/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 15.11.2013
 * Time: 02:47
 * To change this template use File | Settings | File Templates.
 */
import scala.collection.mutable
class Animation( cnt : List[MomentSlice]) {
  def dump() {
    println("START ANIMATION")
    for( moment <- cnt ) {
      moment.dump()
    }
    println("END ANIMATION")
  }
}

object Animation {
  val dynCnt = mutable.MutableList[MomentSlice]()
  def receiveNewMomentSlice( momentSlice : MomentSlice ) {
    dynCnt += momentSlice
  }
  def buildAnimation():Animation = {
    new Animation(dynCnt.toList)
  }
}
