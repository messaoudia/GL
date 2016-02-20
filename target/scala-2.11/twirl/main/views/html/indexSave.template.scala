
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object indexSave_Scope0 {
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

class indexSave extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(pageTitle: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/scripts/*3.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.13*/("""
    """),format.raw/*4.5*/("""<script>
            $(document).ready(function() """),format.raw/*5.42*/("""{"""),format.raw/*5.43*/("""
                """),format.raw/*6.17*/("""setTimeout(function() """),format.raw/*6.39*/("""{"""),format.raw/*6.40*/("""
                    """),format.raw/*7.21*/("""toastr.options = """),format.raw/*7.38*/("""{"""),format.raw/*7.39*/("""
                        """),format.raw/*8.25*/("""closeButton: true,
                        progressBar: true,
                        showMethod: 'slideDown',
                        timeOut: 4000
                    """),format.raw/*12.21*/("""}"""),format.raw/*12.22*/(""";
                    toastr.success('Responsive Admin Theme', 'Welcome to INSPINIA');

                """),format.raw/*15.17*/("""}"""),format.raw/*15.18*/(""", 1300);


                var data1 = [
                    [0,4],[1,8],[2,5],[3,10],[4,4],[5,16],[6,5],[7,11],[8,6],[9,11],[10,30],[11,10],[12,13],[13,4],[14,3],[15,3],[16,6]
                ];
                var data2 = [
                    [0,1],[1,0],[2,2],[3,0],[4,1],[5,3],[6,1],[7,5],[8,2],[9,3],[10,2],[11,1],[12,0],[13,2],[14,8],[15,0],[16,0]
                ];
                $("#flot-dashboard-chart").length && $.plot($("#flot-dashboard-chart"), [
                            data1, data2
                        ],
                        """),format.raw/*27.25*/("""{"""),format.raw/*27.26*/("""
                            """),format.raw/*28.29*/("""series: """),format.raw/*28.37*/("""{"""),format.raw/*28.38*/("""
                                """),format.raw/*29.33*/("""lines: """),format.raw/*29.40*/("""{"""),format.raw/*29.41*/("""
                                    """),format.raw/*30.37*/("""show: false,
                                    fill: true
                                """),format.raw/*32.33*/("""}"""),format.raw/*32.34*/(""",
                                splines: """),format.raw/*33.42*/("""{"""),format.raw/*33.43*/("""
                                    """),format.raw/*34.37*/("""show: true,
                                    tension: 0.4,
                                    lineWidth: 1,
                                    fill: 0.4
                                """),format.raw/*38.33*/("""}"""),format.raw/*38.34*/(""",
                                points: """),format.raw/*39.41*/("""{"""),format.raw/*39.42*/("""
                                    """),format.raw/*40.37*/("""radius: 0,
                                    show: true
                                """),format.raw/*42.33*/("""}"""),format.raw/*42.34*/(""",
                                shadowSize: 2
                            """),format.raw/*44.29*/("""}"""),format.raw/*44.30*/(""",
                            grid: """),format.raw/*45.35*/("""{"""),format.raw/*45.36*/("""
                                """),format.raw/*46.33*/("""hoverable: true,
                                clickable: true,
                                tickColor: "#d5d5d5",
                                borderWidth: 1,
                                color: '#d5d5d5'
                            """),format.raw/*51.29*/("""}"""),format.raw/*51.30*/(""",
                            colors: ["#1ab394", "#1C84C6"],
                            xaxis:"""),format.raw/*53.35*/("""{"""),format.raw/*53.36*/("""
                            """),format.raw/*54.29*/("""}"""),format.raw/*54.30*/(""",
                            yaxis: """),format.raw/*55.36*/("""{"""),format.raw/*55.37*/("""
                                """),format.raw/*56.33*/("""ticks: 4
                            """),format.raw/*57.29*/("""}"""),format.raw/*57.30*/(""",
                            tooltip: false
                        """),format.raw/*59.25*/("""}"""),format.raw/*59.26*/("""
                """),format.raw/*60.17*/(""");

                var doughnutData = [
                    """),format.raw/*63.21*/("""{"""),format.raw/*63.22*/("""
                        """),format.raw/*64.25*/("""value: 300,
                        color: "#a3e1d4",
                        highlight: "#1ab394",
                        label: "App"
                    """),format.raw/*68.21*/("""}"""),format.raw/*68.22*/(""",
                    """),format.raw/*69.21*/("""{"""),format.raw/*69.22*/("""
                        """),format.raw/*70.25*/("""value: 50,
                        color: "#dedede",
                        highlight: "#1ab394",
                        label: "Software"
                    """),format.raw/*74.21*/("""}"""),format.raw/*74.22*/(""",
                    """),format.raw/*75.21*/("""{"""),format.raw/*75.22*/("""
                        """),format.raw/*76.25*/("""value: 100,
                        color: "#A4CEE8",
                        highlight: "#1ab394",
                        label: "Laptop"
                    """),format.raw/*80.21*/("""}"""),format.raw/*80.22*/("""
                """),format.raw/*81.17*/("""];

                var doughnutOptions = """),format.raw/*83.39*/("""{"""),format.raw/*83.40*/("""
                    """),format.raw/*84.21*/("""segmentShowStroke: true,
                    segmentStrokeColor: "#fff",
                    segmentStrokeWidth: 2,
                    percentageInnerCutout: 45, // This is 0 for Pie charts
                    animationSteps: 100,
                    animationEasing: "easeOutBounce",
                    animateRotate: true,
                    animateScale: false
                """),format.raw/*92.17*/("""}"""),format.raw/*92.18*/(""";

                var ctx = document.getElementById("doughnutChart").getContext("2d");
                var DoughnutChart = new Chart(ctx).Doughnut(doughnutData, doughnutOptions);

                var polarData = [
                    """),format.raw/*98.21*/("""{"""),format.raw/*98.22*/("""
                        """),format.raw/*99.25*/("""value: 300,
                        color: "#a3e1d4",
                        highlight: "#1ab394",
                        label: "App"
                    """),format.raw/*103.21*/("""}"""),format.raw/*103.22*/(""",
                    """),format.raw/*104.21*/("""{"""),format.raw/*104.22*/("""
                        """),format.raw/*105.25*/("""value: 140,
                        color: "#dedede",
                        highlight: "#1ab394",
                        label: "Software"
                    """),format.raw/*109.21*/("""}"""),format.raw/*109.22*/(""",
                    """),format.raw/*110.21*/("""{"""),format.raw/*110.22*/("""
                        """),format.raw/*111.25*/("""value: 200,
                        color: "#A4CEE8",
                        highlight: "#1ab394",
                        label: "Laptop"
                    """),format.raw/*115.21*/("""}"""),format.raw/*115.22*/("""
                """),format.raw/*116.17*/("""];

                var polarOptions = """),format.raw/*118.36*/("""{"""),format.raw/*118.37*/("""
                    """),format.raw/*119.21*/("""scaleShowLabelBackdrop: true,
                    scaleBackdropColor: "rgba(255,255,255,0.75)",
                    scaleBeginAtZero: true,
                    scaleBackdropPaddingY: 1,
                    scaleBackdropPaddingX: 1,
                    scaleShowLine: true,
                    segmentShowStroke: true,
                    segmentStrokeColor: "#fff",
                    segmentStrokeWidth: 2,
                    animationSteps: 100,
                    animationEasing: "easeOutBounce",
                    animateRotate: true,
                    animateScale: false
                """),format.raw/*132.17*/("""}"""),format.raw/*132.18*/(""";
                var ctx = document.getElementById("polarChart").getContext("2d");
                var Polarchart = new Chart(ctx).PolarArea(polarData, polarOptions);

            """),format.raw/*136.13*/("""}"""),format.raw/*136.14*/(""");
    </script>
""")))};def /*140.2*/content/*140.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*140.13*/("""
    """),format.raw/*141.5*/("""<div id="wrapper">
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
                    <li class="active">
                        <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span> <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li class="active"><a href="index.html">Dashboard v.1</a></li>
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

        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" action="search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="Search for something..." class="form-control" nom="top-search" id="top-search">
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
                                            <img alt="image" class="img-circle" 1>
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
           """),
