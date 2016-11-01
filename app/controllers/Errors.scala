package controllers

import play.api.mvc.{Action, Controller}

import scala.util.Try

class Errors extends Controller {

  def index() = Action {
    // BAD: avoid try catch blocks like in java, never use exceptions to handle business logic
    val bad = try {
      "Success"
    } catch {
      case _: Exception => "Failure"
    }

    // BETTER: use the scala try utility for exception handling yet again don't use
    // exceptions for business logic
    val better = Try("Success").getOrElse("Failure")

    // GOOD: use options for business logic
    val good = Some("Success").getOrElse("Failure")

    // Note: Try can be converted to option
    // Try("Success").toOption.getOrElse("Failure")

    Ok(s"""{"bad": $bad, "better": $better, "good": $good}""")
  }
}
