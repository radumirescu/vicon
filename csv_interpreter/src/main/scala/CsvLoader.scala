/**
 * Created by: Radu Mirescu (radu@neodonis.com)
 * Date: 30.10.2013
 * Time: 21:04
 */
class CsvLoader(fileToInterpret: String) {
  def process() {
    println( "File to interpret is '%s'".format(fileToInterpret) )
  }
}

object CsvLoader {
  def main(args: Array[String]) {
    for( arg <- args ) {
      (new CsvLoader(arg)).process()
    }
  }
}
