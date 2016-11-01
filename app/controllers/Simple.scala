package controllers

import play.api.Logger
import play.api.mvc.{Action, Controller}

class Simple extends Controller {

  def index() = Action {
    Logger.debug("inside some controller action")
    Ok("{}")
  }
}
