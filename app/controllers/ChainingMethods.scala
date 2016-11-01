package controllers

import play.api.mvc.{Action, Controller}

class ChainingMethods extends Controller {
  def index() = Action {
    // BAD: chaining methods like this makes it hard to read and easy to miss something
    val bad = (1 to 100) map (x =>
      // logic could be on multiple lines
      x * x
        ) sum // sum could be on a different line making it even harder to spot

    // BETTER: when chaining is required make sure you use the full syntax, use indentation to make
    // steps more easy to spot but avoid chaining for complex logic if possible
    val better = (1 to 100)
        .map(x => x * x)
        .sum

    // GOOD: for more complex transformations use named functions and variables, add comments
    // between the different steps, make sure the names are meaningful
    def square(x: Int) = x * x
    // square root of all integers from 1 to 100
    val squared = (1 to 100).map(square)
    // sum of squared integers
    val good = squared.sum

    Ok(s"""{"bad": $bad, "better": $better, "good": $good}""")
  }
}
