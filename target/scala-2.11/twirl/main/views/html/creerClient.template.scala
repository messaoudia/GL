
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object creerClient_Scope0 {
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

class creerClient extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

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


            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/(""");
    </script>
""")))};def /*30.2*/content/*30.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*30.13*/("""
    """),format.raw/*31.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*32.10*/sidebar("CreerClient")),format.raw/*32.32*/("""

        """),format.raw/*34.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">
            """),_display_(/*35.14*/topbar()),format.raw/*35.22*/("""
            """),format.raw/*36.13*/("""<div id="refresh" >
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-6 b-r">
                            <form class="form-horizontal" id="creerClientForm">
                                <div class="row form-group">
                                    <label class="col-sm-5 control-label" for="formCreerClientName">"""),_display_(/*42.102*/Messages("formClientName")),format.raw/*42.128*/("""</label>
                                    <div class="col-sm-7"><input type="text" id="formCreerClientName" class="form-control"></div>
                                </div>
                                <div class="row form-group">
                                    <label class="col-sm-5 control-label" for="formCreerClientAdress">"""),_display_(/*46.104*/Messages("adress")),format.raw/*46.122*/("""</label>
                                    <div class="col-sm-7"><input type="text" id="formCreerClientAdress" class="form-control"></div>
                                </div>
                                <div class="row form-group">
                                    <label class="col-sm-5 control-label" for="formCreerClientZipCode">"""),_display_(/*50.105*/Messages("formZipCode")),format.raw/*50.128*/("""</label>
                                    <div class="col-sm-7"><input type="text" id="formCreerClientZipCode" class="form-control"></div>
                                </div>
                                <div class="row form-group">
                                    <label class="col-sm-5 control-label" for="formCreerClientCity">"""),_display_(/*54.102*/Messages("formCity")),format.raw/*54.122*/("""</label>
                                    <div class="col-sm-7"><input type="text" id="formCreerClientCity" class="form-control"></div>
                                </div>

                                <div class="row form-group">
                                    <label class="col-sm-5 control-label" for="formCreerClientCountry">"""),_display_(/*59.105*/Messages("formCountry")),format.raw/*59.128*/("""</label>
                                    <div class="col-sm-7"><input type="text" id="formCreerClientCountry" class="form-control"></div>
                                </div>

                                <div class="row form-group">
                                    <label class="col-sm-5 control-label">"""),_display_(/*64.76*/Messages("priority")),format.raw/*64.96*/("""</label>
                                    <div class="col-sm-7">
                                        <div class="radio radio-inline radio-danger">
                                            <input type="radio" id="inlineRadio1CreerClient" value="option1" name="radioInline" checked="">
                                            <label for="inlineRadio1CreerClient">1</label>
                                        </div>
                                        <div class="radio radio-inline radio-danger">
                                            <input type="radio" id="inlineRadio2CreerClient" value="option2" name="radioInline">
                                            <label for="inlineRadio2CreerClient">2</label>
                                        </div>
                                        <div class="radio radio-inline radio-danger">
                                            <input type="radio" id="inlineRadio3CreerClient" value="option3" name="radioInline">
                                            <label for="inlineRadio3CreerClient">3</label>
                                        </div>

                                    </div>
                                </div>

                            </form>
                        </div>

                        <div class="col-sm-6">
                            <div class="div-center">
                                <h3 class="inline">"""),_display_(/*87.53*/Messages("addContact")),format.raw/*87.75*/("""</h3>
                                <form class="form-horizontal" id="contactFormCreerClient">
                                    <div class="row form-group">
                                        <label class="col-sm-5 control-label" for="formLastNameCreerClient">"""),_display_(/*90.110*/Messages("formLastName")),format.raw/*90.134*/("""</label>
                                        <div class="col-sm-7"><input type="text" id="formLastNameCreerClient" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <label class="col-sm-5 control-label" for="formFirstNameCreerClient">"""),_display_(/*94.111*/Messages("formFirstName")),format.raw/*94.136*/("""</label>
                                        <div class="col-sm-7"><input type="text" id="formFirstNameCreerClient" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <label class="col-sm-5 control-label" for="formEmailCreerClient">"""),_display_(/*98.107*/Messages("formEmail")),format.raw/*98.128*/("""</label>
                                        <div class="col-sm-7"><input type="text" id="formEmailCreerClient" class="form-control"></div>
                                    </div>
                                    <div class="row form-group">
                                        <label class="col-sm-5 control-label" for="formTelCreerClient" >"""),_display_(/*102.106*/Messages("formTel")),format.raw/*102.125*/("""</label>
                                        <div class="col-sm-7"><input type="text" id="formTelCreerClient" class="form-control"></div>
                                    </div>
                                </form>
                                <button class="btn btn-primary inline" type="submit" form="contactFormCreerClient">
                                    <i class="fa fa-plus-square"></i>  """),_display_(/*107.73*/Messages("add")),format.raw/*107.88*/("""
                                """),format.raw/*108.33*/("""</button>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="display:none;">
                        <div class="col-sm-offset-3 col-sm-6">
                            <h3 style="text-align:center;">"""),_display_(/*114.61*/Messages("contacts")),format.raw/*114.81*/("""</h3>
                            <div class="list-modif-client">
                                <table class="table-bordered">
                                    <tbody>
                                        <tr>
                                            <td class="first-td">Contact 1</td>
                                            <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                        </tr>
                                        <tr>
                                            <td class="first-td">Contact 1</td>
                                            <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                        </tr>
                                        <tr>
                                            <td class="first-td">Contact 1</td>
                                            <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                        </tr>
                                        <tr>
                                            <td class="first-td">Contact 1</td>
                                            <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-top:15px;">
                        <div class="div-center">
                                <!--TODO modalview Valider (check contacts & projet & champs -->
                            <button class="btn btn-primary" type="submit" form="clientFormCreerClient">
                                <i class="fa fa-check-square"></i> """),_display_(/*143.69*/Messages("validate")),format.raw/*143.89*/("""
                            """),format.raw/*144.29*/("""</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*28.2*/("""

"""),format.raw/*151.2*/("""

"""),_display_(/*153.2*/main(pageTitle,content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object creerClient extends creerClient_Scope0.creerClient
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:14 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/creerClient.scala.html
                  HASH: 4078657c9d832440a5a27bd5492931326909b1ae
                  MATRIX: 757->1|854->23|868->30|948->34|979->39|1056->89|1084->90|1128->107|1192->144|1220->145|1268->166|1620->490|1649->491|1702->516|1754->540|1783->541|1840->570|1989->691|2018->692|2150->796|2179->797|2236->826|2309->871|2338->872|2387->893|2416->894|2463->913|2492->914|2537->931|2566->932|2607->953|2622->960|2703->964|2735->969|2807->1014|2850->1036|2887->1046|2978->1110|3007->1118|3048->1131|3470->1525|3518->1551|3888->1893|3928->1911|4301->2256|4346->2279|4717->2622|4759->2642|5131->2986|5176->3009|5521->3327|5562->3347|7031->4789|7074->4811|7373->5082|7419->5106|7812->5471|7859->5496|8249->5858|8292->5879|8678->6236|8720->6255|9161->6668|9198->6683|9260->6716|9574->7002|9616->7022|11593->8971|11635->8991|11693->9020|11869->20|11898->950|11928->9157|11958->9160
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|49->19|49->19|50->20|51->21|51->21|52->22|52->22|53->23|53->23|56->26|56->26|58->30|58->30|60->30|61->31|62->32|62->32|64->34|65->35|65->35|66->36|72->42|72->42|76->46|76->46|80->50|80->50|84->54|84->54|89->59|89->59|94->64|94->64|117->87|117->87|120->90|120->90|124->94|124->94|128->98|128->98|132->102|132->102|137->107|137->107|138->108|144->114|144->114|173->143|173->143|174->144|182->1|184->28|186->151|188->153
                  -- GENERATED --
              */
          