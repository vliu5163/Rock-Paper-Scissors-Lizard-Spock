/**
 * For my creativity portion, I decided to do the Death Stars. 
 * @author Vivian Liu, extended code by jrk based on cay horstmann
 * Here is the HTML file used in my code (also included as an HTML file
 * in the same folder as this project):
 * 
 * <applet code="Playground.class" width="500" height="500">
	<param name="deathStarDiameter" value="50" />
	<param name="delay" value="100" />
	<param name="throw1" value="rock" />
	<param name="throw2" value="paper" />
	<param name="throw3" value="scissors" />
	<param name="throw4" value="spock" />
	<param name="throw5" value="lizard" />
	<param name="velocity" value="1" />
	<param name="xStart1" value="0" />
	<param name="xStart2" value="100" />
	<param name="xStart3" value="50" />
	<param name="xStart4" value="50" />
	<param name="xStart5" value="400" />
	<param name="xVelocity1" value=1" />
	<param name="xVelocity2" value=-1" />
	<param name="xVelocity3" value=1" />
	<param name="xVelocity4" value=1" />
	<param name="xVelocity5" value=-1" />
	<param name="yStart1" value=0" />
	<param name="yStart2" value=100" />
	<param name="yStart3" value=50" />
	<param name="yStart4" value=400" />
	<param name="yStart5" value=400" />
	<param name="yVelocity1" value=1" />	
	<param name="yVelocity2" value=-1" />
	<param name="yVelocity3" value=0" />
	<param name="yVelocity4" value=-1" />
	<param name="yVelocity5" value=-1" />
 * </applet>
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.Timer;

public class Playground extends Applet {

	/**
	 * Adds a MouseListener for Step 5
	 */
	public Playground() {
		addMouseListener(new Playground.MouseHandler());
	}
	
	/**
	 * init() method acts as the runner for the project. In this method,
	 * extracts all the relevant information about a throw (the starting
	 * coordinates, velocities, and throw type) from the HTML and adds the 
	 * throws to a list. Then creates a list of Rectangles based on these
	 * values. Based on the velocity, increments the positions of the throws
	 * and Rectangles.  
	 */
	public void init() {
		for (int i = 1; i < NUM_THROWS + 1; i++) {
			String throwType = "throw" + i;
			String throwName = getParameter(throwType);
			String xVelocity = "xVelocity" + i;
			int xVel = Integer.parseInt(getParameter(xVelocity));
			String yVelocity = "yVelocity" + i;
			int yVel = Integer.parseInt(getParameter(yVelocity));
			String xStart = "xStart" + i;
			int xStartCoord = Integer.parseInt(getParameter(xStart));
			String yStart = "yStart" + i;
			int yStartCoord = Integer.parseInt(getParameter(yStart));
			generateList(throwName, xVel, yVel, xStartCoord, yStartCoord);
		}
		Graphics2D g2D = (Graphics2D) getGraphics();
		// FontRenderContext throwContext = g2D.getFontRenderContext();
		for (int i = 0; i < myThrowList.size(); i++) {
			throwFont = new Font(myThrowList.get(i).getFontName(), 
					Font.BOLD, myThrowList.get(i).getFontSize());
			FontRenderContext throwContext = g2D.getFontRenderContext();
			throwRectangle = throwFont.getStringBounds(myThrowList.get(i).getThrowName(),
					throwContext);
			Rectangle wordRectangle = new Rectangle(myThrowList.get(i).getXCoord(),
					myThrowList.get(i).getYCoord(), (int)throwRectangle.getWidth(),
					(int)throwRectangle.getHeight());
			myRectangles.add(wordRectangle);
		}
		htmlDelay = Integer.parseInt(getParameter("delay"));
		diameter = Integer.parseInt(getParameter("deathStarDiameter"));
		appletTimer = new Timer(htmlDelay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkIntersections();
				checkDeathStar();
				for (int i = 0; i < myThrowList.size(); i++) {
					int newXCoord = myThrowList.get(i).getXCoord() + 
							myThrowList.get(i).getXVelocity();
					int newYCoord = myThrowList.get(i).getYCoord() + 
							myThrowList.get(i).getYVelocity();
					myRectangles.get(i).setRect(newXCoord, newYCoord, 
							myRectangles.get(i).getWidth(), myRectangles.get(i).getHeight());
					myThrowList.get(i).setXCoord(newXCoord);
					myThrowList.get(i).setYCoord(newYCoord);
					if (newXCoord + myRectangles.get(i).getWidth() < 0) {
						myThrowList.get(i).setXCoord(getWidth());
						int yCoord = myThrowList.get(i).getYCoord();
						myRectangles.get(i).setRect(getWidth(), yCoord, myRectangles.get(i).getWidth(),
								myRectangles.get(i).getHeight());
					}
					if (newXCoord - myRectangles.get(i).getWidth() > getWidth()) {
						myThrowList.get(i).setXCoord(-(int)myRectangles.get(i)
								.getWidth());
						int yCoord = myThrowList.get(i).getYCoord();
						myRectangles.get(i).setRect(-myRectangles.get(i).getWidth(), yCoord, 
								myRectangles.get(i).getWidth(), myRectangles.get(i).getHeight());
					}
					if (newYCoord + myRectangles.get(i).getHeight() < 0) {
						myThrowList.get(i).setYCoord(getHeight());
						int xCoord = myThrowList.get(i).getXCoord();
						myRectangles.get(i).setRect(xCoord, getHeight(), 
								myRectangles.get(i).getWidth(), myRectangles.get(i).getHeight());
					}
					if (newYCoord - myRectangles.get(i).getHeight() > getHeight()) {
						myThrowList.get(i).setYCoord(-(int)myRectangles.get(i).getHeight());
						int xCoord = myThrowList.get(i).getXCoord();
						myRectangles.get(i).setRect(xCoord, -myRectangles.get(i).getHeight(), 
								myRectangles.get(i).getWidth(), myRectangles.get(i).getHeight());
					}
				}
				repaint();
			}
		});
	}

	/**
	 * Start the timer
	 */
	public void start() {
		appletTimer.start();
	}
	
	/**
	 * The paint method paints both the throw and the Death Stars.
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < myThrowList.size(); i++) {
			throwFont = new Font(myThrowList.get(i).getFontName(), 
					Font.BOLD, myThrowList.get(i).getFontSize());
			g.setColor(myThrowList.get(i).getColor());
			g.setFont(throwFont);
			g.drawString(myThrowList.get(i).getThrowName(), 
					myThrowList.get(i).getXCoord(), myThrowList.get(i).getYCoord());
		}
		for (int j = 0; j < myDeathStars.size(); j++) {
			g.setColor(Color.BLACK);
			g2.fill(myDeathStars.get(j));
		}
	}

	/**
	 * Stop the timer.
	 */
	public void stop() {
		appletTimer.stop();
	}

	public void destroy() {
		
	}
	
	/**
	 * Generates objects of type ThrowType based on the parameters extracted
	 * from the HTML file.
	 * @param throwName
	 * @param xVelocity
	 * @param yVelocity
	 * @param xStart
	 * @param yStart
	 */
	public void generateList(String throwName, int xVelocity, int yVelocity,
			int xStart, int yStart) {
		if (throwName.equals("rock")) {
			RockThrow myRockThrow = new RockThrow(xStart, yStart,
					xVelocity, yVelocity);
			myThrowList.add(myRockThrow);
		}
		else if (throwName.equals("paper")) {
			PaperThrow myPaperThrow = new PaperThrow(xStart, yStart,
					xVelocity, yVelocity);
			myThrowList.add(myPaperThrow);
		}
		else if (throwName.equals("scissors")) {
			ScissorsThrow myScissorsThrow = new ScissorsThrow(xStart, yStart,
					xVelocity, yVelocity);
			myThrowList.add(myScissorsThrow);
		}
		else if (throwName.equals("spock")) {
			SpockThrow mySpockThrow = new SpockThrow(xStart, yStart,
					xVelocity, yVelocity);
			myThrowList.add(mySpockThrow);
		}
		else {
			LizardThrow myLizardThrow = new LizardThrow(xStart, yStart,
					xVelocity, yVelocity);
			myThrowList.add(myLizardThrow);
		}
	}

	/**
	 * Checks to see if any of the throws intersect each other based on their
	 * Rectangles. If they do, uses a Calculator object to determine if it's a
	 * win, tie, or loss, and removes from the list of ThrowTypes based on the result.
	 */
	public void checkIntersections() {
		for (int i = 0; i < myRectangles.size(); i++) {
			for (int j = i + 1; j < myRectangles.size(); j++) {
				if (myRectangles.get(i).intersects(myRectangles.get(j))) {
					int result = myCalculator.calculate(myThrowList.get(i), 
							myThrowList.get(j));
					if (result == -1) {
						myThrowList.remove(i);
						myRectangles.remove(i);
					}
					else if (result == 1) {
						myThrowList.remove(j);
						myRectangles.remove(j);
					}
				}

			}
		}
	}

	/**
	 * Checks to see if any of the throws intersect any of the user's death stars. 
	 * If they do, then removes the throw from the list of ThrowTypes.
	 */
	public void checkDeathStar() {
		for (int i = 0; i < myRectangles.size(); i++) {
			for (int j = 0; j < myDeathStars.size(); j++) {
				if (i < myRectangles.size() && circleIntersectsRectangle(myRectangles.get(i), 
						myDeathStars.get(j)) && j < myDeathStars.size()) {
					myRectangles.remove(i);
					myThrowList.remove(i);
				}
			}
		}
	}
	
	/**
	 * Checks if a circle intersects a rectangle. 
	 * @param rect
	 * @param circle
	 * @return true if it intersects
	 */
	public boolean circleIntersectsRectangle(Rectangle2D rect, Ellipse2D circle){
	    if (circle.intersects(rect)) {
	    	return true;
	    }
	    return false;
	}
	
	/**
	 * MouseHandler class. Necessary to see where the user clicks to determine where to
	 * drop the Death Star.
	 * @author Vivian Liu, based on code from CourseWorks by jrk
	 *
	 */
	private class MouseHandler implements MouseListener {
		public void mousePressed(MouseEvent e) {
			
		}
		
		/**
		 * Based on where the user clicks their mouse, extracts those coordinates and 
		 * produces an Ellipse2D representing the Death Star and adds them to a list.
		 */
		public void mouseClicked(MouseEvent e) {
			double x = e.getX();
			double y = e.getY();
			Ellipse2D.Double deathStar = new Ellipse2D.Double(x - diameter/2, y - diameter/2,
					diameter, diameter);
			myDeathStars.add(deathStar);
			System.out.println(myDeathStars.size());
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}
	
	private static ArrayList<ThrowTypes> myThrowList = new ArrayList<>();
	private static ArrayList<Rectangle2D> myRectangles = new ArrayList<>();
	private static ArrayList<Ellipse2D> myDeathStars = new ArrayList<>();
	
	private static final int NUM_THROWS = 5;
	private static Calculator myCalculator = new Calculator();
	
	// html parameters
	private int htmlDelay;
	private Font throwFont;
	private Rectangle2D throwRectangle;
	private int diameter;

	// timer stuff
	private Timer appletTimer;
}
