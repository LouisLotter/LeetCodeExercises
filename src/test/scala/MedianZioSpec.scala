import zio.test.Assertion._
import zio.test._


object MedianZioSpec extends DefaultRunnableSpec {


  def spec: Spec[_root_.zio.test.environment.TestEnvironment, TestFailure[Nothing], TestSuccess] =
    suite("HelloWorldSpec")(
      //    testM("sayHello correctly displays output") {
      //      for {
      //        _ <- sayHello
      //        output <- TestConsole.output
      //      } yield assert(output)(equalTo(Vector("Hello, World!\n")))
      //    },

      testM(" test associativity") {
        check(Gen.anyInt, Gen.anyInt, Gen.anyInt) { (x, y, z) =>
          assert((x + y) + z)(equalTo(x + (y + z)))
        }
      },

      testM(" test Median Properties") {
        check(
          Gen.listOfBounded(1, 1000)(Gen.int(0, Integer.MAX_VALUE / 2 - 1)),
          Gen.listOfBounded(1, 1000)(Gen.int(0, Integer.MAX_VALUE / 2 - 1))
        ) { (xs, ys) =>
          val min: Int = Math.min(xs.min, ys.min)
          val max: Int = Math.max(xs.max, ys.max)
          val median: Double = Medians.findMedianSortedArrays(xs.sortWith(_ < _).toArray, ys.sortWith(_ < _).toArray)
          assert(median)(isGreaterThanEqualTo(min.toDouble)) &&
            assert(median)(isLessThanEqualTo(max.toDouble))
        }
      }

    )
}