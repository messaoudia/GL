package controllers.Global;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class StringEnvelope {

    private static final String HASH = "SHA-256";
    private static final String HMAC = "HmacSHA256";
    private static final String CIPHER = "AES";
    private static final String ENCRYPTION = CIPHER + "/CBC/PKCS5Padding";
    private static final SecureRandom secureRandom = new SecureRandom();

    /*
     Returns parameters of the cryptographic engine currently used by StringEnvelope.

     @return configuration string
     */
    public static String getInfo() {
        return "Encryption=" + ENCRYPTION + " MAC=" + HMAC + " Key derivation hash=" + HASH;
    }

    /*
    Time-constant string comparison. Prevents padding oracle attacks.

    @param stringA, string B

    @return boolean
     */
    private static boolean isEqual(byte[] a, byte[] b) {
        if (a == null || b == null)
            return false;

        if (a.length != b.length) {
            return false;
        }

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];
        }
        return result == 0;
    }

    /*
    Derive encryption key from user-supplied key string and purpose string. The purpose string
    only use is to ensure different binary keys are used for different purposes.

    @param purpose
        purpose string

    @param key
        key string

    @return secret key
        SecretKeySpec structure

    @throws NoSuchAlgorithmException
        when encryption algorithm configured in StringEnvelope is not available

    @throws NoSuchPaddingException
        when padding algorithm configured in StringEnvelope is not available

    @throws UnsupportedEncodingException
        when strings passed to this method are not encoded in valid UTF-8
     */
    private static SecretKeySpec deriveKey(String purpose, String key)
            throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException {

        MessageDigest md = MessageDigest.getInstance(HASH);

        md.update(purpose.getBytes("UTF-8"));
        byte[] hash = md.digest(key.getBytes("UTF-8"));

        return new SecretKeySpec(Arrays.copyOfRange(hash, 0,
                Cipher.getInstance(CIPHER).getBlockSize()), CIPHER);
    }

    private static byte[] deriveIv()
    throws NoSuchPaddingException, NoSuchAlgorithmException {
        byte[] iv = new byte[Cipher.getInstance(ENCRYPTION).getBlockSize()];
        secureRandom.nextBytes(iv);
        return iv;
    }

    /*
    Wrap user supplied string in encrypted and authenticated envelope. All strings may be UTF-8 encoded.

    @param plaintext
        user supplied string

    @param key
        user supplied secret key

    @return ciphertext
        BASE64 encoded envelope
     */
    public static String wrap(String plaintext, String key)
    throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, UnsupportedEncodingException {

        // derive two separate sub-keys for encryption and MAC from the supplied string key
        SecretKeySpec macKeySpec = deriveKey("hmac", key);
        SecretKeySpec encKeySpec = deriveKey("encryption", key);

        // prepare to encrypt plaintext
        Cipher cipher = Cipher.getInstance(ENCRYPTION);
        // generate random IV
        IvParameterSpec ivSpec = new IvParameterSpec(deriveIv());
        // initialize cipher with the encryption key and IV
        cipher.init(Cipher.ENCRYPT_MODE, encKeySpec, ivSpec);
        // actually encrypt
        byte[] rawEncrypted = cipher.doFinal(plaintext.getBytes("UTF-8"));

        // calculate HMAC over raw encrypted data and IV
        Mac mac = Mac.getInstance(HMAC);
        // use the MAC key (separate from encryption key)
        mac.init(macKeySpec);
        // calculate MAC over IV
        mac.update(ivSpec.getIV());
        // calculate MAC over ciphertext
        byte[] rawHmac = mac.doFinal(rawEncrypted);

        // BASE64 encode everything
        String strIv = Base64.encode(ivSpec.getIV());
        String strMac = Base64.encode(rawHmac);
        String strEncrypted = Base64.encode(rawEncrypted);

        return strIv + "-" + strMac + "-" + strEncrypted;
    }

    /*
    Unwrap the encrypted and authenticated envelope, failing if the envelope was tampered with.

    @param envelope
        BASE64 encrypted envelope

    @param key
        decryption key

    @return string
        decrypted plaintext
     */
    public static String unwrap(String envelope, String key)
            throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, BadPaddingException,
            IllegalBlockSizeException, InvalidAlgorithmParameterException, UnsupportedEncodingException
     {
        if (!envelope.contains("-"))
            throw new IllegalArgumentException("Malformed envelope: no dash");

        // split into ciphertext and MAC
        String[] parts = envelope.split("-");

        if (parts.length != 3)
            throw new IllegalArgumentException("Malformed envelope: no three dashes");

        String strIv = parts[0];
        String strMac = parts[1];
        String strEncrypted = parts[2];

        byte[] rawIv = Base64.decode(strIv);
        if (rawIv == null)
            throw new IllegalArgumentException("Malformed IV");

        byte[] rawEncrypted = Base64.decode(strEncrypted);
        if (rawIv == null)
            throw new IllegalArgumentException("Malformed ciphertext");

        byte[] rawMac = Base64.decode(strMac); // received MAC
        if (rawIv == null)
            throw new IllegalArgumentException("Malformed MAC");

        // derive two separate sub-keys for encryption and MAC from the supplied string key
        SecretKeySpec macKeySpec = deriveKey("hmac", key);
        SecretKeySpec encKeySpec = deriveKey("encryption", key);

        // validate MAC
        Mac mac = Mac.getInstance(HMAC);
        mac.init(macKeySpec);
        mac.update(rawIv);

        byte[] rawRecvMac; // MAC of received cryptogram
        rawRecvMac = mac.doFinal(rawEncrypted);

        if (!isEqual(rawMac, rawRecvMac))
            throw new IllegalArgumentException("Encrypted data MAC does not match");

        // decrypt authentic data
        IvParameterSpec ivSpec = new IvParameterSpec(rawIv);
        Cipher cipher = Cipher.getInstance(ENCRYPTION);
        cipher.init(Cipher.DECRYPT_MODE, encKeySpec, ivSpec);
        byte[] decrypted = cipher.doFinal(rawEncrypted);

        return new String(decrypted, "UTF8");

    }

    private static final String[][] testVectors = {
            // JCE - algo, iv, plaintext, expected result (key is fixed)
            // these vectors were verified against a PyCrypto implementation
            {"AES/CBC/PKCS5Padding", "0123456789abcdef", "plaintext", "yDNCsm8mWNJlNWB50MMIAg=="},
            {"AES/CBC/PKCS5Padding", "aaaaaaaaaaaaaaaa", "plaintext", "uoG/KJF8TXOzVvNL/Yh2Sg=="},
            {"AES/CBC/PKCS5Padding", "0000000000000000", "комплекс карательных мер, проводившихся большевиками в ходе Гражданской войны", "MWHOOU/fqy4ds9iMskJbKyZU6EsNweJlMh1roZz6jHFtTaoMYeS5tw13o9fAWvCF+MmVIxMuoHJqOw7YYrG13iEsI6aK5ziUbpn6530ei2DYefyWr4meWDy5Be36sq6JVEfPO+jm+XFhLgl4pLHTCN1T5HZZFLfFyG/y/GCxYR9878quZo3CrvxE9aQVmRcQX98S1iCUTgGlsIXjxydeyQ=="},
            // deriveKey() should return deterministic results
            {"deriveKey", "test key 1", "", "QtzGfMLFHf+iAbNAq0iAuQ=="},
            {"deriveKey", "test key 2", "", "Uc10OVlLnyx/q15eyQL64w=="},
            {"deriveKey", "test key ąćęłńóśżź", "", "JTfvXe9hs1ER+VdLN8cMcQ=="},
            // derive() output will be each time different, so we check length
            {"deriveIv", "", "", "16"},
            // wrap() output will be each time different so we check length
            {"wrap", "test key", "test input", "94"},
            {"wrap", "ąćęłńóśżź", "ąćęłńóśżź", "114"},
            {"wrap", "Poćmękłanobzdrężyłłopaćpolerta", "комплекс карательных мер, проводившихся большевиками в ходе Гражданской войны", "134"},
            // unwrap test will replace expect with the original plaintext
            {"unwrap", "test key", "test input", "plaintext"},
            {"unwrap", "ąćęłńóśżź", "ąćęłńóśżź", "plaintext"},
            {"unwrap", "Poćmękłanobzdrężyłłopaćpolerta", "комплекс карательных мер, проводившихся большевиками в ходе Гражданской войны", "plaintext"},
    };

    /*
    Perform basic self-tests on the cryptographic engine.

    @return boolean
        should be always true, do not use if false
     */
    public static boolean selfTest()
            throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        int fails = 0;
        int i = 0;


        for (i = 0; i < testVectors.length; i++) {
            String[] vector = testVectors[i];
            String function = vector[0];
            String input1 = vector[1];
            String input2 = vector[2];
            String expect = vector[3];
            String actual = "";

            if (function.equals("AES/CBC/PKCS5Padding")) {
                byte[] rawIv = input1.getBytes();
                byte[] rawPlaintext = input2.getBytes();
                byte[] rawKey = "0123456789abcdef".getBytes();

                // prepare  key and IV
                SecretKeySpec encKeySpec = new SecretKeySpec(rawKey, "AES");
                IvParameterSpec ivSpec = new IvParameterSpec(rawIv);

                // init cipher
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, encKeySpec, ivSpec);
                // encrypt
                byte[] ciphertext = cipher.doFinal(rawPlaintext);
                actual = Base64.encode(ciphertext);

            }
            if (function.equals("deriveKey")) {
                final String purpose = "self test";
                SecretKeySpec secretKeySpec = deriveKey(purpose, input1);
                actual = Base64.encode(secretKeySpec.getEncoded());
            }
            if (function.equals("deriveIv")) {
                byte[] iv = deriveIv();
                actual = Integer.toString(iv.length);
            }
            if (function.equals("wrap")) {
                String key = input2;
                String plaintext = input1;
                actual = Integer.toString(wrap(plaintext, key).length());
            }
            if (function.equals("unwrap")) {
                String key = input2;
                String plaintext = input1;
                expect = plaintext;
                actual = unwrap(wrap(plaintext, key), key);
            }

            // check if  result was what was expected
            if (!actual.equals(expect))
                fails++;
        }

        // deriveIv() - each should be unique
        for (i = 0; i < 10; i++) {
            String buf, newbuf;

            buf = wrap("plaintext", "key");
            newbuf = wrap("plaintext", "key");

            if (buf.equals(newbuf)) {
                fails++;
            }

        }

        // wrap() - each should be unique
        for (i = 0; i < 10; i++) {
            byte[] buf, newbuf;

            buf = deriveIv();
            newbuf = deriveIv();

            if (buf.equals(newbuf)) {
                fails++;
            }

        }

        // unwrap() - continous integrity test
        for (i = 0; i < 200; i++) {
            byte[] ciphertext = wrap("plaintext", "key").getBytes();
            // modify ciphertext at random offset (can be inIV, MAC or ciphertext)
            int index = secureRandom.nextInt(ciphertext.length);
            ciphertext[index] ^= 1;
            try {
                String hacked = new String(ciphertext, "UTF8");
                unwrap(hacked, "key");
                fails++;
            } catch (IllegalArgumentException e) {
            }
        }

        // end of tests
        return fails == 0;
    }
}
