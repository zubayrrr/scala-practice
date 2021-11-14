package lectures.part1basics
// Call by Name & Call by Value
object CBNvsCBV extends App{
  //

  def calledByValue(x: Long): Unit = {
    // choosing Long because the time functions in JVM return Long(s)
    // exact value of the expression is computed before the function evaluates. hence, same value is printed the second time as well
    // the computed time will be used throughout the function def
    println("By value: " + x)
    println("By value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    // => tells the compiler that the parameter will be called by Name
    // in contrast to by value call, the expression System.nanotime() is passed literally as is, the expression is evaluated everytime
    // useful in lazy strings
    println("By name: " + x)
    println("By name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x) // the by name parameter delays the evaluation of the expression until its used

  // printFirst(infinite(), 34) would crash as StackOverflowError
  printFirst(34, infinite()) // infinite() is never actually evaluated in this case

}
