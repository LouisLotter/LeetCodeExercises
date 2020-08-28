import scala.annotation.tailrec

object LongestBinarySubArray {
  def longestSubarray(nums: Array[Int]): Int = {
    @tailrec
    def iter(nums: Array[Int], i: Int, count: Int, countSinceLastZero: Int, acc: Int, sawAZero: Boolean): Int = {
      if (nums.length == i) {
        if (!sawAZero) count - 1 else Math.max(acc, count)
      } else if (nums(i) == 1) {
        iter(nums, i + 1, count + 1, countSinceLastZero + 1, acc, sawAZero)
      } else if (nums(i) == 0 && countSinceLastZero > 0) {
        iter(nums, i + 1, countSinceLastZero, 0, Math.max(acc, count), true)
      } else {
        iter(nums, i + 1, 0, 0, Math.max(acc, count), true)
      }
    }
    iter(nums, 0, 0, 0, 0, false)
  }
}
