import JavaTests.CyclesTest

import scala.util.Random

class JCStepsCountQuestion extends JavaCodeCountingQuestion {
  def function(x: Int, y: Int, k: Int) = CyclesTest.stepsCount(x, y, k)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val yName = getRandomShortVarName(Set(xName), r)
    val zName = getRandomShortVarName(Set(xName, yName), r)
    val xValue = r.nextInt(20)
    val yValue = xValue + r.nextInt(15) + 5
    val zValue = r.nextInt(3) + 1
    val qText = intVarDeclText(Seq((xName, xValue), (yName, yValue), (zName, zValue))) + "\n" +  text(xName, yName, zName)
    val result = function(xValue, yValue, zValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String, yName: String, zName: String): String = {
    s"""|int sum = 0;
       |for (int i = $xName; i < $yName; i = i + $zName) sum++;
       |System.out.println(sum);
     """.stripMargin
  }
}

class JCYmXMullKQuestion extends JavaCodeCountingQuestion {
  def function(x: Int, y: Int, k: Int) = CyclesTest.xmymullk(x, y, k)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val yName = getRandomShortVarName(Set(xName), r)
    val zName = getRandomShortVarName(Set(xName, yName), r)
    val xValue = r.nextInt(20)
    val yValue = xValue + r.nextInt(15) + 5
    val zValue = r.nextInt(3) + 1
    val qText = intVarDeclText(Seq((xName, xValue), (yName, yValue), (zName, zValue))) + "\n" +  text(xName, yName, zName)
    val result = function(xValue, yValue, zValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String, yName: String, zName: String): String = {
    s"""|int sum = 0;
        |for (int i = $xName; i < $yName; i++) sum += $zName;
        |System.out.println(sum);
     """.stripMargin
  }
}

class JCDigitsSumKQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.digitsSum(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val xValue = r.nextInt(1000000000)
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" +  text(xName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String): String = {
    s"""|int y = 0;
        |while ($xName > 0) {
        |    y = y + $xName % 10;
        |    $xName = $xName / 10;
        |}
        |System.out.println(y);
     """.stripMargin
  }
}
class JCDigitsCountKQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.digitsCount(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val xValue = r.nextInt(1000000000)
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" +  text(xName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String): String = {
    s"""|int y = 0;
        |while ($xName > 0) {
        |    y++;
        |    $xName = $xName / 10;
        |}
        |System.out.println(y);
     """.stripMargin
  }
}

class JCFailedSwapQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.failedSwapTest(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val xValue = (r.nextInt(9) + 1) * 10
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" +  text(xName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String): String =
    s"""int x[] = {$xName, $xName + 1, $xName + 2, $xName + 3, $xName + 4,
       |   $xName + 5, $xName + 6, $xName + 7, $xName + 8, $xName + 9};
       |for (int i = 0; i < x.length; i++) {
       |    int tmp = x[i];
       |    x[i] = x[x.length - 1 - i];
       |    x[x.length - 1 - i] = tmp;
       |}
       |System.out.println(x[3]);
     """.stripMargin
}

class JCSwapQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.swapTest(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val xValue = r.nextInt(100) + 1
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" +  text(xName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String): String =
    s"""int x[] = {$xName, $xName + 1, $xName + 2, $xName + 3, $xName + 4,
       |    $xName + 5, $xName + 6, $xName + 7, $xName + 8, $xName + 9, $xName + 10};
       |for (int l = 0, r = x.length - 1; l < r; l++, r--) {
       |    int t = x[l];
       |    x[l] = x[r];
       |    x[r] = t;
       |}
       |System.out.println(x[4]);
     """.stripMargin
}

class JCClosestQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.closestToFromBotNotGreaterThan(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val xValue = r.nextInt(1000) + 1
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" +  text(xName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String): String =
    s"""|int a[] = {100,200,300,400,500,600,700,800,900,1000};
        |int c = 0;
        |for (int i = 0; i < a.length; i++) {
        |    if (a[i] > c && a[i] < $xName) {
        |        c = a[i];
        |    }
        |}
        |System.out.println(c);
     """.stripMargin
}

class JCarrayIndexesQuestion extends JavaCodeCountingQuestion {
  def function(x: Int) = CyclesTest.arrayIndexes(x)

  override def generate(r: Random, id: Int): QuestionAndAnswer = {
    val xName = getRandomShortVarName(r)
    val xValue = r.nextInt(100) + 10
    val qText = intVarDeclText(Seq((xName, xValue))) + "\n" +  text(xName)
    val result = function(xValue)
    new QuestionAndAnswer(qText, IntAnswer(result), id)
  }

  def text(xName: String): String =
    s"""|int a[] = new int[$xName];
       |for (int i = 0; i < a.length; i++) {
       |    a[i] = a.length - i - 1;
       |}
       |System.out.println(a[$xName / 3)];
     """.stripMargin
}