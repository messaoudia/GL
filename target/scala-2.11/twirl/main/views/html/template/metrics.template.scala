
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object metrics_Scope0 {
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

class metrics extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Dashboard v.2</title>

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
                <li class="active">
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
        <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
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
                                <div>
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
                                <div>
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
                                <div>
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
                                    <span class"""),
format.raw("""="pull-right text-muted small">4 minutes ago</span>
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
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5 class="m-b-md">Server status Q12</h5>
                                <h2 class="text-navy">
                                    <i class="fa fa-play fa-rotate-270"></i> Up
                                </h2>
                                <small>Last down 42 days ago</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content ">
                                <h5 class="m-b-md">Server status Q13</h5>
                                <h2 class="text-navy">
                                    <i class="fa fa-play fa-rotate-270"></i> Up
                                </h2>
                                <small>Last down 42 days ago</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5 class="m-b-md">Server status Q42</h5>
                                <h2 class="text-danger">
                                    <i class="fa fa-play fa-rotate-90"></i> Down
                                </h2>
                                <small>Server down since 4 days</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5 class="m-b-md">Server status Q43</h5>
                                <h2 class="text-danger">
                                    <i class="fa fa-play fa-rotate-90"></i> Down
                                </h2>
                                <small>Server down since 4:32 pm.</small>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Visits in last 24h</h5>
                                <h2>198 009</h2>
                                <div id="sparkline1"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Visits week</h5>
                                <h2>65 000</h2>
                                <div id="sparkline2"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Last month</h5>
                                <h2>680 900</h2>
                                <div id="sparkline3"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Avarage time</h5>
                                <h2>00:06:40</h2>
                                <div id="sparkline4"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Usage</h5>
                                <h2>65%</h2>
                                <div class="progress progress-mini">
                                    <div style="width: 68%;" class="progress-bar"></div>
                                </div>

                                <div class="m-t-sm small">Server down since 4:32 pm.</div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Usage</h5>
                                <h2>50%</h2>
                                <div class="progress progress-mini">
                                    <div style="width: 78%;" class="progress-bar"></div>
                                </div>

                                <div class="m-t-sm small">Server down since 4:32 pm.</div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Usage</h5>
                                <h2>14%</h2>
                                <div class="progress progress-mini">
                                    <div style="width: 38%;" class="progress-bar progress-bar-danger"></div>
                                </div>

                                <div class="m-t-sm small">Server down since 4:32 pm.</div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Usage</h5>
                                <h2>20%</h2>
                                <div class="progress progress-mini">
                                    <div style="width: 28%;" class="progress-bar progress-bar-danger"></div>
                                </div>

                                <div class="m-t-sm small">Server down since 4:32 pm.</div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Percentage distribution</h5>
                                <h2>42/20</h2>
                                <div class="text-center">
                                    <div id="sparkline5"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Percentage division</h5>
                                <h2>100/54</h2>
                                <div class="text-center">
                                    <div id="sparkline6"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Percentage distribution</h5>
                                <h2>685/211</h2>
                                <div class="text-center">
                                    <div id="sparkline7"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Percentage division</h5>
                                <h2>240/32</h2>
                                <div class="text-center">
                                    <div id="sparkline8"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Income</h5>
                                <h1 class="no-margins">886,200</h1>
                                <div class="stat-percent font-bold text-navy">98% <i class="fa fa-bolt"></i></div>
                                <small>Total income</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Income last month</h5>
                                <h1 class="no-margins">1 738,200</h1>
                                <div class="stat-percent font-bold text-navy">98% <i class="fa fa-bolt"></i></div>
                                <small>Total income</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Income last day</h5>
                                <h1 class="no-margins">-200,100</h1>
                                <div class="stat-percent font-bold text-danger">12% <i class="fa fa-level-down"></i></div>
                                <small>Total income</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Income all</h5>
                                <h1 class="no-margins">54,200</h1>
                                <div class="stat-percent font-bold text-danger">24% <i class="fa fa-level-down"></i></div>
                                <small>Total income</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>All new alerts</h5>
                                <table class="table table-stripped small m-t-md">
                                    <tbody>
                                    <tr>
                                        <td class="no-borders">
                                            <i class="fa fa-circle text-navy"></i>
                                        </td>
                                        <td  class="no-borders">
                                            Example element 1
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="fa fa-circle text-navy"></i>
                                        </td>
                                        <td>
                                            Example element 2
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="fa fa-circle text-navy"></i>
                                        </td>
                                        <td>
                                            Example element 3
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Alerts</h5>
                                <table class="table table-stripped small m-t-md">
                                    <tbody>
                                    <tr>
                                        <td class="no-borders">
                                            <i class="fa fa-circle text-navy"></i>
                                        </td>
                                        <td  class="no-borders">
                                            Example element 1
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="fa fa-circle text-navy"></i>
                                        </td>
                                        <td>
                                            Example element 2
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="fa fa-circle text-navy"></i>
                                        </td>
                                        <td>
                                            Example element 3
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>All messages</h5>
                                <table class="table table-stripped small m-t-md">
                                    <tbody>
                                    <tr>
                                        <td class="no-borders">
                                            <i class="fa fa-circle text-danger"></i>
                                        </td>
                                        <td  class="no-borders">
                                            Example element 1
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="fa fa-circle text-danger"></i>
                                        </td>
                                        <td>
                                            Example element 2
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="fa fa-circle text-danger"></i>
                                        </td>
                                        <td>
                                            Example element 3
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox">
                            <div class="ibox-content">
                                <h5>Last notification</h5>
                                <table class="table table-stripped small m-t-md">
                                    <tbody>
                                    <tr>
                                        <td class="no-borders">
                                            <i class="fa fa-circle text-danger"></i>
                                        </td>
                                        <td  class="no-borders">
                                            Example element 1
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="fa fa-circle text-danger"></i>
                                        </td>
                                        <td>
                                            Example element 2
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <i class="fa fa-circle text-danger"></i>
                                        </td>
                                        <td>
                                            Example element 3
                                        </td>
                                    </tr>
                                    </tbody>
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

    <!-- Sparkline -->
    <script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

    <!-- Peity -->
    <script src="js/plu"""),
