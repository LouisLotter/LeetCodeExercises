import scala.annotation.tailrec

object MaxProdSub {
  def maxProduct(nums: Array[Int]): Int = {
    if (nums.isEmpty) return Integer.MIN_VALUE
    if (nums.length == 1) return nums.head
    @tailrec
    def iter(nums: Array[Int], offset: Int, len: Int, acc: Int): Int = {
      if (len == 0) {
        Math.max(acc, nums(offset))
      } else {
        if (offset + len <= nums.length) {
          val product = nums.slice(offset, offset + len).product
          iter(nums, offset + 1, len, Math.max(acc, product))
        } else iter(nums, 0, len - 1, acc)
      }
    }

    iter(nums, 0, nums.length, Integer.MIN_VALUE)
  }
}

//  def getOrderedBuggyContigousSubLists(nums: Array[Int]): List[Array[Int]] =
//    nums.foldLeft(List.empty[Array[Int]]) { (acc, n) =>
//      if (acc.isEmpty) {
//        List(Array(n))
//      } else {
//        if (acc.head.head + 1 == n) {
//          n +: acc.head :: acc.tail
//        } else {
//          Array(n) :: acc
//        }
//      }
//    }
