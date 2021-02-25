import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession


object Exercise4 {
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val session = SparkSession
      .builder
      .master("local[2]")
      .appName("word_1")
      .getOrCreate()
    val input = session.read.textFile("TheHungerGames.txt")
    var concatList =List.empty[String]
    import session.implicits._

    // To remove non-letter characters
    val words = input.flatMap(x => x.split("[^A-Za-z0-9]"))
    val wordCounts = words.rdd.countByValue()
    println("------------------------------------------------------------")
    println("Word count after removing all the special characters ")
    println("------------------------------------------------------------")
    wordCounts foreach println
    println("------------------------------------------------------------")

    // To merge uppercase and lowercase words
    var wordList = wordCounts.keySet
    for (eachWord <- wordList) {
      wordList = wordList.-(eachWord)
      for (item <- wordList) {
        if (eachWord.equalsIgnoreCase(item)) {
          concatList = concatList :+ eachWord.concat(item)
        }
      }
    }
    println("Words after merging uppercase and lowercase words ")
    println("------------------------------------------------------------")
    concatList foreach println


    //To Sort the pairs in reverse order
    val sortedList = concatList.map(s => new String(s.toCharArray)).sorted.reverse
    println("------------------------------------------------------------")
    println("Displaying merged pairs(upper and lower) in reverse order")
    println("------------------------------------------------------------")
    sortedList foreach println
  }
}
