import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {

float spacing;
float columns;
float rows;
PVector mousePos;
 
public void setup() {
  size(700,700);
  spacing = 20;
  columns = PApplet.parseInt(width/spacing);
  rows = PApplet.parseInt(height/spacing);
}
 
public void draw() {
  background(30);
  mousePos = new PVector(mouseX,mouseY);
  stroke(200);
  for(int i = 0; i < columns; i++){
    for(int j = 0; j < rows; j++){
      //point(i*spacing,j*spacing);
      Ticks(i*spacing, j*spacing);
      //rect(i*spacing,j*spacing,spacing,spacing);
    }
  }
}
 
 
public void Ticks(float x, float y) {
  PVector pos = new PVector(x,y);
  point(pos.x,pos.y);
  //float mouseMag =
  //stroke(random(100,255));
  fill(255);
  noStroke();
  PVector lineDir = new PVector(mousePos.x-pos.x, mousePos.y-pos.y);
  PVector lineTarget = new PVector(mouseX, mouseY);
  lineTarget.sub(pos);
  //lineTarget.mult(-180);
   
  pushMatrix();
  translate(pos.x,pos.y);
  rotate(frameCount*0.02f);
  lineTarget.normalize();
  lineTarget.mult(10);
  //line(0,0, lineTarget.x,lineTarget.y);
  rect(0, 0, lineTarget.x, lineTarget.y);
  popMatrix();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
