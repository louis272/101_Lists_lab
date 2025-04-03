object Task2 extends App {
  var names: List[String] = List("Alice", "Paul", "Charlie", "David")

  println(names.mkString(","))

  if (names.contains("Paul")) println("Paul")

  var names_shorter: List[String] = names.filterNot(_ == "Paul")

  println(names_shorter.mkString(","))
}
