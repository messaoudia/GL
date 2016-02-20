
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object dashboard_5_Scope0 {
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

class dashboard_5 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Dashboard v.5</title>

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
                <li class="active">
                    <a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span> <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="index.html">Dashboard v.1</a></li>
                        <li><a href="dashboard_2.html">Dashboard v.2</a></li>
                        <li><a href="dashboard_3.html">Dashboard v.3</a></li>
                        <li><a href="dashboard_4_1.html">Dashboard v.4</a></li>
                        <li class="active"><a href="dashboard_5.html">Dashboard v.5 <span class="label label-primary pull-right">NEW</span></a></li>
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
                                    <span"""),
format.raw(""" class="pull-right text-muted small">4 minutes ago</span>
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

            <div class="wrapper wrapper-content animated fadeIn">

                <div class="p-w-md m-t-sm">
                    <div class="row">

                        <div class="col-sm-4">
                            <h1 class="m-b-xs">
                                26,900
                            </h1>
                            <small>
                                Sales in current month
                            </small>
                            <div id="sparkline1" class="m-b-sm"></div>
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
                        <div class="col-sm-4">
                            <h1 class="m-b-xs">
                                98,100
                            </h1>
                            <small>
                                Sales in last 24h
                            </small>
                            <div id="sparkline2" class="m-b-sm"></div>
                            <div class="row">
                                <div class="col-xs-4">
                                    <small class="stats-label">Pages / Visit</small>
                                    <h4>166 781.80</h4>
                                </div>

                                <div class="col-xs-4">
                                    <small class="stats-label">% New Visits</small>
                                    <h4>22.45%</h4>
                                </div>
                                <div class="col-xs-4">
                                    <small class="stats-label">Last week</small>
                                    <h4>862.044</h4>
                                </div>
                            </div>


                        </div>
                        <div class="col-sm-4">

                            <div class="row m-t-xs">
                                <div class="col-xs-6">
                                    <h5 class="m-b-xs">Income last month</h5>
                                    <h1 class="no-margins">160,000</h1>
                                    <div class="font-bold text-navy">98% <i class="fa fa-bolt"></i></div>
                                </div>
                                <div class="col-xs-6">
                                    <h5 class="m-b-xs">Sals current year</h5>
                                    <h1 class="no-margins">42,120</h1>
                                    <div class="font-bold text-navy">98% <i class="fa fa-bolt"></i></div>
                                </div>
                            </div>


                            <table class="table small m-t-sm">
                                <tbody>
                                <tr>
                                    <td>
                                        <strong>142</strong> Projects

                                    </td>
                                    <td>
                                        <strong>22</strong> Messages
                                    </td>

                                </tr>
                                <tr>
                                    <td>
                                        <strong>61</strong> Comments
                                    </td>
                                    <td>
                                        <strong>54</strong> Articles
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <strong>154</strong> Companies
                                    </td>
                                    <td>
                                        <strong>32</strong> Clients
                                    </td>
                                </tr>
                                </tbody>
                            </table>



                        </div>

                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="small pull-left col-md-3 m-l-lg m-t-md">
                                <strong>Sales char</strong> have evolved over the years sometimes.
                            </div>
                            <div class="small pull-right col-md-3 m-t-md text-right">
                                <strong>There are many</strong> variations of passages of Lorem Ipsum available, but the majority have suffered.
                            </div>
                            <div class="flot-chart m-b-xl">
                                <div class="flot-chart-content" id="flot-dashboard5-chart"></div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="ibox">



                                <div class="ibox-content">

                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label class="control-label" for="product_name">Project Name</label>
                                                <input type="text" id="product_name" name="product_name" value="" placeholder="Project Name" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-sm-2">
                                            <div class="form-group">
                                                <label class="control-label" for="price">Name</label>
                                                <input type="text" id="price" name="price" value="" placeholder="Name" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-sm-2">
                                            <div class="form-group">
                                                <label class="control-label" for="quantity">Company</label>
                                                <input type="text" id="quantity" name="quantity" value="" placeholder="Company" class="form-control">
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label class="control-label" for="status">Status</label>
                                                <select name="status" id="status" class="form-control">
                                                    <option value="1" selected="">Completed</option>
                                                    <option value="0">Pending</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="table-responsive">
                                        <table class="table table-striped">

                                            <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Master project</td>
                                                <td>Patrick Smith</td>
                                                <td>$892,074</td>
                                                <td>Inceptos Hymenaeos Ltd</td>
                                                <td><strong>20%</strong></td>
                                                <td>Jul 14, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Alpha project</td>
                                                <td>Alice Jackson</td>
                                                <td>$963,486</td>
                                                <td>Nec Euismod In Company</td>
                                                <td><strong>40%</strong></td>
                                                <td>Jul 16, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Betha project</td>
                                                <td>John Smith</td>
                                                <td>$996,824</td>
                                                <td>Erat Volutpat</td>
                                                <td><strong>75%</strong></td>
                                                <td>Jul 18, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Gamma project</td>
                                                <td>Anna Jordan</td>
                                                <td>$105,192</td>
                                                <td>Tellus Ltd</td>
                                                <td><strong>18%</strong></td>
                                                <td>Jul 22, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Alpha project</td>
                                                <td>Alice Jackson</td>
                                                <td>$674,803</td>
                                                <td>Nec Euismod In Company</td>
                                                <td><strong>40%</strong></td>
                                                <td>Jul 16, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>1</td>
                                                <td>Master project</td>
                                                <td>Patrick Smith</td>
                                                <td>$174,729</td>
                                                <td>Inceptos Hymenaeos Ltd</td>
                                                <td><strong>20%</strong></td>
                                                <td>Jul 14, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Gamma project</td>
                                                <td>Anna Jordan</td>
                                                <td>$823,198</td>
                                                <td>Tellus Ltd</td>
                                                <td><strong>18%</strong></td>
                                                <td>Jul 22, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>1</td>
                                                <td>Project <small>This is example of project</small></td>
                                                <td>Patrick Smith</td>
                                                <td>$778,696</td>
                                                <td>Inceptos Hymenaeos Ltd</td>
                                                <td><strong>20%</strong></td>
                                                <td>Jul 14, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Alpha project</td>
                                                <td>Alice Jackson</td>
                                                <td>$861,063</td>
                                                <td>Nec Euismod In Company</td>
                                                <td><strong>40%</strong></td>
                                                <td>Jul 16, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Betha project</td>
                                                <td>John Smith</td>
                                                <td>$109,125</td>
                                                <td>Erat Volutpat</td>
                                                <td><strong>75%</strong></td>
                                                <td>Jul 18, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Gamma project</td>
                                                <td>Anna Jordan</td>
                                                <td>$600,978</td>
                                                <td>Tellus Ltd</td>
                                                <td><strong>18%</strong></td>
                                                <td>Jul 22, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Alpha project</td>
                                                <td>Alice Jackson</td>
                                                <td>$150,161</td>
                                                <td>Nec Euismod In Company</td>
                                                <td><strong>40%</strong></td>
                                                <td>Jul 16, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>1</td>
                                                <td>Project <small>This is example of project</small></td>
                                                <td>Patrick Smith</td>
                                                <td>$160,586</td>
                                                <td>Inceptos Hymenaeos Ltd</td>
                                                <td><strong>20%</strong></td>
                                                <td>Jul 14, 2015</td>
                                                <td><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Gamma project</td>
                                                <td>Anna Jordan</td>
                                                <td>$110,612</td>
                                                <td>Tellus Ltd</td>
                                                <td><strong>18%</strong></td>
                                                <td>Jul 22, 2015</td>
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
                <strong>Copyright</strong> Example Company &copy;"""),
format.raw(""" 2014-2015
            </div>
        </div>
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
                                    </div>
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
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example">
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
                                    <input type="checkbox" name="collapsemenu" checked class="onoffswitch-checkbox" id="example2">
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
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example3">
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
                                    <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example4">
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
                                    <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox" id="example5">
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
                                    <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox" id="example6">
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
           """),
format.raw("""                         <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example7">
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

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Flot -->
    <script src="js/plugins/flot/jquery.flot.js"></script>
    <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="js/plugins/flot/jquery.flot.pie.js"></script>
    <script src="js/plugins/flot/jquery.flot.symbol.js"></script>
    <script src="js/plugins/flot/jquery.flot.time.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- Sparkline -->
    <script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>


    <script>
        $(document).ready(function() """),format.raw/*1100.38*/("""{"""),format.raw/*1100.39*/("""

            """),format.raw/*1102.13*/("""var sparklineCharts = function()"""),format.raw/*1102.45*/("""{"""),format.raw/*1102.46*/("""
                """),format.raw/*1103.17*/("""$("#sparkline1").sparkline([34, 43, 43, 35, 44, 32, 44, 52], """),format.raw/*1103.78*/("""{"""),format.raw/*1103.79*/("""
                    """),format.raw/*1104.21*/("""type: 'line',
                    width: '100%',
                    height: '50',
                    lineColor: '#1ab394',
                    fillColor: "transparent"
                """),format.raw/*1109.17*/("""}"""),format.raw/*1109.18*/(""");

                $("#sparkline2").sparkline([32, 11, 25, 37, 41, 32, 34, 42], """),format.raw/*1111.78*/("""{"""),format.raw/*1111.79*/("""
                    """),format.raw/*1112.21*/("""type: 'line',
                    width: '100%',
                    height: '50',
                    lineColor: '#1ab394',
                    fillColor: "transparent"
                """),format.raw/*1117.17*/("""}"""),format.raw/*1117.18*/(""");

                $("#sparkline3").sparkline([34, 22, 24, 41, 10, 18, 16,8], """),format.raw/*1119.76*/("""{"""),format.raw/*1119.77*/("""
                    """),format.raw/*1120.21*/("""type: 'line',
                    width: '100%',
                    height: '50',
                    lineColor: '#1C84C6',
                    fillColor: "transparent"
                """),format.raw/*1125.17*/("""}"""),format.raw/*1125.18*/(""");
            """),format.raw/*1126.13*/("""}"""),format.raw/*1126.14*/(""";

            var sparkResize;

            $(window).resize(function(e) """),format.raw/*1130.42*/("""{"""),format.raw/*1130.43*/("""
                """),format.raw/*1131.17*/("""clearTimeout(sparkResize);
                sparkResize = setTimeout(sparklineCharts, 500);
            """),format.raw/*1133.13*/("""}"""),format.raw/*1133.14*/(""");

            sparklineCharts();




            var data1 = [
                [0,4],[1,8],[2,5],[3,10],[4,4],[5,16],[6,5],[7,11],[8,6],[9,11],[10,20],[11,10],[12,13],[13,4],[14,7],[15,8],[16,12]
            ];
            var data2 = [
                [0,0],[1,2],[2,7],[3,4],[4,11],[5,4],[6,2],[7,5],[8,11],[9,5],[10,4],[11,1],[12,5],[13,2],[14,5],[15,2],[16,0]
            ];
            $("#flot-dashboard5-chart").length && $.plot($("#flot-dashboard5-chart"), [
                        data1,  data2
                    ],
                    """),format.raw/*1149.21*/("""{"""),format.raw/*1149.22*/("""
                        """),format.raw/*1150.25*/("""series: """),format.raw/*1150.33*/("""{"""),format.raw/*1150.34*/("""
                            """),format.raw/*1151.29*/("""lines: """),format.raw/*1151.36*/("""{"""),format.raw/*1151.37*/("""
                                """),format.raw/*1152.33*/("""show: false,
                                fill: true
                            """),format.raw/*1154.29*/("""}"""),format.raw/*1154.30*/(""",
                            splines: """),format.raw/*1155.38*/("""{"""),format.raw/*1155.39*/("""
                                """),format.raw/*1156.33*/("""show: true,
                                tension: 0.4,
                                lineWidth: 1,
                                fill: 0.4
                            """),format.raw/*1160.29*/("""}"""),format.raw/*1160.30*/(""",
                            points: """),format.raw/*1161.37*/("""{"""),format.raw/*1161.38*/("""
                                """),format.raw/*1162.33*/("""radius: 0,
                                show: true
                            """),format.raw/*1164.29*/("""}"""),format.raw/*1164.30*/(""",
                            shadowSize: 2
                        """),format.raw/*1166.25*/("""}"""),format.raw/*1166.26*/(""",
                        grid: """),format.raw/*1167.31*/("""{"""),format.raw/*1167.32*/("""
                            """),format.raw/*1168.29*/("""hoverable: true,
                            clickable: true,

                            borderWidth: 2,
                            color: 'transparent'
                        """),format.raw/*1173.25*/("""}"""),format.raw/*1173.26*/(""",
                        colors: ["#1ab394", "#1C84C6"],
                        xaxis:"""),format.raw/*1175.31*/("""{"""),format.raw/*1175.32*/("""
                        """),format.raw/*1176.25*/("""}"""),format.raw/*1176.26*/(""",
                        yaxis: """),format.raw/*1177.32*/("""{"""),format.raw/*1177.33*/("""
                        """),format.raw/*1178.25*/("""}"""),format.raw/*1178.26*/(""",
                        tooltip: false
                    """),format.raw/*1180.21*/("""}"""),format.raw/*1180.22*/("""
            """),format.raw/*1181.13*/(""");

        """),format.raw/*1183.9*/("""}"""),format.raw/*1183.10*/(""");
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
object dashboard_5 extends dashboard_5_Scope0.dashboard_5
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:18 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/dashboard_5.scala.html
                  HASH: 4452802666a295ea787fabf1b6bccb41b553da0f
                  MATRIX: 848->0|63228->62290|63259->62291|63305->62307|63367->62339|63398->62340|63446->62358|63537->62419|63568->62420|63620->62442|63841->62633|63872->62634|63985->62717|64016->62718|64068->62740|64289->62931|64320->62932|64431->63013|64462->63014|64514->63036|64735->63227|64766->63228|64812->63244|64843->63245|64951->63323|64982->63324|65030->63342|65165->63447|65196->63448|65792->64014|65823->64015|65879->64041|65917->64049|65948->64050|66008->64080|66045->64087|66076->64088|66140->64122|66256->64208|66287->64209|66357->64249|66388->64250|66452->64284|66660->64462|66691->64463|66760->64502|66791->64503|66855->64537|66969->64621|67000->64622|67100->64692|67131->64693|67194->64726|67225->64727|67285->64757|67500->64942|67531->64943|67651->65033|67682->65034|67738->65060|67769->65061|67833->65095|67864->65096|67920->65122|67951->65123|68044->65186|68075->65187|68119->65201|68162->65215|68193->65216
                  LINES: 32->1|1134->1100|1134->1100|1136->1102|1136->1102|1136->1102|1137->1103|1137->1103|1137->1103|1138->1104|1143->1109|1143->1109|1145->1111|1145->1111|1146->1112|1151->1117|1151->1117|1153->1119|1153->1119|1154->1120|1159->1125|1159->1125|1160->1126|1160->1126|1164->1130|1164->1130|1165->1131|1167->1133|1167->1133|1183->1149|1183->1149|1184->1150|1184->1150|1184->1150|1185->1151|1185->1151|1185->1151|1186->1152|1188->1154|1188->1154|1189->1155|1189->1155|1190->1156|1194->1160|1194->1160|1195->1161|1195->1161|1196->1162|1198->1164|1198->1164|1200->1166|1200->1166|1201->1167|1201->1167|1202->1168|1207->1173|1207->1173|1209->1175|1209->1175|1210->1176|1210->1176|1211->1177|1211->1177|1212->1178|1212->1178|1214->1180|1214->1180|1215->1181|1217->1183|1217->1183
                  -- GENERATED --
              */
          