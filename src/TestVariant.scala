import scala.util.Random
//todo class answer

class QuestionAndAnswer(val question: String, val answer: Answer,val index : Int){
  def print(): Unit ={
    println(s"$index : $answer")
    println(question)
  }
}

class Page(val title:String,val  index:Int,val  questions:Seq[QuestionAndAnswer])



class PagePrototype(val title:String, val index:Int, val questions:Seq[Question]){
  def generatePage(startIndex:Int, seed: Int): Page ={
    val r = new Random()
    scala.util.Random.setSeed(r.nextInt)
    val shuffled:Seq[Question] = scala.util.Random.shuffle(questions)
    val zipped = (startIndex to (startIndex + questions.length)).zip(shuffled)
    val list = for(q <-zipped) yield q._2.generateQaA(r.nextInt, q._1)
    new Page(title, index, list)
  }
}

class TestPrototype(val pages:Seq[PagePrototype], val title: String, val description : String = ""){
  def generateTest(variantIndex:Int, seed:Int): TestVariant = {
    val r = new Random()
    val zipped = (1 to pages.length).zip(pages)
    val list = for (p <- zipped) yield p._2.generatePage(0, r.nextInt)

    new TestVariant(list, "variant: " + variantIndex, description)
  }
}

class TestVariant(val pages:Seq[Page], val title: String, val description:String = "")
// {
//
//
//
//  def generate(): Seq[QuestionAndAnswer] = {
//    val r = new Random(seed)
//    var id = 0
//    var res: Seq[QuestionAndAnswer] = Seq()
//    for (elem <- tests) {
//      for (i <- 1 to elem._1) {
//        var answer = r.nextBoolean()
//        var question = elem._3.generate(answer, elem._2, r)
//        res = new QuestionAndAnswer(question, answer, id) +: res
//        id = id + 1
//      }
//    }
//    res = res.reverse
//    res
//  }
//}
