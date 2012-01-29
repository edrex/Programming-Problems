import org.scalatest.FunSuite

class Test03 extends FunSuite {

  test("yields first few primes") {
    val primes = new PrimesIter
    expect(List(2,3,5,7,11)) {
      primes.take(5).toList
    }
  }
  test("doesn't oom for moderate size") {
    import scala.math.sqrt
    val max = sqrt(600851475143L).ceil
    val primes = new PrimesIter
    println(primes.takeWhile(_ < max).toList.length)
    assert(true)
  }
    
}
