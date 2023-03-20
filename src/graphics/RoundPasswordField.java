package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;

public class RoundPasswordField extends JPasswordField {
	
    private Shape shape;
    
    int a = 0;
    int b = 0;
    int c = 0;
    
    int x = 0;
    int y = 0;
    
    public void setRoundPasswordField(int x, int y) {
    	this.x = x;
    	this.y = y;
    	repaint();
    }
    
    public void setBorderColor(int a, int b, int c) {
    	this.a = a;
    	this.b = b;
    	this.c = c;
    	repaint();
    }
    
    public RoundPasswordField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, x, y);
         super.paintComponent(g);
    }
    
    protected void paintBorder(Graphics g) {
//    	 g.setColor(getForeground());
         g.setColor(new Color(a, b, c));
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, x, y);
    }
    
    public boolean contains(int x, int y) {
         if(shape == null || !shape.getBounds().equals(getBounds())) {
        	 shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, x, y);
         }
         
         return shape.contains(x, y);
    }
}
