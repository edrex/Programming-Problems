class Primes extends Iterable[Int] {
    import scala.collection.mutable.ListBuffer
    var primes = ListBuffer[Int]()
    var ints = Iterator.from(2)
    def iterator = new Iterator[Int] {
        def hasNext = true
        def next:Int = {
            ints.dropWhile(n => primes.exists(n % _ == 0))
            primes += ints.next
            primes.last
        }
    }
}

val p = new Primes
println(p.take(5))
//assert(p.take(5).toList == List(2,3,5,7,11))

