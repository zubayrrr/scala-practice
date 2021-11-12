package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {
  // in order to run a recursive function the JVM; on top of which Scala runs,
  // uses a call stack to keep partial results that it can get back to computing the desired result
  // so each call of the recursive function uses stack frame

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }
  println(factorial(10))
  // the JVM keeps all the calls on its internal stack which has limited memory
  // if you did println(factorial(5000)), you'd get a StackOverflowError
  // it happens when the recursive depth is too big

  def anotherFactorial(n: Int): BigInt = {
    // add '@tailrec' annotation before the function to tell the compiler that the function is supposed to be TAIL RECURSIVE
    def facHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else facHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
    }
    facHelper(n, 1)

    /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    ...
    ...
    ...
    = factHelper(2, 3 * 4 ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 ... * 10)
    = 1 * 2 * 3 * 4 ... * 10

    */
  }
//  println {
//    anotherFactorial(5000)
//  }

  /*
  factHelper() is also a recursive function, the fact that its an auxiliary function doesn't really matter
  BUT the reason why it works and the factorial function doesn't it because
  We wrote factHelper as the last expression of its code path, this allows Scala to preserve the same stack frame and not use additional stack frames
  */

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
  1. Concatenate a string n times
  2. isPrime function tail recursive
  3. Fibonacci function, tail recursive
  */

  @tailrec
  def concStringTailRec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concStringTailRec(aString, n - 1, aString + accumulator)
  }
  println(concStringTailRec("hello", 3, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
      isPrimeTailRec(n / 2, isStillPrime = true)
  }
  println(isPrime(2003))
  println(isPrime(69))

  def fibo(n: Int): Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)
    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
    // however many recursive calls you've on the same code path, that's how many accumulators you need to have on a tail recursive functions
  }

  println(fibo(8))
}



