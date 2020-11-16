package org.jayawelch.codility

object CodilitySolutions {
  def waysTheSame(s: String, ch: Char): Int = {
    def loop(seq: Seq[Char], cnt: Int, acc: Int): Int =
      if (cnt == seq.length)
        acc
      else {
        val cw = countWays(seq.drop(seq.length - cnt), ch, s.take(seq.length - cnt).count(_ == ch))
        println(s"For ${seq.drop(seq.length - cnt)} and ${s.take(seq.length - cnt)},${s.take(seq.length - cnt).count(_ == ch)} it is $cw")
        loop(seq,
          cnt + 1,
          acc + cw)
      }

    val strSeq = s.toSeq
    loop(strSeq, 2, 0)
  }

  private def countWays(s: Seq[Char], ch: Char, withSomething: Int): Int = {
    def f(n: Int, acc: Int): Int =
      if (n == 0)
        acc
      else {
        val cnt1 = s.take(s.length - n).count(_ == ch) == withSomething
        val cnt2 = s.drop(s.length - n).count(_ == ch) == withSomething
        f(n - 1, if (cnt1 && cnt2) acc + 1 else acc)
      }
    f(s.length - 1, 0)
  }

}