import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author gouyangyang on 2019/3/2/002 13:52
  */
object StreamingWordCount {

  def main(args: Array[String]): Unit = {
    //StreamingContext
    val conf = new SparkConf().setAppName("StreamingWordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))
    //接收数据  linux 输入nc -lk 8888
    val ds = ssc.socketTextStream("192.168.137.141", 8888)
    //DStream是一个特殊的RDD
    val result = ds.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    //打印结果
    result.print()
    ssc.start()
    //等待结束
    ssc.awaitTermination()
  }
}
