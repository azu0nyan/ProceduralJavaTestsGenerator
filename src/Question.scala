import scalatags.Text

import scala.util.Random

abstract class QuestionLevel

case class Easy() extends QuestionLevel

case class Medium() extends QuestionLevel

case class Hard() extends QuestionLevel


abstract class Question {
  def generate(r: Random, id: Int): QuestionAndAnswer

  def getDataSourceForType(r: Random): (String, TestDataSource[String]) = {
    var typeId = r.nextInt(4)
    typeId match {
      case 0 => ("String", StringLiteralsDataSource)
      case 1 => ("byte", ByteValuesDataSource)
      case 2 => ("int", IntValuesDataSource)
      case 3 => ("long", LongValuesDataSource)
    }
  }

  def generateQaA(seed: Int, index: Int): QuestionAndAnswer = {
    val r = new Random(seed)
    generate(r, index)
  }

  def getRandomShortVarName(notEqual: Set[String], r: Random): String = {
    var res = getRandomShortVarName(r)
    while (notEqual.contains(res)) {
      res = getRandomShortVarName(r)
    }
    res
  }

  def getRandomShortVarName(r: Random): String = {
    (('a' to 'z').take(r.nextInt(26)).end.toString) + (if (r.nextBoolean()) "" else (0 to 9).take(r.nextInt(10)).end.toString)
  }
}


