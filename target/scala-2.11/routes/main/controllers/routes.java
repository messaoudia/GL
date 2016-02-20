
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/yachironi/git/myproject/conf/routes
// @DATE:Sat Feb 20 04:10:13 CET 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAdminController AdminController = new controllers.ReverseAdminController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseProjetController ProjetController = new controllers.ReverseProjetController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseClientController ClientController = new controllers.ReverseClientController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseDashboardController DashboardController = new controllers.ReverseDashboardController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLogin Login = new controllers.ReverseLogin(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTests Tests = new controllers.ReverseTests(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAdminController AdminController = new controllers.javascript.ReverseAdminController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseProjetController ProjetController = new controllers.javascript.ReverseProjetController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseClientController ClientController = new controllers.javascript.ReverseClientController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseDashboardController DashboardController = new controllers.javascript.ReverseDashboardController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLogin Login = new controllers.javascript.ReverseLogin(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTests Tests = new controllers.javascript.ReverseTests(RoutesPrefix.byNamePrefix());
  }

}