format.raw("""gins/peity/jquery.peity.min.js"></script>
    <script src="js/demo/peity-demo.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <script>
        $(document).ready(function() """),format.raw/*769.38*/("""{"""),format.raw/*769.39*/("""

            """),format.raw/*771.13*/("""var sparklineCharts = function()"""),format.raw/*771.45*/("""{"""),format.raw/*771.46*/("""
                 """),format.raw/*772.18*/("""$("#sparkline1").sparkline([34, 43, 43, 35, 44, 32, 44, 52], """),format.raw/*772.79*/("""{"""),format.raw/*772.80*/("""
                     """),format.raw/*773.22*/("""type: 'line',
                     width: '100%',
                     height: '60',
                     lineColor: '#1ab394',
                     fillColor: "#ffffff"
                 """),format.raw/*778.18*/("""}"""),format.raw/*778.19*/(""");

                 $("#sparkline2").sparkline([24, 43, 43, 55, 44, 62, 44, 72], """),format.raw/*780.79*/("""{"""),format.raw/*780.80*/("""
                     """),format.raw/*781.22*/("""type: 'line',
                     width: '100%',
                     height: '60',
                     lineColor: '#1ab394',
                     fillColor: "#ffffff"
                 """),format.raw/*786.18*/("""}"""),format.raw/*786.19*/(""");

                 $("#sparkline3").sparkline([74, 43, 23, 55, 54, 32, 24, 12], """),format.raw/*788.79*/("""{"""),format.raw/*788.80*/("""
                     """),format.raw/*789.22*/("""type: 'line',
                     width: '100%',
                     height: '60',
                     lineColor: '#ed5565',
                     fillColor: "#ffffff"
                 """),format.raw/*794.18*/("""}"""),format.raw/*794.19*/(""");

                 $("#sparkline4").sparkline([24, 43, 33, 55, 64, 72, 44, 22], """),format.raw/*796.79*/("""{"""),format.raw/*796.80*/("""
                     """),format.raw/*797.22*/("""type: 'line',
                     width: '100%',
                     height: '60',
                     lineColor: '#ed5565',
                     fillColor: "#ffffff"
                 """),format.raw/*802.18*/("""}"""),format.raw/*802.19*/(""");

                 $("#sparkline5").sparkline([1, 4], """),format.raw/*804.53*/("""{"""),format.raw/*804.54*/("""
                     """),format.raw/*805.22*/("""type: 'pie',
                     height: '140',
                     sliceColors: ['#1ab394', '#F5F5F5']
                 """),format.raw/*808.18*/("""}"""),format.raw/*808.19*/(""");

                 $("#sparkline6").sparkline([5, 3], """),format.raw/*810.53*/("""{"""),format.raw/*810.54*/("""
                     """),format.raw/*811.22*/("""type: 'pie',
                     height: '140',
                     sliceColors: ['#1ab394', '#F5F5F5']
                 """),format.raw/*814.18*/("""}"""),format.raw/*814.19*/(""");

                 $("#sparkline7").sparkline([2, 2], """),format.raw/*816.53*/("""{"""),format.raw/*816.54*/("""
                     """),format.raw/*817.22*/("""type: 'pie',
                     height: '140',
                     sliceColors: ['#ed5565', '#F5F5F5']
                 """),format.raw/*820.18*/("""}"""),format.raw/*820.19*/(""");

                 $("#sparkline8").sparkline([2, 3], """),format.raw/*822.53*/("""{"""),format.raw/*822.54*/("""
                     """),format.raw/*823.22*/("""type: 'pie',
                     height: '140',
                     sliceColors: ['#ed5565', '#F5F5F5']
                 """),format.raw/*826.18*/("""}"""),format.raw/*826.19*/(""");
            """),format.raw/*827.13*/("""}"""),format.raw/*827.14*/(""";

            var sparkResize;

            $(window).resize(function(e) """),format.raw/*831.42*/("""{"""),format.raw/*831.43*/("""
                """),format.raw/*832.17*/("""clearTimeout(sparkResize);
                sparkResize = setTimeout(sparklineCharts, 500);
            """),format.raw/*834.13*/("""}"""),format.raw/*834.14*/(""");

            sparklineCharts();


        """),format.raw/*839.9*/("""}"""),format.raw/*839.10*/(""");
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
object metrics extends metrics_Scope0.metrics
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:19 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/metrics.scala.html
                  HASH: eb8fb39ea8723181fd555b3582d780a598cd4c11
                  MATRIX: 840->0|41202->40293|41232->40294|41277->40310|41338->40342|41368->40343|41416->40362|41506->40423|41536->40424|41588->40447|41809->40639|41839->40640|41952->40724|41982->40725|42034->40748|42255->40940|42285->40941|42398->41025|42428->41026|42480->41049|42701->41241|42731->41242|42844->41326|42874->41327|42926->41350|43147->41542|43177->41543|43264->41601|43294->41602|43346->41625|43501->41751|43531->41752|43618->41810|43648->41811|43700->41834|43855->41960|43885->41961|43972->42019|44002->42020|44054->42043|44209->42169|44239->42170|44326->42228|44356->42229|44408->42252|44563->42378|44593->42379|44638->42395|44668->42396|44775->42474|44805->42475|44852->42493|44986->42598|45016->42599|45094->42649|45124->42650
                  LINES: 32->1|802->769|802->769|804->771|804->771|804->771|805->772|805->772|805->772|806->773|811->778|811->778|813->780|813->780|814->781|819->786|819->786|821->788|821->788|822->789|827->794|827->794|829->796|829->796|830->797|835->802|835->802|837->804|837->804|838->805|841->808|841->808|843->810|843->810|844->811|847->814|847->814|849->816|849->816|850->817|853->820|853->820|855->822|855->822|856->823|859->826|859->826|860->827|860->827|864->831|864->831|865->832|867->834|867->834|872->839|872->839
                  -- GENERATED --
              */
          