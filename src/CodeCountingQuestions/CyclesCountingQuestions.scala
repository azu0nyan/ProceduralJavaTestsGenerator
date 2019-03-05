import JavaTests.CyclesTest

import scala.util.Random

class JCStepsCountQuestion extends JavaCodeCountingQuestion {
  def function(x: Int, y: Int, k: Int) = CyclesTest.stepsCount(x, y, k)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val yName = getRandomShortVarName(Set(xName), r)
    val zName = getRandomShortVarName(Set(xName, yName), r)
    val sumName = getRandomShortVarName(Set(xName, yName, zName), r)
    val iName = getRandomShortVarName(Set(xName, yName, zName, sumName), r)

    val xValue = r.nextInt(20)
    val yValue = xValue + r.nextInt(15) + 5
    val zValue = r.nextInt(3) + 1
    val qText = intVarDeclText(Seq((xName, xValue), (yName, yValue), (zName, zValue))) + "\n" + text(xName, yName, zName, sumName, iName)
    val result = function(xValue, yValue, zValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String, yName: String, zName: String, sumName: String, iName: String): String = {
    s"""|int $sumName = 0;
        |for (int $iName = $xName; $iName < $yName; $iName = $iName + $zName) $sumName++;
        |System.out.println($sumName);
     """.stripMargin
  }
}

class JCYmXMullKQuestion extends JavaCodeCountingQuestion {
  def function(x: Int, y: Int, k: Int) = CyclesTest.xmymullk(x, y, k)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val yName = getRandomShortVarName(Set(xName), r)
    val zName = getRandomShortVarName(Set(xName, yName), r)
    val sumName = getRandomShortVarName(Set(xName, yName, zName), r)
    val iName = getRandomShortVarName(Set(xName, yName, zName, sumName), r)

    val xValue = r.nextInt(20)
    val yValue = xValue + r.nextInt(15) + 5
    val zValue = r.nextInt(3) + 1
    val qText = intVarDeclText(Seq((xName, xValue), (yName, yValue), (zName, zValue))) + "\n" + text(xName, yName, zName, sumName, iName)
    val result = function(xValue, yValue, zValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String, yName: String, zName: String, sumName: String, iName: String): String = {
    s"""|int $sumName = 0;
        |for (int $iName = $xName; $iName < $yName; $iName++) $sumName += $zName;
        |System.out.println($sumName);
     """.stripMargin
  }
}

class JCDigitsSumKQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.digitsSum(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val yName = getRandomShortVarName(Set(xName), r)

    val xValue = r.nextInt(1000000000)
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" + text(xName, yName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String, yName: String): String = {
    s"""|int $yName = 0;
        |while ($xName > 0) {
        |    $yName = $yName + $xName % 10;
        |    $xName = $xName / 10;
        |}
        |System.out.println($yName);
     """.stripMargin
  }
}

class JCDigitsCountKQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.digitsCount(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val yName = getRandomShortVarName(Set(xName), r)

    val xValue = r.nextInt(1000000000)
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" + text(xName, yName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String, yName: String): String = {
    s"""|int $yName = 0;
        |while ($xName > 0) {
        |    $yName++;
        |    $xName = $xName / 10;
        |}
        |System.out.println($yName);
     """.stripMargin
  }
}

class JCFailedSwapQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.failedSwapTest(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val nName = getRandomShortVarName(r)
    val iName = getRandomShortVarName(Set(nName), r)
    val xName = getRandomShortVarName(Set(nName, iName), r)
    val tmpName = getRandomShortVarName(Set(nName, iName, xName), r)

    val xValue = (r.nextInt(9) + 1) * 10
    val qText = intVarDeclText(Seq((nName, xValue))) + "\n" + text(nName, iName, xName, tmpName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(nName: String, iName: String, xName: String, tmpName: String): String =
    s"""int $xName[] = {$nName, $nName + 1, $nName + 2, $nName + 3, $nName + 4,
       |   $nName + 5, $nName + 6, $nName + 7, $nName + 8, $nName + 9};
       |for (int $iName = 0; $iName < $xName.length; $iName++) {
       |    int $tmpName = $xName[$iName];
       |    $xName[$iName] = $xName[$xName.length - 1 - $iName];
       |    $xName[$xName.length - 1 - $iName] = $tmpName;
       |}
       |System.out.println($xName[3]);
     """.stripMargin
}

class JCSwapQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.swapTest(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val nName = getRandomShortVarName(r)
    val lName = getRandomShortVarName(Set(nName), r)
    val rName = getRandomShortVarName(Set(nName, lName), r)
    val xName = getRandomShortVarName(Set(nName, lName, rName), r)
    val tName = getRandomShortVarName(Set(nName, lName, rName, xName), r)

    val xValue = r.nextInt(100) + 1
    val qText = intVarDeclText(Seq((nName, xValue))) + "\n" + text(nName, lName, xName, rName, tName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(nName: String, lName: String, xName:String, rName: String, tName: String): String =
    s"""int $xName[] = {$nName, $nName + 1, $nName + 2, $nName + 3, $nName + 4,
       |    $nName + 5, $nName + 6, $nName + 7, $nName + 8, $nName + 9, $nName + 10};
       |for (int $lName = 0, $rName = $xName.length - 1; $lName < $rName; $lName++, $rName--) {
       |    int $tName = $xName[$lName];
       |    $xName[$lName] = $xName[$rName];
       |    $xName[$rName] = $tName;
       |}
       |System.out.println($xName[4]);
     """.stripMargin
}

class JCClosestQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.closestToFromBotNotGreaterThan(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val aName = getRandomShortVarName(Set(xName), r)
    val cName = getRandomShortVarName(Set(xName, aName), r)
    val iName = getRandomShortVarName(Set(xName, aName, cName), r)

    val xValue = r.nextInt(1000) + 1
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" + text(xName, aName, cName, iName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String, aName: String, cName: String, iName: String): String =
    s"""|int $aName[] = {100,200,300,400,500,600,700,800,900,1000};
        |int $cName = 0;
        |for (int $iName = 0; $iName < $aName.length; $iName++) {
        |    if ($aName[$iName] > $cName && $aName[$iName] < $xName) {
        |        $cName = $aName[$iName];
        |    }
        |}
        |System.out.println($cName);
     """.stripMargin
}

class JCarrayIndexesQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.arrayIndexes(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val aName = getRandomShortVarName(Set(xName), r)
    val iName = getRandomShortVarName(Set(xName, aName), r)

    val xValue = r.nextInt(100) + 10
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" + text(xName, aName, iName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String, aName: String, iName: String): String =
    s"""|int $aName[] = new int[$xName];
        |for (int $iName = 0; $iName < $aName.length; $iName++) {
        |    $aName[$iName] = $aName.length - $iName - 1;
        |}
        |System.out.println($aName[$xName / 3)];
     """.stripMargin
}