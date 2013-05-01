object problem_03 {
  def primes(nums:Iterator[Int]): Stream[Int] =
    nums.next #:: primes((nums.filter (x => x % nums.head != 0 )))

  def factors(n:BigInt, cands: Iterator[Int]): Iterator[Int] =
    cands.filter(i => n%i==0)

  import scala.math.sqrt
  //val n = 600851475143L
  val n = 6008475143L
  val r = factors(n, primes(Iterator.from(2)).takeWhile(i => i < sqrt(n).ceil))
  println(r.toList)
}

