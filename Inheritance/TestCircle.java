/*****************************************
 *  @author Harrison Jordan
 ****************************************/
package objectoriented;
//******************************************************************
//  A driver/tester class for the Circle3 class
//******************************************************************

public class TestCircle
{
  public static void main(String[] args)
  {
    // Create circle
    Circle circle = new Circle(2);
    Circle circle2 = new Circle(3);
    Circle circle3 = new Circle(4);

    System.out.println("Radius = " + circle.getRadius() +
                       "\nArea = " + circle.getArea());
    System.out.println("# of circles: " + Circle.getAmount());

   }
}
