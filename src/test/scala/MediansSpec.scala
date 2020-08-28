import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should



class MediansSpec extends AnyFlatSpec with should.Matchers {

  //
  //  Example 1:
  //
  //  Input: nums1 = [1,3], nums2 = [2]
  //  Output: 2.00000
  //  Explanation: merged array = [1,2,3] and median is 2.
  //  Example 2:
  //
  //  Input: nums1 = [1,2], nums2 = [3,4]
  //  Output: 2.50000
  //  Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
  //    Example 3:1
  //1
  //  Input: nums1 = [10,0], nums2 = [0,0]
  //  Output: 0.00000
  //  Example 4:
  //
  //  Input: nums1 = [], nums2 = [1]
  //  Output: 1.00000
  //  Example 5:
  //
  //  Input: nums1 = [2], nums2 = []
  //  Output: 2.00000


  "a" should "b" in  {
    val median = Medians.findMedianSortedArrays(Array(2), Array.emptyIntArray)
    assert(median == 2.0)
  }
  "c" should "d" in  {
    val median = Medians.findMedianSortedArrays(Array.emptyIntArray, Array(1))
    assert(median == 1.0)
  }
  "e" should "f" in  {
    val median = Medians.findMedianSortedArrays(Array(1, 2), Array(3, 4))
    assert(median == 2.5)
  }
  "g" should "h" in  {
    val median = Medians.findMedianSortedArrays(Array(1, 3), Array(2))
    assert(median == 2)
  }


}
