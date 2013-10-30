import scala.io.Source

/**
 * Created by: Radu Mirescu (radu@neodonis.com)
 * Date: 30.10.2013
 * Time: 21:04
 */
class CsvLoader(fileToInterpret: String) {
  def process() {
    val bufferedSource = Source.fromFile(fileToInterpret)
    for (line <- Source.fromFile(fileToInterpret).getLines) {
      println( "> %s".format(line))
    }
    bufferedSource.close()
  }
}

object CsvLoader {
  def main(args: Array[String]) {
    for( arg <- args ) {
      (new CsvLoader(arg)).process()
    }
  }
}
