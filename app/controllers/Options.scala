package controllers

import play.api.mvc.{Action, Controller}

class Options extends Controller {

  def index(data: Option[String]) = Action {
    // BAD: when working with options don't just replace them with a default value as you may
    // need to check it again later on
    val lengthOfData: Int = if (data.isDefined) data.get.length else -1
    val bad: Int = if (lengthOfData > 0) lengthOfData else 0

    // GOOD: instead apply transformations on the option which gives you an other option
    // obtaining a default value later on is then really easy
    val lengthOfDataOpt: Option[Int] = data.map(_.length)
    val good: Int = lengthOfDataOpt.getOrElse(0)

    Ok(s"""{"bad": $bad, "good": $good}""")
  }
}
