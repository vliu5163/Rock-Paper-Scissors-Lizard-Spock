/**
 * The PaperThrow class. Implements the interface ThrowTypes. Stores all the information 
 * about a throw including the throw name, font name, font size, Color, xCoord and yCoord
 * of current position, and x and y velocities. Also has two setter methods to change the 
 * x and y positions. 
 * All methods in this class are getter/setter methods.
 * @author Vivian Liu
 */
import java.awt.Color;

public class PaperThrow implements ThrowTypes {

	public PaperThrow(int xStartIn, int yStartIn, int xVelocityIn, int yVelocityIn) {
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
		return 20;
	}
	@Override
	public Color getColor() {
		return BLACK;
	}
	@Override
	public int getXCoord() {
		return xCoord;
	}
	@Override
	public int getYCoord() {
		return yCoord;
	}
	@Override
	public int getXVelocity() {
		return xVelocity;
	}
	@Override
	public int getYVelocity() {
		return yVelocity;
	}
	@Override
	public void setXCoord(int newXCoord) {
		xCoord = newXCoord;
	}
	@Override
	public void setYCoord(int newYCoord) {
		yCoord = newYCoord;
	}
	
	private int xCoord;
	private int yCoord;
	private int xVelocity;
	private int yVelocity;
	
	private String THROW_NAME = "paper";
	private String FONT_NAME = "Academy Engraved LET";
	private int FONT_SIZE = 20;
	private Color BLACK = Color.BLACK;
}
