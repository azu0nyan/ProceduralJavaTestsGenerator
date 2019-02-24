abstract  class  Answer {
  def str():String
}

case class BoolAnswer(v:Boolean) extends Answer {
  override def str(): String = String.valueOf(v)
}

case class IntAnswer(answer:Int) extends Answer {
  override def str(): String = String.valueOf(answer)
}