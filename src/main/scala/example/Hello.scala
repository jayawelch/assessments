package example

import org.jayawelch.hackerrank.HackerRankSolutions

object Hello extends Greeting with App {
  println(greeting)
  println(HackerRankSolutions.rearrange("aaazzdbcaazzzzzzzzzzzzzzzz", 2))
}

trait Greeting {
  lazy val greeting: String = "hello"
}
