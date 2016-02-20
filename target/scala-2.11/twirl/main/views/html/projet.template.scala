
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object projet_Scope0 {
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

class projet extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

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
            """),format.raw/*24.13*/("""}"""),format.raw/*24.14*/(""");
    </script>
""")))};def /*28.2*/content/*28.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*28.13*/("""
    """),format.raw/*29.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*30.10*/sidebar("Projet")),format.raw/*30.27*/("""

        """),format.raw/*32.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">
            """),_display_(/*33.14*/topbar()),format.raw/*33.22*/("""


            """),format.raw/*36.13*/("""<div id="refresh" >
                <div>

                </div>
                <div class="row">
                    <div class="col-md-2" style="background-color: #f2dede ; height: 100% ;">

                        <div class="row" style="margin-left: 0px ; margin-right: 0px ;">
                            <div class="sidebar-projet select">
                                <div class="content">
                                    <div class="sidebar-projet-nom">myProject</div>
                                    <div class="sidebar-client-nom">PoPS5I Inc.</div>
                                    <div class="sidebar-client-priorite"><div class="valeur">3</div></div>
                                </div>
                            </div>
                        </div>


                        <div class="row" style="margin-left: 0px ; margin-right: 0px ;">
                            <div class="sidebar-projet">
                                <div class="content">
                                    <div class="sidebar-projet-nom">BigData</div>
                                    <div class="sidebar-client-nom">Auchan</div>
                                    <div class="sidebar-client-priorite"><div class="valeur">2</div></div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="sidebar-footer">
                                <div class="checkbox checkbox-success checkbox-circle">
                                    <input id="checkbox-tache-termines" type="checkbox">
                                    <label for="checkbox-tache-termines">
                                        Afficher les projets terminés
                                    </label>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="col-md-10">

                        <div id="div-consulterProjet">
                            <div class="row wrapper border-bottom white-bg page-heading" style="padding-bottom: 0px ; padding-right: 0px ;">

                                <div class="col-sm-4">
                                    <h3 class="header-text">Projet : myProjects <div class="priorite">1</div> </h3>
                                    <h3 class="header-text">Client : PoPS5I Inc. <div class="priorite">2</div> </h3>
                                    <textarea readonly class="description" style="width: 100% ;">
                                        Le but étant de développer un site web permettant le suivi de projet Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sed sapien quam. Sed dapibus est id enim facilisis, at posuere turpis adipiscing. Quisque sit amet dui dui
                                        .</textarea>
                                </div>

                                <div class="col-sm-5" id="header-milieu">
                                    <h3 class="header-text">Responsable projet : Julien Preisner</h3>
                                    <h3 class="header-text">Avancement : 25%</h3>

                                    <h3 class="header-text">
                                        <table>
                                            <tr>
                                                <td>
                                                    Du <div class="date-projet">14/10/2015</div>
                                                </td>
                                                <td style="padding-left: 3px ; padding-right: 3px ;">au</td>
                                                <td>
                                                    <div class="date-projet">01/02/2016</div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td>
                                                    <div class="date-projet">05/02/2016</div>
                                                </td>
                                            </tr>
                                        </table>
                                    </h3>
                                </div>

                                <div class="col-sm-3">

                                    <div class="row" style="padding-top: 10px ;">

                                        <div class="col-xs-9">
                                            <div class="row-initiale">Initiale : 50J</div>
                                            <div class="row-restante">Restante : 30J</div>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                    60%
                                                </div>
                                            </div>
                                            <p class="row-consommee">Consommée : 30J</p>
                                        </div>
                                        <div class="col-xs-3">
                                            <a tabindex="0" class="btn btn-success btn-circle popover-info" role="button" data-container="body" data-toggle="popover" data-placement="bottom" data-html="true" data-trigger="focus" data-content='<p><div class="cercle cercle-indisponible"></div> """),_display_(/*132.294*/Messages("unavailable")),format.raw/*132.317*/("""</p><p><div class="cercle cercle-termine"></div> """),_display_(/*132.367*/Messages("completed")),format.raw/*132.388*/("""</p><p><div class="cercle cercle-retard"></div> """),_display_(/*132.437*/Messages("delayed")),format.raw/*132.456*/("""</p>'>
                                                <i class="fa fa-info"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="row" style="margin-top: 14px ;">
                                        <div style="margin-top:14px ;">

                                            <button id="btn-modifierProjet" class="btn btn-info" type="button" style="padding: 3px 7px ; float: right ; border-radius: 0px 0 0 0 ; background-color: #1AB394"><i class="fa fa-pencil"></i>
                                            </button>
                                        </div>
                                    </div>


                                </div>

                            </div>
                        </div>

                        <div id="div-modifierProjet" style="display: none ;">
                            <form id="addProjectForm" class="m-t" role="form" method="POST">

                                <div class="wrapper wrapper-content">
                                    <div class="ibox fadeInRightBig" style="background-color: #FFF ; max-width: 100% ;">
                                        <div class="ibox-content">
                                            <div class="row">
                                                <div class="col-sm-offset-2 col-sm-8">
                                                    <label class="label_form" for="projectResponsible">"""),_display_(/*159.105*/Messages("project")),format.raw/*159.124*/("""</label>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-sm-offset-2 col-sm-8">
                                                    <div class="row">
                                                        <div class="col-sm-6"><input placeholder="" class="form-control"></div>
                                                        <div class="col-sm-6">"""),_display_(/*167.80*/Messages("priority")),format.raw/*167.100*/("""

                                                            """),format.raw/*169.61*/("""<div class="btn-group" style="display: inline-block ;">
                                                                <button class="btn" type="button">1</button>
                                                                <button class="btn btn-active" type="button">2</button>
                                                                <button class="btn" type="button">3</button>

                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <div class='form-group'>
                                                                <label class="label_form" for="projectResponsible">"""),_display_(/*181.117*/Messages("projectPersonResponsible")),format.raw/*181.153*/("""</label>
                                                                <input class="form-control" id="projectResponsible" name="projectResponsible" required="true"/>
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-6">
                                                            <div class='form-group'>
                                                                <label class="label_form" for="client">"""),_display_(/*188.105*/Messages("client")),format.raw/*188.123*/("""</label>
                                                                <input class="form-control" id="client" name="client" required="true"/>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <label class="label_form">"""),_display_(/*196.88*/Messages("description")),format.raw/*196.111*/("""</label>
                                                        </div>

                                                        <div class="col-sm-12">
                                                            <textarea style="height: 260px ; width:100% ;"></textarea>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                        </div>
                                        <div class="ibox-footer text-center" style="background-color: #27AE62 ; color:#FFF ; height: 40px ;">

                                            <h3>"""),_display_(/*210.50*/Messages("saveProject")),format.raw/*210.73*/("""</h3>
                                        </div>
                                    </div>
                                </div>


                            </form>
                        </div>
                        <div style="margin-top: 30px ;" class="row wrapper wrapper-content white-bg">
                            <div style="margin:auto ;">
                                <div class="tab-pane active">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="checkbox checkbox-success checkbox-circle">
                                                    <input id="checkbox-projet-termines" type="checkbox">
                                                    <label for="checkbox-projet-termines">
                                                        Afficher les Projets terminées
                                                    </label>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="checkbox checkbox-success checkbox-circle">
                                                    <input id="checkbox-projet-indisponible" type="checkbox">
                                                    <label for="checkbox-projet-indisponible">
                                                        Afficher les Projets indisponibles
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="ibox-content">

                                            <p  class="m-b-lg">
                                                <strong>Nestable</strong> is an interactive hierarchical list. You can drag and drop to rearrange the order. It works well on touch-screens.
                                            </p>

                                            <div class="dd" id="nestable">
                                                <ol class="dd-list">
                                                    <li class="dd-item" data-id="1">
                                                        <div class="dd-handle" style="padding:0px;">
                                                            <div class="row row-nestable">
                                                                <div class="col-middle" style="border-right: 1px solid #EBEBEB;">Toto</div>
                                                                <div class="col-middle" style="border-right: 1px solid #EBEBEB;">Daro Heng</div>
                                                                <div class="col-middle" style="border-right: 1px solid #EBEBEB;">01/01/2000</div>
                                                                <div class="col-middle" style="border-right: 1px solid #EBEBEB;">
                                                                    <div class="row row-nestable">21/12/1222</div>
                                                                    <div class="row row-nestable">45/32/2345</div>
                                                                </div>
                                                                <div class="col-middle" style="width:22%;border-right: 1px solid #EBEBEB;">
                                                                    <div class="row row-initiale row-nestable">Initiale : 30J</div>
                                                                    <div class="row row-restante row-nestable">Totale : 18J</div>
                                                                    <div class="row progress progress-bar-default row-nestable">
                                                                        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                            60%
                                                                        </div>
                                                                    </div>
                                                                    <div class="row row-consommee row-nestable">Consommée : 30J</div>
                                                                </div>

                                                                <div class="col-middle" style="width:22%;border-right: 1px solid #EBEBEB;">
                                                                    <div class="row row-nestable">Précédente : 4.1</div>
                                                                    <div class="row row-nestable dd-nodrag">
                                                                        Suivantes :
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle dropdown-pert" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">
                                                                                8 tâches <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu dropdown-menu-pert">
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-middle dd-nodrag" style="width:3%; border-right: 1px solid #EBEBEB;"><i class="fa fa-bell-slash-o"></i></div>
                                                                <div class="col-middle dd-nodrag" style="width:3%;"><i class="fa fa-bell-slash-o"></i></div>
                                                            </div>
                                                            <div class="row row-nestable" style="background-color:green; height:25px;">

                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li class="dd-item" data-id="2">
                                                        <div class="dd-handle">
                                                            <tr>
                                                                <td>Toto</td>
                                                                <td>Daro Heng</td>
                                                                <td>01/01/2000</td>
                                                                <td>
                                                                    <div class="row">02/02/2002</div>
                                                                    <div class="row">04/04/2004</div>
                                                                </td>
                                                                <td>
                                                                    <div class="row row-initiale">Initiale : 30J</div>
                                                                    <div class="row row-restante">Totale : 18J</div>
                                                                    <div class="row progress progress-bar-default">
                                                                        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                            60%
                                                                        </div>
                                                                    </div>
                                                                    <div class="row row-consommee">Consommée : 30J</div>
                                                                </td>
                                                            </tr>
                                                        </div>
                                                        <ol class="dd-list">
                                                            <li class="dd-item" data-id="3">
                                                                <div class="dd-handle">3 - Adipiscing elit</div>
                                                            </li>
                                                            <li class="dd-item" data-id="4">
                                                                <div class="dd-handle">4 - Nonummy nibh</div>
                                                            </li>
                                                        </ol>
                                                    </li>
                                                    <li class="dd-item" data-id="5">
                                                        <div class="dd-handle">5 - Consectetuer</div>
                                                        <ol class="dd-list">
                                                            <li class="dd-item" data-id="6">
                                                                <div class="dd-handle">6 - Aliquam erat</div>
                                                            </li>
                                                            <li class="dd-item" data-id="7">
                                                                <div class="dd-handle">7 - Veniam quis</div>
                                                            </li>
                                                        </ol>
                                                    </li>
                                                    <li class="dd-item" data-id="8">
                                                        <div class="dd-handle">8 - Tation ullamcorper</div>
                                                    </li>
                                                    <li class="dd-item" data-id="9">
                                                        <div class="dd-handle">9 - Ea commodo</div>
                                                    </li>
                                                </ol>
                                            </div>
                                            <div class="m-t-md">
                                                <h5>Serialised Output</h5>
                                            </div>
                                            <textarea id="nestable-output" class="form-control"></textarea>
                                        </div>

                                        <div class="wrapper wrapper-content">
                                            <div style="margin:auto ;">
                                                <div class="table-responsive table-responsive-tdb">
                                                    <table id="projet_Projet" class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr class="table-center">
                                                                <th style="vertical-align:middle ;">Projet</th>
                                                                <th style="vertical-align:middle ;">Client</th>
                                                                <th style="vertical-align:middle ;">Date début</th>
                                                                <th style="vertical-align:middle ;">Date fin</th>
                                                                <th style="vertical-align:middle ;">Charge</th>
                                                                <th style="vertical-align:middle ;">Pert</th>
                                                                <th style="vertical-align:middle ;"><i class="fa fa-bell bell"></i></th>
                                                                <th style="vertical-align:middle ;"><img src="img/MyIcons/png/map47-grey.png" alt="image" class="icone"></th>
                                                                <th style="vertical-align:middle ;"><i class="fa fa-trash trash"></i></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="table-center" data-toggle="modal">
                                                                <td style="padding:0px ;">
                                                                    <div>
                                                                        <div class="idTache">4.1</div>
                                                                        <div>
                                                                            <img src="img/MyIcons/png/Criticite.png" alt="image" class="icone"/>
                                                                            <div class="idNom" style="display: inline-block">
                                                                                Toto</div>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;">Daro Heng</td>
                                                                <td style="vertical-align:middle ;">30/10/2015</td>
                                                                <td style="vertical-align:middle ;">
                                                                    <p>29/12/2015</p>
                                                                    <p>4/01/2016</p>
                                                                </td>
                                                                <td style="vertical-align:middle ;">
                                                                    <div class="row-initiale">Initiale : 30J</div>
                                                                    <div class="row-restante">Totale : 18J</div>
                                                                    <div class="progress progress-bar-default">
                                                                        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                            60%
                                                                        </div>
                                                                    </div>
                                                                    <p class="row-consommee">Consommée : 30J</p>
                                                                </td>

                                                                <td style="vertical-align:middle ;">
                                                                    <div class="row">Précédente : 4.1</div>
                                                                    <div class="row">
                                                                        Suivantes :
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle dropdown-pert" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">
                                                                                8 tâches <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu dropdown-menu-pert">
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.2</li>
                                                                                <li>5.3</li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;"><i class="fa fa-bell-slash-o"></i></td>
                                                                <td style="vertical-align:middle ;"><i class="fa fa-bell-slash-o"></i></td>
                                                                <td style="vertical-align:middle ;"><i class="fa fa-bell-slash-o"></i></td>
                                                            </tr>
                                                            <tr id="">
                                                                <td colspan="9" style="padding:0px ;">
                                                                    <div class="row" style="margin-right: 0px ; margin-left: 0px ; text-align: center ; background-color: #1ab394 ;">

                                                                        <div class="col-sm-4 normal">
                                                                            <i id="boutonPlusCreerTache" class="fa fa-plus-circle" style=""> </i>

                                                                            <i id="barreCreerTachei" class="fa fa-arrow-right" style="color: #fff ; cursor: pointer ;">
                                                                                <p style="display:inline ;">
                                                                                """),_display_(/*430.82*/Messages("createSubTask")),format.raw/*430.107*/("""
                                                                                """),format.raw/*431.81*/("""</p>
                                                                            </i>

                                                                        </div>
                                                                        <div class="col-sm-4 normal">
                                                                            <i id="barreCreerTachei" class="fa fa-arrow-down" style="color: #fff ; cursor: pointer ;">
                                                                                <p style="display:inline ;">
                                                                                """),_display_(/*438.82*/Messages("createTask")),format.raw/*438.104*/("""
                                                                                """),format.raw/*439.81*/("""</p>
                                                                            </i>
                                                                        </div>
                                                                        <div class="col-sm-4 normal" style="border:none ;">
                                                                            <i id="barreCreerTachei" class="fa fa-arrow-up" style="color: #fff ; cursor: pointer ;">
                                                                                <p style="display:inline ;">
                                                                                """),_display_(/*445.82*/Messages("createTask")),format.raw/*445.104*/("""
                                                                                """),format.raw/*446.81*/("""</p>
                                                                            </i>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td style="display: none ;"></td>
                                                                <td style="display: none ;"></td>
                                                                <td style="display: none ;"></td>
                                                                <td style="display: none ;"></td>
                                                                <td style="display: none ;"></td>
                                                                <td style="display: none ;"></td>
                                                                <td style="display: none ;"></td>
                                                                <td style="display: none ;"></td>
                                                            </tr>
                                                            <tr class="table-center" data-toggle="modal">
                                                                <td style="padding:0px ;">
                                                                    <div>
                                                                        <div class="idTache">4.1</div>
                                                                        <div>
                                                                            <img src="img/MyIcons/png/Criticite.png" alt="image" class="icone"/>
                                                                            <div class="idNom" style="display: inline-block">
                                                                                Toto</div>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;">Daro Heng</td>
                                                                <td style="vertical-align:middle ;">30/10/2015</td>
                                                                <td style="vertical-align:middle ;">
                                                                    <p>29/12/2015</p>
                                                                    <p>4/01/2016</p>
                                                                </td>
                                                                <td style="vertical-align:middle ;">
                                                                    <div class="row-initiale">Initiale : 30J</div>
                                                                    <div class="row-restante">Totale : 18J</div>
                                                                    <div class="progress progress-bar-default">
                                                                        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                            60%
                                                                        </div>
                                                                    </div>
                                                                    <p class="row-consommee">Consommée : 30J</p>
                                                                </td>

                                                                <td style="vertical-align:middle ;">
                                                                    <div class="row">Précédente : 4.1</div>
                                                                    <div class="row">
                                                                        Suivantes :
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle dropdown-pert" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">
                                                                                8 tâches <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu dropdown-menu-pert">
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.2</li>
                                                                                <li>5.3</li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;"><i class="fa fa-bell-slash-o"></i></td>
                                                                <td style="vertical-align:middle ;" style="padding:0px ;">
                                                                    <div style="display: block ;">
                                                                        <div class="priorite" style="width: 100% ; cursor: pointer ;"> <i class="fa fa-arrow-left"> </i> </div>
                                                                        <div class="priorite" style="width: 100% ; margin-top:5px ; cursor: pointer ;"> <i class="fa fa-arrow-right"> </i> </div>
                                                                        <div class="priorite" style="width: 100% ; margin-top:5px ; cursor: pointer ;"> <i class="fa fa-arrow-up"> </i> </div>
                                                                        <div class="priorite" style="width: 100% ; margin-top:5px ; cursor: pointer ;"> <i class="fa fa-arrow-down"> </i> </div>

                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;"><i class="fa fa-bell-slash-o"></i></td>
                                                            </tr>
                                                        </tbody>
                                                        <tfoot>
                                                            <tr class="table-center">
                                                                <th style="vertical-align:middle ;">Projet</th>
                                                                <th style="vertical-align:middle ;">Client</th>
                                                                <th style="vertical-align:middle ;">Date début</th>
                                                                <th style="vertical-align:middle ;">Date fin</th>
                                                                <th style="vertical-align:middle ;">Charge</th>
                                                                <th style="vertical-align:middle ;">Pert</th>
                                                                <th style="vertical-align:middle ;"><i class="fa fa-bell bell"></i></th>
                                                                <th style="vertical-align:middle ;"><img src="img/MyIcons/png/map47-grey.png" alt="image" class="icone"></th>
                                                                <th style="vertical-align:middle ;"><i class="fa fa-trash trash"></i></th>
                                                            </tr>
                                                        </tfoot>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div style="margin-top: 30px ;" class="row wrapper wrapper-content white-bg">
                            <div style="margin:auto ;">
                                <div class="tab-pane active">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <div class="checkbox checkbox-success checkbox-circle">
                                                    <input id="checkbox-tache-termines" type="checkbox">
                                                    <label for="checkbox-tache-termines">
                                                        Afficher les tâches terminées
                                                    </label>
                                                </div>
                                            </div>

                                            <div class="col-sm-4">
                                                <div class="checkbox checkbox-success checkbox-circle">
                                                    <input id="checkbox-tache-indisponible" type="checkbox">
                                                    <label for="checkbox-tache-indisponible">
                                                        Afficher les tâches indisponibles
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                            <!-- fin filtre -->
                                        <div class="wrapper wrapper-content">
                                            <div class="animated fadeInRightBig" style="margin:auto ;">
                                                <div class="table-responsive table-responsive-tdb">
                                                    <table id="projet_Tache" class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr class="table-center">
                                                                <th style="vertical-align:middle ;">Tâche</th>
                                                                <th style="vertical-align:middle ;">Resp. tâche</th>
                                                                <th style="vertical-align:middle ;">Date début</th>
                                                                <th style="vertical-align:middle ;">Date fin</th>
                                                                <th style="vertical-align:middle ;">Charge</th>
                                                                <th style="vertical-align:middle ;">Pert</th>
                                                                <th style="vertical-align:middle ;"><i class="fa fa-bell"></i></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="table-center" data-toggle="modal">
                                                                <td style="padding:0px ;">
                                                                    <div>
                                                                        <div class="idTache">4.1</div>
                                                                        <div>
                                                                            <img src="img/MyIcons/png/Criticite.png" alt="image" class="icone"/>
                                                                            <div class="idNom" style="display: inline-block">
                                                                                Toto</div>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;">Daro Heng</td>
                                                                <td style="vertical-align:middle ;">30/10/2015</td>
                                                                <td style="vertical-align:middle ;">
                                                                    <p>29/12/2015</p>
                                                                    <p>4/01/2016</p>
                                                                </td>
                                                                <td style="vertical-align:middle ;">
                                                                    <div class="row-initiale">Initiale : 30J</div>
                                                                    <div class="row-restante">Totale : 18J</div>
                                                                    <div class="progress progress-bar-default">
                                                                        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                            60%
                                                                        </div>
                                                                    </div>
                                                                    <p class="row-consommee">Consommée : 30J</p>
                                                                </td>

                                                                <td style="vertical-align:middle ;">
                                                                    <div class="row">Précédente : 4.1</div>
                                                                    <div class="row">
                                                                        Suivantes :
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle dropdown-pert" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">
                                                                                8 tâches <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu dropdown-menu-pert">
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.2</li>
                                                                                <li>5.3</li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;"><i class="fa fa-bell-slash-o"></i></td>
                                                            </tr>

                                                            <tr class="table-center" data-toggle="modal">
                                                                <td style="padding:0px ;">
                                                                    <div class="idTache">4.1</div>
                                                                    <div>
                                                                        <table>
                                                                            <tr>
                                                                                <td class="sous-tache-1"><p></p></td>
                                                                                <td><img src="img/MyIcons/png/Criticite.png" alt="image" class="icone">
                                                                                    <div class="idNom" style="display: inline-block">
                                                                                        Faire les maquettes</div></td>
                                                                            </tr>
                                                                        </table>
                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;">Daro Heng</td>
                                                                <td style="vertical-align:middle ;">30/10/2015</td>
                                                                <td style="vertical-align:middle ;">
                                                                    <p>29/12/2015</p>
                                                                    <p>4/01/2016</p>
                                                                </td>
                                                                <td style="vertical-align:middle ;">
                                                                    <div class="row-initiale">Initiale : 30J</div>
                                                                    <div class="row-restante">Totale : 18J</div>
                                                                    <div class="progress progress-bar-default">
                                                                        <div class="progress-bar" role="progressb"""),
