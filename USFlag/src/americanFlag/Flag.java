package americanFlag;
import javax.swing.JApplet;
import java.awt.*;

/**
 * The Flag Class is an applet that draws a scalable US Flag
 * @author ameliamao
 */
public class Flag extends JApplet {
	
	//scale factors for flag according to the specification
	public final static double B = 1.9;
	public final static double C = 7.0 / 13.0;
	public final static double D = 0.76;
	public final static double F = 0.054;
	public final static double G = 0.063;
	public final static double K = 0.0616;
	public final static double L = 1.0 / 13.0;
	
	//flag colors
	public final Color NAVY_BLUE = new Color(0, 40, 104);
	public final Color DARK_RED = new Color(191, 10, 48);
	
	double height, width; //height and width of window


	/**
	 * draws scalable flag
	 * @param g: graphics object
	 */
	public void paint(Graphics g) {

		//sets and draws white background of the applet
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int) getWidth(), (int) getHeight());

		//logic for getting the flag to scale according to the width and height of the window
		if (getHeight() * B <= getWidth()) {
			width = getHeight() * B;
			height = getHeight();
		} else if (getHeight() * B > getWidth()) {
			width = getWidth();
			height = width / B;
		}
		
		drawStripes(g);
		drawUnion(g);
	}

	/**
	 * draws the 13 stripes of flag according to dimensions of window and correct color
	 * @param g: graphics object
	 */
	public void drawStripes(Graphics g) {
		Stripes[] stripes = new Stripes[13]; //creates an array of 13 stripes

		for (int i = 0; i < 13; i++) {
			if (i % 2 == 0) {
				stripes[i] = new Stripes(0, (int) (height * L * i), (int) width, (int) (height * L), DARK_RED);
			} else {
				stripes[i] = new Stripes(0, (int) (height * L * i), (int) width, (int) (height * L), Color.WHITE);
			}
		}

		for (int i = 0; i < 13; i++) {
			stripes[i].draw(g);
		}
	}

	/**
	 * creates a blue rectangle(the union) based on specifications of flag
	 * and draws the stars on top of it
	 * @param g: graphics object
	 */
	public void drawUnion(Graphics g) {
		final double UNION_OFFSET = 1.31; //offset for stars to be in the correct place on union
		g.setColor(NAVY_BLUE);
		g.fillRect(0, 0, (int) (D * height), (int) (C * height));
		Stars star = new Stars(Color.WHITE);
		star.draw(g, (int) (C * height * UNION_OFFSET), (int) (D * height * UNION_OFFSET));
	}
}
