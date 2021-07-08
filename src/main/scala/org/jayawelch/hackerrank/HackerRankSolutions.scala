package org.jayawelch.hackerrank

import scala.annotation.tailrec
import scala.collection.immutable.TreeMap

object HackerRankSolutions {

  def rearrange(s: String, k: Int): String = {
    val sorted = s.toSeq.sorted(Ordering[Char].reverse)
    sorted.subSequence(0, sorted.lastIndexOf(sorted(0))).toString.grouped(k)
    arrange(
      s.toSeq.sorted(Ordering[Char].reverse),
      k,
      ""
    )
  }



  @tailrec
  private def arrange(sorted: Seq[Char], k: Int, acc: String): String =
    if (sorted.isEmpty)
      acc
    else {
      val idx = sorted.lastIndexOf(sorted.head)
      if (idx < sorted.length) {
        val (work, rest) = sorted.splitAt(idx + 1)
        val grouped = work.grouped(k).toSeq
        val (ready, leftOver) = grouped.tail
          .foldLeft((acc ++ grouped.head.toString, rest)){(tuple2, seq) =>
            if (tuple2._2.nonEmpty)
              (tuple2._1 + tuple2._2.head.toString + seq.toString, tuple2._2.tail)
            else if (tuple2._1.last != seq.head)
              (tuple2._1 + seq.toString, tuple2._2)
            else
              (tuple2._1, tuple2._2)
          }
        arrange(leftOver, k, ready)
      } else {
        val (keep, _) = sorted.splitAt(if (k < sorted.length) k else sorted.length - 1)
        arrange("", k, acc + keep.toString)
      }

    }

}
