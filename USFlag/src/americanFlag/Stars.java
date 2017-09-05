package americanFlag;
import java.awt.*;
import java.lang.Math ;

/**
 * generates the stars on the union based on current size of flag
 * @author ameliamao
 */
public class Stars {
	private Color color;
	
	/**
	 * constructor for a star
	 * @param color: color of the star
	 */
	public Stars(Color color) {
		this.color = color;
	}

	/**
	 * draws the 50 stars on the union
	 * @param g: Graphics object
	 * @param actualWidth: the width of the union(the blue rectangle)
	 * @param actualHeight: the height of the union
	 */
	public void draw(Graphics g, int actualWidth, int actualHeight) {
		g.setColor(color);

		//integer arrays for the x and y coordinates of a star(one x and one y value for each vertex)
		int[] xPoints = new int[10];
		int[] yPoints = new int[10];

		//Outer radius of star: calculated by multiplying actualHeight by the radius on one star.
		//Radius is calculated from the provided diameter divided by 2
		double r1 = actualHeight * (Flag.K / 2);
		
		/* inner radius of star: calculated using trigonometry relations between right-most point and left-most point
		 * on the star assuming the y-coordinates of both points are the same
		 */
		double r2 = r1 * Math.sin(Math.toRadians(18)) / Math.sin(Math.toRadians(54));
		
		for(int row = 0; row < 9; row++) {
			/* The number of stars per row initially begin at 6 for the first row and alternate between
			 * 5 and 6 for each successive row.
			 */
			int starsPerRow = (row % 2 == 0) ? 6 : 5;

			/* The initial star x offset is initially 1 for the first row, but alternates between 2
			 * and 1 for each successive row.
			 */
			int initialStarXOffset = (row % 2 == 0) ? 1 : 2;

			for(int col = 0; col < starsPerRow; col++) {
				//coordinates for center of star
				int starCenterX = (int)((actualHeight * Flag.G) * (initialStarXOffset + 2 * col));
				int starCenterY = (int)((actualHeight * Flag.F) * (1 + row));

				/* Assigns the x and y values of each star based on whether the point is an outer point or an inner point.
				 * Points are calculated based on the center x and y coordinates and with the trigonometric sin and cos
				 * functions. The angle measure is incremented by 36 degrees for each iteration of the for loop, for
				 * use in the cos and sin functions.
				 */
				for(int i = 0; i < 10; i++) {
					xPoints[i] = (i % 2) == 0 ? starCenterX + (int)(r1 * Math.cos(Math.toRadians(18 + 36 * i))) : starCenterX + (int)(r2 * Math.cos(Math.toRadians(54 + 36 * (i - 1))));
					yPoints[i] = (i % 2) == 0 ? starCenterY - (int)(r1 * Math.sin(Math.toRadians(18 + 36 * i))) : starCenterY - (int)(r2 * Math.sin(Math.toRadians(54 + 36 * (i - 1))));
				}
				g.fillPolygon(xPoints, yPoints, 10); //draws the star
			}
		}
	}
}