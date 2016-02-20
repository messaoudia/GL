
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/yachironi/git/myproject/conf/routes
// @DATE:Sat Feb 20 04:10:13 CET 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:27
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "favicon.ico"})
        }
      """
    )
  
    // @LINE:27
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(path,file) {
        
          if (path == """ + implicitly[JavascriptLiteral[String]].to("/public") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
          }
        
          if (path == """ + implicitly[JavascriptLiteral[String]].to("/public/css") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "css/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
          }
        
          if (path == """ + implicitly[JavascriptLiteral[String]].to("/public/font-awesome") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "font-awesome/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
          }
        
          if (path == """ + implicitly[JavascriptLiteral[String]].to("/public/fonts") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "fonts/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
          }
        
          if (path == """ + implicitly[JavascriptLiteral[String]].to("/public/img") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "img/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
          }
        
          if (path == """ + implicitly[JavascriptLiteral[String]].to("/public/js") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "js/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
          }
        
          if (path == """ + implicitly[JavascriptLiteral[String]].to("/public/LESS") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "LESS/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
          }
        
        }
      """
    )
  
  }

  // @LINE:45
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def afficherAdminClients: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.afficherAdminClients",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminClients"})
        }
      """
    )
  
    // @LINE:47
    def afficherAdminUtilisateur: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.afficherAdminUtilisateur",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminUtilisateur"})
        }
      """
    )
  
    // @LINE:46
    def afficherAdminProjets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.afficherAdminProjets",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "adminProjets"})
        }
      """
    )
  
  }

  // @LINE:42
  class ReverseProjetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def afficherCreerProjet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjetController.afficherCreerProjet",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "creerProjet"})
        }
      """
    )
  
    // @LINE:42
    def afficherProjets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjetController.afficherProjets",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "projet"})
        }
      """
    )
  
  }

  // @LINE:41
  class ReverseClientController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def afficherCreerClient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClientController.afficherCreerClient",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "creerClient"})
        }
      """
    )
  
    // @LINE:41
    def afficherClients: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ClientController.afficherClients",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "client"})
        }
      """
    )
  
  }

  // @LINE:48
  class ReverseDashboardController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def afficherDashboard: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DashboardController.afficherDashboard",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dashboard"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseLogin(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Login.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:13
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Login.authenticate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:6
    def changeLanguage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.changeLanguage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "changeLanguage"})
        }
      """
    )
  
    // @LINE:25
    def javascriptRoutes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.javascriptRoutes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/js/routes/"})
        }
      """
    )
  
  }

  // @LINE:21
  class ReverseTests(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def addTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Tests.addTask",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addTask"})
        }
      """
    )
  
    // @LINE:37
    def getAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Tests.getAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "taches"})
        }
      """
    )
  
    // @LINE:22
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Tests.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tests"})
        }
      """
    )
  
    // @LINE:21
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Tests.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tests"})
        }
      """
    )
  
  }


}