package Lab08;
/**
*  @author Unknown
*/

/**
 * The Paddle Class
 */

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends AbstractAnimation {
   private Color color = Color.BLACK;      // Paddle color

    /**
     * Paddle no-arg constructor. Paddle is at the top left position of
     * the window with no width, height or movement offsets.
     */
   public Paddle() {
      this(0,0,0,0,0,0);
   }

    /**
     * Paddle constructor. Paddle is at position (x,y) with no width,
     * height or movement offsets.
     * 
     * @param x is the paddle's top left x coordinate
     * @param y is the paddle's top left y coordinate
     */ 
   public Paddle(int x, int y) {
      this(x,y,0,0,0,0);
   }

    /**
     * Paddle constructor. Paddle is at position (x,y) with a given
     * width and height, with no movement offsets.
     * 
     * @param x is the paddle's top left x coordinate
     * @param y is the paddle's top left y coordinate
     * @param width is the paddle's width
     * @param height is the paddle's height
     */
   public Paddle(int x, int y, int width, int height) {
      this(x,y,width,height,0,0);
   }

    /**
     * Paddle constructor. Paddle is at position (x,y) with a given
     * width, height and horizontal and vertical movement offsets.
     * 
     * @param x is the paddle's top left x coordinate
     * @param y is the paddle's top left y coordinate
     * @param width is the paddle's width
     * @param height is the paddle's height
     * @param hOffset is the paddle's horizontal movement offset
     * @param vOffset is the paddle's vertical movement offset
     */
   public Paddle(int x, int y, int width, int height,
                               int hOffset, int vOffest) {
      super(0,true,width,height,x,y,hOffset,vOffest);
   }

    /**
     * Paddle constructor. Paddle is at position (x,y) with a given
     * width, height, horizontal and vertical movement offsets, and.
     * color.
     * 
     * @param x is the paddle's top left x coordinate
     * @param y is the paddle's top left y coordinate
     * @param width is the paddle's width
     * @param height is the paddle's height
     * @param hOffset is the paddle's horizontal movement offset
     * @param vOffset is the paddle's vertical movement offset
     * @param color is the paddle's color
     */
  public Paddle(int x, int y, int width, int height,
                              int hOffset, int vOffest, Color color) {
     super(0,true,width,height,x,y,hOffset,vOffest);
     setColor(color);
  }

    /**
     * Gets the paddle's color
     * 
     * @return Returns the color
     */
   public Color getColor() {
      return color;
   }

   /**
    * Sets the paddle's color
    * 
    * @param color is the new color
    */
   public void setColor(Color color) {
      this.color = color;
   }

    /**
     * Draws the paddle on the given graphics page
     * 
     * @param gObject is the graphics page
     */
   public void draw(Object gObject) {
      Graphics page = (Graphics) gObject;
      page.setColor(color);
      page.fillRect((int)getX(),(int)getY(),getWidth(),getHeight());
   }

    /** 
     * Determines if a given ball has collided with the paddle and returns
     * true if it has and false if it has not.  If the ball has collided with
     * the paddle the ball's velocity vectors are modified so the ball will
     * bounce back at the proper angle.
     * 
     * @param ballObject is the ball in the potential collision
     * @return Returns true if collision occurs and updates velocity vectors
     */
   public boolean chkCollision(Object ballObject) {
      Ball ball = (Ball) ballObject;
      
      int bRad = ball.getRadius();
      int bX = (int) ball.getX() + bRad, bY = (int) ball.getY() + bRad;
      int pX1 = (int) getX(), pX2 = pX1 + getWidth() - 1;
      int pY1 = (int) getY(), pY2 = pY1 + getHeight() - 1;
      int dx = bX - ((bX >= pX1 && bX <= pX2) ? bX : (bX < pX1) ? pX1 : pX2);
      int dy = bY - ((bY >= pY1 && bY <= pY2) ? bY : (bY < pY1) ? pY1 : pY2);
      if (dx * dx + dy * dy <= bRad * bRad) {
         int xV = (int) ball.getXVelocity(), yV = (int) ball.getYVelocity();
         int dx2 = Math.abs(dx), dy2 = Math.abs(dy);
         boolean goodRatio = (Math.abs(dx2-dy2) * 6 < dx2+dy2);
         if (dx == 0 && dy == 0) {
            if (Math.abs(xV) >= Math.abs(yV)) {
               ball.setX((xV > 0)?pX1-bRad:pX2);
               ball.setXVelocity(-xV);
            }
            if (Math.abs(xV) <= Math.abs(yV)) {
               ball.setY((yV > 0)?pY1-bRad:pY2);
               ball.setYVelocity(-yV);
            }
            return true;
         }
         if (dx2 >= dy2 || goodRatio) {
            if (dx < 0 && xV > 0 || dx > 0 && xV < 0)
               ball.setXVelocity(-xV);
         }
         if (dy2 >= dx2 || goodRatio) {
            if (dy < 0 && yV > 0 || dy > 0 && yV < 0)
               ball.setYVelocity(-yV);
         }
         return true;
      }
      return false;
   }

   /**
    * The toString method for the Ball class
    * 
    * @return Returns the paddle's color and other field values
    */
   public String toString() {
      return "Paddle color=" + getColor() + ", " + super.toString();
   }
}