package controllers

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    val javaVersion = System.getProperty("java.version")
    Ok(views.html.index(javaVersion))
  }

}