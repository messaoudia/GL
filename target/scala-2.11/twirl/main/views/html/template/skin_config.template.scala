
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object skin_config_Scope0 {
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

class skin_config extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<div class="theme-config">
    <div class="theme-config-box">
        <div class="spin-icon">
            <i class="fa fa-cogs fa-spin"></i>
        </div>
        <div class="skin-setttings">
            <div class="title">Configuration</div>
            <div class="setings-item">
                    <span>
                        Collapse menu
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                        <label class="onoffswitch-label" for="collapsemenu">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        Fixed sidebar
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="fixedsidebar" class="onoffswitch-checkbox" id="fixedsidebar">
                        <label class="onoffswitch-label" for="fixedsidebar">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        Top navbar
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                        <label class="onoffswitch-label" for="fixednavbar">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        Boxed layout
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                        <label class="onoffswitch-label" for="boxedlayout">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="setings-item">
                    <span>
                        Fixed footer
                    </span>

                <div class="switch">
                    <div class="onoffswitch">
                        <input type="checkbox" name="fixedfooter" class="onoffswitch-checkbox" id="fixedfooter">
                        <label class="onoffswitch-label" for="fixedfooter">
                            <span class="onoffswitch-inner"></span>
                            <span class="onoffswitch-switch"></span>
                        </label>
                    </div>
                </div>
            </div>

            <div class="title">Skins</div>
            <div class="setings-item default-skin">
                    <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             Default
                         </a>
                    </span>
            </div>
            <div class="setings-item blue-skin">
                    <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            Blue light
                        </a>
                    </span>
            </div>
            <div class="setings-item yellow-skin">
                    <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            Yellow/Purple
                        </a>
                    </span>
            </div>
            <div class="setings-item ultra-skin">
                    <span class="skin-name ">
                        <a target="_blank" href="md_skin/" class="md-skin">
                            Material Design
                        </a>
                    </span>
            </div>
        </div>
    </div>
</div>
<script>
    // Config box

    // Enable/disable fixed top navbar
    $('#fixednavbar').click(function () """),format.raw/*120.41*/("""{"""),format.raw/*120.42*/("""
        """),format.raw/*121.9*/("""if ($('#fixednavbar').is(':checked')) """),format.raw/*121.47*/("""{"""),format.raw/*121.48*/("""
            """),format.raw/*122.13*/("""$(".navbar-static-top").removeClass('navbar-static-top').addClass('navbar-fixed-top');
            $("body").removeClass('boxed-layout');
            $("body").addClass('fixed-nav');
            $('#boxedlayout').prop('checked', false);

            if (localStorageSupport) """),format.raw/*127.38*/("""{"""),format.raw/*127.39*/("""
                """),format.raw/*128.17*/("""localStorage.setItem("boxedlayout",'off');
            """),format.raw/*129.13*/("""}"""),format.raw/*129.14*/("""

            """),format.raw/*131.13*/("""if (localStorageSupport) """),format.raw/*131.38*/("""{"""),format.raw/*131.39*/("""
                """),format.raw/*132.17*/("""localStorage.setItem("fixednavbar",'on');
            """),format.raw/*133.13*/("""}"""),format.raw/*133.14*/("""
        """),format.raw/*134.9*/("""}"""),format.raw/*134.10*/(""" """),format.raw/*134.11*/("""else """),format.raw/*134.16*/("""{"""),format.raw/*134.17*/("""
            """),format.raw/*135.13*/("""$(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');

            if (localStorageSupport) """),format.raw/*138.38*/("""{"""),format.raw/*138.39*/("""
                """),format.raw/*139.17*/("""localStorage.setItem("fixednavbar",'off');
            """),format.raw/*140.13*/("""}"""),format.raw/*140.14*/("""
        """),format.raw/*141.9*/("""}"""),format.raw/*141.10*/("""
    """),format.raw/*142.5*/("""}"""),format.raw/*142.6*/(""");

    // Enable/disable fixed sidebar
    $('#fixedsidebar').click(function () """),format.raw/*145.42*/("""{"""),format.raw/*145.43*/("""
        """),format.raw/*146.9*/("""if ($('#fixedsidebar').is(':checked')) """),format.raw/*146.48*/("""{"""),format.raw/*146.49*/("""
            """),format.raw/*147.13*/("""$("body").addClass('fixed-sidebar');
            $('.sidebar-collapse').slimScroll("""),format.raw/*148.47*/("""{"""),format.raw/*148.48*/("""
                """),format.raw/*149.17*/("""height: '100%',
                railOpacity: 0.9
            """),format.raw/*151.13*/("""}"""),format.raw/*151.14*/(""");

            if (localStorageSupport) """),format.raw/*153.38*/("""{"""),format.raw/*153.39*/("""
                """),format.raw/*154.17*/("""localStorage.setItem("fixedsidebar",'on');
            """),format.raw/*155.13*/("""}"""),format.raw/*155.14*/("""
        """),format.raw/*156.9*/("""}"""),format.raw/*156.10*/(""" """),format.raw/*156.11*/("""else """),format.raw/*156.16*/("""{"""),format.raw/*156.17*/("""
            """),format.raw/*157.13*/("""$('.sidebar-collapse').slimscroll("""),format.raw/*157.47*/("""{"""),format.raw/*157.48*/("""destroy: true"""),format.raw/*157.61*/("""}"""),format.raw/*157.62*/(""");
            $('.sidebar-collapse').attr('style', '');
            $("body").removeClass('fixed-sidebar');

            if (localStorageSupport) """),format.raw/*161.38*/("""{"""),format.raw/*161.39*/("""
                """),format.raw/*162.17*/("""localStorage.setItem("fixedsidebar",'off');
            """),format.raw/*163.13*/("""}"""),format.raw/*163.14*/("""
        """),format.raw/*164.9*/("""}"""),format.raw/*164.10*/("""
    """),format.raw/*165.5*/("""}"""),format.raw/*165.6*/(""");

    // Enable/disable collapse menu
    $('#collapsemenu').click(function () """),format.raw/*168.42*/("""{"""),format.raw/*168.43*/("""
        """),format.raw/*169.9*/("""if ($('#collapsemenu').is(':checked')) """),format.raw/*169.48*/("""{"""),format.raw/*169.49*/("""
            """),format.raw/*170.13*/("""$("body").addClass('mini-navbar');
            SmoothlyMenu();

            if (localStorageSupport) """),format.raw/*173.38*/("""{"""),format.raw/*173.39*/("""
                """),format.raw/*174.17*/("""localStorage.setItem("collapse_menu",'on');
            """),format.raw/*175.13*/("""}"""),format.raw/*175.14*/("""

        """),format.raw/*177.9*/("""}"""),format.raw/*177.10*/(""" """),format.raw/*177.11*/("""else """),format.raw/*177.16*/("""{"""),format.raw/*177.17*/("""
            """),format.raw/*178.13*/("""$("body").removeClass('mini-navbar');
            SmoothlyMenu();

            if (localStorageSupport) """),format.raw/*181.38*/("""{"""),format.raw/*181.39*/("""
                """),format.raw/*182.17*/("""localStorage.setItem("collapse_menu",'off');
            """),format.raw/*183.13*/("""}"""),format.raw/*183.14*/("""
        """),format.raw/*184.9*/("""}"""),format.raw/*184.10*/("""
    """),format.raw/*185.5*/("""}"""),format.raw/*185.6*/(""");

    // Enable/disable boxed layout
    $('#boxedlayout').click(function () """),format.raw/*188.41*/("""{"""),format.raw/*188.42*/("""
        """),format.raw/*189.9*/("""if ($('#boxedlayout').is(':checked')) """),format.raw/*189.47*/("""{"""),format.raw/*189.48*/("""
            """),format.raw/*190.13*/("""$("body").addClass('boxed-layout');
            $('#fixednavbar').prop('checked', false);
            $(".navbar-fixed-top").removeClass('navbar-fixed-top').addClass('navbar-static-top');
            $("body").removeClass('fixed-nav');
            $(".footer").removeClass('fixed');
            $('#fixedfooter').prop('checked', false);

            if (localStorageSupport) """),format.raw/*197.38*/("""{"""),format.raw/*197.39*/("""
                """),format.raw/*198.17*/("""localStorage.setItem("fixednavbar",'off');
            """),format.raw/*199.13*/("""}"""),format.raw/*199.14*/("""

            """),format.raw/*201.13*/("""if (localStorageSupport) """),format.raw/*201.38*/("""{"""),format.raw/*201.39*/("""
                """),format.raw/*202.17*/("""localStorage.setItem("fixedfooter",'off');
            """),format.raw/*203.13*/("""}"""),format.raw/*203.14*/("""


            """),format.raw/*206.13*/("""if (localStorageSupport) """),format.raw/*206.38*/("""{"""),format.raw/*206.39*/("""
                """),format.raw/*207.17*/("""localStorage.setItem("boxedlayout",'on');
            """),format.raw/*208.13*/("""}"""),format.raw/*208.14*/("""
        """),format.raw/*209.9*/("""}"""),format.raw/*209.10*/(""" """),format.raw/*209.11*/("""else """),format.raw/*209.16*/("""{"""),format.raw/*209.17*/("""
            """),format.raw/*210.13*/("""$("body").removeClass('boxed-layout');

            if (localStorageSupport) """),format.raw/*212.38*/("""{"""),format.raw/*212.39*/("""
                """),format.raw/*213.17*/("""localStorage.setItem("boxedlayout",'off');
            """),format.raw/*214.13*/("""}"""),format.raw/*214.14*/("""
        """),format.raw/*215.9*/("""}"""),format.raw/*215.10*/("""
    """),format.raw/*216.5*/("""}"""),format.raw/*216.6*/(""");

    // Enable/disable fixed footer
    $('#fixedfooter').click(function () """),format.raw/*219.41*/("""{"""),format.raw/*219.42*/("""
        """),format.raw/*220.9*/("""if ($('#fixedfooter').is(':checked')) """),format.raw/*220.47*/("""{"""),format.raw/*220.48*/("""
            """),format.raw/*221.13*/("""$('#boxedlayout').prop('checked', false);
            $("body").removeClass('boxed-layout');
            $(".footer").addClass('fixed');

            if (localStorageSupport) """),format.raw/*225.38*/("""{"""),format.raw/*225.39*/("""
                """),format.raw/*226.17*/("""localStorage.setItem("boxedlayout",'off');
            """),format.raw/*227.13*/("""}"""),format.raw/*227.14*/("""

            """),format.raw/*229.13*/("""if (localStorageSupport) """),format.raw/*229.38*/("""{"""),format.raw/*229.39*/("""
                """),format.raw/*230.17*/("""localStorage.setItem("fixedfooter",'on');
            """),format.raw/*231.13*/("""}"""),format.raw/*231.14*/("""
        """),format.raw/*232.9*/("""}"""),format.raw/*232.10*/(""" """),format.raw/*232.11*/("""else """),format.raw/*232.16*/("""{"""),format.raw/*232.17*/("""
            """),format.raw/*233.13*/("""$(".footer").removeClass('fixed');

            if (localStorageSupport) """),format.raw/*235.38*/("""{"""),format.raw/*235.39*/("""
                """),format.raw/*236.17*/("""localStorage.setItem("fixedfooter",'off');
            """),format.raw/*237.13*/("""}"""),format.raw/*237.14*/("""
        """),format.raw/*238.9*/("""}"""),format.raw/*238.10*/("""
    """),format.raw/*239.5*/("""}"""),format.raw/*239.6*/(""");

    // SKIN Select
    $('.spin-icon').click(function () """),format.raw/*242.39*/("""{"""),format.raw/*242.40*/("""
        """),format.raw/*243.9*/("""$(".theme-config-box").toggleClass("show");
    """),format.raw/*244.5*/("""}"""),format.raw/*244.6*/(""");

    // Default skin
    $('.s-skin-0').click(function () """),format.raw/*247.38*/("""{"""),format.raw/*247.39*/("""
        """),format.raw/*248.9*/("""$("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
    """),format.raw/*251.5*/("""}"""),format.raw/*251.6*/(""");

    // Blue skin
    $('.s-skin-1').click(function () """),format.raw/*254.38*/("""{"""),format.raw/*254.39*/("""
        """),format.raw/*255.9*/("""$("body").removeClass("skin-2");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-1");
    """),format.raw/*258.5*/("""}"""),format.raw/*258.6*/(""");

    // Inspinia ultra skin
    $('.s-skin-2').click(function () """),format.raw/*261.38*/("""{"""),format.raw/*261.39*/("""
        """),format.raw/*262.9*/("""$("body").removeClass("skin-1");
        $("body").removeClass("skin-3");
        $("body").addClass("skin-2");
    """),format.raw/*265.5*/("""}"""),format.raw/*265.6*/(""");

    // Yellow skin
    $('.s-skin-3').click(function () """),format.raw/*268.38*/("""{"""),format.raw/*268.39*/("""
        """),format.raw/*269.9*/("""$("body").removeClass("skin-1");
        $("body").removeClass("skin-2");
        $("body").addClass("skin-3");
    """),format.raw/*272.5*/("""}"""),format.raw/*272.6*/(""");

    if (localStorageSupport) """),format.raw/*274.30*/("""{"""),format.raw/*274.31*/("""
        """),format.raw/*275.9*/("""var collapse = localStorage.getItem("collapse_menu");
        var fixedsidebar = localStorage.getItem("fixedsidebar");
        var fixednavbar = localStorage.getItem("fixednavbar");
        var boxedlayout = localStorage.getItem("boxedlayout");
        var fixedfooter = localStorage.getItem("fixedfooter");

        if (collapse == 'on') """),format.raw/*281.31*/("""{"""),format.raw/*281.32*/("""
            """),format.raw/*282.13*/("""$('#collapsemenu').prop('checked','checked')
        """),format.raw/*283.9*/("""}"""),format.raw/*283.10*/("""
        """),format.raw/*284.9*/("""if (fixedsidebar == 'on') """),format.raw/*284.35*/("""{"""),format.raw/*284.36*/("""
            """),format.raw/*285.13*/("""$('#fixedsidebar').prop('checked','checked')
        """),format.raw/*286.9*/("""}"""),format.raw/*286.10*/("""
        """),format.raw/*287.9*/("""if (fixednavbar == 'on') """),format.raw/*287.34*/("""{"""),format.raw/*287.35*/("""
            """),format.raw/*288.13*/("""$('#fixednavbar').prop('checked','checked')
        """),format.raw/*289.9*/("""}"""),format.raw/*289.10*/("""
        """),format.raw/*290.9*/("""if (boxedlayout == 'on') """),format.raw/*290.34*/("""{"""),format.raw/*290.35*/("""
            """),format.raw/*291.13*/("""$('#boxedlayout').prop('checked','checked')
        """),format.raw/*292.9*/("""}"""),format.raw/*292.10*/("""
        """),format.raw/*293.9*/("""if (fixedfooter == 'on') """),format.raw/*293.34*/("""{"""),format.raw/*293.35*/("""
            """),format.raw/*294.13*/("""$('#fixedfooter').prop('checked','checked')
        """),format.raw/*295.9*/("""}"""),format.raw/*295.10*/("""
    """),format.raw/*296.5*/("""}"""),format.raw/*296.6*/("""
"""),format.raw/*297.1*/("""</script>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object skin_config extends skin_config_Scope0.skin_config
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:20 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/skin_config.scala.html
                  HASH: a2f7e0f0a920b42d7276654789d94f7f73224de4
                  MATRIX: 848->0|5737->4860|5767->4861|5805->4871|5872->4909|5902->4910|5945->4924|6254->5204|6284->5205|6331->5223|6416->5279|6446->5280|6491->5296|6545->5321|6575->5322|6622->5340|6706->5395|6736->5396|6774->5406|6804->5407|6834->5408|6868->5413|6898->5414|6941->5428|7145->5603|7175->5604|7222->5622|7307->5678|7337->5679|7375->5689|7405->5690|7439->5696|7468->5697|7581->5781|7611->5782|7649->5792|7717->5831|7747->5832|7790->5846|7903->5930|7933->5931|7980->5949|8072->6012|8102->6013|8174->6056|8204->6057|8251->6075|8336->6131|8366->6132|8404->6142|8434->6143|8464->6144|8498->6149|8528->6150|8571->6164|8634->6198|8664->6199|8706->6212|8736->6213|8916->6364|8946->6365|8993->6383|9079->6440|9109->6441|9147->6451|9177->6452|9211->6458|9240->6459|9353->6543|9383->6544|9421->6554|9489->6593|9519->6594|9562->6608|9695->6712|9725->6713|9772->6731|9858->6788|9888->6789|9928->6801|9958->6802|9988->6803|10022->6808|10052->6809|10095->6823|10231->6930|10261->6931|10308->6949|10395->7007|10425->7008|10463->7018|10493->7019|10527->7025|10556->7026|10667->7108|10697->7109|10735->7119|10802->7157|10832->7158|10875->7172|11286->7554|11316->7555|11363->7573|11448->7629|11478->7630|11523->7646|11577->7671|11607->7672|11654->7690|11739->7746|11769->7747|11816->7765|11870->7790|11900->7791|11947->7809|12031->7864|12061->7865|12099->7875|12129->7876|12159->7877|12193->7882|12223->7883|12266->7897|12374->7976|12404->7977|12451->7995|12536->8051|12566->8052|12604->8062|12634->8063|12668->8069|12697->8070|12808->8152|12838->8153|12876->8163|12943->8201|12973->8202|13016->8216|13224->8395|13254->8396|13301->8414|13386->8470|13416->8471|13461->8487|13515->8512|13545->8513|13592->8531|13676->8586|13706->8587|13744->8597|13774->8598|13804->8599|13838->8604|13868->8605|13911->8619|14015->8694|14045->8695|14092->8713|14177->8769|14207->8770|14245->8780|14275->8781|14309->8787|14338->8788|14431->8852|14461->8853|14499->8863|14576->8912|14605->8913|14698->8977|14728->8978|14766->8988|14916->9110|14945->9111|15035->9172|15065->9173|15103->9183|15250->9302|15279->9303|15379->9374|15409->9375|15447->9385|15594->9504|15623->9505|15715->9568|15745->9569|15783->9579|15930->9698|15959->9699|16023->9734|16053->9735|16091->9745|16465->10090|16495->10091|16538->10105|16620->10159|16650->10160|16688->10170|16743->10196|16773->10197|16816->10211|16898->10265|16928->10266|16966->10276|17020->10301|17050->10302|17093->10316|17174->10369|17204->10370|17242->10380|17296->10405|17326->10406|17369->10420|17450->10473|17480->10474|17518->10484|17572->10509|17602->10510|17645->10524|17726->10577|17756->10578|17790->10584|17819->10585|17849->10587
                  LINES: 32->1|151->120|151->120|152->121|152->121|152->121|153->122|158->127|158->127|159->128|160->129|160->129|162->131|162->131|162->131|163->132|164->133|164->133|165->134|165->134|165->134|165->134|165->134|166->135|169->138|169->138|170->139|171->140|171->140|172->141|172->141|173->142|173->142|176->145|176->145|177->146|177->146|177->146|178->147|179->148|179->148|180->149|182->151|182->151|184->153|184->153|185->154|186->155|186->155|187->156|187->156|187->156|187->156|187->156|188->157|188->157|188->157|188->157|188->157|192->161|192->161|193->162|194->163|194->163|195->164|195->164|196->165|196->165|199->168|199->168|200->169|200->169|200->169|201->170|204->173|204->173|205->174|206->175|206->175|208->177|208->177|208->177|208->177|208->177|209->178|212->181|212->181|213->182|214->183|214->183|215->184|215->184|216->185|216->185|219->188|219->188|220->189|220->189|220->189|221->190|228->197|228->197|229->198|230->199|230->199|232->201|232->201|232->201|233->202|234->203|234->203|237->206|237->206|237->206|238->207|239->208|239->208|240->209|240->209|240->209|240->209|240->209|241->210|243->212|243->212|244->213|245->214|245->214|246->215|246->215|247->216|247->216|250->219|250->219|251->220|251->220|251->220|252->221|256->225|256->225|257->226|258->227|258->227|260->229|260->229|260->229|261->230|262->231|262->231|263->232|263->232|263->232|263->232|263->232|264->233|266->235|266->235|267->236|268->237|268->237|269->238|269->238|270->239|270->239|273->242|273->242|274->243|275->244|275->244|278->247|278->247|279->248|282->251|282->251|285->254|285->254|286->255|289->258|289->258|292->261|292->261|293->262|296->265|296->265|299->268|299->268|300->269|303->272|303->272|305->274|305->274|306->275|312->281|312->281|313->282|314->283|314->283|315->284|315->284|315->284|316->285|317->286|317->286|318->287|318->287|318->287|319->288|320->289|320->289|321->290|321->290|321->290|322->291|323->292|323->292|324->293|324->293|324->293|325->294|326->295|326->295|327->296|327->296|328->297
                  -- GENERATED --
              */
          