format.raw("""ar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                            60%
                                                                        </div>
                                                                    </div>
                                                                    <p class="row-consommee">Consommée : 30J</p>
                                                                </td>

                                                                <td style="vertical-align:middle ;">
                                                                    <div class="row">Précédente : 4.1</div>
                                                                    <div class="row">
                                                                        Suivantes :
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle dropdown-pert" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">
                                                                                8 tâches <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu dropdown-menu-pert">
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.1</li>
                                                                                <li>5.2</li>
                                                                                <li>5.3</li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </td>
                                                                <td style="vertical-align:middle ;"><i class="fa fa-bell-slash-o"></i></td>
                                                            </tr>
                                                        </tbody>
                                                        <tfoot>
                                                            <tr class="table-center">
                                                                <th style="vertical-align:middle ;">Tâche</th>
                                                                <th style="vertical-align:middle ;">Resp. tâche</th>
                                                                <th style="vertical-align:middle ;">Date début</th>
                                                                <th style="vertical-align:middle ;">Date fin</th>
                                                                <th style="vertical-align:middle ;">Charge</th>
                                                                <th style="vertical-align:middle ;">Pert</th>
                                                                <th style="vertical-align:middle ;"><i class="fa fa-bell"></i></th>
                                                            </tr>
                                                        </tfoot>
                                                    </table>
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
        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*26.2*/("""

"""),format.raw/*715.2*/("""

"""),_display_(/*717.2*/main(pageTitle, content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object projet extends projet_Scope0.projet
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/projet.scala.html
                  HASH: bfe152c73638c0bd66ff20d6d975058398d71ae9
                  MATRIX: 747->1|844->23|858->30|938->34|969->39|1046->89|1074->90|1118->107|1182->144|1210->145|1258->166|1610->490|1639->491|1692->516|1744->540|1773->541|1830->570|1979->691|2008->692|2140->796|2169->797|2226->826|2299->871|2328->872|2377->893|2406->894|2453->913|2482->914|2525->929|2554->930|2595->951|2610->958|2691->962|2723->967|2795->1012|2833->1029|2870->1039|2961->1103|2990->1111|3033->1126|8930->6994|8976->7017|9055->7067|9099->7088|9177->7137|9219->7156|10794->8702|10836->8721|11406->9263|11449->9283|11540->9345|12504->10280|12563->10316|13160->10884|13201->10902|13800->11473|13846->11496|14615->12237|14660->12260|34507->32079|34555->32104|34665->32185|35318->32810|35363->32832|35473->32913|36145->33557|36190->33579|36300->33660|60800->20|60829->948|60859->58101|60889->58104
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|49->19|49->19|50->20|51->21|51->21|52->22|52->22|53->23|53->23|54->24|54->24|56->28|56->28|58->28|59->29|60->30|60->30|62->32|63->33|63->33|66->36|162->132|162->132|162->132|162->132|162->132|162->132|189->159|189->159|197->167|197->167|199->169|211->181|211->181|218->188|218->188|226->196|226->196|240->210|240->210|460->430|460->430|461->431|468->438|468->438|469->439|475->445|475->445|476->446|747->1|749->26|751->715|753->717
                  -- GENERATED --
              */
          