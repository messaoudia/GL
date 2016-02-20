
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object client_Scope0 {
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

class client extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageTitle: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/scripts/*3.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
    """),format.raw/*4.5*/("""<script>
            $(document).ready(function() """),format.raw/*5.42*/("""{"""),format.raw/*5.43*/("""
                """),format.raw/*6.17*/("""$('.liclickable').click(function (e) """),format.raw/*6.54*/("""{"""),format.raw/*6.55*/("""
                    """),format.raw/*7.21*/("""e.preventDefault();
                    var self = $(this),
                            controler = self.data('infos') || self.attr('data-infos');
                    $('#sidebar ul li').removeClass('active');
                    $(this).addClass('active');

                    eval("jsRoutes.controllers."+controler).ajax("""),format.raw/*13.66*/("""{"""),format.raw/*13.67*/("""
                        """),format.raw/*14.25*/("""success: function(html) """),format.raw/*14.49*/("""{"""),format.raw/*14.50*/("""
                            """),format.raw/*15.29*/("""var result = $('#refresh',html);
                            $('#refresh').empty().html(result);
                        """),format.raw/*17.25*/("""}"""),format.raw/*17.26*/(""",
                        //Case we have a problem
                        error: function(errorMessage)"""),format.raw/*19.54*/("""{"""),format.raw/*19.55*/("""
                            """),format.raw/*20.29*/("""alert(errorMessage);
                        """),format.raw/*21.25*/("""}"""),format.raw/*21.26*/("""
                    """),format.raw/*22.21*/("""}"""),format.raw/*22.22*/(""");
                """),format.raw/*23.17*/("""}"""),format.raw/*23.18*/(""");

                $("body").load(function()"""),format.raw/*25.42*/("""{"""),format.raw/*25.43*/("""
                    """),format.raw/*26.21*/("""updateMenu();
                """),format.raw/*27.17*/("""}"""),format.raw/*27.18*/(""");

                function updateMenu()
                """),format.raw/*30.17*/("""{"""),format.raw/*30.18*/("""
                    """),format.raw/*31.21*/("""var navHeader = document.getElementById('nav-header-admin');
                    $(navHeader).addClass('nav-header');
                    $('.navbar').css("cssText", "background-color : #1AB394 !important;border-color : #1AB394 !important; transition: none;");
                    $('.pear-theme').css("cssText", "background-color : #1AB394 !important;border-color : #1AB394 !important;");
                """),format.raw/*35.17*/("""}"""),format.raw/*35.18*/("""
                """),format.raw/*36.17*/("""updateMenu();

            """),format.raw/*38.13*/("""}"""),format.raw/*38.14*/(""");
    </script>
""")))};def /*42.2*/content/*42.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*42.13*/("""
    """),format.raw/*43.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*44.10*/sidebar("Client")),format.raw/*44.27*/("""

        """),format.raw/*46.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">
            """),_display_(/*47.14*/topbar()),format.raw/*47.22*/("""
            """),format.raw/*48.13*/("""<div id="refresh" >

                <div class="row wrapper border-bottom white-bg page-heading">
                    <div class="col-sm-4">
                        <h2>This is CLIENT</h2>
                        <ol class="breadcrumb">
                            <li>
                                <a href="http://webapplayers.com/inspinia_admin-v2.4/index.html">This is</a>
                            </li>
                            <li class="active">
                                <strong>Breadcrumb</strong>
                            </li>
                        </ol>
                    </div>

                </div>

                <div class="wrapper wrapper-content">
                    <div class="middle-box text-center animated fadeInRightBig">
                        <h3 class="font-bold">This is page content</h3>
                        <div class="error-desc">
                            You can create here any grid layout you want. And any variation layout you imagine:) Check out
                            main dashboard and other site. It use many different layout.
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*40.2*/("""

"""),format.raw/*79.2*/("""

"""),_display_(/*81.2*/main(pageTitle,content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object client extends client_Scope0.client
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/client.scala.html
                  HASH: 370f8c7984920966cbf55a491cead384ce719df3
                  MATRIX: 747->1|844->23|858->30|938->34|969->39|1046->89|1074->90|1118->107|1182->144|1210->145|1258->166|1610->490|1639->491|1692->516|1744->540|1773->541|1830->570|1979->691|2008->692|2140->796|2169->797|2226->826|2299->871|2328->872|2377->893|2406->894|2453->913|2482->914|2555->959|2584->960|2633->981|2691->1011|2720->1012|2806->1070|2835->1071|2884->1092|3318->1498|3347->1499|3392->1516|3447->1543|3476->1544|3517->1565|3532->1572|3613->1576|3645->1581|3717->1626|3755->1643|3792->1653|3883->1717|3912->1725|3953->1738|5227->20|5256->1562|5285->2973|5314->2976
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|49->19|49->19|50->20|51->21|51->21|52->22|52->22|53->23|53->23|55->25|55->25|56->26|57->27|57->27|60->30|60->30|61->31|65->35|65->35|66->36|68->38|68->38|70->42|70->42|72->42|73->43|74->44|74->44|76->46|77->47|77->47|78->48|110->1|112->40|114->79|116->81
                  -- GENERATED --
              */
          