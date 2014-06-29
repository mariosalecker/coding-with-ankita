package graphiceditor;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main Editor frame for displaying the editor.
 *
 */
public class EditorFrame extends JFrame {
	/*
	 * Constant values should be extracted and meaningful labeled.
	 */
	/**
	 * Initial window size
	 */
	private static final Dimension DEFAULT_PREFERRED_SIZE = new Dimension(800, 600);

	/**
	 * Constructs a new Editor frame.
	 */
	public EditorFrame() {
		super("Graphic Editor");
		/*
		 * I tried to group the operations on the frame a bit. The following three operations are something that the
		 * frame needs to have on creation time, so they are part of the constructor.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationAndSize();
		/*
		 * We only have one component so far in the frame, a panel (I removed the label, because it served no purpose so
		 * far, I think...), but still this is a very different operation from the rest. Here we construct the display,
		 * which certainly should not be mixed with the rest of setup of the frame. Also it shows where to add further
		 * components in the future if required.
		 */
		addComponents();
	}

	private void setLocationAndSize() {
		/*
		 * The setLocation method defines the upper left position of the frame. Just setting this to 300,300 is very
		 * arbitary, let's better compute the best location for it. There we need to consider the different screen
		 * sizes.
		 * For this we take compute (screen width - window width) / 2 and the same for the height.
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - DEFAULT_PREFERRED_SIZE.width) / 2,
				(screenSize.height - DEFAULT_PREFERRED_SIZE.height) / 2);
		setPreferredSize(DEFAULT_PREFERRED_SIZE);
	}

	/*
	 * Important are the right visibility qualifiers. addComponents is an internal method (which is why a JavaDoc
	 * comment is more optional) and not used from the outside. It is just there to structure our code a bit.
	 */
	private void addComponents() {
		/*
		 * I extracted the Panel functionality again in a separate class, because it does a lot on its own.
		 */
		JPanel panel = new DrawingPanel();
		add(panel);
	}

	/*
	 * These two operations serve the display of the editor frame. I extracted them in a separate method because it
	 * would allow to construct the editor, then to further configure it and finally show it.
	 */
	/**
	 * Displays the editor frame.
	 */
	public void display() {
		pack();
		setVisible(true);
	}
}
