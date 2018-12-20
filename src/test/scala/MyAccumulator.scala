import org.apache.spark.util.AccumulatorV2

/**
  * https://blog.csdn.net/leen0304/article/details/78866353
  * Spark2 自定义累加器
  *
  * @author gouyangyang on 2018/12/19/019 22:17
  */
class MyAccumulator extends AccumulatorV2[String, String] {
  private var res = ""

  // 清零 返回Boolean
  override def isZero: Boolean = {
    res == ""
  }

  // 复制
  override def copy(): MyAccumulator = {
    val newMyAcc = new MyAccumulator
    newMyAcc.res = this.res
    newMyAcc
  }

  // 重置
  override def reset(): Unit = res = ""

  // 添加
  override def add(v: String): Unit = res += v + "-"

  // merge 合并
  override def merge(other: AccumulatorV2[String, String]): Unit = other match {
    case o: MyAccumulator => res += o.res
    case _ => throw new UnsupportedOperationException(s"Cannot merge ${this.getClass.getName} with ${other.getClass.getName}")
  }

  // 获取值
  override def value: String = res
}
