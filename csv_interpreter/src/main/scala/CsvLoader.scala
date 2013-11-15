import scala.io.Source
import resource._
import scala.collection.mutable

/**
 * Created by: Radu Mirescu (radu@neodonis.com)
 * Date: 30.10.2013
 * Time: 21:04
 */
class CsvLoader(fileToInterpret: String) {
  def process() {
    for (source <- managed(Source.fromFile(fileToInterpret))) {
      var loadData = false
      var rowsNb = 0
      var infoLabels : List[String] = List()
      for (line <- source.getLines) {
        if (loadData) {
          val parts = line.split(",").toList
          if( parts.size > 240 ) {
            rowsNb += 1
            val moment = parts.head.toInt
            val rowInfo = packRowInfo(infoLabels,parts.tail,Map[String,(String,String,String)]())
            Animation.receiveNewMomentSlice( MomentSlice.makeMomentSlice( moment, rowInfo ) )
          }
        } else if (line startsWith "Field #,X,Y,Z") {
          loadData = true
        } else if (line startsWith ",LASI,,,") {
          infoLabels = line.substring(1).split(",,,").toList
        }
      }
      val animation = Animation.buildAnimation()
      animation.dump()
      animation.show()
    }
  }

  def dumpRowInfo( info : Map[String,(String,String,String)]) {
    for( key <- info.keys ) {
      println("%s -> %s".format(key, info(key)))
    }
  }

  def packRowInfo(labels: List[String], values: List[String], collector: Map[String,(String,String,String)]) : Map[String,(String,String,String)] = values match {
    case List() => collector
    case x :: y :: z :: nextVals => packRowInfo( labels.tail, nextVals, collector + ( labels.head -> (x,y,z)) )
  }
}

object CsvLoader {
  def main(args: Array[String]) {
    for (arg <- args) {
      (new CsvLoader(arg)).process()
    }
  }
}
