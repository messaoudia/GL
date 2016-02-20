
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object creerProjet_Scope0 {
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

class creerProjet extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

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

            """),format.raw/*25.13*/("""}"""),format.raw/*25.14*/(""");
    </script>
""")))};def /*29.2*/content/*29.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*29.13*/("""
    """),format.raw/*30.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*31.10*/sidebar("CreerProjet")),format.raw/*31.32*/("""

        """),format.raw/*33.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">
            """),_display_(/*34.14*/topbar()),format.raw/*34.22*/("""
            """),format.raw/*35.13*/("""<div id="refresh" >

                <div class="row wrapper border-bottom white-bg page-heading">
                    <div class="col-sm-4">
                        <h2>This is CREER PROJET</h2>
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

                <form id="addProjectForm" class="m-t" role="form" method="POST">

                    <div class="wrapper wrapper-content">
                        <div class="ibox animated fadeInRightBig" style="background-color: #FFF; max-width: 100%;">
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-sm-offset-2 col-sm-8">
                                        <label class="label_form" for="projectResponsible">"""),_display_(/*59.93*/Messages("project")),format.raw/*59.112*/("""</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-offset-2 col-sm-8">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <input placeholder="" class="form-control"/>
                                            </div>
                                            <div class="col-sm-6">"""),_display_(/*68.68*/Messages("priority")),format.raw/*68.88*/("""

                                                """),format.raw/*70.49*/("""<div class="btn-group" style="display: inline-block ;">
                                                    <button class="btn" type="button">1</button>
                                                    <button class="btn btn-active" type="button">2</button>
                                                    <button class="btn" type="button">3</button>

                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label class="label_form" for="projectResponsible">"""),_display_(/*82.105*/Messages("projectPersonResponsible")),format.raw/*82.141*/("""</label>
                                                    <div>
                                                        <select  id="projectResponsible" name="projectResponsible" required="true" style="width:100%;" class="select2_demo_1 form-control">
                                                            <option value="1">Option 1</option>
                                                            <option value="2">Option 2</option>
                                                            <option value="3">Option 3</option>
                                                            <option value="4">Option 4</option>
                                                            <option value="5">Option 5</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-6">
                                                <div class='form-group'>
                                                    <label class="label_form" for="client">"""),_display_(/*97.93*/Messages("client")),format.raw/*97.111*/("""</label>
                                                    <input class="form-control" id="client" name="client" required="true"/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label class="label_form">"""),_display_(/*105.76*/Messages("description")),format.raw/*105.99*/("""</label>
                                            </div>

                                            <div class="col-sm-12">
                                                <textarea style="height: 150px; width:100%;"></textarea>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div type="submit" id="submitButton" class="ibox-footer text-center" style="background-color: #27AE62;color:#FFF;height: 40px;cursor: pointer;">
                                <h3>"""),_display_(/*117.38*/Messages("saveProject")),format.raw/*117.61*/("""</h3>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*27.2*/("""

"""),format.raw/*125.2*/("""

"""),_display_(/*127.2*/main(pageTitle,content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object creerProjet extends creerProjet_Scope0.creerProjet
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/creerProjet.scala.html
                  HASH: 40e3dbdb195e511b373c925d10984286ae76662a
                  MATRIX: 757->1|854->23|868->30|948->34|979->39|1056->89|1084->90|1128->107|1192->144|1220->145|1268->166|1620->490|1649->491|1702->516|1754->540|1783->541|1840->570|1989->691|2018->692|2150->796|2179->797|2236->826|2309->871|2338->872|2387->893|2416->894|2463->913|2492->914|2536->930|2565->931|2606->952|2621->959|2702->963|2734->968|2806->1013|2849->1035|2886->1045|2977->1109|3006->1117|3047->1130|4246->2302|4287->2321|4866->2873|4907->2893|4985->2943|5828->3758|5886->3794|7112->4993|7152->5011|7667->5498|7712->5521|8400->6181|8445->6204|8653->20|8682->949|8712->6373|8742->6376
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|49->19|49->19|50->20|51->21|51->21|52->22|52->22|53->23|53->23|55->25|55->25|57->29|57->29|59->29|60->30|61->31|61->31|63->33|64->34|64->34|65->35|89->59|89->59|98->68|98->68|100->70|112->82|112->82|127->97|127->97|135->105|135->105|147->117|147->117|156->1|158->27|160->125|162->127
                  -- GENERATED --
              */
          