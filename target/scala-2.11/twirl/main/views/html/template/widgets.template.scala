
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object widgets_Scope0 {
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

class widgets extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Widgets</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
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
                <li  class="active">
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
format.raw("""              <i class="fa fa-upload fa-fw"></i> Server Rebooted
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
                <div class="col-lg-9">
                    <h2>Widgets</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li class="active">
                            <strong>Widgets</strong>
                        </li>
                    </ol>
                </div>
            </div>
        <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-lg-3">
                <div class="widget style1">
                        <div class="row">
                            <div class="col-xs-4 text-center">
                                <i class="fa fa-trophy fa-5x"></i>
                            </div>
                            <div class="col-xs-8 text-right">
                                <span> Today income </span>
                                <h2 class="font-bold">$ 4,232</h2>
                            </div>
                        </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="widget style1 navy-bg">
                    <div class="row">
                        <div class="col-xs-4">
                            <i class="fa fa-cloud fa-5x"></i>
                        </div>
                        <div class="col-xs-8 text-right">
                            <span> Today degrees </span>
                            <h2 class="font-bold">26'C</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="widget style1 lazur-bg">
                    <div class="row">
                        <div class="col-xs-4">
                            <i class="fa fa-envelope-o fa-5x"></i>
                        </div>
                        <div class="col-xs-8 text-right">
                            <span> New messages </span>
                            <h2 class="font-bold">260</h2>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="widget style1 yellow-bg">
                    <div class="row">
                        <div class="col-xs-4">
                            <i class="fa fa-music fa-5x"></i>
                        </div>
                        <div class="col-xs-8 text-right">
                            <span> New albums </span>
                            <h2 class="font-bold">12</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="widget navy-bg no-padding">
                    <div class="p-m">
                        <h1 class="m-xs">$ 1,540</h1>

                        <h3 class="font-bold no-margins">
                            Annual income
                        </h3>
                        <small>Income form project Alpha.</small>
                    </div>
                    <div class="flot-chart">
                        <div class="flot-chart-content" id="flot-chart1"></div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="widget lazur-bg no-padding">
                    <div class="p-m">
                        <h1 class="m-xs">$ 210,660</h1>

                        <h3 class="font-bold no-margins">
                            Monthly income
                        </h3>
                        <small>Income form project Beta.</small>
                    </div>
                    <div class="flot-chart">
                        <div class="flot-chart-content" id="flot-chart2"></div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="widget yellw-bg no-padding">
                    <div class="p-m">
                        <h1 class="m-xs">$ 50,992</h1>

                        <h3 class="font-bold no-margins">
                            Half-year revenue margin
                        </h3>
                        <small>Sales marketing.</small>
                    </div>
                    <div class="flot-chart">
                        <div class="flot-chart-content" id="flot-chart3"></div>
                    </div>
                </div>
            </div>
        </div>
            <div class="row">
                <div class="col-lg-2">
                    <div class="widget style1 navy-bg">
                        <div class="row vertical-align">
                            <div class="col-xs-3">
                                <i class="fa fa-user fa-3x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <h2 class="font-bold">217</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="widget style1 navy-bg">
                        <div class="row vertical-align">
                            <div class="col-xs-3">
                                <i class="fa fa-thumbs-up fa-3x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <h2 class="font-bold">400</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="widget style1 navy-bg">
                        <div class="row vertical-align">
                            <div class="col-xs-3">
                                <i class="fa fa-rss fa-3x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <h2 class="font-bold">10</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="widget style1 lazur-bg">
                        <div class="row vertical-align">
                            <div class="col-xs-3">
                                <i class="fa fa-phone fa-3x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <h2 class="font-bold">120</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="widget style1 lazur-bg">
                        <div class="row vertical-align">
                            <div class="col-xs-3">
                                <i class="fa fa-euro fa-3x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <h2 class="font-bold">462</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                    <div class="widget style1 yellow-bg">
                        <div class="row vertical-align">
                            <div class="col-xs-3">
                                <i class="fa fa-shield fa-3x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <h2 class="font-bold">610</h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4">
                        <div class="widget-head-color-box navy-bg p-lg text-center">
                            <div class="m-b-md">
                            <h2 class="font-bold no-margins">
                                Alex Smith
                            </h2>
                                <small>Founder of Groupeq</small>
                            </div>
                            <img src="img/a4.jpg" class="img-circle circle-border m-b-md" alt="profile">
                            <div>
                                <span>100 Tweets</span> |
                                <span>350 Following</span> |
                                <span>610 Followers</span>
                            </div>
                        </div>
                        <div class="widget-text-box">
                            <h4 class="media-heading">Alex Smith</h4>
                            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                            <div class="text-right">
                                <a class="btn btn-xs btn-white"><i class="fa fa-thumbs-up"></i> Like </a>
                                <a class="btn btn-xs btn-primary"><i class="fa fa-heart"></i> Love</a>
                            </div>
                        </div>
                </div>
                <div class="col-lg-2">
                    <div class="widget navy-bg p-lg text-center">
                        <div class="m-b-md">
                            <i class="fa fa-shield fa-4x"></i>
                            <h1 class="m-xs">456</h1>
                            <h3 class="font-bold no-margins">
                                Shield
                            </h3>
                            <small>power</small>
                        </div>
                    </div>
                    <div class="widget  p-lg text-center">
                        <div class="m-b-md">
                            <i class="fa fa-flash fa-4x"></i>
                            <h1 class="m-xs">612</h1>
                            <h3 class="font-bold no-margins">
                                Thunder
                            </h3>
                            <small>amount</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="widget lazur-bg p-xl">

                                <h2>
                                    Janet Smith
                                </h2>
                        <ul class="list-unstyled m-t-md">
                            <li>
                                <span class="fa fa-envelope m-r-xs"></span>
                                <label>Email:</label>
                                mike@mail.com
                            </li>
                            <li>
                                <span class="fa fa-home m-r-xs"></span>
                                <label>Address:</label>
                                Street 200, Avenue 10
                            </li>
                            <li>
                                <span class="fa fa-phone m-r-xs"></span>
                                <label>Contact:</label>
                                (+121) 678 3462
                            </li>
                        </ul>

                    </div>
                    <div class="widget red-bg p-lg text-center">
                        <div class="m-b-md">
                            <i class="fa fa-bell fa-4x"></i>
                            <h1 class="m-xs">47</h1>
                            <h3 class="font-bold no-margins">
                                Notification
                            </h3>
                            <small>We detect the error.</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2">
                <div class="widget yellow-bg p-lg text-center">
                    <div class="m-b-md">
                        <i class="fa fa-thumbs-up fa-4x"></i>
                        <h1 class="m-xs">520</h1>
                        <h3 class="font-bold no-margins">
                            Likes
                        </h3>
                        <small>amount</small>
                    </div>
                </div>
                    <div class="widget yellow-bg p-lg text-center">
                        <div class="m-b-md">
                            <i class="fa fa-warning fa-4x"></i>
                            <h1 class="m-xs">Alarm</h1>
                            <h3 class="font-bold no-margins">
                                Do
                            </h3>
                            <small>something</small>
                        </div>
                    </div>
                    </div>
            </div>
        <div class="row m-t-lg">
            <div class="col-lg-6">
                <div class="ibox float-e-margins">

                    <div class="ibox-content">

                        <div>
                <div class="chat-activity-list">

                    <div class="chat-element">
                        <a href="#" class="pull-left">
                            <img alt="image" class="img-circle" src="img/a2.jpg">
                        </a>
                        <div class="media-body ">
                            <small class="pull-right text-navy">1m ago</small>
                            <strong>Mike Smith</strong>
                            <p class="m-b-xs">
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                            </p>
                            <small class="text-muted">Today 4:21 pm - 12.06.2014</small>
                        </div>
                    </div>

                    <div class="chat-element right">
                        <a href="#" class="pull-right">
                            <img alt="image" class="img-circle" src="img/a4.jpg">
                        </a>
                        <div class="media-body text-right ">
                            <small class="pull-left">5m ago</small>
                            <strong>John Smith</strong>
                            <p class="m-b-xs">
                                Lorem Ipsum is simply dummy text of the printing.
                            </p>
                            <small class="text-muted">Today 4:21 pm - 12.06.2014</small>
                        </div>
                    </div>

                    <div class="chat-element ">
                        <a href="#" class="pull-left">
                            <img alt="image" class="img-circle" src="img/a2.jpg">
                        </a>
                        <div class="media-body ">
                            <small class="pull-right">2h ago</small>
                            <strong>Mike Smith</strong>
                            <p class="m-b-xs">
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                            </p>
                            <small class="text-muted">Today 4:21 pm - 12.06.2014</small>
                        </div>
                    </div>
                </div>
                </div>
                        <div class="chat-form">
                            <form role="form">
                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Message"></textarea>
                                </div>
                                <div class="text-right">
                                    <button type="submit" class="btn btn-sm btn-primary m-t-n-xs"><strong>Send message</strong></button>
                                </div>
                            </form>
                        </div>
                </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div>
                    <table class="table">
                        <tbody>
                        <tr>
                            <td>
                                <button type="button" class="btn btn-danger m-r-sm">12</button>
                                Total messages
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary m-r-sm">28</button>
                                Posts
                            </td>
                            <td>
                                <button type="button" class="btn btn-info m-r-sm">15</button>
                               Comments
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button type="button" class="btn btn-info m-r-sm">20</button>
                                News
                            </td>
                            <td>
                                <button type="button" class="btn btn-success m-r-sm">40</button>
                                Likes
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger m-r-sm">30</button>
                                Notifications
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button type="button" class="btn btn-warning m-r-sm">20</button>
                                Albums
                            </td>
                            <td>
                                <button type="button" class="btn btn-default m-r-sm">40</button>
                                Groups
                            </td>
                            <td>
                                <button type="button" class="btn btn-warning m-r-sm">30</button>
                                Permissions
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="ibox-content text-center">
                                <h1>"""),
format.raw("""Nicki Smith</h1>
                                <div class="m-b-sm">
                                        <img alt="image" class="img-circle" src="img/a8.jpg">
                                </div>
                                        <p class="font-bold">Consectetur adipisicing</p>

                                <div class="text-center">
                                    <a class="btn btn-xs btn-white"><i class="fa fa-thumbs-up"></i> Like </a>
                                    <a class="btn btn-xs btn-primary"><i class="fa fa-heart"></i> Love</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="ibox-content">
                                <div>
                                    <div>
                                        <span>Memory</span>
                                        <small class="pull-right">10/200 GB</small>
                                    </div>
                                    <div class="progress progress-small">
                                        <div style="width: 60%;" class="progress-bar"></div>
                                    </div>

                                    <div>
                                        <span>Bandwidth</span>
                                        <small class="pull-right">20 GB</small>
                                    </div>
                                    <div class="progress progress-small">
                                        <div style="width: 50%;" class="progress-bar"></div>
                                    </div>

                                    <div>
                                        <span>Activity</span>
                                        <small class="pull-right">73%</small>
                                    </div>
                                    <div class="progress progress-small">
                                        <div style="width: 40%;" class="progress-bar"></div>
                                    </div>

                                    <div>
                                        <span>FTP</span>
                                        <small class="pull-right">400 GB</small>
                                    </div>
                                    <div class="progress progress-small">
                                        <div style="width: 20%;" class="progress-bar progress-bar-danger"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div class="ibox-content">
                    <h2>TODO List</h2>
                    <small>This is example of task list</small>
                    <ul class="todo-list m-t">
                        <li>
                            <input type="checkbox" value="" nom="" class="i-checks"/>
                            <span class="m-l-xs">Buy a milk</span>
                            <small class="label label-primary"><i class="fa fa-clock-o"></i> 1 mins</small>
                        </li>
                        <li>
                            <input type="checkbox" value="" nom="" class="i-checks" checked/>
                            <span class="m-l-xs">Go to shop and find some products.</span>
                            <small class="label label-info"><i class="fa fa-clock-o"></i> 3 mins</small>
                        </li>
                        <li>
                            <input type="checkbox" value="" nom="" class="i-checks" />
                            <span class="m-l-xs">Send documents to Mike</span>
                            <small class="label label-warning"><i class="fa fa-clock-o"></i> 2 mins</small>
                        </li>
                        <li>
                            <input type="checkbox" value="" nom="" class="i-checks"/>
                            <span class="m-l-xs">Go to the doctor dr Smith</span>
                            <small class="label label-danger"><i class="fa fa-clock-o"></i> 42 mins</small>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <h2>TODO Small version</h2>
                        <small>This is example of small version of todo list</small>
                        <ul class="todo-list m-t small-list">
                            <li>
                                <a href="#" class="check-link"><i class="fa fa-check-square"></i> </a>
                                <span class="m-l-xs todo-completed">Buy a milk</span>

                            </li>
                            <li>
                                <a href="#" class="check-link"><i class="fa fa-check-square"></i> </a>
                                <span class="m-l-xs  todo-completed">Go to shop and find some products.</span>

                            </li>
                            <li>
                                <a href="#" class="check-link"><i class="fa fa-square-o"></i> </a>
                                <span class="m-l-xs">Send documents to Mike</span>
                                <small class="label label-primary"><i class="fa fa-clock-o"></i> 1 mins</small>
                            </li>
                            <li>
                                <a href="#" class="check-link"><i class="fa fa-square-o"></i> </a>
                                <span class="m-l-xs">Go to the doctor dr Smith</span>
                            </li>
                            <li>
                                <a href="#" class="check-link"><i class="fa fa-square-o"></i> </a>
                                <span class="m-l-xs">Plan vacation</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row m-t-lg">
            <div class="col-lg-12">
                <div class="ibox-content">
                    <h2>Word map</h2>
                    <small>This is simple example of map</small>
                <div id="world-map" style="height: 300px;"></div>
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
    <script src="js/jquery-ui-1.10.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>

    <!-- Jvectormap -->
    <script src="js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

    <!-- Flot -->
    <script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>
    <script>
        $(document).ready(function()"""),format.raw/*940.37*/("""{"""),format.raw/*940.38*/("""
            """),format.raw/*941.13*/("""var d1 = [[1262304000000, 6], [1264982400000, 3057], [1267401600000, 20434], [1270080000000, 31982], [1272672000000, 26602], [1275350400000, 27826], [1277942400000, 24302], [1280620800000, 24237], [1283299200000, 21004], [1285891200000, 12144], [1288569600000, 10577], [1291161600000, 10295]];
            var d2 = [[1262304000000, 5], [1264982400000, 200], [1267401600000, 1605], [1270080000000, 6129], [1272672000000, 11643], [1275350400000, 19055], [1277942400000, 30062], [1280620800000, 39197], [1283299200000, 37000], [1285891200000, 27000], [1288569600000, 21000], [1291161600000, 17000]];

            var data1 = [
                """),format.raw/*945.17*/("""{"""),format.raw/*945.18*/(""" """),format.raw/*945.19*/("""label: "Data 1", data: d1, color: '#17a084'"""),format.raw/*945.62*/("""}"""),format.raw/*945.63*/(""",
                """),format.raw/*946.17*/("""{"""),format.raw/*946.18*/(""" """),format.raw/*946.19*/("""label: "Data 2", data: d2, color: '#127e68' """),format.raw/*946.63*/("""}"""),format.raw/*946.64*/("""
            """),format.raw/*947.13*/("""];
            $.plot($("#flot-chart1"), data1, """),format.raw/*948.46*/("""{"""),format.raw/*948.47*/("""
                """),format.raw/*949.17*/("""xaxis: """),format.raw/*949.24*/("""{"""),format.raw/*949.25*/("""
                    """),format.raw/*950.21*/("""tickDecimals: 0
                """),format.raw/*951.17*/("""}"""),format.raw/*951.18*/(""",
                series: """),format.raw/*952.25*/("""{"""),format.raw/*952.26*/("""
                    """),format.raw/*953.21*/("""lines: """),format.raw/*953.28*/("""{"""),format.raw/*953.29*/("""
                        """),format.raw/*954.25*/("""show: true,
                        fill: true,
                        fillColor: """),format.raw/*956.36*/("""{"""),format.raw/*956.37*/("""
                            """),format.raw/*957.29*/("""colors: ["""),format.raw/*957.38*/("""{"""),format.raw/*957.39*/("""
                                """),format.raw/*958.33*/("""opacity: 1
                            """),format.raw/*959.29*/("""}"""),format.raw/*959.30*/(""", """),format.raw/*959.32*/("""{"""),format.raw/*959.33*/("""
                                """),format.raw/*960.33*/("""opacity: 1
                            """),format.raw/*961.29*/("""}"""),format.raw/*961.30*/("""]
                        """),format.raw/*962.25*/("""}"""),format.raw/*962.26*/("""
                    """),format.raw/*963.21*/("""}"""),format.raw/*963.22*/(""",
                    points: """),format.raw/*964.29*/("""{"""),format.raw/*964.30*/("""
                        """),format.raw/*965.25*/("""width: 0.1,
                        show: false
                    """),format.raw/*967.21*/("""}"""),format.raw/*967.22*/("""
                """),format.raw/*968.17*/("""}"""),format.raw/*968.18*/(""",
                grid: """),format.raw/*969.23*/("""{"""),format.raw/*969.24*/("""
                    """),format.raw/*970.21*/("""show: false,
                    borderWidth: 0
                """),format.raw/*972.17*/("""}"""),format.raw/*972.18*/(""",
                legend: """),format.raw/*973.25*/("""{"""),format.raw/*973.26*/("""
                    """),format.raw/*974.21*/("""show: false
                """),format.raw/*975.17*/("""}"""),format.raw/*975.18*/("""
            """),format.raw/*976.13*/("""}"""),format.raw/*976.14*/(""");

            var data2 = [
                """),format.raw/*979.17*/("""{"""),format.raw/*979.18*/(""" """),format.raw/*979.19*/("""label: "Data 1", data: d1, color: '#19a0a1'"""),format.raw/*979.62*/("""}"""),format.raw/*979.63*/("""
            """),format.raw/*980.13*/("""];
            $.plot($("#flot-chart2"), data2, """),format.raw/*981.46*/("""{"""),format.raw/*981.47*/("""
                """),format.raw/*982.17*/("""xaxis: """),format.raw/*982.24*/("""{"""),format.raw/*982.25*/("""
                    """),format.raw/*983.21*/("""tickDecimals: 0
                """),format.raw/*984.17*/("""}"""),format.raw/*984.18*/(""",
                series: """),format.raw/*985.25*/("""{"""),format.raw/*985.26*/("""
                    """),format.raw/*986.21*/("""lines: """),format.raw/*986.28*/("""{"""),format.raw/*986.29*/("""
                        """),format.raw/*987.25*/("""show: true,
                        fill: true,
                        fillColor: """),format.raw/*989.36*/("""{"""),format.raw/*989.37*/("""
                            """),format.raw/*990.29*/("""colors: ["""),format.raw/*990.38*/("""{"""),format.raw/*990.39*/("""
                                """),format.raw/*991.33*/("""opacity: 1
                            """),format.raw/*992.29*/("""}"""),format.raw/*992.30*/(""", """),format.raw/*992.32*/("""{"""),format.raw/*992.33*/("""
                                """),format.raw/*993.33*/("""opacity: 1
                            """),format.raw/*994.29*/("""}"""),format.raw/*994.30*/("""]
                        """),format.raw/*995.25*/("""}"""),format.raw/*995.26*/("""
                    """),format.raw/*996.21*/("""}"""),format.raw/*996.22*/(""",
                    points: """),format.raw/*997.29*/("""{"""),format.raw/*997.30*/("""
                        """),format.raw/*998.25*/("""width: 0.1,
                        show: false
                    """),format.raw/*1000.21*/("""}"""),format.raw/*1000.22*/("""
                """),format.raw/*1001.17*/("""}"""),format.raw/*1001.18*/(""",
                grid: """),format.raw/*1002.23*/("""{"""),format.raw/*1002.24*/("""
                    """),format.raw/*1003.21*/("""show: false,
                    borderWidth: 0
                """),format.raw/*1005.17*/("""}"""),format.raw/*1005.18*/(""",
                legend: """),format.raw/*1006.25*/("""{"""),format.raw/*1006.26*/("""
                    """),format.raw/*1007.21*/("""show: false
                """),format.raw/*1008.17*/("""}"""),format.raw/*1008.18*/("""
            """),format.raw/*1009.13*/("""}"""),format.raw/*1009.14*/(""");

            var data3 = [
                """),format.raw/*1012.17*/("""{"""),format.raw/*1012.18*/(""" """),format.raw/*1012.19*/("""label: "Data 1", data: d1, color: '#fbbe7b'"""),format.raw/*1012.62*/("""}"""),format.raw/*1012.63*/(""",
                """),format.raw/*1013.17*/("""{"""),format.raw/*1013.18*/(""" """),format.raw/*1013.19*/("""label: "Data 2", data: d2, color: '#f8ac59' """),format.raw/*1013.63*/("""}"""),format.raw/*1013.64*/("""
            """),format.raw/*1014.13*/("""];
            $.plot($("#flot-chart3"), data3, """),format.raw/*1015.46*/("""{"""),format.raw/*1015.47*/("""
                """),format.raw/*1016.17*/("""xaxis: """),format.raw/*1016.24*/("""{"""),format.raw/*1016.25*/("""
                    """),format.raw/*1017.21*/("""tickDecimals: 0
                """),format.raw/*1018.17*/("""}"""),format.raw/*1018.18*/(""",
                series: """),format.raw/*1019.25*/("""{"""),format.raw/*1019.26*/("""
                    """),format.raw/*1020.21*/("""lines: """),format.raw/*1020.28*/("""{"""),format.raw/*1020.29*/("""
                        """),format.raw/*1021.25*/("""show: true,
                        fill: true,
                        fillColor: """),format.raw/*1023.36*/("""{"""),format.raw/*1023.37*/("""
                            """),format.raw/*1024.29*/("""colors: ["""),format.raw/*1024.38*/("""{"""),format.raw/*1024.39*/("""
                                """),format.raw/*1025.33*/("""opacity: 1
                            """),format.raw/*1026.29*/("""}"""),format.raw/*1026.30*/(""", """),format.raw/*1026.32*/("""{"""),format.raw/*1026.33*/("""
                                """),format.raw/*1027.33*/("""opacity: 1
                            """),format.raw/*1028.29*/("""}"""),format.raw/*1028.30*/("""]
                        """),format.raw/*1029.25*/("""}"""),format.raw/*1029.26*/("""
                    """),format.raw/*1030.21*/("""}"""),format.raw/*1030.22*/(""",
                    points: """),format.raw/*1031.29*/("""{"""),format.raw/*1031.30*/("""
                        """),format.raw/*1032.25*/("""width: 0.1,
                        show: false
                    """),format.raw/*1034.21*/("""}"""),format.raw/*1034.22*/("""
                """),format.raw/*1035.17*/("""}"""),format.raw/*1035.18*/(""",
                grid: """),format.raw/*1036.23*/("""{"""),format.raw/*1036.24*/("""
                    """),format.raw/*1037.21*/("""show: false,
                    borderWidth: 0
                """),format.raw/*1039.17*/("""}"""),format.raw/*1039.18*/(""",
                legend: """),format.raw/*1040.25*/("""{"""),format.raw/*1040.26*/("""
                    """),format.raw/*1041.21*/("""show: false
                """),format.raw/*1042.17*/("""}"""),format.raw/*1042.18*/("""
            """),format.raw/*1043.13*/("""}"""),format.raw/*1043.14*/(""");

            $('.i-checks').iCheck("""),format.raw/*1045.35*/("""{"""),format.raw/*1045.36*/("""
                """),format.raw/*1046.17*/("""checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green'
            """),format.raw/*1048.13*/("""}"""),format.raw/*1048.14*/(""");

            $(".todo-list").sortable("""),format.raw/*1050.38*/("""{"""),format.raw/*1050.39*/("""
                """),format.raw/*1051.17*/("""placeholder: "sort-highlight",
                handle: ".handle",
                forcePlaceholderSize: true,
                zIndex: 999999
            """),format.raw/*1055.13*/("""}"""),format.raw/*1055.14*/(""").disableSelection();

            var mapData = """),format.raw/*1057.27*/("""{"""),format.raw/*1057.28*/("""
                """),format.raw/*1058.17*/(""""US": 498,
                "SA": 200,
                "CA": 1300,
                "DE": 220,
                "FR": 540,
                "CN": 120,
                "AU": 760,
                "BR": 550,
                "IN": 200,
                "GB": 120,
                "RU": 2000
            """),format.raw/*1069.13*/("""}"""),format.raw/*1069.14*/(""";

            $('#world-map').vectorMap("""),format.raw/*1071.39*/("""{"""),format.raw/*1071.40*/("""
                """),format.raw/*1072.17*/("""map: 'world_mill_en',
                backgroundColor: "transparent",
                regionStyle: """),format.raw/*1074.30*/("""{"""),format.raw/*1074.31*/("""
                    """),format.raw/*1075.21*/("""initial: """),format.raw/*1075.30*/("""{"""),format.raw/*1075.31*/("""
                        """),format.raw/*1076.25*/("""fill: '#e4e4e4',
                        "fill-opacity": 1,
                        stroke: 'none',
                        "stroke-width": 0,
                        "stroke-opacity": 0
                    """),format.raw/*1081.21*/("""}"""),format.raw/*1081.22*/("""
                """),format.raw/*1082.17*/("""}"""),format.raw/*1082.18*/(""",
                series: """),format.raw/*1083.25*/("""{"""),format.raw/*1083.26*/("""
                    """),format.raw/*1084.21*/("""regions: ["""),format.raw/*1084.31*/("""{"""),format.raw/*1084.32*/("""
                        """),format.raw/*1085.25*/("""values: mapData,
                        scale: ["#1ab394", "#22d6b1"],
                        normalizeFunction: 'polynomial'
                    """),format.raw/*1088.21*/("""}"""),format.raw/*1088.22*/("""]
                """),format.raw/*1089.17*/("""}"""),format.raw/*1089.18*/("""
            """),format.raw/*1090.13*/("""}"""),format.raw/*1090.14*/(""");
        """),format.raw/*1091.9*/("""}"""),format.raw/*1091.10*/(""");
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
object widgets extends widgets_Scope0.widgets
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:19 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/widgets.scala.html
                  HASH: 5b7e233c518817783f82e34f0d3e9da425d805b6
                  MATRIX: 840->0|48998->48090|49028->48091|49071->48105|49744->48749|49774->48750|49804->48751|49876->48794|49906->48795|49954->48814|49984->48815|50014->48816|50087->48860|50117->48861|50160->48875|50238->48924|50268->48925|50315->48943|50351->48950|50381->48951|50432->48973|50494->49006|50524->49007|50580->49034|50610->49035|50661->49057|50697->49064|50727->49065|50782->49091|50896->49176|50926->49177|50985->49207|51023->49216|51053->49217|51116->49251|51185->49291|51215->49292|51246->49294|51276->49295|51339->49329|51408->49369|51438->49370|51494->49397|51524->49398|51575->49420|51605->49421|51665->49452|51695->49453|51750->49479|51849->49549|51879->49550|51926->49568|51956->49569|52010->49594|52040->49595|52091->49617|52186->49683|52216->49684|52272->49711|52302->49712|52353->49734|52411->49763|52441->49764|52484->49778|52514->49779|52592->49828|52622->49829|52652->49830|52724->49873|52754->49874|52797->49888|52875->49937|52905->49938|52952->49956|52988->49963|53018->49964|53069->49986|53131->50019|53161->50020|53217->50047|53247->50048|53298->50070|53334->50077|53364->50078|53419->50104|53533->50189|53563->50190|53622->50220|53660->50229|53690->50230|53753->50264|53822->50304|53852->50305|53883->50307|53913->50308|53976->50342|54045->50382|54075->50383|54131->50410|54161->50411|54212->50433|54242->50434|54302->50465|54332->50466|54387->50492|54487->50562|54518->50563|54566->50581|54597->50582|54652->50607|54683->50608|54735->50630|54831->50696|54862->50697|54919->50724|54950->50725|55002->50747|55061->50776|55092->50777|55136->50791|55167->50792|55246->50841|55277->50842|55308->50843|55381->50886|55412->50887|55461->50906|55492->50907|55523->50908|55597->50952|55628->50953|55672->50967|55751->51016|55782->51017|55830->51035|55867->51042|55898->51043|55950->51065|56013->51098|56044->51099|56101->51126|56132->51127|56184->51149|56221->51156|56252->51157|56308->51183|56423->51268|56454->51269|56514->51299|56553->51308|56584->51309|56648->51343|56718->51383|56749->51384|56781->51386|56812->51387|56876->51421|56946->51461|56977->51462|57034->51489|57065->51490|57117->51512|57148->51513|57209->51544|57240->51545|57296->51571|57396->51641|57427->51642|57475->51660|57506->51661|57561->51686|57592->51687|57644->51709|57740->51775|57771->51776|57828->51803|57859->51804|57911->51826|57970->51855|58001->51856|58045->51870|58076->51871|58146->51911|58177->51912|58225->51930|58360->52035|58391->52036|58464->52079|58495->52080|58543->52098|58730->52255|58761->52256|58842->52307|58873->52308|58921->52326|59256->52631|59287->52632|59360->52675|59391->52676|59439->52694|59570->52795|59601->52796|59653->52818|59692->52827|59723->52828|59779->52854|60021->53066|60052->53067|60100->53085|60131->53086|60188->53113|60219->53114|60271->53136|60311->53146|60342->53147|60398->53173|60579->53324|60610->53325|60659->53344|60690->53345|60734->53359|60765->53360|60806->53372|60837->53373
                  LINES: 32->1|973->940|973->940|974->941|978->945|978->945|978->945|978->945|978->945|979->946|979->946|979->946|979->946|979->946|980->947|981->948|981->948|982->949|982->949|982->949|983->950|984->951|984->951|985->952|985->952|986->953|986->953|986->953|987->954|989->956|989->956|990->957|990->957|990->957|991->958|992->959|992->959|992->959|992->959|993->960|994->961|994->961|995->962|995->962|996->963|996->963|997->964|997->964|998->965|1000->967|1000->967|1001->968|1001->968|1002->969|1002->969|1003->970|1005->972|1005->972|1006->973|1006->973|1007->974|1008->975|1008->975|1009->976|1009->976|1012->979|1012->979|1012->979|1012->979|1012->979|1013->980|1014->981|1014->981|1015->982|1015->982|1015->982|1016->983|1017->984|1017->984|1018->985|1018->985|1019->986|1019->986|1019->986|1020->987|1022->989|1022->989|1023->990|1023->990|1023->990|1024->991|1025->992|1025->992|1025->992|1025->992|1026->993|1027->994|1027->994|1028->995|1028->995|1029->996|1029->996|1030->997|1030->997|1031->998|1033->1000|1033->1000|1034->1001|1034->1001|1035->1002|1035->1002|1036->1003|1038->1005|1038->1005|1039->1006|1039->1006|1040->1007|1041->1008|1041->1008|1042->1009|1042->1009|1045->1012|1045->1012|1045->1012|1045->1012|1045->1012|1046->1013|1046->1013|1046->1013|1046->1013|1046->1013|1047->1014|1048->1015|1048->1015|1049->1016|1049->1016|1049->1016|1050->1017|1051->1018|1051->1018|1052->1019|1052->1019|1053->1020|1053->1020|1053->1020|1054->1021|1056->1023|1056->1023|1057->1024|1057->1024|1057->1024|1058->1025|1059->1026|1059->1026|1059->1026|1059->1026|1060->1027|1061->1028|1061->1028|1062->1029|1062->1029|1063->1030|1063->1030|1064->1031|1064->1031|1065->1032|1067->1034|1067->1034|1068->1035|1068->1035|1069->1036|1069->1036|1070->1037|1072->1039|1072->1039|1073->1040|1073->1040|1074->1041|1075->1042|1075->1042|1076->1043|1076->1043|1078->1045|1078->1045|1079->1046|1081->1048|1081->1048|1083->1050|1083->1050|1084->1051|1088->1055|1088->1055|1090->1057|1090->1057|1091->1058|1102->1069|1102->1069|1104->1071|1104->1071|1105->1072|1107->1074|1107->1074|1108->1075|1108->1075|1108->1075|1109->1076|1114->1081|1114->1081|1115->1082|1115->1082|1116->1083|1116->1083|1117->1084|1117->1084|1117->1084|1118->1085|1121->1088|1121->1088|1122->1089|1122->1089|1123->1090|1123->1090|1124->1091|1124->1091
                  -- GENERATED --
              */
          