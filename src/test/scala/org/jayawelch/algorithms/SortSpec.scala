package org.jayawelch.algorithms

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.Random

class SortSpec extends AnyFlatSpec with Matchers{
  "mergeSort" should "sort a list" in {
    val random = new Random
    val randomList = (1 to 1000).foldLeft(List.empty[Int])((lst, _) => random.nextInt :: lst)
    Sort.mergeSort(randomList) shouldBe randomList.sorted
  }
}
