// Jessica Hsieh
// 4/18/17
// CSE142
// TA: Alex Demeo
// Assignment #3 Part B
//
// This program will print out the Cafe Wall illusion.

import java.awt.*;

public class CafeWall {
   public static final int MORTAR = 2;
	
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(650, 400);
		panel.setBackground(Color.GRAY);
		Graphics g = panel.getGraphics();
		drawSquares(g, 0, 0, 20, 4);
		drawSquares(g, 50, 70, 30, 5);
		drawGrid(g, 10, 150, 25, 4, 0);
		drawGrid(g, 250, 200, 25, 3, 10);
		drawGrid(g, 425, 180, 20, 5, 10);
		drawGrid(g, 400, 20, 35, 2, 35);
	}
	
	// Draws a row of black (with blue X) and white squares.
   public static void drawSquares(Graphics g, int x, int y, int size, int pair) {
      for (int i = 1; i <= pair; i++) {
			int a = (2 * size * i) - (2 * size - x);
			int b = (2 * size * i) + (x - size);
			g.setColor(Color.BLACK);
			g.fillRect(a, y, size, size);
			g.setColor(Color.BLUE);
			g.drawLine(a, y, b, y + size);
			g.drawLine(b, y, a, y + size);
			g.setColor(Color.WHITE);
			g.fillRect(b, y, size, size);
		}
	}
	
	// Draws a grid that contains several rows of black (with blue X) and white squares.
	public static void drawGrid(Graphics g, int x, int y, int size, int pair, int offset) {
      for (int i = 1; i <= pair; i++) {
         int a = 2 * (size + MORTAR) * i + y - 2 * (size + MORTAR);
			int b = 2 * (size + MORTAR) * i + y - (size + MORTAR);
			drawSquares(g, x, a, size, pair);
			drawSquares(g, x + offset, b, size, pair);
		}
	}
}