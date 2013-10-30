import scala.io.Source
import resource._
/**
 * Created by: Radu Mirescu (radu@neodonis.com)
 * Date: 30.10.2013
 * Time: 21:04
 */
class CsvLoader(fileToInterpret: String) {
  def process() {
    for (source <- managed(Source.fromFile(fileToInterpret))) {
      for( line <- source.getLines ) {
        println( "> %s".format(line))
      }
    }
  }
}

object CsvLoader {
  def main(args: Array[String]) {
    for( arg <- args ) {
      (new CsvLoader(arg)).process()
    }
  }
}
