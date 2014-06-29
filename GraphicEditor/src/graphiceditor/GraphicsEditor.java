package graphiceditor;


/*
 * I did some changes to the code, Ankita, have a look. I will put my comments
 * in these normal block comments. 
 *
 */
/**
 * Entry point for the Graphic Editor program.
 *
 */
public class GraphicsEditor {

	/**
	 * Starts the Graphic Editor.
	 * @param args no parameters are required.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome");
		/*
		 * This is a new Java 8 feature, and will only compile if you have Java
		 * 8 installed. This is a so called lambda expression and replaces
		 * basically this code: new Runnable() {
		 * 
		 * @Override public void run() { createEditor(); } }
		 */
		javax.swing.SwingUtilities.invokeLater(() -> createEditor());
	}

	/*
	 * Previously we created a JFrame here and set various attributes on it to display it.
	 * In general I prefer to extract into a new class. We create a specific JFrame with 
	 * a specific set of data and operations, which qualifies for creating a new class.
	 * Also we don't have to use static methods then, we just have a normal class. 
	 */
	private static void createEditor() {
		EditorFrame frame = new EditorFrame();
		frame.display();
	}
}
