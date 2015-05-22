package Homework2;

//*******************************************************************
//Demonstrates using standard actionPerformed() method for
// the Timer handler.
//*******************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Course: CS2302
 * Section: 01
 * Name: Harrison Jordan
 * Professor: Shaw
 * Assignment #: Homework 2
 */

public class TrainLoop extends JPanel implements ActionListener {
	private final int WIDTH = 800; // the window width
	private final int HEIGHT = 200; // the window height
	private final int DELAY = 40; // the delay for the animation
	private Timer timer; // timer for animation

	private boolean goRight = true; // Determines weather to change values of x,
									// flipT, flipF, and flipFN
	private int x = 0; // movement along the window
	private int flipT; // 100 flips the top of the train to the back
	private int flipF; // 150 flips the front of the train to otherside
	private int flipFN; // 70 flips the front tip of polygon of train

	//
	// Constructor for the train
	//
	public TrainLoop() {

		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.magenta);

		timer = new Timer(DELAY, this);
		timer.start();
	}

	//
	// Once the timer starts this method repeats and updates the location of
	// train
	//
	public void actionPerformed(ActionEvent e) {
		if (goRight) {
			x += 10;
		}
		if (!goRight) {
			x -= 10;
		}
		if (x > WIDTH) {
			goRight = false;
		}
		if (x < -210) {
			goRight = true;
		}
		repaint();
	}

	//
	// Draws the train using rectangle, ovals, and polygons
	// The x coordinates have variables added to them for the direction
	// the train is traveling.
	//
	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		if (!goRight) {
			flipT = 100;
			flipF = 150;
			flipFN = 60;
		} else {
			flipT = 0;
			flipF = 0;
			flipFN = 0;
		}
		page.setColor(Color.cyan);
		page.fillRect(20 + x, 100, 150, 50);
		page.setColor(Color.black);
		page.drawRect(20 + x, 100, 150, 50);

		Polygon topT = new Polygon();
		topT.addPoint(45 + x + flipT, 55);
		topT.addPoint(20 + x + flipT, 70);
		topT.addPoint(70 + x + flipT, 70);
		page.setColor(new Color(218, 165, 32));
		page.fillPolygon(topT);

		Polygon frontT = new Polygon();
		frontT.addPoint(170 + x - flipF, 100);
		frontT.addPoint(170 + x - flipF, 150);
		frontT.addPoint(200 + x - flipF - flipFN, 150);
		page.setColor(Color.green);
		page.fillPolygon(frontT);
		page.setColor(Color.black);
		page.drawPolygon(frontT);

		page.setColor(Color.gray);
		page.fillRect(20 + x + flipT, 70, 50, 30);
		page.setColor(Color.black);
		page.drawRect(20 + x + flipT, 70, 50, 30);
		page.drawLine(45 + x + flipT, 55, 15 + x + flipT, 73);
		page.drawLine(45 + x + flipT, 55, 75 + x + flipT, 73);

		page.setColor(Color.yellow);
		page.fillOval(35 + x, 135, 40, 40);
		page.fillOval(115 + x, 135, 40, 40);
		page.setColor(Color.black);
		page.drawOval(35 + x, 135, 40, 40);
		page.drawOval(115 + x, 135, 40, 40);

	}

	// ----------------------------------------------------------------
	// Creates and displays the application frame.
	// ----------------------------------------------------------------
	public static void main(String[] args) {
		JFrame frame = new JFrame("Train Loop");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(new TrainLoop());
		frame.pack();
		frame.setVisible(true);
	}

}
