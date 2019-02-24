import java.io.{File, PrintWriter}

import scalatags.Text.all._

object HtmlBuilder {
  def questionsPerPage = 20
  var printAnswers = true
  var printQuestions = true

  def buildQuestionsHtmlAndSave(fileTitle: String, variants: Seq[TestVariant], filename : String) = {
    val content = for(v <- variants) yield buildQuestionsVariantHtml(v)
    val builded = buildHtml(content)
    println(builded)
    val writer = new PrintWriter(new File(filename))
    writer.println(builded)
    writer.close()
  }

  /*def paginate(questions:Seq[QuestionAndAnswer]) = {
    questions.grouped(questionsPerPage).toSeq.zipWithIndex
  }*/

  def buildQuestionsVariantHtml(variant:TestVariant): Frag ={
    //val paginated = paginate(questions)
    for (page <- variant.pages) yield buildQuestionsPage(variant.title, page)
  }

  def buildQuestionsPage(varTitle: String, page: Page):Frag = {
    div(CssStyles.questionPageDivStyle)(
      div(width := 1000, height := 25)(
        h2(float := "left", margin :=5)(page.title),
        h2(float := "right", margin :=5)( varTitle + " page:" + page.index)
      ),
      if(printQuestions){
        div(CssStyles.questionListDivStyle) {
          for (question <- page.questions) yield buildQuestionHtml(question)
        }
      } else
        div(),
      div(width := 1000, height := 100) (
        div(textAlign:= "center")(h2(float := "center", margin :=5)("answers")),
        table(CssStyles.answerTableStyle)(
          tr(CssStyles.answerTableTdThStyle)(
            for(question <- page.questions) yield th(CssStyles.answerTableTdThStyle)(question.index)
          ),
          tr(
            for(question <- page.questions) yield td(CssStyles.answerTableTdThStyle)(if (printAnswers) question.answer.str() else "")
          )
        )
      )
    )
  }

  def buildQuestionHtml(question: QuestionAndAnswer): Frag = {
    div(CssStyles.questionDivStyle)(
      div(CssStyles.questionIdDivStyle)(
       question.index,
      ),
      div(CssStyles.questionTextDivStyle)(
        pre(
          code(
            question.question
          )
        )
      )
    )
  }


  def buildHtml(conent:Frag):String = {
      "<!DOCTYPE html>" +
      html(
        head(
          tag("style")(tpe := "text/css", CssStyles.styleSheetText)
        ),
        body(
          conent
         /* h1("This is my title"),
          div(CssStyles.answerDivStyle)(
            p("This is my first paragraph"),
            p("This is my second paragraph")
          )*/
        )
      )

    }

  def main(args: Array[String]): Unit = {
    val builded = buildHtml()
    println(builded)
    val writer = new PrintWriter(new File("output.html"))
    writer.println(builded)
    writer.close()
  }
}
