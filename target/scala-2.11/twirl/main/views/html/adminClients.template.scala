
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminClients_Scope0 {
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

class adminClients extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

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
                    $("#sidebar ul li").removeClass('active');
                    $(this).addClass('active');

                    eval("jsRoutes.controllers."+controler).ajax("""),format.raw/*13.66*/("""{"""),format.raw/*13.67*/("""
                        """),format.raw/*14.25*/("""success: function(html) """),format.raw/*14.49*/("""{"""),format.raw/*14.50*/("""

                            """),format.raw/*16.29*/("""var result = $('#refresh',html);
                            $('#refresh').empty().html(result);
                        """),format.raw/*18.25*/("""}"""),format.raw/*18.26*/(""",
                        //Case we have a problem
                        error: function(errorMessage)"""),format.raw/*20.54*/("""{"""),format.raw/*20.55*/("""
                            """),format.raw/*21.29*/("""alert(errorMessage);
                        """),format.raw/*22.25*/("""}"""),format.raw/*22.26*/("""
                    """),format.raw/*23.21*/("""}"""),format.raw/*23.22*/(""");
                """),format.raw/*24.17*/("""}"""),format.raw/*24.18*/(""");

                $("body").load(function()"""),format.raw/*26.42*/("""{"""),format.raw/*26.43*/("""
                    """),format.raw/*27.21*/("""updateMenu();
                """),format.raw/*28.17*/("""}"""),format.raw/*28.18*/(""");

                function updateMenu()
                """),format.raw/*31.17*/("""{"""),format.raw/*31.18*/("""
                    """),format.raw/*32.21*/("""var navHeader = document.getElementById('nav-header');
                    $(navHeader).addClass('nav-header-admin');
                    $('.navbar').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important; transition: none;");
                    $('.pear-theme').css("cssText", "background-color : #e74c3c !important;border-color : #e74c3c !important;");
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/("""
                """),format.raw/*37.17*/("""updateMenu();
            """),format.raw/*38.13*/("""}"""),format.raw/*38.14*/(""");




    </script>
""")))};def /*46.2*/content/*46.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*46.13*/("""
    """),format.raw/*47.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*48.10*/sidebar("ClientAdmin")),format.raw/*48.32*/("""

        """),format.raw/*50.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">
            """),_display_(/*51.14*/topbar()),format.raw/*51.22*/("""
            """),format.raw/*52.13*/("""<div id="refresh" >
                <div class="ibox-content">
                    <div class="row row-options-admin-client">
                        <div class="col-sm-3">
                            <div class="checkbox checkbox-danger checkbox-circle">
                                <input id="checkBoxClientsArchived" class="styled" type="checkbox" onclick="clientsArchived()">
                                <label for="checkBoxClientsArchived"> """),_display_(/*58.72*/Messages("showArchivedClients")),format.raw/*58.103*/(""" """),format.raw/*58.104*/("""</label>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive table-responsive-admin-client">
                        <table id="dataTables-admin-client" class="table table-striped table-bordered table-hover" >
                            <thead>
                                <tr>
                                    <th>"""),_display_(/*67.42*/Messages("client")),format.raw/*67.60*/("""</th>
                                    <th>"""),_display_(/*68.42*/Messages("adress")),format.raw/*68.60*/("""</th>
                                    <th>"""),_display_(/*69.42*/Messages("nbContacts")),format.raw/*69.64*/("""</th>
                                    <th>"""),_display_(/*70.42*/Messages("nbProjects")),format.raw/*70.64*/("""</th>
                                    <th>"""),_display_(/*71.42*/Messages("nbTasks")),format.raw/*71.61*/("""</th>
                                    <th>"""),_display_(/*72.42*/Messages("priority")),format.raw/*72.62*/("""</th>
                                    <th><i class="fa fa-trash"></i></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">Auchan</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">92 rue Réaumur 75002 Paris</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">23</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">5</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">112</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">LCL</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">18 rue de la République 69002 Lyon</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">11</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">28</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">PoPS5 Inc.</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">9 Rue Joliot Curie 91120 Gif-sur-Yvette</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">37</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">Société Générale</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">4 Ter Rue de Paris 91400 Orsay</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">16</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">91</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">La banque Postale</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">11 Rue Bourseul, 75015 Paris</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">31</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">31</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">Atos</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">80 Quai Voltaire, 95870 Bezons</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">7</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">12</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">3</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">EDF</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">résid Foulon, 91140 Villebon-sur-Yvette</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">12</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">CEA</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">Centre d'Etudes, 91190 Gif-sur-Yvette</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">12</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">21</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">MAAF</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1 rue de Chartres, 91400 Orsay</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">60</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">2</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">Matmut</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">41 boulevard Dubreuil, 91400 Orsay</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">3</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">12</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">MAIF</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">37 boulevard Dubreuil, 91400 Orsay</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">5</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">49</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">La Chocolatine</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">55 rue de Paris, 91400 Orsay</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">7</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">3</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">11</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">Le Moulin de Gasny</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">12 rue Boursier, 91400 Orsay</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">15</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">5</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">15</td>
                                    <td class="td-modal" data-toggle="modal" data-target="#modal-modif-client">1</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;" data-toggle="modal" data-target="#modal-suppr-client"><i class="fa fa-times"></i></td>
                                </tr>
                            </tbody>
                        </table>

                            <!-- Modal -->
                        <div class="modal fade" id="modal-suppr-client" role="dialog">
                            <div class="modal-dialog">
                                <div class="ibox-title background_admin div-center">
                                    ModalVIew Supprimer TItle
                                </div>
                                <div class="ibox-content">
                                    ModalVIew Supprimer Content
                                </div>
                            </div>
                        </div>

                        <div class="modal fade" id="modal-modif-client" role="dialog">
                            <div class="modal-dialog">
                                <div class="ibox-title background_admin div-center">
                                    <h5 class="text-white inline">"""),_display_(/*212.68*/Messages("setClient")),format.raw/*212.89*/("""</h5>
                                    <div class="ibox-tools">
                                        <button type="button" class="close" data-dismiss="modal">
                                            <i class="fa fa-times"/>
                                        </button>
                                    </div>
                                </div>
                                <div class="ibox-content">
                                    <div class="row">
                                        <div class="col-sm-6 b-r">
                                            <form class="form-horizontal" id="clientForm">
                                                <div class="row form-group">
                                                    <label class="col-sm-5 control-label" for="formClientName">"""),_display_(/*224.113*/Messages("formClientName")),format.raw/*224.139*/("""</label>
                                                    <div class="col-sm-7"><input type="text" id="formClientName" class="form-control"></div>
                                                </div>
                                                <div class="row form-group">
                                                    <label class="col-sm-5 control-label" for="formClientAdress">"""),_display_(/*228.115*/Messages("adress")),format.raw/*228.133*/("""</label>
                                                    <div class="col-sm-7"><input type="text" id="formClientAdress" class="form-control"></div>
                                                </div>
                                                <div class="row form-group">
                                                    <label class="col-sm-5 control-label" for="formZipCode">"""),_display_(/*232.110*/Messages("formZipCode")),format.raw/*232.133*/("""</label>
                                                    <div class="col-sm-7"><input type="text" id="formZipCode" class="form-control"></div>
                                                </div>
                                                <div class="row form-group">
                                                    <label class="col-sm-5 control-label" for="formCity">"""),_display_(/*236.107*/Messages("formCity")),format.raw/*236.127*/("""</label>
                                                    <div class="col-sm-7"><input type="text" id="formCity" class="form-control"></div>
                                                </div>

                                                <div class="row form-group">
                                                    <label class="col-sm-5 control-label" for="formCountry">"""),_display_(/*241.110*/Messages("formCountry")),format.raw/*241.133*/("""</label>
                                                    <div class="col-sm-7"><input type="text" id="formCountry" class="form-control"></div>
                                                </div>

                                                <div class="row form-group">
                                                    <label class="col-sm-5 control-label">"""),_display_(/*246.92*/Messages("priority")),format.raw/*246.112*/("""</label>
                                                    <div class="col-sm-7">
                                                        <div class="radio radio-inline radio-danger">
                                                            <input type="radio" id="inlineRadio1" value="option1" name="radioInline" checked="">
                                                            <label for="inlineRadio1">1</label>
                                                        </div>
                                                        <div class="radio radio-inline radio-danger">
                                                            <input type="radio" id="inlineRadio2" value="option2" name="radioInline">
                                                            <label for="inlineRadio2">2</label>
                                                        </div>
                                                        <div class="radio radio-inline radio-danger">
                                                            <input type="radio" id="inlineRadio3" value="option3" name="radioInline">
                                                            <label for="inlineRadio3">3</label>
                                                        </div>

                                                    </div>
                                                </div>

                                            </form>
                                        </div>

                                        <div class="col-sm-6">
                                            <div class="div-center">
                                                <h3 class="inline">"""),_display_(/*269.69*/Messages("addContact")),format.raw/*269.91*/("""</h3>
                                                <form class="form-horizontal" id="contactForm">
                                                    <div class="row form-group">
                                                        <label class="col-sm-5 control-label" for="formLastName">"""),_display_(/*272.115*/Messages("formLastName")),format.raw/*272.139*/("""</label>
                                                        <div class="col-sm-7"><input type="text" id="formLastName" class="form-control"></div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <label class="col-sm-5 control-label" for="formFirstName">"""),_display_(/*276.116*/Messages("formFirstName")),format.raw/*276.141*/("""</label>
                                                        <div class="col-sm-7"><input type="text" id="formFirstName" class="form-control"></div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <label class="col-sm-5 control-label" for="formEmail">"""),_display_(/*280.112*/Messages("formEmail")),format.raw/*280.133*/("""</label>
                                                        <div class="col-sm-7"><input type="text" id="formEmail" class="form-control"></div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <label class="col-sm-5 control-label" for="formTel" >"""),_display_(/*284.111*/Messages("formTel")),format.raw/*284.130*/("""</label>
                                                        <div class="col-sm-7"><input type="text" id="formTel" class="form-control"></div>
                                                    </div>
                                                </form>
                                                <button class="btn btn-admin inline" type="submit" form="contactForm">
                                                    <i class="fa fa-plus-square"></i>  """),_display_(/*289.89*/Messages("add")),format.raw/*289.104*/("""
                                                """),format.raw/*290.49*/("""</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <h3 style="text-align:center;">"""),_display_(/*296.77*/Messages("projects")),format.raw/*296.97*/("""</h3>
                                            <div class="list-modif-client">
                                                <table class="table-bordered">
                                                    <tbody>
                                                        <tr>
                                                            <td class="first-td">Projet 1</td>
                                                            <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="first-td">Projet 1</td>
                                                            <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="first-td">Projet 1</td>
                                                            <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                                        </tr>
                                                        <tr>
                                                            <td class="first-td">Projet 1</td>
                                                            <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <h3 style="text-align:center;">"""),_display_(/*321.77*/Messages("contacts")),format.raw/*321.97*/("""</h3>
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
                                            <button class="btn btn-admin" type="submit" form="clientForm">
                                                <i class="fa fa-check-square"></i> """),_display_(/*350.85*/Messages("validate")),format.raw/*350.105*/("""
                                            """),format.raw/*351.45*/("""</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>



        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*44.2*/("""

"""),format.raw/*367.2*/("""

"""),_display_(/*369.2*/main(pageTitle,content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object adminClients extends adminClients_Scope0.adminClients
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/adminClients.scala.html
                  HASH: 88c3bd8f60420ff900edbf304eecc05603f5af19
                  MATRIX: 759->1|856->23|870->30|950->34|981->39|1058->89|1086->90|1130->107|1194->144|1222->145|1270->166|1622->490|1651->491|1704->516|1756->540|1785->541|1843->571|1992->692|2021->693|2153->797|2182->798|2239->827|2312->872|2341->873|2390->894|2419->895|2466->914|2495->915|2568->960|2597->961|2646->982|2704->1012|2733->1013|2819->1071|2848->1072|2897->1093|3331->1499|3360->1500|3405->1517|3459->1543|3488->1544|3533->1569|3548->1576|3629->1580|3661->1585|3733->1630|3776->1652|3813->1662|3904->1726|3933->1734|3974->1747|4456->2202|4509->2233|4539->2234|4981->2649|5020->2667|5094->2714|5133->2732|5207->2779|5250->2801|5324->2848|5367->2870|5441->2917|5481->2936|5555->2983|5596->3003|19804->17183|19847->17204|20702->18030|20751->18056|21176->18452|21217->18470|21639->18863|21685->18886|22099->19271|22142->19291|22557->19677|22603->19700|23002->20071|23045->20091|24769->21787|24813->21809|25139->22106|25186->22130|25622->22537|25670->22562|26103->22966|26147->22987|26575->23386|26617->23405|27114->23874|27152->23889|27230->23938|27602->24282|27644->24302|29716->26346|29758->26366|32186->28766|32229->28786|32303->28831|32648->20|32677->1566|32707->29137|32737->29140
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|43->13|43->13|44->14|44->14|44->14|46->16|48->18|48->18|50->20|50->20|51->21|52->22|52->22|53->23|53->23|54->24|54->24|56->26|56->26|57->27|58->28|58->28|61->31|61->31|62->32|66->36|66->36|67->37|68->38|68->38|74->46|74->46|76->46|77->47|78->48|78->48|80->50|81->51|81->51|82->52|88->58|88->58|88->58|97->67|97->67|98->68|98->68|99->69|99->69|100->70|100->70|101->71|101->71|102->72|102->72|242->212|242->212|254->224|254->224|258->228|258->228|262->232|262->232|266->236|266->236|271->241|271->241|276->246|276->246|299->269|299->269|302->272|302->272|306->276|306->276|310->280|310->280|314->284|314->284|319->289|319->289|320->290|326->296|326->296|351->321|351->321|380->350|380->350|381->351|398->1|400->44|402->367|404->369
                  -- GENERATED --
              */
          