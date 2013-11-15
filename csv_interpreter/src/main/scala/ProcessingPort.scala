/**
 * Created with IntelliJ IDEA.
 * User: asus
 * Date: 15.11.2013
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */

import processing.core.{PConstants, PApplet}

class ProcessingPort extends PApplet {

  override def setup() {
    size( 640, 480, PConstants.OPENGL )
  }

  override def draw() {
    background( 255 );
    lights();
    val angleY = PApplet.radians( (frameCount).toFloat );
    pushMatrix();
    translate( (width * 0.3).toFloat, (height* 0.3).toFloat );
    rotateY( angleY );
    fill( 0, 255, 255 );
    box( 100 );
    popMatrix();
    pushMatrix();
    translate( (width * 0.5).toFloat, (height* 0.5).toFloat );
    rotateY( angleY );
    fill( 0, 255, 0 );
    box( 100, 40, 50 );
    popMatrix();
    pushMatrix();
    translate( (width * 0.7).toFloat, (height * 0.3).toFloat );
    rotateY( angleY );
    fill( 255, 0, 0 );
    sphereDetail( 30 );
    sphere( 75 );
    popMatrix();
    pushMatrix();
    translate( (width * 0.3).toFloat, (height * 0.7).toFloat );
    rotateY( angleY );
    fill( 255, 255, 0 );
    sphereDetail( 6 );
    sphere( 75 );
    popMatrix();
    pushMatrix();
    translate( (width * 0.7).toFloat, (height * 0.7).toFloat );
    rotateY( angleY );
    fill( 255, 0, 255 );
    sphereDetail( 4, 20 );
    sphere( 75 );
    popMatrix();
  }
}
