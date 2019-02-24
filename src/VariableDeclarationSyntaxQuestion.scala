import scala.util.Random


class VariableDeclarationSyntaxQuestion(answer: BoolAnswer, level: QuestionLevel) extends Question{


  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    var valsSource = getDataSourceForType(r)
    var namesSource = VariableNamesDataSource
    var error = if (answer.v) 0 else r.nextInt(3) + 1

    var varType = valsSource._1
    var varName = namesSource.getRandom(true, level, r)
    var varValue = valsSource._2.getRandom(true, level, r)

    val question = if (answer.v) {
      val sType = r.nextInt(4)
      sType match {
        case 0 => s"$varType $varName = $varValue;"
        case 1 => s"$varType $varName=$varValue  ;"
        case 2 => s"$varType $varName; \n$varName = $varValue;"
        case 3 => s"$varType $varName   ; \n    $varName =$varValue;"
      }
    } else {
      val sType = r.nextInt(5)
      sType match {
        case 0 => s"$varType $varName = $varValue"
        case 1 => s"$varType $varName   $varValue"
        case 2 => s"$varType $varName  \n$varName = $varValue;"
        case 3 => s"$varType = $varName; \n$varName $varValue;"
        case 4 => s"$varType $varName; \n$varName   $varValue;"
      }
    }
    new QuestionAndAnswer(question, answer, id)
  }
}
