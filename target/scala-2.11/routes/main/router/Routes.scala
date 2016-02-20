
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/yachironi/git/myproject/conf/routes
// @DATE:Sat Feb 20 04:10:13 CET 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_6: controllers.Application,
  // @LINE:12
  Login_3: controllers.Login,
  // @LINE:21
  Tests_7: controllers.Tests,
  // @LINE:27
  Assets_5: controllers.Assets,
  // @LINE:41
  ClientController_4: controllers.ClientController,
  // @LINE:42
  ProjetController_1: controllers.ProjetController,
  // @LINE:45
  AdminController_0: controllers.AdminController,
  // @LINE:48
  DashboardController_2: controllers.DashboardController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_6: controllers.Application,
    // @LINE:12
    Login_3: controllers.Login,
    // @LINE:21
    Tests_7: controllers.Tests,
    // @LINE:27
    Assets_5: controllers.Assets,
    // @LINE:41
    ClientController_4: controllers.ClientController,
    // @LINE:42
    ProjetController_1: controllers.ProjetController,
    // @LINE:45
    AdminController_0: controllers.AdminController,
    // @LINE:48
    DashboardController_2: controllers.DashboardController
  ) = this(errorHandler, Application_6, Login_3, Tests_7, Assets_5, ClientController_4, ProjetController_1, AdminController_0, DashboardController_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_6, Login_3, Tests_7, Assets_5, ClientController_4, ProjetController_1, AdminController_0, DashboardController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """changeLanguage""", """controllers.Application.changeLanguage()"""),
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Login.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.Login.authenticate()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.Application.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tests""", """controllers.Tests.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tests""", """controllers.Tests.add()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/js/routes/""", """controllers.Application.javascriptRoutes()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """css/$file<.+>""", """controllers.Assets.versioned(path:String = "/public/css", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """font-awesome/$file<.+>""", """controllers.Assets.versioned(path:String = "/public/font-awesome", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """fonts/$file<.+>""", """controllers.Assets.versioned(path:String = "/public/fonts", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """img/$file<.+>""", """controllers.Assets.versioned(path:String = "/public/img", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """js/$file<.+>""", """controllers.Assets.versioned(path:String = "/public/js", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """LESS/$file<.+>""", """controllers.Assets.versioned(path:String = "/public/LESS", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """favicon.ico""", """controllers.Assets.at(path:String = "/public", file:String = "favicon.ico")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """taches""", """controllers.Tests.getAll()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addTask""", """controllers.Tests.addTask()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """client""", """controllers.ClientController.afficherClients"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """projet""", """controllers.ProjetController.afficherProjets"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """creerClient""", """controllers.ClientController.afficherCreerClient"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """creerProjet""", """controllers.ProjetController.afficherCreerProjet"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminClients""", """controllers.AdminController.afficherAdminClients"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminProjets""", """controllers.AdminController.afficherAdminProjets"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adminUtilisateur""", """controllers.AdminController.afficherAdminUtilisateur"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dashboard""", """controllers.DashboardController.afficherDashboard"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_changeLanguage0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("changeLanguage")))
  )
  private[this] lazy val controllers_Application_changeLanguage0_invoker = createInvoker(
    Application_6.changeLanguage(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "changeLanguage",
      Nil,
      "POST",
      """ i18n route""",
      this.prefix + """changeLanguage"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_index1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index1_invoker = createInvoker(
    Application_6.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Login_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Login_index2_invoker = createInvoker(
    Login_3.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Login",
      "index",
      Nil,
      "GET",
      """ Login page""",
      this.prefix + """login"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Login_authenticate3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_Login_authenticate3_invoker = createInvoker(
    Login_3.authenticate(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Login",
      "authenticate",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Application_logout4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_Application_logout4_invoker = createInvoker(
    Application_6.logout(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "logout",
      Nil,
      "GET",
      """""",
      this.prefix + """logout"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Tests_index5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tests")))
  )
  private[this] lazy val controllers_Tests_index5_invoker = createInvoker(
    Tests_7.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Tests",
      "index",
      Nil,
      "GET",
      """ Tests pages""",
      this.prefix + """tests"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Tests_add6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tests")))
  )
  private[this] lazy val controllers_Tests_add6_invoker = createInvoker(
    Tests_7.add(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Tests",
      "add",
      Nil,
      "POST",
      """""",
      this.prefix + """tests"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Application_javascriptRoutes7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/js/routes/")))
  )
  private[this] lazy val controllers_Application_javascriptRoutes7_invoker = createInvoker(
    Application_6.javascriptRoutes(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "javascriptRoutes",
      Nil,
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/js/routes/"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """assets/$file<.+>"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("css/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """css/$file<.+>"""
    )
  )

  // @LINE:29
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("font-awesome/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """font-awesome/$file<.+>"""
    )
  )

  // @LINE:30
  private[this] lazy val controllers_Assets_versioned11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("fonts/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned11_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """fonts/$file<.+>"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Assets_versioned12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned12_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """img/$file<.+>"""
    )
  )

  // @LINE:32
  private[this] lazy val controllers_Assets_versioned13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("js/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned13_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """js/$file<.+>"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_Assets_versioned14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("LESS/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned14_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """LESS/$file<.+>"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_Assets_at15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("favicon.ico")))
  )
  private[this] lazy val controllers_Assets_at15_invoker = createInvoker(
    Assets_5.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """favicon.ico"""
    )
  )

  // @LINE:37
  private[this] lazy val controllers_Tests_getAll16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("taches")))
  )
  private[this] lazy val controllers_Tests_getAll16_invoker = createInvoker(
    Tests_7.getAll(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Tests",
      "getAll",
      Nil,
      "GET",
      """ CRUD JSRoutes""",
      this.prefix + """taches"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_Tests_addTask17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addTask")))
  )
  private[this] lazy val controllers_Tests_addTask17_invoker = createInvoker(
    Tests_7.addTask(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Tests",
      "addTask",
      Nil,
      "POST",
      """""",
      this.prefix + """addTask"""
    )
  )

  // @LINE:41
  private[this] lazy val controllers_ClientController_afficherClients18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("client")))
  )
  private[this] lazy val controllers_ClientController_afficherClients18_invoker = createInvoker(
    ClientController_4.afficherClients,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClientController",
      "afficherClients",
      Nil,
      "GET",
      """View controller""",
      this.prefix + """client"""
    )
  )

  // @LINE:42
  private[this] lazy val controllers_ProjetController_afficherProjets19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("projet")))
  )
  private[this] lazy val controllers_ProjetController_afficherProjets19_invoker = createInvoker(
    ProjetController_1.afficherProjets,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjetController",
      "afficherProjets",
      Nil,
      "GET",
      """""",
      this.prefix + """projet"""
    )
  )

  // @LINE:43
  private[this] lazy val controllers_ClientController_afficherCreerClient20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("creerClient")))
  )
  private[this] lazy val controllers_ClientController_afficherCreerClient20_invoker = createInvoker(
    ClientController_4.afficherCreerClient,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ClientController",
      "afficherCreerClient",
      Nil,
      "GET",
      """""",
      this.prefix + """creerClient"""
    )
  )

  // @LINE:44
  private[this] lazy val controllers_ProjetController_afficherCreerProjet21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("creerProjet")))
  )
  private[this] lazy val controllers_ProjetController_afficherCreerProjet21_invoker = createInvoker(
    ProjetController_1.afficherCreerProjet,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProjetController",
      "afficherCreerProjet",
      Nil,
      "GET",
      """""",
      this.prefix + """creerProjet"""
    )
  )

  // @LINE:45
  private[this] lazy val controllers_AdminController_afficherAdminClients22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminClients")))
  )
  private[this] lazy val controllers_AdminController_afficherAdminClients22_invoker = createInvoker(
    AdminController_0.afficherAdminClients,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "afficherAdminClients",
      Nil,
      "GET",
      """""",
      this.prefix + """adminClients"""
    )
  )

  // @LINE:46
  private[this] lazy val controllers_AdminController_afficherAdminProjets23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminProjets")))
  )
  private[this] lazy val controllers_AdminController_afficherAdminProjets23_invoker = createInvoker(
    AdminController_0.afficherAdminProjets,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "afficherAdminProjets",
      Nil,
      "GET",
      """""",
      this.prefix + """adminProjets"""
    )
  )

  // @LINE:47
  private[this] lazy val controllers_AdminController_afficherAdminUtilisateur24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adminUtilisateur")))
  )
  private[this] lazy val controllers_AdminController_afficherAdminUtilisateur24_invoker = createInvoker(
    AdminController_0.afficherAdminUtilisateur,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "afficherAdminUtilisateur",
      Nil,
      "GET",
      """""",
      this.prefix + """adminUtilisateur"""
    )
  )

  // @LINE:48
  private[this] lazy val controllers_DashboardController_afficherDashboard25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dashboard")))
  )
  private[this] lazy val controllers_DashboardController_afficherDashboard25_invoker = createInvoker(
    DashboardController_2.afficherDashboard,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DashboardController",
      "afficherDashboard",
      Nil,
      "GET",
      """""",
      this.prefix + """dashboard"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_changeLanguage0_route(params) =>
      call { 
        controllers_Application_changeLanguage0_invoker.call(Application_6.changeLanguage())
      }
  
    // @LINE:9
    case controllers_Application_index1_route(params) =>
      call { 
        controllers_Application_index1_invoker.call(Application_6.index())
      }
  
    // @LINE:12
    case controllers_Login_index2_route(params) =>
      call { 
        controllers_Login_index2_invoker.call(Login_3.index())
      }
  
    // @LINE:13
    case controllers_Login_authenticate3_route(params) =>
      call { 
        controllers_Login_authenticate3_invoker.call(Login_3.authenticate())
      }
  
    // @LINE:14
    case controllers_Application_logout4_route(params) =>
      call { 
        controllers_Application_logout4_invoker.call(Application_6.logout())
      }
  
    // @LINE:21
    case controllers_Tests_index5_route(params) =>
      call { 
        controllers_Tests_index5_invoker.call(Tests_7.index())
      }
  
    // @LINE:22
    case controllers_Tests_add6_route(params) =>
      call { 
        controllers_Tests_add6_invoker.call(Tests_7.add())
      }
  
    // @LINE:25
    case controllers_Application_javascriptRoutes7_route(params) =>
      call { 
        controllers_Application_javascriptRoutes7_invoker.call(Application_6.javascriptRoutes())
      }
  
    // @LINE:27
    case controllers_Assets_versioned8_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:28
    case controllers_Assets_versioned9_route(params) =>
      call(Param[String]("path", Right("/public/css")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:29
    case controllers_Assets_versioned10_route(params) =>
      call(Param[String]("path", Right("/public/font-awesome")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:30
    case controllers_Assets_versioned11_route(params) =>
      call(Param[String]("path", Right("/public/fonts")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned11_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:31
    case controllers_Assets_versioned12_route(params) =>
      call(Param[String]("path", Right("/public/img")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned12_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:32
    case controllers_Assets_versioned13_route(params) =>
      call(Param[String]("path", Right("/public/js")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned13_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:33
    case controllers_Assets_versioned14_route(params) =>
      call(Param[String]("path", Right("/public/LESS")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned14_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:34
    case controllers_Assets_at15_route(params) =>
      call(Param[String]("path", Right("/public")), Param[String]("file", Right("favicon.ico"))) { (path, file) =>
        controllers_Assets_at15_invoker.call(Assets_5.at(path, file))
      }
  
    // @LINE:37
    case controllers_Tests_getAll16_route(params) =>
      call { 
        controllers_Tests_getAll16_invoker.call(Tests_7.getAll())
      }
  
    // @LINE:38
    case controllers_Tests_addTask17_route(params) =>
      call { 
        controllers_Tests_addTask17_invoker.call(Tests_7.addTask())
      }
  
    // @LINE:41
    case controllers_ClientController_afficherClients18_route(params) =>
      call { 
        controllers_ClientController_afficherClients18_invoker.call(ClientController_4.afficherClients)
      }
  
    // @LINE:42
    case controllers_ProjetController_afficherProjets19_route(params) =>
      call { 
        controllers_ProjetController_afficherProjets19_invoker.call(ProjetController_1.afficherProjets)
      }
  
    // @LINE:43
    case controllers_ClientController_afficherCreerClient20_route(params) =>
      call { 
        controllers_ClientController_afficherCreerClient20_invoker.call(ClientController_4.afficherCreerClient)
      }
  
    // @LINE:44
    case controllers_ProjetController_afficherCreerProjet21_route(params) =>
      call { 
        controllers_ProjetController_afficherCreerProjet21_invoker.call(ProjetController_1.afficherCreerProjet)
      }
  
    // @LINE:45
    case controllers_AdminController_afficherAdminClients22_route(params) =>
      call { 
        controllers_AdminController_afficherAdminClients22_invoker.call(AdminController_0.afficherAdminClients)
      }
  
    // @LINE:46
    case controllers_AdminController_afficherAdminProjets23_route(params) =>
      call { 
        controllers_AdminController_afficherAdminProjets23_invoker.call(AdminController_0.afficherAdminProjets)
      }
  
    // @LINE:47
    case controllers_AdminController_afficherAdminUtilisateur24_route(params) =>
      call { 
        controllers_AdminController_afficherAdminUtilisateur24_invoker.call(AdminController_0.afficherAdminUtilisateur)
      }
  
    // @LINE:48
    case controllers_DashboardController_afficherDashboard25_route(params) =>
      call { 
        controllers_DashboardController_afficherDashboard25_invoker.call(DashboardController_2.afficherDashboard)
      }
  }
}