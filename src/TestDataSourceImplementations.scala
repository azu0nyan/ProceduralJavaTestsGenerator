//VARIABLE NAMES
object BadVariableNamesEasy extends ConstantArrayDataSource[String](dataArray = Array(
  "i count", "100", "09", "i j", "i + j", "i == 5", "q,q", "i = 2", "i < 3", "{q = 5;}", "233", "300", "500", "bad name",
  "good name", "a + 2", "u + 3", "a + b", "b + c", "i + 2", "")) {}

object BadVariableNamesMedium extends ConstantArrayDataSource[String](dataArray = Array(
  "0Mad", "alter-ego", "0bojeMoi", "2hard4you", ".add", "-ego", "2name", "1_x", "2_y", "3_w_x_4"
)) {}

object BadVariableNamesHard extends ConstantArrayDataSource[String](dataArray = Array(
  "1eet", "alter-ego", "0bojeMoi", "2hard4you", "for", "while", "do"
)) {}

object GoodVariableNamesEasy extends ConstantArrayDataSource[String](dataArray = Array("iCount", "badName", "i", "j", "a",
  "b", "c", "one", "oneRing", "darkLord", "sauron",  "i2", "i3", "k23", "o09", "middleEarth",
  "dwarfLords", "nineRings", "theElves", "powerOfTheRing","more", "great", "max", "min")) {}

object GoodVariableNamesMedium extends ConstantArrayDataSource[String](dataArray = Array(
  "_Name", "it_is_G_R_E_A_T_name", "_alo", "_var_va2", "_a2", "_x_4_x", "_2", "AAA", "XX"
)) {}

object GoodVariableNamesHard extends ConstantArrayDataSource[String](dataArray = Array(
  "_1ame", "____it_is_G_R_E_A_T_name", "_alo", "_var_va2", "___________"
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
  "\"I amar prestar aen.\"",
  "\"The world\"",

  "\"Han mathon ne nen.\"",
  "\"I feel it in the\"",

  "\"Han mathon ne chae.\"",
  "\"I feel it in the earth.\"",

  "\"A han nostron ned\"",
  "\"I smell it in the air.\"",

  "\"Much that once was\"",
  "\"For none now live\"",
  "\" who remember it\"",

  "\"It began with the forging\"",
  "\" of the great rings.\"",
  "\"were given to the Elves\"",
  "\"wisest and fairest\"",

  "\"Seven to the dwarf lords:\"",
  "\"Great miners and craftsmen\",",
  "\" of the mountain halls\"",

  "\"And nine, nine rings \"",
  "\"gifted to the race of men\"",
  "\"above all else\"",

  "\"For within these rings\"",
  "\"was bound the strength\"",
  "\"will to govern each race.\"",

  "\"But they were deceived\"",
  "\"another ring was made.\"",
  "\"the land of Mordor\"",
  "\"fires of Mount Doom,\"",
  "\"Dark Lord Sauron\"",
  "\"a master ring.\"",

  "\"And into this ring he\"",
  "\"poured his cruelty\"",
  "\"and his will to dominate\"",

  "\"One ring\"",
  "\" to rule them all.\"",

  "\"One by one, the \"",
  "\"lands of Middle-earth\"",
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
  easyGood = new RandomValuesDataSource(1, 48),//easy good
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