format.raw("""                     </li>
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
                        <li>
                            <a class="right-sidebar-toggle">
                                <i class="fa fa-tasks"></i>
                            </a>
                        </li>
                    </ul>

                </nav>
            </div>
            <div class="row  border-bottom white-bg dashboard-header">

                <div class="col-sm-3">
                    <h2>Welcome Amelia</h2>
                    <small>You have 42 messages and 6 notifications.</small>
                    <ul class="list-group clear-list m-t">
                        <li class="list-group-item fist-item">
                            <span class="pull-right">
                                09:00 pm
                            </span>
                            <span class="label label-success">1</span> Please contact me
                        </li>
                        <li class="list-group-item">
                            <span class="pull-right">
                                10:16 am
                            </span>
                            <span class="label label-info">2</span> Sign a contract
                        </li>
                        <li class="list-group-item">
                            <span class="pull-right">
                                08:22 pm
                            </span>
                            <span class="label label-primary">3</span> Open new shop
                        </li>
                        <li class="list-group-item">
                            <span class="pull-right">
                                11:06 pm
                            </span>
                            <span class="label label-default">4</span> Call back to Sylvia
                        </li>
                        <li class="list-group-item">
                            <span class="pull-right">
                                12:00 am
                            </span>
                            <span class="label label-primary">5</span> Write a letter to Sandra
                        </li>
                    </ul>
                </div>
                <div class="col-sm-6">
                    <div class="flot-chart dashboard-chart">
                        <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                    </div>
                    <div class="row text-left">
                        <div class="col-xs-4">
                            <div class=" m-l-md">
                                <span class="h4 font-bold m-t block">$ 406,100</span>
                                <small class="text-muted m-b block">Sales marketing report</small>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <span class="h4 font-bold m-t block">$ 150,401</span>
                            <small class="text-muted m-b block">Annual sales revenue</small>
                        </div>
                        <div class="col-xs-4">
                            <span class="h4 font-bold m-t block">$ 16,822</span>
                            <small class="text-muted m-b block">Half-year revenue margin</small>
                        </div>

                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="statistic-box">
                        <h4>
                            Project Beta progress
                        </h4>
                        <p>
                            You have two project with not compleated task.
                        </p>
                        <div class="row text-center">
                            <div class="col-lg-6">
                                <canvas id="polarChart" width="80" height="80"></canvas>
                                <h5 >Kolter</h5>
                            </div>
                            <div class="col-lg-6">
                                <canvas id="doughnutChart" width="78" height="78"></canvas>
                                <h5 >Maxtor</h5>
                            </div>
                        </div>
                        <div class="m-t">
                            <small>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</small>
                        </div>

                    </div>
                </div>

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="wrapper wrapper-content">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>New data for the report</h5> <span class="label label-primary">IN+</span>
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
                                        <div>

                                            <div class="pull-right text-right">

                                                <span class="bar_dashboard">5,3,9,6,5,9,7,3,5,2,4,7,3,2,7,9,6,4,5,7,3,2,1,0,9,5,6,8,3,2,1</span>
                                                <br/>
                                                <small class="font-bold">$ 20 054.43</small>
                                            </div>
                                            <h4>NYS report new data!
                                                <br/>
                                                <small class="m-r"><a href="graph_flot.html"> Check the stock price! </a> </small>
                                            </h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Read below comments</h5>
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
                                    <div class="ibox-content no-padding">
                                        <ul class="list-group">
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Alan Marry</a> I belive that. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 minuts ago</small>
                                            </li>
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Stock Man</a> Check this stock chart. This price is crazy! </p>
                                                <div class="text-center m">
                                                    <span id="sparkline8"></span>
                                                </div>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 hours ago</small>
                                            </li>
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Kevin Smith</a> Lorem ipsum unknown printer took a galley </p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 minuts ago</small>
                                            </li>
                                            <li class="list-group-item ">
                                                <p><a class="text-info" href="#">@Jonathan Febrick</a> The standard chunk of Lorem Ipsum</p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 hour ago</small>
                                            </li>
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Alan Marry</a> I belive that. Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 1 minuts ago</small>
                                            </li>
                                            <li class="list-group-item">
                                                <p><a class="text-info" href="#">@Kevin Smith</a> Lorem ipsum unknown printer took a galley </p>
                                                <small class="block text-muted"><i class="fa fa-clock-o"></i> 2 minuts ago</small>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Your daily feed</h5>
                                        <div class="ibox-tools">
                                            <span class="label label-warning-light pull-right">10 Messages</span>
                                        </div>
                                    </div>
                                    <div class="ibox-content">

                                        <div>
                                            <div class="feed-activity-list">

                                                <div class="feed-element">
                                                    <a href="profile.html" class="pull-left">
                                                        <img alt="image" class="img-circle" src="img/profile.jpg">
                                                    </a>
                                                    <div class="media-body ">
                                                        <small class="pull-right">5m ago</small>
                                                        <strong>Monica Smith</strong> posted a new blog. <br>
                                                        <small class="text-muted">Today 5:60 pm - 12.06.2014</small>

                                                    </div>
                                                </div>

                                                <div class="feed-element">
                                                    <a href="profile.html" class="pull-left">
                                                        <img alt="image" class="img-circle" src="img/a2.jpg">
                                                    </a>
                                                    <div class="media-body ">
                                                        <small class="pull-right">2h ago</small>
                                                        <strong>Mark Johnson</strong> posted message on <strong>Monica Smith</strong> site. <br>
                                                        <small class="text-muted">Today 2:10 pm - 12.06.2014</small>
                                                    </div>
                                                </div>
                                                <div class="feed-element">
                                                    <a href="profile.html" class="pull-left">
                                                        <img alt="image" class="img-circle" src="img/a3.jpg">
                                                    </a>
                                                    <div class="media-body ">
                                                        <small class="pull-right">2h ago</small>
                                                        <strong>Janet Rosowski</strong> add 1 photo on <strong>Monica Smith</strong>. <br>
                                                        <small class="text-muted">2 days ago at 8:30am</small>
                                                    </div>
                                                </div>
                                                <div class="feed-element">
                                                    <a href="profile.html" class="pull-left">
                                                        <img alt="image" class="img-circle" src="img/a4.jpg">
                                                    </a>
                                                    <div class="media-body ">
                                                        <small class="pull-right text-navy">5h ago</small>
                                                        <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                                        <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                                        <div class="actions">
                                                            <a class="btn btn-xs btn-white"><i class="fa fa-thumbs-up"></i> Like </a>
                                                            <a class="btn btn-xs btn-white"><i class="fa fa-heart"></i> Love</a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="feed-element">
                                                    <a href="profile.html" class="pull-left">
                                                        <img alt="image" class="img-circle" src="img/a5.jpg">
                                                    </a>
                                                    <div class="media-body ">
                                                        <small class="pull-right">2h ago</small>
                                                        <strong>Kim Smith</strong> posted message on <strong>Monica Smith</strong> site. <br>
                                                        <small class="text-muted">Yesterday 5:20 pm - 12.06.2014</small>
                                                        <div class="well">
                                                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
                                                            Over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                                                        </div>
                                                        <div class="pull-right">
                                                            <a class="btn btn-xs btn-white"><i class="fa fa-thumbs-up"></i> Like </a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="feed-element">
                                                    <a href="profile.html" class="pull-left">
                                                        <img alt="image" class="img-circle" src="img/profile.jpg">
                                                    </a>
                     """),
