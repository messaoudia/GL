
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/yachironi/git/myproject/conf/routes
// @DATE:Sat Feb 20 04:10:13 CET 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
