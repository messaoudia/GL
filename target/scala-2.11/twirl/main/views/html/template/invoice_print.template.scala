
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object invoice_print_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class invoice_print extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Invoice Print</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="white-bg">
                <div class="wrapper wrapper-content p-xl">
                    <div class="ibox-content p-xl">
                            <div class="row">
                                <div class="col-sm-6">
                                    <h5>From:</h5>
                                    <address>
                                        <strong>Inspinia, Inc.</strong><br>
                                        106 Jorg Avenu, 600/10<br>
                                        Chicago, VT 32456<br>
                                        <abbr title="Phone">P:</abbr> (123) 601-4590
                                    </address>
                                </div>

                                <div class="col-sm-6 text-right">
                                    <h4>Invoice No.</h4>
                                    <h4 class="text-navy">INV-000567F7-00</h4>
                                    <span>To:</span>
                                    <address>
                                        <strong>Corporate, Inc.</strong><br>
                                        112 Street Avenu, 1080<br>
                                        Miami, CT 445611<br>
                                        <abbr title="Phone">P:</abbr> (120) 9000-4321
                                    </address>
                                    <p>
                                        <span><strong>Invoice Date:</strong> Marh 18, 2014</span><br/>
                                        <span><strong>Due Date:</strong> March 24, 2014</span>
                                    </p>
                                </div>
                            </div>

                            <div class="table-responsive m-t">
                                <table class="table invoice-table">
                                    <thead>
                                    <tr>
                                        <th>Item List</th>
                                        <th>Quantity</th>
                                        <th>Unit Price</th>
                                        <th>Tax</th>
                                        <th>Total Price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><div><strong>Admin Theme with psd project layouts</strong></div>
                                            <small>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</small></td>
                                        <td>1</td>
                                        <td>$26.00</td>
                                        <td>$5.98</td>
                                        <td>$31,98</td>
                                    </tr>
                                    <tr>
                                        <td><div><strong>Wodpress Them customization</strong></div>
                                            <small>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                                Eiusmod tempor incididunt ut labore et dolore magna aliqua.
                                            </small></td>
                                        <td>2</td>
                                        <td>$80.00</td>
                                        <td>$36.80</td>
                                        <td>$196.80</td>
                                    </tr>
                                    <tr>
                                        <td><div><strong>Angular JS & Node JS Application</strong></div>
                                            <small>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</small></td>
                                        <td>3</td>
                                        <td>$420.00</td>
                                        <td>$193.20</td>
                                        <td>$1033.20</td>
                                    </tr>

                                    </tbody>
                                </table>
                            </div><!-- /table-responsive -->

                            <table class="table invoice-total">
                                <tbody>
                                <tr>
                                    <td><strong>Sub Total :</strong></td>
                                    <td>$1026.00</td>
                                </tr>
                                <tr>
                                    <td><strong>TAX :</strong></td>
                                    <td>$235.98</td>
                                </tr>
                                <tr>
                                    <td><strong>TOTAL :</strong></td>
                                    <td>$1261.98</td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="well m-t"><strong>Comments</strong>
                                It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less
                            </div>
                        </div>

    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>

    <script type="text/javascript">
        window.print();
    </script>

</body>

</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object invoice_print extends invoice_print_Scope0.invoice_print
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:19 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/invoice_print.scala.html
                  HASH: 602ce21c5285a50754d001dd4ba17c3bb47df12c
                  MATRIX: 852->0
                  LINES: 32->1
                  -- GENERATED --
              */
          