package lectures.part1basics
import scala.annotation.tailrec

object DefaultArgs extends App{

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n * acc)

  val fact10 = trFact(10)

  def savePic(format: String = "jpg", width: Int = 1920, height: Int = 1000): Unit = println("Saving picture")

  // if the leading value for "format" is omitted, the compiler will be confused and will not know how to infer the values that were passed
  // either PASS IN EVERY LEADING ARGUMENT (in our case the "format" argument
  // name the arguments, in which case you don't have to follow the order of the parameters

  // savePic(width = 800)
  savePic(height = 600, width = 800, format = "bmp")

}
