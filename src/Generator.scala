import scala.util.Random

object Generator {
  def main(args: Array[String]): Unit = {
    var r = new Random
    var test = TestVariant.generate(Array(
      (15,  Easy(), VariableDeclarationTest),
      (10,  Easy(), ScopeTest),
    ), r.nextInt())
    for (elem <- test) {
      println("-------------" + elem.id + "-------------")
      println(elem.question)
    }
  }

}