object Medians {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val a = (nums1 ++ nums2).sortWith(_ < _)
    if (a.length == 0) {
      0
    } else if (a.length == 1) {
      a(0)
    } else if (a.length % 2 == 0) {
      val midWay = a.length / 2
      (a(midWay - 1) + a(midWay)) / 2.0
    } else {
      val midWay = (a.length - 1) / 2
      a(midWay)
    }
  }
}