format.raw("""                               <div class="media-body ">
                                                        <small class="pull-right">23h ago</small>
                                                        <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                                        <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                                    </div>
                                                </div>
                                                <div class="feed-element">
                                                    <a href="profile.html" class="pull-left">
                                                        <img alt="image" class="img-circle" src="img/a7.jpg">
                                                    </a>
                                                    <div class="media-body ">
                                                        <small class="pull-right">46h ago</small>
                                                        <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                                        <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                                    </div>
                                                </div>
                                            </div>

                                            <button class="btn btn-primary btn-block m-t"><i class="fa fa-arrow-down"></i> Show More</button>

                                        </div>

                                    </div>
                                </div>

                            </div>
                            <div class="col-lg-4">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Alpha project</h5>
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
                                    <div class="ibox-content ibox-heading">
                                        <h3>You have meeting today!</h3>
                                        <small><i class="fa fa-map-marker"></i> Meeting is on 6:00am. Check your schedule to see detail.</small>
                                    </div>
                                    <div class="ibox-content inspinia-timeline">

                                        <div class="timeline-item">
                                            <div class="row">
                                                <div class="col-xs-3 dateDebut">
                                                    <i class="fa fa-briefcase"></i>
                                                    6:00 am
                                                    <br/>
                                                    <small class="text-navy">2 hour ago</small>
                                                </div>
                                                <div class="col-xs-7 content no-top-border">
                                                    <p class="m-b-xs"><strong>Meeting</strong></p>

                                                    <p>Conference on the sales results for the previous year. Monica please examine sales trends in marketing and products. Below please find the current status of the
                                                        sale.</p>

                                                    <p><span data-diameter="40" class="updating-chart">5,3,9,6,5,9,7,3,5,2,5,3,9,6,5,9,4,7,3,2,9,8,7,4,5,1,2,9,5,4,7,2,7,7,3,5,2</span></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="timeline-item">
                                            <div class="row">
                                                <div class="col-xs-3 dateDebut">
                                                    <i class="fa fa-file-text"></i>
                                                    7:00 am
                                                    <br/>
                                                    <small class="text-navy">3 hour ago</small>
                                                </div>
                                                <div class="col-xs-7 content">
                                                    <p class="m-b-xs"><strong>Send documents to Mike</strong></p>
                                                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since.</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="timeline-item">
                                            <div class="row">
                                                <div class="col-xs-3 dateDebut">
                                                    <i class="fa fa-coffee"></i>
                                                    8:00 am
                                                    <br/>
                                                </div>
                                                <div class="col-xs-7 content">
                                                    <p class="m-b-xs"><strong>Coffee Break</strong></p>
                                                    <p>
                                                        Go to shop and find some products.
                                                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's.
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="timeline-item">
                                            <div class="row">
                                                <div class="col-xs-3 dateDebut">
                                                    <i class="fa fa-phone"></i>
                                                    11:00 am
                                                    <br/>
                                                    <small class="text-navy">21 hour ago</small>
                                                </div>
                                                <div class="col-xs-7 content">
                                                    <p class="m-b-xs"><strong>Phone with Jeronimo</strong></p>
                                                    <p>
                                                        Lorem Ipsum has been the industry's standard dummy text ever since.
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="timeline-item">
                                            <div class="row">
                                                <div class="col-xs-3 dateDebut">
                                                    <i class="fa fa-user-md"></i>
                                                    09:00 pm
                                                    <br/>
                                                    <small>21 hour ago</small>
                                                </div>
                                                <div class="col-xs-7 content">
                                                    <p class="m-b-xs"><strong>Go to the doctor dr Smith</strong></p>
                                                    <p>
                                                        Find some issue and go to doctor.
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="timeline-item">
                                            <div class="row">
                                                <div class="col-xs-3 dateDebut">
                                                    <i class="fa fa-comments"></i>
                                                    12:50 pm
                                                    <br/>
                                                    <small class="text-navy">48 hour ago</small>
                                                </div>
                                                <div class="col-xs-7 content">
                                                    <p class="m-b-xs"><strong>Chat with Monica and Sandra</strong></p>
                                                    <p>
                                                        Web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                                                    </p>
                                                </div>
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

        </div>
        <div class="small-chat-box fadeInRight animated">

            <div class="heading" draggable="true">
                <small class="chat-dateDebut pull-right">
                    02.19.2015
                </small>
                Small chat
            </div>

            <div class="content">

                <div class="left">
                    <div class="author-nom">
                        Monica Jackson <small class="chat-dateDebut">
                        10:02 am
                    </small>
                    </div>
                    <div class="chat-message active">
                        Lorem Ipsum is simply dummy text input.
                    </div>

                </div>
                <div class="right">
                    <div class="author-nom">
                        Mick Smith
                        <small class="chat-dateDebut">
                            11:24 am
                        </small>
                    </div>
                    <div class="chat-message">
                        Lorem Ipsum is simpl.
                    </div>
                </div>
                <div class="left">
                    <div class="author-nom">
                        Alice Novak
                        <small class="chat-dateDebut">
                            08:45 pm
                        </small>
                    </div>
                    <div class="chat-message active">
                        Check this stock char.
                    </div>
                </div>
                <div class="right">
                    <div class="author-nom">
                        Anna Lamson
                        <small class="chat-dateDebut">
                            11:24 am
                        </small>
                    </div>
                    <div class="chat-message">
                        The standard chunk of Lorem Ipsum
                    </div>
                </div>
                <div class="left">
                    <div class="author-nom">
                        Mick Lane
                        <small class="chat-dateDebut">
                            08:45 pm
                        </small>
                    </div>
                    <div class="chat-message active">
                        I belive that. Lorem Ipsum is simply dummy text.
                    </div>
                </div>


            </div>
            <div class="form-chat">
                <div class="input-group input-group-sm"><input type="text" class="form-control"> <span class="input-group-btn"> <button
                class="btn btn-primary" type="button">Send
                </button> </span></div>
            </div>

        </div>
        <div id="small-chat">

            <span class="badge badge-warning pull-right">5</span>
            <a class="open-small-chat">
                <i class="fa fa-comments"></i>

            </a>
        </div>
        <div id="right-sidebar">
            <div class="sidebar-container">

                <ul class="nav nav-tabs navs-3">

                    <li class="active"><a data-toggle="tab" href="#tab-1">
                        Notes
                    </a></li>
                    <li><a data-toggle="tab" href="#tab-2">
                        Projects
                    </a></li>
                    <li class=""><a data-toggle="tab" href="#tab-3">
                        <i class="fa fa-gear"></i>
                    </a></li>
                </ul>

                <div class="tab-content">


                    <div id="tab-1" class="tab-pane active">

                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> Latest Notes</h3>
                            <small><i class="fa fa-tim"></i> You have 10 new message.</small>
                        </div>

                        <div>

                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="img/a1.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">

                                        There are many variations of passages of Lorem Ipsum available.
                                        <br>
                                        <small class="text-muted">Today 4:21 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="img/a2.jpg">
                                    </div>
                                    <div class="media-body">
                                        The point of using Lorem Ipsum is that it has a more-or-less normal.
                                        <br>
                                        <small class="text-muted">Yesterday 2:45 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="img/a3.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        Mevolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                                        <br>
                                        <small class="text-muted">Yesterday 1:10 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="img/a4.jpg">
                                    </div>

                                    <div class="media-body">
                                        Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the
                                        <br>
                                        <small class="text-muted">Monday 8:37 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="img/a8.jpg">
                                    </div>
                                    <div class="media-body">

                                        All the Lorem Ipsum generators on the Internet tend to repeat.
                                        <br>
                                        <small class="text-muted">Today 4:21 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="img/a7.jpg">
                              """),
