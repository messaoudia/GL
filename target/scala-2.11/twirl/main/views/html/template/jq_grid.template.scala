
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object jq_grid_Scope0 {
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

class jq_grid extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | jqGrid</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/plugins/jQueryUI/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
    <link href="css/plugins/jqGrid/ui.jqgrid.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <style>
        /* Additional style to fix warning dialog position */
        #alertmod_table_list_2 """),format.raw/*20.32*/("""{"""),format.raw/*20.33*/("""
            """),format.raw/*21.13*/("""top: 900px !important;
        """),format.raw/*22.9*/("""}"""),format.raw/*22.10*/("""
    """),format.raw/*23.5*/("""</style>
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
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">Graphs</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="graph_flot.html">Flot Charts</a></li>
                        <li><a href="graph_morris.html">Morris.js Charts</a></li>
                        <li><a href="graph_rickshaw.html">Rickshaw Charts</a></li>
                        <li><a href="graph_chartjs.html">Chart.js</a></li>
                        <li><a href="graph_chartist.html">Chartist</a></li>
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
                <li class="active">
                    <a href="#"><i class="fa fa-table"></i> <span class="nav-label">Tables</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="table_basic.html">Static Tables</a></li>
                        <li><a href="table_data_tables.html">Data Tables</a></li>
                        <li><a href="table_foo_table.html">Foo Tables</a></li>
                        <li class="active"><a href="jq_grid.html">jqGrid</a></li>
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
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="text-center link-block">
                                <a href="notifica"""),
