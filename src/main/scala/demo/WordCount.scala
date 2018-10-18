package demo

import org.apache.spark.sql.SparkSession

/**
  * @author gouyangyang on 2018/10/15/015 20:00
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    // val conf=new SparkConf().setAppName("测试").setMaster("local[2]")
    // val sc= new SparkContext(conf)
    //  val file=sc.textFile("file:///home/soyo/桌面/spark编程测试数据/1.txt")
    val spark = SparkSession.builder().getOrCreate()
    // val file=spark.read.textFile("file:///home/soyo/桌面/spark编程测试数据/1.txt").rdd
    val file = spark.sparkContext.textFile("D:\\github_project\\Diagrammatize_Spark\\data\\sparklearning.txt")
    val word = file.flatMap(lines => lines.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
    word.foreach(println)
  }

}
