import org.scalatest.FunSuite
import scala.math.sqrt

class Test04 extends FunSuite {
  test("is_palindrome") {
    Seq(1, 213312, 10101).foreach(n => assert(solution_04.is_palindrome(n)))
    Seq(12, 2102, 11101).foreach(n => assert(!solution_04.is_palindrome(n)))
  }
  test("solves problem") {
    expect(906609) {
      solution_04.find
    }
  }
}
