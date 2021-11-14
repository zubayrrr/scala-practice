package lectures.part2oop

object OOBasics extends App {
  val person1 = new Person("John", 40) // object instance
  // concrete realizations in memory, actual memory spaces that conforms to the code and data structure that the class defined
  println(person1.age)
  println(person1.x)

  // calling a method
  person1.greet("Zubayr")

  person1.greet() // overloaded method

  // AT EVERY INSTANTIATION OF THE CLASS PERSON, the whole body of the class Person will be evaluated,
  // all of the expressions inside it will be evaluated first including side effects

}

// class organises data ad behaviour

// class Person(name: String, age: Int)
// everything inside the parenthesis is called a constructor,
// it basically defines every single instance of the class Person should be constructed by passing in a name and age
// age is a class param but not a member that you can readily access using the . dot operator, class params are not fields
// to convert a class param to field is to add a 'val' or 'var' before the parameter
class Person(var name: String, var age: Int) {
  // we can pass default params right inside the constructor var age: Int = 0

  // curly braces are delimiters to the class's body
  // body is not an expression per say, but it defines the implementation of the class
  // values defined in the body can be accessed readily using the dot operator
  val x = 4
  println(1 + 4) // this will be printed on every class instantiation

  // a function defined inside a class definition is called a METHOD

  // to access an instance's field, use the this keyword to refer to the object instead of the class

 def greet(name: String): Unit = println(s"${this.name} says: Hello, $name")

  // overloading
  // defining methods with same name but different signature
  // different signatures really mean, different number of params or params of different types coupled with possibly different return types
  def greet(): Unit = println(s"Hello, my name is $name")
  // this.name doesn't really matter in this case because we don't have any other params called "name", eliminates our need to be specific
  // it already implies that we're looking for the object's param or fields
  // if we had a param with the same name for the method greet() then we'd have had to use the this keyword
  // def greet(): Int = 42 the compiler would be confused in this case as it would not know which method you're referring to


  // multiple constructors or overloading constructors
  def this(name: String) = this(name, 0)
  // auxiliary constructor that initializes the age with 0, takes name as param and calls primary constructor
  // con: the implementation of the secondary constructor has to be another constructor

  // if we had to make another constructor we'd have to call another constructor
  def this() = this("Sam Harris")
}
