import scala.collection.mutable.ListBuffer
var ints = Iterator.from(2)
var primes = ListBuffer[Int]()

def next:Int = {
    ints.dropWhile(n => primes.exists(n % _ == 0))
    primes += ints.next
    primes.last
}

