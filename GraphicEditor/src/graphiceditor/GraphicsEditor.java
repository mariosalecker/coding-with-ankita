package graphiceditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphicsEditor extends JPanel implements ActionListener {

	public static void main(String[] args) {
		System.out.println("Welcome");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				createEditor();
			}
		});
	}
	
	public static void createEditor(){
		JFrame frame = new JFrame("GraphicEditor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Paint");
		frame.getContentPane().add(label);
		frame.setSize(1800, 600);
		frame.setLocation(300, 300);
		frame.setResizable(false);
		
		JPanel panel = new JPanel() {
	        Point pointStart = null;
	        Point pointEnd   = null;
	        {
	            addMouseListener(new MouseAdapter() {
	                public void mousePressed(MouseEvent e) {
	                    pointStart = e.getPoint();
	                }

	                public void mouseReleased(MouseEvent e) {
	                    pointStart = null;
	                }
	            });
	            addMouseMotionListener(new MouseMotionAdapter() {
	                public void mouseMoved(MouseEvent e) {
	                    pointEnd = e.getPoint();
	                }

	                public void mouseDragged(MouseEvent e) {
	                    pointEnd = e.getPoint();
	                    repaint();
	                }
	            });
	        }
	    
		
	    public void paint(Graphics g) {
		        super.paint(g);
		        if (pointStart != null) {
		            g.setColor(Color.RED);
		            g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
		        }
		    }
		};
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

   
}
