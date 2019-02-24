import scala.util.Random

class IfSyntaxQuestion(answer: BoolAnswer, level: QuestionLevel) extends Question {
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
      val sType = r.nextInt(3)
      sType match {
        case 0 if varType1 != "String" =>
          s"""$varType1 $varName1 = $varValue1;
             |if($varName1 < $varValue2){
             |    $varType2 $varName2 = $varName1 + $varValue2
             |    System.out.println($varName1);
             |}
           """.stripMargin
        case 0 if varType1 == "String" =>
          s"""int x = 12;
             |if(x < 2){
             |    $varType2 $varName2 = $varValue2 + $varValue2
             |    System.out.println($varName1);
             |}
           """.stripMargin
        case 1 =>
          s"""$varType1 $varName1;
             |int y = 2;
             |if(y > 3){
             |    $varName1 = $varValue1;
             |} else {
             |    $varName1 = $varValue2;
             |}
             |System.out.println($varName1);
           """.stripMargin
        case 2 =>
          s"""$varType1 $varName1 = $varValue1;
             |$varType2 $varName2 = $varValue2;
             |if($varName1 == $varName2){
             |    System.out.println($varName1);
             |} else {
             |    System.out.println($varName1);
             |    System.out.println($varName2);
             |}
           """.stripMargin
      }
    } else {
      val sType = r.nextInt(6)
      sType match {
        case 0 if varType1 != "String" =>
          s"""$varType1 $varName1 = $varValue1;
             |if($varName1 < $varValue2)
             |    $varType2 $varName2 = $varName1 + $varValue2
             |    System.out.println($varName1);
             |}
           """.stripMargin
        case 0 if varType1 == "String" =>
          s"""int x = 12;
             |if(x < 2{
             |    $varType2 $varName2 = $varValue2 + $varValue2
             |    System.out.println($varName1);
             |}
           """.stripMargin
        case 1 =>
          s"""$varType1 $varName1;
             |int y = 2;
             |if($varName3 + $varValue3){
             |    $varName1 = $varValue1;
             |} else {
             |    $varName1 = $varValue2;
             |}
             |System.out.println($varName1);
           """.stripMargin
        case 2 =>
          s"""$varType1 $varName1 = $varValue1;
             |$varType2 $varName2 = $varValue2;
             |if($varName1 = $varName2){
             |    System.out.println($varName1);
             |} else {
             |    System.out.println($varName1);
             |    System.out.println($varName2);
             |}
           """.stripMargin
        case 3 =>
          s"""$varType1 $varName1;
             |int y = 2;
             |if y > 2 {
             |    $varName1 = $varValue1;
             |}
             |System.out.println($varName1);
           """.stripMargin
        case 4 =>
          s"""$varType1 $varName1 = $varValue1;
             |if($varName1 == $varValue2){
             |    System.out.println($varName1);
             |} else {
             |    System.out.println(Not equals);
             |}
           """.stripMargin
        case 5 =>
          s"""$varType1 $varName1 = $varValue1;
             |if $varName1 == $varValue2){
             |    System.out.println($varName1);
             |} else {
             |    System.out.println();
             |}
           """.stripMargin
      }
    }
    new QuestionAndAnswer(question, answer , id)
  }
}