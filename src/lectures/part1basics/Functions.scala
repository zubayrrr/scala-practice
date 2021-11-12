package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String =
    a + " " + b; // you can also move the expression to a code block (curly braces)

  println(aFunction("Hello", 3))
  // calling a func is also an expression
  // parameter-less functions can also be called just by their name

  def aParamLessFunc(): Int = 42
  println(aParamLessFunc()) // or
  println(aParamLessFunc) // compiler warns Empty-paren method accessed as parameterless

  def aRepeatedFunc(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunc(aString, n - 1) // function that calls it self, recursion
    // unlike other langs that use loops, we use recursive functions in Scala
  }

  println(aRepeatedFunc("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  // return type of functions, just like the compiler can infer the types of vars and vals so it can for functions
  // BUT a recursive function needs it's return(result) type defined, as best practice always define return type of functions

  // You can also define function's return type as Unit
  // a function that is only executing side effects
  def aFuncWithSideEffects(aString: String): Unit = println(aString)
  // We normally need functions with side effects if we want something that has nothing to do with computation itself,
  // like printing something to the console, logging, writing to a file etc


  // code blocks as implementations of functions
  // code blocks also allow you to define auxiliary functions inside

  def aBigFunc(n: Int): Int =  {
    def aSmallerFunc(a: Int, b: Int): Int = a + b
    aSmallerFunc(n, n - 1)
  }
/*
1. A greeting function(name, age) => "Hi, my name is $name and I am $age years old"
*/

  def greeting(name: String, age: Int): Unit = {
    println(s"Hi, my name is $name and I am $age years old")
  }

  greeting("Bruh", 22)

/*
2. Factorial function product of all numbers up to a given number that you pass in as a parameter; 1 * 2 * 3 * ... * n
*/

  def factorial(n: Int ): Int = {
    if (n == 0)
      1
    else
      n * factorial(n - 1)
  }

  println(factorial(4))

  /*
  3. A Fibonacci function
  */

  def fibo(n: Int): Int = {
    if (n == 1)
      1
    else if (n == 2)
      1
    else
      fibo(n - 1) + fibo(n - 2)
  }

  println(fibo(8))

/*
  4. Test if a number is a prime
*/

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int) : Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
}
