package org.jayawelch.codility

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CodilitySolutionsSpec extends AnyFlatSpec with Matchers {
  "countways" should "return 1 for 'aaa'" in {
    CodilitySolutions.waysTheSame("aaa", 'a') shouldBe 1
  }

  "countways" should "return 3 for 'bbbb'" in {
    CodilitySolutions.waysTheSame("bbbb", 'a') shouldBe 3
  }

  "countways" should "return 0 for 'aabbaa'" in {
    CodilitySolutions.waysTheSame("aabbaa", 'a') shouldBe 0
  }
}
