
package views.html.template

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object tree_view_Scope0 {
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

class tree_view extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Tree view</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/plugins/jsTree/style.min.css" rel="stylesheet">

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
                    <li><a href="google_maps.html">Google maps</a></li>
                    <li><a href="code_editor.html">Code editor</a></li>
                    <li><a href="modal_window.html">Modal window</a></li>
                    <li><a href="forum_main.html">Forum view</a></li>
                    <li><a href="validation.html">Validation</a></li>
                    <li class="active"><a href="tree_view.html">Tree view</a></li>
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
        <h2>Tree view</h2>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">Home</a>
            </li>
            <li>
                """),
format.raw("""<a>Miscellaneous</a>
            </li>
            <li class="active">
                <strong>Tree view</strong>
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
                <div class="ibox-content">

                    <strong>jsTree</strong> is jquery plugin, that provides interactive trees. It is absolutely free, open source and distributed under the MIT license. jsTree is easily extendable, themable and configurable, it supports HTML & JSON data sources and AJAX loading.
                    Get more info on: <a href="http://www.jstree.com/" target="_blank">http://www.jstree.com/</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>Basic example <small>with custom Font Awesome icons.</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">

                    <div id="jstree1">
                        <ul>
                            <li class="jstree-open">Admin theme
                                <ul>
                                    <li>css
                                        <ul>
                                            <li data-jstree='"""),format.raw/*418.62*/("""{"""),format.raw/*418.63*/(""""type":"css""""),format.raw/*418.75*/("""}"""),format.raw/*418.76*/("""'>animate.css</li>
                                            <li data-jstree='"""),format.raw/*419.62*/("""{"""),format.raw/*419.63*/(""""type":"css""""),format.raw/*419.75*/("""}"""),format.raw/*419.76*/("""'>bootstrap.css</li>
                                            <li data-jstree='"""),format.raw/*420.62*/("""{"""),format.raw/*420.63*/(""""type":"css""""),format.raw/*420.75*/("""}"""),format.raw/*420.76*/("""'>style.css</li>
                                        </ul>
                                    </li>
                                    <li>email-templates
                                        <ul>
                                            <li data-jstree='"""),format.raw/*425.62*/("""{"""),format.raw/*425.63*/(""""type":"html""""),format.raw/*425.76*/("""}"""),format.raw/*425.77*/("""'>action.html</li>
                                            <li data-jstree='"""),format.raw/*426.62*/("""{"""),format.raw/*426.63*/(""""type":"html""""),format.raw/*426.76*/("""}"""),format.raw/*426.77*/("""'>alert.html</li>
                                            <li data-jstree='"""),format.raw/*427.62*/("""{"""),format.raw/*427.63*/(""""type":"html""""),format.raw/*427.76*/("""}"""),format.raw/*427.77*/("""'>billing.html</li>
                                        </ul>
                                    </li>
                                    <li>fonts
                                        <ul>
                                            <li data-jstree='"""),format.raw/*432.62*/("""{"""),format.raw/*432.63*/(""""type":"svg""""),format.raw/*432.75*/("""}"""),format.raw/*432.76*/("""'>glyphicons-halflings-regular.eot</li>
                                            <li data-jstree='"""),format.raw/*433.62*/("""{"""),format.raw/*433.63*/(""""type":"svg""""),format.raw/*433.75*/("""}"""),format.raw/*433.76*/("""'>glyphicons-halflings-regular.svg</li>
                                            <li data-jstree='"""),format.raw/*434.62*/("""{"""),format.raw/*434.63*/(""""type":"svg""""),format.raw/*434.75*/("""}"""),format.raw/*434.76*/("""'>glyphicons-halflings-regular.ttf</li>
                                            <li data-jstree='"""),format.raw/*435.62*/("""{"""),format.raw/*435.63*/(""""type":"svg""""),format.raw/*435.75*/("""}"""),format.raw/*435.76*/("""'>glyphicons-halflings-regular.woff</li>
                                        </ul>
                                    </li>
                                    <li class="jstree-open">img
                                        <ul>
                                            <li data-jstree='"""),format.raw/*440.62*/("""{"""),format.raw/*440.63*/(""""type":"img""""),format.raw/*440.75*/("""}"""),format.raw/*440.76*/("""'>profile_small.jpg</li>
                                            <li data-jstree='"""),format.raw/*441.62*/("""{"""),format.raw/*441.63*/(""""type":"img""""),format.raw/*441.75*/("""}"""),format.raw/*441.76*/("""'>angular_logo.png</li>
                                            <li class="text-navy" data-jstree='"""),format.raw/*442.80*/("""{"""),format.raw/*442.81*/(""""type":"img""""),format.raw/*442.93*/("""}"""),format.raw/*442.94*/("""'>html_logo.png</li>
                                            <li class="text-navy" data-jstree='"""),format.raw/*443.80*/("""{"""),format.raw/*443.81*/(""""type":"img""""),format.raw/*443.93*/("""}"""),format.raw/*443.94*/("""'>mvc_logo.png</li>
                                        </ul>
                                    </li>
                                    <li class="jstree-open">js
                                        <ul>
                                            <li data-jstree='"""),format.raw/*448.62*/("""{"""),format.raw/*448.63*/(""""type":"js""""),format.raw/*448.74*/("""}"""),format.raw/*448.75*/("""'>inspinia.js</li>
                                            <li data-jstree='"""),format.raw/*449.62*/("""{"""),format.raw/*449.63*/(""""type":"js""""),format.raw/*449.74*/("""}"""),format.raw/*449.75*/("""'>bootstrap.js</li>
                                            <li data-jstree='"""),format.raw/*450.62*/("""{"""),format.raw/*450.63*/(""""type":"js""""),format.raw/*450.74*/("""}"""),format.raw/*450.75*/("""'>jquery-2.1.1.js</li>
                                            <li data-jstree='"""),format.raw/*451.62*/("""{"""),format.raw/*451.63*/(""""type":"js""""),format.raw/*451.74*/("""}"""),format.raw/*451.75*/("""'>jquery-ui.custom.min.js</li>
                                            <li  class="text-navy" data-jstree='"""),format.raw/*452.81*/("""{"""),format.raw/*452.82*/(""""type":"js""""),format.raw/*452.93*/("""}"""),format.raw/*452.94*/("""'>jquery-ui-1.10.4.min.js</li>
                                        </ul>
                                    </li>
                                    <li data-jstree='"""),format.raw/*455.54*/("""{"""),format.raw/*455.55*/(""""type":"html""""),format.raw/*455.68*/("""}"""),format.raw/*455.69*/("""'> affix.html</li>
                                    <li data-jstree='"""),format.raw/*456.54*/("""{"""),format.raw/*456.55*/(""""type":"html""""),format.raw/*456.68*/("""}"""),format.raw/*456.69*/("""'> dashboard.html</li>
                                    <li data-jstree='"""),format.raw/*457.54*/("""{"""),format.raw/*457.55*/(""""type":"html""""),format.raw/*457.68*/("""}"""),format.raw/*457.69*/("""'> buttons.html</li>
                                    <li data-jstree='"""),format.raw/*458.54*/("""{"""),format.raw/*458.55*/(""""type":"html""""),format.raw/*458.68*/("""}"""),format.raw/*458.69*/("""'> calendar.html</li>
                                    <li data-jstree='"""),format.raw/*459.54*/("""{"""),format.raw/*459.55*/(""""type":"html""""),format.raw/*459.68*/("""}"""),format.raw/*459.69*/("""'> contacts.html</li>
                                    <li data-jstree='"""),format.raw/*460.54*/("""{"""),format.raw/*460.55*/(""""type":"html""""),format.raw/*460.68*/("""}"""),format.raw/*460.69*/("""'> css_animation.html</li>
                                    <li  class="text-navy" data-jstree='"""),format.raw/*461.73*/("""{"""),format.raw/*461.74*/(""""type":"html""""),format.raw/*461.87*/("""}"""),format.raw/*461.88*/("""'> flot_chart.html</li>
                                    <li  class="text-navy" data-jstree='"""),format.raw/*462.73*/("""{"""),format.raw/*462.74*/(""""type":"html""""),format.raw/*462.87*/("""}"""),format.raw/*462.88*/("""'> google_maps.html</li>
                                    <li data-jstree='"""),format.raw/*463.54*/("""{"""),format.raw/*463.55*/(""""type":"html""""),format.raw/*463.68*/("""}"""),format.raw/*463.69*/("""'> icons.html</li>
                                    <li data-jstree='"""),format.raw/*464.54*/("""{"""),format.raw/*464.55*/(""""type":"html""""),format.raw/*464.68*/("""}"""),format.raw/*464.69*/("""'> inboice.html</li>
                                    <li data-jstree='"""),format.raw/*465.54*/("""{"""),format.raw/*465.55*/(""""type":"html""""),format.raw/*465.68*/("""}"""),format.raw/*465.69*/("""'> login.html</li>
                                    <li data-jstree='"""),format.raw/*466.54*/("""{"""),format.raw/*466.55*/(""""type":"html""""),format.raw/*466.68*/("""}"""),format.raw/*466.69*/("""'> mailbox.html</li>
                                    <li data-jstree='"""),format.raw/*467.54*/("""{"""),format.raw/*467.55*/(""""type":"html""""),format.raw/*467.68*/("""}"""),format.raw/*467.69*/("""'> profile.html</li>
                                    <li  class="text-navy" data-jstree='"""),format.raw/*468.73*/("""{"""),format.raw/*468.74*/(""""type":"html""""),format.raw/*468.87*/("""}"""),format.raw/*468.88*/("""'> register.html</li>
                                    <li data-jstree='"""),format.raw/*469.54*/("""{"""),format.raw/*469.55*/(""""type":"html""""),format.raw/*469.68*/("""}"""),format.raw/*469.69*/("""'> timeline.html</li>
                                    <li data-jstree='"""),format.raw/*470.54*/("""{"""),format.raw/*470.55*/(""""type":"html""""),format.raw/*470.68*/("""}"""),format.raw/*470.69*/("""'> video.html</li>
                                    <li data-jstree='"""),format.raw/*471.54*/("""{"""),format.raw/*471.55*/(""""type":"html""""),format.raw/*471.68*/("""}"""),format.raw/*471.69*/("""'> widgets.html</li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>JSON example</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">

                    <div id="using_json"></div>

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

<script src="js/plugins/jsTree/jstree.min.js"></script>

<style>
    .jstree-open > .jstree-anchor > .fa-folder:before """),format.raw/*531.55*/("""{"""),format.raw/*531.56*/("""
        """),format.raw/*532.9*/("""content: "\f07c";
    """),format.raw/*533.5*/("""}"""),format.raw/*533.6*/("""

    """),format.raw/*535.5*/(""".jstree-default .jstree-icon.none """),format.raw/*535.39*/("""{"""),format.raw/*535.40*/("""
        """),format.raw/*536.9*/("""width: 0;
    """),format.raw/*537.5*/("""}"""),format.raw/*537.6*/("""
"""),format.raw/*538.1*/("""</style>

<script>
    $(document).ready(function()"""),format.raw/*541.33*/("""{"""),format.raw/*541.34*/("""

        """),format.raw/*543.9*/("""$('#jstree1').jstree("""),format.raw/*543.30*/("""{"""),format.raw/*543.31*/("""
            """),format.raw/*544.13*/("""'core' : """),format.raw/*544.22*/("""{"""),format.raw/*544.23*/("""
                """),format.raw/*545.17*/("""'check_callback' : true
            """),format.raw/*546.13*/("""}"""),format.raw/*546.14*/(""",
            'plugins' : [ 'types', 'dnd' ],
            'types' : """),format.raw/*548.23*/("""{"""),format.raw/*548.24*/("""
                """),format.raw/*549.17*/("""'default' : """),format.raw/*549.29*/("""{"""),format.raw/*549.30*/("""
                    """),format.raw/*550.21*/("""'icon' : 'fa fa-folder'
                """),format.raw/*551.17*/("""}"""),format.raw/*551.18*/(""",
                'html' : """),format.raw/*552.26*/("""{"""),format.raw/*552.27*/("""
                    """),format.raw/*553.21*/("""'icon' : 'fa fa-file-code-o'
                """),format.raw/*554.17*/("""}"""),format.raw/*554.18*/(""",
                'svg' : """),format.raw/*555.25*/("""{"""),format.raw/*555.26*/("""
                    """),format.raw/*556.21*/("""'icon' : 'fa fa-file-picture-o'
                """),format.raw/*557.17*/("""}"""),format.raw/*557.18*/(""",
                'css' : """),format.raw/*558.25*/("""{"""),format.raw/*558.26*/("""
                    """),format.raw/*559.21*/("""'icon' : 'fa fa-file-code-o'
                """),format.raw/*560.17*/("""}"""),format.raw/*560.18*/(""",
                'img' : """),format.raw/*561.25*/("""{"""),format.raw/*561.26*/("""
                    """),format.raw/*562.21*/("""'icon' : 'fa fa-file-image-o'
                """),format.raw/*563.17*/("""}"""),format.raw/*563.18*/(""",
                'js' : """),format.raw/*564.24*/("""{"""),format.raw/*564.25*/("""
                    """),format.raw/*565.21*/("""'icon' : 'fa fa-file-text-o'
                """),format.raw/*566.17*/("""}"""),format.raw/*566.18*/("""

            """),format.raw/*568.13*/("""}"""),format.raw/*568.14*/("""
        """),format.raw/*569.9*/("""}"""),format.raw/*569.10*/(""");

        $('#using_json').jstree("""),format.raw/*571.33*/("""{"""),format.raw/*571.34*/(""" """),format.raw/*571.35*/("""'core' : """),format.raw/*571.44*/("""{"""),format.raw/*571.45*/("""
            """),format.raw/*572.13*/("""'data' : [
                'Empty Folder',
                """),format.raw/*574.17*/("""{"""),format.raw/*574.18*/("""
                    """),format.raw/*575.21*/("""'text': 'Resources',
                    'state': """),format.raw/*576.30*/("""{"""),format.raw/*576.31*/("""
                        """),format.raw/*577.25*/("""'opened': true
                    """),format.raw/*578.21*/("""}"""),format.raw/*578.22*/(""",
                    'children': [
                        """),format.raw/*580.25*/("""{"""),format.raw/*580.26*/("""
                            """),format.raw/*581.29*/("""'text': 'css',
                            'children': [
                                """),format.raw/*583.33*/("""{"""),format.raw/*583.34*/("""
                                    """),format.raw/*584.37*/("""'text': 'animate.css', 'icon': 'none'
                                """),format.raw/*585.33*/("""}"""),format.raw/*585.34*/(""",
                                """),format.raw/*586.33*/("""{"""),format.raw/*586.34*/("""
                                    """),format.raw/*587.37*/("""'text': 'bootstrap.css', 'icon': 'none'
                                """),format.raw/*588.33*/("""}"""),format.raw/*588.34*/(""",
                                """),format.raw/*589.33*/("""{"""),format.raw/*589.34*/("""
                                    """),format.raw/*590.37*/("""'text': 'main.css', 'icon': 'none'
                                """),format.raw/*591.33*/("""}"""),format.raw/*591.34*/(""",
                                """),format.raw/*592.33*/("""{"""),format.raw/*592.34*/("""
                                    """),format.raw/*593.37*/("""'text': 'style.css', 'icon': 'none'
                                """),format.raw/*594.33*/("""}"""),format.raw/*594.34*/("""
                            """),format.raw/*595.29*/("""],
                            'state': """),format.raw/*596.38*/("""{"""),format.raw/*596.39*/("""
                                """),format.raw/*597.33*/("""'opened': true
                            """),format.raw/*598.29*/("""}"""),format.raw/*598.30*/("""
                        """),format.raw/*599.25*/("""}"""),format.raw/*599.26*/(""",
                        """),format.raw/*600.25*/("""{"""),format.raw/*600.26*/("""
                            """),format.raw/*601.29*/("""'text': 'js',
                            'children': [
                                """),format.raw/*603.33*/("""{"""),format.raw/*603.34*/("""
                                    """),format.raw/*604.37*/("""'text': 'bootstrap.js', 'icon': 'none'
                                """),format.raw/*605.33*/("""}"""),format.raw/*605.34*/(""",
                                """),format.raw/*606.33*/("""{"""),format.raw/*606.34*/("""
                                    """),format.raw/*607.37*/("""'text': 'inspinia.min.js', 'icon': 'none'
                                """),format.raw/*608.33*/("""}"""),format.raw/*608.34*/(""",
                                """),format.raw/*609.33*/("""{"""),format.raw/*609.34*/("""
                                    """),format.raw/*610.37*/("""'text': 'jquery.min.js', 'icon': 'none'
                                """),format.raw/*611.33*/("""}"""),format.raw/*611.34*/(""",
                                """),format.raw/*612.33*/("""{"""),format.raw/*612.34*/("""
                                    """),format.raw/*613.37*/("""'text': 'jsTree.min.js', 'icon': 'none'
                                """),format.raw/*614.33*/("""}"""),format.raw/*614.34*/(""",
                                """),format.raw/*615.33*/("""{"""),format.raw/*615.34*/("""
                                    """),format.raw/*616.37*/("""'text': 'custom.min.js', 'icon': 'none'
                                """),format.raw/*617.33*/("""}"""),format.raw/*617.34*/("""
                            """),format.raw/*618.29*/("""],
                            'state': """),format.raw/*619.38*/("""{"""),format.raw/*619.39*/("""
                                """),format.raw/*620.33*/("""'opened': true
                            """),format.raw/*621.29*/("""}"""),format.raw/*621.30*/("""
                        """),format.raw/*622.25*/("""}"""),format.raw/*622.26*/(""",
                        """),format.raw/*623.25*/("""{"""),format.raw/*623.26*/("""
                            """),format.raw/*624.29*/("""'text': 'html',
                            'children': [
                                """),format.raw/*626.33*/("""{"""),format.raw/*626.34*/("""
                                    """),format.raw/*627.37*/("""'text': 'layout.html', 'icon': 'none'
                                """),format.raw/*628.33*/("""}"""),format.raw/*628.34*/(""",
                                """),format.raw/*629.33*/("""{"""),format.raw/*629.34*/("""
                                    """),format.raw/*630.37*/("""'text': 'navigation.html', 'icon': 'none'
                                """),format.raw/*631.33*/("""}"""),format.raw/*631.34*/(""",
                                """),format.raw/*632.33*/("""{"""),format.raw/*632.34*/("""
                                    """),format.raw/*633.37*/("""'text': 'navbar.html', 'icon': 'none'
                                """),format.raw/*634.33*/("""}"""),format.raw/*634.34*/(""",
                                """),format.raw/*635.33*/("""{"""),format.raw/*635.34*/("""
                                    """),format.raw/*636.37*/("""'text': 'footer.html', 'icon': 'none'
                                """),format.raw/*637.33*/("""}"""),format.raw/*637.34*/(""",
                                """),format.raw/*638.33*/("""{"""),format.raw/*638.34*/("""
                                    """),format.raw/*639.37*/("""'text': 'sidebar.html', 'icon': 'none'
                                """),format.raw/*640.33*/("""}"""),format.raw/*640.34*/("""
                            """),format.raw/*641.29*/("""],
                            'state': """),format.raw/*642.38*/("""{"""),format.raw/*642.39*/("""
                                """),format.raw/*643.33*/("""'opened': true
                            """),format.raw/*644.29*/("""}"""),format.raw/*644.30*/("""
                        """),format.raw/*645.25*/("""}"""),format.raw/*645.26*/("""
                    """),format.raw/*646.21*/("""]
                """),format.raw/*647.17*/("""}"""),format.raw/*647.18*/(""",
                'Fonts',
                'Images',
                'Scripts',
                'Templates',
            ]
        """),format.raw/*653.9*/("""}"""),format.raw/*653.10*/(""" """),format.raw/*653.11*/("""}"""),format.raw/*653.12*/(""");

    """),format.raw/*655.5*/("""}"""),format.raw/*655.6*/(""");
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
object tree_view extends tree_view_Scope0.tree_view
              /*
                  -- GENERATED --
                  DATE: Sat Feb 20 04:10:20 CET 2016
                  SOURCE: /home/yachironi/git/myproject/app/views/template/tree_view.scala.html
                  HASH: 4436172cb0065958d28afa142d6eed025f529cc3
                  MATRIX: 844->0|22768->21875|22798->21876|22839->21888|22869->21889|22979->21970|23009->21971|23050->21983|23080->21984|23192->22067|23222->22068|23263->22080|23293->22081|23594->22353|23624->22354|23666->22367|23696->22368|23806->22449|23836->22450|23878->22463|23908->22464|24017->22544|24047->22545|24089->22558|24119->22559|24413->22824|24443->22825|24484->22837|24514->22838|24645->22940|24675->22941|24716->22953|24746->22954|24877->23056|24907->23057|24948->23069|24978->23070|25109->23172|25139->23173|25180->23185|25210->23186|25543->23490|25573->23491|25614->23503|25644->23504|25760->23591|25790->23592|25831->23604|25861->23605|25994->23709|26024->23710|26065->23722|26095->23723|26225->23824|26255->23825|26296->23837|26326->23838|26637->24120|26667->24121|26707->24132|26737->24133|26847->24214|26877->24215|26917->24226|26947->24227|27058->24309|27088->24310|27128->24321|27158->24322|27272->24407|27302->24408|27342->24419|27372->24420|27513->24532|27543->24533|27583->24544|27613->24545|27817->24720|27847->24721|27889->24734|27919->24735|28021->24808|28051->24809|28093->24822|28123->24823|28229->24900|28259->24901|28301->24914|28331->24915|28435->24990|28465->24991|28507->25004|28537->25005|28642->25081|28672->25082|28714->25095|28744->25096|28849->25172|28879->25173|28921->25186|28951->25187|29080->25287|29110->25288|29152->25301|29182->25302|29308->25399|29338->25400|29380->25413|29410->25414|29518->25493|29548->25494|29590->25507|29620->25508|29722->25581|29752->25582|29794->25595|29824->25596|29928->25671|29958->25672|30000->25685|30030->25686|30132->25759|30162->25760|30204->25773|30234->25774|30338->25849|30368->25850|30410->25863|30440->25864|30563->25958|30593->25959|30635->25972|30665->25973|30770->26049|30800->26050|30842->26063|30872->26064|30977->26140|31007->26141|31049->26154|31079->26155|31181->26228|31211->26229|31253->26242|31283->26243|32995->27926|33025->27927|33063->27937|33114->27960|33143->27961|33179->27969|33242->28003|33272->28004|33310->28014|33353->28029|33382->28030|33412->28032|33495->28086|33525->28087|33565->28099|33615->28120|33645->28121|33688->28135|33726->28144|33756->28145|33803->28163|33869->28200|33899->28201|33998->28271|34028->28272|34075->28290|34116->28302|34146->28303|34197->28325|34267->28366|34297->28367|34354->28395|34384->28396|34435->28418|34510->28464|34540->28465|34596->28492|34626->28493|34677->28515|34755->28564|34785->28565|34841->28592|34871->28593|34922->28615|34997->28661|35027->28662|35083->28689|35113->28690|35164->28712|35240->28759|35270->28760|35325->28786|35355->28787|35406->28809|35481->28855|35511->28856|35556->28872|35586->28873|35624->28883|35654->28884|35721->28922|35751->28923|35781->28924|35819->28933|35849->28934|35892->28948|35982->29009|36012->29010|36063->29032|36143->29083|36173->29084|36228->29110|36293->29146|36323->29147|36414->29209|36444->29210|36503->29240|36623->29331|36653->29332|36720->29370|36820->29441|36850->29442|36914->29477|36944->29478|37011->29516|37113->29589|37143->29590|37207->29625|37237->29626|37304->29664|37401->29732|37431->29733|37495->29768|37525->29769|37592->29807|37690->29876|37720->29877|37779->29907|37849->29948|37879->29949|37942->29983|38015->30027|38045->30028|38100->30054|38130->30055|38186->30082|38216->30083|38275->30113|38394->30203|38424->30204|38491->30242|38592->30314|38622->30315|38686->30350|38716->30351|38783->30389|38887->30464|38917->30465|38981->30500|39011->30501|39078->30539|39180->30612|39210->30613|39274->30648|39304->30649|39371->30687|39473->30760|39503->30761|39567->30796|39597->30797|39664->30835|39766->30908|39796->30909|39855->30939|39925->30980|39955->30981|40018->31015|40091->31059|40121->31060|40176->31086|40206->31087|40262->31114|40292->31115|40351->31145|40472->31237|40502->31238|40569->31276|40669->31347|40699->31348|40763->31383|40793->31384|40860->31422|40964->31497|40994->31498|41058->31533|41088->31534|41155->31572|41255->31643|41285->31644|41349->31679|41379->31680|41446->31718|41546->31789|41576->31790|41640->31825|41670->31826|41737->31864|41838->31936|41868->31937|41927->31967|41997->32008|42027->32009|42090->32043|42163->32087|42193->32088|42248->32114|42278->32115|42329->32137|42377->32156|42407->32157|42572->32294|42602->32295|42632->32296|42662->32297|42700->32307|42729->32308
                  LINES: 32->1|450->418|450->418|450->418|450->418|451->419|451->419|451->419|451->419|452->420|452->420|452->420|452->420|457->425|457->425|457->425|457->425|458->426|458->426|458->426|458->426|459->427|459->427|459->427|459->427|464->432|464->432|464->432|464->432|465->433|465->433|465->433|465->433|466->434|466->434|466->434|466->434|467->435|467->435|467->435|467->435|472->440|472->440|472->440|472->440|473->441|473->441|473->441|473->441|474->442|474->442|474->442|474->442|475->443|475->443|475->443|475->443|480->448|480->448|480->448|480->448|481->449|481->449|481->449|481->449|482->450|482->450|482->450|482->450|483->451|483->451|483->451|483->451|484->452|484->452|484->452|484->452|487->455|487->455|487->455|487->455|488->456|488->456|488->456|488->456|489->457|489->457|489->457|489->457|490->458|490->458|490->458|490->458|491->459|491->459|491->459|491->459|492->460|492->460|492->460|492->460|493->461|493->461|493->461|493->461|494->462|494->462|494->462|494->462|495->463|495->463|495->463|495->463|496->464|496->464|496->464|496->464|497->465|497->465|497->465|497->465|498->466|498->466|498->466|498->466|499->467|499->467|499->467|499->467|500->468|500->468|500->468|500->468|501->469|501->469|501->469|501->469|502->470|502->470|502->470|502->470|503->471|503->471|503->471|503->471|563->531|563->531|564->532|565->533|565->533|567->535|567->535|567->535|568->536|569->537|569->537|570->538|573->541|573->541|575->543|575->543|575->543|576->544|576->544|576->544|577->545|578->546|578->546|580->548|580->548|581->549|581->549|581->549|582->550|583->551|583->551|584->552|584->552|585->553|586->554|586->554|587->555|587->555|588->556|589->557|589->557|590->558|590->558|591->559|592->560|592->560|593->561|593->561|594->562|595->563|595->563|596->564|596->564|597->565|598->566|598->566|600->568|600->568|601->569|601->569|603->571|603->571|603->571|603->571|603->571|604->572|606->574|606->574|607->575|608->576|608->576|609->577|610->578|610->578|612->580|612->580|613->581|615->583|615->583|616->584|617->585|617->585|618->586|618->586|619->587|620->588|620->588|621->589|621->589|622->590|623->591|623->591|624->592|624->592|625->593|626->594|626->594|627->595|628->596|628->596|629->597|630->598|630->598|631->599|631->599|632->600|632->600|633->601|635->603|635->603|636->604|637->605|637->605|638->606|638->606|639->607|640->608|640->608|641->609|641->609|642->610|643->611|643->611|644->612|644->612|645->613|646->614|646->614|647->615|647->615|648->616|649->617|649->617|650->618|651->619|651->619|652->620|653->621|653->621|654->622|654->622|655->623|655->623|656->624|658->626|658->626|659->627|660->628|660->628|661->629|661->629|662->630|663->631|663->631|664->632|664->632|665->633|666->634|666->634|667->635|667->635|668->636|669->637|669->637|670->638|670->638|671->639|672->640|672->640|673->641|674->642|674->642|675->643|676->644|676->644|677->645|677->645|678->646|679->647|679->647|685->653|685->653|685->653|685->653|687->655|687->655
                  -- GENERATED --
              */
          