package org.jayawelch.hackerrank

import scala.annotation.tailrec
import scala.collection.immutable.TreeMap

object HackerRankSolutions {

  def rearrange(s: String, k: Int): String =
    arrange(
      s.toList
        .foldLeft(TreeMap.empty[Char, Int](Ordering[Char].reverse)) { (map, ch) =>
          map.get(ch).fold(map.+(ch -> 1))(l => map.+(ch -> (l + 1)))
        }.toList,
      k,
      ""
    )


  private def lookAhead(l: List[(Char, Int)]): Option[(Char, List[(Char, Int)])] =
    l match {
      case Nil => None

      case x :: xs if x._2 == 1 =>
        Some((x._1, xs))

      case x :: xs =>
        Some((x._1, (x._1, x._2 - 1) :: xs))
    }

  @tailrec
  private def arrange(l: List[(Char, Int)], k: Int, acc: String): String =
    l match {
      case Nil => acc

      case x :: xs if x._2 < k =>
        arrange(xs, k, acc + (x._1.toString * x._2))

      case x :: xs if xs.nonEmpty =>
        val chList = (x._1.toString * x._2).toList.sliding(k, k).toList
        val (rearranged, rest) = chList.take(chList.size - 1)
          .foldLeft((acc, xs)) { (tup, subList) =>
            lookAhead(tup._2).fold((tup._1, List.empty[(Char, Int)]))(ct => (tup._1 + subList.mkString + ct._1, ct._2))
          }
        if (rearranged.charAt(rearranged.length - 1) != chList.head.head)
          arrange(rest, k, rearranged + chList.drop(chList.size - 1).head.mkString)
        else
          arrange(rest, k, rearranged)

      case x :: _ =>
        acc + (x._1.toString * k)
    }

}