format.raw("""      </div>
                                    <div class="media-body">
                                        Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.
                                        <br>
                                        <small class="text-muted">Yesterday 2:45 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="img/a3.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        The standard chunk of Lorem Ipsum used since the 1500s is reproduced below.
                                        <br>
                                        <small class="text-muted">Yesterday 1:10 pm</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="img/a4.jpg">
                                    </div>
                                    <div class="media-body">
                                        Uncover many web sites still in their infancy. Various versions have.
                                        <br>
                                        <small class="text-muted">Monday 8:37 pm</small>
                                    </div>
                                </a>
                            </div>
                        </div>

                    </div>

                    <div id="tab-2" class="tab-pane">

                        <div class="sidebar-title">
                            <h3> <i class="fa fa-cube"></i> Latest projects</h3>
                            <small><i class="fa fa-tim"></i> You have 14 projects. 10 not completed.</small>
                        </div>

                        <ul class="sidebar-list">
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Business valuation</h4>
                                    It is a long established fact that a reader will be distracted.

                                    <div class="small">Completion with: 22%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                    <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Contract with Company </h4>
                                    Many desktop publishing packages and web page editors.

                                    <div class="small">Completion with: 48%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 48%;" class="progress-bar"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Meeting</h4>
                                    By the readable content of a page when looking at its layout.

                                    <div class="small">Completion with: 14%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="label label-primary pull-right">NEW</span>
                                    <h4>The generated</h4>
                                        <!--<div class="small pull-right m-t-xs">9 hours ago</div>-->
                                        There are many variations of passages of Lorem Ipsum available.
                                    <div class="small">Completion with: 22%</div>
                                    <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Business valuation</h4>
                                    It is a long established fact that a reader will be distracted.

                                    <div class="small">Completion with: 22%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                    <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Contract with Company </h4>
                                    Many desktop publishing packages and web page editors.

                                    <div class="small">Completion with: 48%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 48%;" class="progress-bar"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9 hours ago</div>
                                    <h4>Meeting</h4>
                                    By the readable content of a page when looking at its layout.

                                    <div class="small">Completion with: 14%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="label label-primary pull-right">NEW</span>
                                    <h4>The generated</h4>
                                        <!--<div class="small pull-right m-t-xs">9 hours ago</div>-->
                                        There are many variations of passages of Lorem Ipsum available.
                                    <div class="small">Completion with: 22%</div>
                                    <div class="small text-muted m-t-xs">Project end: 4:00 pm - 12.06.2014</div>
                                </a>
                            </li>

                        </ul>

                    </div>

                    <div id="tab-3" class="tab-pane">

                        <div class="sidebar-title">
                            <h3><i class="fa fa-gears"></i> Settings</h3>
                            <small><i class="fa fa-tim"></i> You have 14 projects. 10 not completed.</small>
                        </div>

                        <div class="setings-item">
                            <span>
                                Show notifications
                            </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" nom="collapsemenu" class="onoffswitch-checkbox" id="example">
                                    <label class="onoffswitch-label" for="example">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>
                                Disable Chat
                            </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" nom="collapsemenu" checked class="onoffswitch-checkbox" id="example2">
                                    <label class="onoffswitch-label" for="example2">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>
                                Enable history
                            </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" nom="collapsemenu" class="onoffswitch-checkbox" id="example3">
                                    <label class="onoffswitch-label" for="example3">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>
                                Show charts
                            </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" nom="collapsemenu" class="onoffswitch-checkbox" id="example4">
                                    <label class="onoffswitch-label" for="example4">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>
                                Offline users
                            </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" checked nom="collapsemenu" class="onoffswitch-checkbox" id="example5">
                                    <label class="onoffswitch-label" for="example5">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>
                                Global search
                            </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" checked nom="collapsemenu" class="onoffswitch-checkbox" id="example6">
                                    <label class="onoffswitch-label" for="example6">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="setings-item">
                            <span>
                                Update everyday
                            </span>
                            <div class="switch">
                                <div class="onoffswitch">
                                    <input type="checkbox" nom="collapsemenu" class="onoffswitch-checkbox" id="example7">
                                    <label class="onoffswitch-label" for="example7">
                                        <span class="onoffswitch-inner"></span>
                                        <span class="onoffswitch-switch"></span>
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="sidebar-content">
                            <h4>Settings</h4>
                            <div class="small">
                                I belive that. Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                                And typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
                                Over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
""")))};
Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*138.2*/("""

"""),format.raw/*1377.2*/("""

"""),_display_(/*1379.2*/main(pageTitle,content, scripts)))
      }
    }
  }

  def render(pageTitle:String): play.twirl.api.HtmlFormat.Appendable = apply(pageTitle)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (pageTitle) => apply(pageTitle)

  def ref: this.type = this

}


}

