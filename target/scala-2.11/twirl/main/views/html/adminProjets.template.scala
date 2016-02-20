
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminProjets_Scope0 {
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

class adminProjets extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

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


""")))};def /*43.2*/content/*43.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*43.13*/("""
    """),format.raw/*44.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*45.10*/sidebar("ProjetAdmin")),format.raw/*45.32*/("""

        """),format.raw/*47.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">
            """),_display_(/*48.14*/topbar()),format.raw/*48.22*/("""
            """),format.raw/*49.13*/("""<div id="refresh" >
                <div class="ibox-content">
                    <div class="panel-body" style="padding-top:10px;">
                        <div class="row row-options-admin-projet">
                            <div class="col-sm-3">
                                <div class="checkbox checkbox-success checkbox-circle">
                                    <input id="checkbox-projet-admin-projets-termines" type="checkbox">
                                    <label for="checkbox-projet-admin-projets-termines">
                                    """),_display_(/*57.38*/Messages("completedProjects")),format.raw/*57.67*/("""
                                    """),format.raw/*58.37*/("""</label>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="checkbox checkbox-success checkbox-circle">
                                    <input id="checkbox-projet-admin-projets-archives" type="checkbox">
                                    <label for="checkbox-projet-admin-projets-archives">
                                    """),_display_(/*65.38*/Messages("archivedProjects")),format.raw/*65.66*/("""
                                    """),format.raw/*66.37*/("""</label>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive table-responsive-admin-projet">
                            <table id="dataTables-admin-projet" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr class="table-center">
                                        <th style="vertical-align:middle;">"""),_display_(/*74.77*/Messages("project")),format.raw/*74.96*/("""</th>
                                        <th style="vertical-align:middle;">"""),_display_(/*75.77*/Messages("client")),format.raw/*75.95*/("""</th>
                                        <th style="vertical-align:middle;">"""),_display_(/*76.77*/Messages("startDate")),format.raw/*76.98*/("""</th>
                                        <th style="vertical-align:middle;">"""),_display_(/*77.77*/Messages("endDate")),format.raw/*77.96*/("""</th>
                                        <th style="vertical-align:middle;">"""),_display_(/*78.77*/Messages("archived")),format.raw/*78.97*/("""</th>
                                        <th style="vertical-align:middle;">"""),_display_(/*79.77*/Messages("workload")),format.raw/*79.97*/("""</th>
                                        <th><i class="fa fa-trash"></i></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">
                                            myProjects
                                        </td>
                                        <td style="vertical-align:middle;">PoPS5I Inc.</td>
                                        <td style="vertical-align:middle;">10/10/2015</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2017/10/01</p>
                                            <p>01/10/2017</p>
                                            <p>10/10/2017</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">060%</p>
                                            <p class="row-initiale">"""),_display_(/*98.70*/Messages("initial")),format.raw/*98.89*/(""" """),format.raw/*98.90*/(""": 50"""),_display_(/*98.95*/Messages("day-first-letter")),format.raw/*98.123*/("""</p>
                                            <p class="row-restante">"""),_display_(/*99.70*/Messages("remaining")),format.raw/*99.91*/(""" """),format.raw/*99.92*/(""": 30"""),_display_(/*99.97*/Messages("day-first-letter")),format.raw/*99.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                                    60%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*106.71*/Messages("consumed")),format.raw/*106.91*/(""" """),format.raw/*106.92*/(""": 30"""),_display_(/*106.97*/Messages("day-first-letter")),format.raw/*106.125*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">EISD</td>
                                        <td style="vertical-align:middle;">Lavergne Inc.</td>
                                        <td style="vertical-align:middle;">20/12/2015</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/03/03</p>
                                            <p>03/03/2016</p>
                                            <p>13/03/2016</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">050%</p>
                                            <p class="row-initiale">"""),_display_(/*122.70*/Messages("initial")),format.raw/*122.89*/(""" """),format.raw/*122.90*/(""": 100"""),_display_(/*122.96*/Messages("day-first-letter")),format.raw/*122.124*/("""</p>
                                            <p class="row-restante">"""),_display_(/*123.70*/Messages("remaining")),format.raw/*123.91*/(""" """),format.raw/*123.92*/(""": 50"""),_display_(/*123.97*/Messages("day-first-letter")),format.raw/*123.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
                                                    50%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*130.71*/Messages("consumed")),format.raw/*130.91*/(""" """),format.raw/*130.92*/(""": 50"""),_display_(/*130.97*/Messages("day-first-letter")),format.raw/*130.125*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">Développer une application mobile</td>
                                        <td style="vertical-align:middle;">LePhocéen</td>
                                        <td style="vertical-align:middle;">01/10/2013</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2017/10/01</p>
                                            <p>01/10/2017</p>
                                            <p>10/10/2017</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">100%</p>
                                            <p class="row-initiale">"""),_display_(/*146.70*/Messages("initial")),format.raw/*146.89*/(""" """),format.raw/*146.90*/(""": 3501"""),_display_(/*146.97*/Messages("day-first-letter")),format.raw/*146.125*/("""</p>
                                            <p class="row-restante">"""),_display_(/*147.70*/Messages("remaining")),format.raw/*147.91*/(""" """),format.raw/*147.92*/(""": 300"""),_display_(/*147.98*/Messages("day-first-letter")),format.raw/*147.126*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                                    100%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*154.71*/Messages("consumed")),format.raw/*154.91*/(""" """),format.raw/*154.92*/(""": 310"""),_display_(/*154.98*/Messages("day-first-letter")),format.raw/*154.126*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">Gagner un match</td>
                                        <td style="vertical-align:middle;">Olympique de Marseille</td>
                                        <td style="vertical-align:middle;">09/03/2016</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/03/19</p>
                                            <p>19/03/2016</p>
                                            <p>23/03/2016</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">0%</p>
                                            <p class="row-initiale">"""),_display_(/*170.70*/Messages("initial")),format.raw/*170.89*/(""" """),format.raw/*170.90*/(""": 10"""),_display_(/*170.95*/Messages("day-first-letter")),format.raw/*170.123*/("""</p>
                                            <p class="row-restante">"""),_display_(/*171.70*/Messages("remaining")),format.raw/*171.91*/(""" """),format.raw/*171.92*/(""": 10"""),_display_(/*171.97*/Messages("day-first-letter")),format.raw/*171.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%; color:black;">
                                                    0%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*178.71*/Messages("consumed")),format.raw/*178.91*/(""" """),format.raw/*178.92*/(""": 0"""),_display_(/*178.96*/Messages("day-first-letter")),format.raw/*178.124*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">myProjects</td>
                                        <td style="vertical-align:middle;">PoPS5I Inc.</td>
                                        <td style="vertical-align:middle;">10/10/2015</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/04/03</p>
                                            <p>03/04/2016</p>
                                            <p>13/06/2016</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">060%</p>
                                            <p class="row-initiale">"""),_display_(/*194.70*/Messages("initial")),format.raw/*194.89*/(""" """),format.raw/*194.90*/(""": 50"""),_display_(/*194.95*/Messages("day-first-letter")),format.raw/*194.123*/("""</p>
                                            <p class="row-restante">"""),_display_(/*195.70*/Messages("remaining")),format.raw/*195.91*/(""" """),format.raw/*195.92*/(""": 30"""),_display_(/*195.97*/Messages("day-first-letter")),format.raw/*195.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                                    60%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*202.71*/Messages("consumed")),format.raw/*202.91*/(""" """),format.raw/*202.92*/(""": 30"""),_display_(/*202.97*/Messages("day-first-letter")),format.raw/*202.125*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">EISD</td>
                                        <td style="vertical-align:middle;">Lavergne Inc.</td>
                                        <td style="vertical-align:middle;">20/12/2015</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/03/02</p>
                                            <p>02/03/2016</p>
                                            <p>02/03/2016</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">050%</p>
                                            <p class="row-initiale">"""),_display_(/*218.70*/Messages("initial")),format.raw/*218.89*/(""" """),format.raw/*218.90*/(""": 100"""),_display_(/*218.96*/Messages("day-first-letter")),format.raw/*218.124*/("""</p>
                                            <p class="row-restante">"""),_display_(/*219.70*/Messages("remaining")),format.raw/*219.91*/(""" """),format.raw/*219.92*/(""": 50"""),_display_(/*219.97*/Messages("day-first-letter")),format.raw/*219.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
                                                    50%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*226.71*/Messages("consumed")),format.raw/*226.91*/(""" """),format.raw/*226.92*/(""": 50"""),_display_(/*226.97*/Messages("day-first-letter")),format.raw/*226.125*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">Développer une application mobile</td>
                                        <td style="vertical-align:middle;">LePhocéen</td>
                                        <td style="vertical-align:middle;">01/10/2013</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2017/10/01</p>
                                            <p>01/10/2017</p>
                                            <p>10/10/2017</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">100%</p>
                                            <p class="row-initiale">"""),_display_(/*242.70*/Messages("initial")),format.raw/*242.89*/(""" """),format.raw/*242.90*/(""": 3501"""),_display_(/*242.97*/Messages("day-first-letter")),format.raw/*242.125*/("""</p>
                                            <p class="row-restante">"""),_display_(/*243.70*/Messages("remaining")),format.raw/*243.91*/(""" """),format.raw/*243.92*/(""": 300"""),_display_(/*243.98*/Messages("day-first-letter")),format.raw/*243.126*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                                    100%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*250.71*/Messages("consumed")),format.raw/*250.91*/(""" """),format.raw/*250.92*/(""": 310"""),_display_(/*250.98*/Messages("day-first-letter")),format.raw/*250.126*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">Gagner un match</td>
                                        <td style="vertical-align:middle;">Olympique de Marseille</td>
                                        <td style="vertical-align:middle;">09/03/2016</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/05/03</p>
                                            <p>03/05/2016</p>
                                            <p>13/05/2016</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">0%</p>
                                            <p class="row-initiale">"""),_display_(/*266.70*/Messages("initial")),format.raw/*266.89*/(""" """),format.raw/*266.90*/(""": 10"""),_display_(/*266.95*/Messages("day-first-letter")),format.raw/*266.123*/("""</p>
                                            <p class="row-restante">"""),_display_(/*267.70*/Messages("remaining")),format.raw/*267.91*/(""" """),format.raw/*267.92*/(""": 10"""),_display_(/*267.97*/Messages("day-first-letter")),format.raw/*267.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%; color:black;">
                                                    0%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*274.71*/Messages("consumed")),format.raw/*274.91*/(""" """),format.raw/*274.92*/(""": 0"""),_display_(/*274.96*/Messages("day-first-letter")),format.raw/*274.124*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>

                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">myProjects</td>
                                        <td style="vertical-align:middle;">PoPS5I Inc.</td>
                                        <td style="vertical-align:middle;">10/10/2015</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/11/20</p>
                                            <p>20/11/2016</p>
                                            <p>23/12/2016</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">060%</p>
                                            <p class="row-initiale">"""),_display_(/*291.70*/Messages("initial")),format.raw/*291.89*/(""" """),format.raw/*291.90*/(""": 50"""),_display_(/*291.95*/Messages("day-first-letter")),format.raw/*291.123*/("""</p>
                                            <p class="row-restante">"""),_display_(/*292.70*/Messages("remaining")),format.raw/*292.91*/(""" """),format.raw/*292.92*/(""": 30"""),_display_(/*292.97*/Messages("day-first-letter")),format.raw/*292.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                                                    60%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*299.71*/Messages("consumed")),format.raw/*299.91*/(""" """),format.raw/*299.92*/(""": 30"""),_display_(/*299.97*/Messages("day-first-letter")),format.raw/*299.125*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">EISD</td>
                                        <td style="vertical-align:middle;">Lavergne Inc.</td>
                                        <td style="vertical-align:middle;">20/12/2015</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/01/01</p>
                                            <p>01/01/2016</p>
                                            <p>01/01/2017</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">050%</p>
                                            <p class="row-initiale">"""),_display_(/*315.70*/Messages("initial")),format.raw/*315.89*/(""" """),format.raw/*315.90*/(""": 100"""),_display_(/*315.96*/Messages("day-first-letter")),format.raw/*315.124*/("""</p>
                                            <p class="row-restante">"""),_display_(/*316.70*/Messages("remaining")),format.raw/*316.91*/(""" """),format.raw/*316.92*/(""": 50"""),_display_(/*316.97*/Messages("day-first-letter")),format.raw/*316.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
                                                    50%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*323.71*/Messages("consumed")),format.raw/*323.91*/(""" """),format.raw/*323.92*/(""": 50"""),_display_(/*323.97*/Messages("day-first-letter")),format.raw/*323.125*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">Développer une application mobile</td>
                                        <td style="vertical-align:middle;">LePhocéen</td>
                                        <td style="vertical-align:middle;">01/10/2013</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/05/04</p>
                                            <p>04/05/2016</p>
                                            <p>07/02/2018</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">100%</p>
                                            <p class="row-initiale">"""),_display_(/*339.70*/Messages("initial")),format.raw/*339.89*/(""" """),format.raw/*339.90*/(""": 3501"""),_display_(/*339.97*/Messages("day-first-letter")),format.raw/*339.125*/("""</p>
                                            <p class="row-restante">"""),_display_(/*340.70*/Messages("remaining")),format.raw/*340.91*/(""" """),format.raw/*340.92*/(""": 300"""),_display_(/*340.98*/Messages("day-first-letter")),format.raw/*340.126*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
                                                    100%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*347.71*/Messages("consumed")),format.raw/*347.91*/(""" """),format.raw/*347.92*/(""": 310"""),_display_(/*347.98*/Messages("day-first-letter")),format.raw/*347.126*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                    <tr class="table-center">
                                        <td style="vertical-align:middle;">Gagner un match</td>
                                        <td style="vertical-align:middle;">Olympique de Marseille</td>
                                        <td style="vertical-align:middle;">09/03/2016</td>
                                        <td style="vertical-align:middle;">
                                            <p style="display:none;">2016/03/03</p>
                                            <p>03/03/2016</p>
                                            <p>13/03/2016</p>
                                        </td>
                                        <td style="vertical-align:middle;">Non</td>
                                        <td class="td-avancement" style="vertical-align:middle;">
                                            <p style="display:none;">0%</p>
                                            <p class="row-initiale">"""),_display_(/*363.70*/Messages("initial")),format.raw/*363.89*/(""" """),format.raw/*363.90*/(""": 10"""),_display_(/*363.95*/Messages("day-first-letter")),format.raw/*363.123*/("""</p>
                                            <p class="row-restante">"""),_display_(/*364.70*/Messages("remaining")),format.raw/*364.91*/(""" """),format.raw/*364.92*/(""": 10"""),_display_(/*364.97*/Messages("day-first-letter")),format.raw/*364.125*/("""</p>
                                            <div class="progress progress-bar-default">
                                                    <!-- si 0% : color:black; -->
                                                <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%; color:black;">
                                                    0%
                                                </div>
                                            </div>
                                            <p class="row-consommee">"""),_display_(/*371.71*/Messages("consumed")),format.raw/*371.91*/(""" """),format.raw/*371.92*/(""": 0"""),_display_(/*371.96*/Messages("day-first-letter")),format.raw/*371.124*/("""</p>
                                        </td>
                                        <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*41.2*/("""

"""),format.raw/*385.2*/("""

"""),_display_(/*387.2*/main(pageTitle,content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object adminProjets extends adminProjets_Scope0.adminProjets
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/adminProjets.scala.html
                  HASH: 3e335bed766a4e30355309c4b72a3714d597173e
                  MATRIX: 759->1|856->23|870->30|950->34|981->39|1058->89|1086->90|1130->107|1194->144|1222->145|1270->166|1622->490|1651->491|1704->516|1756->540|1785->541|1842->570|1991->691|2020->692|2152->796|2181->797|2238->826|2311->871|2340->872|2389->893|2418->894|2465->913|2494->914|2567->959|2596->960|2645->981|2703->1011|2732->1012|2818->1070|2847->1071|2896->1092|3330->1498|3359->1499|3404->1516|3458->1542|3487->1543|3530->1566|3545->1573|3626->1577|3658->1582|3730->1627|3773->1649|3810->1659|3901->1723|3930->1731|3971->1744|4568->2314|4618->2343|4683->2380|5162->2832|5211->2860|5276->2897|5800->3394|5840->3413|5949->3495|5988->3513|6097->3595|6139->3616|6248->3698|6288->3717|6397->3799|6438->3819|6547->3901|6588->3921|7902->5208|7942->5227|7971->5228|8003->5233|8053->5261|8154->5335|8196->5356|8225->5357|8257->5362|8307->5390|8913->5968|8955->5988|8985->5989|9018->5994|9069->6022|10310->7235|10351->7254|10381->7255|10415->7261|10466->7289|10568->7363|10611->7384|10641->7385|10674->7390|10725->7418|11331->7996|11373->8016|11403->8017|11436->8022|11487->8050|12753->9288|12794->9307|12824->9308|12859->9315|12910->9343|13012->9417|13055->9438|13085->9439|13119->9445|13170->9473|13779->10054|13821->10074|13851->10075|13885->10081|13936->10109|15195->11340|15236->11359|15266->11360|15299->11365|15350->11393|15452->11467|15495->11488|15525->11489|15558->11494|15609->11522|16225->12110|16267->12130|16297->12131|16329->12135|16380->12163|17625->13380|17666->13399|17696->13400|17729->13405|17780->13433|17882->13507|17925->13528|17955->13529|17988->13534|18039->13562|18645->14140|18687->14160|18717->14161|18750->14166|18801->14194|20042->15407|20083->15426|20113->15427|20147->15433|20198->15461|20300->15535|20343->15556|20373->15557|20406->15562|20457->15590|21063->16168|21105->16188|21135->16189|21168->16194|21219->16222|22485->17460|22526->17479|22556->17480|22591->17487|22642->17515|22744->17589|22787->17610|22817->17611|22851->17617|22902->17645|23511->18226|23553->18246|23583->18247|23617->18253|23668->18281|24927->19512|24968->19531|24998->19532|25031->19537|25082->19565|25184->19639|25227->19660|25257->19661|25290->19666|25341->19694|25957->20282|25999->20302|26029->20303|26061->20307|26112->20335|27358->21553|27399->21572|27429->21573|27462->21578|27513->21606|27615->21680|27658->21701|27688->21702|27721->21707|27772->21735|28378->22313|28420->22333|28450->22334|28483->22339|28534->22367|29775->23580|29816->23599|29846->23600|29880->23606|29931->23634|30033->23708|30076->23729|30106->23730|30139->23735|30190->23763|30796->24341|30838->24361|30868->24362|30901->24367|30952->24395|32218->25633|32259->25652|32289->25653|32324->25660|32375->25688|32477->25762|32520->25783|32550->25784|32584->25790|32635->25818|33244->26399|33286->26419|33316->26420|33350->26426|33401->26454|34660->27685|34701->27704|34731->27705|34764->27710|34815->27738|34917->27812|34960->27833|34990->27834|35023->27839|35074->27867|35690->28455|35732->28475|35762->28476|35794->28480|35845->28508|36313->20|36342->1563|36372->28937|36402->28940
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|49->19|49->19|50->20|51->21|51->21|52->22|52->22|53->23|53->23|55->25|55->25|56->26|57->27|57->27|60->30|60->30|61->31|65->35|65->35|66->36|67->37|67->37|71->43|71->43|73->43|74->44|75->45|75->45|77->47|78->48|78->48|79->49|87->57|87->57|88->58|95->65|95->65|96->66|104->74|104->74|105->75|105->75|106->76|106->76|107->77|107->77|108->78|108->78|109->79|109->79|128->98|128->98|128->98|128->98|128->98|129->99|129->99|129->99|129->99|129->99|136->106|136->106|136->106|136->106|136->106|152->122|152->122|152->122|152->122|152->122|153->123|153->123|153->123|153->123|153->123|160->130|160->130|160->130|160->130|160->130|176->146|176->146|176->146|176->146|176->146|177->147|177->147|177->147|177->147|177->147|184->154|184->154|184->154|184->154|184->154|200->170|200->170|200->170|200->170|200->170|201->171|201->171|201->171|201->171|201->171|208->178|208->178|208->178|208->178|208->178|224->194|224->194|224->194|224->194|224->194|225->195|225->195|225->195|225->195|225->195|232->202|232->202|232->202|232->202|232->202|248->218|248->218|248->218|248->218|248->218|249->219|249->219|249->219|249->219|249->219|256->226|256->226|256->226|256->226|256->226|272->242|272->242|272->242|272->242|272->242|273->243|273->243|273->243|273->243|273->243|280->250|280->250|280->250|280->250|280->250|296->266|296->266|296->266|296->266|296->266|297->267|297->267|297->267|297->267|297->267|304->274|304->274|304->274|304->274|304->274|321->291|321->291|321->291|321->291|321->291|322->292|322->292|322->292|322->292|322->292|329->299|329->299|329->299|329->299|329->299|345->315|345->315|345->315|345->315|345->315|346->316|346->316|346->316|346->316|346->316|353->323|353->323|353->323|353->323|353->323|369->339|369->339|369->339|369->339|369->339|370->340|370->340|370->340|370->340|370->340|377->347|377->347|377->347|377->347|377->347|393->363|393->363|393->363|393->363|393->363|394->364|394->364|394->364|394->364|394->364|401->371|401->371|401->371|401->371|401->371|416->1|418->41|420->385|422->387
                  -- GENERATED --
              */
          