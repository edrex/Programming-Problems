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

object solution_03 {
  import scala.math.sqrt
  def primes(limit: Int) = {
    val composites = new Array[Boolean](limit)
    for { i <- 2 to sqrt(limit).toInt if (!composites(i))}
      (2*i until limit by i).foreach(composites(_) = true)
    for { i <- 2 until limit
      if (!composites(i))
    } yield i
  }

  def factors(num:BigInt): ListBuffer[Int] = {
    var fs = ListBuffer[Int]()
    val max = sqrt(num).toInt
    var rem = num
    for { p <- primes(max)} { 
      while (rem % p == 0)
      { 
        fs += p
        rem = rem/p 
        if (rem == 1) return fs
      }
    }

    return fs
  }
}
