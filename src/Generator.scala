import scala.util.Random

object Generator {
  def printGenerated = true
  def buildQuestionsHtml = true
  def buildAnswersHtml = true
  def questionsSaveLocation = "output.html"
  def answersSaveLocation = "answers.html"
  def shortAnswersSaveLocation = "answers_short.html"


  def variantsToGenerate = 15
  def seed = 0
  def testPrototype:TestPrototype = new TestPrototype(
    Seq(

      new PagePrototype(
        "name & class:_____________________________________",
        0,
        Seq(
          new ScopeQuestion(BoolAnswer(true), Easy()),
          new ScopeQuestion(BoolAnswer(true), Easy()),
          new ScopeQuestion(BoolAnswer(true), Easy()),
          new ScopeQuestion(BoolAnswer(false), Easy()),
          new ScopeQuestion(BoolAnswer(false), Easy()),
          new ScopeQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(true), Easy()),
          new IfSyntaxQuestion(BoolAnswer(true), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(true), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(false), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(false), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(true), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(false), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(false), Easy())
        )
      ),
      new PagePrototype(
        "name & class:_____________________________________",
        1,
        Seq(
          new JCFailedSwapQuestion,
          new JCSwapQuestion,
          new JCSwapQuestion,
          new JCStepsCountQuestion,
          new JCStepsCountQuestion,
          new JCClosestQuestion,
          new JCDigitsSumKQuestion,
          new JCDigitsSumKQuestion,
          new JCDigitsCountKQuestion,
          new JCDigitsCountKQuestion,
          new JCYmXMullKQuestion,
          new JCYmXMullKQuestion,
          new JCarrayIndexesQuestion,
          new JCarrayIndexesQuestion,
        )
      )
    ),
    "",
    ""
  )

  def testPrototypeFirstTest:TestPrototype = new TestPrototype(
    Seq(

      new PagePrototype(
        "name & class:_____________________________________",
        0,
        Seq(
          new VariableDeclarationSyntaxQuestion(BoolAnswer(true), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(true), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(true), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(true), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(false), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(false), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(false), Easy()),
          new VariableDeclarationSyntaxQuestion(BoolAnswer(false), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(true), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(true), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(true), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(true), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(false), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(false), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(false), Easy()),
          new VariableAssigmentTypeQuestion(BoolAnswer(false), Easy()),
          new ScopeQuestion(BoolAnswer(false), Easy()),
          new ScopeQuestion(BoolAnswer(false), Medium()),
          new VariableNamingQuestion(BoolAnswer(false), Medium()),
          new VariableNamingQuestion(BoolAnswer(false), Medium()),
          new VariableNamingQuestion(BoolAnswer(true), Easy()),
          new VariableNamingQuestion(BoolAnswer(true), Medium()),
          new ScopeQuestion(BoolAnswer(true), Medium()),
          new ScopeQuestion(BoolAnswer(true), Medium()),
        )
      ),
      new PagePrototype(
        "name & class:_____________________________________",
        1,
        Seq(
          new ScopeQuestion(BoolAnswer(true), Easy()),
          new ScopeQuestion(BoolAnswer(true), Easy()),
          new ScopeQuestion(BoolAnswer(true), Easy()),
          new ScopeQuestion(BoolAnswer(true), Easy()),
          new ScopeQuestion(BoolAnswer(false), Easy()),
          new ScopeQuestion(BoolAnswer(false), Easy()),
          new ScopeQuestion(BoolAnswer(false), Easy()),
          new ScopeQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(true), Easy()),
          new IfSyntaxQuestion(BoolAnswer(true), Easy()),
          new IfSyntaxQuestion(BoolAnswer(true), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
          new IfSyntaxQuestion(BoolAnswer(false), Easy()),
        )
      )
    ),
    "",
    ""
  )


  def main(args: Array[String]): Unit = {
    println("Generating tests...")
    val r = new Random(seed)
    val variants = (0 until variantsToGenerate).map(id => testPrototype.generateTest(id, r.nextInt))
   /* if(printGenerated) {
      println("Printing...")
      for (elem <- test) {
        println("-------------" + elem.id + "-------------")
        println("-------------" + elem.ans() + "-------------")
        println(elem.question)
      }
    }*/

    if(buildQuestionsHtml){
      HtmlBuilder.printAnswers = false
      HtmlBuilder.printQuestions = true
      HtmlBuilder.buildQuestionsHtmlAndSave("TEST VARIANT", variants, questionsSaveLocation)
      HtmlBuilder.printAnswers = true
      HtmlBuilder.printQuestions = true
      HtmlBuilder.buildQuestionsHtmlAndSave("TEST VARIANT", variants, answersSaveLocation)
      HtmlBuilder.printAnswers = true
      HtmlBuilder.printQuestions = false
      HtmlBuilder.buildQuestionsHtmlAndSave("TEST VARIANT", variants, shortAnswersSaveLocation)
    }
  }

  def generateTestVariants(seed:Int):Seq[TestVariant] = {
    val r = new Random(seed)
    for(i <- 1 to variantsToGenerate) yield testPrototype.generateTest(i, r.nextInt())
  }

}