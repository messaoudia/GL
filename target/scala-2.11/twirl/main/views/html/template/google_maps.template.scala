
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object google_maps_Scope0 {
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

class google_maps extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Google Maps</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
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
                <li class="active">
                    <a href="#"><i class="fa fa-globe"></i> <span class="nav-label">Miscellaneous</span><span class="label label-info pull-right">NEW</span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="toastr_notifications.html">Notification</a></li>
                        <li><a href="nestable_list.html">Nestable list</a></li>
                        <li><a href="agile_board.html">Agile board</a></li>
                        <li><a href="timeline_2.html">Timeline v.2</a></li>
                        <li><a href="diff.html">Diff</a></li>
                        <li><a href="sweetalert.html">Sweet alert</a></li>
                        <li><a href="idle_timer.html">Idle timer</a></li>
                        <li><a href="spinners.html">Spinners</a></li>
                        <li><a href="tinycon.html">Live favicon</a></li>
                        <li class="active"><a href="google_maps.html">Google maps</a></li>
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
                                    <i class="fa fa-upload fa-fw"></i> Server R"""),
format.raw("""ebooted
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
                    <h2>Google Maps</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li>
                            <a>Miscellaneous</a>
                        </li>
                        <li class="active">
                            <strong>Google Maps</strong>
                        </li>
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
        <div class="wrapper wrapper-content  animated fadeInRight">

<!--
 You need to include this script on any page that has a Google Map.
 When using Google Maps on your own site you MUST signup for your own API key at:
 https://developers.google.com/maps/documentation/javascript/tutorial#api_key
 After your sign up replace the key in the URL below..
-->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQTpXj82d8UpCi97wzo_nKXL7nYrd4G70"></script>

            <div class="row">
                <div class="col-md-6">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>Google Maps Basic example</h5>
                        </div>
                        <div class="ibox-content">
                            <p>
                                With google maps <a href="https://developers.google.com/maps/documentation/javascript/reference#MapOptions">API</a> You can easy customize your map.
                            </p>
                            <div class="google-map" id="map1"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>Custom theme 1</h5>
                        </div>
                        <div class="ibox-content">
                            <p>
                                This is a custom theme for Google map.
                            </p>
                            <div class="google-map" id="map2"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>Map Type</h5>
                        </div>
                        <div class="ibox-content">
                            <p>
                                You can also change a map type.
                            </p>
                            <div class="google-map" id="map3"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>Custom theme 2</h5>
                        </div>
                        <div class="ibox-content">
                            <p>
                                This is a custom theme for Google map.
                            </p>
                            <div class="google-map" id="map4"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>Street View</h5>
                        </div>
                        <div class="ibox-content">
                            <p>
                                You can also initial turn on Street View in Google maps.
                            </p>
                            <div class="google-map" id="pano" style="height: 500px"></div>
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

    <script type="text/javascript">
        // When the window has finished loading google map
        google.maps.event.addDomListener(window, 'load', init);

        function init() """),format.raw/*491.25*/("""{"""),format.raw/*491.26*/("""
            """),format.raw/*492.13*/("""// Options for Google map
            // More info see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
            var mapOptions1 = """),format.raw/*494.31*/("""{"""),format.raw/*494.32*/("""
                """),format.raw/*495.17*/("""zoom: 11,
                center: new google.maps.LatLng(40.6700, -73.9400),
                // Style for Google Maps
                styles: ["""),format.raw/*498.26*/("""{"""),format.raw/*498.27*/(""""featureType":"water","stylers":["""),format.raw/*498.60*/("""{"""),format.raw/*498.61*/(""""saturation":43"""),format.raw/*498.76*/("""}"""),format.raw/*498.77*/(""","""),format.raw/*498.78*/("""{"""),format.raw/*498.79*/(""""lightness":-11"""),format.raw/*498.94*/("""}"""),format.raw/*498.95*/(""","""),format.raw/*498.96*/("""{"""),format.raw/*498.97*/(""""hue":"#0088ff""""),format.raw/*498.112*/("""}"""),format.raw/*498.113*/("""]"""),format.raw/*498.114*/("""}"""),format.raw/*498.115*/(""","""),format.raw/*498.116*/("""{"""),format.raw/*498.117*/(""""featureType":"road","elementType":"geometry.fill","stylers":["""),format.raw/*498.179*/("""{"""),format.raw/*498.180*/(""""hue":"#ff0000""""),format.raw/*498.195*/("""}"""),format.raw/*498.196*/(""","""),format.raw/*498.197*/("""{"""),format.raw/*498.198*/(""""saturation":-100"""),format.raw/*498.215*/("""}"""),format.raw/*498.216*/(""","""),format.raw/*498.217*/("""{"""),format.raw/*498.218*/(""""lightness":99"""),format.raw/*498.232*/("""}"""),format.raw/*498.233*/("""]"""),format.raw/*498.234*/("""}"""),format.raw/*498.235*/(""","""),format.raw/*498.236*/("""{"""),format.raw/*498.237*/(""""featureType":"road","elementType":"geometry.stroke","stylers":["""),format.raw/*498.301*/("""{"""),format.raw/*498.302*/(""""color":"#808080""""),format.raw/*498.319*/("""}"""),format.raw/*498.320*/(""","""),format.raw/*498.321*/("""{"""),format.raw/*498.322*/(""""lightness":54"""),format.raw/*498.336*/("""}"""),format.raw/*498.337*/("""]"""),format.raw/*498.338*/("""}"""),format.raw/*498.339*/(""","""),format.raw/*498.340*/("""{"""),format.raw/*498.341*/(""""featureType":"landscape.man_made","elementType":"geometry.fill","stylers":["""),format.raw/*498.417*/("""{"""),format.raw/*498.418*/(""""color":"#ece2d9""""),format.raw/*498.435*/("""}"""),format.raw/*498.436*/("""]"""),format.raw/*498.437*/("""}"""),format.raw/*498.438*/(""","""),format.raw/*498.439*/("""{"""),format.raw/*498.440*/(""""featureType":"poi.park","elementType":"geometry.fill","stylers":["""),format.raw/*498.506*/("""{"""),format.raw/*498.507*/(""""color":"#ccdca1""""),format.raw/*498.524*/("""}"""),format.raw/*498.525*/("""]"""),format.raw/*498.526*/("""}"""),format.raw/*498.527*/(""","""),format.raw/*498.528*/("""{"""),format.raw/*498.529*/(""""featureType":"road","elementType":"labels.text.fill","stylers":["""),format.raw/*498.594*/("""{"""),format.raw/*498.595*/(""""color":"#767676""""),format.raw/*498.612*/("""}"""),format.raw/*498.613*/("""]"""),format.raw/*498.614*/("""}"""),format.raw/*498.615*/(""","""),format.raw/*498.616*/("""{"""),format.raw/*498.617*/(""""featureType":"road","elementType":"labels.text.stroke","stylers":["""),format.raw/*498.684*/("""{"""),format.raw/*498.685*/(""""color":"#ffffff""""),format.raw/*498.702*/("""}"""),format.raw/*498.703*/("""]"""),format.raw/*498.704*/("""}"""),format.raw/*498.705*/(""","""),format.raw/*498.706*/("""{"""),format.raw/*498.707*/(""""featureType":"poi","stylers":["""),format.raw/*498.738*/("""{"""),format.raw/*498.739*/(""""visibility":"off""""),format.raw/*498.757*/("""}"""),format.raw/*498.758*/("""]"""),format.raw/*498.759*/("""}"""),format.raw/*498.760*/(""","""),format.raw/*498.761*/("""{"""),format.raw/*498.762*/(""""featureType":"landscape.natural","elementType":"geometry.fill","stylers":["""),format.raw/*498.837*/("""{"""),format.raw/*498.838*/(""""visibility":"on""""),format.raw/*498.855*/("""}"""),format.raw/*498.856*/(""","""),format.raw/*498.857*/("""{"""),format.raw/*498.858*/(""""color":"#b8cb93""""),format.raw/*498.875*/("""}"""),format.raw/*498.876*/("""]"""),format.raw/*498.877*/("""}"""),format.raw/*498.878*/(""","""),format.raw/*498.879*/("""{"""),format.raw/*498.880*/(""""featureType":"poi.park","stylers":["""),format.raw/*498.916*/("""{"""),format.raw/*498.917*/(""""visibility":"on""""),format.raw/*498.934*/("""}"""),format.raw/*498.935*/("""]"""),format.raw/*498.936*/("""}"""),format.raw/*498.937*/(""","""),format.raw/*498.938*/("""{"""),format.raw/*498.939*/(""""featureType":"poi.sports_complex","stylers":["""),format.raw/*498.985*/("""{"""),format.raw/*498.986*/(""""visibility":"on""""),format.raw/*498.1003*/("""}"""),format.raw/*498.1004*/("""]"""),format.raw/*498.1005*/("""}"""),format.raw/*498.1006*/(""","""),format.raw/*498.1007*/("""{"""),format.raw/*498.1008*/(""""featureType":"poi.medical","stylers":["""),format.raw/*498.1047*/("""{"""),format.raw/*498.1048*/(""""visibility":"on""""),format.raw/*498.1065*/("""}"""),format.raw/*498.1066*/("""]"""),format.raw/*498.1067*/("""}"""),format.raw/*498.1068*/(""","""),format.raw/*498.1069*/("""{"""),format.raw/*498.1070*/(""""featureType":"poi.business","stylers":["""),format.raw/*498.1110*/("""{"""),format.raw/*498.1111*/(""""visibility":"simplified""""),format.raw/*498.1136*/("""}"""),format.raw/*498.1137*/("""]"""),format.raw/*498.1138*/("""}"""),format.raw/*498.1139*/("""]
            """),format.raw/*499.13*/("""}"""),format.raw/*499.14*/(""";

            var mapOptions2 = """),format.raw/*501.31*/("""{"""),format.raw/*501.32*/("""
                """),format.raw/*502.17*/("""zoom: 11,
                center: new google.maps.LatLng(40.6700, -73.9400),
                // Style for Google Maps
                styles: ["""),format.raw/*505.26*/("""{"""),format.raw/*505.27*/(""""featureType":"all","elementType":"all","stylers":["""),format.raw/*505.78*/("""{"""),format.raw/*505.79*/(""""invert_lightness":true"""),format.raw/*505.102*/("""}"""),format.raw/*505.103*/(""","""),format.raw/*505.104*/("""{"""),format.raw/*505.105*/(""""saturation":10"""),format.raw/*505.120*/("""}"""),format.raw/*505.121*/(""","""),format.raw/*505.122*/("""{"""),format.raw/*505.123*/(""""lightness":30"""),format.raw/*505.137*/("""}"""),format.raw/*505.138*/(""","""),format.raw/*505.139*/("""{"""),format.raw/*505.140*/(""""gamma":0.5"""),format.raw/*505.151*/("""}"""),format.raw/*505.152*/(""","""),format.raw/*505.153*/("""{"""),format.raw/*505.154*/(""""hue":"#435158""""),format.raw/*505.169*/("""}"""),format.raw/*505.170*/("""]"""),format.raw/*505.171*/("""}"""),format.raw/*505.172*/("""]
            """),format.raw/*506.13*/("""}"""),format.raw/*506.14*/(""";

            var mapOptions3 = """),format.raw/*508.31*/("""{"""),format.raw/*508.32*/("""
                """),format.raw/*509.17*/("""center: new google.maps.LatLng(36.964645, -122.01523),
                zoom: 18,
                mapTypeId: google.maps.MapTypeId.SATELLITE,
                // Style for Google Maps
                styles: ["""),format.raw/*513.26*/("""{"""),format.raw/*513.27*/(""""featureType":"road","elementType":"geometry","stylers":["""),format.raw/*513.84*/("""{"""),format.raw/*513.85*/(""""visibility":"off""""),format.raw/*513.103*/("""}"""),format.raw/*513.104*/("""]"""),format.raw/*513.105*/("""}"""),format.raw/*513.106*/(""","""),format.raw/*513.107*/("""{"""),format.raw/*513.108*/(""""featureType":"poi","elementType":"geometry","stylers":["""),format.raw/*513.164*/("""{"""),format.raw/*513.165*/(""""visibility":"off""""),format.raw/*513.183*/("""}"""),format.raw/*513.184*/("""]"""),format.raw/*513.185*/("""}"""),format.raw/*513.186*/(""","""),format.raw/*513.187*/("""{"""),format.raw/*513.188*/(""""featureType":"landscape","elementType":"geometry","stylers":["""),format.raw/*513.250*/("""{"""),format.raw/*513.251*/(""""color":"#fffffa""""),format.raw/*513.268*/("""}"""),format.raw/*513.269*/("""]"""),format.raw/*513.270*/("""}"""),format.raw/*513.271*/(""","""),format.raw/*513.272*/("""{"""),format.raw/*513.273*/(""""featureType":"water","stylers":["""),format.raw/*513.306*/("""{"""),format.raw/*513.307*/(""""lightness":50"""),format.raw/*513.321*/("""}"""),format.raw/*513.322*/("""]"""),format.raw/*513.323*/("""}"""),format.raw/*513.324*/(""","""),format.raw/*513.325*/("""{"""),format.raw/*513.326*/(""""featureType":"road","elementType":"labels","stylers":["""),format.raw/*513.381*/("""{"""),format.raw/*513.382*/(""""visibility":"off""""),format.raw/*513.400*/("""}"""),format.raw/*513.401*/("""]"""),format.raw/*513.402*/("""}"""),format.raw/*513.403*/(""","""),format.raw/*513.404*/("""{"""),format.raw/*513.405*/(""""featureType":"transit","stylers":["""),format.raw/*513.440*/("""{"""),format.raw/*513.441*/(""""visibility":"off""""),format.raw/*513.459*/("""}"""),format.raw/*513.460*/("""]"""),format.raw/*513.461*/("""}"""),format.raw/*513.462*/(""","""),format.raw/*513.463*/("""{"""),format.raw/*513.464*/(""""featureType":"administrative","elementType":"geometry","stylers":["""),format.raw/*513.531*/("""{"""),format.raw/*513.532*/(""""lightness":40"""),format.raw/*513.546*/("""}"""),format.raw/*513.547*/("""]"""),format.raw/*513.548*/("""}"""),format.raw/*513.549*/("""]
            """),format.raw/*514.13*/("""}"""),format.raw/*514.14*/(""";

            var mapOptions4 = """),format.raw/*516.31*/("""{"""),format.raw/*516.32*/("""
                """),format.raw/*517.17*/("""zoom: 11,
                center: new google.maps.LatLng(40.6700, -73.9400),
                // Style for Google Maps
                styles: ["""),format.raw/*520.26*/("""{"""),format.raw/*520.27*/(""""stylers":["""),format.raw/*520.38*/("""{"""),format.raw/*520.39*/(""""hue":"#18a689""""),format.raw/*520.54*/("""}"""),format.raw/*520.55*/(""","""),format.raw/*520.56*/("""{"""),format.raw/*520.57*/(""""visibility":"on""""),format.raw/*520.74*/("""}"""),format.raw/*520.75*/(""","""),format.raw/*520.76*/("""{"""),format.raw/*520.77*/(""""invert_lightness":true"""),format.raw/*520.100*/("""}"""),format.raw/*520.101*/(""","""),format.raw/*520.102*/("""{"""),format.raw/*520.103*/(""""saturation":40"""),format.raw/*520.118*/("""}"""),format.raw/*520.119*/(""","""),format.raw/*520.120*/("""{"""),format.raw/*520.121*/(""""lightness":10"""),format.raw/*520.135*/("""}"""),format.raw/*520.136*/("""]"""),format.raw/*520.137*/("""}"""),format.raw/*520.138*/("""]
            """),format.raw/*521.13*/("""}"""),format.raw/*521.14*/(""";

            var fenway = new google.maps.LatLng(42.345573, -71.098326);
            var mapOptions5 = """),format.raw/*524.31*/("""{"""),format.raw/*524.32*/("""
                """),format.raw/*525.17*/("""zoom: 14,
                center: fenway,
                // Style for Google Maps
                styles: ["""),format.raw/*528.26*/("""{"""),format.raw/*528.27*/("""featureType:"landscape",stylers:["""),format.raw/*528.60*/("""{"""),format.raw/*528.61*/("""saturation:-100"""),format.raw/*528.76*/("""}"""),format.raw/*528.77*/(""","""),format.raw/*528.78*/("""{"""),format.raw/*528.79*/("""lightness:65"""),format.raw/*528.91*/("""}"""),format.raw/*528.92*/(""","""),format.raw/*528.93*/("""{"""),format.raw/*528.94*/("""visibility:"on""""),format.raw/*528.109*/("""}"""),format.raw/*528.110*/("""]"""),format.raw/*528.111*/("""}"""),format.raw/*528.112*/(""","""),format.raw/*528.113*/("""{"""),format.raw/*528.114*/("""featureType:"poi",stylers:["""),format.raw/*528.141*/("""{"""),format.raw/*528.142*/("""saturation:-100"""),format.raw/*528.157*/("""}"""),format.raw/*528.158*/(""","""),format.raw/*528.159*/("""{"""),format.raw/*528.160*/("""lightness:51"""),format.raw/*528.172*/("""}"""),format.raw/*528.173*/(""","""),format.raw/*528.174*/("""{"""),format.raw/*528.175*/("""visibility:"simplified""""),format.raw/*528.198*/("""}"""),format.raw/*528.199*/("""]"""),format.raw/*528.200*/("""}"""),format.raw/*528.201*/(""","""),format.raw/*528.202*/("""{"""),format.raw/*528.203*/("""featureType:"road.highway",stylers:["""),format.raw/*528.239*/("""{"""),format.raw/*528.240*/("""saturation:-100"""),format.raw/*528.255*/("""}"""),format.raw/*528.256*/(""","""),format.raw/*528.257*/("""{"""),format.raw/*528.258*/("""visibility:"simplified""""),format.raw/*528.281*/("""}"""),format.raw/*528.282*/("""]"""),format.raw/*528.283*/("""}"""),format.raw/*528.284*/(""","""),format.raw/*528.285*/("""{"""),format.raw/*528.286*/("""featureType:"road.arterial",stylers:["""),format.raw/*528.323*/("""{"""),format.raw/*528.324*/("""saturation:-100"""),format.raw/*528.339*/("""}"""),format.raw/*528.340*/(""","""),format.raw/*528.341*/("""{"""),format.raw/*528.342*/("""lightness:30"""),format.raw/*528.354*/("""}"""),format.raw/*528.355*/(""","""),format.raw/*528.356*/("""{"""),format.raw/*528.357*/("""visibility:"on""""),format.raw/*528.372*/("""}"""),format.raw/*528.373*/("""]"""),format.raw/*528.374*/("""}"""),format.raw/*528.375*/(""","""),format.raw/*528.376*/("""{"""),format.raw/*528.377*/("""featureType:"road.local",stylers:["""),format.raw/*528.411*/("""{"""),format.raw/*528.412*/("""saturation:-100"""),format.raw/*528.427*/("""}"""),format.raw/*528.428*/(""","""),format.raw/*528.429*/("""{"""),format.raw/*528.430*/("""lightness:40"""),format.raw/*528.442*/("""}"""),format.raw/*528.443*/(""","""),format.raw/*528.444*/("""{"""),format.raw/*528.445*/("""visibility:"on""""),format.raw/*528.460*/("""}"""),format.raw/*528.461*/("""]"""),format.raw/*528.462*/("""}"""),format.raw/*528.463*/(""","""),format.raw/*528.464*/("""{"""),format.raw/*528.465*/("""featureType:"transit",stylers:["""),format.raw/*528.496*/("""{"""),format.raw/*528.497*/("""saturation:-100"""),format.raw/*528.512*/("""}"""),format.raw/*528.513*/(""","""),format.raw/*528.514*/("""{"""),format.raw/*528.515*/("""visibility:"simplified""""),format.raw/*528.538*/("""}"""),format.raw/*528.539*/("""]"""),format.raw/*528.540*/("""}"""),format.raw/*528.541*/(""","""),format.raw/*528.542*/("""{"""),format.raw/*528.543*/("""featureType:"administrative.province",stylers:["""),format.raw/*528.590*/("""{"""),format.raw/*528.591*/("""visibility:"off""""),format.raw/*528.607*/("""}"""),format.raw/*528.608*/("""]/**/"""),format.raw/*528.613*/("""}"""),format.raw/*528.614*/(""","""),format.raw/*528.615*/("""{"""),format.raw/*528.616*/("""featureType:"administrative.locality",stylers:["""),format.raw/*528.663*/("""{"""),format.raw/*528.664*/("""visibility:"off""""),format.raw/*528.680*/("""}"""),format.raw/*528.681*/("""]"""),format.raw/*528.682*/("""}"""),format.raw/*528.683*/(""","""),format.raw/*528.684*/("""{"""),format.raw/*528.685*/("""featureType:"administrative.neighborhood",stylers:["""),format.raw/*528.736*/("""{"""),format.raw/*528.737*/("""visibility:"on""""),format.raw/*528.752*/("""}"""),format.raw/*528.753*/("""]/**/"""),format.raw/*528.758*/("""}"""),format.raw/*528.759*/(""","""),format.raw/*528.760*/("""{"""),format.raw/*528.761*/("""featureType:"water",elementType:"labels",stylers:["""),format.raw/*528.811*/("""{"""),format.raw/*528.812*/("""visibility:"on""""),format.raw/*528.827*/("""}"""),format.raw/*528.828*/(""","""),format.raw/*528.829*/("""{"""),format.raw/*528.830*/("""lightness:-25"""),format.raw/*528.843*/("""}"""),format.raw/*528.844*/(""","""),format.raw/*528.845*/("""{"""),format.raw/*528.846*/("""saturation:-100"""),format.raw/*528.861*/("""}"""),format.raw/*528.862*/("""]"""),format.raw/*528.863*/("""}"""),format.raw/*528.864*/(""","""),format.raw/*528.865*/("""{"""),format.raw/*528.866*/("""featureType:"water",elementType:"geometry",stylers:["""),format.raw/*528.918*/("""{"""),format.raw/*528.919*/("""hue:"#ffff00""""),format.raw/*528.932*/("""}"""),format.raw/*528.933*/(""","""),format.raw/*528.934*/("""{"""),format.raw/*528.935*/("""lightness:-25"""),format.raw/*528.948*/("""}"""),format.raw/*528.949*/(""","""),format.raw/*528.950*/("""{"""),format.raw/*528.951*/("""saturation:-97"""),format.raw/*528.965*/("""}"""),format.raw/*528.966*/("""]"""),format.raw/*528.967*/("""}"""),format.raw/*528.968*/("""]
            """),format.raw/*529.13*/("""}"""),format.raw/*529.14*/(""";

            var panoramaOptions = """),format.raw/*531.35*/("""{"""),format.raw/*531.36*/("""
                """),format.raw/*532.17*/("""position: fenway,
                pov: """),format.raw/*533.22*/("""{"""),format.raw/*533.23*/("""
                    """),format.raw/*534.21*/("""heading: 10,
                    pitch: 10
                """),format.raw/*536.17*/("""}"""),format.raw/*536.18*/("""
            """),format.raw/*537.13*/("""}"""),format.raw/*537.14*/(""";
            var panorama = new google.maps.StreetViewPanorama(document.getElementById('pano'), panoramaOptions);

            // Get all html elements for map
            var mapElement1 = document.getElementById('map1');
            var mapElement2 = document.getElementById('map2');
            var mapElement3 = document.getElementById('map3');
            var mapElement4 = document.getElementById('map4');

            // Create the Google Map using elements
            var map1 = new google.maps.Map(mapElement1, mapOptions1);
            var map2 = new google.maps.Map(mapElement2, mapOptions2);
            var map3 = new google.maps.Map(mapElement3, mapOptions3);
            var map4 = new google.maps.Map(mapElement4, mapOptions4);
        """),format.raw/*551.9*/("""}"""),format.raw/*551.10*/("""
    """),format.raw/*552.5*/("""</script>

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
object google_maps extends google_maps_Scope0.google_maps
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:19 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/google_maps.scala.html
                  HASH: 1bd2d2d3cef1eb35e48f68a1da48d017583acb43
                  MATRIX: 848->0|27101->26204|27131->26205|27174->26219|27372->26388|27402->26389|27449->26407|27624->26553|27654->26554|27716->26587|27746->26588|27790->26603|27820->26604|27850->26605|27880->26606|27924->26621|27954->26622|27984->26623|28014->26624|28059->26639|28090->26640|28121->26641|28152->26642|28183->26643|28214->26644|28306->26706|28337->26707|28382->26722|28413->26723|28444->26724|28475->26725|28522->26742|28553->26743|28584->26744|28615->26745|28659->26759|28690->26760|28721->26761|28752->26762|28783->26763|28814->26764|28908->26828|28939->26829|28986->26846|29017->26847|29048->26848|29079->26849|29123->26863|29154->26864|29185->26865|29216->26866|29247->26867|29278->26868|29384->26944|29415->26945|29462->26962|29493->26963|29524->26964|29555->26965|29586->26966|29617->26967|29713->27033|29744->27034|29791->27051|29822->27052|29853->27053|29884->27054|29915->27055|29946->27056|30041->27121|30072->27122|30119->27139|30150->27140|30181->27141|30212->27142|30243->27143|30274->27144|30371->27211|30402->27212|30449->27229|30480->27230|30511->27231|30542->27232|30573->27233|30604->27234|30665->27265|30696->27266|30744->27284|30775->27285|30806->27286|30837->27287|30868->27288|30899->27289|31004->27364|31035->27365|31082->27382|31113->27383|31144->27384|31175->27385|31222->27402|31253->27403|31284->27404|31315->27405|31346->27406|31377->27407|31443->27443|31474->27444|31521->27461|31552->27462|31583->27463|31614->27464|31645->27465|31676->27466|31752->27512|31783->27513|31831->27530|31863->27531|31895->27532|31927->27533|31959->27534|31991->27535|32061->27574|32093->27575|32141->27592|32173->27593|32205->27594|32237->27595|32269->27596|32301->27597|32372->27637|32404->27638|32460->27663|32492->27664|32524->27665|32556->27666|32600->27681|32630->27682|32694->27717|32724->27718|32771->27736|32946->27882|32976->27883|33056->27934|33086->27935|33139->27958|33170->27959|33201->27960|33232->27961|33277->27976|33308->27977|33339->27978|33370->27979|33414->27993|33445->27994|33476->27995|33507->27996|33548->28007|33579->28008|33610->28009|33641->28010|33686->28025|33717->28026|33748->28027|33779->28028|33823->28043|33853->28044|33917->28079|33947->28080|33994->28098|34234->28309|34264->28310|34350->28367|34380->28368|34428->28386|34459->28387|34490->28388|34521->28389|34552->28390|34583->28391|34669->28447|34700->28448|34748->28466|34779->28467|34810->28468|34841->28469|34872->28470|34903->28471|34995->28533|35026->28534|35073->28551|35104->28552|35135->28553|35166->28554|35197->28555|35228->28556|35291->28589|35322->28590|35366->28604|35397->28605|35428->28606|35459->28607|35490->28608|35521->28609|35606->28664|35637->28665|35685->28683|35716->28684|35747->28685|35778->28686|35809->28687|35840->28688|35905->28723|35936->28724|35984->28742|36015->28743|36046->28744|36077->28745|36108->28746|36139->28747|36236->28814|36267->28815|36311->28829|36342->28830|36373->28831|36404->28832|36448->28847|36478->28848|36542->28883|36572->28884|36619->28902|36794->29048|36824->29049|36864->29060|36894->29061|36938->29076|36968->29077|36998->29078|37028->29079|37074->29096|37104->29097|37134->29098|37164->29099|37217->29122|37248->29123|37279->29124|37310->29125|37355->29140|37386->29141|37417->29142|37448->29143|37492->29157|37523->29158|37554->29159|37585->29160|37629->29175|37659->29176|37796->29284|37826->29285|37873->29303|38013->29414|38043->29415|38105->29448|38135->29449|38179->29464|38209->29465|38239->29466|38269->29467|38310->29479|38340->29480|38370->29481|38400->29482|38445->29497|38476->29498|38507->29499|38538->29500|38569->29501|38600->29502|38657->29529|38688->29530|38733->29545|38764->29546|38795->29547|38826->29548|38868->29560|38899->29561|38930->29562|38961->29563|39014->29586|39045->29587|39076->29588|39107->29589|39138->29590|39169->29591|39235->29627|39266->29628|39311->29643|39342->29644|39373->29645|39404->29646|39457->29669|39488->29670|39519->29671|39550->29672|39581->29673|39612->29674|39679->29711|39710->29712|39755->29727|39786->29728|39817->29729|39848->29730|39890->29742|39921->29743|39952->29744|39983->29745|40028->29760|40059->29761|40090->29762|40121->29763|40152->29764|40183->29765|40247->29799|40278->29800|40323->29815|40354->29816|40385->29817|40416->29818|40458->29830|40489->29831|40520->29832|40551->29833|40596->29848|40627->29849|40658->29850|40689->29851|40720->29852|40751->29853|40812->29884|40843->29885|40888->29900|40919->29901|40950->29902|40981->29903|41034->29926|41065->29927|41096->29928|41127->29929|41158->29930|41189->29931|41266->29978|41297->29979|41343->29995|41374->29996|41409->30001|41440->30002|41471->30003|41502->30004|41579->30051|41610->30052|41656->30068|41687->30069|41718->30070|41749->30071|41780->30072|41811->30073|41892->30124|41923->30125|41968->30140|41999->30141|42034->30146|42065->30147|42096->30148|42127->30149|42207->30199|42238->30200|42283->30215|42314->30216|42345->30217|42376->30218|42419->30231|42450->30232|42481->30233|42512->30234|42557->30249|42588->30250|42619->30251|42650->30252|42681->30253|42712->30254|42794->30306|42825->30307|42868->30320|42899->30321|42930->30322|42961->30323|43004->30336|43035->30337|43066->30338|43097->30339|43141->30353|43172->30354|43203->30355|43234->30356|43278->30371|43308->30372|43376->30411|43406->30412|43453->30430|43522->30470|43552->30471|43603->30493|43693->30554|43723->30555|43766->30569|43796->30570|44592->31338|44622->31339|44656->31345
                  LINES: 32->1|523->491|523->491|524->492|526->494|526->494|527->495|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|530->498|531->499|531->499|533->501|533->501|534->502|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|537->505|538->506|538->506|540->508|540->508|541->509|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|545->513|546->514|546->514|548->516|548->516|549->517|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|552->520|553->521|553->521|556->524|556->524|557->525|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|560->528|561->529|561->529|563->531|563->531|564->532|565->533|565->533|566->534|568->536|568->536|569->537|569->537|583->551|583->551|584->552
                  -- GENERATED --
              */
          