format.raw("""tions.html">
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
                    <h2>jqGrid</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li>
                            <a>Tables</a>
                        </li>
                        <li class="active">
                            <strong>jqGrid</strong>
                        </li>
                    </ol>
                </div>
            </div>
        <div class="wrapper wrapper-content  animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>jQuery Grid Plugin – jqGrid</h5>
                        </div>
                        <div class="ibox-content">
                            <p>
                                <strong>jqGrid</strong> is an Ajax-enabled JavaScript control that provides solutions for representing and manipulating tabular data on the web. Since the grid is a client-side solution loading data dynamically through Ajax callbacks, it can be integrated with any server-side technology, including PHP, ASP, Java Servlets, JSP, ColdFusion, and Perl.
                                jqGrid uses a jQuery Java Script Library and is written as plugin for that package. For more information on jQuery Grid, please refer to the <a target="_blank" href="http://www.trirand.com/blog/"> jqGrid web site.</a>
                            </p>

                            <h4>Basic example</h4>

                            <div class="jqGrid_wrapper">
                                <table id="table_list_1"></table>
                                <div id="pager_list_1"></div>
                           </div>

                            <h4>Advanced example</h4>
                            <p>

                            </p>

                            <div class="jqGrid_wrapper">
                                <table id="table_list_2"></table>
                                <div id="pager_list_2"></div>
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

    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>

    <!-- jqGrid -->
    <script src="js/plugins/jqGrid/i18n/grid.locale-en.js"></script>
    <script src="js/plugins/jqGrid/jquery.jqGrid.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>


    <script>
        $(document).ready(function () """),format.raw/*455.39*/("""{"""),format.raw/*455.40*/("""


            """),format.raw/*458.13*/("""// Examle data for jqGrid
            var mydata = [
                """),format.raw/*460.17*/("""{"""),format.raw/*460.18*/("""id: "1", invdate: "2010-05-24", name: "test", note: "note", tax: "10.00", total: "2111.00""""),format.raw/*460.108*/("""}"""),format.raw/*460.109*/(""" """),format.raw/*460.110*/(""",
                """),format.raw/*461.17*/("""{"""),format.raw/*461.18*/("""id: "2", invdate: "2010-05-25", name: "test2", note: "note2", tax: "20.00", total: "320.00""""),format.raw/*461.109*/("""}"""),format.raw/*461.110*/(""",
                """),format.raw/*462.17*/("""{"""),format.raw/*462.18*/("""id: "3", invdate: "2007-09-01", name: "test3", note: "note3", tax: "30.00", total: "430.00""""),format.raw/*462.109*/("""}"""),format.raw/*462.110*/(""",
                """),format.raw/*463.17*/("""{"""),format.raw/*463.18*/("""id: "4", invdate: "2007-10-04", name: "test", note: "note", tax: "10.00", total: "210.00""""),format.raw/*463.107*/("""}"""),format.raw/*463.108*/(""",
                """),format.raw/*464.17*/("""{"""),format.raw/*464.18*/("""id: "5", invdate: "2007-10-05", name: "test2", note: "note2", tax: "20.00", total: "320.00""""),format.raw/*464.109*/("""}"""),format.raw/*464.110*/(""",
                """),format.raw/*465.17*/("""{"""),format.raw/*465.18*/("""id: "6", invdate: "2007-09-06", name: "test3", note: "note3", tax: "30.00", total: "430.00""""),format.raw/*465.109*/("""}"""),format.raw/*465.110*/(""",
                """),format.raw/*466.17*/("""{"""),format.raw/*466.18*/("""id: "7", invdate: "2007-10-04", name: "test", note: "note", tax: "10.00", total: "210.00""""),format.raw/*466.107*/("""}"""),format.raw/*466.108*/(""",
                """),format.raw/*467.17*/("""{"""),format.raw/*467.18*/("""id: "8", invdate: "2007-10-03", name: "test2", note: "note2", amount: "300.00", tax: "21.00", total: "320.00""""),format.raw/*467.127*/("""}"""),format.raw/*467.128*/(""",
                """),format.raw/*468.17*/("""{"""),format.raw/*468.18*/("""id: "9", invdate: "2007-09-01", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00""""),format.raw/*468.127*/("""}"""),format.raw/*468.128*/(""",
                """),format.raw/*469.17*/("""{"""),format.raw/*469.18*/("""id: "11", invdate: "2007-10-01", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00""""),format.raw/*469.126*/("""}"""),format.raw/*469.127*/(""",
                """),format.raw/*470.17*/("""{"""),format.raw/*470.18*/("""id: "12", invdate: "2007-10-02", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00""""),format.raw/*470.128*/("""}"""),format.raw/*470.129*/(""",
                """),format.raw/*471.17*/("""{"""),format.raw/*471.18*/("""id: "13", invdate: "2007-09-01", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00""""),format.raw/*471.128*/("""}"""),format.raw/*471.129*/(""",
                """),format.raw/*472.17*/("""{"""),format.raw/*472.18*/("""id: "14", invdate: "2007-10-04", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00""""),format.raw/*472.126*/("""}"""),format.raw/*472.127*/(""",
                """),format.raw/*473.17*/("""{"""),format.raw/*473.18*/("""id: "15", invdate: "2007-10-05", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00""""),format.raw/*473.128*/("""}"""),format.raw/*473.129*/(""",
                """),format.raw/*474.17*/("""{"""),format.raw/*474.18*/("""id: "16", invdate: "2007-09-06", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00""""),format.raw/*474.128*/("""}"""),format.raw/*474.129*/(""",
                """),format.raw/*475.17*/("""{"""),format.raw/*475.18*/("""id: "17", invdate: "2007-10-04", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00""""),format.raw/*475.126*/("""}"""),format.raw/*475.127*/(""",
                """),format.raw/*476.17*/("""{"""),format.raw/*476.18*/("""id: "18", invdate: "2007-10-03", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00""""),format.raw/*476.128*/("""}"""),format.raw/*476.129*/(""",
                """),format.raw/*477.17*/("""{"""),format.raw/*477.18*/("""id: "19", invdate: "2007-09-01", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00""""),format.raw/*477.128*/("""}"""),format.raw/*477.129*/(""",
                """),format.raw/*478.17*/("""{"""),format.raw/*478.18*/("""id: "21", invdate: "2007-10-01", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00""""),format.raw/*478.126*/("""}"""),format.raw/*478.127*/(""",
                """),format.raw/*479.17*/("""{"""),format.raw/*479.18*/("""id: "22", invdate: "2007-10-02", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00""""),format.raw/*479.128*/("""}"""),format.raw/*479.129*/(""",
                """),format.raw/*480.17*/("""{"""),format.raw/*480.18*/("""id: "23", invdate: "2007-09-01", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00""""),format.raw/*480.128*/("""}"""),format.raw/*480.129*/(""",
                """),format.raw/*481.17*/("""{"""),format.raw/*481.18*/("""id: "24", invdate: "2007-10-04", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00""""),format.raw/*481.126*/("""}"""),format.raw/*481.127*/(""",
                """),format.raw/*482.17*/("""{"""),format.raw/*482.18*/("""id: "25", invdate: "2007-10-05", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00""""),format.raw/*482.128*/("""}"""),format.raw/*482.129*/(""",
                """),format.raw/*483.17*/("""{"""),format.raw/*483.18*/("""id: "26", invdate: "2007-09-06", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00""""),format.raw/*483.128*/("""}"""),format.raw/*483.129*/(""",
                """),format.raw/*484.17*/("""{"""),format.raw/*484.18*/("""id: "27", invdate: "2007-10-04", name: "test", note: "note", amount: "200.00", tax: "10.00", total: "210.00""""),format.raw/*484.126*/("""}"""),format.raw/*484.127*/(""",
                """),format.raw/*485.17*/("""{"""),format.raw/*485.18*/("""id: "28", invdate: "2007-10-03", name: "test2", note: "note2", amount: "300.00", tax: "20.00", total: "320.00""""),format.raw/*485.128*/("""}"""),format.raw/*485.129*/(""",
                """),format.raw/*486.17*/("""{"""),format.raw/*486.18*/("""id: "29", invdate: "2007-09-01", name: "test3", note: "note3", amount: "400.00", tax: "30.00", total: "430.00""""),format.raw/*486.128*/("""}"""),format.raw/*486.129*/("""
            """),format.raw/*487.13*/("""];

            // Configuration for jqGrid Example 1
            $("#table_list_1").jqGrid("""),format.raw/*490.39*/("""{"""),format.raw/*490.40*/("""
                """),format.raw/*491.17*/("""data: mydata,
                datatype: "local",
                height: 250,
                autowidth: true,
                shrinkToFit: true,
                rowNum: 14,
                rowList: [10, 20, 30],
                colNames: ['Inv No', 'Date', 'Client', 'Amount', 'Tax', 'Total', 'Notes'],
                colModel: [
                    """),format.raw/*500.21*/("""{"""),format.raw/*500.22*/("""name: 'id', index: 'id', width: 60, sorttype: "int""""),format.raw/*500.73*/("""}"""),format.raw/*500.74*/(""",
                    """),format.raw/*501.21*/("""{"""),format.raw/*501.22*/("""name: 'invdate', index: 'invdate', width: 90, sorttype: "date", formatter: "date""""),format.raw/*501.103*/("""}"""),format.raw/*501.104*/(""",
                    """),format.raw/*502.21*/("""{"""),format.raw/*502.22*/("""name: 'name', index: 'name', width: 100"""),format.raw/*502.61*/("""}"""),format.raw/*502.62*/(""",
                    """),format.raw/*503.21*/("""{"""),format.raw/*503.22*/("""name: 'amount', index: 'amount', width: 80, align: "right", sorttype: "float", formatter: "number""""),format.raw/*503.120*/("""}"""),format.raw/*503.121*/(""",
                    """),format.raw/*504.21*/("""{"""),format.raw/*504.22*/("""name: 'tax', index: 'tax', width: 80, align: "right", sorttype: "float""""),format.raw/*504.93*/("""}"""),format.raw/*504.94*/(""",
                    """),format.raw/*505.21*/("""{"""),format.raw/*505.22*/("""name: 'total', index: 'total', width: 80, align: "right", sorttype: "float""""),format.raw/*505.97*/("""}"""),format.raw/*505.98*/(""",
                    """),format.raw/*506.21*/("""{"""),format.raw/*506.22*/("""name: 'note', index: 'note', width: 150, sortable: false"""),format.raw/*506.78*/("""}"""),format.raw/*506.79*/("""
                """),format.raw/*507.17*/("""],
                pager: "#pager_list_1",
                viewrecords: true,
                caption: "Example jqGrid 1",
                hidegrid: false
            """),format.raw/*512.13*/("""}"""),format.raw/*512.14*/(""");

            // Configuration for jqGrid Example 2
            $("#table_list_2").jqGrid("""),format.raw/*515.39*/("""{"""),format.raw/*515.40*/("""
                """),format.raw/*516.17*/("""data: mydata,
                datatype: "local",
                height: 450,
                autowidth: true,
                shrinkToFit: true,
                rowNum: 20,
                rowList: [10, 20, 30],
                colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
                colModel:[
                    """),format.raw/*525.21*/("""{"""),format.raw/*525.22*/("""name:'id',index:'id', editable: true, width:60, sorttype:"int",search:true"""),format.raw/*525.96*/("""}"""),format.raw/*525.97*/(""",
                    """),format.raw/*526.21*/("""{"""),format.raw/*526.22*/("""name:'invdate',index:'invdate', editable: true, width:90, sorttype:"date", formatter:"date""""),format.raw/*526.113*/("""}"""),format.raw/*526.114*/(""",
                    """),format.raw/*527.21*/("""{"""),format.raw/*527.22*/("""name:'name',index:'name', editable: true, width:100"""),format.raw/*527.73*/("""}"""),format.raw/*527.74*/(""",
                    """),format.raw/*528.21*/("""{"""),format.raw/*528.22*/("""name:'amount',index:'amount', editable: true, width:80, align:"right",sorttype:"float", formatter:"number""""),format.raw/*528.128*/("""}"""),format.raw/*528.129*/(""",
                    """),format.raw/*529.21*/("""{"""),format.raw/*529.22*/("""name:'tax',index:'tax', editable: true, width:80, align:"right",sorttype:"float""""),format.raw/*529.102*/("""}"""),format.raw/*529.103*/(""",
                    """),format.raw/*530.21*/("""{"""),format.raw/*530.22*/("""name:'total',index:'total', editable: true, width:80,align:"right",sorttype:"float""""),format.raw/*530.105*/("""}"""),format.raw/*530.106*/(""",
                    """),format.raw/*531.21*/("""{"""),format.raw/*531.22*/("""name:'note',index:'note', editable: true, width:100, sortable:false"""),format.raw/*531.89*/("""}"""),format.raw/*531.90*/("""
                """),format.raw/*532.17*/("""],
                pager: "#pager_list_2",
                viewrecords: true,
                caption: "Example jqGrid 2",
                add: true,
                edit: true,
                addtext: 'Add',
                edittext: 'Edit',
                hidegrid: false
            """),format.raw/*541.13*/("""}"""),format.raw/*541.14*/(""");

            // Add selection
            $("#table_list_2").setSelection(4, true);


            // Setup buttons
            $("#table_list_2").jqGrid('navGrid', '#pager_list_2',
                    """),format.raw/*549.21*/("""{"""),format.raw/*549.22*/("""edit: true, add: true, del: true, search: true"""),format.raw/*549.68*/("""}"""),format.raw/*549.69*/(""",
                    """),format.raw/*550.21*/("""{"""),format.raw/*550.22*/("""height: 200, reloadAfterSubmit: true"""),format.raw/*550.58*/("""}"""),format.raw/*550.59*/("""
            """),format.raw/*551.13*/(""");

            // Add responsive to jqGrid
            $(window).bind('resize', function () """),format.raw/*554.50*/("""{"""),format.raw/*554.51*/("""
                """),format.raw/*555.17*/("""var width = $('.jqGrid_wrapper').width();
                $('#table_list_1').setGridWidth(width);
                $('#table_list_2').setGridWidth(width);
            """),format.raw/*558.13*/("""}"""),format.raw/*558.14*/(""");
        """),format.raw/*559.9*/("""}"""),format.raw/*559.10*/(""");

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
object jq_grid extends jq_grid_Scope0.jq_grid
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:20 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/jq_grid.scala.html
                  HASH: 1634dd23047019220498503a4d4f34825671d74f
                  MATRIX: 840->0|1548->680|1577->681|1619->695|1678->727|1707->728|1740->734|25896->24841|25926->24842|25973->24860|26073->24931|26103->24932|26223->25022|26254->25023|26285->25024|26333->25043|26363->25044|26484->25135|26515->25136|26563->25155|26593->25156|26714->25247|26745->25248|26793->25267|26823->25268|26942->25357|26973->25358|27021->25377|27051->25378|27172->25469|27203->25470|27251->25489|27281->25490|27402->25581|27433->25582|27481->25601|27511->25602|27630->25691|27661->25692|27709->25711|27739->25712|27878->25821|27909->25822|27957->25841|27987->25842|28126->25951|28157->25952|28205->25971|28235->25972|28373->26080|28404->26081|28452->26100|28482->26101|28622->26211|28653->26212|28701->26231|28731->26232|28871->26342|28902->26343|28950->26362|28980->26363|29118->26471|29149->26472|29197->26491|29227->26492|29367->26602|29398->26603|29446->26622|29476->26623|29616->26733|29647->26734|29695->26753|29725->26754|29863->26862|29894->26863|29942->26882|29972->26883|30112->26993|30143->26994|30191->27013|30221->27014|30361->27124|30392->27125|30440->27144|30470->27145|30608->27253|30639->27254|30687->27273|30717->27274|30857->27384|30888->27385|30936->27404|30966->27405|31106->27515|31137->27516|31185->27535|31215->27536|31353->27644|31384->27645|31432->27664|31462->27665|31602->27775|31633->27776|31681->27795|31711->27796|31851->27906|31882->27907|31930->27926|31960->27927|32098->28035|32129->28036|32177->28055|32207->28056|32347->28166|32378->28167|32426->28186|32456->28187|32596->28297|32627->28298|32670->28312|32794->28407|32824->28408|32871->28426|33261->28787|33291->28788|33371->28839|33401->28840|33453->28863|33483->28864|33594->28945|33625->28946|33677->28969|33707->28970|33775->29009|33805->29010|33857->29033|33887->29034|34015->29132|34046->29133|34098->29156|34128->29157|34228->29228|34258->29229|34310->29252|34340->29253|34444->29328|34474->29329|34526->29352|34556->29353|34641->29409|34671->29410|34718->29428|34919->29600|34949->29601|35073->29696|35103->29697|35150->29715|35534->30070|35564->30071|35667->30145|35697->30146|35749->30169|35779->30170|35900->30261|35931->30262|35983->30285|36013->30286|36093->30337|36123->30338|36175->30361|36205->30362|36341->30468|36372->30469|36424->30492|36454->30493|36564->30573|36595->30574|36647->30597|36677->30598|36790->30681|36821->30682|36873->30705|36903->30706|36999->30773|37029->30774|37076->30792|37402->31089|37432->31090|37673->31302|37703->31303|37778->31349|37808->31350|37860->31373|37890->31374|37955->31410|37985->31411|38028->31425|38153->31521|38183->31522|38230->31540|38428->31709|38458->31710|38498->31722|38528->31723
                  LINES: 32->1|51->20|51->20|52->21|53->22|53->22|54->23|487->455|487->455|490->458|492->460|492->460|492->460|492->460|492->460|493->461|493->461|493->461|493->461|494->462|494->462|494->462|494->462|495->463|495->463|495->463|495->463|496->464|496->464|496->464|496->464|497->465|497->465|497->465|497->465|498->466|498->466|498->466|498->466|499->467|499->467|499->467|499->467|500->468|500->468|500->468|500->468|501->469|501->469|501->469|501->469|502->470|502->470|502->470|502->470|503->471|503->471|503->471|503->471|504->472|504->472|504->472|504->472|505->473|505->473|505->473|505->473|506->474|506->474|506->474|506->474|507->475|507->475|507->475|507->475|508->476|508->476|508->476|508->476|509->477|509->477|509->477|509->477|510->478|510->478|510->478|510->478|511->479|511->479|511->479|511->479|512->480|512->480|512->480|512->480|513->481|513->481|513->481|513->481|514->482|514->482|514->482|514->482|515->483|515->483|515->483|515->483|516->484|516->484|516->484|516->484|517->485|517->485|517->485|517->485|518->486|518->486|518->486|518->486|519->487|522->490|522->490|523->491|532->500|532->500|532->500|532->500|533->501|533->501|533->501|533->501|534->502|534->502|534->502|534->502|535->503|535->503|535->503|535->503|536->504|536->504|536->504|536->504|537->505|537->505|537->505|537->505|538->506|538->506|538->506|538->506|539->507|544->512|544->512|547->515|547->515|548->516|557->525|557->525|557->525|557->525|558->526|558->526|558->526|558->526|559->527|559->527|559->527|559->527|560->528|560->528|560->528|560->528|561->529|561->529|561->529|561->529|562->530|562->530|562->530|562->530|563->531|563->531|563->531|563->531|564->532|573->541|573->541|581->549|581->549|581->549|581->549|582->550|582->550|582->550|582->550|583->551|586->554|586->554|587->555|590->558|590->558|591->559|591->559
                  -- GENERATED --
              */
          