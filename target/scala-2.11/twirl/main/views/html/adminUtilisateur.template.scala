
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminUtilisateur_Scope0 {
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

class adminUtilisateur extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

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
                    """),format.raw/*31.21*/("""var navHeader = document.getElementById('nav-header');
                    $(navHeader).addClass('nav-header-admin');
                    $('.navbar').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important; transition: none;");
                    $('.pear-theme').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important;");
                """),format.raw/*35.17*/("""}"""),format.raw/*35.18*/("""
                """),format.raw/*36.17*/("""updateMenu();
            """),format.raw/*37.13*/("""}"""),format.raw/*37.14*/(""");
    </script>
""")))};def /*41.2*/content/*41.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*41.13*/("""
    """),format.raw/*42.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*43.10*/sidebar("UtilisateurAdmin")),format.raw/*43.37*/("""

        """),format.raw/*45.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">
            """),_display_(/*46.14*/topbar()),format.raw/*46.22*/("""
            """),format.raw/*47.13*/("""<div id="refresh" >
                <div class="ibox-content">
                    <div class="row row-options-admin-user">
                        <div class="col-sm-3">
                            <div class="checkbox checkbox-danger checkbox-circle">
                                <input id="checkboxUsersArchived" class="styled" type="checkbox">
                                <label for="checkboxUsersArchived"> """),_display_(/*53.70*/Messages("showArchivedUsers")),format.raw/*53.99*/(""" """),format.raw/*53.100*/("""</label>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive table-responsive-admin-user">
                        <table id="dataTables-admin-user" class="table table-striped table-bordered table-hover" >
                            <thead>
                                <tr>
                                    <th>"""),_display_(/*62.42*/Messages("formLastName")),format.raw/*62.66*/("""</th>
                                    <th>"""),_display_(/*63.42*/Messages("formFirstName")),format.raw/*63.67*/("""</th>
                                    <th>"""),_display_(/*64.42*/Messages("formEmail")),format.raw/*64.63*/("""</th>
                                    <th>"""),_display_(/*65.42*/Messages("formTel")),format.raw/*65.61*/("""</th>
                                    <th>"""),_display_(/*66.42*/Messages("currentProjects")),format.raw/*66.69*/("""</th>
                                    <th>"""),_display_(/*67.42*/Messages("currentTasks")),format.raw/*67.66*/("""</th>
                                    <th>"""),_display_(/*68.42*/Messages("archived")),format.raw/*68.62*/("""</th>
                                    <th><i class="fa fa-trash"></i></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Rabi</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Yasser</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">yasser.rabi&commat;u-psud.fr</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">0123456789</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">25</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">7</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Oui</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-user"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Heng</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Daro</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">daro.heng&commat;u-psud.fr</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">0123456788</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">7</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">3</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Non</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-user"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Zheng</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Zhang</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">zz&commat;u-psud.fr</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">09876554321</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">12</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">12</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-user">Oui</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-user"><i class="fa fa-times"></i></td>
                                </tr>
                            </tbody>
                        </table>

                        <div class="modal fade" id="modal-modif-user" role="dialog">
                            <div class="modal-dialog">
                                <div class="ibox-title background_admin div-center">
                                    <h5 class="text-white inline">"""),_display_(/*109.68*/Messages("setUser")),format.raw/*109.87*/("""</h5>
                                    <div class="ibox-tools">
                                        <button type="button" class="close" data-dismiss="modal">
                                            <i class="fa fa-times"/>
                                        </button>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <form class="form-horizontal" id="userForm">
                                        <div class="row form-group form-group-user">
                                            <label class="control-label" for="formLastName">"""),_display_(/*119.94*/Messages("formLastName")),format.raw/*119.118*/("""</label>
                                            <div><input type="text" id="formLastName" class="form-control"></div>
                                        </div>
                                        <div class="row form-group form-group-user">
                                            <label class="control-label" for="formFirstName">"""),_display_(/*123.95*/Messages("formFirstName")),format.raw/*123.120*/("""</label>
                                            <div><input type="text" id="formFirstName" class="form-control"></div>
                                        </div>
                                        <div class="row form-group form-group-user">
                                            <label class="control-label" for="formEmail">"""),_display_(/*127.91*/Messages("formEmail")),format.raw/*127.112*/("""</label>
                                            <div><input type="text" id="formEmail" class="form-control"></div>
                                        </div>
                                        <div class="row form-group form-group-user">
                                            <label class="control-label" for="formTel">"""),_display_(/*131.89*/Messages("formTel")),format.raw/*131.108*/("""</label>
                                            <div><input type="text" id="formTel" class="form-control"></div>
                                        </div>

                                        <div class="row form-group form-group-user">
                                            <label class="col-sm-5 control-label">"""),_display_(/*136.84*/Messages("administrator")),format.raw/*136.109*/("""</label>
                                            <div class="col-sm-7">
                                                <div class="radio radio-inline radio-danger">
                                                    <input type="radio" id="inlineRadioAdminOui" value="option1" name="radioInlineAdmin" checked="">
                                                    <label for="inlineRadioAdminOui">Oui</label>
                                                </div>
                                                <div class="radio radio-inline radio-danger">
                                                    <input type="radio" id="inlineRadioAdminNon" value="option2" name="radioInlineAdmin">
                                                    <label for="inlineRadioAdminNon">Non</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" style="margin-top:15px;">
                                            <div class="div-center">
                                                    <!--TODO modalview Valider (check contacts & projet & champs -->
                                                <button class="btn btn-admin" type="submit" form="userForm">
                                                    <i class="fa fa-check-square"></i> """),_display_(/*152.89*/Messages("validate")),format.raw/*152.109*/("""
                                                """),format.raw/*153.49*/("""</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="modal fade" id="modal-suppr-user" role="dialog">
                            <div class="modal-dialog modal-lg">
                                <div class="ibox-title background_admin div-center">
                                    <h5 class="text-white inline">"""),_display_(/*164.68*/Messages("removeUser")),format.raw/*164.90*/("""</h5>
                                    <div class="ibox-tools">
                                        <button type="button" class="close" data-dismiss="modal">
                                            <i class="fa fa-times"/>
                                        </button>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <form class="form-horizontal" id="removeUserForm">
                                        <div class="row div-center">
                                            <h3>"""),_display_(/*174.50*/Messages("deletingOf")),format.raw/*174.72*/(""" """),format.raw/*174.73*/(""": Yasser Rabi (yasser.rabi&commat;u-psud.fr)</h3>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <p>"""),_display_(/*178.53*/Messages("projectManagerChange")),format.raw/*178.85*/(""" """),format.raw/*178.86*/(""":</p>
                                                <div class="table-responsive">
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>"""),_display_(/*183.70*/Messages("project")),format.raw/*183.89*/("""</th>
                                                                <th>"""),_display_(/*184.70*/Messages("newPersonResponsible")),format.raw/*184.102*/("""</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody class="table-suppr-user">
                                                            <tr>
                                                                <td>Projet 1</td>
                                                                <td>
                                                                    <select class="form-control select2-respo-tache" style="width:100%;" multiple="multiple">
                                                                        <option value="Mayotte">Mayotte</option>
                                                                        <option value="Mexico">Mexico</option>
                                                                        <option value="Nicaragua">Nicaragua</option>
                                                                    </select>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <!-- TODO : clé traduction -->
                                                <p>Changement du responsable d'une tâche :</p>
                                                <div class="table-responsive">
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>"""),_display_(/*209.70*/Messages("task")),format.raw/*209.86*/("""</th>
                                                                <th>"""),_display_(/*210.70*/Messages("project")),format.raw/*210.89*/("""</th>
                                                                <th>"""),_display_(/*211.70*/Messages("newPersonResponsible")),format.raw/*211.102*/("""</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody class="table-suppr-user">
                                                            <tr>
                                                                <td>Créer la base de données</td>
                                                                <td>Projet 1</td>
                                                                <td>
                                                                    <select class="form-control select2-respo-projet" style="width:100%;" multiple="multiple">
                                                                        <option value="Mayotte">Mayotte</option>
                                                                        <option value="Mexico">Mexico</option>
                                                                        <option value="Nicaragua">Nicaragua</option>
                                                                    </select>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" style="margin-top:15px;">
                                            <div class="div-center">
                                                    <!--TODO modalview Valider (check contacts & projet & champs -->
                                                <button class="btn btn-admin" type="submit" form="removeUserForm">
                                                    <i class="fa fa-check-square"></i> """),_display_(/*235.89*/Messages("validate")),format.raw/*235.109*/("""
                                                """),format.raw/*236.49*/("""</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <button type="button" class="btn btn-w-m btn-primary" style="position: fixed; bottom: 0; width:100%; margin-left:-15px; padding-left:0px;padding-right:0px;" data-toggle="modal" data-target="#modal-add-user">"""),_display_(/*246.225*/Messages("addUser")),format.raw/*246.244*/("""</button>
                <div class="modal fade" id="modal-add-user" role="dialog">
                    <div class="modal-dialog">
                        <div class="ibox-title background_admin div-center">
                            <h5 class="text-white inline">"""),_display_(/*250.60*/Messages("addUser")),format.raw/*250.79*/("""</h5>
                            <div class="ibox-tools">
                                <button type="button" class="close" data-dismiss="modal">
                                    <i class="fa fa-times"/>
                                </button>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <form class="form-horizontal" id="userForm">
                                <div class="row form-group form-group-user">
                                    <label class="control-label" for="formLastName">"""),_display_(/*260.86*/Messages("formLastName")),format.raw/*260.110*/("""</label>
                                    <div><input type="text" id="formLastName" class="form-control"></div>
                                </div>
                                <div class="row form-group form-group-user">
                                    <label class="control-label" for="formFirstName">"""),_display_(/*264.87*/Messages("formFirstName")),format.raw/*264.112*/("""</label>
                                    <div><input type="text" id="formFirstName" class="form-control"></div>
                                </div>
                                <div class="row form-group form-group-user">
                                    <label class="control-label" for="formEmail">"""),_display_(/*268.83*/Messages("formEmail")),format.raw/*268.104*/("""</label>
                                    <div><input type="text" id="formEmail" class="form-control"></div>
                                </div>
                                <div class="row form-group form-group-user">
                                    <label class="control-label" for="formTel">"""),_display_(/*272.81*/Messages("formTel")),format.raw/*272.100*/("""</label>
                                    <div><input type="text" id="formTel" class="form-control"></div>
                                </div>

                                <div class="row form-group form-group-user">
                                    <label class="col-sm-5 control-label">"""),_display_(/*277.76*/Messages("administrator")),format.raw/*277.101*/("""</label>
                                    <div class="col-sm-7">
                                        <div class="radio radio-inline radio-danger">
                                            <input type="radio" id="inlineRadioAdminOui" value="option1" name="radioInlineAdmin" checked="">
                                            <label for="inlineRadioAdminOui">"""),_display_(/*281.79*/Messages("yes")),format.raw/*281.94*/("""</label>
                                        </div>
                                        <div class="radio radio-inline radio-danger">
                                            <input type="radio" id="inlineRadioAdminNon" value="option2" name="radioInlineAdmin">
                                            <label for="inlineRadioAdminNon">"""),_display_(/*285.79*/Messages("no")),format.raw/*285.93*/("""</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row" style="margin-top:15px;">
                                    <div class="div-center">
                                            <!--TODO modalview Valider (check contacts & projet & champs -->
                                        <button class="btn btn-admin" type="submit" form="userForm">
                                            <i class="fa fa-check-square"></i> """),_display_(/*293.81*/Messages("validate")),format.raw/*293.101*/("""
                                        """),format.raw/*294.41*/("""</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*39.2*/("""

"""),format.raw/*304.2*/("""

"""),_display_(/*306.2*/main(pageTitle,content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object adminUtilisateur extends adminUtilisateur_Scope0.adminUtilisateur
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:14 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/adminUtilisateur.scala.html
                  HASH: d081f3d400cf46cad824863cae0879042b35758d
                  MATRIX: 767->1|864->23|878->30|958->34|989->39|1066->89|1094->90|1138->107|1202->144|1230->145|1278->166|1630->490|1659->491|1712->516|1764->540|1793->541|1850->570|1999->691|2028->692|2160->796|2189->797|2246->826|2319->871|2348->872|2397->893|2426->894|2473->913|2502->914|2575->959|2604->960|2653->981|2711->1011|2740->1012|2826->1070|2855->1071|2904->1092|3338->1498|3367->1499|3412->1516|3466->1542|3495->1543|3536->1564|3551->1571|3632->1575|3664->1580|3736->1625|3784->1652|3821->1662|3912->1726|3941->1734|3982->1747|4430->2168|4480->2197|4510->2198|4948->2609|4993->2633|5067->2680|5113->2705|5187->2752|5229->2773|5303->2820|5343->2839|5417->2886|5465->2913|5539->2960|5584->2984|5658->3031|5699->3051|9601->6925|9642->6944|10354->7628|10401->7652|10778->8001|10826->8026|11200->8372|11244->8393|11612->8733|11654->8752|12016->9086|12064->9111|13511->10530|13554->10550|13632->10599|14219->11158|14263->11180|14921->11810|14965->11832|14995->11833|15297->12107|15351->12139|15381->12140|15781->12512|15822->12531|15925->12606|15980->12638|18002->14632|18040->14648|18143->14723|18184->14742|18287->14817|18342->14849|20375->16854|20418->16874|20496->16923|21057->17455|21099->17474|21395->17742|21436->17761|22068->18365|22115->18389|22460->18706|22508->18731|22850->19045|22894->19066|23230->19374|23272->19393|23602->19695|23650->19720|24051->20093|24088->20108|24466->20458|24502->20472|25094->21036|25137->21056|25207->21097|25501->20|25530->1561|25560->21352|25590->21355
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|49->19|49->19|50->20|51->21|51->21|52->22|52->22|53->23|53->23|55->25|55->25|56->26|57->27|57->27|60->30|60->30|61->31|65->35|65->35|66->36|67->37|67->37|69->41|69->41|71->41|72->42|73->43|73->43|75->45|76->46|76->46|77->47|83->53|83->53|83->53|92->62|92->62|93->63|93->63|94->64|94->64|95->65|95->65|96->66|96->66|97->67|97->67|98->68|98->68|139->109|139->109|149->119|149->119|153->123|153->123|157->127|157->127|161->131|161->131|166->136|166->136|182->152|182->152|183->153|194->164|194->164|204->174|204->174|204->174|208->178|208->178|208->178|213->183|213->183|214->184|214->184|239->209|239->209|240->210|240->210|241->211|241->211|265->235|265->235|266->236|276->246|276->246|280->250|280->250|290->260|290->260|294->264|294->264|298->268|298->268|302->272|302->272|307->277|307->277|311->281|311->281|315->285|315->285|323->293|323->293|324->294|335->1|337->39|339->304|341->306
                  -- GENERATED --
              */
          