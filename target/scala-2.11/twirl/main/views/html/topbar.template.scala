
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object topbar_Scope0 {
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

class topbar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="row border-bottom">
    <nav class="navbar navbar-fixed-top" role="navigation" style="margin-bottom: 0 ; transition: none ;">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary pear-theme" href="#"><i class="fa fa-bars"></i> </a>
        </div>
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown" dropdown="">
                <div tabindex="0" class="popover-info" type="button" data-container="body" data-toggle="popover" data-placement="bottom" data-trigger="focus" data-html="true" data-content='<p><a><img class="country-flag" src="img/MyIcons/png/fr.png"/> Français</a></p><a><a><img class="country-flag" src="img/MyIcons/png/en.png"/> English</a></p>'>
                    <a class="dropdown-toggle count-info pear-theme" data-toggle="dropdown" href="#" aria-expanded="true">
                        <img class="country-flag" src="img/MyIcons/png/fr.png"/>
                    </a>
                </div>
            </li>
            <li class="dropdown" dropdown="">
                <a class="dropdown-toggle count-info pear-theme" data-toggle="dropdown" href="#" aria-expanded="true">
                    <i class="fa fa-bell"></i> <span class="label label-warning">8</span>
                </a>
            </li>

            <li>
                <a class="right-sidebar-toggle">
                    <i class="logo-eu fa fa-user pear-theme"></i>
                </a>
            </li>

            <li>
                <a href="login.html">
                    <i class="logo-eu fa fa-power-off pear-theme"></i>
                </a>
            </li>
        </ul>
    </nav>
</div>
    <!-- Partie droite, les settings -->
<div id="right-sidebar">
    <div class="sidebar-container">
        <div class="changePassword">
            <form role="form">
                <div class="form-group previousPassword">
                    <label for="previousPassword">"""),_display_(/*40.52*/Messages("previousPassword")),format.raw/*40.80*/("""</label>
                    <input type="password" id="previousPassword" class="form-control">
                </div>
                <div class="form-group newPassword">
                    <label for="newPassword">"""),_display_(/*44.47*/Messages("newPassword")),format.raw/*44.70*/("""</label>
                    <input type="password" id="newPassword" class="form-control">
                </div>
                <div class="form-group newPasswordConfirm">
                    <label for="newPasswordConfirm">"""),_display_(/*48.54*/Messages("newPasswordConfirm")),format.raw/*48.84*/("""</label>
                    <input type="password" id="newPasswordConfirm" class="form-control">
                </div>
                <div class="validateForm">
                    <button class="btn btn-user btn-block" type="submit" onclick>"""),_display_(/*52.83*/Messages("validateForm")),format.raw/*52.107*/(""" """),format.raw/*52.108*/("""<i class="fa fa-check"></i></button>
                </div>
            </form>
        </div>

        <div class="notificationFrom">
            <p>"""),_display_(/*58.17*/Messages("titleNotificationFrom")),format.raw/*58.50*/("""</p>
            <div>
                    <!--TODO : auto recherche -->
                <input type="text" id="searchContact" class="form-control z-index-3"/>
            </div>

            <div class="list-personnes-notifiees">
                <table class="table-bordered">
                    <tbody>
                        <tr>
                            <td class="first-td">Yasser Rabi - yasser.rabi&commat;gmail.com</td>
                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>
                        </tr>
                        <tr>
                            <td class="first-td">Yasser Rabi - yasser.rabi&commat;gmail.com</td>
                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>
                        </tr>
                        <tr>
                            <td class="first-td">Yasser Rabi - yasser.rabi&commat;gmail.com</td>
                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>
                        </tr>
                        <tr>
                            <td class="first-td">Yasser Rabi - yasser.rabi&commat;gmail.com</td>
                            <td class="td-btn-suppr" style="vertical-align:middle ;"><i class="fa fa-times"></i></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="notificationSettings">
            <div class="checkbox checkbox-success checkbox-circle">
                <input id="checkbox-changes" type="checkbox">
                <label for="checkbox-changes">
                """),_display_(/*92.18*/Messages("checkbox-changes")),format.raw/*92.46*/("""
                """),format.raw/*93.17*/("""</label>
            </div>
            <div class="checkbox checkbox-success checkbox-circle">
                <input id="checkbox-tasks-almost-finish" type="checkbox" >
                <label for="checkbox-tasks-almost-finish">
                """),_display_(/*98.18*/Messages("checkbox-tasks-almost-finish")),format.raw/*98.58*/("""
                """),format.raw/*99.17*/("""</label>
            </div>
            <div class="checkbox checkbox-success checkbox-circle">
                <input id="checkbox-tasks-late" type="checkbox" checked>
                <label for="checkbox-tasks-late">
                """),_display_(/*104.18*/Messages("checkbox-tasks-late")),format.raw/*104.49*/("""
                """),format.raw/*105.17*/("""</label>
            </div>
        </div>
    </div>
</div>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object topbar extends topbar_Scope0.topbar
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/topbar.scala.html
                  HASH: 292f177cc1912b3c983bccfe0a9c7496c3ecf9c5
                  MATRIX: 829->0|2835->1979|2884->2007|3129->2225|3173->2248|3427->2475|3478->2505|3751->2751|3797->2775|3827->2776|4005->2927|4059->2960|5814->4688|5863->4716|5908->4733|6182->4980|6243->5020|6288->5037|6552->5273|6605->5304|6651->5321
                  LINES: 32->1|71->40|71->40|75->44|75->44|79->48|79->48|83->52|83->52|83->52|89->58|89->58|123->92|123->92|124->93|129->98|129->98|130->99|135->104|135->104|136->105
                  -- GENERATED --
              */
          