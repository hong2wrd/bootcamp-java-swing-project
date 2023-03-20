package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class RoundPanel extends JPanel {
	
	private int topLeft = 0;
	private int topRight = 0;
	private int botLeft = 0;
	private int botRight = 0;
	
	public void setRoundPanel(int topLeft, int topRight, int botLeft, int botRight) {
		setTopLeft(topLeft);
		setTopRight(topRight);
		setBotLeft(botLeft);
		setBotRight(botRight);
	}

	public int getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(int topLeft) {
		this.topLeft = topLeft;
		repaint();
	}

	public int getTopRight() {
		return topRight;
	}

	public void setTopRight(int topRight) {
		this.topRight = topRight;
		repaint();
	}

	public int getBotLeft() {
		return botLeft;
	}

	public void setBotLeft(int botLeft) {
		this.botLeft = botLeft;
		repaint();
	}

	public int getBotRight() {
		return botRight;
	}

	public void setBotRight(int botRight) {
		this.botRight = botRight;
		repaint();
	}
	
	public RoundPanel() {
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(getBackground());
		Area area = new Area(createRoundTopLeft());
		if(topRight > 0) {
			area.intersect(new Area(createRoundTopRight()));
		}
		
		if(botLeft > 0) {
			area.intersect(new Area(createRoundBotLeft()));
		}
		
		if(botRight > 0) {
			area.intersect(new Area(createRoundBotRight()));
		}
		
		g2.fill(area);
		
		g2.dispose();
		
		super.paintComponent(g);
	}
	
	private Shape createRoundTopRight() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, topRight);
		int roundY = Math.min(height, topRight);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
		return area;
	}
	
	private Shape createRoundTopLeft() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, topLeft);
		int roundY = Math.min(height, topLeft);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
		return area;
	}
	
	private Shape createRoundBotRight() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, botRight);
		int roundY = Math.min(height, botRight);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
		return area;
	}
	
	private Shape createRoundBotLeft() {
		int width = getWidth();
		int height = getHeight();
		int roundX = Math.min(width, botLeft);
		int roundY = Math.min(height, botLeft);
		Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
		area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
		area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
		return area;
	}
}
