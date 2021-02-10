package org.jayawelch.algorithms

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SearchSpec extends AnyFlatSpec with Matchers {
  "binarySearch" should "report if the element is found or not" in {
    Search.binarySearch(1, Array(1,3,4)) shouldBe Some(0)
    Search.binarySearch(3, Array(1,3,4)) shouldBe Some(1)
    Search.binarySearch(4, Array(1,3,4)) shouldBe Some(2)
    Search.binarySearch(2, Array(1,3,4)) shouldBe Option.empty[Int]

    val random = new scala.util.Random
    val sortedArray = (0 until 10000).foldLeft(new Array[Int](10000)){(array, idx) => array(idx) = random.nextInt; array}.sorted
    val randomIdx = random.nextInt(10000)
    Search.binarySearch(sortedArray(randomIdx), sortedArray) shouldBe Some(randomIdx)

    val sortedVector = (0 until 10000).foldLeft(Vector.empty[Int])((vec, _) => vec.+:(random.nextInt)).sorted
    Search.binarySearch(sortedVector(randomIdx), sortedVector) shouldBe Some(randomIdx)
  }

}
