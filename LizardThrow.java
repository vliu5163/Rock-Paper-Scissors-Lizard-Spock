/**
 * The LizardThrow class. Implements the interface ThrowTypes. Stores all the information 
 * about a throw including the throw name, font name, font size, Color, xCoord and yCoord
 * of current position, and x and y velocities. Also has two setter methods to change the 
 * x and y positions. 
 * All methods in this class are getter/setter methods.
 * @author Vivian Liu
 */
import java.awt.Color;

public class LizardThrow implements ThrowTypes{
	public LizardThrow(int xStartIn, int yStartIn, int xVelocityIn, int yVelocityIn) {
		xCoord = xStartIn;
		yCoord = yStartIn;
		xVelocity = xVelocityIn;
		yVelocity = yVelocityIn;
	}

	@Override
	public String getThrowName() {
		// TODO Auto-generated method stub
		return THROW_NAME;
	}
	@Override
	public String getFontName() {
		// TODO Auto-generated method stub
		return FONT_NAME;
	}
	@Override
	public int getFontSize() {
		// TODO Auto-generated method stub
		return 20;
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return LIZARD_GREEN;
	}
	@Override
	public int getXCoord() {
		// TODO Auto-generated method stub
		return xCoord;
	}
	@Override
	public int getYCoord() {
		// TODO Auto-generated method stub
		return yCoord;
	}
	@Override
	public int getXVelocity() {
		// TODO Auto-generated method stub
		return xVelocity;
	}
	@Override
	public int getYVelocity() {
		// TODO Auto-generated method stub
		return yVelocity;
	}
	@Override
	public void setXCoord(int newXCoord) {
		// TODO Auto-generated method stub
		xCoord = newXCoord;
	}
	@Override
	public void setYCoord(int newYCoord) {
		// TODO Auto-generated method stub
		yCoord = newYCoord;
	}
	
	private int xCoord;
	private int yCoord;
	private int xVelocity;
	private int yVelocity;
	
	private final String THROW_NAME = "lizard";
	private final String FONT_NAME = "Comic Sans";
	private final int FONT_SIZE = 20;
	private final Color LIZARD_GREEN = new Color(6, 125, 61);
}
