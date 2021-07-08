package org.jayawelch.hackerrank

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolutionsSpec extends AnyFlatSpec with Matchers {
  "Solutions" should "rearrange abababcczzzzz to zzczzczbbabaa" in {
    HackerRankSolutions.rearrange("abababcczzzzz", 2) should be ("zzczzczbbabaa")
  }

  "Solutions" should "rearrange azzzzz to zzazz" in {
    HackerRankSolutions.rearrange("azzzzz", 2) should be ("zzazz")
  }

  "Solutions" should "rearrange zzzzz to zz" in {
    HackerRankSolutions.rearrange("zzzzz", 2) should be ("zz")
  }
}
