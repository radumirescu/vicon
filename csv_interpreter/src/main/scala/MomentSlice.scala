import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 15.11.2013
 * Time: 02:09
 * To change this template use File | Settings | File Templates.
 */
class MomentSlice(cnt: Map[String, LblInfo]) {
  def dump() {
    for( key <- cnt.keys ) {
      cnt(key).dump()
    }
  }
}

object MomentSlice {
  def makeMomentSlice(info: Map[String, (String, String, String)]) : MomentSlice = {
    val collector = mutable.Map[String,LblInfo]()

    for( key <- info.keys ) {
      val (xs,ys,zs) = info(key)
      val x = if( xs == "") 0 else java.lang.Double.parseDouble(xs)
      val y = if( ys == "") 0 else java.lang.Double.parseDouble(ys)
      val z = if( zs == "") 0 else java.lang.Double.parseDouble(zs)

      collector += ( key -> new LblInfo(key,x,y,z))
    }

    new MomentSlice( Map.empty ++ collector )
  }
}
