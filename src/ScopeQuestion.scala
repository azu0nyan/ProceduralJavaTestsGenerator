
import scala.util.Random

class ScopeQuestion(answer: BoolAnswer, level: QuestionLevel) extends Question {
  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val namesSource = VariableNamesDataSource
    //1 2 same type
    val valsSource1 = getDataSourceForType(r)
    var varName1 = namesSource.getRandom(true, Easy(), r)
    var varType1 = valsSource1._1
    var varValue1 = valsSource1._2.getRandom(true, Easy(), r)

    var varName2 = namesSource.getRandom(true, Easy(), r)
    var varType2 = valsSource1._1
    var varValue2 = valsSource1._2.getRandom(true, Easy(), r)
    //3 can be different
    val valsSource3 = getDataSourceForType(r)
    var varName3 = namesSource.getRandom(true, Easy(), r)
    var varType3 = valsSource3._1
    var varValue3 = valsSource3._2.getRandom(true, Easy(), r)
    //to prevent same names
    if(varName1 == varName2 | varName2 == varName3 | varName1 == varName3){
      varName1 = varName1 + "1"
      varName2 = varName2 + "2"
      varName3 = varName3 + "3"
    }

    val question = if (answer.v) {
      val sType = r.nextInt(4)
      sType match {
        case 0 =>
          s"""$varType1 $varName1 = $varValue1;
             |$varType2 $varName2 = $varName1 + $varValue2;
             |System.out.println($varName1);
           """.stripMargin
        case 1 =>
          s"""int x = 0;
             |if(x > 5){
             |    $varType1 $varName1 = $varValue1;
             |    $varType2 $varName2 = $varName1 + $varValue2;
             |    System.out.println($varName1);
             |}
           """.stripMargin
        case 2 =>
          s"""$varType1 $varName1;
             |int y = 2;
             |if(y > 3){
             |    $varName1 = $varValue1;
             |} else {
             |    $varName1 = $varValue2;
             |}
             |System.out.println($varName1);
           """.stripMargin
        case 3 =>
          s"""$varType1 $varName1;
             |int y = 2;
             |if(y > 3){
             |    $varName1 = $varValue1;
             |}
             |$varName1 = $varValue2 + $varName1;
             |System.out.println($varName1);
           """.stripMargin
      }
    } else {
      val sType = r.nextInt(4)
      sType match {
        case 0 =>
          s"""$varType1 $varName1 = $varValue1;
             |System.out.println($varName2);
             |$varType2 $varName2 = $varName1 + $varValue2;
           """.stripMargin
        case 1 =>
          s"""int x = 0;
             |if(x > 5){
             |    $varType1 $varName1 = $varValue1;
             |    $varType2 $varName2 = $varName1 + $varValue2;
             |}
             |System.out.println($varName1);
           """.stripMargin
        case 2 =>
          s"""$varType1 $varName1;
             |int y = 2;
             |if(y > 3){
             |    $varName1 = $varValue1;
             |} else {
             |    $varName1 = $varValue2;
             |}
             |System.out.println($varName3);
           """.stripMargin
        case 3 =>
          s"""int y = 2;
             |if(y > 3){
             |    $varType1  $varName1 = $varValue1;
             |}
             |$varName1 = $varValue2 + $varName1;
             |System.out.println($varName1);
           """.stripMargin
      }
    }
    new QuestionAndAnswer(question, answer , id)
  }
}
