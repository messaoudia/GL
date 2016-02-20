
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object toastr_notifications_Scope0 {
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

class toastr_notifications extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Toastr notifications</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet">

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
                        <li class="active"><a href="toastr_notifications.html">Notification</a></li>
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
    """),
format.raw("""                            <div>
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
                    <h2>Toastr notifications</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                        <li>
                            <a>UI Elements</a>
                        </li>
                        <li class="active">
                            <strong>Toastr notifications</strong>
                        </li>
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
        <div class="wrapper wrapper-content animated fadeIn">
            <div class="row">
                <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Toastr examples</h5>
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
                            <div class="col-md-4">
                                <div class="form-group">
                                        <label for="title">Title</label>
                                        <input id="title" type="text" class="form-control" placeholder="Enter a title ..." />
                                    </div>
                                <div class="form-group">
                                        <label for="message">Message</label>
                                        <textarea class="form-control" id="message" rows="3" placeholder="Enter a message ..."></textarea>
                                </div>
                                    <div class="checkbox">
                                        <label class="checkbox" for="closeButton">
                                            <input id="closeButton" type="checkbox" value="checked" class="input-mini" checked/>Close Button
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label class="checkbox" for="addBehaviorOnToastClick">
                                            <input id="addBehaviorOnToastClick" type="checkbox" value="checked" class="input-mini" />Add behavior on toast click
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label class="checkbox" for="debugInfo">
                                            <input id="debugInfo" type="checkbox" value="checked" class="input-mini" />Debug
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label class="checkbox" for="progressBar">
                                            <input id="progressBar" type="checkbox" value="checked" class="input-mini" checked/>Progress Bar
                                        </label>
                                    </div>
                                    <div class="checkbox">
                                        <label class="checkbox" for="preventDuplicates">
                                            <input id="preventDuplicates" type="checkbox" value="checked" class="input-mini" />Prevent Duplicates
                                        </label>
                                    </div>
                            </div>

                            <div class="col-md-2">
                                <div class="form-group" id="toastTypeGroup">
                                        <label>Toast Type</label>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="toasts" value="success" checked />Success
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label class="radio">
                                            <input type="radio" name="toasts" value="info" />Info
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label class="radio">
                                            <input type="radio" name="toasts" value="warning" />Warning
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label class="radio">
                                            <input type="radio" name="toasts" value="error" />Error
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group" id="positionGroup">
                                        <label>Position</label>
                                    <div class="radio">
                                        <label >
                                            <input type="radio" name="positions" value="toast-top-right" checked />Top Right
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label >
                                            <input type="radio" name="positions" value="toast-bottom-right" />Bottom Right
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label >
                                            <input type="radio" name="positions" value="toast-bottom-left" />Bottom Left
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label >
                                            <input type="radio" name="positions" value="toast-top-left" />Top Left
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label >
                                            <input type="radio" name="positions" value="toast-top-full-width" />Top Full Width
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label >
                                            <input type="radio" name="positions" value="toast-bottom-full-width" />Bottom Full Width
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label >
                                            <input type="radio" name="positions" value="toast-top-center" />Top Center
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label >
                                            <input type="radio" name="positions" value="toast-bottom-center" />Bottom Center
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-2">
                                <div class="form-group">
                                    <label for="showEasing">Show Easing</label>
                                    <input id="showEasing" type="text" placeholder="swing, linear" class="form-control" value="swing"/>
                                </div>
                                <div class="form-group">

                                    <label for="hideEasing">Hide Easing</label>
                                    <input id="hideEasing" type="text" placeholder="swing, linear" class="form-control" value="linear"/>
                                </div>
                                <div class="form-group">

                                    <label for="showMethod">Show Method</label>
                                    <input id="showMethod" type="text" placeholder="show, fadeIn, slideDown" class="form-control" value="fadeIn"/>
                                </div>
                                <div class="form-group">

                                    <label for="hideMethod">Hide Method</label>
                                    <input id="hideMethod" type="text" placeholder="hide, fadeOut, slideUp" class="form-control" value="fadeOut"/>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="form-group">
                                        <label for="showDuration">Show Duration</label>
                                        <input id="showDuration" type="text" placeholder="ms" class="form-control" value="400" />
                                </div>
                                <div class="form-group">
                                        <label for="hideDuration">Hide Duration</label>
                                        <input id="hideDuration" type="text" placeholder="ms" class="form-control" value="1000" />
                                </div>
                                <div class="form-group">
                                        <label for="timeOut">Time out</label>
                                        <input id="timeOut" type="text" placeholder="ms" class="form-control" value="7000" />
                                </div>
                                <div class="form-group">
                                        <label for="extendedTimeOut">Extended time out</label>
                                        <input id="extendedTimeOut" type="text" placeholder="ms" class="form-control" value="1000" />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                            <button type="button" class="btn btn-primary" id="showtoast">Show Toast</button>
                            <button type="button" class="btn btn-white" id="cleartoasts">Clear Toasts</button>
                            <button type="button" class="btn btn-white" id="clearlasttoast">Clear Last Toast</button>
                            <button type="button" class="btn btn-white" id="showsimple">Show simple options</button>
                            </div>
                        </div>

                        <div class="row m-t-lg">
                            <div class="col-lg-12">
                            <small>Toastr Options in JSON</small>
                            <pre id="toastrOptions" class="p-m"></pre>
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

    <!-- Toastr script -->
    <script src="js/plugins/toastr/toastr.min.js"></script>

    <script type="text/javascript">
        $(function () """),format.raw/*609.23*/("""{"""),format.raw/*609.24*/("""
            """),format.raw/*610.13*/("""var i = -1;
            var toastCount = 0;
            var $toastlast;
            var getMessage = function () """),format.raw/*613.42*/("""{"""),format.raw/*613.43*/("""
                """),format.raw/*614.17*/("""var msg = 'Hi, welcome to Inspinia. This is example of Toastr notification box.';
                return msg;
            """),format.raw/*616.13*/("""}"""),format.raw/*616.14*/(""";

            $('#showsimple').click(function ()"""),format.raw/*618.47*/("""{"""),format.raw/*618.48*/("""
                """),format.raw/*619.17*/("""// Display a success toast, with a title
                toastr.success('Without any options','Simple notification!')
            """),format.raw/*621.13*/("""}"""),format.raw/*621.14*/(""");
            $('#showtoast').click(function () """),format.raw/*622.47*/("""{"""),format.raw/*622.48*/("""
                """),format.raw/*623.17*/("""var shortCutFunction = $("#toastTypeGroup input:radio:checked").val();
                var msg = $('#message').val();
                var title = $('#title').val() || '';
                var $showDuration = $('#showDuration');
                var $hideDuration = $('#hideDuration');
                var $timeOut = $('#timeOut');
                var $extendedTimeOut = $('#extendedTimeOut');
                var $showEasing = $('#showEasing');
                var $hideEasing = $('#hideEasing');
                var $showMethod = $('#showMethod');
                var $hideMethod = $('#hideMethod');
                var toastIndex = toastCount++;
                toastr.options = """),format.raw/*635.34*/("""{"""),format.raw/*635.35*/("""
                    """),format.raw/*636.21*/("""closeButton: $('#closeButton').prop('checked'),
                    debug: $('#debugInfo').prop('checked'),
                    progressBar: $('#progressBar').prop('checked'),
                    preventDuplicates: $('#preventDuplicates').prop('checked'),
                    positionClass: $('#positionGroup input:radio:checked').val() || 'toast-top-right',
                    onclick: null
                """),format.raw/*642.17*/("""}"""),format.raw/*642.18*/(""";
                if ($('#addBehaviorOnToastClick').prop('checked')) """),format.raw/*643.68*/("""{"""),format.raw/*643.69*/("""
                    """),format.raw/*644.21*/("""toastr.options.onclick = function () """),format.raw/*644.58*/("""{"""),format.raw/*644.59*/("""
                        """),format.raw/*645.25*/("""alert('You can perform some custom action after a toast goes away');
                    """),format.raw/*646.21*/("""}"""),format.raw/*646.22*/(""";
                """),format.raw/*647.17*/("""}"""),format.raw/*647.18*/("""
                """),format.raw/*648.17*/("""if ($showDuration.val().length) """),format.raw/*648.49*/("""{"""),format.raw/*648.50*/("""
                    """),format.raw/*649.21*/("""toastr.options.showDuration = $showDuration.val();
                """),format.raw/*650.17*/("""}"""),format.raw/*650.18*/("""
                """),format.raw/*651.17*/("""if ($hideDuration.val().length) """),format.raw/*651.49*/("""{"""),format.raw/*651.50*/("""
                    """),format.raw/*652.21*/("""toastr.options.hideDuration = $hideDuration.val();
                """),format.raw/*653.17*/("""}"""),format.raw/*653.18*/("""
                """),format.raw/*654.17*/("""if ($timeOut.val().length) """),format.raw/*654.44*/("""{"""),format.raw/*654.45*/("""
                    """),format.raw/*655.21*/("""toastr.options.timeOut = $timeOut.val();
                """),format.raw/*656.17*/("""}"""),format.raw/*656.18*/("""
                """),format.raw/*657.17*/("""if ($extendedTimeOut.val().length) """),format.raw/*657.52*/("""{"""),format.raw/*657.53*/("""
                    """),format.raw/*658.21*/("""toastr.options.extendedTimeOut = $extendedTimeOut.val();
                """),format.raw/*659.17*/("""}"""),format.raw/*659.18*/("""
                """),format.raw/*660.17*/("""if ($showEasing.val().length) """),format.raw/*660.47*/("""{"""),format.raw/*660.48*/("""
                    """),format.raw/*661.21*/("""toastr.options.showEasing = $showEasing.val();
                """),format.raw/*662.17*/("""}"""),format.raw/*662.18*/("""
                """),format.raw/*663.17*/("""if ($hideEasing.val().length) """),format.raw/*663.47*/("""{"""),format.raw/*663.48*/("""
                    """),format.raw/*664.21*/("""toastr.options.hideEasing = $hideEasing.val();
                """),format.raw/*665.17*/("""}"""),format.raw/*665.18*/("""
                """),format.raw/*666.17*/("""if ($showMethod.val().length) """),format.raw/*666.47*/("""{"""),format.raw/*666.48*/("""
                    """),format.raw/*667.21*/("""toastr.options.showMethod = $showMethod.val();
                """),format.raw/*668.17*/("""}"""),format.raw/*668.18*/("""
                """),format.raw/*669.17*/("""if ($hideMethod.val().length) """),format.raw/*669.47*/("""{"""),format.raw/*669.48*/("""
                    """),format.raw/*670.21*/("""toastr.options.hideMethod = $hideMethod.val();
                """),format.raw/*671.17*/("""}"""),format.raw/*671.18*/("""
                """),format.raw/*672.17*/("""if (!msg) """),format.raw/*672.27*/("""{"""),format.raw/*672.28*/("""
                    """),format.raw/*673.21*/("""msg = getMessage();
                """),format.raw/*674.17*/("""}"""),format.raw/*674.18*/("""
                """),format.raw/*675.17*/("""$("#toastrOptions").text("Command: toastr["
                        + shortCutFunction
                        + "](\""
                        + msg
                        + (title ? "\", \"" + title : '')
                        + "\")\n\ntoastr.options = "
                        + JSON.stringify(toastr.options, null, 2)
                );
                var $toast = toastr[shortCutFunction](msg, title); // Wire up an event handler to a button in the toast, if it exists
                $toastlast = $toast;
                if ($toast.find('#okBtn').length) """),format.raw/*685.51*/("""{"""),format.raw/*685.52*/("""
                    """),format.raw/*686.21*/("""$toast.delegate('#okBtn', 'click', function () """),format.raw/*686.68*/("""{"""),format.raw/*686.69*/("""
                        """),format.raw/*687.25*/("""alert('you clicked me. i was toast #' + toastIndex + '. goodbye!');
                        $toast.remove();
                    """),format.raw/*689.21*/("""}"""),format.raw/*689.22*/(""");
                """),format.raw/*690.17*/("""}"""),format.raw/*690.18*/("""
                """),format.raw/*691.17*/("""if ($toast.find('#surpriseBtn').length) """),format.raw/*691.57*/("""{"""),format.raw/*691.58*/("""
                    """),format.raw/*692.21*/("""$toast.delegate('#surpriseBtn', 'click', function () """),format.raw/*692.74*/("""{"""),format.raw/*692.75*/("""
                        """),format.raw/*693.25*/("""alert('Surprise! you clicked me. i was toast #' + toastIndex + '. You could perform an action here.');
                    """),format.raw/*694.21*/("""}"""),format.raw/*694.22*/(""");
                """),format.raw/*695.17*/("""}"""),format.raw/*695.18*/("""
            """),format.raw/*696.13*/("""}"""),format.raw/*696.14*/(""");
            function getLastToast()"""),format.raw/*697.36*/("""{"""),format.raw/*697.37*/("""
                """),format.raw/*698.17*/("""return $toastlast;
            """),format.raw/*699.13*/("""}"""),format.raw/*699.14*/("""
            """),format.raw/*700.13*/("""$('#clearlasttoast').click(function () """),format.raw/*700.52*/("""{"""),format.raw/*700.53*/("""
                """),format.raw/*701.17*/("""toastr.clear(getLastToast());
            """),format.raw/*702.13*/("""}"""),format.raw/*702.14*/(""");
            $('#cleartoasts').click(function () """),format.raw/*703.49*/("""{"""),format.raw/*703.50*/("""
                """),format.raw/*704.17*/("""toastr.clear();
            """),format.raw/*705.13*/("""}"""),format.raw/*705.14*/(""");
        """),format.raw/*706.9*/("""}"""),format.raw/*706.10*/(""")
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
object toastr_notifications extends toastr_notifications_Scope0.toastr_notifications
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:20 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/toastr_notifications.scala.html
                  HASH: ba9fa0e1df969facd306a0b3517b042ec08c87bc
                  MATRIX: 866->0|35651->34736|35681->34737|35724->34751|35869->34867|35899->34868|35946->34886|36099->35010|36129->35011|36209->35062|36239->35063|36286->35081|36447->35213|36477->35214|36556->35264|36586->35265|36633->35283|37353->35974|37383->35975|37434->35997|37878->36412|37908->36413|38007->36483|38037->36484|38088->36506|38154->36543|38184->36544|38239->36570|38358->36660|38388->36661|38436->36680|38466->36681|38513->36699|38574->36731|38604->36732|38655->36754|38752->36822|38782->36823|38829->36841|38890->36873|38920->36874|38971->36896|39068->36964|39098->36965|39145->36983|39201->37010|39231->37011|39282->37033|39369->37091|39399->37092|39446->37110|39510->37145|39540->37146|39591->37168|39694->37242|39724->37243|39771->37261|39830->37291|39860->37292|39911->37314|40004->37378|40034->37379|40081->37397|40140->37427|40170->37428|40221->37450|40314->37514|40344->37515|40391->37533|40450->37563|40480->37564|40531->37586|40624->37650|40654->37651|40701->37669|40760->37699|40790->37700|40841->37722|40934->37786|40964->37787|41011->37805|41050->37815|41080->37816|41131->37838|41197->37875|41227->37876|41274->37894|41880->38471|41910->38472|41961->38494|42037->38541|42067->38542|42122->38568|42282->38699|42312->38700|42361->38720|42391->38721|42438->38739|42507->38779|42537->38780|42588->38802|42670->38855|42700->38856|42755->38882|42908->39006|42938->39007|42987->39027|43017->39028|43060->39042|43090->39043|43158->39082|43188->39083|43235->39101|43296->39133|43326->39134|43369->39148|43437->39187|43467->39188|43514->39206|43586->39249|43616->39250|43697->39302|43727->39303|43774->39321|43832->39350|43862->39351|43902->39363|43932->39364
                  LINES: 32->1|641->609|641->609|642->610|645->613|645->613|646->614|648->616|648->616|650->618|650->618|651->619|653->621|653->621|654->622|654->622|655->623|667->635|667->635|668->636|674->642|674->642|675->643|675->643|676->644|676->644|676->644|677->645|678->646|678->646|679->647|679->647|680->648|680->648|680->648|681->649|682->650|682->650|683->651|683->651|683->651|684->652|685->653|685->653|686->654|686->654|686->654|687->655|688->656|688->656|689->657|689->657|689->657|690->658|691->659|691->659|692->660|692->660|692->660|693->661|694->662|694->662|695->663|695->663|695->663|696->664|697->665|697->665|698->666|698->666|698->666|699->667|700->668|700->668|701->669|701->669|701->669|702->670|703->671|703->671|704->672|704->672|704->672|705->673|706->674|706->674|707->675|717->685|717->685|718->686|718->686|718->686|719->687|721->689|721->689|722->690|722->690|723->691|723->691|723->691|724->692|724->692|724->692|725->693|726->694|726->694|727->695|727->695|728->696|728->696|729->697|729->697|730->698|731->699|731->699|732->700|732->700|732->700|733->701|734->702|734->702|735->703|735->703|736->704|737->705|737->705|738->706|738->706
                  -- GENERATED --
              */
          