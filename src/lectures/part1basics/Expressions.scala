package lectures.part1basics

object Expressions extends App{
  val x = 1 + 2 // Expression, the type of this expression is auto determined
  println(x)

  // math expressions that get evaluated to something
  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  // relational operators
  println(1 == x) // it will evaluate to a boolean value
  // == != > >= < <=

  // boolean operators for logic
  println(!(1 == x)) // logical negation ! is a unary operator
  // ! && || binary

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ...side effects
   // these operators only with variables

  // statement(instructions)[DO] vs expressions [VALUE]

  // an instruction is something that you tell the computer to do, in imperative languages you work with instructions
  // an expression is something that has a value, every single bit of your program will evaluate a value

  // if expression

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue) // unlike other languages if expression evaluates to value in the expression not to a boolean
  // if in other languages is a statement not an expression

  // loops are HEAVILY discouraged in Scala
  // while loops are side effects and they return a Unit
  //  var i = 0
  //  while(i < 10) {
  //    println(i)
  //    i += 1
  //  }

  // Everything in Scala is an expression.

  val aWeirdValue: Unit = (aVariable = 3) // Unit type === void
  println(aWeirdValue)
  // value of a Unit is (), they don't really return anything meaningful
  // reassigning a variable is a side effect

  // side effects are expressions returning Unit, e.g: println(), while loops

  // code blocks are special kind of expressions

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  // surrounded by curly braces and inside we can write code, define values, expressions
  // code block is an expressions, value of the block is the value of it's last expression
  }

  // 1. difference between "Hello world" vs println("Hello world")
  // "Hello world" is a string literal and type String
  // println("Hello world") is an expression which is a side effect, returning type Unit
  // 2.
  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)
}
