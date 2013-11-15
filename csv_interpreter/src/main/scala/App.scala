import java.awt.Dimension
import javax.swing.JFrame

/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 15.11.2013
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
class App {
  private var Frame: JFrame = new JFrame("Csv Interpretor")
  private var processingPort : ProcessingPort = new ProcessingPort
  Frame.getContentPane.setLayout(null)
  processingPort.setBounds(320, 10, 800, 600)
  processingPort.setVisible(true)
  Frame.getContentPane.add(processingPort)
  Frame.setMinimumSize(new Dimension(1024, 768))
  Frame.pack
  Frame.setVisible(true)
  processingPort.init
}
