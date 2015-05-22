/*****************************************
 *  @author Harrison Jordan
 ****************************************/

package objectoriented;
//******************************************************************
//  The Circle class
//******************************************************************

public class Circle
{
  /** The radius of the circle */
  private double radius;
  private static int amountOfCircles;
  /** Construct a circle with radius 1 */
  public Circle() {
    this(1.0);
  }

  /** Construct a circle with a specified radius */
  public Circle(double newRadius) {
    this.radius = newRadius;
    Circle.amountOfCircles++;
  }
  
  public static int getAmount(){
	  return amountOfCircles;
  }

  /** Return the area of this circle */
  public double getArea() {
    return this.radius * this.radius * Math.PI;
  }

  /** Sets the radius */
  public void setRadius(double newRadius) {
    this.radius = newRadius;
  }

  /** Gets the radius */
  public double getRadius() {
    return this.radius;
  }
}
