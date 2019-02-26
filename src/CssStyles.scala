import scalatags.stylesheet._
import scalatags.Text.all._


object CssStyles extends StyleSheet {
  initStyleSheet()
  val questionPageDivStyle = cls(
    css("page-break-after") := "always"
  )
  val answerPageDivStyle = cls(
    css("page-break-after") := "auto"
  )

  val questionListDivStyle = cls(

    display := "flex",
    flexWrap := "wrap",
    flexDirection := "row",
    alignItems := "center",
    justifyContent := "center",
    width := 1000,
    height := 1300,

    borderStyle := "solid",
    borderWidth := 0.5,
    borderColor := "black"


  )

  val questionDivStyle = cls(
    //  backgroundColor := "green",
    width := 450,
    display := "flex",
    flexWrap := "wrap",
    flexDirection := "row"

    /*  borderStyle := "solid",
      borderWidth := 0.5,
      borderColor := "grey"*/
  )

  val questionIdDivStyle = cls(
    width := 25,
    height := 25,
    borderStyle := "solid",
    borderWidth := 1,
    borderColor := "black",
    display := "flex",
    alignItems := "center",
    justifyContent := "center"
  )

  val questionTextDivStyle = cls(
    //    borderStyle := "dotted",
    //    borderWidth := 1,
    //    borderColor := "blue",
    paddingLeft := 10
  )


  val answerTableStyle = cls(
    width := 1000,
    height := 50,
    borderCollapse := "collapse",
    borderWidth := 1,
    borderColor := "black",
    textAlign := "center",
    tableLayout := "fixed"
  )

  val answerTableTdThStyle = cls(
    height := 25,
    borderCollapse := "collapse",
    borderStyle := "solid",
    borderWidth := 1,
    borderColor := "black",
    textAlign := "center"
  )
  val answerTableTdThStyleCorrect = cls(
    height := 25,
    borderCollapse := "collapse",
    borderStyle := "solid",
    borderWidth := 1,
    borderColor := "black",
    textAlign := "center",
    backgroundColor := "black"
  )
}
