package two

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author gouyangyang on 2018/12/17/017 22:47
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("WordCount")
    val sc = new SparkContext(conf)
    val rdd  = sc.textFile("D:\\github_project\\Diagrammatize_Spark\\data\\sparklearning.txt")
    rdd.foreach(println)
    // flatMap 对集合中每个元素进行操作然后再扁平化
    val wordCount  = rdd.flatMap(_.split(" ")).map(x=>(x,1)).reduceByKey(_+_)
    val wordsort=wordCount.map(x=>(x._2,x._1)).sortByKey(false).map(x=>(x._2,x._1))
    // hdfs 写入的时候没有权限 hadoop fs -chmod 777 /Diagrammatize_Spark
    wordsort.saveAsTextFile("hdfs://hadoop:9000/Diagrammatize_Spark/Two/Wordcount2/")
    wordCount.foreach(println)
    sc.stop()
  }
}
