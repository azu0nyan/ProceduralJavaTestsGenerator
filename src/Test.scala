import scala.util.Random

abstract class TestLevel
case class Easy() extends TestLevel
case class Medium() extends TestLevel
case class Hard() extends TestLevel

abstract class Test {
  def generate(correct: Boolean, level : TestLevel, r: Random): String

  def getDataSourceForType(r: Random): (String, TestDataSource[String]) = {
    var typeId = r.nextInt(4)
    typeId match {
      case 0 => ("String", StringLiteralsDataSource)
      case 1 => ("byte", ByteValuesDataSource)
      case 2 => ("int", IntValuesDataSource)
      case 3 => ("long", LongValuesDataSource)
    }
  }
}


