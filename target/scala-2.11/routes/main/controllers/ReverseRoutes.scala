
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/yachironi/git/myproject/conf/routes
// @DATE:Sat Feb 20 04:10:13 CET 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:27
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def at(): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public"), ("file", "favicon.ico")))
      Call("GET", _prefix + { _defaultPrefix } + "favicon.ico")
    }
  
    // @LINE:27
    def versioned(path:String, file:Asset): Call = {
    
      (path: @unchecked, file: @unchecked) match {
      
        // @LINE:27
        case (path, file) if path == "/public" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
          Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
      
        // @LINE:28
        case (path, file) if path == "/public/css" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/css")))
          Call("GET", _prefix + { _defaultPrefix } + "css/" + implicitly[PathBindable[Asset]].unbind("file", file))
      
        // @LINE:29
        case (path, file) if path == "/public/font-awesome" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/font-awesome")))
          Call("GET", _prefix + { _defaultPrefix } + "font-awesome/" + implicitly[PathBindable[Asset]].unbind("file", file))
      
        // @LINE:30
        case (path, file) if path == "/public/fonts" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/fonts")))
          Call("GET", _prefix + { _defaultPrefix } + "fonts/" + implicitly[PathBindable[Asset]].unbind("file", file))
      
        // @LINE:31
        case (path, file) if path == "/public/img" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/img")))
          Call("GET", _prefix + { _defaultPrefix } + "img/" + implicitly[PathBindable[Asset]].unbind("file", file))
      
        // @LINE:32
        case (path, file) if path == "/public/js" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/js")))
          Call("GET", _prefix + { _defaultPrefix } + "js/" + implicitly[PathBindable[Asset]].unbind("file", file))
      
        // @LINE:33
        case (path, file) if path == "/public/LESS" =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public/LESS")))
          Call("GET", _prefix + { _defaultPrefix } + "LESS/" + implicitly[PathBindable[Asset]].unbind("file", file))
      
      }
    
    }
  
  }

  // @LINE:45
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def afficherAdminClients(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "adminClients")
    }
  
    // @LINE:47
    def afficherAdminUtilisateur(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "adminUtilisateur")
    }
  
    // @LINE:46
    def afficherAdminProjets(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "adminProjets")
    }
  
  }

  // @LINE:42
  class ReverseProjetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def afficherCreerProjet(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "creerProjet")
    }
  
    // @LINE:42
    def afficherProjets(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "projet")
    }
  
  }

  // @LINE:41
  class ReverseClientController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def afficherCreerClient(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "creerClient")
    }
  
    // @LINE:41
    def afficherClients(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "client")
    }
  
  }

  // @LINE:48
  class ReverseDashboardController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:48
    def afficherDashboard(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "dashboard")
    }
  
  }

  // @LINE:12
  class ReverseLogin(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:13
    def authenticate(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def logout(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:9
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:6
    def changeLanguage(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "changeLanguage")
    }
  
    // @LINE:25
    def javascriptRoutes(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "assets/js/routes/")
    }
  
  }

  // @LINE:21
  class ReverseTests(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def addTask(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "addTask")
    }
  
    // @LINE:37
    def getAll(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "taches")
    }
  
    // @LINE:22
    def add(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "tests")
    }
  
    // @LINE:21
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "tests")
    }
  
  }


}