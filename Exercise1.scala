import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object Exercise1 {
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.ERROR)
    val session = SparkSession
      .builder
      .master("local[2]")
      .appName("word_1")
      .getOrCreate()
    val input = session.read.textFile("TheHungerGames.txt")
    import session.implicits._
    val words = input.flatMap(x => x.split(" "))
    val wordCounts = words.rdd.countByValue()
    wordCounts.foreach(println)
  }
}
