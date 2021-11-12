package lectures.part1basics

object ValuesVariablesTypes extends App{
  val x: Int = 42
  println(x)

  // values assigned through 'val' cannot be reassigned, they're immutable, kinda like constants or final in java
  // val(s) aren't really regarded as constants to be reused but more like intermediate computations to later use in other computations
  // types are inferred by the compiler, they're optional

  val aString = "Hello";
  // semi colons are optional unless you're writing multiple expressions on the same line

  val aBoolean: Boolean = false
  val aChar: Char = 'a' // single characters inside single quotes
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 465465879L // Longs should end with an uppercase L at the end
  val aFloat: Float = 2.0f // Floats should end with a lowercase f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 9 // unlike val(s) var(s) can be reassigned
  aVariable = 8 // side effects changing of var, printing to console

}
