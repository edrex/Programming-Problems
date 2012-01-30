import scala.collection.mutable.ListBuffer

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
    val max = sqrt(num.toFloat).toInt
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
