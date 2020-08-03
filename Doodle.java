// Jessica Hsieh
// 4/18/17
// CSE142
// TA: Alex Demeo
// Assignment #3 Part A
//
// This program will print out a figure I created.

import java.awt.*;

public class Doodle {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(200, 200);
		panel.setBackground(Color.BLACK);
		Graphics g = panel.getGraphics();
		g.setColor(Color.YELLOW);
		
		// Animation for the shapes.
		for (int i = 1; i <= 8; i++) {
			panel.clear();
			g.fillOval(170, 10 * i + 100, 20, 20);
			g.fillRect(20, 10 * i + 100, 20, 20);
			g.fillRect(80, 10 * i + 100, 50, 20);
			panel.sleep(150);
		}
		squares(g, 10, 10);
		squares(g, 20, 20);
		squares(g, 30, 30);
		lines(g, 20, 0);
	}
	
	// Outlines the squares.
	public static void squares(Graphics g, int x, int y) {
		for (int i = 1; i <= 10; i++) {
			g.setColor(Color.WHITE);
			g.drawRect(x * i - x, y * i, 100, 100);
		}
	}
	
	// Draws the lines that separate equally.
	public static void lines(Graphics g, int x, int y) {
		for (int i = 1; i <= 10; i++) {
			g.setColor(Color.GRAY);
			g.drawLine(x * i, y, x * i, y + 200);
		}
	}
}