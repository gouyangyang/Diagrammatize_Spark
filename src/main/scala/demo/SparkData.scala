package demo

import org.apache.spark.sql.SparkSession

/**
  * @author gouyangyang on 2018/10/15/015 19:59
  */
object SparkData {
    def main(args:Array[String]):Unit={
      val spark=SparkSession.builder().appName("fileRead").getOrCreate()
      val data1=spark.read
        // 推断数据类型
        .option("inferSchema",true)
        //设置空值
        .option("nullValue","?")
        // 表示有表头，若没有则为false
        .option("header",true)
        //文件路径
        .csv("D:\\github_project\\Diagrammatize_Spark\\data\\11.csv")
        //缓存
        .cache()
      //打印数据格式
      data1.printSchema()
      //显示数据,false参数为不要把数据截断
      data1.show(false)
    }
}
