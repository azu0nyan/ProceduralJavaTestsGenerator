class Type(name:String,testDataSource: TestDataSource[String], isPrimitive:Boolean) {

}

object LongType extends Type(name = "long", testDataSource =  LongValuesDataSource, isPrimitive = true){}
object IntType extends Type(name = "int", testDataSource =  IntValuesDataSource, isPrimitive = true){}
object ByteType extends Type(name = "byte", testDataSource =  ByteValuesDataSource, isPrimitive = true){}
object StringType extends Type(name = "String", testDataSource = StringLiteralsDataSource, isPrimitive = false){}
