import scala.util.Random

class QuestionAndAnswer(questio: String, answer: Boolean, id_ : Int){
  def question() = questio
  def ans() = answer
  def id() = id_
  def print(): Unit ={
    println(s"$id : $answer")
    println(question)
  }
}

object TestVariant {
  def generate(tests: Array[(Int,TestLevel, Test)], seed: Int): List[QuestionAndAnswer] = {
    val r = new Random(seed)
    var id = 0;
    var res: List[QuestionAndAnswer] = List()
    for (elem <- tests) {
      for (i <- 1 to elem._1) {
        var answer = r.nextBoolean()
        var question = elem._3.generate(answer, elem._2, r)
        res = new QuestionAndAnswer(question, answer, id) :: res
        id = id + 1
      }
    }
    res = res.reverse
    res
  }
}
