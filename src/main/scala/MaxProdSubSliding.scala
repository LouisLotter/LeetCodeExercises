import scala.annotation.tailrec

object MaxProdSubSliding {

  def addIfMultiple(x: (Int, Int), list: List[(Int, Int)]): List[(Int, Int)] =
    if (x._1 >= x._2) {
      list
    } else {
      x :: list
    }

  def maxProduct(nums: Array[Int]): Int = {
    if (nums.isEmpty) return Integer.MIN_VALUE
    if (nums.length == 1) return nums.head

    @tailrec
    def iter(nums: Array[Int], todo: List[(Int, Int)], accumulator: Int): Int = {
      if (todo.isEmpty) {
        accumulator
      } else {
        val head = todo.head
        val ts = (head._1 + 1, head._2)
        val hs = (head._1, head._2 - 1)
        val tp = nums.slice(ts._1, ts._2 + 1).product
        val hp = nums.slice(hs._1, hs._2 + 1).product
        iter(
          nums,
          addIfMultiple(ts, addIfMultiple(hs, todo.tail)),
          Math.max(
            accumulator,
            Math.max(
              tp,
              hp)
          )
        )
      }
    }

    iter(nums, List((0, nums.length - 1)), nums.product)
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
