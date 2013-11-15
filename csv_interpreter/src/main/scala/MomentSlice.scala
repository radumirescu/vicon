import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 15.11.2013
 * Time: 02:09
 * To change this template use File | Settings | File Templates.
 */
class MomentSlice(moment: Int, cnt: Map[String, LblInfo]) {
  def dump() {
    println("Moment: %d".format(moment))
    for (key <- cnt.keys) {
      cnt(key).dump()
    }
  }

  def dimensions(): Array[Double] = {
    var first = true
    var dims = Array[Double](0, 0, 0, 0, 0, 0)
    for (lblInfo <- cnt.values) {
      if (lblInfo.isPoint) {
        if (first) {
          dims = Array(lblInfo.X, lblInfo.X, lblInfo.Y, lblInfo.Y, lblInfo.Z, lblInfo.Z)
          first = false
        } else {
          MomentSlice.adjustDimensions(dims, (lblInfo.X, lblInfo.Y, lblInfo.Z));
        }
      }
    }
    dims
  }
}

object MomentSlice {
  def makeMomentSlice(moment: Int, info: Map[String, (String, String, String)]): MomentSlice = {
    val collector = mutable.Map[String, LblInfo]()

    for (key <- info.keys) {
      if (onInterest(key)) {
        val (xs, ys, zs) = info(key)
        val x = if (xs == "") 0 else java.lang.Double.parseDouble(xs)
        val y = if (ys == "") 0 else java.lang.Double.parseDouble(ys)
        val z = if (zs == "") 0 else java.lang.Double.parseDouble(zs)

        collector += (key -> new LblInfo(key, x, y, z, isPoint(key)))
      }
    }

    new MomentSlice(moment, Map.empty ++ collector)
  }

  def adjustDimensions(dims: Array[Double], point: (Double, Double, Double)) {
    if (dims(0) > point._1) {
      dims(0) = point._1;
    }
    if (dims(1) < point._1) {
      dims(1) = point._1;
    }
    if (dims(2) > point._2) {
      dims(2) = point._2;
    }
    if (dims(3) < point._2) {
      dims(3) = point._2;
    }
    if (dims(4) > point._3) {
      dims(4) = point._3;
    }
    if (dims(5) < point._3) {
      dims(5) = point._3;
    }
  }

  def mergeDimensions(dims: Array[Double], dims2: Array[Double]):Array[Double] = {
    if (dims(0) > dims2(0)) dims(0) = dims2(0)
    if (dims(1) < dims2(1)) dims(1) = dims2(1)
    if (dims(2) > dims2(2)) dims(2) = dims2(2)
    if (dims(3) < dims2(3)) dims(3) = dims2(3)
    if (dims(4) > dims2(4)) dims(4) = dims2(4)
    if (dims(5) < dims2(5)) dims(5) = dims2(5)
    dims
  }

  def onInterest(key: String): Boolean = {
    //TODO filter only values of interest based on markers names
    true
  }

  def isPoint(key: String): Boolean = {
    //TODO mark only points
    true
  }
}
