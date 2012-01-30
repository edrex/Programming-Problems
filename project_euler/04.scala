
object solution_04 {
  def is_palindrome(n:Int): Boolean = {
    val s = n.toString
    s == s.reverse
  }

  def find: Int = {
    val ns = (999 to 1 by -1)
    val a = ns.map(i => ns.map(j => (i, j))).flatten.filter{case(i, j) => is_palindrome(i*j)}.sortWith{case ((a,b),(c,d)) => a*b>c*d}(0)
    println("Answer: %s (product of %s and %s) is the largest palindrome product of two 3 digit numbers".format(a._1*a._2, a._1, a._2)) 
    a._1*a._2
  }
    
}
