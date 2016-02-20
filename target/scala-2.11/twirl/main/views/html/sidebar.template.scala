
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object sidebar_Scope0 {
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

class sidebar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(menu:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.15*/("""

"""),format.raw/*3.1*/("""<div class="ng-scope">
    <nav class="navbar-default navbar-static-side ng-scope" role="navigation">
        <div id="sidebar" class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li id="nav-header" class="nav-header">
                    <div>
                        <span><img alt="image" class="img-circle" src="img/profile_small.jpg" /></span>
                        <span class="block m-t-xs" style="color:white ;"> <strong class="font-bold">
                                    David Williams</strong> </span>
                    </div>
                </li>
                """),_display_(/*14.18*/if(menu.equals("Dashboard"))/*14.46*/ {_display_(Seq[Any](format.raw/*14.48*/("""
                    """),format.raw/*15.21*/("""<li class="liclickable active sidebar-btn-green" data-infos="DashboardController.afficherDashboard()">
                        <a ><img src="img/MyIcons/png/map158.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Dashboard</span></a>
                    </li>
                """)))}/*19.19*/else/*19.24*/{_display_(Seq[Any](format.raw/*19.25*/("""
                    """),format.raw/*20.21*/("""<li class="liclickable sidebar-btn-green" data-infos="DashboardController.afficherDashboard()">
                        <a ><img src="img/MyIcons/png/map158.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Dashboard</span></a>
                    </li>
                """)))}),format.raw/*24.18*/("""

                """),_display_(/*26.18*/if(menu.equals("Projet"))/*26.43*/ {_display_(Seq[Any](format.raw/*26.45*/("""
                    """),format.raw/*27.21*/("""<li class="liclickable active sidebar-btn-green" data-infos="ProjetController.afficherProjets()">
                        <a><img src="img/MyIcons/png/bars62.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Projets</span></a>
                    </li>
                """)))}/*31.19*/else/*31.24*/{_display_(Seq[Any](format.raw/*31.25*/("""
                    """),format.raw/*32.21*/("""<li class="liclickable sidebar-btn-green" data-infos="ProjetController.afficherProjets()">
                        <a><img src="img/MyIcons/png/bars62.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Projets</span></a>
                    </li>
                """)))}),format.raw/*36.18*/("""

                """),_display_(/*38.18*/if(menu.equals("Client"))/*38.43*/ {_display_(Seq[Any](format.raw/*38.45*/("""
                    """),format.raw/*39.21*/("""<li class="liclickable active sidebar-btn-green" data-infos="ClientController.afficherClients()">
                        <a ><img src="img/MyIcons/png/team2.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Clients</span></a>
                    </li>
                """)))}/*43.19*/else/*43.24*/{_display_(Seq[Any](format.raw/*43.25*/("""
                    """),format.raw/*44.21*/("""<li class="liclickable sidebar-btn-green" data-infos="ClientController.afficherClients()">
                        <a ><img src="img/MyIcons/png/team2.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Clients</span></a>
                    </li>
                """)))}),format.raw/*48.18*/("""

                """),_display_(/*50.18*/if(menu.equals("CreerProjet"))/*50.48*/ {_display_(Seq[Any](format.raw/*50.50*/("""
                    """),format.raw/*51.21*/("""<li class="liclickable active sidebar-btn-green" data-infos="ProjetController.afficherCreerProjet()">
                        <a ><img src="img/MyIcons/png/add182.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Créer un projet</span></a>

                    </li>
                """)))}/*56.19*/else/*56.24*/{_display_(Seq[Any](format.raw/*56.25*/("""
                    """),format.raw/*57.21*/("""<li class="liclickable sidebar-btn-green" data-infos="ProjetController.afficherCreerProjet()">
                        <a ><img src="img/MyIcons/png/add182.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Créer un projet</span></a>

                    </li>
                """)))}),format.raw/*62.18*/("""

                """),_display_(/*64.18*/if(menu.equals("CreerClient"))/*64.48*/ {_display_(Seq[Any](format.raw/*64.50*/("""
                    """),format.raw/*65.21*/("""<li class="liclickable active sidebar-btn-green" data-infos="ClientController.afficherCreerClient()">
                        <a ><img src="img/MyIcons/png/add182.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Créer un client</span></a>
                    </li>
                """)))}/*69.19*/else/*69.24*/{_display_(Seq[Any](format.raw/*69.25*/("""
                    """),format.raw/*70.21*/("""<li class="liclickable sidebar-btn-green" data-infos="ClientController.afficherCreerClient()">
                        <a ><img src="img/MyIcons/png/add182.png" alt="image" class="icone"> <span class="nav-label" style="padding-left:7px ;">
                            Créer un client</span></a>
                    </li>
                """)))}),format.raw/*74.18*/("""


                """),format.raw/*77.17*/("""<li style="pointer-events: none ; cursor: default ; background-color:#e74c3c ;">
                    <a> <span class="nav-label" style="color:white ; padding-right:10px ;" >
                                Administrateur </span><img src="img/MyIcons/png/locked59-white.png" alt="image" class="icone"></a>
                </li>

                """),_display_(/*82.18*/if(menu.equals("ProjetAdmin"))/*82.48*/ {_display_(Seq[Any](format.raw/*82.50*/("""
                    """),format.raw/*83.21*/("""<li class="liclickable active sidebar-btn-red" data-infos="AdminController.afficherAdminProjets()">
                        <a ><img src="img/MyIcons/png/bars62.png" alt="image" class="icone" style="margin-left: 20px ;"> <span style="padding-left:7px ;" class="nav-label">
                            Projets </span></a>
                    </li>
                """)))}/*87.19*/else/*87.24*/{_display_(Seq[Any](format.raw/*87.25*/("""
                    """),format.raw/*88.21*/("""<li class="liclickable sidebar-btn-red" data-infos="AdminController.afficherAdminProjets()">
                        <a ><img src="img/MyIcons/png/bars62.png" alt="image" class="icone" style="margin-left: 20px ;"> <span style="padding-left:7px ;" class="nav-label">
                            Projets </span></a>
                    </li>
                """)))}),format.raw/*92.18*/("""

                """),_display_(/*94.18*/if(menu.equals("ClientAdmin"))/*94.48*/ {_display_(Seq[Any](format.raw/*94.50*/("""
                    """),format.raw/*95.21*/("""<li class="liclickable active sidebar-btn-red" data-infos="AdminController.afficherAdminClients()">
                        <a ><img src="img/MyIcons/png/team2.png" alt="image" class="icone" style="margin-left: 20px ;"> <span style="padding-left:7px ;" class="nav-label">
                            Clients </span></a>
                    </li>
                """)))}/*99.19*/else/*99.24*/{_display_(Seq[Any](format.raw/*99.25*/("""
                    """),format.raw/*100.21*/("""<li class="liclickable sidebar-btn-red" data-infos="AdminController.afficherAdminClients()">
                        <a ><img src="img/MyIcons/png/team2.png" alt="image" class="icone" style="margin-left: 20px ;"> <span style="padding-left:7px ;" class="nav-label">
                            Clients </span></a>
                    </li>
                """)))}),format.raw/*104.18*/("""


                """),_display_(/*107.18*/if(menu.equals("UtilisateurAdmin"))/*107.53*/ {_display_(Seq[Any](format.raw/*107.55*/("""
                    """),format.raw/*108.21*/("""<li class="liclickable active sidebar-btn-red" data-infos="AdminController.afficherAdminUtilisateur()">
                        <a ><img src="img/MyIcons/png/useravatar9.png" alt="image" class="icone" style="margin-left: 20px ;"> <span style="padding-left:7px ;" class="nav-label">
                            Utilisateur </span></a>
                    </li>
                """)))}/*112.19*/else/*112.24*/{_display_(Seq[Any](format.raw/*112.25*/("""
                    """),format.raw/*113.21*/("""<li class="liclickable sidebar-btn-red" data-infos="AdminController.afficherAdminUtilisateur()">
                        <a ><img src="img/MyIcons/png/useravatar9.png" alt="image" class="icone" style="margin-left: 20px ;"> <span style="padding-left:7px ;" class="nav-label">
                            Utilisateur </span></a>
                    </li>
                """)))}),format.raw/*117.18*/("""

            """),format.raw/*119.13*/("""</ul>

        </div>
    </nav>
</div>"""))
      }
    }
  }

  def render(menu:String): play.twirl.api.HtmlFormat.Appendable = apply(menu)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (menu) => apply(menu)

  def ref: this.type = this

}


}

