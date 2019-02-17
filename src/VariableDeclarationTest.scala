import scala.util.Random


object VariableDeclarationTest extends Test {


  override def generate(correct: Boolean, level: TestLevel, r: Random): String = {
    var valsSource = getDataSourceForType(r)
    var namesSource = VariableNamesDataSource
    var error = if (correct) 0 else r.nextInt(3) + 1
    var correctName = error != 1
    var correctValues = error != 2
    var correctSyntax = error != 3

    var varType = valsSource._1
    var varName = namesSource.getRandom(correctName, level, r)
    var varValue = valsSource._2.getRandom(correctValues, level, r)

    if (correctSyntax) {
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

  }
}
