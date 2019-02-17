import scala.util.Random

abstract class DataSource[T] {
  def getRandom(r: Random): T
}

abstract class TestDataSource[T] {
  def getRandom(good: Boolean, level: TestLevel, r: Random): T
}

class CombinedTestDataSource[T](easyGood: DataSource[T], easyBad: DataSource[T],
                                mediumGood: DataSource[T], mediumBad: DataSource[T],
                                hardGood: DataSource[T], hardBad: DataSource[T]) extends TestDataSource[T] {
  override def getRandom(good: Boolean, level: TestLevel, r: Random): T = {
    (good, level) match {
      case (true, Easy()) => easyGood.getRandom(r)
      case (false, Easy()) => easyBad.getRandom(r)
      case (true, Medium()) => mediumGood.getRandom(r)
      case (false, Medium()) => mediumBad.getRandom(r)
      case (true, Hard()) => hardGood.getRandom(r)
      case (false, Hard()) => hardBad.getRandom(r)
    }
  }
}

class ConstantArrayDataSource[T](dataArray: Array[T]) extends DataSource[T] {
  val data: Array[T] = dataArray

  override def getRandom(r: Random): T = {
    val index = r.nextInt(data.length)
    data(index)
  }
}

class RandomValuesDataSource(bitLengthMin: Int, bitLengthMax: Int, varSign:Boolean = true, radix:Int = 10) extends DataSource[String] {
  override def getRandom(r: Random): String = {
    var res:BigInt = 0
    val min:BigInt = if(bitLengthMin <= 0) 0 else BigInt(2).pow(bitLengthMin - 1)
    while (res.abs < min) {
      res = BigInt.apply(bitLengthMax, r)
    }
    if(varSign ) {
      if(r.nextBoolean()){
        res = -res
      }
    }
    res.toString(radix)
  }
}

class SelectRandomDataSource[T](sources: Array[DataSource[T]]) extends DataSource[T]{
  override def getRandom(r: Random): T = {
    val index = r.nextInt(sources.length)
    sources(index).getRandom(r)
  }
}


