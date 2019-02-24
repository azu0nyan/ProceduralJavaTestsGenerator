import scala.util.Random

  class VariableAssigmentTypeQuestion(answer: BoolAnswer, level: QuestionLevel) extends Question {
    override def generate(r: Random, id: Int): QuestionAndAnswer = {
      val valsSource = getDataSourceForType(r)
      val namesSource = VariableNamesDataSource

      val varType = valsSource._1
      var varName = namesSource.getRandom(true, level, r)
      var varValue = valsSource._2.getRandom(answer.v, level, r)

      val question = {
        val sType = r.nextInt(4)
        sType match {
          case 0 => s"$varType $varName = $varValue;"
          case 1 => s"$varType $varName=$varValue  ;"
          case 2 => s"$varType $varName; \n$varName = $varValue;"
          case 3 => s"$varType $varName   ; \n    $varName =$varValue;"
        }
      }
      new QuestionAndAnswer(question, answer, id)
    }
  }
