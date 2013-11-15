/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 15.11.2013
 * Time: 02:47
 * To change this template use File | Settings | File Templates.
 */

import scala.collection.mutable

class Animation(cnt: List[MomentSlice]) {
  def dump() {
    println("START ANIMATION")
    for (moment <- cnt) {
      moment.dump()
    }
    println("END ANIMATION")
  }

  def processingStartup() {

  }

  def processingRun() {

  }

  def computeBoxDimension(): Array[Double] = {
    val first = true
    var dims:Array[Double] = Array[Double](0,0,0,0,0,0)
    for (moment <- cnt) {
      dims = if (first) moment.dimensions() else MomentSlice.mergeDimensions(dims, moment.dimensions())
    }
    dims
  }

  def show() {
    var app: App = new App()
  }
}

object Animation {
  val dynCnt = mutable.MutableList[MomentSlice]()

  def receiveNewMomentSlice(momentSlice: MomentSlice) {
    dynCnt += momentSlice
  }

  def buildAnimation(): Animation = {
    new Animation(dynCnt.toList)
  }
}
