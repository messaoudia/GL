
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
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

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageTitle: String, content: Html, scripts: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.51*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>"""),_display_(/*11.17*/pageTitle),format.raw/*11.26*/("""</title>

        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="/css/plugins/toastr/toastr.min.css" rel="stylesheet">
        <link href="/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">
        <link href="/css/animate.css" rel="stylesheet">

        <link href="/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
        <link href="/css/plugins/dataTables/dataTables.responsive.css" rel="stylesheet">
        <link href="/css/plugins/dataTables/dataTables.tableTools.min.css" rel="stylesheet">

        <link href="/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
        <link href="/css/plugins/footable/footable.core.css" rel="stylesheet">
        <link href="/css/plugins/chosen/chosen.css" rel="stylesheet">
        <link href="/css/plugins/iCheck/custom.css" rel="stylesheet">
        <link href="/css/plugins/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet">
        <link href="/css/plugins/cropper/cropper.min.css" rel="stylesheet">
        <link href="/css/plugins/switchery/switchery.css" rel="stylesheet">
        <link href="/css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">
        <link href="/css/plugins/nouslider/jquery.nouislider.css" rel="stylesheet">
        <link href="/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
        <link href="/css/plugins/ionRangeSlider/ion.rangeSlider.css" rel="stylesheet">
        <link href="/css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">
        <link href="/css/plugins/clockpicker/clockpicker.css" rel="stylesheet">
        <link href="/css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">
        <link href="/css/plugins/select2/select2.min.css" rel="stylesheet">
        <link href="/css/style.css" rel="stylesheet">

    </head>

    <body class="md-skin fixed-sidebar fixed-nav pace-done">
            <!--########### Start - Main HTML Content  ########### -->

        """),_display_(/*45.10*/content),format.raw/*45.17*/("""

            """),format.raw/*47.13*/("""<!--########### End  - Main HTML Content  ########### -->


            <!-- Mainly scripts -->
        <script src="/assets/js/jquery-2.1.1.js"></script>
        <script src="/assets/js/bootstrap.min.js"></script>

        <script src="/assets/js/plugins/metisMenu/jquery.metisMenu.js"></script>
        <script src="/assets/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

            <!-- Flot -->
        <script src="/assets/js/plugins/flot/jquery.flot.js"></script>
        <script src="/assets/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
        <script src="/assets/js/plugins/flot/jquery.flot.spline.js"></script>
        <script src="/assets/js/plugins/flot/jquery.flot.resize.js"></script>
        <script src="/assets/js/plugins/flot/jquery.flot.pie.js"></script>

            <!-- Peity -->
        <script src="/assets/js/plugins/peity/jquery.peity.min.js"></script>
        <script src="/assets/js/demo/peity-demo.js"></script>

            <!-- Custom and plugin javascript -->
        <script src="/assets/js/inspinia.js"></script>
        <script src="/assets/js/plugins/pace/pace.min.js"></script>

            <!-- jQuery UI -->
        <script src="/assets/js/plugins/jquery-ui/jquery-ui.min.js"></script>

            <!-- GITTER -->
        <script src="/assets/js/plugins/gritter/jquery.gritter.min.js"></script>

            <!-- Sparkline -->
        <script src="/assets/js/plugins/sparkline/jquery.sparkline.min.js"></script>

            <!-- Sparkline demo data  -->
        <script src="/assets/js/demo/sparkline-demo.js"></script>

            <!-- ChartJS-->
        <script src="/assets/js/plugins/chartJs/Chart.min.js"></script>

            <!-- Toastr -->
        <script src="/assets/js/plugins/toastr/toastr.min.js"></script>

            <!-- Data Tables -->
        <script src="/js/plugins/jeditable/jquery.jeditable.js"></script>
        <script src="/js/plugins/dataTables/jquery.dataTables.js"></script>
        <script src="/js/plugins/dataTables/dataTables.bootstrap.js"></script>
        <script src="/js/plugins/dataTables/dataTables.responsive.js"></script>
        <script src="/js/plugins/dataTables/dataTables.tableTools.min.js"></script>

            <!-- Footable -->
        <script src="/js/plugins/footable/footable.all.min.js"></script>

            <!-- DATE -->
        <script src="/assets/js/plugins/datapicker/bootstrap-datepicker.js"></script>
        <script src="/assets/js/plugins/datepicker/bootstrap-datepicker.js"></script>
        <script src="/assets/js/plugins/datepicker/locales/bootstrap-datepicker.en.js"></script>
        <script src="/assets/js/plugins/datepicker/locales/bootstrap-datepicker.fr.js"></script>

            <!-- Chosen -->
        <script src="/js/plugins/chosen/chosen.jquery.js"></script>
            <!-- Exposing play framework routes -->
        <script type="text/javascript" src=""""),_display_(/*109.46*/routes/*109.52*/.Application.javascriptRoutes()),format.raw/*109.83*/(""""></script>

            <!-- JSKnob -->
        <script src="/js/plugins/jsKnob/jquery.knob.js"></script>

            <!-- Input Mask-->
        <script src="/js/plugins/jasny/jasny-bootstrap.min.js"></script>

            <!-- Data picker -->
        <script src="/js/plugins/datapicker/bootstrap-datepicker.js"></script>

            <!-- NouSlider -->
        <script src="/js/plugins/nouslider/jquery.nouislider.min.js"></script>

            <!-- Switchery -->
        <script src="/js/plugins/switchery/switchery.js"></script>

            <!-- IonRangeSlider -->
        <script src="/js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

            <!-- iCheck -->
        <script src="/js/plugins/iCheck/icheck.min.js"></script>

            <!-- MENU -->
        <script src="/js/plugins/metisMenu/jquery.metisMenu.js"></script>

            <!-- Color picker -->
        <script src="/js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

            <!-- Clock picker -->
        <script src="/js/plugins/clockpicker/clockpicker.js"></script>

            <!-- Image cropper -->
        <script src="/js/plugins/cropper/cropper.min.js"></script>

            <!-- Date range use moment.js same as full calendar plugin -->
        <script src="/js/plugins/fullcalendar/moment.min.js"></script>

            <!-- Date range picker -->
        <script src="/js/plugins/daterangepicker/daterangepicker.js"></script>

            <!-- Select2 -->
        <script src="/js/plugins/select2/select2.full.min.js"></script>

            <!-- Nestable -->
        <script src="/js/plugins/nestable/jquery.nestable.js"></script>

            <!-- Projet -->
        <script src="/js/projet.js"></script>

            <!-- Menu -->
        <script src="/js/menu.js"></script>

        """),_display_(/*162.10*/scripts),format.raw/*162.17*/("""
        """),format.raw/*163.9*/("""<script>
                $(document).ready(function () """),format.raw/*164.47*/("""{"""),format.raw/*164.48*/("""

                    """),format.raw/*166.21*/("""/* $("#submitButton").click(function(e) """),format.raw/*166.61*/("""{"""),format.raw/*166.62*/("""
                     """),format.raw/*167.22*/("""alert("JE SUIS LA");
                     $("#addProjectForm").submit(function( event ) """),format.raw/*168.68*/("""{"""),format.raw/*168.69*/("""

                     """),format.raw/*170.22*/("""jsRoutes.controllers.ProjetController.ajouterProjet().ajax("""),format.raw/*170.81*/("""{"""),format.raw/*170.82*/("""
                     """),format.raw/*171.22*/("""success : function(data) """),format.raw/*171.47*/("""{"""),format.raw/*171.48*/("""
                     """),format.raw/*172.22*/("""alert("oki");
                     """),format.raw/*173.22*/("""}"""),format.raw/*173.23*/(""",
                     error: function(errorMessage)"""),format.raw/*174.51*/("""{"""),format.raw/*174.52*/("""
                     """),format.raw/*175.22*/("""alert("error");
                     """),format.raw/*176.22*/("""}"""),format.raw/*176.23*/("""
                     """),format.raw/*177.22*/("""}"""),format.raw/*177.23*/(""");

                     """),format.raw/*179.22*/("""}"""),format.raw/*179.23*/(""");
                     """),format.raw/*180.22*/("""}"""),format.raw/*180.23*/(""");
                     */
                    $(".select2-predecesseur").select2("""),format.raw/*182.56*/("""{"""),format.raw/*182.57*/("""
                        """),format.raw/*183.25*/("""placeholder : '"""),_display_(/*183.41*/Messages("choosePredecessor")),format.raw/*183.70*/("""...',
                        maximumSelectionLength: 1
                    """),format.raw/*185.21*/("""}"""),format.raw/*185.22*/(""");

                    $(".select2-successeur").select2("""),format.raw/*187.54*/("""{"""),format.raw/*187.55*/("""
                        """),format.raw/*188.25*/("""placeholder : '"""),_display_(/*188.41*/Messages("chooseSuccessor")),format.raw/*188.68*/("""...'
                    """),format.raw/*189.21*/("""}"""),format.raw/*189.22*/(""");
                    $(".select2-client").select2("""),format.raw/*190.50*/("""{"""),format.raw/*190.51*/("""
                        """),format.raw/*191.25*/("""placeholder : '"""),_display_(/*191.41*/Messages("chooseClient")),format.raw/*191.65*/("""...',
                        maximumSelectionLength: 1
                    """),format.raw/*193.21*/("""}"""),format.raw/*193.22*/(""");

                    $(".select2-respo-projet").select2("""),format.raw/*195.56*/("""{"""),format.raw/*195.57*/("""
                        """),format.raw/*196.25*/("""placeholder : '"""),_display_(/*196.41*/Messages("chooseProjectManager")),format.raw/*196.73*/("""...',
                        maximumSelectionLength: 1
                    """),format.raw/*198.21*/("""}"""),format.raw/*198.22*/(""");
                    $(".select2-respo-tache").select2("""),format.raw/*199.55*/("""{"""),format.raw/*199.56*/("""
                        """),format.raw/*200.25*/("""placeholder : '"""),_display_(/*200.41*/Messages("chooseTaskResponsible")),format.raw/*200.74*/("""...',
                        maximumSelectionLength: 1
                    """),format.raw/*202.21*/("""}"""),format.raw/*202.22*/(""");

                    $('[data-toggle="popover"]').popover()
                    // activate Nestable for list 1
                    $('#nestable').nestable("""),format.raw/*206.45*/("""{"""),format.raw/*206.46*/("""
                        """),format.raw/*207.25*/("""group: 1,
                        maxDepth: 4
                    """),format.raw/*209.21*/("""}"""),format.raw/*209.22*/(""").on('change');


                    $('#dataTables-tdb-projet').DataTable();


                    $('#dataTables-tdb-tache').DataTable("""),format.raw/*215.58*/("""{"""),format.raw/*215.59*/("""
                        """),format.raw/*216.25*/(""""columnDefs": ["""),format.raw/*216.40*/("""{"""),format.raw/*216.41*/("""
                            """),format.raw/*217.29*/(""""searchable": false,
                            "orderable": false,
                            "targets": [6, 7]
                        """),format.raw/*220.25*/("""}"""),format.raw/*220.26*/(""" """),format.raw/*220.27*/("""]
                    """),format.raw/*221.21*/("""}"""),format.raw/*221.22*/(""");
                    $(".select2_demo_1").select2();

                    $('.dataTables-example').DataTable();

                    $('#projet_Projet').dataTable( """),format.raw/*226.52*/("""{"""),format.raw/*226.53*/("""
                        """),format.raw/*227.25*/(""""ordering": false
                    """),format.raw/*228.21*/("""}"""),format.raw/*228.22*/(""" """),format.raw/*228.23*/(""");

                    $('#dataTables-admin-projet').DataTable("""),format.raw/*230.61*/("""{"""),format.raw/*230.62*/("""
                        """),format.raw/*231.25*/(""""columnDefs": ["""),format.raw/*231.40*/("""{"""),format.raw/*231.41*/("""
                            """),format.raw/*232.29*/(""""searchable": false,
                            "orderable": false,
                            "targets":6
                        """),format.raw/*235.25*/("""}"""),format.raw/*235.26*/(""" """),format.raw/*235.27*/("""]
                    """),format.raw/*236.21*/("""}"""),format.raw/*236.22*/(""");
                    $('#projet_Tache').dataTable( """),format.raw/*237.51*/("""{"""),format.raw/*237.52*/("""
                        """),format.raw/*238.25*/(""""ordering": false
                    """),format.raw/*239.21*/("""}"""),format.raw/*239.22*/(""" """),format.raw/*239.23*/(""");


                    $('#dataTables-admin-client').DataTable("""),format.raw/*242.61*/("""{"""),format.raw/*242.62*/("""
                        """),format.raw/*243.25*/(""""columnDefs": ["""),format.raw/*243.40*/("""{"""),format.raw/*243.41*/("""
                            """),format.raw/*244.29*/(""""searchable": false,
                            "orderable": false,
                            "targets":6
                        """),format.raw/*247.25*/("""}"""),format.raw/*247.26*/(""" """),format.raw/*247.27*/("""]
                    """),format.raw/*248.21*/("""}"""),format.raw/*248.22*/(""");

                    $('#dataTables-admin-user').DataTable("""),format.raw/*250.59*/("""{"""),format.raw/*250.60*/("""
                        """),format.raw/*251.25*/(""""columnDefs": ["""),format.raw/*251.40*/("""{"""),format.raw/*251.41*/("""
                            """),format.raw/*252.29*/(""""searchable": false,
                            "orderable": false,
                            "targets":7
                        """),format.raw/*255.25*/("""}"""),format.raw/*255.26*/(""" """),format.raw/*255.27*/("""]
                    """),format.raw/*256.21*/("""}"""),format.raw/*256.22*/(""");

                    $('#btn-modifierTache').click(function() """),format.raw/*258.62*/("""{"""),format.raw/*258.63*/("""
                        """),format.raw/*259.25*/("""jQuery.fx.off = true;
                        $('#div-consulterTache').hide();
                        $('#div-modifierTache').show();
                        jQuery.fx.off = false;

                    """),format.raw/*264.21*/("""}"""),format.raw/*264.22*/(""");

                    $('#btn-fermer-modifierTache').click(function() """),format.raw/*266.69*/("""{"""),format.raw/*266.70*/("""
                        """),format.raw/*267.25*/("""jQuery.fx.off = true;
                        $('#div-consulterTache').show();
                        $('#div-modifierTache').hide();
                        jQuery.fx.off = false;

                    """),format.raw/*272.21*/("""}"""),format.raw/*272.22*/(""");

                    $('#btn-valider-modifierTache').click(function() """),format.raw/*274.70*/("""{"""),format.raw/*274.71*/("""
                        """),format.raw/*275.25*/("""jQuery.fx.off = true;
                        $('#div-consulterTache').show();
                        $('#div-modifierTache').hide();
                        jQuery.fx.off = false;

                    """),format.raw/*280.21*/("""}"""),format.raw/*280.22*/(""");

                    $('#btn-modifierTache-active').click(function() """),format.raw/*282.69*/("""{"""),format.raw/*282.70*/("""
                        """),format.raw/*283.25*/("""jQuery.fx.off = true;
                        $('#div-consulterTache').show();
                        $('#div-modifierTache').hide();
                        jQuery.fx.off = false;

                    """),format.raw/*288.21*/("""}"""),format.raw/*288.22*/(""");

                    $('#datepicker_date_debut .input-group.date').datepicker("""),format.raw/*290.78*/("""{"""),format.raw/*290.79*/("""
                        """),format.raw/*291.25*/("""todayBtn: "linked",
                        keyboardNavigation: false,
                        forceParse: false,
                        calendarWeeks: true,
                        autoclose: true,
                        language: "fr-FR"

                    """),format.raw/*298.21*/("""}"""),format.raw/*298.22*/(""");
                    $('#datepicker_date_fin_tot .input-group.date').datepicker("""),format.raw/*299.80*/("""{"""),format.raw/*299.81*/("""
                        """),format.raw/*300.25*/("""todayBtn: "linked",
                        keyboardNavigation: false,
                        forceParse: false,
                        calendarWeeks: true,
                        autoclose: true,
                        language: "fr-FR"
                    """),format.raw/*306.21*/("""}"""),format.raw/*306.22*/(""");
                    $('#datepicker_date_fin_tard .input-group.date').datepicker("""),format.raw/*307.81*/("""{"""),format.raw/*307.82*/("""
                        """),format.raw/*308.25*/("""todayBtn: "linked",
                        keyboardNavigation: false,
                        forceParse: false,
                        calendarWeeks: true,
                        autoclose: true,
                        language: "fr-FR"
                    """),format.raw/*314.21*/("""}"""),format.raw/*314.22*/(""");

                    $('#projet-tdb').slimScroll("""),format.raw/*316.49*/("""{"""),format.raw/*316.50*/("""
                        """),format.raw/*317.25*/("""height: '130px'
                    """),format.raw/*318.21*/("""}"""),format.raw/*318.22*/(""");
                    $('#tache-tdb').slimScroll("""),format.raw/*319.48*/("""{"""),format.raw/*319.49*/("""
                        """),format.raw/*320.25*/("""height: '130px'
                    """),format.raw/*321.21*/("""}"""),format.raw/*321.22*/(""");
                    $('#taches-retardes').slimScroll("""),format.raw/*322.54*/("""{"""),format.raw/*322.55*/("""
                        """),format.raw/*323.25*/("""height: '130px'
                    """),format.raw/*324.21*/("""}"""),format.raw/*324.22*/(""");
                    $('#taches-proches').slimScroll("""),format.raw/*325.53*/("""{"""),format.raw/*325.54*/("""
                        """),format.raw/*326.25*/("""height: '130px'
                    """),format.raw/*327.21*/("""}"""),format.raw/*327.22*/(""");
                    $('#taches-proposees').slimScroll("""),format.raw/*328.55*/("""{"""),format.raw/*328.56*/("""
                        """),format.raw/*329.25*/("""height: '130px'
                    """),format.raw/*330.21*/("""}"""),format.raw/*330.22*/(""");
                    $('#bloc-notes-tdb').slimScroll("""),format.raw/*331.53*/("""{"""),format.raw/*331.54*/("""
                        """),format.raw/*332.25*/("""height: '172px',
                        width: '100%'
                    """),format.raw/*334.21*/("""}"""),format.raw/*334.22*/(""");
                    $('.description-modal-tache').slimScroll("""),format.raw/*335.62*/("""{"""),format.raw/*335.63*/("""
                        """),format.raw/*336.25*/("""height: '100px'
                    """),format.raw/*337.21*/("""}"""),format.raw/*337.22*/(""");

                    $('.list-task').slimScroll("""),format.raw/*339.48*/("""{"""),format.raw/*339.49*/("""
                        """),format.raw/*340.25*/("""height: '90px'
                    """),format.raw/*341.21*/("""}"""),format.raw/*341.22*/(""");
                    $('.list-modif-client').slimScroll("""),format.raw/*342.56*/("""{"""),format.raw/*342.57*/("""
                        """),format.raw/*343.25*/("""height: '130px'
                    """),format.raw/*344.21*/("""}"""),format.raw/*344.22*/(""");

                    $('.list-personnes-notifiees').slimScroll("""),format.raw/*346.63*/("""{"""),format.raw/*346.64*/("""
                        """),format.raw/*347.25*/("""height: '85px'
                    """),format.raw/*348.21*/("""}"""),format.raw/*348.22*/(""");
                    /*
                     $('.table-suppr-user').slimScroll("""),format.raw/*350.56*/("""{"""),format.raw/*350.57*/("""
                     """),format.raw/*351.22*/("""height: '300px'
                     """),format.raw/*352.22*/("""}"""),format.raw/*352.23*/(""");
                     */

                    $('.footable').footable();

                    // $('#modal-tdb-tache').modal();

                """),format.raw/*359.17*/("""}"""),format.raw/*359.18*/(""");

                $( document ).ajaxComplete(function() """),format.raw/*361.55*/("""{"""),format.raw/*361.56*/("""
                    """),format.raw/*362.21*/("""$(".select2-predecesseur").select2("""),format.raw/*362.56*/("""{"""),format.raw/*362.57*/("""
                        """),format.raw/*363.25*/("""placeholder : '"""),_display_(/*363.41*/Messages("choosePredecessor")),format.raw/*363.70*/("""...',
                        maximumSelectionLength: 1
                    """),format.raw/*365.21*/("""}"""),format.raw/*365.22*/(""");

                    $(".select2-successeur").select2("""),format.raw/*367.54*/("""{"""),format.raw/*367.55*/("""
                        """),format.raw/*368.25*/("""placeholder : '"""),_display_(/*368.41*/Messages("chooseSuccessor")),format.raw/*368.68*/("""...'
                    """),format.raw/*369.21*/("""}"""),format.raw/*369.22*/(""");
                    $(".select2-client").select2("""),format.raw/*370.50*/("""{"""),format.raw/*370.51*/("""
                        """),format.raw/*371.25*/("""placeholder : '"""),_display_(/*371.41*/Messages("chooseClient")),format.raw/*371.65*/("""...',
                        maximumSelectionLength: 1
                    """),format.raw/*373.21*/("""}"""),format.raw/*373.22*/(""");

                    $(".select2-respo-projet").select2("""),format.raw/*375.56*/("""{"""),format.raw/*375.57*/("""
                        """),format.raw/*376.25*/("""placeholder : '"""),_display_(/*376.41*/Messages("chooseProjectManager")),format.raw/*376.73*/("""...',
                        maximumSelectionLength: 1
                    """),format.raw/*378.21*/("""}"""),format.raw/*378.22*/(""");
                    $(".select2-respo-tache").select2("""),format.raw/*379.55*/("""{"""),format.raw/*379.56*/("""
                        """),format.raw/*380.25*/("""placeholder : '"""),_display_(/*380.41*/Messages("chooseTaskResponsible")),format.raw/*380.74*/("""...',
                        maximumSelectionLength: 1
                    """),format.raw/*382.21*/("""}"""),format.raw/*382.22*/(""");

                    $('[data-toggle="popover"]').popover()
                    // activate Nestable for list 1
                    $('#nestable').nestable("""),format.raw/*386.45*/("""{"""),format.raw/*386.46*/("""
                        """),format.raw/*387.25*/("""group: 1,
                        maxDepth: 4
                    """),format.raw/*389.21*/("""}"""),format.raw/*389.22*/(""").on('change');


                    $('#dataTables-tdb-projet').DataTable();


                    $('#dataTables-tdb-tache').DataTable("""),format.raw/*395.58*/("""{"""),format.raw/*395.59*/("""
                        """),format.raw/*396.25*/(""""columnDefs": ["""),format.raw/*396.40*/("""{"""),format.raw/*396.41*/("""
                            """),format.raw/*397.29*/(""""searchable": false,
                            "orderable": false,
                            "targets": [6, 7]
                        """),format.raw/*400.25*/("""}"""),format.raw/*400.26*/(""" """),format.raw/*400.27*/("""]
                    """),format.raw/*401.21*/("""}"""),format.raw/*401.22*/(""");
                    $(".select2_demo_1").select2();

                    $('.dataTables-example').DataTable();

                    $('#projet_Projet').dataTable( """),format.raw/*406.52*/("""{"""),format.raw/*406.53*/("""
                        """),format.raw/*407.25*/(""""ordering": false
                    """),format.raw/*408.21*/("""}"""),format.raw/*408.22*/(""" """),format.raw/*408.23*/(""");

                    $('#dataTables-admin-projet').DataTable("""),format.raw/*410.61*/("""{"""),format.raw/*410.62*/("""
                        """),format.raw/*411.25*/(""""columnDefs": ["""),format.raw/*411.40*/("""{"""),format.raw/*411.41*/("""
                            """),format.raw/*412.29*/(""""searchable": false,
                            "orderable": false,
                            "targets":6
                        """),format.raw/*415.25*/("""}"""),format.raw/*415.26*/(""" """),format.raw/*415.27*/("""]
                    """),format.raw/*416.21*/("""}"""),format.raw/*416.22*/(""");
                    $('#projet_Tache').dataTable( """),format.raw/*417.51*/("""{"""),format.raw/*417.52*/("""
                        """),format.raw/*418.25*/(""""ordering": false
                    """),format.raw/*419.21*/("""}"""),format.raw/*419.22*/(""" """),format.raw/*419.23*/(""");


                    $('#dataTables-admin-client').DataTable("""),format.raw/*422.61*/("""{"""),format.raw/*422.62*/("""
                        """),format.raw/*423.25*/(""""columnDefs": ["""),format.raw/*423.40*/("""{"""),format.raw/*423.41*/("""
                            """),format.raw/*424.29*/(""""searchable": false,
                            "orderable": false,
                            "targets":6
                        """),format.raw/*427.25*/("""}"""),format.raw/*427.26*/(""" """),format.raw/*427.27*/("""]
                    """),format.raw/*428.21*/("""}"""),format.raw/*428.22*/(""");

                    $('#dataTables-admin-user').DataTable("""),format.raw/*430.59*/("""{"""),format.raw/*430.60*/("""
                        """),format.raw/*431.25*/(""""columnDefs": ["""),format.raw/*431.40*/("""{"""),format.raw/*431.41*/("""
                            """),format.raw/*432.29*/(""""searchable": false,
                            "orderable": false,
                            "targets":7
                        """),format.raw/*435.25*/("""}"""),format.raw/*435.26*/(""" """),format.raw/*435.27*/("""]
                    """),format.raw/*436.21*/("""}"""),format.raw/*436.22*/(""");

                    $('#btn-modifierTache').click(function() """),format.raw/*438.62*/("""{"""),format.raw/*438.63*/("""
                        """),format.raw/*439.25*/("""jQuery.fx.off = true;
                        $('#div-consulterTache').hide();
                        $('#div-modifierTache').show();
                        jQuery.fx.off = false;

                    """),format.raw/*444.21*/("""}"""),format.raw/*444.22*/(""");

                    $('#btn-fermer-modifierTache').click(function() """),format.raw/*446.69*/("""{"""),format.raw/*446.70*/("""
                        """),format.raw/*447.25*/("""jQuery.fx.off = true;
                        $('#div-consulterTache').show();
                        $('#div-modifierTache').hide();
                        jQuery.fx.off = false;

                    """),format.raw/*452.21*/("""}"""),format.raw/*452.22*/(""");

                    $('#btn-valider-modifierTache').click(function() """),format.raw/*454.70*/("""{"""),format.raw/*454.71*/("""
                        """),format.raw/*455.25*/("""jQuery.fx.off = true;
                        $('#div-consulterTache').show();
                        $('#div-modifierTache').hide();
                        jQuery.fx.off = false;

                    """),format.raw/*460.21*/("""}"""),format.raw/*460.22*/(""");

                    $('#btn-modifierTache-active').click(function() """),format.raw/*462.69*/("""{"""),format.raw/*462.70*/("""
                        """),format.raw/*463.25*/("""jQuery.fx.off = true;
                        $('#div-consulterTache').show();
                        $('#div-modifierTache').hide();
                        jQuery.fx.off = false;

                    """),format.raw/*468.21*/("""}"""),format.raw/*468.22*/(""");

                    $('#datepicker_date_debut .input-group.date').datepicker("""),format.raw/*470.78*/("""{"""),format.raw/*470.79*/("""
                        """),format.raw/*471.25*/("""todayBtn: "linked",
                        keyboardNavigation: false,
                        forceParse: false,
                        calendarWeeks: true,
                        autoclose: true,
                        language: "fr-FR"

                    """),format.raw/*478.21*/("""}"""),format.raw/*478.22*/(""");
                    $('#datepicker_date_fin_tot .input-group.date').datepicker("""),format.raw/*479.80*/("""{"""),format.raw/*479.81*/("""
                        """),format.raw/*480.25*/("""todayBtn: "linked",
                        keyboardNavigation: false,
                        forceParse: false,
                        calendarWeeks: true,
                        autoclose: true,
                        language: "fr-FR"
                    """),format.raw/*486.21*/("""}"""),format.raw/*486.22*/(""");
                    $('#datepicker_date_fin_tard .input-group.date').datepicker("""),format.raw/*487.81*/("""{"""),format.raw/*487.82*/("""
                        """),format.raw/*488.25*/("""todayBtn: "linked",
                        keyboardNavigation: false,
                        forceParse: false,
                        calendarWeeks: true,
                        autoclose: true,
                        language: "fr-FR"
                    """),format.raw/*494.21*/("""}"""),format.raw/*494.22*/(""");

                    $('#projet-tdb').slimScroll("""),format.raw/*496.49*/("""{"""),format.raw/*496.50*/("""
                        """),format.raw/*497.25*/("""height: '130px'
                    """),format.raw/*498.21*/("""}"""),format.raw/*498.22*/(""");
                    $('#tache-tdb').slimScroll("""),format.raw/*499.48*/("""{"""),format.raw/*499.49*/("""
                        """),format.raw/*500.25*/("""height: '130px'
                    """),format.raw/*501.21*/("""}"""),format.raw/*501.22*/(""");
                    $('#taches-retardes').slimScroll("""),format.raw/*502.54*/("""{"""),format.raw/*502.55*/("""
                        """),format.raw/*503.25*/("""height: '130px'
                    """),format.raw/*504.21*/("""}"""),format.raw/*504.22*/(""");
                    $('#taches-proches').slimScroll("""),format.raw/*505.53*/("""{"""),format.raw/*505.54*/("""
                        """),format.raw/*506.25*/("""height: '130px'
                    """),format.raw/*507.21*/("""}"""),format.raw/*507.22*/(""");
                    $('#taches-proposees').slimScroll("""),format.raw/*508.55*/("""{"""),format.raw/*508.56*/("""
                        """),format.raw/*509.25*/("""height: '130px'
                    """),format.raw/*510.21*/("""}"""),format.raw/*510.22*/(""");
                    $('#bloc-notes-tdb').slimScroll("""),format.raw/*511.53*/("""{"""),format.raw/*511.54*/("""
                        """),format.raw/*512.25*/("""height: '172px',
                        width: '100%'
                    """),format.raw/*514.21*/("""}"""),format.raw/*514.22*/(""");
                    $('.description-modal-tache').slimScroll("""),format.raw/*515.62*/("""{"""),format.raw/*515.63*/("""
                        """),format.raw/*516.25*/("""height: '100px'
                    """),format.raw/*517.21*/("""}"""),format.raw/*517.22*/(""");

                    $('.list-task').slimScroll("""),format.raw/*519.48*/("""{"""),format.raw/*519.49*/("""
                        """),format.raw/*520.25*/("""height: '90px'
                    """),format.raw/*521.21*/("""}"""),format.raw/*521.22*/(""");
                    $('.list-modif-client').slimScroll("""),format.raw/*522.56*/("""{"""),format.raw/*522.57*/("""
                        """),format.raw/*523.25*/("""height: '130px'
                    """),format.raw/*524.21*/("""}"""),format.raw/*524.22*/(""");

                    $('.list-personnes-notifiees').slimScroll("""),format.raw/*526.63*/("""{"""),format.raw/*526.64*/("""
                        """),format.raw/*527.25*/("""height: '85px'
                    """),format.raw/*528.21*/("""}"""),format.raw/*528.22*/(""");
                    /*
                     $('.table-suppr-user').slimScroll("""),format.raw/*530.56*/("""{"""),format.raw/*530.57*/("""
                     """),format.raw/*531.22*/("""height: '300px'
                     """),format.raw/*532.22*/("""}"""),format.raw/*532.23*/(""");
                     */

                    $('.footable').footable();

                    // $('#modal-tdb-tache').modal();

                """),format.raw/*539.17*/("""}"""),format.raw/*539.18*/(""");
        </script>
    </body>
</html>
"""))
      }
    }
  }

  def render(pageTitle:String,content:Html,scripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle,content,scripts)

  def f:((String,Html,Html) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle,content,scripts) => apply(pageTitle,content,scripts)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/main.scala.html
                  HASH: 58f1e4226dfe9f44139a7b5bbab7a5feaa9da6ca
                  MATRIX: 753->1|897->50|925->52|1115->215|1145->224|3259->2311|3287->2318|3329->2332|6260->5235|6276->5241|6329->5272|8162->7077|8191->7084|8228->7093|8312->7148|8342->7149|8393->7171|8462->7211|8492->7212|8543->7234|8660->7322|8690->7323|8742->7346|8830->7405|8860->7406|8911->7428|8965->7453|8995->7454|9046->7476|9110->7511|9140->7512|9221->7564|9251->7565|9302->7587|9368->7624|9398->7625|9449->7647|9479->7648|9533->7673|9563->7674|9616->7698|9646->7699|9757->7781|9787->7782|9841->7807|9885->7823|9936->7852|10041->7928|10071->7929|10157->7986|10187->7987|10241->8012|10285->8028|10334->8055|10388->8080|10418->8081|10499->8133|10529->8134|10583->8159|10627->8175|10673->8199|10778->8275|10808->8276|10896->8335|10926->8336|10980->8361|11024->8377|11078->8409|11183->8485|11213->8486|11299->8543|11329->8544|11383->8569|11427->8585|11482->8618|11587->8694|11617->8695|11805->8854|11835->8855|11889->8880|11984->8946|12014->8947|12181->9085|12211->9086|12265->9111|12309->9126|12339->9127|12397->9156|12565->9295|12595->9296|12625->9297|12676->9319|12706->9320|12901->9486|12931->9487|12985->9512|13052->9550|13082->9551|13112->9552|13205->9616|13235->9617|13289->9642|13333->9657|13363->9658|13421->9687|13583->9820|13613->9821|13643->9822|13694->9844|13724->9845|13806->9898|13836->9899|13890->9924|13957->9962|13987->9963|14017->9964|14111->10029|14141->10030|14195->10055|14239->10070|14269->10071|14327->10100|14489->10233|14519->10234|14549->10235|14600->10257|14630->10258|14721->10320|14751->10321|14805->10346|14849->10361|14879->10362|14937->10391|15099->10524|15129->10525|15159->10526|15210->10548|15240->10549|15334->10614|15364->10615|15418->10640|15650->10843|15680->10844|15781->10916|15811->10917|15865->10942|16097->11145|16127->11146|16229->11219|16259->11220|16313->11245|16545->11448|16575->11449|16676->11521|16706->11522|16760->11547|16992->11750|17022->11751|17132->11832|17162->11833|17216->11858|17508->12121|17538->12122|17649->12204|17679->12205|17733->12230|18024->12492|18054->12493|18166->12576|18196->12577|18250->12602|18541->12864|18571->12865|18652->12917|18682->12918|18736->12943|18801->12979|18831->12980|18910->13030|18940->13031|18994->13056|19059->13092|19089->13093|19174->13149|19204->13150|19258->13175|19323->13211|19353->13212|19437->13267|19467->13268|19521->13293|19586->13329|19616->13330|19702->13387|19732->13388|19786->13413|19851->13449|19881->13450|19965->13505|19995->13506|20049->13531|20153->13606|20183->13607|20276->13671|20306->13672|20360->13697|20425->13733|20455->13734|20535->13785|20565->13786|20619->13811|20683->13846|20713->13847|20800->13905|20830->13906|20884->13931|20949->13967|20979->13968|21074->14034|21104->14035|21158->14060|21222->14095|21252->14096|21362->14177|21392->14178|21443->14200|21509->14237|21539->14238|21715->14385|21745->14386|21832->14444|21862->14445|21912->14466|21976->14501|22006->14502|22060->14527|22104->14543|22155->14572|22260->14648|22290->14649|22376->14706|22406->14707|22460->14732|22504->14748|22553->14775|22607->14800|22637->14801|22718->14853|22748->14854|22802->14879|22846->14895|22892->14919|22997->14995|23027->14996|23115->15055|23145->15056|23199->15081|23243->15097|23297->15129|23402->15205|23432->15206|23518->15263|23548->15264|23602->15289|23646->15305|23701->15338|23806->15414|23836->15415|24024->15574|24054->15575|24108->15600|24203->15666|24233->15667|24400->15805|24430->15806|24484->15831|24528->15846|24558->15847|24616->15876|24784->16015|24814->16016|24844->16017|24895->16039|24925->16040|25120->16206|25150->16207|25204->16232|25271->16270|25301->16271|25331->16272|25424->16336|25454->16337|25508->16362|25552->16377|25582->16378|25640->16407|25802->16540|25832->16541|25862->16542|25913->16564|25943->16565|26025->16618|26055->16619|26109->16644|26176->16682|26206->16683|26236->16684|26330->16749|26360->16750|26414->16775|26458->16790|26488->16791|26546->16820|26708->16953|26738->16954|26768->16955|26819->16977|26849->16978|26940->17040|26970->17041|27024->17066|27068->17081|27098->17082|27156->17111|27318->17244|27348->17245|27378->17246|27429->17268|27459->17269|27553->17334|27583->17335|27637->17360|27869->17563|27899->17564|28000->17636|28030->17637|28084->17662|28316->17865|28346->17866|28448->17939|28478->17940|28532->17965|28764->18168|28794->18169|28895->18241|28925->18242|28979->18267|29211->18470|29241->18471|29351->18552|29381->18553|29435->18578|29727->18841|29757->18842|29868->18924|29898->18925|29952->18950|30243->19212|30273->19213|30385->19296|30415->19297|30469->19322|30760->19584|30790->19585|30871->19637|30901->19638|30955->19663|31020->19699|31050->19700|31129->19750|31159->19751|31213->19776|31278->19812|31308->19813|31393->19869|31423->19870|31477->19895|31542->19931|31572->19932|31656->19987|31686->19988|31740->20013|31805->20049|31835->20050|31921->20107|31951->20108|32005->20133|32070->20169|32100->20170|32184->20225|32214->20226|32268->20251|32372->20326|32402->20327|32495->20391|32525->20392|32579->20417|32644->20453|32674->20454|32754->20505|32784->20506|32838->20531|32902->20566|32932->20567|33019->20625|33049->20626|33103->20651|33168->20687|33198->20688|33293->20754|33323->20755|33377->20780|33441->20815|33471->20816|33581->20897|33611->20898|33662->20920|33728->20957|33758->20958|33934->21105|33964->21106
                  LINES: 27->1|32->1|34->3|42->11|42->11|76->45|76->45|78->47|140->109|140->109|140->109|193->162|193->162|194->163|195->164|195->164|197->166|197->166|197->166|198->167|199->168|199->168|201->170|201->170|201->170|202->171|202->171|202->171|203->172|204->173|204->173|205->174|205->174|206->175|207->176|207->176|208->177|208->177|210->179|210->179|211->180|211->180|213->182|213->182|214->183|214->183|214->183|216->185|216->185|218->187|218->187|219->188|219->188|219->188|220->189|220->189|221->190|221->190|222->191|222->191|222->191|224->193|224->193|226->195|226->195|227->196|227->196|227->196|229->198|229->198|230->199|230->199|231->200|231->200|231->200|233->202|233->202|237->206|237->206|238->207|240->209|240->209|246->215|246->215|247->216|247->216|247->216|248->217|251->220|251->220|251->220|252->221|252->221|257->226|257->226|258->227|259->228|259->228|259->228|261->230|261->230|262->231|262->231|262->231|263->232|266->235|266->235|266->235|267->236|267->236|268->237|268->237|269->238|270->239|270->239|270->239|273->242|273->242|274->243|274->243|274->243|275->244|278->247|278->247|278->247|279->248|279->248|281->250|281->250|282->251|282->251|282->251|283->252|286->255|286->255|286->255|287->256|287->256|289->258|289->258|290->259|295->264|295->264|297->266|297->266|298->267|303->272|303->272|305->274|305->274|306->275|311->280|311->280|313->282|313->282|314->283|319->288|319->288|321->290|321->290|322->291|329->298|329->298|330->299|330->299|331->300|337->306|337->306|338->307|338->307|339->308|345->314|345->314|347->316|347->316|348->317|349->318|349->318|350->319|350->319|351->320|352->321|352->321|353->322|353->322|354->323|355->324|355->324|356->325|356->325|357->326|358->327|358->327|359->328|359->328|360->329|361->330|361->330|362->331|362->331|363->332|365->334|365->334|366->335|366->335|367->336|368->337|368->337|370->339|370->339|371->340|372->341|372->341|373->342|373->342|374->343|375->344|375->344|377->346|377->346|378->347|379->348|379->348|381->350|381->350|382->351|383->352|383->352|390->359|390->359|392->361|392->361|393->362|393->362|393->362|394->363|394->363|394->363|396->365|396->365|398->367|398->367|399->368|399->368|399->368|400->369|400->369|401->370|401->370|402->371|402->371|402->371|404->373|404->373|406->375|406->375|407->376|407->376|407->376|409->378|409->378|410->379|410->379|411->380|411->380|411->380|413->382|413->382|417->386|417->386|418->387|420->389|420->389|426->395|426->395|427->396|427->396|427->396|428->397|431->400|431->400|431->400|432->401|432->401|437->406|437->406|438->407|439->408|439->408|439->408|441->410|441->410|442->411|442->411|442->411|443->412|446->415|446->415|446->415|447->416|447->416|448->417|448->417|449->418|450->419|450->419|450->419|453->422|453->422|454->423|454->423|454->423|455->424|458->427|458->427|458->427|459->428|459->428|461->430|461->430|462->431|462->431|462->431|463->432|466->435|466->435|466->435|467->436|467->436|469->438|469->438|470->439|475->444|475->444|477->446|477->446|478->447|483->452|483->452|485->454|485->454|486->455|491->460|491->460|493->462|493->462|494->463|499->468|499->468|501->470|501->470|502->471|509->478|509->478|510->479|510->479|511->480|517->486|517->486|518->487|518->487|519->488|525->494|525->494|527->496|527->496|528->497|529->498|529->498|530->499|530->499|531->500|532->501|532->501|533->502|533->502|534->503|535->504|535->504|536->505|536->505|537->506|538->507|538->507|539->508|539->508|540->509|541->510|541->510|542->511|542->511|543->512|545->514|545->514|546->515|546->515|547->516|548->517|548->517|550->519|550->519|551->520|552->521|552->521|553->522|553->522|554->523|555->524|555->524|557->526|557->526|558->527|559->528|559->528|561->530|561->530|562->531|563->532|563->532|570->539|570->539
                  -- GENERATED --
              */
          