package org.jayawelch

import org.jayawelch.hackerrank.HackerRankSolutions

object Assessment {
  def toBinary(i : Long) = {
    def loop(q: Long, remainders: List[Long]): String =
      if (q / 2 == 0) (q % 2 :: remainders).mkString
      else loop(q / 2, q % 2 :: remainders)

    loop(i, List.empty[Long])
  }

  def main(args: Array[String]): Unit = {
    println(toBinary(6))
  }
}
