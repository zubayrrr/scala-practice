package lectures.part1basics

object StringOps extends App{
  val str: String = "Hello, I am learning Scala and Spark"
  println(str.charAt(2)) // returns character at index 2
  println(str.substring(7, 11)) // takes a beginner index and an end index
  println(str.split(" ").toList) // Uses a delimiter, list represenation using toList
  println(str.startsWith("Hello")) // returns true or false
  println(str.replace(' ', '-')) // takes two string params, oldChar and the newChar to be replaced with
  println(str.toLowerCase())
  println(str.length()) // returns length of the string
  // these are all Java functions that are made available in Scala since it has access to the String class from Java

  // Scala has it's own utilities

  val aNumStr = "2"
  val aNum = aNumStr.toInt // converts a string to an integer
  println('a' +: aNumStr :+ 'z') // prepending char a to aNumStr, appending with :+
  println(str.reverse)
  println(str.take(2))

  // Scala specific: String interpolation

  // s-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old." // s interpolator can evaluate complex expressions
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."

  // f-interpolators
  // they can also receive printf like formats
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute." // 2.2f stands for 2 characters total minimum and 2 decimals precision
  // it can also check for type correctness
  val x = 1.1f
  //val aStr = f"$x%3d" // format requires Int but value is Float, hence the compiler will issue an error

  // raw-interpolator
  println(raw"This is a \n newline, but is it really?")
  // raw is used to print statements literally.
  // but if a string is injected, raw won't have an affect

  val escapedStr = "This is a \n newline, for real this time."
  println(raw"$escapedStr")
}
