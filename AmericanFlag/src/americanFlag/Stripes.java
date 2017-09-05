package americanFlag;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The Stripes Class creates a single stripe after being passed in x, y, dimensions and a color
 * @author ameliamao
 */
public class Stripes extends Flag {
	/**
	 * instance variables
	 */
	private Color color;
	private double stripeHeight;
	private double stripeWidth;
	private int x,y;
	
	/**
	 * Constructor for the stripe
	 * @param xVal: X value of the top left corner of the stripe
	 * @param yVal: Y value of the top left corner of the stripe
	 * @param width: Width of stripe
	 * @param height: Height of stripe
	 * @param color: Color of stripe
	 */
	public Stripes(int xVal, int yVal, double width, double height, Color color) {
		this.x = xVal;
		this.y = yVal;
		this.color = color;
		this.stripeHeight = height;
		this.stripeWidth = width;
	}
	

	/**
	 * draws stripe
	 * @param g: graphics object
	 */
	public void draw(Graphics g){
		g.setColor(this.color);
		g.fillRect(this.x, this.y, (int) this.stripeWidth, (int) this.stripeHeight);
	}
}