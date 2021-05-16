package sql

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by Administrator on 2020/4/28.
 */
object WorldCount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("WorldCount");
    // 创建Spark 上下文对象
    val sc = new SparkContext(conf);
    // 读取文件
    val lines = sc.textFile("D:\\github_project\\Diagrammatize_Spark\\data\\sparklearning.txt");
    // 将一行一行数据分解成一个一个单词
    val words = lines.flatMap(_.split(" "));
    // 方便统计，将单词数据进行结构转换
    val wordToOne = words.map((_, 1));
    // 对转换结构后的数据进行分组聚合
    val wordToSum: RDD[(String, Int)] = wordToOne.reduceByKey(_ + _);
    // 统计结果采集后打印到控制台
    val result: Array[(String, Int)] = wordToSum.collect();
    result.foreach(println)
    sc.stop();
  }

}
