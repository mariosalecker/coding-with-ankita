package graphiceditor;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Handling of the mouse movement
 *
 */
public class MouseHandler extends MouseAdapter {

	/*
	 * Component the mouse handler is acting on.
	 */
	private Component component;
	
	/*
	 * List of points the mouse was dragged to.
	 */
	private List<Point> points = new ArrayList<>();

	/**
	 * Construcuts a new Mousehandler on the given component.
	 * @param component The component the mouse handler is listener of.
	 */
	public MouseHandler(Component component) {
		this.component = component;
	}

	/*
	 * This is the relevant event for us, not mouseMoved. mouseMoved is triggered whenever the
	 * mouse buttons are not pressed, mouseDragged whenever the mouse buttons are pressed (and
	 * the mouse is moved of course).
	 * We just add all new points while the mouse is moved with a button down in a list.
	 * After each event we redraw the screen to reflect the new line segment.
	 * 
	 * There is a problem of course. You see we do not handle the mousePressed and mouseReleased events.
	 * This means when we draw the lines they will be drawn as one single lines instead of individual line
	 * segments. This we have to tackle next.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		points.add(e.getPoint());
		component.repaint();
	}
	
	public List<Point> getPoints() {
		return points;
	}
}
