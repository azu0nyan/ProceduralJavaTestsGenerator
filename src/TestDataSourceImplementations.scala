//VARIABLE NAMES
object BadVariableNamesEasy extends ConstantArrayDataSource[String](dataArray = Array(
  "i count", "100", "09", "i j", "i + j", "i == 5", "q,q", "i = 2", "i < 3", "{q = 5;}", "233", "300", "500", "bad name",
  "good name", "a + 2", "u + 3", "a + b", "b + c", "i + 2", "")) {}

object BadVariableNamesMedium extends ConstantArrayDataSource[String](dataArray = Array(
  "0Mad", "alter-ego", "0bojeMoi", "2hard4you", ".add", "-ego", "|name", "for", "while", "do"
)) {}

object BadVariableNamesHard extends ConstantArrayDataSource[String](dataArray = Array(
  "1eet", "alter-ego", "0bojeMoi", "2hard4you"
)) {}

object GoodVariableNamesEasy extends ConstantArrayDataSource[String](dataArray = Array("iCount", "badName", "i", "j", "a",
  "b", "c", "one", "oneRing", "darkLordSauron", "i2", "i3", "k23", "o09", "middleEarth",
  "dwarfLords", "nineRings", "theElves", "powerOfTheRing","more", "great", "max", "min")) {}

object GoodVariableNamesMedium extends ConstantArrayDataSource[String](dataArray = Array(
  "_Name", "it_is_G_R_E_A_T_name", "_alo", "_var_va2"
)) {}

object GoodVariableNamesHard extends ConstantArrayDataSource[String](dataArray = Array(
  "_1ame", "____it_is_G_R_E_A_T_name", "_alo", "_var_va2"
)) {}


object VariableNamesDataSource extends CombinedTestDataSource[String](
  GoodVariableNamesEasy, BadVariableNamesEasy,
  GoodVariableNamesMedium, BadVariableNamesMedium,
  GoodVariableNamesHard, BadVariableNamesHard) {}

///Strings
///Strings
object ShortGoodStringLiterals extends ConstantArrayDataSource[String](dataArray = Array(
  "\"some\"",
  "\"value\"",
  "\"count\"",
  "\"add\"",
  "\"remove\"",
  "\"index\"",
  "\"min\"",
  "\"max\"",
  "\"sqrt\"",
  "\"mull\"",
  "\"x\"",
  "\"y\"",
  "\"z\"",
  "\"i\"",
  "\"j\"",
  "\"k\"",
  "\"abs\""
)){}


object EasyGoodStringLiterals extends ConstantArrayDataSource[String](dataArray = Array(
  "\"I amar prestar aen. (ee amar prestar ein)\"",
  "\"The world has changed.\"",

  "\"Han mathon ne nen. (han mathon ne nen)\"",
  "\"I feel it in the water.\"",

  "\"Han mathon ne chae. (han mathon ne hai)\"",
  "\"I feel it in the earth.\"",

  "\"A han nostron ned wilith. (ahan nothon ne gwilith)\"",
  "\"(and?) I smell it in the air.\"",

  "\"Much that once was, is lost\"",
  "\"For none now live who remember it.\"",

  "\"It began with the forging of the great rings.\"",
  "\"Three were given to the Elves:\"",
  "\"Immortal, wisest and fairest of all beings.\"",

  "\"Seven to the dwarf lords:\"",
  "\"Great miners and craftsmen of the mountain halls.\"",

  "\"And nine, nine rings were gifted to the race of men who,\"",
  "\"above all else, desire power.\"",

  "\"For within these rings was bound the strength\"",
  "\"and the will to govern each race.\"",

  "\"But they were, all of them, deceived;\"",
  "\"for another ring was made.\"",
  "\"In the land of Mordor, in the fires of Mount Doom,\"",
  "\"the Dark Lord Sauron forged, in secret, a master ring.\"",

  "\"And into this ring he poured his cruelty, his malice\"",
  "\"and his will to dominate all life.\"",

  "\"One ring to rule them all.\"",

  "\"One by one, the free lands of Middle-earth fell\"",
  "\"to the power of the ring.\""
)) {}

object EasyBadStringLiterals extends ConstantArrayDataSource[String](dataArray = Array(
  "string", "\"строка", "текст\"", "слова вода\"", "воды слова", "где вода", "йцуйцуйцуйцу", "\"афффффаааф",
  "11111111", "3333333\"", "\"ааааааааааааа", "512", "1024", "2048", "4096", "8192", "4000", "5000", "1000", "400", "-400", "1000"
)){}

object StringLiteralsDataSource extends CombinedTestDataSource[String](
  EasyGoodStringLiterals, EasyBadStringLiterals,
  EasyGoodStringLiterals, EasyBadStringLiterals,
  EasyGoodStringLiterals, EasyBadStringLiterals
){}

///NUMBERS
object LongValuesDataSource extends CombinedTestDataSource[String](
  easyGood = new RandomValuesDataSource(1, 53),//easy good
  easyBad = new SelectRandomDataSource[String](Array(new RandomValuesDataSource(75, 100), new RandomValuesDataSource(75, 100), ShortGoodStringLiterals)),
  mediumGood = new RandomValuesDataSource(32, 60),
  mediumBad = new RandomValuesDataSource(68, 100),
  hardGood = new RandomValuesDataSource(56, 63),
  hardBad = new RandomValuesDataSource(64, 66)
) {}

object IntValuesDataSource extends CombinedTestDataSource[String](
  easyGood = new RandomValuesDataSource(1, 20),//easy good
  easyBad = new SelectRandomDataSource[String](Array(new RandomValuesDataSource(45, 55), ShortGoodStringLiterals)),
  mediumGood = new RandomValuesDataSource(16, 28),
  mediumBad = new RandomValuesDataSource(40, 50),
  hardGood = new RandomValuesDataSource(30, 31),
  hardBad = new RandomValuesDataSource(32, 33)
) {}

object ByteValuesDataSource extends CombinedTestDataSource[String](
  easyGood = new RandomValuesDataSource(1, 5),//easy good
  easyBad = new SelectRandomDataSource[String](Array(new RandomValuesDataSource(9, 12),new RandomValuesDataSource(9, 12), ShortGoodStringLiterals)),
  mediumGood = new RandomValuesDataSource(6, 7),
  mediumBad = new RandomValuesDataSource(9, 9),
  hardGood = new RandomValuesDataSource(7, 7),
  hardBad = new RandomValuesDataSource(8, 8)
) {}