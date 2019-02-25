import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author gouyangyang on 2018/12/19/019 23:05
  */
object Accumulator1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Accumulator1").setMaster("local[1]")
    val sc = new SparkContext(conf)
    val myAcc = new MyAccumulator
    sc.register(myAcc, "myAcc")
    // val acc = sc.longAccumulator("avg")
    //使用已经存在的迭代器或者集合通过调用spark驱动程序提供的parallelize函数来创建并行集合
    // 并行集合被创建用来在分布式集群上并行计算的。
    val nums = Array("1", "2", "3", "4", "5", "6", "7", "8")
    val numsRdd = sc.parallelize(nums)
    numsRdd.foreach(num => myAcc.add(num))
    println(myAcc)
    sc.stop()
  }
}
