import org.apache.log4j.{Level, Logger}

/**
  * @author gouyangyang on 2018/12/20/020 13:47
  */
object JuleiMLdemo {

  def main(args: Array[String]): Unit = {
    //聚类算法
    //屏蔽不必要的日志
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
  }
}
