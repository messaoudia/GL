
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object graph_chartist_Scope0 {
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

class graph_chartist extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Chartist</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/plugins/chartist/chartist.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body>
    <div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html">Profile</a></li>
                            <li><a href="contacts.html">Contacts</a></li>
                            <li><a href="mailbox.html">Mailbox</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html">Logout</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>
                <li>
                    <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span> <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="index.html">Dashboard v.1</a></li>
                        <li><a href="dashboard_2.html">Dashboard v.2</a></li>
                        <li><a href="dashboard_3.html">Dashboard v.3</a></li>
                        <li><a href="dashboard_4_1.html">Dashboard v.4</a></li>
                        <li><a href="dashboard_5.html">Dashboard v.5 <span class="label label-primary pull-right">NEW</span></a></li>
                    </ul>
                </li>
                <li>
                    <a href="layouts.html"><i class="fa fa-diamond"></i> <span class="nav-label">Layouts</span></a>
                </li>
                <li class="active">
                    <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">Graphs</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="graph_flot.html">Flot Charts</a></li>
                        <li><a href="graph_morris.html">Morris.js Charts</a></li>
                        <li><a href="graph_rickshaw.html">Rickshaw Charts</a></li>
                        <li><a href="graph_chartjs.html">Chart.js</a></li>
                        <li class="active"><a href="graph_chartist.html">Chartist</a></li>
                        <li><a href="graph_peity.html">Peity Charts</a></li>
                        <li><a href="graph_sparkline.html">Sparkline Charts</a></li>
                    </ul>
                </li>
                <li>
                    <a href="mailbox.html"><i class="fa fa-envelope"></i> <span class="nav-label">Mailbox </span><span class="label label-warning pull-right">16/24</span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="mailbox.html">Inbox</a></li>
                        <li><a href="mail_detail.html">Email view</a></li>
                        <li><a href="mail_compose.html">Compose email</a></li>
                        <li><a href="email_template.html">Email templates</a></li>
                    </ul>
                </li>
                <li>
                    <a href="metrics.html"><i class="fa fa-pie-chart"></i> <span class="nav-label">Metrics</span>  </a>
                </li>
                <li>
                    <a href="widgets.html"><i class="fa fa-flask"></i> <span class="nav-label">Widgets</span></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">Forms</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="form_basic.html">Basic form</a></li>
                        <li><a href="form_advanced.html">Advanced Plugins</a></li>
                        <li><a href="form_wizard.html">Wizard</a></li>
                        <li><a href="form_file_upload.html">File Upload</a></li>
                        <li><a href="form_editors.html">Text Editor</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-desktop"></i> <span class="nav-label">App Views</span>  <span class="pull-right label label-primary">SPECIAL</span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="contacts.html">Contacts</a></li>
                        <li><a href="profile.html">Profile</a></li>
                        <li><a href="profile_2.html">Profile v.2</a></li>
                        <li><a href="contacts_2.html">Contacts v.2</a></li>
                        <li><a href="projects.html">Projects</a></li>
                        <li><a href="project_detail.html">Project detail</a></li>
                        <li><a href="teams_board.html">Teams board</a></li>
                        <li><a href="social_feed.html">Social feed</a></li>
                        <li><a href="clients.html">Clients</a></li>
                        <li><a href="full_height.html">Outlook view</a></li>
                        <li><a href="vote_list.html">Vote list</a></li>
                        <li><a href="file_manager.html">File manager</a></li>
                        <li><a href="calendar.html">Calendar</a></li>
                        <li><a href="issue_tracker.html">Issue tracker</a></li>
                        <li><a href="blog.html">Blog</a></li>
                        <li><a href="article.html">Article</a></li>
                        <li><a href="faq.html">FAQ</a></li>
                        <li><a href="timeline.html">Timeline</a></li>
                        <li><a href="pin_board.html">Pin board</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-files-o"></i> <span class="nav-label">Other Pages</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="search_results.html">Search results</a></li>
                        <li><a href="lockscreen.html">Lockscreen</a></li>
                        <li><a href="invoice.html">Invoice</a></li>
                        <li><a href="login.html">Login</a></li>
                        <li><a href="login_two_columns.html">Login v.2</a></li>
                        <li><a href="forgot_password.html">Forget password</a></li>
                        <li><a href="register.html">Register</a></li>
                        <li><a href="404.html">404 Page</a></li>
                        <li><a href="500.html">500 Page</a></li>
                        <li><a href="empty_page.html">Empty page</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-globe"></i> <span class="nav-label">Miscellaneous</span><span class="label label-info pull-right">NEW</span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="toastr_notifications.html">Notification</a></li>
                        <li><a href="nestable_list.html">Nestable list</a></li>
                        <li><a href="agile_board.html">Agile board</a></li>
                        <li><a href="timeline_2.html">Timeline v.2</a></li>
                        <li><a href="diff.html">Diff</a></li>
                        <li><a href="sweetalert.html">Sweet alert</a></li>
                        <li><a href="idle_timer.html">Idle timer</a></li>
                        <li><a href="spinners.html">Spinners</a></li>
                        <li><a href="tinycon.html">Live favicon</a></li>
                        <li><a href="google_maps.html">Google maps</a></li>
                        <li><a href="code_editor.html">Code editor</a></li>
                        <li><a href="modal_window.html">Modal window</a></li>
                        <li><a href="forum_main.html">Forum view</a></li>
                        <li><a href="validation.html">Validation</a></li>
                        <li><a href="tree_view.html">Tree view</a></li>
                        <li><a href="chat_view.html">Chat view</a></li>
                        <li><a href="masonry.html">Masonry</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">UI Elements</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="typography.html">Typography</a></li>
                        <li><a href="icons.html">Icons</a></li>
                        <li><a href="draggable_panels.html">Draggable Panels</a></li>
                        <li><a href="buttons.html">Buttons</a></li>
                        <li><a href="video.html">Video</a></li>
                        <li><a href="tabs_panels.html">Panels</a></li>
                        <li><a href="tabs.html">Tabs</a></li>
                        <li><a href="notifications.html">Notifications & Tooltips</a></li>
                        <li><a href="badges_labels.html">Badges, Labels, Progress</a></li>
                    </ul>
                </li>

                <li>
                    <a href="grid_options.html"><i class="fa fa-laptop"></i> <span class="nav-label">Grid options</span></a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table"></i> <span class="nav-label">Tables</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="table_basic.html">Static Tables</a></li>
                        <li><a href="table_data_tables.html">Data Tables</a></li>
                        <li><a href="table_foo_table.html">Foo Tables</a></li>
                        <li><a href="jq_grid.html">jqGrid</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-shopping-cart"></i> <span class="nav-label">E-commerce</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="ecommerce_products_grid.html">Products grid</a></li>
                        <li><a href="ecommerce_product_list.html">Products list</a></li>
                        <li><a href="ecommerce_product.html">Product edit</a></li>
                        <li><a href="ecommerce_product_detail.html">Product detail</a></li>
                        <li><a href="ecommerce-orders.html">Orders</a></li>
                        <li><a href="ecommerce_payments.html">Credit Card form</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-picture-o"></i> <span class="nav-label">Gallery</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="basic_gallery.html">Lightbox Gallery</a></li>
                        <li><a href="slick_carousel.html">Slick Carousel</a></li>
                        <li><a href="carousel.html">Bootstrap Carousel</a></li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">Menu Levels </span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li>
                            <a href="#">Third Level <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>

                            </ul>
                        </li>
                        <li><a href="#">Second Level Item</a></li>
                        <li>
                            <a href="#">Second Level Item</a></li>
                        <li>
                            <a href="#">Second Level Item</a></li>
                    </ul>
                </li>
                <li>
                    <a href="css_animation.html"><i class="fa fa-magic"></i> <span class="nav-label">CSS Animations </span><span class="label label-info pull-right">62</span></a>
                </li>
                <li class="landing_link">
                    <a target="_blank" href="landing.html"><i class="fa fa-star"></i> <span class="nav-label">Landing Page</span> <span class="label label-warning pull-right">NEW</span></a>
                </li>
                <li class="special_link">
                    <a href="package.html"><i class="fa fa-database"></i> <span class="nav-label">Package</span></a>
                </li>
            </ul>

        </div>
    </nav>

        <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            <form role="search" class="navbar-form-custom" action="search_results.html">
                <div class="form-group">
                    <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                </div>
            </form>
        </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">Welcome to INSPINIA+ Admin Theme.</span>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/a7.jpg">
                                </a>
                                <div class="media-body">
                                    <small class="pull-right">46h ago</small>
                                    <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                    <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/a4.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right text-navy">5h ago</small>
                                    <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                    <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="dropdown-messages-box">
                                <a href="profile.html" class="pull-left">
                                    <img alt="image" class="img-circle" src="img/profile.jpg">
                                </a>
                                <div class="media-body ">
                                    <small class="pull-right">23h ago</small>
                                    <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                    <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="mailbox.html">
                                    <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="mailbox.html">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="profile.html">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="grid_options.html">
                                <div>
        """),
format.raw("""                            <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="notifications.html">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="login.html">
                        <i class="fa fa-sign-out"></i> Log out
                    </a>
                </li>
            </ul>

        </nav>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>Chartist</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li>
                        <a>Graphs</a>
                    </li>
                    <li class="active">
                        <strong>Chartist</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Simple line chart
                            </h5>
                        </div>
                        <div class="ibox-content">
                            <div id="ct-chart1" class="ct-perfect-fourth"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Line scatter diagram</h5>
                        </div>
                        <div class="ibox-content">
                            <div id="ct-chart2" class="ct-perfect-fourth"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Stacked bar chart</h5>
                        </div>
                        <div class="ibox-content">
                            <div id="ct-chart3" class="ct-perfect-fourth"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Horizontal bar chart </h5>
                        </div>
                        <div class="ibox-content">
                            <div id="ct-chart4" class="ct-perfect-fourth"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Simple pie chart</h5>
                        </div>
                        <div class="ibox-content">
                            <div id="ct-chart5" class="ct-perfect-fourth"></div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Gauge chart </h5>
                        </div>
                        <div class="ibox-content">
                            <div id="ct-chart6" class="ct-perfect-fourth"></div>
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

    <!-- Chartist -->
    <script src="js/plugins/chartist/chartist.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <script>
        $(document).ready(function()"""),format.raw/*479.37*/("""{"""),format.raw/*479.38*/("""


            """),format.raw/*482.13*/("""// Simple line

            new Chartist.Line('#ct-chart1', """),format.raw/*484.45*/("""{"""),format.raw/*484.46*/("""
                """),format.raw/*485.17*/("""labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'],
                series: [
                    [12, 9, 7, 8, 5],
                    [2, 1, 3.5, 7, 3],
                    [1, 3, 4, 5, 6]
                ]
            """),format.raw/*491.13*/("""}"""),format.raw/*491.14*/(""", """),format.raw/*491.16*/("""{"""),format.raw/*491.17*/("""
                """),format.raw/*492.17*/("""fullWidth: true,
                chartPadding: """),format.raw/*493.31*/("""{"""),format.raw/*493.32*/("""
                    """),format.raw/*494.21*/("""right: 40
                """),format.raw/*495.17*/("""}"""),format.raw/*495.18*/("""
            """),format.raw/*496.13*/("""}"""),format.raw/*496.14*/(""");


            // Line scatter diagram

            var times = function(n) """),format.raw/*501.37*/("""{"""),format.raw/*501.38*/("""
                """),format.raw/*502.17*/("""return Array.apply(null, new Array(n));
            """),format.raw/*503.13*/("""}"""),format.raw/*503.14*/(""";

            var data = times(26).map(Math.random).reduce(function(data, rnd, index) """),format.raw/*505.85*/("""{"""),format.raw/*505.86*/("""
                """),format.raw/*506.17*/("""data.labels.push(index + 1);
                data.series.forEach(function(series) """),format.raw/*507.54*/("""{"""),format.raw/*507.55*/("""
                    """),format.raw/*508.21*/("""series.push(Math.random() * 100)
                """),format.raw/*509.17*/("""}"""),format.raw/*509.18*/(""");

                return data;
            """),format.raw/*512.13*/("""}"""),format.raw/*512.14*/(""", """),format.raw/*512.16*/("""{"""),format.raw/*512.17*/("""
                """),format.raw/*513.17*/("""labels: [],
                series: times(4).map(function() """),format.raw/*514.49*/("""{"""),format.raw/*514.50*/(""" """),format.raw/*514.51*/("""return new Array() """),format.raw/*514.70*/("""}"""),format.raw/*514.71*/(""")
            """),format.raw/*515.13*/("""}"""),format.raw/*515.14*/(""");

            var options = """),format.raw/*517.27*/("""{"""),format.raw/*517.28*/("""
                """),format.raw/*518.17*/("""showLine: false,
                axisX: """),format.raw/*519.24*/("""{"""),format.raw/*519.25*/("""
                    """),format.raw/*520.21*/("""labelInterpolationFnc: function(value, index) """),format.raw/*520.67*/("""{"""),format.raw/*520.68*/("""
                        """),format.raw/*521.25*/("""return index % 13 === 0 ? 'W' + value : null;
                    """),format.raw/*522.21*/("""}"""),format.raw/*522.22*/("""
                """),format.raw/*523.17*/("""}"""),format.raw/*523.18*/("""
            """),format.raw/*524.13*/("""}"""),format.raw/*524.14*/(""";

            new Chartist.Line('#ct-chart2', data, options);


            // Stocked bar chart

            new Chartist.Bar('#ct-chart3', """),format.raw/*531.44*/("""{"""),format.raw/*531.45*/("""
                """),format.raw/*532.17*/("""labels: ['Q1', 'Q2', 'Q3', 'Q4'],
                series: [
                    [800000, 1200000, 1400000, 1300000],
                    [200000, 400000, 500000, 300000],
                    [100000, 200000, 400000, 600000]
                ]
            """),format.raw/*538.13*/("""}"""),format.raw/*538.14*/(""", """),format.raw/*538.16*/("""{"""),format.raw/*538.17*/("""
                """),format.raw/*539.17*/("""stackBars: true,
                axisY: """),format.raw/*540.24*/("""{"""),format.raw/*540.25*/("""
                    """),format.raw/*541.21*/("""labelInterpolationFnc: function(value) """),format.raw/*541.60*/("""{"""),format.raw/*541.61*/("""
                        """),format.raw/*542.25*/("""return (value / 1000) + 'k';
                    """),format.raw/*543.21*/("""}"""),format.raw/*543.22*/("""
                """),format.raw/*544.17*/("""}"""),format.raw/*544.18*/("""
            """),format.raw/*545.13*/("""}"""),format.raw/*545.14*/(""").on('draw', function(data) """),format.raw/*545.42*/("""{"""),format.raw/*545.43*/("""
                        """),format.raw/*546.25*/("""if(data.type === 'bar') """),format.raw/*546.49*/("""{"""),format.raw/*546.50*/("""
                            """),format.raw/*547.29*/("""data.element.attr("""),format.raw/*547.47*/("""{"""),format.raw/*547.48*/("""
                                """),format.raw/*548.33*/("""style: 'stroke-width: 30px'
                            """),format.raw/*549.29*/("""}"""),format.raw/*549.30*/(""");
                        """),format.raw/*550.25*/("""}"""),format.raw/*550.26*/("""
                    """),format.raw/*551.21*/("""}"""),format.raw/*551.22*/(""");


            // Stocked horizontal bar

            new Chartist.Bar('#ct-chart4', """),format.raw/*556.44*/("""{"""),format.raw/*556.45*/("""
                """),format.raw/*557.17*/("""labels: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
                series: [
                    [5, 4, 3, 7, 5, 10, 3],
                    [3, 2, 9, 5, 4, 6, 4]
                ]
            """),format.raw/*562.13*/("""}"""),format.raw/*562.14*/(""", """),format.raw/*562.16*/("""{"""),format.raw/*562.17*/("""
                """),format.raw/*563.17*/("""seriesBarDistance: 10,
                reverseData: true,
                horizontalBars: true,
                axisY: """),format.raw/*566.24*/("""{"""),format.raw/*566.25*/("""
                    """),format.raw/*567.21*/("""offset: 70
                """),format.raw/*568.17*/("""}"""),format.raw/*568.18*/("""
            """),format.raw/*569.13*/("""}"""),format.raw/*569.14*/(""");


            // Simple pie chart

            var data = """),format.raw/*574.24*/("""{"""),format.raw/*574.25*/("""
                """),format.raw/*575.17*/("""series: [5, 3, 4]
            """),format.raw/*576.13*/("""}"""),format.raw/*576.14*/(""";

            var sum = function(a, b) """),format.raw/*578.38*/("""{"""),format.raw/*578.39*/(""" """),format.raw/*578.40*/("""return a + b """),format.raw/*578.53*/("""}"""),format.raw/*578.54*/(""";

            new Chartist.Pie('#ct-chart5', data, """),format.raw/*580.50*/("""{"""),format.raw/*580.51*/("""
                """),format.raw/*581.17*/("""labelInterpolationFnc: function(value) """),format.raw/*581.56*/("""{"""),format.raw/*581.57*/("""
                    """),format.raw/*582.21*/("""return Math.round(value / data.series.reduce(sum) * 100) + '%';
                """),format.raw/*583.17*/("""}"""),format.raw/*583.18*/("""
            """),format.raw/*584.13*/("""}"""),format.raw/*584.14*/(""");

            // Gauge chart

            new Chartist.Pie('#ct-chart6', """),format.raw/*588.44*/("""{"""),format.raw/*588.45*/("""
                """),format.raw/*589.17*/("""series: [20, 10, 30, 40]
            """),format.raw/*590.13*/("""}"""),format.raw/*590.14*/(""", """),format.raw/*590.16*/("""{"""),format.raw/*590.17*/("""
                """),format.raw/*591.17*/("""donut: true,
                donutWidth: 60,
                startAngle: 270,
                total: 200,
                showLabel: false
            """),format.raw/*596.13*/("""}"""),format.raw/*596.14*/(""");

        """),format.raw/*598.9*/("""}"""),format.raw/*598.10*/(""");
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
object graph_chartist extends graph_chartist_Scope0.graph_chartist
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:21 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/graph_chartist.scala.html
                  HASH: 770b82a70d077d8fd15a39e0d8db18464fb3ef4a
                  MATRIX: 854->0|26402->25499|26432->25500|26479->25518|26570->25580|26600->25581|26647->25599|26917->25840|26947->25841|26978->25843|27008->25844|27055->25862|27132->25910|27162->25911|27213->25933|27269->25960|27299->25961|27342->25975|27372->25976|27484->26059|27514->26060|27561->26078|27643->26131|27673->26132|27791->26221|27821->26222|27868->26240|27980->26323|28010->26324|28061->26346|28140->26396|28170->26397|28247->26445|28277->26446|28308->26448|28338->26449|28385->26467|28475->26528|28505->26529|28535->26530|28583->26549|28613->26550|28657->26565|28687->26566|28748->26598|28778->26599|28825->26617|28895->26658|28925->26659|28976->26681|29051->26727|29081->26728|29136->26754|29232->26821|29262->26822|29309->26840|29339->26841|29382->26855|29412->26856|29590->27005|29620->27006|29667->27024|29956->27284|29986->27285|30017->27287|30047->27288|30094->27306|30164->27347|30194->27348|30245->27370|30313->27409|30343->27410|30398->27436|30477->27486|30507->27487|30554->27505|30584->27506|30627->27520|30657->27521|30714->27549|30744->27550|30799->27576|30852->27600|30882->27601|30941->27631|30988->27649|31018->27650|31081->27684|31167->27741|31197->27742|31254->27770|31284->27771|31335->27793|31365->27794|31486->27886|31516->27887|31563->27905|31827->28140|31857->28141|31888->28143|31918->28144|31965->28162|32116->28284|32146->28285|32197->28307|32254->28335|32284->28336|32327->28350|32357->28351|32452->28417|32482->28418|32529->28436|32589->28467|32619->28468|32690->28510|32720->28511|32750->28512|32792->28525|32822->28526|32905->28580|32935->28581|32982->28599|33050->28638|33080->28639|33131->28661|33241->28742|33271->28743|33314->28757|33344->28758|33452->28837|33482->28838|33529->28856|33596->28894|33626->28895|33657->28897|33687->28898|33734->28916|33919->29072|33949->29073|33991->29087|34021->29088
                  LINES: 32->1|511->479|511->479|514->482|516->484|516->484|517->485|523->491|523->491|523->491|523->491|524->492|525->493|525->493|526->494|527->495|527->495|528->496|528->496|533->501|533->501|534->502|535->503|535->503|537->505|537->505|538->506|539->507|539->507|540->508|541->509|541->509|544->512|544->512|544->512|544->512|545->513|546->514|546->514|546->514|546->514|546->514|547->515|547->515|549->517|549->517|550->518|551->519|551->519|552->520|552->520|552->520|553->521|554->522|554->522|555->523|555->523|556->524|556->524|563->531|563->531|564->532|570->538|570->538|570->538|570->538|571->539|572->540|572->540|573->541|573->541|573->541|574->542|575->543|575->543|576->544|576->544|577->545|577->545|577->545|577->545|578->546|578->546|578->546|579->547|579->547|579->547|580->548|581->549|581->549|582->550|582->550|583->551|583->551|588->556|588->556|589->557|594->562|594->562|594->562|594->562|595->563|598->566|598->566|599->567|600->568|600->568|601->569|601->569|606->574|606->574|607->575|608->576|608->576|610->578|610->578|610->578|610->578|610->578|612->580|612->580|613->581|613->581|613->581|614->582|615->583|615->583|616->584|616->584|620->588|620->588|621->589|622->590|622->590|622->590|622->590|623->591|628->596|628->596|630->598|630->598
                  -- GENERATED --
              */
          