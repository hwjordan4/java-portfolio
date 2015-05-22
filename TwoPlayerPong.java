package Lab08;
/**
 * The Pong Class 
 */
/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Extra Credit 1
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TwoPlayerPong extends JPanel implements ActionListener {
   private final int WIDTH = 500;   // the window width
   private final int HEIGHT = 500;  // the window height
   private final int PWIDTH = 20;   // the paddle width
   private final int PHEIGHT = 70;  // the paddle height
   private final int BRADIUS = 20;  // the radius of the ball
   private final int DELAY = 30;    // the delay for the animation
   private Timer timer;             // timer for animation
   private boolean paused = false;  // pauses animation when true
   private int p1Score=0;
   private int p2Score=0;
   
   private Ball ball;        // the ball object
   private Paddle paddle;      // the paddle object
   private Paddle paddle2;    // second paddle object
   
   private Color bkgColor = Color.YELLOW;  // background color

   /**  The constructor */
   public TwoPlayerPong () {
      setPreferredSize(new Dimension(WIDTH,HEIGHT));
      setBackground(bkgColor);
      
      int xVelocity = 2 + (int)(Math.random() * 9);
      int yVelocity = 2 + (int)(Math.random() * 9);
      if (Math.random() < 0.5)
          xVelocity *= -1;     // random start in horizontal direction
      if (Math.random() < 0.5)
          yVelocity *= -1;      // random start in vertical direction
      
      ball = new Ball(250,250,xVelocity,yVelocity,BRADIUS,Color.red);
      paddle = new Paddle(20, HEIGHT/2,20,70,0,50,new Color(0, 80, 0));
      paddle2 = new Paddle((WIDTH-40), HEIGHT/2, PWIDTH, PHEIGHT, 0, 50, Color.BLUE);
      
      
      addKeyListener(new DirectionListener());
      setFocusable(true);
      
      timer = new Timer(DELAY,this);     // setting timer delay
      timer.start();                     // start the timer
   }

   /**  Handler for the timer */
   public void actionPerformed (ActionEvent evt) {
      ball.moveRebound(0, 0, WIDTH, HEIGHT);   // keeps the ball in the screen
      paddle.chkCollision(ball);              // checks for bounce off of paddle 1
      paddle2.chkCollision(ball);             // checks for bounce off of paddle 2
      if(paddle.chkCollision(ball)){
    	  p1Score++;    //one point to P1 score if hits paddle
      }
      if(paddle2.chkCollision(ball)){
    	  p2Score++;    //one to to P2 score if hits paddle
      }
      if(ball.getX() == 0){
    	  p1Score -= 10;   //if ball gets past paddle one
    	  timer.stop();
      }
      if(ball.getX() == WIDTH - ball.getWidth()){
    	  p2Score -= 10;     //if ball get past paddle two
    	  timer.stop();
      }
     
      repaint();
   }
   
   /**  Draws the scene */
   public void paintComponent (Graphics page) {
      super.paintComponent(page);
      ball.draw(page);
      paddle.draw(page);
      paddle2.draw(page);
      
      if(ball.getX() == 0){   //End game screen display
    	  page.setColor(Color.BLACK);
    	  page.setFont(new Font("Arial", Font.BOLD, 20));
    	  page.drawString("Game Over!", 185, 245);
    	  page.drawString("Player 2 Wins!!", 170, 275);
    	  page.setFont(new Font("Arial", Font.PLAIN, 10));
    	  page.drawString("(Press (R) to reset game)", 180, 290);
      }
      if(ball.getX() == WIDTH - ball.getWidth()){ //End game screen display
    	  page.setColor(Color.BLACK);
    	  page.setFont(new Font("Arial", Font.BOLD, 20));
    	  page.drawString("Game Over!", 185, 245);
    	  page.drawString("Player 1 Wins!!", 170, 275); 
    	  page.setFont(new Font("Arial", Font.PLAIN, 10));
    	  page.drawString("(Press (R) to reset game)", 180, 290);
      }
      
      page.setFont(new Font("Arial", Font.PLAIN, 15));
      page.setColor(new Color(0, 80, 0));
      page.drawString("Score: " + p1Score, 15, HEIGHT-10);  // displays player one score
      page.setColor(Color.BLUE);
      page.drawString("Score: " + p2Score, (WIDTH-85), HEIGHT-10); // displays player two score
   }
  


   /**  Listener for paddle keys pressed to move the paddle */
   private class DirectionListener extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
         char ch = e.getKeyChar();
         int code = e.getKeyCode();
         	if (ch == 'q' || ch == 'Q')  // exits the program
         		System.exit(0);
         	if (ch == 'p' || ch == 'P')  { // Pause game
         		if (paused)
         			timer.start();
         		else
         			timer.stop();
         			paused = !paused;
			}
			if (ch == 'a' || ch == 'A') {
				paddle.moveUp(0); // move the left paddle up
			}
			if (ch == 'z' || ch == 'Z') {
				paddle.moveDown(HEIGHT); //move the left paddle down
			}
			if (ch == 'k' || ch == 'K') {
				paddle2.moveUp(0); // move the right paddle up
			}
			if (ch == 'm' || ch == 'M') {  //move the right paddle down
				paddle2.moveDown(HEIGHT);
			}
			if (ch == 'r' || ch == 'R'){ //Resets game to default settings
				new TwoPlayerPong();
				timer.start();
				ball.setX(250);
				ball.setY(250);
				ball.setXVelocity(2 + (int)(Math.random() * 9));
					if (Math.random() < 0.5)
						ball.setXVelocity(ball.getXVelocity()*-1);
						ball.setYVelocity(2 + (int)(Math.random() * 9));
					if (Math.random() < 0.5)
						ball.setYVelocity(ball.getYVelocity()*-1);      // random start in vertical direction
				
				p1Score = 0;
				p2Score = 0;
			}

		}
   }
   
   /** Creates the application frame. */
   public static void main (String[] args) {
      JFrame frame = new JFrame ("Two Player Pong");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TwoPlayerPong ());
      frame.pack();
      frame.setVisible(true);
   }
}