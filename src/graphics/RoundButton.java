package graphics;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundButton extends JButton {
	
	int x = 0;
	int y = 0;
	
	/* 생성자 */
	public RoundButton() {
		super();
		decorate();
	}
	
	public RoundButton(String text) {
		super(text);
		decorate();
	}
	
	public RoundButton(Action act) {
		super(act);
		decorate();
	}
	
	public RoundButton(Icon icon) {
		super(icon);
		decorate();
	}
	
	public RoundButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}
	
	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}
	
	public void setRoundButton(int x, int y) {
		this.x = x;
		this.y = y;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		
		Graphics2D gr = (Graphics2D) g;
		gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(getModel().isArmed()) {
			gr.setColor(getBackground().darker());
		}else if(getModel().isRollover()) {
			gr.setColor(getBackground().brighter());
		}else {
			gr.setColor(getBackground());
		}
		
		gr.fillRoundRect(0, 0, width, height, x, y);
		
		FontMetrics fm = gr.getFontMetrics();
		Rectangle stringBounds = fm.getStringBounds(this.getText(), gr).getBounds();
		
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fm.getAscent();
		
		gr.setColor(getForeground());
		gr.setFont(getFont());
		gr.drawString(getText(), textX, textY);
		gr.dispose();
		
		super.paintComponent(g);
	}
}
