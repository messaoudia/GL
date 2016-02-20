
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

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
                            """),format.raw/*15.29*/("""if(controler.substring(0,15) === 'AdminController')"""),format.raw/*15.80*/("""{"""),format.raw/*15.81*/("""
                                """),format.raw/*16.33*/("""var navBarTop = document.getElementById('navBarTop');
                                $(navBarTop).addClass('navbar-fixed-top-admin');
                                var menuButton = document.getElementById('menuButton');
                                $(menuButton).addClass('btn-danger');
                                var navHeader = document.getElementById('nav-header');
                                $(navHeader).addClass('nav-header-admin');

                            """),format.raw/*23.29*/("""}"""),format.raw/*23.30*/("""else"""),format.raw/*23.34*/("""{"""),format.raw/*23.35*/("""
                                """),format.raw/*24.33*/("""var navBarTop = document.getElementById('navBarTop');
                                $(navBarTop).removeClass('navbar-fixed-top-admin');
                                var menuButton = document.getElementById('menuButton');
                                $(menuButton).removeClass('btn-danger');
                                var navHeader = document.getElementById('nav-header');
                                $(navHeader).removeClass('nav-header-admin');
                            """),format.raw/*30.29*/("""}"""),format.raw/*30.30*/("""
                            """),format.raw/*31.29*/("""var result = $('#refresh',html);
                            $('#refresh').empty().html(result);
                        """),format.raw/*33.25*/("""}"""),format.raw/*33.26*/(""",
                        //Case we have a problem
                        error: function(errorMessage)"""),format.raw/*35.54*/("""{"""),format.raw/*35.55*/("""
                            """),format.raw/*36.29*/("""alert(errorMessage);
                        """),format.raw/*37.25*/("""}"""),format.raw/*37.26*/("""
                    """),format.raw/*38.21*/("""}"""),format.raw/*38.22*/(""");
                """),format.raw/*39.17*/("""}"""),format.raw/*39.18*/(""");
            """),format.raw/*40.13*/("""}"""),format.raw/*40.14*/(""");

            var getElementsByAttribute = function (attr, value) """),format.raw/*42.65*/("""{"""),format.raw/*42.66*/("""
                """),format.raw/*43.17*/("""var match = [];
                var elements = document.getElementsByTagName("*");

                for (var ii = 0, ln = elements.length; ii < ln; ii++) """),format.raw/*46.71*/("""{"""),format.raw/*46.72*/("""
                    """),format.raw/*47.21*/("""if (elements[ii].hasAttribute(attr)) """),format.raw/*47.58*/("""{"""),format.raw/*47.59*/("""
                        """),format.raw/*48.25*/("""if (value) """),format.raw/*48.36*/("""{"""),format.raw/*48.37*/("""
                            """),format.raw/*49.29*/("""if (elements[ii].getAttribute(attr) === value) """),format.raw/*49.76*/("""{"""),format.raw/*49.77*/("""
                                """),format.raw/*50.33*/("""match.push(elements[ii]);
                            """),format.raw/*51.29*/("""}"""),format.raw/*51.30*/("""
                        """),format.raw/*52.25*/("""}"""),format.raw/*52.26*/(""" """),format.raw/*52.27*/("""else """),format.raw/*52.32*/("""{"""),format.raw/*52.33*/("""
                            """),format.raw/*53.29*/("""/* Else, simply push it */
                            match.push(elements[ii]);
                        """),format.raw/*55.25*/("""}"""),format.raw/*55.26*/("""
                    """),format.raw/*56.21*/("""}"""),format.raw/*56.22*/("""
                """),format.raw/*57.17*/("""}"""),format.raw/*57.18*/("""
                """),format.raw/*58.17*/("""return match;
            """),format.raw/*59.13*/("""}"""),format.raw/*59.14*/(""";

            /* Afficher les clients archivés */
            function clientsArchived()"""),format.raw/*62.39*/("""{"""),format.raw/*62.40*/("""
                """),format.raw/*63.17*/("""// console.log("TEST checkbox");
                if($("#checkBoxClientsArchived").is(":checked")) """),format.raw/*64.66*/("""{"""),format.raw/*64.67*/("""
                    """),format.raw/*65.21*/("""// checkbox is checked
                    var table = document.getElementById("clientsTable");
                    $(table).find('tbody')
                            .append($('<tr>').attr('data-toggle','modal').attr('data-target','#myModal').attr('class','archived')
                                    .append($('<td>').text('ArchivedName'))
                                    .append($('<td>').text('ArchivedAdress'))
                                    .append($('<td>').text('ArchivedNbContacts'))
                                    .append($('<td>').text('ArchivedNbProjects'))
                                    .append($('<td>').text('ArchivedNbTasks'))
                                    .append($('<td>').text('ArchivedPriority'))
                                    .append($('<td>').append($('<i>').attr('class','fa fa-times-circle'))));

                    //console.log("CHECKED");
                """),format.raw/*78.17*/("""}"""),format.raw/*78.18*/(""" """),format.raw/*78.19*/("""else """),format.raw/*78.24*/("""{"""),format.raw/*78.25*/("""
                    """),format.raw/*79.21*/("""// checkbox is not checked
                    //console.log("NOT CHECKED");
                    $('.archived').hide();
                """),format.raw/*82.17*/("""}"""),format.raw/*82.18*/("""
            """),format.raw/*83.13*/("""}"""),format.raw/*83.14*/("""
    """),format.raw/*84.5*/("""</script>
