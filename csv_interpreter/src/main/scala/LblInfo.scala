/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 15.11.2013
 * Time: 02:07
 * To change this template use File | Settings | File Templates.
 */
class LblInfo(lbl : String, x:Double, y:Double, z:Double) {
  def dump() {
    println("%s -> %f, %f, %f".format(lbl,x,y,z))
  }
}
