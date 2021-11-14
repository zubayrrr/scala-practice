package lectures.part2oop

object OOExercises extends App {
  val author = new Writer("Sam", "Harris", 1967)
  val novel = new Novel("Waking Up", 2014, author)
  // val imposter = new Writer("Sam", "Harris", 1967)

  println(novel.authorAge)
  // println(novel.isWrittenBy(imposter))
  println(novel.isWrittenBy(author))

  val counter = new Counter()
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
  counter.dec.print
}

class Writer(firstName: String, surName: String, val year: Int){
  def fullName: String = s"$firstName $surName"
}

class Novel(name: String, year: Int, author:  Writer) {
  def authorAge: Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

// Counter

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  } // immutability
  // when you need to modify the contents of an instance, you cannot
  // you would simply create a new instance with the stipulated modifications

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print: Unit = println(count)
}

// calling methods val bobSaysHi = bob.greet
// this syntax is allowed only for parameter-less methods