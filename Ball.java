package Lab08;
/**
* @ author Unknown
*/

/**
 * The Ball Class - 
 * An animated ball object
 */

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends AbstractAnimation {
   private int radius = 20;                 // Ball radius
   private Color color = Color.BLACK;       // Ball color

    /**
     * Ball no-arg constructor. Ball is at the top left position of
     * the window with no velocity.
     */
   public Ball() {
      this(0,0,0,0);
   }

    /**
     * Ball constructor. Ball is at position (x,y) with no velocity.
     * 
     * @param x is the ball's top left x coordinate
     * @param y is the ball's top left y coordinate
     */ 
   public Ball(int x, int y) {
      this(x,y,0,0);
   }

    /**
     * Ball constructor. Ball is at position (x,y) with a given
     * velocity.
     * 
     * @param x is the ball's top left x coordinate
     * @param y is the ball's top left y coordinate
     * @param xVelocity is the ball's x velocity
     * @param yVelocity is the ball's y velocity
     */
   public Ball(int x, int y, int xVelocity, int yVelocity) {
      super(0,true,x,y,xVelocity,yVelocity);
      setWidth(radius*2);
      setHeight(radius*2);
   }

    /**
     * Ball constructor. Ball is at position (x,y) with a given
     * velocity, a given radius and a given color.
     * 
     * @param x is the ball's top left x coordinate
     * @param y is the ball's top left y coordinate
     * @param xVelocity is the ball's x velocity
     * @param yVelocity is the ball's y velocity
     * @param radius is the ball's radius
     * @param color is the ball's color
     */
   public Ball(int x, int y, int xVelocity, int yVelocity,
                                     int radius, Color color) {
      super(0,true,radius*2,radius*2,x,y,xVelocity,yVelocity);
      setRadius(radius);
      setColor(color);
   }
   
    /**
     * Gets the ball's radius
     * 
     * @return Returns the radius
     */
   public int getRadius() {
      return radius;
   }

    /**
     * Sets the ball's radius
     * 
     * @param radius is the new radius
     */
   public void setRadius(int radius) {
      if (radius >= 0) {
         this.radius = radius;
         setWidth(radius*2);
         setHeight(radius*2);
      }
   }

    /**
     * Gets the ball's color
     * 
     * @return Returns the color
     */
   public Color getColor() {
      return color;
   }

    /**
     * Sets the ball's color
     * 
     * @param color is the new color
     */
   public void setColor(Color color) {
      this.color = color;
   }

    /**
     * Draws the ball on the given graphics page
     * 
     * @param gObject is the graphics page
     */
   public void draw(Object gObject) {
      Graphics page = (Graphics) gObject;
      page.setColor(color);
      page.fillOval((int)getX(),(int)getY(),getWidth(),getHeight());
   }

    /**
     * The toString method for the Ball class
     * 
     * @return Returns the ball's direction, position and movement offsets
     */
   public String toString() {
      return "Ball " + super.toString();
   }
}