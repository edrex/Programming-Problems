import org.scalatest.FunSuite
import scala.math.sqrt

class Test03 extends FunSuite {
  val n = 600851475143L

  test("doesn't oom for moderate size") {
    val max = sqrt(n).toInt
    expect(Seq(2,3,5,7,11)) {
      solution_03.primes(12)
    }
  }
  test("solves problem") {
    val factors = solution_03.factors(n)
    println(factors)
    assert(factors.length > 1)
  }
}
