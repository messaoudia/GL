
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object table_data_tables_Scope0 {
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

class table_data_tables extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Data Tables</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Data Tables -->
    <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="css/plugins/dataTables/dataTables.responsive.css" rel="stylesheet">
    <link href="css/plugins/dataTables/dataTables.tableTools.min.css" rel="stylesheet">

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
                        <li class="active"><a href="table_data_tables.html">Data Tables</a></li>
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
"""),
format.raw("""                        </li>
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
            </ul>

        </nav>
        </div>
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>Data Tables</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li>
                            <a>Tables</a>
                        </li>
                        <li class="active">
                            <strong>Data Tables</strong>
                        </li>
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Basic Data Tables example with responsive plugin</h5>
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
                    <table class="table table-striped table-bordered table-hover dataTables-example" >
                    <thead>
                    <tr>
                        <th>Rendering engine</th>
                        <th>Browser</th>
                        <th>Platform(s)</th>
                        <th>Engine version</th>
                        <th>CSS grade</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="gradeX">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 4.0
                        </td>
                        <td>Win 95+</td>
                        <td class="center">4</td>
                        <td class="center">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 5.0
                        </td>
                        <td>Win 95+</td>
                        <td class="center">5</td>
                        <td class="center">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 5.5
                        </td>
                        <td>Win 95+</td>
                        <td class="center">5.5</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 6
                        </td>
                        <td>Win 98+</td>
                        <td class="center">6</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet Explorer 7</td>
                        <td>Win XP SP2+</td>
                        <td class="center">7</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>AOL browser (AOL desktop)</td>
                        <td>Win XP</td>
                        <td class="center">6</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 1.0</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center">1.7</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 1.5</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center">1.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 2.0</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center">1.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 3.0</td>
                        <td>Win 2k+ / OSX.3+</td>
                        <td class="center">1.9</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Camino 1.0</td>
                        <td>OSX.2+</td>
                        <td class="center">1.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Camino 1.5</td>
                        <td>OSX.3+</td>
                        <td class="center">1.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape 7.2</td>
                        <td>Win 95+ / Mac OS 8.6-9.2</td>
                        <td class="center">1.7</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape Browser 8</td>
                        <td>Win 98SE+</td>
                        <td class="center">1.7</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape Navigator 9</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center">1.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.0</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center">1</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.1</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center">1.1</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.2</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center">1.2</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.3</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center">1.3</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.4</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center">1.4</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.5</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center">1.5</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.6</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center">1.6</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.7</td>
                        <td>Win 98+ / OSX.1+</td>
                        <td class="center">1.7</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.8</td>
                        <td>Win 98+ / OSX.1+</td>
                        <td class="center">1.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Seamonkey 1.1</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center">1.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Epiphany 2.20</td>
                        <td>Gnome</td>
                        <td class="center">1.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 1.2</td>
                        <td>OSX.3</td>
                        <td class="center">125.5</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 1.3</td>
                        <td>OSX.3</td>
                        <td class="center">312.8</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 2.0</td>
                        <td>OSX.4+</td>
                        <td class="center">419.3</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 3.0</td>
                        <td>OSX.4+</td>
                        <td class="center">522.1</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>OmniWeb 5.5</td>
                        <td>OSX.4+</td>
                        <td class="center">420</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>iPod Touch / iPhone</td>
                        <td>iPod</td>
                        <td class="center">420.1</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>S60</td>
                        <td>S60</td>
                        <td class="center">413</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 7.0</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 7.5</td>
                        <td>Win 95+ / OSX.2+</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 8.0</td>
                        <td>Win 95+ / OSX.2+</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 8.5</td>
                        <td>Win 95+ / OSX.2+</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.0</td>
                        <td>Win 95+ / OSX.3+</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.2</td>
                        <td>Win 88+ / OSX.3+</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.5</td>
                        <td>Win 88+ / OSX.3+</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera for Wii</td>
                        <td>Wii</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Nokia N800</td>
                        <td>N800</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Nintendo DS browser</td>
                        <td>Nintendo DS</td>
                        <td class="center">8.5</td>
                        <td class="center">C/A<sup>1</sup></td>
                    </tr>
                    <tr class="gradeC">
                        <td>KHTML</td>
                        <td>Konqureror 3.1</td>
                        <td>KDE 3.1</td>
                        <td class="center">3.1</td>
                        <td class="center">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>KHTML</td>
                        <td>Konqureror 3.3</td>
                        <td>KDE 3.3</td>
                        <td class="center">3.3</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>KHTML</td>
                        <td>Konqureror 3.5</td>
                        <td>KDE 3.5</td>
                        <td class="center">3.5</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Tasman</td>
                        <td>Internet Explorer 4.5</td>
                        <td>Mac OS 8-9</td>
                        <td class="center">-</td>
                        <td class="center">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Tasman</td>
                        <td>Internet Explorer 5.1</td>
                        <td>Mac OS 7.6-9</td>
                        <td class="center">1</td>
                        <td class="center">C</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Tasman</td>
                        <td>Internet Explorer 5.2</td>
                        <td>Mac OS 8-X</td>
                        <td class="center">1</td>
                        <td class="center">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Misc</td>
                        <td>NetFront 3.1</td>
                        <td>Embedded devices</td>
                        <td class="center">-</td>
                        <td class="center">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Misc</td>
                        <td>NetFront 3.4</td>
                        <td>Embedded devices</td>
                        <td class="center">-</td>
                        <td class="center">A</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Misc</td>
                        <td>Dillo 0.8</td>
                        <td>Embedded devices</td>
                        <td class="center">-</td>
                        <td class="center">X</td>
                    </tr>
                    <tr class="gradeX">
                    """),
format.raw("""    <td>Misc</td>
                        <td>Links</td>
                        <td>Text only</td>
                        <td class="center">-</td>
                        <td class="center">X</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Misc</td>
                        <td>Lynx</td>
                        <td>Text only</td>
                        <td class="center">-</td>
                        <td class="center">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Misc</td>
                        <td>IE Mobile</td>
                        <td>Windows Mobile 6</td>
                        <td class="center">-</td>
                        <td class="center">C</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Misc</td>
                        <td>PSP browser</td>
                        <td>PSP</td>
                        <td class="center">-</td>
                        <td class="center">C</td>
                    </tr>
                    <tr class="gradeU">
                        <td>Other browsers</td>
                        <td>All others</td>
                        <td>-</td>
                        <td class="center">-</td>
                        <td class="center">U</td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>Rendering engine</th>
                        <th>Browser</th>
                        <th>Platform(s)</th>
                        <th>Engine version</th>
                        <th>CSS grade</th>
                    </tr>
                    </tfoot>
                    </table>
                        </div>

                    </div>
                </div>
            </div>
            </div>
            <div class="row">
            <div class="col-lg-12">
            <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Editable Table in- combination with jEditable</h5>
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
            <div class="">
            <a onclick="fnClickAddRow();" href="javascript:void(0);" class="btn btn-primary ">Add a new row</a>
            </div>
            <table class="table table-striped table-bordered table-hover " id="editable" >
            <thead>
            <tr>
                <th>Rendering engine</th>
                <th>Browser</th>
                <th>Platform(s)</th>
                <th>Engine version</th>
                <th>CSS grade</th>
            </tr>
            </thead>
            <tbody>
            <tr class="gradeX">
                <td>Trident</td>
                <td>Internet
                    Explorer 4.0
                </td>
                <td>Win 95+</td>
                <td class="center">4</td>
                <td class="center">X</td>
            </tr>
            <tr class="gradeC">
                <td>Trident</td>
                <td>Internet
                    Explorer 5.0
                </td>
                <td>Win 95+</td>
                <td class="center">5</td>
                <td class="center">C</td>
            </tr>
            <tr class="gradeA">
                <td>Trident</td>
                <td>Internet
                    Explorer 5.5
                </td>
                <td>Win 95+</td>
                <td class="center">5.5</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Trident</td>
                <td>Internet
                    Explorer 6
                </td>
                <td>Win 98+</td>
                <td class="center">6</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Trident</td>
                <td>Internet Explorer 7</td>
                <td>Win XP SP2+</td>
                <td class="center">7</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Trident</td>
                <td>AOL browser (AOL desktop)</td>
                <td>Win XP</td>
                <td class="center">6</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Firefox 1.0</td>
                <td>Win 98+ / OSX.2+</td>
                <td class="center">1.7</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Firefox 1.5</td>
                <td>Win 98+ / OSX.2+</td>
                <td class="center">1.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Firefox 2.0</td>
                <td>Win 98+ / OSX.2+</td>
                <td class="center">1.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Firefox 3.0</td>
                <td>Win 2k+ / OSX.3+</td>
                <td class="center">1.9</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Camino 1.0</td>
                <td>OSX.2+</td>
                <td class="center">1.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Camino 1.5</td>
                <td>OSX.3+</td>
                <td class="center">1.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Netscape 7.2</td>
                <td>Win 95+ / Mac OS 8.6-9.2</td>
                <td class="center">1.7</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Netscape Browser 8</td>
                <td>Win 98SE+</td>
                <td class="center">1.7</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Netscape Navigator 9</td>
                <td>Win 98+ / OSX.2+</td>
                <td class="center">1.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.0</td>
                <td>Win 95+ / OSX.1+</td>
                <td class="center">1</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.1</td>
                <td>Win 95+ / OSX.1+</td>
                <td class="center">1.1</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.2</td>
                <td>Win 95+ / OSX.1+</td>
                <td class="center">1.2</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.3</td>
                <td>Win 95+ / OSX.1+</td>
                <td class="center">1.3</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.4</td>
                <td>Win 95+ / OSX.1+</td>
                <td class="center">1.4</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.5</td>
                <td>Win 95+ / OSX.1+</td>
                <td class="center">1.5</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.6</td>
                <td>Win 95+ / OSX.1+</td>
                <td class="center">1.6</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.7</td>
                <td>Win 98+ / OSX.1+</td>
                <td class="center">1.7</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Mozilla 1.8</td>
                <td>Win 98+ / OSX.1+</td>
                <td class="center">1.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Seamonkey 1.1</td>
                <td>Win 98+ / OSX.2+</td>
                <td class="center">1.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Gecko</td>
                <td>Epiphany 2.20</td>
                <td>Gnome</td>
                <td class="center">1.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Webkit</td>
                <td>Safari 1.2</td>
                <td>OSX.3</td>
                <td class="center">125.5</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Webkit</td>
                <td>Safari 1.3</td>
                <td>OSX.3</td>
                <td class="center">312.8</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Webkit</td>
                <td>Safari 2.0</td>
                <td>OSX.4+</td>
                <td class="center">419.3</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Webkit</td>
                <td>Safari 3.0</td>
                <td>OSX.4+</td>
                <td class="center">522.1</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Webkit</td>
                <td>OmniWeb 5.5</td>
                <td>OSX.4+</td>
                <td class="center">420</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Webkit</td>
                <td>iPod Touch / iPhone</td>
                <td>iPod</td>
                <td class="center">420.1</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Webkit</td>
                <td>S60</td>
                <td>S60</td>
                <td class="center">413</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Opera 7.0</td>
                <td>Win 95+ / OSX.1+</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Opera 7.5</td>
                <td>Win 95+ / OSX.2+</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Opera 8.0</td>
                <td>Win 95+ / OSX.2+</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Opera 8.5</td>
                <td>Win 95+ / OSX.2+</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Opera 9.0</td>
                <td>Win 95+ / OSX.3+</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Opera 9.2</td>
                <td>Win 88+ / OSX.3+</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Opera 9.5</td>
                <td>Win 88+ / OSX.3+</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Opera for Wii</td>
                <td>Wii</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Nokia N800</td>
                <td>N800</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>Presto</td>
                <td>Nintendo DS browser</td>
                <td>Nintendo DS</td>
                <td class="center">8.5</td>
                <td class="center">C/A<sup>1</sup></td>
            </tr>
            <tr class="gradeC">
                <td>KHTML</td>
                <td>Konqureror 3.1</td>
                <td>KDE 3.1</td>
                <td class="center">3.1</td>
                <td class="center">C</td>
            </tr>
            <tr class="gradeA">
                <td>KHTML</td>
                <td>Konqureror 3.3</td>
                <td>KDE 3.3</td>
                <td class="center">3.3</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeA">
                <td>KHTML</td>
                <td>Konqureror 3.5</td>
                <td>KDE 3.5</td>
                <td class="center">3.5</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeX">
                <td>Tasman</td>
                <td>Internet Explorer 4.5</td>
                <td>Mac OS 8-9</td>
                <td class="center">-</td>
                <td class="center">X</td>
            </tr>
            <tr class="gradeC">
                <td>Tasman</td>
                <td>Internet Explorer 5.1</td>
                <td>Mac OS 7.6-9</td>
                <td class="center">1</td>
                <td class="center">C</td>
            </tr>
            <tr class="gradeC">
                <td>Tasman</td>
                <td>Internet Explorer 5.2</td>
                <td>Mac OS 8-X</td>
                <td class="center">1</td>
                <td class="center">C</td>
            </tr>
            <tr class="gradeA">
                <td>Misc</td>
                <td>NetFront 3.1</td>
                <td>Embedded devices</td>
                <td class="center">-</td>
                <td class="center">C</td>
            </tr>
            <tr class="gradeA">
                <td>Misc</td>
                <td>NetFront 3.4</td>
                <td>Embedded devices</td>
                <td class="center">-</td>
                <td class="center">A</td>
            </tr>
            <tr class="gradeX">
                <td>Misc</td>
                <td>Dillo 0.8</td>
                <td>Embedded devices</td>
                <td class="center">-</td>
                <td class="center">X</td>
            </tr>
            <tr class="gradeX">
                <td>Misc</td>
                <td>Links</td>
                <td>Text only</td>
                <td class="center">-</td>
                <td class="center">X</td>
            </tr>
            <tr class="gradeX">
                <td>Misc</td>
                <td>Lynx</td>
                <td>Text only</td>
                <td class="center">-</td>
                <td class="center">X</td>
            </tr>
            <tr class="gradeC">
                <td>Misc</td>
                <td>IE Mobile</td>
                <td>Windows Mobile 6</td>
                <td class="center">-</td>
                <td class="center">C</td>
            </tr>
            <tr class="gradeC">
                <td>Misc</td>
                <td>PSP browser</td>
                <td>PSP</td>
                <td class="center">-</td>
                <td class="center">C</td>
            </tr>
            <tr class="gradeU">
                <td>Other browsers</td>
                <td>All others</td>
                <td>-</td>
                <td class="center">-</td>
                <td class="center">U</td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <th>Rendering engine</th>
                <th>Browser</th>
                <th>Platform(s)</th>
                <th>Engine version</th>
                <th>CSS grade</th>
            </tr>
            </tfoot>
            </table>

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
    <script src="js/plugins/jeditable/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script src="js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script src="js/plugins/dataTables/dataTables.responsive.js"></script>
    <script src="js/plugins/dataTables/dataTables.tableTools.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <style>

    </style>

    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function() """),format.raw/*1348.38*/("""{"""),format.raw/*1348.39*/("""
            """),format.raw/*1349.13*/("""$('.dataTables-example').DataTable("""),format.raw/*1349.48*/("""{"""),format.raw/*1349.49*/("""
                """),format.raw/*1350.17*/(""""dom": 'lTfigt',
                "tableTools": """),format.raw/*1351.31*/("""{"""),format.raw/*1351.32*/("""
                    """),format.raw/*1352.21*/(""""sSwfPath": "js/plugins/dataTables/swf/copy_csv_xls_pdf.swf"
                """),format.raw/*1353.17*/("""}"""),format.raw/*1353.18*/("""
            """),format.raw/*1354.13*/("""}"""),format.raw/*1354.14*/(""");

            /* Init DataTables */
            var oTable = $('#editable').DataTable();

            /* Apply the jEditable handlers to the table */
            oTable.$('td').editable( '../example_ajax.php', """),format.raw/*1360.61*/("""{"""),format.raw/*1360.62*/("""
                """),format.raw/*1361.17*/(""""callback": function( sValue, y ) """),format.raw/*1361.51*/("""{"""),format.raw/*1361.52*/("""
                    """),format.raw/*1362.21*/("""var aPos = oTable.fnGetPosition( this );
                    oTable.fnUpdate( sValue, aPos[0], aPos[1] );
                """),format.raw/*1364.17*/("""}"""),format.raw/*1364.18*/(""",
                "submitdata": function ( value, settings ) """),format.raw/*1365.60*/("""{"""),format.raw/*1365.61*/("""
                    """),format.raw/*1366.21*/("""return """),format.raw/*1366.28*/("""{"""),format.raw/*1366.29*/("""
                        """),format.raw/*1367.25*/(""""row_id": this.parentNode.getAttribute('id'),
                        "column": oTable.fnGetPosition( this )[2]
                    """),format.raw/*1369.21*/("""}"""),format.raw/*1369.22*/(""";
                """),format.raw/*1370.17*/("""}"""),format.raw/*1370.18*/(""",

                "width": "90%",
                "height": "100%"
            """),format.raw/*1374.13*/("""}"""),format.raw/*1374.14*/(""" """),format.raw/*1374.15*/(""");


        """),format.raw/*1377.9*/("""}"""),format.raw/*1377.10*/(""");

        function fnClickAddRow() """),format.raw/*1379.34*/("""{"""),format.raw/*1379.35*/("""
            """),format.raw/*1380.13*/("""$('#editable').dataTable().fnAddData( [
                "Custom row",
                "New row",
                "New row",
                "New row",
                "New row" ] );

        """),format.raw/*1387.9*/("""}"""),format.raw/*1387.10*/("""
    """),format.raw/*1388.5*/("""</script>

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
object table_data_tables extends table_data_tables_Scope0.table_data_tables
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:20 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/table_data_tables.scala.html
                  HASH: 9635de7290eb94cc5db6205472584f17f8e5f340
                  MATRIX: 860->0|60534->59604|60565->59605|60609->59619|60674->59654|60705->59655|60753->59673|60831->59721|60862->59722|60914->59744|61022->59822|61053->59823|61097->59837|61128->59838|61376->60056|61407->60057|61455->60075|61519->60109|61550->60110|61602->60132|61756->60256|61787->60257|61879->60319|61910->60320|61962->60342|61999->60349|62030->60350|62086->60376|62250->60510|62281->60511|62330->60530|62361->60531|62475->60615|62506->60616|62537->60617|62582->60633|62613->60634|62682->60673|62713->60674|62757->60688|62984->60886|63015->60887|63050->60893
                  LINES: 32->1|1381->1348|1381->1348|1382->1349|1382->1349|1382->1349|1383->1350|1384->1351|1384->1351|1385->1352|1386->1353|1386->1353|1387->1354|1387->1354|1393->1360|1393->1360|1394->1361|1394->1361|1394->1361|1395->1362|1397->1364|1397->1364|1398->1365|1398->1365|1399->1366|1399->1366|1399->1366|1400->1367|1402->1369|1402->1369|1403->1370|1403->1370|1407->1374|1407->1374|1407->1374|1410->1377|1410->1377|1412->1379|1412->1379|1413->1380|1420->1387|1420->1387|1421->1388
                  -- GENERATED --
              */
          