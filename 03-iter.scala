
import scala.collection.mutable.ListBuffer

class PrimesIter extends Iterable[Int] {
    var primes = ListBuffer[Int]()
    var ints = Iterator.from(2)
    def iterator = new Iterator[Int] {
        def hasNext = true
        def next:Int = {
            ints = ints.dropWhile(n => primes.exists(n % _ == 0))
            primes += ints.next
            primes.last
        }
    }
}

class PrimesStream extends Iterable[Int] {
    var primes = ListBuffer[Int]()
    var ints = Iterator.from(2)
    def iterator = new Iterator[Int] {
        def hasNext = true
        def next:Int = {
            ints = ints.dropWhile(n => primes.exists(n % _ == 0))
            primes += ints.next
            primes.last
        }
    }
}

val p = new Primes
println(p.take(5))
//assert(p.take(5).toList == List(2,3,5,7,11))

object problem_03_iter {
  def primes(nums:Iterator[Int]): Iterator[Int] =
    nums.head #:: primes((nums tail) filter (x => x % nums.head != 0 ))

  def factors(n:BigInt, cands:Iterator[Int]): Iterator[Int] =
    cands.filter(i => n%i==0)

  import scala.math.sqrt
  //val n = 600851475143L
  val n = 6008475143L
  val r = factors(n, primes(Iterator.from(2)).takeWhile(i => i < sqrt(n).ceil))
  println(r.toList)
}


// vim: set ts=4 sw=4 et:
