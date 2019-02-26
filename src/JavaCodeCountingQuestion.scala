import JavaTests.CyclesTest

import scala.util.Random

abstract class JavaCodeCountingQuestion extends Question {

  def intVarDeclText(nameValue: Seq[(String, Int)]): String = {
    (for (nv <- nameValue)
      yield
        s"""int ${nv._1} = ${nv._2};""".stripMargin
      ).reduce((x, y) => x + "\n" + y)
  }
}