/**/
object indexSave extends indexSave_Scope0.indexSave
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/indexSave.scala.html
                  HASH: 1e6b77a21ba4ea00f3e2045ee5d8f7a908033a0d
                  MATRIX: 753->1|850->23|864->30|944->34|975->39|1052->89|1080->90|1124->107|1173->129|1201->130|1249->151|1293->168|1321->169|1373->194|1570->363|1599->364|1731->468|1760->469|2344->1025|2373->1026|2430->1055|2466->1063|2495->1064|2556->1097|2591->1104|2620->1105|2685->1142|2805->1234|2834->1235|2905->1278|2934->1279|2999->1316|3217->1506|3246->1507|3316->1549|3345->1550|3410->1587|3528->1677|3557->1678|3661->1754|3690->1755|3754->1791|3783->1792|3844->1825|4117->2070|4146->2071|4270->2167|4299->2168|4356->2197|4385->2198|4450->2235|4479->2236|4540->2269|4605->2306|4634->2307|4731->2376|4760->2377|4805->2394|4894->2455|4923->2456|4976->2481|5161->2638|5190->2639|5240->2661|5269->2662|5322->2687|5511->2848|5540->2849|5590->2871|5619->2872|5672->2897|5860->3057|5889->3058|5934->3075|6004->3117|6033->3118|6082->3139|6493->3522|6522->3523|6785->3758|6814->3759|6867->3784|7053->3941|7083->3942|7134->3964|7164->3965|7218->3990|7409->4152|7439->4153|7490->4175|7520->4176|7574->4201|7763->4361|7793->4362|7839->4379|7907->4418|7937->4419|7987->4440|8617->5041|8647->5042|8857->5223|8887->5224|8929->5245|8945->5252|9027->5256|9060->5261|84442->20|84472->5242|84503->80550|84534->80553
                  LINES: 27->1|31->3|31->3|33->3|34->4|35->5|35->5|36->6|36->6|36->6|37->7|37->7|37->7|38->8|42->12|42->12|45->15|45->15|57->27|57->27|58->28|58->28|58->28|59->29|59->29|59->29|60->30|62->32|62->32|63->33|63->33|64->34|68->38|68->38|69->39|69->39|70->40|72->42|72->42|74->44|74->44|75->45|75->45|76->46|81->51|81->51|83->53|83->53|84->54|84->54|85->55|85->55|86->56|87->57|87->57|89->59|89->59|90->60|93->63|93->63|94->64|98->68|98->68|99->69|99->69|100->70|104->74|104->74|105->75|105->75|106->76|110->80|110->80|111->81|113->83|113->83|114->84|122->92|122->92|128->98|128->98|129->99|133->103|133->103|134->104|134->104|135->105|139->109|139->109|140->110|140->110|141->111|145->115|145->115|146->116|148->118|148->118|149->119|162->132|162->132|166->136|166->136|168->140|168->140|170->140|171->141|1411->1|1413->138|1415->1377|1417->1379
                  -- GENERATED --
              */
          