
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object dashboard_4_Scope0 {
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

class dashboard_4 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Dashboard v.4</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="top-navigation">

    <div id="wrapper">
        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom white-bg">
        <nav class="navbar navbar-static-top" role="navigation">
            <div class="navbar-header">
                <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                    <i class="fa fa-reorder"></i>
                </button>
                <a href="#" class="navbar-brand">Inspinia</a>
            </div>
            <div class="navbar-collapse collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a aria-expanded="false" role="button" href="layouts.html"> Back to main Layout page</a>
                    </li>
                    <li class="dropdown">
                        <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> Menu item <span class="caret"></span></a>
                        <ul role="menu" class="dropdown-menu">
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                            <li><a href="">Menu item</a></li>
                        </ul>
                    </li>

                </ul>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        </div>
        <div class="wrapper wrapper-content">
            <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-success pull-right">Monthly</span>
                            <h5>Views</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins">386,200</h1>
                            <div class="stat-percent font-bold text-success">98% <i class="fa fa-bolt"></i></div>
                            <small>Total views</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-info pull-right">Annual</span>
                            <h5>Orders</h5>
                        </div>
                        <div class="ibox-content">
                                    <h1 class="no-margins">80,800</h1>
                                    <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i></div>
                                    <small>New orders</small>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <span class="label label-primary pull-right">Today</span>
                            <h5>Vistits</h5>
                        </div>
                        <div class="ibox-content">

                            <div class="row">
                                <div class="col-md-6">
                                    <h1 class="no-margins">$ 406,420</h1>
                                    <div class="font-bold text-navy">44% <i class="fa fa-level-up"></i> <small>Rapid pace</small></div>
                                </div>
                                <div class="col-md-6">
                                    <h1 class="no-margins">206,120</h1>
                                    <div class="font-bold text-navy">22% <i class="fa fa-level-up"></i> <small>Slow pace</small></div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Monthly income</h5>
                            <div class="ibox-tools">
                                <span class="label label-primary">Updated 12.2015</span>
                            </div>
                        </div>
                        <div class="ibox-content no-padding">
                            <div class="flot-chart m-t-lg" style="height: 55px;">
                                <div class="flot-chart-content" id="flot-chart1"></div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
                <div class="row">
                    <div class="col-lg-8">
                        <div class="ibox float-e-margins">
                            <div class="ibox-content">
                                <div>
                                        <span class="pull-right text-right">
                                        <small>Average value of sales in the past month in: <strong>United states</strong></small>
                                            <br/>
                                            All sales: 162,862
                                        </span>
                                    <h3 class="font-bold no-margins">
                                        Half-year revenue margin
                                    </h3>
                                    <small>Sales marketing.</small>
                                </div>

                                <div class="m-t-sm">

                                    <div class="row">
                                        <div class="col-md-8">
                                            <div>
                                            <canvas id="lineChart" height="114"></canvas>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <ul class="stat-list m-t-lg">
                                                <li>
                                                    <h2 class="no-margins">2,346</h2>
                                                    <small>Total orders in period</small>
                                                    <div class="progress progress-mini">
                                                        <div class="progress-bar" style="width: 48%;"></div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <h2 class="no-margins ">4,422</h2>
                                                    <small>Orders in last month</small>
                                                    <div class="progress progress-mini">
                                                        <div class="progress-bar" style="width: 60%;"></div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>

                                </div>

                                <div class="m-t-md">
                                    <small class="pull-right">
                                        <i class="fa fa-clock-o"> </i>
                                        Update on 16.07.2015
                                    </small>
                                    <small>
                                        <strong>Analysis of sales:</strong> The value has been changed over time, and last month reached a level over $50,000.
                                    </small>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-warning pull-right">Data has changed</span>
                                <h5>User activity</h5>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <small class="stats-label">Pages / Visit</small>
                                        <h4>236 321.80</h4>
                                    </div>

                                    <div class="col-xs-4">
                                        <small class="stats-label">% New Visits</small>
                                        <h4>46.11%</h4>
                                    </div>
                                    <div class="col-xs-4">
                                        <small class="stats-label">Last week</small>
                                        <h4>432.021</h4>
                                    </div>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <small class="stats-label">Pages / Visit</small>
                                        <h4>643 321.10</h4>
                                    </div>

                                    <div class="col-xs-4">
                                        <small class="stats-label">% New Visits</small>
                                        <h4>92.43%</h4>
                                    </div>
                                    <div class="col-xs-4">
                                        <small class="stats-label">Last week</small>
                                        <h4>564.554</h4>
                                    </div>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <small class="stats-label">Pages / Visit</small>
                                        <h4>436 547.20</h4>
                                    </div>

                                    <div class="col-xs-4">
                                        <small class="stats-label">% New Visits</small>
                                        <h4>150.23%</h4>
                                    </div>
                                    <div class="col-xs-4">
                                        <small class="stats-label">Last week</small>
                                        <h4>124.990</h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row">

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
                                <div class="row">
                                    <div class="col-sm-9 m-b-xs">
                                        <div data-toggle="buttons" class="btn-group">
                                            <label class="btn btn-sm btn-white"> <input type="radio" id="option1" name="options"> Day </label>
                                            <label class="btn btn-sm btn-white active"> <input type="radio" id="option2" name="options"> Week </label>
                                            <label class="btn btn-sm btn-white"> <input type="radio" id="option3" name="options"> Month </label>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="input-group"><input type="text" placeholder="Search" class="input-sm form-control"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> Go!</button> </span></div>
                                    </div>
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-striped">
                                        <thead>
                                        <tr>

                                            <th>#</th>
                                            <th>Project </th>
                                            <th>Name </th>
                                            <th>Phone </th>
                                            <th>Company </th>
                                            <th>Completed </th>
                                            <th>Task</th>
                                            <th>Date</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Project <small>This is example of project</small></td>
                                            <td>Patrick Smith</td>
                                            <td>0800 051213</td>
                                            <td>Inceptos Hymenaeos Ltd</td>
                                            <td><span class="pie">0.52/1.561</span></td>
                                            <td>20%</td>
                                            <td>Jul 14, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Alpha project</td>
                                            <td>Alice Jackson</td>
                                            <td>0500 780909</td>
                                            <td>Nec Euismod In Company</td>
                                            <td><span class="pie">6,9</span></td>
                                            <td>40%</td>
                                            <td>Jul 16, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Betha project</td>
                                            <td>John Smith</td>
                                            <td>0800 1111</td>
                                            <td>Erat Volutpat</td>
                                            <td><span class="pie">3,1</span></td>
                                            <td>75%</td>
                                            <td>Jul 18, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td"""),
format.raw(""">Gamma project</td>
                                            <td>Anna Jordan</td>
                                            <td>(016977) 0648</td>
                                            <td>Tellus Ltd</td>
                                            <td><span class="pie">4,9</span></td>
                                            <td>18%</td>
                                            <td>Jul 22, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Alpha project</td>
                                            <td>Alice Jackson</td>
                                            <td>0500 780909</td>
                                            <td>Nec Euismod In Company</td>
                                            <td><span class="pie">6,9</span></td>
                                            <td>40%</td>
                                            <td>Jul 16, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>Project <small>This is example of project</small></td>
                                            <td>Patrick Smith</td>
                                            <td>0800 051213</td>
                                            <td>Inceptos Hymenaeos Ltd</td>
                                            <td><span class="pie">0.52/1.561</span></td>
                                            <td>20%</td>
                                            <td>Jul 14, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>Gamma project</td>
                                            <td>Anna Jordan</td>
                                            <td>(016977) 0648</td>
                                            <td>Tellus Ltd</td>
                                            <td><span class="pie">4,9</span></td>
                                            <td>18%</td>
                                            <td>Jul 22, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>Project <small>This is example of project</small></td>
                                            <td>Patrick Smith</td>
                                            <td>0800 051213</td>
                                            <td>Inceptos Hymenaeos Ltd</td>
                                            <td><span class="pie">0.52/1.561</span></td>
                                            <td>20%</td>
                                            <td>Jul 14, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Alpha project</td>
                                            <td>Alice Jackson</td>
                                            <td>0500 780909</td>
                                            <td>Nec Euismod In Company</td>
                                            <td><span class="pie">6,9</span></td>
                                            <td>40%</td>
                                            <td>Jul 16, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Betha project</td>
                                            <td>John Smith</td>
                                            <td>0800 1111</td>
                                            <td>Erat Volutpat</td>
                                            <td><span class="pie">3,1</span></td>
                                            <td>75%</td>
                                            <td>Jul 18, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>Gamma project</td>
                                            <td>Anna Jordan</td>
                                            <td>(016977) 0648</td>
                                            <td>Tellus Ltd</td>
                                            <td><span class="pie">4,9</span></td>
                                            <td>18%</td>
                                            <td>Jul 22, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Alpha project</td>
                                            <td>Alice Jackson</td>
                                            <td>0500 780909</td>
                                            <td>Nec Euismod In Company</td>
                                            <td><span class="pie">6,9</span></td>
                                            <td>40%</td>
                                            <td>Jul 16, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>Project <small>This is example of project</small></td>
                                            <td>Patrick Smith</td>
                                            <td>0800 051213</td>
                                            <td>Inceptos Hymenaeos Ltd</td>
                                            <td><span class="pie">0.52/1.561</span></td>
                                            <td>20%</td>
                                            <td>Jul 14, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>Gamma project</td>
                                            <td>Anna Jordan</td>
                                            <td>(016977) 0648</td>
                                            <td>Tellus Ltd</td>
                                            <td><span class="pie">4,9</span></td>
                                            <td>18%</td>
                                            <td>Jul 22, 2013</td>
                                            <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>
        <div class="footer">
            <div class="pull-right">
                10GB of <strong>250GB</strong> Free.
            </div>
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2015
            </div>
        </div>

        </div>
        </div>



    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- Flot -->
    <script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>

    <!-- ChartJS-->
    <script src="js/plugins/chartJs/Chart.min.js"></script>

    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>
    <!-- Peity demo -->
    <script src="js/demo/peity-demo.js"></script>


    <script>
        $(document).ready(function() """),format.raw/*535.38*/("""{"""),format.raw/*535.39*/("""


            """),format.raw/*538.13*/("""var d1 = [[1262304000000, 6], [1264982400000, 3057], [1267401600000, 20434], [1270080000000, 31982], [1272672000000, 26602], [1275350400000, 27826], [1277942400000, 24302], [1280620800000, 24237], [1283299200000, 21004], [1285891200000, 12144], [1288569600000, 10577], [1291161600000, 10295]];
            var d2 = [[1262304000000, 5], [1264982400000, 200], [1267401600000, 1605], [1270080000000, 6129], [1272672000000, 11643], [1275350400000, 19055], [1277942400000, 30062], [1280620800000, 39197], [1283299200000, 37000], [1285891200000, 27000], [1288569600000, 21000], [1291161600000, 17000]];

            var data1 = [
                """),format.raw/*542.17*/("""{"""),format.raw/*542.18*/(""" """),format.raw/*542.19*/("""label: "Data 1", data: d1, color: '#17a084'"""),format.raw/*542.62*/("""}"""),format.raw/*542.63*/(""",
                """),format.raw/*543.17*/("""{"""),format.raw/*543.18*/(""" """),format.raw/*543.19*/("""label: "Data 2", data: d2, color: '#127e68' """),format.raw/*543.63*/("""}"""),format.raw/*543.64*/("""
            """),format.raw/*544.13*/("""];
            $.plot($("#flot-chart1"), data1, """),format.raw/*545.46*/("""{"""),format.raw/*545.47*/("""
                """),format.raw/*546.17*/("""xaxis: """),format.raw/*546.24*/("""{"""),format.raw/*546.25*/("""
                    """),format.raw/*547.21*/("""tickDecimals: 0
                """),format.raw/*548.17*/("""}"""),format.raw/*548.18*/(""",
                series: """),format.raw/*549.25*/("""{"""),format.raw/*549.26*/("""
                    """),format.raw/*550.21*/("""lines: """),format.raw/*550.28*/("""{"""),format.raw/*550.29*/("""
                        """),format.raw/*551.25*/("""show: true,
                        fill: true,
                        fillColor: """),format.raw/*553.36*/("""{"""),format.raw/*553.37*/("""
                            """),format.raw/*554.29*/("""colors: ["""),format.raw/*554.38*/("""{"""),format.raw/*554.39*/("""
                                """),format.raw/*555.33*/("""opacity: 1
                            """),format.raw/*556.29*/("""}"""),format.raw/*556.30*/(""", """),format.raw/*556.32*/("""{"""),format.raw/*556.33*/("""
                                """),format.raw/*557.33*/("""opacity: 1
                            """),format.raw/*558.29*/("""}"""),format.raw/*558.30*/("""]
                        """),format.raw/*559.25*/("""}"""),format.raw/*559.26*/(""",
                    """),format.raw/*560.21*/("""}"""),format.raw/*560.22*/(""",
                    points: """),format.raw/*561.29*/("""{"""),format.raw/*561.30*/("""
                        """),format.raw/*562.25*/("""width: 0.1,
                        show: false
                    """),format.raw/*564.21*/("""}"""),format.raw/*564.22*/(""",
                """),format.raw/*565.17*/("""}"""),format.raw/*565.18*/(""",
                grid: """),format.raw/*566.23*/("""{"""),format.raw/*566.24*/("""
                    """),format.raw/*567.21*/("""show: false,
                    borderWidth: 0
                """),format.raw/*569.17*/("""}"""),format.raw/*569.18*/(""",
                legend: """),format.raw/*570.25*/("""{"""),format.raw/*570.26*/("""
                    """),format.raw/*571.21*/("""show: false,
                """),format.raw/*572.17*/("""}"""),format.raw/*572.18*/("""
            """),format.raw/*573.13*/("""}"""),format.raw/*573.14*/(""");

            var lineData = """),format.raw/*575.28*/("""{"""),format.raw/*575.29*/("""
                """),format.raw/*576.17*/("""labels: ["January", "February", "March", "April", "May", "June", "July"],
                datasets: [
                    """),format.raw/*578.21*/("""{"""),format.raw/*578.22*/("""
                        """),format.raw/*579.25*/("""label: "Example dataset",
                        fillColor: "rgba(220,220,220,0.5)",
                        strokeColor: "rgba(220,220,220,1)",
                        pointColor: "rgba(220,220,220,1)",
                        pointStrokeColor: "#fff",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(220,220,220,1)",
                        data: [65, 59, 40, 51, 36, 25, 40]
                    """),format.raw/*587.21*/("""}"""),format.raw/*587.22*/(""",
                    """),format.raw/*588.21*/("""{"""),format.raw/*588.22*/("""
                        """),format.raw/*589.25*/("""label: "Example dataset",
                        fillColor: "rgba(26,179,148,0.5)",
                        strokeColor: "rgba(26,179,148,0.7)",
                        pointColor: "rgba(26,179,148,1)",
                        pointStrokeColor: "#fff",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(26,179,148,1)",
                        data: [48, 48, 60, 39, 56, 37, 30]
                    """),format.raw/*597.21*/("""}"""),format.raw/*597.22*/("""
                """),format.raw/*598.17*/("""]
            """),format.raw/*599.13*/("""}"""),format.raw/*599.14*/(""";

            var lineOptions = """),format.raw/*601.31*/("""{"""),format.raw/*601.32*/("""
                """),format.raw/*602.17*/("""scaleShowGridLines: true,
                scaleGridLineColor: "rgba(0,0,0,.05)",
                scaleGridLineWidth: 1,
                bezierCurve: true,
                bezierCurveTension: 0.4,
                pointDot: true,
                pointDotRadius: 4,
                pointDotStrokeWidth: 1,
                pointHitDetectionRadius: 20,
                datasetStroke: true,
                datasetStrokeWidth: 2,
                datasetFill: true,
                responsive: true,
            """),format.raw/*615.13*/("""}"""),format.raw/*615.14*/(""";


            var ctx = document.getElementById("lineChart").getContext("2d");
            var myNewChart = new Chart(ctx).Line(lineData, lineOptions);

        """),format.raw/*621.9*/("""}"""),format.raw/*621.10*/(""");
    </script>

</body>

</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object dashboard_4 extends dashboard_4_Scope0.dashboard_4
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:20 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/dashboard_4.scala.html
                  HASH: d8a62be30bbd1b35400a6d03a66a38392ee6d28d
                  MATRIX: 848->0|30554->29657|30584->29658|30631->29676|31304->30320|31334->30321|31364->30322|31436->30365|31466->30366|31514->30385|31544->30386|31574->30387|31647->30431|31677->30432|31720->30446|31798->30495|31828->30496|31875->30514|31911->30521|31941->30522|31992->30544|32054->30577|32084->30578|32140->30605|32170->30606|32221->30628|32257->30635|32287->30636|32342->30662|32456->30747|32486->30748|32545->30778|32583->30787|32613->30788|32676->30822|32745->30862|32775->30863|32806->30865|32836->30866|32899->30900|32968->30940|32998->30941|33054->30968|33084->30969|33136->30992|33166->30993|33226->31024|33256->31025|33311->31051|33410->31121|33440->31122|33488->31141|33518->31142|33572->31167|33602->31168|33653->31190|33748->31256|33778->31257|33834->31284|33864->31285|33915->31307|33974->31337|34004->31338|34047->31352|34077->31353|34139->31386|34169->31387|34216->31405|34369->31529|34399->31530|34454->31556|34946->32019|34976->32020|35028->32043|35058->32044|35113->32070|35603->32531|35633->32532|35680->32550|35724->32565|35754->32566|35818->32601|35848->32602|35895->32620|36442->33138|36472->33139|36669->33308|36699->33309
                  LINES: 32->1|567->535|567->535|570->538|574->542|574->542|574->542|574->542|574->542|575->543|575->543|575->543|575->543|575->543|576->544|577->545|577->545|578->546|578->546|578->546|579->547|580->548|580->548|581->549|581->549|582->550|582->550|582->550|583->551|585->553|585->553|586->554|586->554|586->554|587->555|588->556|588->556|588->556|588->556|589->557|590->558|590->558|591->559|591->559|592->560|592->560|593->561|593->561|594->562|596->564|596->564|597->565|597->565|598->566|598->566|599->567|601->569|601->569|602->570|602->570|603->571|604->572|604->572|605->573|605->573|607->575|607->575|608->576|610->578|610->578|611->579|619->587|619->587|620->588|620->588|621->589|629->597|629->597|630->598|631->599|631->599|633->601|633->601|634->602|647->615|647->615|653->621|653->621
                  -- GENERATED --
              */
          