package graphiceditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import javax.swing.JPanel;

/*
 * As you noticed your solution was always drawing lines from the point you clicked on
 * to the point you dragged your mouse pointer to. Of couse we want to paint real lines,
 * just as we can do it in Paint! I modified the solution accordingly.
 * 
 */
/**
 * The DrawingPanel represents the canvas the user can draw on.
 *
 */
public class DrawingPanel extends JPanel {

	/*
	 * Here is some best practice: We want our classes to fulfill a single task and not multiple ones.
	 * Whenever we discover a concept that does not have to do with the primary task of the class
	 * we should extract it to a new class. This is called Single-Responsibility-Principle.
	 * In our case we had two responsibities in the class: Drawing lines, and handling the mouse. 
	 * For the latter I created now a new class that does the mouse handling.
	 */
	private MouseHandler mouseHandler;
	
	/**
	 * Constructs a new DrawingPanel.
	 */
	public DrawingPanel() {
		mouseHandler = new MouseHandler(this);
		addMouseListeners(mouseHandler);
	}

	/*
	 * Swing registers the mouse clicks and movements on this panel. That means we need to register
	 * the new MouseHandler class as listener for this panel.
	 */
	private void addMouseListeners(MouseHandler mouseHandler) {
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
	}

	/*
	 * This method is drawing the whole screen again. That means we do not just draw the last line, but all lines again!
	 * This is why we save them in a list to redraw them again.
	 * This might be problematic later on from a performance perspective if we have a lot of lines drawn already.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		/*
		 * To know what needs to be painted, we need to ask the MouseHandler, because this one keeps a list
		 * of all points the mouse moved to.
		 */
		List<Point> points = mouseHandler.getPoints();
		Point lastPoint = null;
		g.setColor(Color.RED);
		/*
		 * We draw simply lines between all points the mouse visited so far.
		 */
		for (Point point : points) {
			if (lastPoint != null) {
				g.drawLine(point.x, point.y, lastPoint.x, lastPoint.y);
			}
			lastPoint = point;
		}
	}
}