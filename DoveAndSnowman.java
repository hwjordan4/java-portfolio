package Lab07;
/**
*  @author Multiple
*/


//*******************************************************************
// Animation of a dove flying around a snowman.
//*******************************************************************
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Lab07
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DoveAndSnowman extends JPanel implements ActionListener{
    private final int WIDTH = 500;   // the window width
    private final int HEIGHT = 400;  // the window height
    private final int DELAY = 40;	 // the delay between wing flaps
    private final int JUMP = 10;
    private int xPos = 10;           // the x position of dove
    private int yPos = 150;          // the y position of dove
    
    private Image dove;              // the dove image
    private Image[] rdove = new Image[8]; //array of right dove images
    private Image[] ldove = new Image[8]; //array of left dove images
    private int imageIndex = 0;		//keep track of dove
    private boolean goRight = true;
    private Image bkgImage;          // the background image
    
    private Timer timer;				//the timer for animation

    /** The constructor */
    public DoveAndSnowman() {
    	
    	
        MediaTracker track = new MediaTracker(this);
        bkgImage = new ImageIcon("snowlandscape.jpg").getImage();
        
        for(int i= 1; i <= 8; i++){
        	rdove[i-1] = new ImageIcon("rdove"+i+".png").getImage();
        	ldove[i-1] = new ImageIcon("ldove"+i+".png").getImage();
        	track.addImage(rdove[i-1],0);
        	track.addImage(ldove[i-1],0);
        }
        track.addImage(bkgImage,0);
        dove = rdove[0];
        try {
             track.waitForAll();
        } catch ( InterruptedException e ) { }
        
        
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener (new DirectionListener());
        setFocusable(true);
        timer = new Timer(DELAY, this);
        timer.start();
    }
/*****************************************
 *  @author Harrison Jordan
 ****************************************/

    /** Draw the scene */
    public void paintComponent (Graphics page) {
        super.paintComponent(page);
        page.drawImage(bkgImage,0,0,WIDTH,HEIGHT,null);
        	if(goRight){
        		drawSnowman(page);
        		page.drawImage(dove, xPos, yPos, null);
        	}
        	else{
        		page.drawImage(dove, xPos, yPos, null);
        		drawSnowman(page);
        	}
        
    }
    
    /**  Draws the snowman */
    public void drawSnowman(Graphics page) {
        final int XMID = 200;
        final int YTOP = 188;
        
        page.setColor(Color.WHITE);
        page.fillOval(XMID-30, YTOP, 60, 60);      // head
        page.fillOval(XMID-52, YTOP+52, 105, 75);   // upper torso
        page.fillOval(XMID-75, YTOP+120, 150, 90);  // lower torso
        
        page.setColor(Color.BLACK);
        page.fillOval(XMID-13, YTOP+15, 5, 5);   // left eye
        page.fillOval(XMID+8, YTOP+15, 5, 5);    // right eye
     
        page.drawArc(XMID-15, YTOP+25, 30, 15, 190, 160);   // smile
        
        page.drawLine(XMID-35, YTOP+80, XMID-80, YTOP+45);  // left arm
        page.drawLine(XMID-35, YTOP+81, XMID-80, YTOP+46);
        page.drawLine(XMID+40, YTOP+80, XMID+90, YTOP+80);  // right arm
        page.drawLine(XMID+40, YTOP+81, XMID+90, YTOP+81);
        
        page.drawLine(XMID-30, YTOP+5, XMID+30, YTOP+5);  // brim of hat
        page.fillRect(XMID-20, YTOP-25, 40, 30);        // top of hat
    }
    
	/*****************************************
 	*  @author Harrison Jordan
 	****************************************/
    //Action listener that performs animation of wings
    public void actionPerformed (ActionEvent e){
    		++imageIndex;
    		if(imageIndex >= 8)
    			imageIndex=0;
    		if(goRight){
    			dove = rdove[imageIndex];
    		}
    		else{
    			dove = ldove[imageIndex];
    		}
    		repaint();
    }
    
	/*****************************************
 	*  @author Harrison Jordan
 	****************************************/
    //Key listener to change direction of dove
    private class DirectionListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
           char ch = e.getKeyChar();
           int code = e.getKeyCode();
           if (ch == 'q' || ch == 'Q')  //quits the program
              System.exit(0);
           if (ch == 'u' || ch == 'U' || code == KeyEvent.VK_UP){
              yPos -= JUMP; //  move the dove up
           		if(yPos <= 0)
           			yPos = 0;
           }
           if (ch == 'd' || ch == 'D' || code == KeyEvent.VK_DOWN){
              yPos += JUMP; //  move the dove down
           		if(yPos > HEIGHT-dove.getHeight(null))
           			yPos = HEIGHT-dove.getHeight(null);
           }
           if (ch == 'r' || ch == 'R' || code == KeyEvent.VK_RIGHT){
        	   goRight = true;
              xPos += JUMP; //  move the dove up
              if(xPos > WIDTH - dove.getWidth(null))
            	  xPos = WIDTH - dove.getWidth(null);
           }
           if (ch == 'l' || ch == 'L' || code == KeyEvent.VK_LEFT){
        	   goRight = false;
              xPos -= JUMP; //  move the dove down
              if(xPos <= 0)
            	  xPos = 0;
           }
           repaint();
        }
    }
    /** Creates the application frame. */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snowman and the Dove");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DoveAndSnowman());
        frame.pack();
        frame.setVisible(true);
    }
}