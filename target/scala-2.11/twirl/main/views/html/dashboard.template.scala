
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object dashboard_Scope0 {
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

class dashboard extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageTitle: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/scripts/*3.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
    """),format.raw/*4.5*/("""<script>


            $(document).ready(function() """),format.raw/*7.42*/("""{"""),format.raw/*7.43*/("""
                """),format.raw/*8.17*/("""$('.liclickable').click(function (e) """),format.raw/*8.54*/("""{"""),format.raw/*8.55*/("""
                    """),format.raw/*9.21*/("""e.preventDefault();
                    var self = $(this),
                            controler = self.data('infos') || self.attr('data-infos');
                    $('#sidebar ul li').removeClass('active');
                    $(this).addClass('active');

                    eval("jsRoutes.controllers."+controler).ajax("""),format.raw/*15.66*/("""{"""),format.raw/*15.67*/("""
                        """),format.raw/*16.25*/("""success: function(html) """),format.raw/*16.49*/("""{"""),format.raw/*16.50*/("""
                            """),format.raw/*17.29*/("""var result = $('#refresh',html);
                            $('#refresh').empty().html(result);
                        """),format.raw/*19.25*/("""}"""),format.raw/*19.26*/(""",
                        //Case we have a problem
                        error: function(errorMessage)"""),format.raw/*21.54*/("""{"""),format.raw/*21.55*/("""
                            """),format.raw/*22.29*/("""alert(errorMessage);
                        """),format.raw/*23.25*/("""}"""),format.raw/*23.26*/("""
                    """),format.raw/*24.21*/("""}"""),format.raw/*24.22*/(""");
                """),format.raw/*25.17*/("""}"""),format.raw/*25.18*/(""");
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/(""");

    </script>
""")))};def /*32.2*/content/*32.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*32.13*/("""
    """),format.raw/*33.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*34.10*/sidebar("Dashboard")),format.raw/*34.30*/("""

        """),format.raw/*36.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">
            """),_display_(/*37.14*/topbar()),format.raw/*37.22*/("""
            """),format.raw/*38.13*/("""<div id="refresh" >

                <div class="row wrapper border-bottom white-bg page-heading" style="margin-top:10px ; margin-left:1px ; margin-right:1px ; background-color:#1AB394 ; color:white ;" >
                    <div class="col-sm-12 col-lg-4" style="padding:0px 20px 0px 20px ;">
                        <div class="row">
                            <h3>"""),_display_(/*43.34*/Messages("hello")),format.raw/*43.51*/(""" """),format.raw/*43.52*/("""Julien Preisner</h3>
                        </div>
                        <div class="row row-tdb">
                            <div class="col-sm-6">
                                <div class="panel panel-tdb">
                                    <div class="panel-heading panel-heading-normal">
                                    """),_display_(/*49.38*/Messages("projects")),format.raw/*49.58*/("""
                                    """),format.raw/*50.37*/("""</div>
                                    <div id="projet-tdb" class="panel-body" style="color:black ;">
                                        <p>"""),_display_(/*52.45*/Messages("currentProjects")),format.raw/*52.72*/(""" """),format.raw/*52.73*/(""": 4</p>
                                        <p>"""),_display_(/*53.45*/Messages("almostFinishedProjects")),format.raw/*53.79*/(""" """),format.raw/*53.80*/(""": 1</p>
                                        <p>"""),_display_(/*54.45*/Messages("delayedProjects")),format.raw/*54.72*/(""" """),format.raw/*54.73*/(""": 0</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="panel panel-tdb">
                                    <div class="panel-heading panel-heading-normal">
                                    """),_display_(/*61.38*/Messages("tasks")),format.raw/*61.55*/("""
                                    """),format.raw/*62.37*/("""</div>
                                    <div id="tache-tdb" class="panel-body" style="color:black ;">
                                        <p>"""),_display_(/*64.45*/Messages("currentTasks")),format.raw/*64.69*/(""" """),format.raw/*64.70*/(""": 4</p>
                                        <p>"""),_display_(/*65.45*/Messages("notStartedTasks")),format.raw/*65.72*/(""": 1</p>
                                        <p>"""),_display_(/*66.45*/Messages("startedTasks")),format.raw/*66.69*/(""" """),format.raw/*66.70*/(""": 4</p>
                                        <p>"""),_display_(/*67.45*/Messages("almostFinishedTasks")),format.raw/*67.76*/(""" """),format.raw/*67.77*/(""": 1</p>
                                        <p>"""),_display_(/*68.45*/Messages("delayedTasks")),format.raw/*68.69*/(""" """),format.raw/*68.70*/(""": 4</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-sm-12 col-lg-4" style="padding:0px 20px 0px 20px ;">
                        <div class="row">
                            <h3>"""),_display_(/*77.34*/Messages("importantEvents")),format.raw/*77.61*/("""</h3>
                        </div>
                        <div class="row row-tdb">
                            <div class="col-sm-6">
                                <div class="panel panel-tdb">
                                    <div class="panel-heading panel-heading-danger">
                                    """),_display_(/*83.38*/Messages("delayedTasks")),format.raw/*83.62*/("""
                                    """),format.raw/*84.37*/("""</div>
                                    <div id="taches-retardes" class="panel-body" style="color:black ;">
                                        <p>- Vérification des disques</p>
                                        <p>- Commencer le front-end</p>
                                        <p>- Créer la base de données</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="panel panel-tdb">
                                    <div class="panel-heading panel-heading-warning">
                                    """),_display_(/*95.38*/Messages("tasksToFinishShortly")),format.raw/*95.70*/("""
                                    """),format.raw/*96.37*/("""</div>
                                    <div id="taches-proches" class="panel-body" style="color:black ;">
                                        <p>- Vérification des disques</p>
                                        <p>- Commencer le front-end</p>
                                        <p>- Créer la base de données</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-lg-4" style="padding:0px 20px 0px 20px ;">
                        <div class="row row-tdb" style="margin-top:32px ;">
                            <div class="col-sm-6">
                                <div class="panel panel-tdb">
                                    <div class="panel-heading panel-heading-normal">
                                    """),_display_(/*111.38*/Messages("tasksProposal")),format.raw/*111.63*/("""
                                    """),format.raw/*112.37*/("""</div>
                                    <div id="taches-proposees" class="panel-body">
                                        <p>
                                            <a class="btn btn-danger btn-tdb">
                                                Vérification des disques
                                            </a>
                                        </p>
                                        <p>
                                            <a class="btn btn-danger btn-tdb">
                                                Commencer le front-end
                                            </a>
                                        </p>
                                        <p>
                                            <a class="btn btn-warning btn-tdb">
                                                Créer la base de données
                                            </a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <textarea id="bloc-notes-tdb" class="textarea-perso" placeholder='"""),_display_(/*133.100*/Messages("notes")),format.raw/*133.117*/("""...'></textarea>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="wrapper wrapper-content">
                    <div class="animated fadeInRightBig" style="margin:auto ;">
                        <div class="row">
                            <div class="col-xs-offset-11 col-xs-1">
                                <a tabindex="0" class="btn btn-success btn-circle popover-info" role="button" data-container="body" data-toggle="popover" data-placement="bottom" data-html="true" data-trigger="focus" data-content='<p><div class="cercle cercle-indisponible"></div> """),_display_(/*143.282*/Messages("unavailable")),format.raw/*143.305*/("""</p><p><div class="cercle cercle-termine"></div> """),_display_(/*143.355*/Messages("completed")),format.raw/*143.376*/("""</p><p><div class="cercle cercle-retard"></div> """),_display_(/*143.425*/Messages("delayed")),format.raw/*143.444*/("""</p>'>
                                    <i class="fa fa-info"></i>
                                </a>
                            </div>
                        </div>
                        <div class="tabs-container">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#tab-projets">"""),_display_(/*150.94*/Messages("myProjects")),format.raw/*150.116*/("""</a></li>
                                <li class=""><a data-toggle="tab" href="#tab-taches">"""),_display_(/*151.87*/Messages("myTasks")),format.raw/*151.106*/("""</a></li>
                            </ul>

                            <div class="tab-content">
                                    <!-- Tab "Mes projets" -->
                                <div id="tab-projets" class="tab-pane active">
                                    <div class="panel-body" style="padding-top:10px ;">
                                        <div class="row row-options-tdb">
                                            <div class="col-sm-3">
                                                <div class="checkbox checkbox-success checkbox-circle">
                                                    <input id="checkbox-tdb-rp-projets-termines" type="checkbox">
                                                    <label for="checkbox-tdb-rp-projets-termines">
                                                    """),_display_(/*163.54*/Messages("completedProjects")),format.raw/*163.83*/("""
                                                    """),format.raw/*164.53*/("""</label>
                                                </div>
                                            </div>
                                                <!-- debut filtre -->
                                            <div class="col-sm-offset-7 col-sm-2">
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-default dropdown-toggle dropdown-filtre" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        """),_display_(/*171.58*/Messages("filters")),format.raw/*171.77*/(""" """),format.raw/*171.78*/("""<span class="caret"></span>
                                                    </button>
                                                    <ul class="dropdown-menu">
                                                        <li>
                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                <input id="checkbox-tdb-projets-bientot-finis" type="checkbox">
                                                                <label for="checkbox-tdb-projets-bientot-finis">
                                                                """),_display_(/*178.66*/Messages("projectsToFinishShortly")),format.raw/*178.101*/("""
                                                                """),format.raw/*179.65*/("""</label>
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                <input id="checkbox-tdb-projets-retardes" type="checkbox">
                                                                <label for="checkbox-tdb-projets-retardes">
                                                                """),_display_(/*186.66*/Messages("delayedProjects")),format.raw/*186.93*/("""
                                                                """),format.raw/*187.65*/("""</label>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                            <!-- fin filtre -->
                                        <div class="table-responsive table-responsive-tdb">
                                            <table id="dataTables-tdb-projet" class="table table-striped table-bordered table-hover">
                                                <thead>
                                                    <tr class="table-center">
                                                        <th style="vertical-align:middle ;">"""),_display_(/*199.94*/Messages("project")),format.raw/*199.113*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*200.94*/Messages("client")),format.raw/*200.112*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*201.94*/Messages("startDate")),format.raw/*201.115*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*202.94*/Messages("endDate")),format.raw/*202.113*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*203.94*/Messages("workload")),format.raw/*203.114*/("""</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">
                                                            myProjects
                                                        </td>
                                                        <td style="vertical-align:middle ;">PoPS5I Inc.</td>
                                                        <td style="vertical-align:middle ;">10/10/2015</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2017/10/01</p>
                                                            <p>01/10/2017</p>
                                                            <p>10/10/2017</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">060%</p>
                                                            <p class="row-initiale">"""),_display_(/*220.86*/Messages("initial")),format.raw/*220.105*/("""
                                                                """),format.raw/*221.65*/(""": 50"""),_display_(/*221.70*/Messages("day-first-letter")),format.raw/*221.98*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*222.86*/Messages("remaining")),format.raw/*222.107*/("""
                                                                """),format.raw/*223.65*/(""": 30"""),_display_(/*223.70*/Messages("day-first-letter")),format.raw/*223.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                    60%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*230.87*/Messages("consumed")),format.raw/*230.107*/("""
                                                                """),format.raw/*231.65*/(""": 30"""),_display_(/*231.70*/Messages("day-first-letter")),format.raw/*231.98*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">EISD</td>
                                                        <td style="vertical-align:middle ;">Lavergne Inc.</td>
                                                        <td style="vertical-align:middle ;">20/12/2015</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/03/03</p>
                                                            <p>03/03/2016</p>
                                                            <p>13/03/2016</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">050%</p>
                                                            <p class="row-initiale">"""),_display_(/*245.86*/Messages("initial")),format.raw/*245.105*/("""
                                                                """),format.raw/*246.65*/(""": 100"""),_display_(/*246.71*/Messages("day-first-letter")),format.raw/*246.99*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*247.86*/Messages("remaining")),format.raw/*247.107*/("""
                                                                """),format.raw/*248.65*/(""": 50"""),_display_(/*248.70*/Messages("day-first-letter")),format.raw/*248.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50% ;">
                                                                    50%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*255.87*/Messages("consumed")),format.raw/*255.107*/("""
                                                                """),format.raw/*256.65*/(""": 50"""),_display_(/*256.70*/Messages("day-first-letter")),format.raw/*256.98*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">
                                                            Développer une application mobile</td>
                                                        <td style="vertical-align:middle ;">LePhocéen</td>
                                                        <td style="vertical-align:middle ;">01/10/2013</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2017/10/01</p>
                                                            <p>01/10/2017</p>
                                                            <p>10/10/2017</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">100%</p>
                                                            <p class="row-initiale">"""),_display_(/*271.86*/Messages("initial")),format.raw/*271.105*/("""
                                                                """),format.raw/*272.65*/(""": 3501"""),_display_(/*272.72*/Messages("day-first-letter")),format.raw/*272.100*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*273.86*/Messages("remaining")),format.raw/*273.107*/("""
                                                                """),format.raw/*274.65*/(""": 300"""),_display_(/*274.71*/Messages("day-first-letter")),format.raw/*274.99*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100% ;">
                                                                    100%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*281.87*/Messages("consumed")),format.raw/*281.107*/("""
                                                                """),format.raw/*282.65*/(""": 310"""),_display_(/*282.71*/Messages("day-first-letter")),format.raw/*282.99*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">Gagner un match</td>
                                                        <td style="vertical-align:middle ;">Olympique de Marseille</td>
                                                        <td style="vertical-align:middle ;">09/03/2016</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/03/19</p>
                                                            <p>19/03/2016</p>
                                                            <p>23/03/2016</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">0%</p>
                                                            <p class="row-initiale">"""),_display_(/*296.86*/Messages("initial")),format.raw/*296.105*/("""
                                                                """),format.raw/*297.65*/(""": 10"""),_display_(/*297.70*/Messages("day-first-letter")),format.raw/*297.98*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*298.86*/Messages("remaining")),format.raw/*298.107*/("""
                                                                """),format.raw/*299.65*/(""": 10"""),_display_(/*299.70*/Messages("day-first-letter")),format.raw/*299.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0% ; color:black ;">
                                                                    0%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*306.87*/Messages("consumed")),format.raw/*306.107*/("""
                                                                """),format.raw/*307.65*/(""": 0"""),_display_(/*307.69*/Messages("day-first-letter")),format.raw/*307.97*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">myProjects</td>
                                                        <td style="vertical-align:middle ;">PoPS5I Inc.</td>
                                                        <td style="vertical-align:middle ;">10/10/2015</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/04/03</p>
                                                            <p>03/04/2016</p>
                                                            <p>13/06/2016</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">060%</p>
                                                            <p class="row-initiale">"""),_display_(/*321.86*/Messages("initial")),format.raw/*321.105*/("""
                                                                """),format.raw/*322.65*/(""": 50"""),_display_(/*322.70*/Messages("day-first-letter")),format.raw/*322.98*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*323.86*/Messages("remaining")),format.raw/*323.107*/("""
                                                                """),format.raw/*324.65*/(""": 30"""),_display_(/*324.70*/Messages("day-first-letter")),format.raw/*324.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                    60%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*331.87*/Messages("consumed")),format.raw/*331.107*/("""
                                                                """),format.raw/*332.65*/(""": 30"""),_display_(/*332.70*/Messages("day-first-letter")),format.raw/*332.98*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">EISD</td>
                                                        <td style="vertical-align:middle ;">Lavergne Inc.</td>
                                                        <td style="vertical-align:middle ;">20/12/2015</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/03/02</p>
                                                            <p>02/03/2016</p>
                                                            <p>02/03/2016</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">050%</p>
                                                            <p class="row-initiale">"""),_display_(/*346.86*/Messages("initial")),format.raw/*346.105*/("""
                                                                """),format.raw/*347.65*/(""": 100"""),_display_(/*347.71*/Messages("day-first-letter")),format.raw/*347.99*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*348.86*/Messages("remaining")),format.raw/*348.107*/("""
                                                                """),format.raw/*349.65*/(""": 50"""),_display_(/*349.70*/Messages("day-first-letter")),format.raw/*349.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50% ;">
                                                                    50%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*356.87*/Messages("consumed")),format.raw/*356.107*/("""
                                                                """),format.raw/*357.65*/(""": 50"""),_display_(/*357.70*/Messages("day-first-letter")),format.raw/*357.98*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">
                                                            Développer une application mobile</td>
                                                        <td style="vertical-align:middle ;">LePhocéen</td>
                                                        <td style="vertical-align:middle ;">01/10/2013</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2017/10/01</p>
                                                            <p>01/10/2017</p>
                                                            <p>10/10/2017</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">100%</p>
                                                            <p class="row-initiale">"""),_display_(/*372.86*/Messages("initial")),format.raw/*372.105*/("""
                                                                """),format.raw/*373.65*/(""": 3501"""),_display_(/*373.72*/Messages("day-first-letter")),format.raw/*373.100*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*374.86*/Messages("remaining")),format.raw/*374.107*/("""
                                                                """),format.raw/*375.65*/(""": 300"""),_display_(/*375.71*/Messages("day-first-letter")),format.raw/*375.99*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100% ;">
                                                                    100%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*382.87*/Messages("consumed")),format.raw/*382.107*/("""
                                                                """),format.raw/*383.65*/(""": 310"""),_display_(/*383.71*/Messages("day-first-letter")),format.raw/*383.99*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">Gagner un match</td>
                                                        <td style="vertical-align:middle ;">Olympique de Marseille</td>
                                                        <td style="vertical-align:middle ;">09/03/2016</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/05/03</p>
                                                            <p>03/05/2016</p>
                                                            <p>13/05/2016</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">0%</p>
                                                            <p class="row-initiale">"""),_display_(/*397.86*/Messages("initial")),format.raw/*397.105*/("""
                                                                """),format.raw/*398.65*/(""": 10"""),_display_(/*398.70*/Messages("day-first-letter")),format.raw/*398.98*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*399.86*/Messages("remaining")),format.raw/*399.107*/("""
                                                                """),format.raw/*400.65*/(""": 10"""),_display_(/*400.70*/Messages("day-first-letter")),format.raw/*400.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0% ; color:black ;">
                                                                    0%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*407.87*/Messages("consumed")),format.raw/*407.107*/("""
                                                                """),format.raw/*408.65*/(""": 0"""),_display_(/*408.69*/Messages("day-first-letter")),format.raw/*408.97*/("""</p>
                                                        </td>
                                                    </tr>

                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">myProjects</td>
                                                        <td style="vertical-align:middle ;">PoPS5I Inc.</td>
                                                        <td style="vertical-align:middle ;">10/10/2015</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/11/20</p>
                                                            <p>20/11/2016</p>
                                                            <p>23/12/2016</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">060%</p>
                                                            <p class="row-initiale">"""),_display_(/*423.86*/Messages("initial")),format.raw/*423.105*/("""
                                                                """),format.raw/*424.65*/(""": 50"""),_display_(/*424.70*/Messages("day-first-letter")),format.raw/*424.98*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*425.86*/Messages("remaining")),format.raw/*425.107*/("""
                                                                """),format.raw/*426.65*/(""": 30"""),_display_(/*426.70*/Messages("day-first-letter")),format.raw/*426.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                    60%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*433.87*/Messages("consumed")),format.raw/*433.107*/("""
                                                                """),format.raw/*434.65*/(""": 30"""),_display_(/*434.70*/Messages("day-first-letter")),format.raw/*434.98*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">EISD</td>
                                                        <td style="vertical-align:middle ;">Lavergne Inc.</td>
                                                        <td style="vertical-align:middle ;">20/12/2015</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/01/01</p>
                                                            <p>01/01/2016</p>
                                                            <p>01/01/2017</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">050%</p>
                                                            <p class="row-initiale">"""),_display_(/*448.86*/Messages("initial")),format.raw/*448.105*/("""
                                                                """),format.raw/*449.65*/(""": 100"""),_display_(/*449.71*/Messages("day-first-letter")),format.raw/*449.99*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*450.86*/Messages("remaining")),format.raw/*450.107*/("""
                                                                """),format.raw/*451.65*/(""": 50"""),_display_(/*451.70*/Messages("day-first-letter")),format.raw/*451.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50% ;">
                                                                    50%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*458.87*/Messages("consumed")),format.raw/*458.107*/("""
                                                                """),format.raw/*459.65*/(""": 50"""),_display_(/*459.70*/Messages("day-first-letter")),format.raw/*459.98*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">
                                                            Développer une application mobile</td>
                                                        <td style="vertical-align:middle ;">LePhocéen</td>
                                                        <td style="vertical-align:middle ;">01/10/2013</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/05/04</p>
                                                            <p>04/05/2016</p>
                                                            <p>07/02/2018</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">100%</p>
                                                            <p class="row-initiale">"""),_display_(/*474.86*/Messages("initial")),format.raw/*474.105*/("""
                                                                """),format.raw/*475.65*/(""": 3501"""),_display_(/*475.72*/Messages("day-first-letter")),format.raw/*475.100*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*476.86*/Messages("remaining")),format.raw/*476.107*/("""
                                                                """),format.raw/*477.65*/(""": 300"""),_display_(/*477.71*/Messages("day-first-letter")),format.raw/*477.99*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100% ;">
                                                                    100%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*484.87*/Messages("consumed")),format.raw/*484.107*/("""
                                                                """),format.raw/*485.65*/(""": 310"""),_display_(/*485.71*/Messages("day-first-letter")),format.raw/*485.99*/("""</p>
                                                        </td>
                                                    </tr>
                                                    <tr class="table-center">
                                                        <td style="vertical-align:middle ;">Gagner un match</td>
                                                        <td style="vertical-align:middle ;">Olympique de Marseille</td>
                                                        <td style="vertical-align:middle ;">09/03/2016</td>
                                                        <td style="vertical-align:middle ;">
                                                            <p style="display:none ;">2016/03/03</p>
                                                            <p>03/03/2016</p>
                                                            <p>13/03/2016</p>
                                                        </td>
                                                        <td class="td-avancement" style="vertical-align:middle ;">
                                                            <p style="display:none ;">0%</p>
                                                            <p class="row-initiale">"""),_display_(/*499.86*/Messages("initial")),format.raw/*499.105*/("""
                                                                """),format.raw/*500.65*/(""": 10"""),_display_(/*500.70*/Messages("day-first-letter")),format.raw/*500.98*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*501.86*/Messages("remaining")),format.raw/*501.107*/("""
                                                                """),format.raw/*502.65*/(""": 10"""),_display_(/*502.70*/Messages("day-first-letter")),format.raw/*502.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0% ; color:black ;">
                                                                    0%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*509.87*/Messages("consumed")),format.raw/*509.107*/("""
                                                                """),format.raw/*510.65*/(""": 0"""),_display_(/*510.69*/Messages("day-first-letter")),format.raw/*510.97*/("""</p>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                                    <!-- Tab "Mes taches" -->
                                <div id="tab-taches" class="tab-pane">
                                    <div class="panel-body" style="padding-top:10px ;">
                                        <div class="row row-options-tdb">
                                            <div class="col-sm-3">
                                                <div class="checkbox checkbox-success checkbox-circle">
                                                    <input id="checkbox-tdb-collab-projets-termines" type="checkbox">
                                                    <label for="checkbox-tdb-collab-projets-termines">
                                                    """),_display_(/*527.54*/Messages("completedProjects")),format.raw/*527.83*/("""
                                                    """),format.raw/*528.53*/("""</label>
                                                </div>
                                            </div>
                                            <div class="col-sm-3">
                                                <div class="checkbox checkbox-success checkbox-circle">
                                                    <input id="checkbox-tdb-collab-taches-termines" type="checkbox">
                                                    <label for="checkbox-tdb-collab-taches-termines">
                                                    """),_display_(/*535.54*/Messages("completedTasks")),format.raw/*535.80*/("""
                                                    """),format.raw/*536.53*/("""</label>
                                                </div>
                                            </div>
                                                <!-- debut filtre -->
                                            <div class="col-sm-offset-4 col-sm-2">
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-default dropdown-toggle dropdown-filtre" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        """),_display_(/*543.58*/Messages("filters")),format.raw/*543.77*/(""" """),format.raw/*543.78*/("""<span class="caret"></span>
                                                    </button>
                                                    <ul class="dropdown-menu">
                                                        <li>
                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                <input id="checkbox-tdb-taches-critiques" type="checkbox">
                                                                <label for="checkbox-tdb-taches-critiques">
                                                                """),_display_(/*550.66*/Messages("tasksOnCriticalPath")),format.raw/*550.97*/("""
                                                                """),format.raw/*551.65*/("""</label>
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                <input id="checkbox-tdb-taches-indisponibles" type="checkbox">
                                                                <label for="checkbox-tdb-taches-indisponibles">
                                                                """),_display_(/*558.66*/Messages("unavailableTasks")),format.raw/*558.94*/("""
                                                                """),format.raw/*559.65*/("""</label>
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                <input id="checkbox-tdb-taches-semaine-pro" type="checkbox">
                                                                <label for="checkbox-tdb-taches-semaine-pro">
                                                                """),_display_(/*566.66*/Messages("tasksStartingNextWeek")),format.raw/*566.99*/("""
                                                                """),format.raw/*567.65*/("""</label>
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                <input id="checkbox-tdb-taches-moins-10j" type="checkbox">
                                                                <label for="checkbox-tdb-taches-moins-10j">
                                                                """),_display_(/*574.66*/Messages("tasksMustBeCompletedInLessThan10days")),format.raw/*574.114*/("""
                                                                """),format.raw/*575.65*/("""</label>
                                                            </div>
                                                        </li>
                                                        <li>
                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                <input id="checkbox-tdb-taches-retardees" type="checkbox">
                                                                <label for="checkbox-tdb-taches-retardees">
                                                                """),_display_(/*582.66*/Messages("delayedTasks")),format.raw/*582.90*/("""
                                                                """),format.raw/*583.65*/("""</label>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                            <!-- fin filtre -->
                                        <td class="table-responsive table-responsive-tdb">
                                            <table id="dataTables-tdb-tache" class="table table-striped table-bordered table-hover">
                                                <thead>
                                                    <tr class="table-center">
                                                        <th style="vertical-align:middle ;">"""),_display_(/*595.94*/Messages("task")),format.raw/*595.110*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*596.94*/Messages("project")),format.raw/*596.113*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*597.94*/Messages("client")),format.raw/*597.112*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*598.94*/Messages("startDate")),format.raw/*598.115*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*599.94*/Messages("endDate")),format.raw/*599.113*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*600.94*/Messages("workload")),format.raw/*600.114*/("""</th>
                                                        <th style="vertical-align:middle ;">"""),_display_(/*601.94*/Messages("pert")),format.raw/*601.110*/("""</th>
                                                        <th style="vertical-align:middle ;"><i class="fa fa-bell"></i></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="table-center">
                                                        <td class="tdb-td-tache td-modal" style="padding:0px ;" data-toggle="modal" data-target="#modal-tdb-tache">
                                                            <p class="tdb-id-tache">4.1</p>
                                                            <p class="tdb-nom-tache">Créer la base de données</p>
                                                        </td>
                                                        <td class="td-modal" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tdb-tache">
                                                            PoPS5I Inc.</td>
                                                        <td class="td-modal" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tdb-tache">
                                                            myProjects</td>
                                                        <td class="td-modal" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tdb-tache">
                                                            10/10/2015</td>
                                                        <td class="td-modal" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tdb-tache">
                                                            <p style="display:none ;">2016/03/03</p>
                                                            <p>03/03/2016</p>
                                                            <p>13/03/2016</p>
                                                        </td>
                                                        <td class="td-modal" class="td-avancement" style="vertical-align:middle ;" data-toggle="modal" data-target="#modal-tdb-tache">
                                                            <p style="display:none ;">060%</p>
                                                            <p class="row-initiale">"""),_display_(/*624.86*/Messages("initial")),format.raw/*624.105*/("""
                                                                """),format.raw/*625.65*/(""": 50"""),_display_(/*625.70*/Messages("day-first-letter")),format.raw/*625.98*/("""</p>
                                                            <p class="row-restante">"""),_display_(/*626.86*/Messages("remaining")),format.raw/*626.107*/("""
                                                                """),format.raw/*627.65*/(""": 30"""),_display_(/*627.70*/Messages("day-first-letter")),format.raw/*627.98*/("""</p>
                                                            <div class="progress progress-bar-default">
                                                                    <!-- si 0% : color:black; -->
                                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                    60%
                                                                </div>
                                                            </div>
                                                            <p class="row-consommee">"""),_display_(/*634.87*/Messages("consumed")),format.raw/*634.107*/("""
                                                                """),format.raw/*635.65*/(""": 30"""),_display_(/*635.70*/Messages("day-first-letter")),format.raw/*635.98*/("""</p>
                                                        </td>
                                                        <td style="vertical-align:middle ;">
                                                            <div class="row">"""),_display_(/*638.79*/Messages("predecessor")),format.raw/*638.102*/(""" """),format.raw/*638.103*/(""": 4.1</div>
                                                            <div class="row">
                                                                """),_display_(/*640.66*/Messages("successors")),format.raw/*640.88*/(""" """),format.raw/*640.89*/(""":
                                                                <div class="btn-group">
                                                                    <button type="button" class="btn btn-default dropdown-toggle dropdown-pert" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">
                                                                        3 """),_display_(/*643.76*/Messages("tasks-lower")),format.raw/*643.99*/(""" """),format.raw/*643.100*/("""<span class="caret"></span>
                                                                    </button>
                                                                    <ul class="dropdown-menu dropdown-menu-pert">
                                                                        <li>5.1</li>
                                                                        <li>5.2</li>
                                                                        <li>5.3</li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </td>
                                                        <td class="icon-notif-tdb" style="vertical-align:middle ;"><a onclick="clickOnNotification('notif-tache-1')"><i id="notif-tache-1" class="fa fa-bell-slash"></i></a></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                                <!-- Modal view pour "Mes taches" -->
                                            <div class="modal fade" id="modal-tdb-tache" role="dialog">
                                                <div class="modal-dialog">
                                                        <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-body">
                                                            <div id="div-consulterTache">
                                                                <div class="row">
                                                                        <!-- 1ere colonne -->
                                                                    <div class="col-sm-6">
                                                                        <div class="id-tache-modal">
                                                                            <img src="img/MyIcons/png/Criticite.png" alt="image" class="icone" />
                                                                            """),_display_(/*669.78*/Messages("task")),format.raw/*669.94*/(""" """),format.raw/*669.95*/("""14
                                                                            <a><i class="fa fa-bell-slash"></i></a>
                                                                            <a><i class="fa fa-trash"></i></a>
                                                                            <a id="btn-modifierTache"><i class="fa fa-pencil"></i></a>
                                                                        </div>
                                                                        <p class="titre-tache-modal">Faire la maquette</p>
                                                                        <div class="description-modal-tache">
                                                                            Création de la maquette. Création de la maquette. Création de la maquette.
                                                                            Création de la maquette. Création de la maquette. Création de la maquette.
                                                                            Création de la maquette. Création de la maquette. Création de la maquette.
                                                                            Création de la maquette. Création de la maquette. Création de la maquette.
                                                                            Création de la maquette. Création de la maquette. Création de la maquette.
                                                                        </div>
                                                                        <p style="margin-top:7px ;">"""),_display_(/*682.102*/Messages("predecessor")),format.raw/*682.125*/("""
                                                                            """),format.raw/*683.77*/(""": </p>
                                                                        <div class="list-task">
                                                                            <table class="table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td class="id-task">8</td>
                                                                                        <td class="name-task">
                                                                                            Créer la base de données</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>

                                                                        <p style="margin-top:7px ;">"""),_display_(/*696.102*/Messages("successors")),format.raw/*696.124*/("""
                                                                            """),format.raw/*697.77*/(""": </p>
                                                                        <div class="list-task">
                                                                            <table class="table-bordered">
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td class="id-task">18</td>
                                                                                        <td class="name-task">
                                                                                            Créer la base de données</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td class="id-task">8</td>
                                                                                        <td class="name-task">
                                                                                            Créer la base de données</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td class="id-task">8</td>
                                                                                        <td class="name-task">
                                                                                            Créer la base de données</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td class="id-task">8</td>
                                                                                        <td class="name-task">
                                                                                            Créer la base de données</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>

                                                                        <!-- 2eme colonne -->
                                                                    <div class="col-sm-6">
                                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                                        <p class="bold">"""),_display_(/*729.90*/Messages("project")),format.raw/*729.109*/("""
                                                                            """),format.raw/*730.77*/(""": myProjects</p>
                                                                        <p class="bold">"""),_display_(/*731.90*/Messages("client")),format.raw/*731.108*/("""
                                                                            """),format.raw/*732.77*/(""": PoPS5I Inc.</p>
                                                                        <p>"""),_display_(/*733.77*/Messages("taskPersonResponsible")),format.raw/*733.110*/("""
                                                                            """),format.raw/*734.77*/(""": Daro Heng</p>
                                                                        <div class="row" style="margin-left:0px ;">
                                                                            <a class="btn-interlocuteurs-externes"><i class="fa fa-envelope"></i></a>
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle dropdown-interlocuteurs" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">
                                                                                    3 """),_display_(/*739.88*/Messages("externalInterlocutors")),format.raw/*739.121*/(""" """),format.raw/*739.122*/("""<span class="caret"></span>
                                                                                </button>
                                                                                <ul class="dropdown-menu dropdown-menu-pert">
                                                                                    <li>Lassana Diarra</li>
                                                                                    <li>Steve Mandanda</li>
                                                                                    <li>Didier Drogba</li>
                                                                                </ul>
                                                                            </div>
                                                                        </div>

                                                                        <p style="margin-top:12px ;">"""),_display_(/*749.103*/Messages("remainingTime")),format.raw/*749.128*/("""
                                                                            """),format.raw/*750.77*/(""": 10"""),_display_(/*750.82*/Messages("day-first-letter")),format.raw/*750.110*/("""</p>
                                                                        <div class="row row-date-tache-modal">
                                                                            <div class="col-sm-7">
                                                                            """),_display_(/*753.78*/Messages("startDate")),format.raw/*753.99*/("""
                                                                            """),format.raw/*754.77*/("""</div>
                                                                            <div class="col-sm-4 dateVert">
                                                                                20/11/2016
                                                                            </div>
                                                                        </div>
                                                                        <div class="row row-date-tache-modal">
                                                                            <div class="col-sm-7">
                                                                            """),_display_(/*761.78*/Messages("earliestEndDate")),format.raw/*761.105*/("""
                                                                            """),format.raw/*762.77*/("""</div>
                                                                            <div class="col-sm-4 dateVert">
                                                                                20/11/2016
                                                                            </div>
                                                                        </div>
                                                                        <div class="row row-date-tache-modal">
                                                                            <div class="col-sm-7">
                                                                            """),_display_(/*769.78*/Messages("latestEndDate")),format.raw/*769.103*/("""
                                                                            """),format.raw/*770.77*/("""</div>
                                                                            <div class="col-sm-4 dateVert">
                                                                                20/11/2016
                                                                            </div>
                                                                        </div>
                                                                        <div class="td-avancement" style="margin-top:24px ;">
                                                                            <p class="row-initiale">"""),_display_(/*776.102*/Messages("initial")),format.raw/*776.121*/("""
                                                                                """),format.raw/*777.81*/(""": 50"""),_display_(/*777.86*/Messages("day-first-letter")),format.raw/*777.114*/("""</p>
                                                                            <p class="row-restante">"""),_display_(/*778.102*/Messages("remaining")),format.raw/*778.123*/("""
                                                                                """),format.raw/*779.81*/(""": 30"""),_display_(/*779.86*/Messages("day-first-letter")),format.raw/*779.114*/("""</p>
                                                                            <div class="progress progress-bar-default">
                                                                                    <!-- si 0% : color:black; -->
                                                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60% ;">
                                                                                    60%
                                                                                </div>
                                                                            </div>
                                                                            <p class="row-consommee">"""),_display_(/*786.103*/Messages("consumed")),format.raw/*786.123*/("""
                                                                                """),format.raw/*787.81*/(""": 30"""),_display_(/*787.86*/Messages("day-first-letter")),format.raw/*787.114*/("""</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                                <!-- Formulaire modifier tache -->
                                                            <div id="div-modifierTache" style="display: none ;">
                                                                <form id="formModifierTache" class="form-horizontal">
                                                                    <div class="row">
                                                                            <!-- 1ere colonne -->
                                                                        <div class="col-sm-6">
                                                                                <!-- Icones -->
                                                                            <div class="id-tache-modal">
                                                                                <img src="img/MyIcons/png/Criticite.png" alt="image" class="icone" />
                                                                                """),_display_(/*802.82*/Messages("task")),format.raw/*802.98*/(""" """),format.raw/*802.99*/("""14
                                                                                <a><i class="fa fa-trash"></i></a>
                                                                                <a id="btn-modifierTache-active"><i class="fa fa-reply"></i></a>
                                                                            </div>
                                                                                <!-- Form nom tache -->
                                                                            <input type="text" id="formModifierNomTache" class="form-control margin-form" placeholder='"""),_display_(/*807.169*/Messages("taskName")),format.raw/*807.189*/("""...'>

                                                                                <!-- Form description tache -->
                                                                            <textarea id="formModifierDescriptionTache" class="textarea-perso margin-form" placeholder='"""),_display_(/*810.170*/Messages("taskDescription")),format.raw/*810.197*/("""...'></textarea>

                                                                                <!-- Modifier predecesseur -->
                                                                            <p style="margin-top:7px ;">"""),_display_(/*813.106*/Messages("predecessor")),format.raw/*813.129*/(""" """),format.raw/*813.130*/(""": </p>
                                                                            <select class="form-control select2-predecesseur" style="width:100%;" multiple="multiple">
                                                                                <option value="Mayotte">Mayotte</option>
                                                                                <option value="Mexico">Mexico</option>
                                                                                <option value="Nicaragua">Nicaragua</option>
                                                                            </select>
                                                                            <div class="list-task">
                                                                                <table class="table-bordered">
                                                                                    <tbody>
                                                                                        <tr>
                                                                                            <td class="id-task">8</td>
                                                                                            <td class="name-task">
                                                                                                Créer la base de données</td>
                                                                                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>
                                                                                        </tr>
                                                                                    </tbody>
                                                                                </table>
                                                                            </div>

                                                                                <!-- Modifier successeurs -->
                                                                            <p style="margin-top:7px ;">"""),_display_(/*833.106*/Messages("successors")),format.raw/*833.128*/("""
                                                                                """),format.raw/*834.81*/(""": </p>
                                                                            <select class="form-control select2-successeur" style="width:100%;" multiple="multiple">
                                                                                <option value="Mayotte">Mayotte</option>
                                                                                <option value="Mexico">Mexico</option>
                                                                                <option value="Nicaragua">Nicaragua</option>
                                                                            </select>
                                                                            <div class="list-task">
                                                                                <table class="table-bordered">
                                                                                    <tbody>
                                                                                        <tr>
                                                                                            <td class="id-task">18</td>
                                                                                            <td class="name-task">
                                                                                                Créer la base de données</td>
                                                                                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>                                                                                            </tr>
                                                                                        <tr>
                                                                                            <td class="id-task">8</td>
                                                                                            <td class="name-task">
                                                                                                Créer la base de données</td>
                                                                                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>                                                                                            </tr>
                                                                                        <tr>
                                                                                            <td class="id-task">8</td>
                                                                                            <td class="name-task">
                                                                                                Créer la base de données</td>
                                                                                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>                                                                                            </tr>
                                                                                        <tr>
                                                                                            <td class="id-task">8</td>
                                                                                            <td class="name-task">
                                                                                                Créer la base de données</td>
                                                                                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>                                                                                            </tr>
                                                                                    </tbody>
                                                                                </table>
                                                                            </div>
                                                                        </div>

                                                                            <!-- 2eme colonne -->
                                                                        <div class="col-sm-6">
                                                                            <button id="btn-fermer-modifierTache" type="button" class="close" data-dismiss="modal" style="margin-bottom:7px ;">&times;</button>

                                                                                <!-- Form nom du projet -->
                                                                            <input type="text" id="formModifierProjet" class="form-control margin-form" placeholder='"""),_display_(/*873.167*/Messages("projectName")),format.raw/*873.190*/("""...'>

                                                                                <!-- Form client -->
                                                                            <select class="form-control select2-client" style="width:100%;" multiple="multiple">

                                                                                <option value="Mayotte">Mayotte</option>
                                                                                <option value="Mexico">Mexico</option>
                                                                                <option value="Nicaragua">Nicaragua</option>
                                                                            </select>

                                                                                <!-- Form responsable tache -->
                                                                            <select class="form-control select2-respo-tache" style="width:100%;" multiple="multiple">
                                                                                <option value="Mayotte">Mayotte</option>
                                                                                <option value="Mexico">Mexico</option>
                                                                                <option value="Nicaragua">Nicaragua</option>
                                                                            </select>

                                                                                <!-- Liste interlocuteurs externes -->
                                                                            <div class="row margin-form" style="margin:10px 0px ;">
                                                                                <div class="btn-group">
                                                                                    <button type="button" class="btn btn-default dropdown-toggle dropdown-interlocuteurs" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background-color:white ; color:#676A6C ;">
                                                                                        3 """),_display_(/*894.92*/Messages("externalInterlocutors")),format.raw/*894.125*/(""" """),format.raw/*894.126*/("""<span class="caret"></span>
                                                                                    </button>
                                                                                    <ul class="dropdown-menu dropdown-menu-pert">
                                                                                        <li>
                                                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                                                <input id="checkbox-interlocuteur-1" type="checkbox">
                                                                                                <label for="checkbox-interlocuteur-1">
                                                                                                    Valérie Guimard
                                                                                                </label>
                                                                                            </div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                                                <input id="checkbox-interlocuteur-2" type="checkbox" checked>
                                                                                                <label for="checkbox-interlocuteur-2">
                                                                                                    Lassana Diarra
                                                                                                </label>
                                                                                            </div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                                                <input id="checkbox-interlocuteur-3" type="checkbox" checked>
                                                                                                <label for="checkbox-interlocuteur-3">
                                                                                                    Steve Mandanda
                                                                                                </label>
                                                                                            </div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                                                <input id="checkbox-interlocuteur-4" type="checkbox">
                                                                                                <label for="checkbox-interlocuteur-4">
                                                                                                    Frédéric Voisin
                                                                                                </label>
                                                                                            </div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <div class="checkbox checkbox-success checkbox-dropdown">
                                                                                                <input id="checkbox-interlocuteur-5" type="checkbox" checked>
                                                                                                <label for="checkbox-interlocuteur-5">
                                                                                                    Didier Drogba
                                                                                                </label>
                                                                                            </div>
                                                                                        </li>
                                                                                    </ul>
                                                                                </div>
                                                                            </div>

                                                                                <!-- datepicker - date debut -->
                                                                            <div class="row margin-form">
                                                                                <label class="col-sm-4 control-label font-noraml" for="datepicker_date_debut" style="text-align: left">"""),_display_(/*943.185*/Messages("startDate")),format.raw/*943.206*/("""</label>
                                                                                <div class="form-group col-sm-8" id="datepicker_date_debut">
                                                                                    <div class="input-group date">
                                                                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="">
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                                <!-- datepicker - date fin au + tot -->
                                                                            <div class="row margin-form">
                                                                                <label class="col-sm-4 control-label font-noraml" for="datepicker_date_fin_tot" style="text-align: left">"""),_display_(/*953.187*/Messages("earliestEndDate")),format.raw/*953.214*/("""</label>
                                                                                <div class="form-group col-sm-8" id="datepicker_date_fin_tot">
                                                                                    <div class="input-group date">
                                                                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="">
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                                <!-- datepicker - date fin au + tard -->
                                                                            <div class="row margin-form">
                                                                                <label class="col-sm-4 control-label font-noraml" for="datepicker_date_fin_tard" style="text-align: left">"""),_display_(/*963.188*/Messages("latestEndDate")),format.raw/*963.213*/("""</label>
                                                                                <div class="form-group col-sm-8" id="datepicker_date_fin_tard">
                                                                                    <div class="input-group date">
                                                                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input type="text" class="form-control" value="">
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                                <!-- charge initiale -->
                                                                            <div class="row form-group margin-form" >
                                                                                <label class="col-sm-6 control-label font-noraml" for="formModifierChargeInitiale" style="text-align: left">"""),_display_(/*973.190*/Messages("initialWorload")),format.raw/*973.216*/("""</label>
                                                                                <div class="col-sm-6">
                                                                                    <div class="input-group">
                                                                                        <input type="number" id="formModifierChargeInitiale" class="form-control" value="0" min="0" step="0.5">
                                                                                        <span class="input-group-addon" style="background-color:#1AB394 ; color:white ;">
                                                                                            J</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                                <!-- charge consommée -->
                                                                            <div class="row form-group margin-form" >
                                                                                <label class="col-sm-6 control-label font-noraml" for="formModifierChargeConsommee" style="text-align: left">"""),_display_(/*985.191*/Messages("consumedWorkload")),format.raw/*985.219*/("""</label>
                                                                                <div class="col-sm-6">
                                                                                    <div class="input-group">
                                                                                        <input type="number" id="formModifierChargeConsommee" class="form-control" value="0" min="0" step="0.5">
                                                                                        <span class="input-group-addon" style="background-color:#1AB394 ; color:white ;">"""),_display_(/*989.171*/Messages("day-first-letter")),format.raw/*989.199*/("""</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                                <!-- charge restante -->
                                                                            <div class="row form-group margin-form" >
                                                                                <label class="col-sm-6 control-label font-noraml" for="formModifierChargeRestante" style="text-align: left">"""),_display_(/*996.190*/Messages("remainingWorkload")),format.raw/*996.219*/("""</label>
                                                                                <div class="col-sm-6">
                                                                                    <div class="input-group">
                                                                                        <input type="number" id="formModifierChargeRestante" class="form-control" value="0" min="0" step="0.5">
                                                                                        <span class="input-group-addon" style="background-color:#1AB394 ; color:white ;">"""),_display_(/*1000.171*/Messages("day-first-letter")),format.raw/*1000.199*/("""</span>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                        <!-- bouton valider -->
                                                                    <div class="row" style="margin-top:15px ;">
                                                                        <div class="div-center">
                                                                            <button id="btn-valider-modifierTache" class="btn btn-primary" type="submit" form="formModifierTache">
                                                                                <i class="fa fa-check-square"></i> """),_display_(/*1010.117*/Messages("validate")),format.raw/*1010.137*/("""
                                                                            """),format.raw/*1011.77*/("""</button>
                                                                        </div>
                                                                    </div>
                                                                </form>
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
        </div>
    </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*29.2*/("""


"""),format.raw/*1030.2*/("""

"""),_display_(/*1032.2*/main(pageTitle, content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object dashboard extends dashboard_Scope0.dashboard
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/dashboard.scala.html
                  HASH: 8418c57de917cbb3a3422c68d04284d7ca1888ec
                  MATRIX: 753->1|850->23|864->30|944->34|975->39|1054->91|1082->92|1126->109|1190->146|1218->147|1266->168|1618->492|1647->493|1700->518|1752->542|1781->543|1838->572|1987->693|2016->694|2148->798|2177->799|2234->828|2307->873|2336->874|2385->895|2414->896|2461->915|2490->916|2533->931|2562->932|2604->955|2619->962|2700->966|2732->971|2804->1016|2845->1036|2882->1046|2973->1110|3002->1118|3043->1131|3438->1499|3476->1516|3505->1517|3869->1854|3910->1874|3975->1911|4152->2061|4200->2088|4229->2089|4308->2141|4363->2175|4392->2176|4471->2228|4519->2255|4548->2256|4935->2616|4973->2633|5038->2670|5214->2819|5259->2843|5288->2844|5367->2896|5415->2923|5494->2975|5539->2999|5568->3000|5647->3052|5699->3083|5728->3084|5807->3136|5852->3160|5881->3161|6256->3509|6304->3536|6653->3858|6698->3882|6763->3919|7474->4603|7527->4635|7592->4672|8525->5577|8572->5602|8638->5639|9893->6865|9933->6882|10621->7541|10667->7564|10746->7614|10790->7635|10868->7684|10910->7703|11311->8076|11356->8098|11480->8194|11522->8213|12390->9053|12441->9082|12523->9135|13145->9729|13186->9748|13216->9749|13898->10403|13956->10438|14050->10503|14691->11116|14740->11143|14834->11208|15728->12074|15770->12093|15897->12192|15938->12210|16065->12309|16109->12330|16236->12429|16278->12448|16405->12547|16448->12567|17881->13972|17923->13991|18017->14056|18050->14061|18100->14089|18218->14179|18262->14200|18356->14265|18389->14270|18439->14298|19158->14989|19201->15009|19295->15074|19328->15079|19378->15107|20637->16338|20679->16357|20773->16422|20807->16428|20857->16456|20975->16546|21019->16567|21113->16632|21146->16637|21196->16665|21915->17356|21958->17376|22052->17441|22085->17446|22135->17474|23480->18791|23522->18810|23616->18875|23651->18882|23702->18910|23820->19000|23864->19021|23958->19086|23992->19092|24042->19120|24764->19814|24807->19834|24901->19899|24935->19905|24985->19933|26262->21182|26304->21201|26398->21266|26431->21271|26481->21299|26599->21389|26643->21410|26737->21475|26770->21480|26820->21508|27550->22210|27593->22230|27687->22295|27719->22299|27769->22327|29032->23562|29074->23581|29168->23646|29201->23651|29251->23679|29369->23769|29413->23790|29507->23855|29540->23860|29590->23888|30309->24579|30352->24599|30446->24664|30479->24669|30529->24697|31788->25928|31830->25947|31924->26012|31958->26018|32008->26046|32126->26136|32170->26157|32264->26222|32297->26227|32347->26255|33066->26946|33109->26966|33203->27031|33236->27036|33286->27064|34631->28381|34673->28400|34767->28465|34802->28472|34853->28500|34971->28590|35015->28611|35109->28676|35143->28682|35193->28710|35915->29404|35958->29424|36052->29489|36086->29495|36136->29523|37413->30772|37455->30791|37549->30856|37582->30861|37632->30889|37750->30979|37794->31000|37888->31065|37921->31070|37971->31098|38701->31800|38744->31820|38838->31885|38870->31889|38920->31917|40184->33153|40226->33172|40320->33237|40353->33242|40403->33270|40521->33360|40565->33381|40659->33446|40692->33451|40742->33479|41461->34170|41504->34190|41598->34255|41631->34260|41681->34288|42940->35519|42982->35538|43076->35603|43110->35609|43160->35637|43278->35727|43322->35748|43416->35813|43449->35818|43499->35846|44218->36537|44261->36557|44355->36622|44388->36627|44438->36655|45783->37972|45825->37991|45919->38056|45954->38063|46005->38091|46123->38181|46167->38202|46261->38267|46295->38273|46345->38301|47067->38995|47110->39015|47204->39080|47238->39086|47288->39114|48565->40363|48607->40382|48701->40447|48734->40452|48784->40480|48902->40570|48946->40591|49040->40656|49073->40661|49123->40689|49853->41391|49896->41411|49990->41476|50022->41480|50072->41508|51205->42613|51256->42642|51338->42695|51924->43253|51972->43279|52054->43332|52676->43926|52717->43945|52747->43946|53419->44590|53472->44621|53566->44686|54215->45307|54265->45335|54359->45400|55004->46017|55059->46050|55153->46115|55794->46728|55865->46776|55959->46841|56600->47454|56646->47478|56740->47543|57632->48407|57671->48423|57798->48522|57840->48541|57967->48640|58008->48658|58135->48757|58179->48778|58306->48877|58348->48896|58475->48995|58518->49015|58645->49114|58684->49130|61078->51496|61120->51515|61214->51580|61247->51585|61297->51613|61415->51703|61459->51724|61553->51789|61586->51794|61636->51822|62355->52513|62398->52533|62492->52598|62525->52603|62575->52631|62841->52869|62887->52892|62918->52893|63101->53048|63145->53070|63175->53071|63628->53496|63673->53519|63704->53520|66060->55848|66098->55864|66128->55865|67769->57477|67815->57500|67921->57577|69130->58757|69175->58779|69281->58856|72465->62012|72507->62031|72613->62108|72747->62214|72788->62232|72894->62309|73016->62403|73072->62436|73178->62513|73957->63264|74013->63297|74044->63298|74991->64216|75039->64241|75145->64318|75178->64323|75229->64351|75549->64643|75592->64664|75698->64741|76381->65396|76431->65423|76537->65500|77220->66155|77268->66180|77374->66257|77998->66852|78040->66871|78150->66952|78183->66957|78234->66985|78369->67091|78413->67112|78523->67193|78556->67198|78607->67226|79439->68029|79482->68049|79592->68130|79625->68135|79676->68163|81043->69502|81081->69518|81111->69519|81758->70137|81801->70157|82118->70445|82168->70472|82431->70706|82477->70729|82508->70730|84675->72868|84720->72890|84830->72971|89735->77847|89781->77870|91993->80054|92049->80087|92080->80088|97755->85734|97799->85755|98974->86901|99024->86928|100203->88078|100251->88103|101429->89252|101478->89278|102868->90639|102919->90667|103533->91252|103584->91280|104295->91962|104347->91991|104961->92575|105013->92603|106066->93626|106110->93646|106217->93723|107042->20|107071->951|107103->94509|107134->94512
                  LINES: 27->1|31->3|31->3|33->3|34->4|37->7|37->7|38->8|38->8|38->8|39->9|45->15|45->15|46->16|46->16|46->16|47->17|49->19|49->19|51->21|51->21|52->22|53->23|53->23|54->24|54->24|55->25|55->25|56->26|56->26|59->32|59->32|61->32|62->33|63->34|63->34|65->36|66->37|66->37|67->38|72->43|72->43|72->43|78->49|78->49|79->50|81->52|81->52|81->52|82->53|82->53|82->53|83->54|83->54|83->54|90->61|90->61|91->62|93->64|93->64|93->64|94->65|94->65|95->66|95->66|95->66|96->67|96->67|96->67|97->68|97->68|97->68|106->77|106->77|112->83|112->83|113->84|124->95|124->95|125->96|140->111|140->111|141->112|162->133|162->133|172->143|172->143|172->143|172->143|172->143|172->143|179->150|179->150|180->151|180->151|192->163|192->163|193->164|200->171|200->171|200->171|207->178|207->178|208->179|215->186|215->186|216->187|228->199|228->199|229->200|229->200|230->201|230->201|231->202|231->202|232->203|232->203|249->220|249->220|250->221|250->221|250->221|251->222|251->222|252->223|252->223|252->223|259->230|259->230|260->231|260->231|260->231|274->245|274->245|275->246|275->246|275->246|276->247|276->247|277->248|277->248|277->248|284->255|284->255|285->256|285->256|285->256|300->271|300->271|301->272|301->272|301->272|302->273|302->273|303->274|303->274|303->274|310->281|310->281|311->282|311->282|311->282|325->296|325->296|326->297|326->297|326->297|327->298|327->298|328->299|328->299|328->299|335->306|335->306|336->307|336->307|336->307|350->321|350->321|351->322|351->322|351->322|352->323|352->323|353->324|353->324|353->324|360->331|360->331|361->332|361->332|361->332|375->346|375->346|376->347|376->347|376->347|377->348|377->348|378->349|378->349|378->349|385->356|385->356|386->357|386->357|386->357|401->372|401->372|402->373|402->373|402->373|403->374|403->374|404->375|404->375|404->375|411->382|411->382|412->383|412->383|412->383|426->397|426->397|427->398|427->398|427->398|428->399|428->399|429->400|429->400|429->400|436->407|436->407|437->408|437->408|437->408|452->423|452->423|453->424|453->424|453->424|454->425|454->425|455->426|455->426|455->426|462->433|462->433|463->434|463->434|463->434|477->448|477->448|478->449|478->449|478->449|479->450|479->450|480->451|480->451|480->451|487->458|487->458|488->459|488->459|488->459|503->474|503->474|504->475|504->475|504->475|505->476|505->476|506->477|506->477|506->477|513->484|513->484|514->485|514->485|514->485|528->499|528->499|529->500|529->500|529->500|530->501|530->501|531->502|531->502|531->502|538->509|538->509|539->510|539->510|539->510|556->527|556->527|557->528|564->535|564->535|565->536|572->543|572->543|572->543|579->550|579->550|580->551|587->558|587->558|588->559|595->566|595->566|596->567|603->574|603->574|604->575|611->582|611->582|612->583|624->595|624->595|625->596|625->596|626->597|626->597|627->598|627->598|628->599|628->599|629->600|629->600|630->601|630->601|653->624|653->624|654->625|654->625|654->625|655->626|655->626|656->627|656->627|656->627|663->634|663->634|664->635|664->635|664->635|667->638|667->638|667->638|669->640|669->640|669->640|672->643|672->643|672->643|698->669|698->669|698->669|711->682|711->682|712->683|725->696|725->696|726->697|758->729|758->729|759->730|760->731|760->731|761->732|762->733|762->733|763->734|768->739|768->739|768->739|778->749|778->749|779->750|779->750|779->750|782->753|782->753|783->754|790->761|790->761|791->762|798->769|798->769|799->770|805->776|805->776|806->777|806->777|806->777|807->778|807->778|808->779|808->779|808->779|815->786|815->786|816->787|816->787|816->787|831->802|831->802|831->802|836->807|836->807|839->810|839->810|842->813|842->813|842->813|862->833|862->833|863->834|902->873|902->873|923->894|923->894|923->894|972->943|972->943|982->953|982->953|992->963|992->963|1002->973|1002->973|1014->985|1014->985|1018->989|1018->989|1025->996|1025->996|1029->1000|1029->1000|1039->1010|1039->1010|1040->1011|1060->1|1062->29|1065->1030|1067->1032
                  -- GENERATED --
              */
          