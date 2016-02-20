
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login_Scope0 {
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

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta nom="viewport" content="width=device-width, initial-scale=1.0">

        <title>MyProjects | Login</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body class="gray-bg">
        <!--<div class="middle-box text-center loginscreen animated fadeInDown">-->
        <div class="middle-box text-center loginscreen animated fadeInDown">
            <div style="padding-bottom:23px;">
                <h2>Bienvenue sur myProjects</h2>
            </div>
            <div>
                <p>
                    myProjects, solution de gestion et de suivi de projets
                </p>
                <form class="m-t" role="form" method="POST" action=""""),_display_(/*30.70*/routes/*30.76*/.Login.authenticate()),format.raw/*30.97*/("""">
                    """),_display_(/*31.22*/if(form.hasGlobalErrors)/*31.46*/ {_display_(Seq[Any](format.raw/*31.48*/("""
                        """),format.raw/*32.25*/("""<p class="error">
                        """),_display_(/*33.26*/form/*33.30*/.globalError.message),format.raw/*33.50*/("""
                        """),format.raw/*34.25*/("""</p>
                    """)))}),format.raw/*35.22*/("""

                    """),_display_(/*37.22*/if(flash.contains("success"))/*37.51*/ {_display_(Seq[Any](format.raw/*37.53*/("""
                        """),format.raw/*38.25*/("""<p class="success">
                        """),_display_(/*39.26*/flash/*39.31*/.get("success")),format.raw/*39.46*/("""
                        """),format.raw/*40.25*/("""</p>
                    """)))}),format.raw/*41.22*/("""
                """),format.raw/*42.17*/("""<div class="form-group">
                    <input name="email" type="email" class="form-control" placeholder="Login" required="" value=""""),_display_(/*43.115*/form("email")/*43.128*/.value),format.raw/*43.134*/("""">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="Password" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Connexion</button>
                <a href="#"><small>Mot de passe oublié?</small></a>
                </form>

                <p class="m-t"> <small>Pear Corporation &copy; 2016</small> </p>
            </div>
        </div>

            <!-- Mainly scripts -->
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
"""))
      }
    }
  }

  def render(form:Form[User]): play.twirl.api.HtmlFormat.Appendable = apply(form)

  def f:((Form[User]) => play.twirl.api.HtmlFormat.Appendable) = (form) => apply(form)

  def ref: this.type = this

}


}

/**/
object login extends login_Scope0.login
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/login.scala.html
                  HASH: f9a0667ee08fb2227dd373fefa0518f4490147d2
                  MATRIX: 749->1|862->19|890->21|1898->1002|1913->1008|1955->1029|2007->1054|2040->1078|2080->1080|2134->1106|2205->1150|2218->1154|2259->1174|2313->1200|2371->1227|2423->1252|2461->1281|2501->1283|2555->1309|2628->1355|2642->1360|2678->1375|2732->1401|2790->1428|2836->1446|3004->1586|3027->1599|3055->1605
                  LINES: 27->1|32->1|33->2|61->30|61->30|61->30|62->31|62->31|62->31|63->32|64->33|64->33|64->33|65->34|66->35|68->37|68->37|68->37|69->38|70->39|70->39|70->39|71->40|72->41|73->42|74->43|74->43|74->43
                  -- GENERATED --
              */
          