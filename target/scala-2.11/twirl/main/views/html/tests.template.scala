
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object tests_Scope0 {
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

class tests extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Task],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(taches: List[Task]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.22*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta nom="viewport" content="width=device-width, initial-scale=1.0">

        <title>MyProjects | Tests</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

        <link href="css/animate.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body class="gray-bg">
        <div class="middle-box text-center animated fadeInDown">
            <div>
                <div>

                    <h4 class="logo-nom">Tests</h4>
                    <form method="POST" action="/changeLanguage">
                        <input name="language" type="submit" value="en" title="English">
                        <input name="language" type="submit" value="fr" title="French">
                        <input name="return_url" type="hidden" value=""""),_display_(/*29.72*/request()/*29.81*/.path()),format.raw/*29.88*/("""">
                    </form>
                        <!-- Form errors goes here -->
                    <div id="errorOutputPlace" style="color:red">

                    </div>
                </div>
                <form id="addTaskhForm" class="m-t" role="form" method="POST">
                    <div class='row'>
                        <div class='col-sm-3'>
                            <div class='form-group'>
                                <label for="nom">"""),_display_(/*40.51*/Messages("name")),format.raw/*40.67*/("""</label>
                                <input class="form-control" id="nom" name="nom" required="true" size="30" type="text" />
                            </div>
                        </div>
                        <div class='col-sm-3'>
                            <div class='form-group'>
                                <label for="description">"""),_display_(/*46.59*/Messages("description")),format.raw/*46.82*/("""</label>
                                <input class="form-control" id="description" name="description" required="true" type="text" />
                            </div>
                        </div>
                        <div class='col-sm-3'>
                            <div class='form-group'>
                                <label for="charge">"""),_display_(/*52.54*/Messages("load")),format.raw/*52.70*/("""</label>
                                <input class="form-control" id="charge" name="charge" required="true" size="30" type="number" />
                            </div>
                        </div>
                        <div class='col-sm-3'>
                            <div class='form-group'>
                                <label for="user_lastname">"""),_display_(/*58.61*/Messages("submit")),format.raw/*58.79*/("""</label>
                                <button id="addTask" type="submit" class="form-control btn btn-primary block full-width m-b">
                                """),_display_(/*60.34*/Messages("add")),format.raw/*60.49*/("""</button>
                            </div>
                        </div>
                    </div>
                </form>

                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Custom responsive table </h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>

                                            <th>#</th>
                                            <th>Nom </th>
                                            <th>Description </th>
                                            <th>Charge </th>
                                        </tr>
                                    </thead>
                                    <tbody id="taskList">
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>


                <p class="m-t"> <small>MyProjects &copy; 2016</small> </p>
            </div>
        </div>


            <!-- Mainly scripts -->
        <script src="js/jquery-2.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
            <!-- Play Framework Javascript Routes -->
        <script type="text/javascript" src=""""),_display_(/*119.46*/routes/*119.52*/.Application.javascriptRoutes()),format.raw/*119.83*/(""""></script>

        <script type="application/javascript">

                // For simplification purpose
                var doc = $ (document);

                // Waiting until the web page load all the scripts and the contents
                doc.ready (function() """),format.raw/*127.39*/("""{"""),format.raw/*127.40*/("""
                    """),format.raw/*128.21*/("""//########################################
                    //  Ajax call for initializing the view
                    //########################################
                    jsRoutes.controllers.Tests.getAll().ajax("""),format.raw/*131.62*/("""{"""),format.raw/*131.63*/("""
                        """),format.raw/*132.25*/("""success : function(data) """),format.raw/*132.50*/("""{"""),format.raw/*132.51*/("""
                            """),format.raw/*133.29*/("""var tacheList = $('#taskList');
                            $(data).each(function(index, tache) """),format.raw/*134.65*/("""{"""),format.raw/*134.66*/("""
                                """),format.raw/*135.33*/("""var list ="";
                                list+=('<tr>');
                                list+=('<td>'+tache.id+'</td>');
                                list+=('<td>'+tache.nom+'</td>');
                                list+=('<td>'+tache.description+'</td>');
                                list+=('<td>'+tache.charge+'</td>');
                                list+=('</tr>');

                                tacheList.append(list);
                            """),format.raw/*144.29*/("""}"""),format.raw/*144.30*/(""");

                        """),format.raw/*146.25*/("""}"""),format.raw/*146.26*/("""
                    """),format.raw/*147.21*/("""}"""),format.raw/*147.22*/(""");
                    //########################################

                    //########################################
                    //  Ajax call for adding a task
                    //########################################

                    $( "#addTaskhForm" ).submit(function( event ) """),format.raw/*154.67*/("""{"""),format.raw/*154.68*/("""

                        """),format.raw/*156.25*/("""// Stop form from submitting normally
                        event.preventDefault();

                        // Get the form itself:
                        var $form = $( this );

                        // We call the controller created in the controllers package responsible for adding a task
                        // The controller is available throw the routes file:
                        // POST        /addTask                   controllers.Tests.addTask()




                        jsRoutes.controllers.Tests.addTask().ajax("""),format.raw/*169.67*/("""{"""),format.raw/*169.68*/("""
                            """),format.raw/*170.29*/("""// Serialising the form to send it
                            data :$form.serialize(),
                            // Case the operation end successfully
                            success : function(task) """),format.raw/*173.54*/("""{"""),format.raw/*173.55*/(""" """),format.raw/*173.56*/("""// task is the response coming from the server

                                // Logging for debug purpose
                                console.log(task)

                                // Creating the HTML element
                                var list ="";
                                list+=('<tr>');
                                list+=('<td>'+task.id+'</td>');
                                list+=('<td>'+task.nom+'</td>');
                                list+=('<td>'+task.description+'</td>');
                                list+=('<td>'+task.charge+'</td>');
                                list+=('</tr>');

                                // Adding the newly created task to the html element having the id="tacheList"
                                $('#taskList').append(list);

                                // Emptying the form after a successful add
                                $("#addTaskhForm")[0].reset();
                                $('#errorOutputPlace').empty();
                            """),format.raw/*193.29*/("""}"""),format.raw/*193.30*/(""",
                            //Case we have a problem
                            error: function(errorMessage)"""),format.raw/*195.58*/("""{"""),format.raw/*195.59*/("""
                                """),format.raw/*196.33*/("""// This is an exemple of handling a problem related to a wrong form inputs
                                // The errorMessage came from the controller and can be personalised

                                // Deleting old error messages
                                $('#errorOutputPlace').empty();

                                $.each($.parseJSON(errorMessage.responseText), function(inputKey, inputError) """),format.raw/*202.111*/("""{"""),format.raw/*202.112*/("""
                                    """),format.raw/*203.37*/("""console.error(inputKey + ' => ' + inputError);

                                    // Pushing the error to the view in the appropriate HTML elements
                                    $('#errorOutputPlace').append(inputKey + ' => ' + inputError+"<br>");
                                """),format.raw/*207.33*/("""}"""),format.raw/*207.34*/(""");
                            """),format.raw/*208.29*/("""}"""),format.raw/*208.30*/("""
                        """),format.raw/*209.25*/("""}"""),format.raw/*209.26*/(""");

                    """),format.raw/*211.21*/("""}"""),format.raw/*211.22*/(""");
                    //########################################


                    //########################################
                    //  All the Ajax calls goes here
                    //########################################



                    //########################################
                """),format.raw/*222.17*/("""}"""),format.raw/*222.18*/(""");

        </script>

    </body>

</html>
"""))
      }
    }
  }

  def render(taches:List[Task]): play.twirl.api.HtmlFormat.Appendable = apply(taches)

  def f:((List[Task]) => play.twirl.api.HtmlFormat.Appendable) = (taches) => apply(taches)

  def ref: this.type = this

}


}

/**/
object tests extends tests_Scope0.tests
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/tests.scala.html
                  HASH: 95f7a2f9d9291fa667ea17714ed8dfb05abd19ea
                  MATRIX: 749->1|864->21|892->23|1891->995|1909->1004|1937->1011|2445->1492|2482->1508|2869->1868|2913->1891|3301->2252|3338->2268|3735->2638|3774->2656|3971->2826|4007->2841|6611->5417|6627->5423|6680->5454|6987->5732|7017->5733|7068->5755|7327->5985|7357->5986|7412->6012|7466->6037|7496->6038|7555->6068|7681->6165|7711->6166|7774->6200|8282->6679|8312->6680|8371->6710|8401->6711|8452->6733|8482->6734|8830->7053|8860->7054|8917->7082|9499->7635|9529->7636|9588->7666|9828->7877|9858->7878|9888->7879|10976->8938|11006->8939|11149->9053|11179->9054|11242->9088|11693->9509|11724->9510|11791->9548|12112->9840|12142->9841|12203->9873|12233->9874|12288->9900|12318->9901|12373->9927|12403->9928|12772->10268|12802->10269
                  LINES: 27->1|32->1|33->2|60->29|60->29|60->29|71->40|71->40|77->46|77->46|83->52|83->52|89->58|89->58|91->60|91->60|150->119|150->119|150->119|158->127|158->127|159->128|162->131|162->131|163->132|163->132|163->132|164->133|165->134|165->134|166->135|175->144|175->144|177->146|177->146|178->147|178->147|185->154|185->154|187->156|200->169|200->169|201->170|204->173|204->173|204->173|224->193|224->193|226->195|226->195|227->196|233->202|233->202|234->203|238->207|238->207|239->208|239->208|240->209|240->209|242->211|242->211|253->222|253->222
                  -- GENERATED --
              */
          