/**/
object sidebar extends sidebar_Scope0.sidebar
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/sidebar.scala.html
                  HASH: 88f6832e304f21e4c8d8db83a4aae61457812827
                  MATRIX: 749->1|857->14|885->16|1541->645|1578->673|1618->675|1667->696|2026->1037|2039->1042|2078->1043|2127->1064|2491->1397|2537->1416|2571->1441|2611->1443|2660->1464|3011->1797|3024->1802|3063->1803|3112->1824|3468->2149|3514->2168|3548->2193|3588->2195|3637->2216|3988->2549|4001->2554|4040->2555|4089->2576|4445->2901|4491->2920|4530->2950|4570->2952|4619->2973|4984->3320|4997->3325|5036->3326|5085->3347|5455->3686|5501->3705|5540->3735|5580->3737|5629->3758|5993->4104|6006->4109|6045->4110|6094->4131|6463->4469|6510->4488|6882->4833|6921->4863|6961->4865|7010->4886|7393->5251|7406->5256|7445->5257|7494->5278|7882->5635|7928->5654|7967->5684|8007->5686|8056->5707|8438->6071|8451->6076|8490->6077|8540->6098|8928->6454|8976->6474|9021->6509|9062->6511|9112->6532|9509->6910|9523->6915|9563->6916|9613->6937|10015->7307|10058->7321
                  LINES: 27->1|32->1|34->3|45->14|45->14|45->14|46->15|50->19|50->19|50->19|51->20|55->24|57->26|57->26|57->26|58->27|62->31|62->31|62->31|63->32|67->36|69->38|69->38|69->38|70->39|74->43|74->43|74->43|75->44|79->48|81->50|81->50|81->50|82->51|87->56|87->56|87->56|88->57|93->62|95->64|95->64|95->64|96->65|100->69|100->69|100->69|101->70|105->74|108->77|113->82|113->82|113->82|114->83|118->87|118->87|118->87|119->88|123->92|125->94|125->94|125->94|126->95|130->99|130->99|130->99|131->100|135->104|138->107|138->107|138->107|139->108|143->112|143->112|143->112|144->113|148->117|150->119
                  -- GENERATED --
              */
          