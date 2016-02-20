
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object css_animation_Scope0 {
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

class css_animation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | CSS Animations</title>

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
                <li class="active">
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
                                    <i class="fa fa-upload fa-fw"></i> Server Rebo"""),
format.raw("""oted
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
                    <h2>CSS Animations</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">Home</a>
                        </li>
                          <li class="active">
                            <strong>CSS Animations</strong>
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
                        <h5>CSS Animations <small>http://daneden.github.io/animate.css/</small></h5>
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
                    <div class="ibox-content text-center css-animation-box">
                        <h1 class="text-navy">
                            Animation.css
                        </h1>
                        <p>
                            A cross-browser library of CSS animations.  Animation.css is a bunch of cool, fun, and cross-browser animations for you to use in your projects. Great for emphasis, home pages, sliders, and general just-add-water-awesomeness.
                        </p>

                        <div class="hr-line-dashed"></div>

                        <div class="row">
                            <div class="col-sm-6 text-center">

                                <h4 class="m-b-lg">
                                    Example box for animation effect.
                                </h4>

                                <div id="animation_box" class="animated">
                                    <p class="animation-text-info">
                                        This is simple example of Rickshaw charts. You can use animation on any objects: text, charts, images, tables etc.
                                    </p>
                                    <div class="text-center wrapper-content animation-text-box">
                                        <h2>48%</h2>
                                        <p>Sales marketing</p>
                                    </div>
                                    <div id="rickshaw_multi" class="rickshaw_graph"></div>
                                </div>
                            </div>
                            <div class="col-lg-6 animation-efect-links text-center">
                                <h4 class="m-b-lg">
                                    Use any animation button to turn on the animation on box example.
                                </h4>

                                <!--<h5 class="text-navy">Attention Seekers</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="bounce">bounce</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="flash">flash</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="pulse">pulse</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rubberBand">rubberBand</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="shake">shake</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="swing">swing</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="tada">tada</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="wobble">wobble</a>


                                <!--<h5 class="text-navy">Bouncing Entrances</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceIn">bounceIn</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceInDown">bounceInDown</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceInLeft">bounceInLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceInRight">bounceInRight</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceInUp">bounceInUp</a>


                                <!--<h5 class="text-navy">Bouncing Exits</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceOut">bounceOut</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceOutDown">bounceOutDown</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceOutLeft">bounceOutLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceOutRight">bounceOutRight</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="bounceOutUp">bounceOutUp</a>
                                <!--<h5 class="text-navy">Fading Entrances</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeIn">fadeIn</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeInDown">fadeInDown</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeInDownBig">fadeInDownBig</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeInLeft">fadeInLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeInLeftBig">fadeInLeftBig</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeInRight">fadeInRight</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeInRightBig">fadeInRightBig</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeInUp">fadeInUp</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeInUpBig">fadeInUpBig</a>
                                <!--<h5 class="text-navy">Fading Exits</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOut">fadeOut</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOutDown">fadeOutDown</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOutDownBig">fadeOutDownBig</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOutLeft">fadeOutLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOutLeftBig">fadeOutLeftBig</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOutRight">fadeOutRight</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOutRightBig">fadeOutRightBig</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOutUp">fadeOutUp</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="fadeOutUpBig">fadeOutUpBig</a>
                                <!--<h5 class="text-navy">Flippers</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="flip">flip</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="flipInX">flipInX</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="flipInY">flipInY</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="flipOutX">flipOutX</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="flipOutY">flipOutY</a>

                                <!--<h5 class="text-navy">Lightspeed</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="lightSpeedIn">lightSpeedIn</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="lightSpeedOut">lightSpeedOut</a>
                                <!--<h5 class="text-navy">Rotating Entrances</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateIn">rotateIn</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateInDownLeft">rotateInDownLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateInDownRight">rotateInDownRight</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateInUpLeft">rotateInUpLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateInUpRight">rotateInUpRight</a>


                                <!--<h5 class="text-navy">Rotating Exits</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateOut">rotateOut</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateOutDownLeft">rotateOutDownLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateOutDownRight">rotateOutDownRight</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateOutUpLeft">rotateOutUpLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rotateOutUpRight">rotateOutUpRight</a>

                                <!--<h5 class="text-navy">Sliders</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="slideInDown">slideInDown</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="slideInLeft">slideInLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="slideInRight">slideInRight</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="slideOutLeft">slideOutLeft</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="slideOutRight">slideOutRight</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="slideOutUp">slideOutUp</a>
                                <!--<h5 class="text-navy">Specials</h5>-->
                                <a href="#" class="btn btn-white animation_select" data-animation="hinge">hinge</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rollIn">rollIn</a>
                                <a href="#" class="btn btn-white animation_select" data-animation="rollOut">rollOut</a>
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

    <!-- Peity -->
    <script src="js/plugins/peity/jquery.peity.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- Rickshaw -->
    <script src="js/plugins/rickshaw/vendor/d3.v3.js"></script>
    <script src="js/plugins/rickshaw/rickshaw.min.js"></script>


    <script>


        $(document).ready(function() """),format.raw/*560.38*/("""{"""),format.raw/*560.39*/("""
            """),format.raw/*561.13*/("""$('.animation_select').click( function()"""),format.raw/*561.53*/("""{"""),format.raw/*561.54*/("""
                """),format.raw/*562.17*/("""$('#animation_box').removeAttr('class').attr('class', '');
                var animation = $(this).attr("data-animation");
                $('#animation_box').addClass('animated');
                $('#animation_box').addClass(animation);
                return false;
            """),format.raw/*567.13*/("""}"""),format.raw/*567.14*/(""");

            var graph2 = new Rickshaw.Graph( """),format.raw/*569.46*/("""{"""),format.raw/*569.47*/("""
                """),format.raw/*570.17*/("""element: document.querySelector("#rickshaw_multi"),
                renderer: 'area',
                stroke: true,
                series: [ """),format.raw/*573.27*/("""{"""),format.raw/*573.28*/("""
                    """),format.raw/*574.21*/("""data: [ """),format.raw/*574.29*/("""{"""),format.raw/*574.30*/(""" """),format.raw/*574.31*/("""x: 0, y: 2 """),format.raw/*574.42*/("""}"""),format.raw/*574.43*/(""", """),format.raw/*574.45*/("""{"""),format.raw/*574.46*/(""" """),format.raw/*574.47*/("""x: 1, y: 5 """),format.raw/*574.58*/("""}"""),format.raw/*574.59*/(""", """),format.raw/*574.61*/("""{"""),format.raw/*574.62*/(""" """),format.raw/*574.63*/("""x: 2, y: 8 """),format.raw/*574.74*/("""}"""),format.raw/*574.75*/(""", """),format.raw/*574.77*/("""{"""),format.raw/*574.78*/(""" """),format.raw/*574.79*/("""x: 3, y: 4 """),format.raw/*574.90*/("""}"""),format.raw/*574.91*/(""", """),format.raw/*574.93*/("""{"""),format.raw/*574.94*/(""" """),format.raw/*574.95*/("""x: 4, y: 8 """),format.raw/*574.106*/("""}"""),format.raw/*574.107*/(""" """),format.raw/*574.108*/("""],
                    color: '#1ab394',
                    stroke: '#17997f'
                """),format.raw/*577.17*/("""}"""),format.raw/*577.18*/(""", """),format.raw/*577.20*/("""{"""),format.raw/*577.21*/("""
                    """),format.raw/*578.21*/("""data: [ """),format.raw/*578.29*/("""{"""),format.raw/*578.30*/(""" """),format.raw/*578.31*/("""x: 0, y: 13 """),format.raw/*578.43*/("""}"""),format.raw/*578.44*/(""", """),format.raw/*578.46*/("""{"""),format.raw/*578.47*/(""" """),format.raw/*578.48*/("""x: 1, y: 15 """),format.raw/*578.60*/("""}"""),format.raw/*578.61*/(""", """),format.raw/*578.63*/("""{"""),format.raw/*578.64*/(""" """),format.raw/*578.65*/("""x: 2, y: 17 """),format.raw/*578.77*/("""}"""),format.raw/*578.78*/(""", """),format.raw/*578.80*/("""{"""),format.raw/*578.81*/(""" """),format.raw/*578.82*/("""x: 3, y: 12 """),format.raw/*578.94*/("""}"""),format.raw/*578.95*/(""", """),format.raw/*578.97*/("""{"""),format.raw/*578.98*/(""" """),format.raw/*578.99*/("""x: 4, y: 10 """),format.raw/*578.111*/("""}"""),format.raw/*578.112*/(""" """),format.raw/*578.113*/("""],
                    color: '#eeeeee',
                    stroke: '#d7d7d7'
                """),format.raw/*581.17*/("""}"""),format.raw/*581.18*/(""" """),format.raw/*581.19*/("""]
            """),format.raw/*582.13*/("""}"""),format.raw/*582.14*/(""" """),format.raw/*582.15*/(""");
            graph2.renderer.unstack = true;
            graph2.render();
        """),format.raw/*585.9*/("""}"""),format.raw/*585.10*/(""");
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
object css_animation extends css_animation_Scope0.css_animation
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:19 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/css_animation.scala.html
                  HASH: 50395e7e9f27b90a0c05f0e3f75dfc1ff2447e96
                  MATRIX: 852->0|35672->34771|35702->34772|35745->34786|35814->34826|35844->34827|35891->34845|36205->35130|36235->35131|36315->35182|36345->35183|36392->35201|36566->35346|36596->35347|36647->35369|36684->35377|36714->35378|36744->35379|36784->35390|36814->35391|36845->35393|36875->35394|36905->35395|36945->35406|36975->35407|37006->35409|37036->35410|37066->35411|37106->35422|37136->35423|37167->35425|37197->35426|37227->35427|37267->35438|37297->35439|37328->35441|37358->35442|37388->35443|37429->35454|37460->35455|37491->35456|37618->35554|37648->35555|37679->35557|37709->35558|37760->35580|37797->35588|37827->35589|37857->35590|37898->35602|37928->35603|37959->35605|37989->35606|38019->35607|38060->35619|38090->35620|38121->35622|38151->35623|38181->35624|38222->35636|38252->35637|38283->35639|38313->35640|38343->35641|38384->35653|38414->35654|38445->35656|38475->35657|38505->35658|38547->35670|38578->35671|38609->35672|38736->35770|38766->35771|38796->35772|38840->35787|38870->35788|38900->35789|39015->35876|39045->35877
                  LINES: 32->1|592->560|592->560|593->561|593->561|593->561|594->562|599->567|599->567|601->569|601->569|602->570|605->573|605->573|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|606->574|609->577|609->577|609->577|609->577|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|610->578|613->581|613->581|613->581|614->582|614->582|614->582|617->585|617->585
                  -- GENERATED --
              */
          