""")))};def /*87.2*/content/*87.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*87.13*/("""
    """),format.raw/*88.5*/("""<div id="wrapper" class="ng-scope">
        """),_display_(/*89.10*/sidebar("Dashboard")),format.raw/*89.30*/("""

        """),format.raw/*91.9*/("""<div id="page-wrapper" class="gray-bg dashbard-1">

            """),_display_(/*93.14*/topbar()),format.raw/*93.22*/("""

            """),format.raw/*95.13*/("""<div id="refresh" >
                <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content">
                                <form id="form-notif">
                                    <h2>"""),_display_(/*101.42*/Messages("notifications")),format.raw/*101.67*/(""" """),format.raw/*101.68*/("""(2)</h2>
                                    <a class="btn btn-white btn-bitbucket"><i class="fa fa-eye"></i></a>
                                    <a class="btn btn-white btn-bitbucket"><i class="fa fa-trash"></i></a>
                                    <div class="table-responsive">
                                        <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="10">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th>"""),_display_(/*109.58*/Messages("from")),format.raw/*109.74*/("""</th>
                                                    <th>"""),_display_(/*110.58*/Messages("project")),format.raw/*110.77*/("""</th>
                                                    <th>"""),_display_(/*111.58*/Messages("client")),format.raw/*111.76*/("""</th>
                                                    <th>"""),_display_(/*112.58*/Messages("object")),format.raw/*112.76*/("""</th>
                                                    <th>"""),_display_(/*113.58*/Messages("date")),format.raw/*113.74*/("""</th>
                                                    <th data-hide="all">"""),_display_(/*114.74*/Messages("state")),format.raw/*114.91*/("""</th>
                                                    <th data-hide="all">"""),_display_(/*115.74*/Messages("message")),format.raw/*115.93*/("""</th>
                                                    <th data-hide="all">"""),_display_(/*116.74*/Messages("link")),format.raw/*116.90*/("""</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr id="notif-1" class="non-lu">
                                                    <td>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input id="checkbox-notif-1" type="checkbox" onclick="clickOnCheckboxNotification('checkbox-notif-1','notif-1')">
                                                            <label for="checkbox-notif-1"></label>
                                                        </div>
                                                    </td>
                                                    <td>Organiser une réunion</td>
                                                    <td>myProjects</td>
                                                    <td>PoPS5I Inc.</td>
                                                    <td>Modification des interlocuteurs externes</td>
                                                    <td>06/02/2016 (15:15)</td>
                                                    <td>"""),_display_(/*132.58*/Messages("unread")),format.raw/*132.76*/("""</td>
                                                    <td>
                                                        <p>Nouveau interlocuteur externe : Frédéric Voisin</p>
                                                    </td>
                                                    <td>
                                                        <p><a href="#">Cliquer ici pour accéder au détail</a></p>
                                                    </td>
                                                </tr>
                                                <tr id="notif-2" class="lu">
                                                    <td>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input id="checkbox-notif-2" type="checkbox" onclick="clickOnCheckboxNotification('checkbox-notif-2','notif-2')">
                                                            <label for="checkbox-notif-2"></label>
                                                        </div>
                                                    </td>
                                                    <td>Créer une base de données</td>
                                                    <td>Big Data</td>
                                                    <td>Auchan</td>
                                                    <td>Modification de l'avancement</td>
                                                    <td>06/02/2016 (14:35)</td>
                                                    <td>"""),_display_(/*152.58*/Messages("read")),format.raw/*152.74*/("""</td>
                                                    <td>
                                                        <p>Amin a modifié l'avancement de la tâche "Créer une base de données"</p>
                                                        <p>Charge consommée : 10h</p>
                                                        <p>Charge restante : 20h</p>
                                                        <p>Pourcentage d'avancement : 33%</p>
                                                    </td>
                                                    <td>
                                                        <p><a href="#">Cliquer ici pour accéder au détail</a></p>
                                                    </td>
                                                </tr>
                                                <tr id="notif-3" class="non-lu">
                                                    <td>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input id="checkbox-notif-3" type="checkbox" onclick="clickOnCheckboxNotification('checkbox-notif-3','notif-3')">
                                                            <label for="checkbox-notif-3"></label>
                                                        </div>
                                                    </td>
                                                    <td>Organiser une réunion</td>
                                                    <td>myProjects</td>
                                                    <td>PoPS5I Inc.</td>
                                                    <td>Modification des interlocuteurs externes</td>
                                                    <td>06/02/2016 (15:15)</td>
                                                    <td>"""),_display_(/*175.58*/Messages("unread")),format.raw/*175.76*/("""</td>
                                                    <td>
                                                        <p>Nouveau interlocuteur externe : Frédéric Voisin</p>
                                                    </td>
                                                    <td>
                                                        <p><a href="#">Cliquer ici pour accéder au détail</a></p>
                                                    </td>
                                                </tr>
                                                <tr id="notif-4" class="lu">
                                                    <td>
                                                        <div class="checkbox checkbox-success checkbox-inline">
                                                            <input id="checkbox-notif-4" type="checkbox" onclick="clickOnCheckboxNotification('checkbox-notif-4','notif-4')">
                                                            <label for="checkbox-notif-4"></label>
                                                        </div>
                                                    </td>
                                                    <td>Créer une base de données</td>
                                                    <td>Big Data</td>
                                                    <td>Auchan</td>
                                                    <td>Modification de l'avancement</td>
                                                    <td>06/02/2016 (14:35)</td>
                                                    <td>"""),_display_(/*195.58*/Messages("read")),format.raw/*195.74*/("""</td>
                                                    <td>
                                                        <p>Amin a modifié l'avancement de la tâche "Créer une base de données"</p>
                                                        <p>Charge consommée : 10h</p>
                                                        <p>Charge restante : 20h</p>
                                                        <p>Pourcentage d'avancement : 33%</p>
                                                    </td>
                                                    <td>
                                                        <p><a href="#">Cliquer ici pour accéder au détail</a></p>
                                                    </td>
                                                </tr>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <td colspan="5">
                                                        <ul class="pagination pull-right"></ul>
                                                    </td>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

            <!-- Partie droite, les settings -->
        <div id="right-sidebar">
            <div class="sidebar-container">
                <div class="changePassword">
                    <form role="form">
                        <div class="form-group previousPassword">
                            <label for="previousPassword">"""),_display_(/*230.60*/Messages("previousPassword")),format.raw/*230.88*/("""</label>
                            <input type="password" id="previousPassword" class="form-control">
                        </div>
                        <div class="form-group newPassword">
                            <label for="newPassword">"""),_display_(/*234.55*/Messages("newPassword")),format.raw/*234.78*/("""</label>
                            <input type="password" id="newPassword" class="form-control">
                        </div>
                        <div class="form-group newPasswordConfirm">
                            <label for="newPasswordConfirm">"""),_display_(/*238.62*/Messages("newPasswordConfirm")),format.raw/*238.92*/("""</label>
                            <input type="password" id="newPasswordConfirm" class="form-control">
                        </div>
                        <div class="validateForm">
                            <button class="btn btn-user btn-block" type="submit" onclick>"""),_display_(/*242.91*/Messages("validateForm")),format.raw/*242.115*/("""  """),format.raw/*242.117*/("""<i class="fa fa-check"></i></button>
                        </div>
                    </form>
                </div>

                <div class="notificationFrom">
                    <p>"""),_display_(/*248.25*/Messages("titleNotificationFrom")),format.raw/*248.58*/("""</p>
                    <div>
                            <!--TODO : auto recherche -->
                        <input type="text" id="searchContact" class="form-control z-index-3"/>
                    </div>

                    <div class="list-personnes-notifiees">
                        <table class="table-bordered">
                            <tbody>
                                <tr>
                                    <td class="first-td">Yasser Rabi - yasser.rabi&commat;gmail.com</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="first-td">Yasser Rabi - yasser.rabi&commat;gmail.com</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="first-td">Yasser Rabi - yasser.rabi&commat;gmail.com</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                </tr>
                                <tr>
                                    <td class="first-td">Yasser Rabi - yasser.rabi&commat;gmail.com</td>
                                    <td class="td-btn-suppr" style="vertical-align:middle;"><i class="fa fa-times"></i></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="notificationSettings">
                    <div class="checkbox checkbox-success checkbox-circle">
                        <input id="checkbox-changes" type="checkbox">
                        <label for="checkbox-changes">
                        """),_display_(/*282.26*/Messages("checkbox-changes")),format.raw/*282.54*/("""
                        """),format.raw/*283.25*/("""</label>
                    </div>
                    <div class="checkbox checkbox-success checkbox-circle">
                        <input id="checkbox-tasks-almost-finish" type="checkbox" >
                        <label for="checkbox-tasks-almost-finish">
                        """),_display_(/*288.26*/Messages("checkbox-tasks-almost-finish")),format.raw/*288.66*/("""
                        """),format.raw/*289.25*/("""</label>
                    </div>
                    <div class="checkbox checkbox-success checkbox-circle">
                        <input id="checkbox-tasks-late" type="checkbox" checked>
                        <label for="checkbox-tasks-late">
                        """),_display_(/*294.26*/Messages("checkbox-tasks-late")),format.raw/*294.57*/("""
                        """),format.raw/*295.25*/("""</label>
                    </div>
                </div>
            </div>
        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*85.2*/("""

"""),format.raw/*301.2*/("""

"""),_display_(/*303.2*/main(pageTitle, content, scripts)),format.raw/*303.35*/("""
"""))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/index.scala.html
                  HASH: dbc50ad2c60a8362de8cad34984cfeb6c5b1d15b
                  MATRIX: 745->1|842->23|856->30|936->34|967->39|1044->89|1072->90|1116->107|1180->144|1208->145|1256->166|1608->490|1637->491|1690->516|1742->540|1771->541|1828->570|1907->621|1936->622|1997->655|2509->1139|2538->1140|2570->1144|2599->1145|2660->1178|3180->1670|3209->1671|3266->1700|3415->1821|3444->1822|3576->1926|3605->1927|3662->1956|3735->2001|3764->2002|3813->2023|3842->2024|3889->2043|3918->2044|3961->2059|3990->2060|4086->2128|4115->2129|4160->2146|4342->2300|4371->2301|4420->2322|4485->2359|4514->2360|4567->2385|4606->2396|4635->2397|4692->2426|4767->2473|4796->2474|4857->2507|4939->2561|4968->2562|5021->2587|5050->2588|5079->2589|5112->2594|5141->2595|5198->2624|5331->2729|5360->2730|5409->2751|5438->2752|5483->2769|5512->2770|5557->2787|5611->2813|5640->2814|5757->2903|5786->2904|5831->2921|5957->3019|5986->3020|6035->3041|6981->3959|7010->3960|7039->3961|7072->3966|7101->3967|7150->3988|7314->4124|7343->4125|7384->4138|7413->4139|7445->4144|7479->4158|7494->4165|7575->4169|7607->4174|7679->4219|7720->4239|7757->4249|7849->4314|7878->4322|7920->4336|8256->4644|8303->4669|8333->4670|8997->5306|9035->5322|9126->5385|9167->5404|9258->5467|9298->5485|9389->5548|9429->5566|9520->5629|9558->5645|9665->5724|9704->5741|9811->5820|9852->5839|9959->5918|9997->5934|11301->7210|11341->7228|12976->8835|13014->8851|14953->10762|14993->10780|16628->12387|16666->12403|18600->14309|18650->14337|18928->14587|18973->14610|19260->14869|19312->14899|19618->15177|19665->15201|19697->15203|19916->15394|19971->15427|21979->17407|22029->17435|22083->17460|22398->17747|22460->17787|22514->17812|22818->18088|22871->18119|22925->18144|23069->20|23098->4155|23128->18249|23158->18252|23213->18285
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|46->16|53->23|53->23|53->23|53->23|54->24|60->30|60->30|61->31|63->33|63->33|65->35|65->35|66->36|67->37|67->37|68->38|68->38|69->39|69->39|70->40|70->40|72->42|72->42|73->43|76->46|76->46|77->47|77->47|77->47|78->48|78->48|78->48|79->49|79->49|79->49|80->50|81->51|81->51|82->52|82->52|82->52|82->52|82->52|83->53|85->55|85->55|86->56|86->56|87->57|87->57|88->58|89->59|89->59|92->62|92->62|93->63|94->64|94->64|95->65|108->78|108->78|108->78|108->78|108->78|109->79|112->82|112->82|113->83|113->83|114->84|115->87|115->87|117->87|118->88|119->89|119->89|121->91|123->93|123->93|125->95|131->101|131->101|131->101|139->109|139->109|140->110|140->110|141->111|141->111|142->112|142->112|143->113|143->113|144->114|144->114|145->115|145->115|146->116|146->116|162->132|162->132|182->152|182->152|205->175|205->175|225->195|225->195|260->230|260->230|264->234|264->234|268->238|268->238|272->242|272->242|272->242|278->248|278->248|312->282|312->282|313->283|318->288|318->288|319->289|324->294|324->294|325->295|332->1|334->85|336->301|338->303|338->303
                  -- GENERATED --
              */
          