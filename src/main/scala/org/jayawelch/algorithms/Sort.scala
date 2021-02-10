package org.jayawelch.algorithms


object Sort {
  def mergeSort[T : Ordering](xs: List[T]): List[T] = {

    def merge(xs1: List[T], xs2: List[T]): List[T] =
      (xs1, xs2) match {
        case (Nil, yss) => yss
        case (xss, Nil) => xss
        case (x :: xss, y :: _) if implicitly[Ordering[T]].lt(x , y) => x :: merge(xss, xs2)
        case (_, y :: yss) => y :: merge(xs1, yss)
      }
    val n = xs.length / 2
    if (n == 0)
      xs
    else {
      val (xss, yss) = xs splitAt n
      merge(mergeSort(xss), mergeSort(yss))
    }
  }
}
