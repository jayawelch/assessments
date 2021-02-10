package org.jayawelch.algorithms

object Search {
  def binarySearch[T : Ordering](item: T, a: IndexedSeq[T]): Option[Int] = {
    def go(low: Int, high: Int): Option[Int] =
      (high - low, (low + high) / 2) match {
        case (diff, _) if diff < 0 => Option.empty[Int]

        case (_, mid) if a(mid) == item => Option(mid)

        case (_, mid) if implicitly[Ordering[T]].lt(a(mid), item) => go(mid + 1, high)

        case _ => go(low, high - 1)
      }
    go(0, a.length - 1)
  }
}
