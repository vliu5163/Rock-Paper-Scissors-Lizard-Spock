/**
 * The interface ThrowTypes. Each of the five throw types implements
 * this interface. All the methods in this interface are getter/setter
 * methods. Provides the structure for retrieving all the information
 * about a throw.
 * @author Vivian Liu
 * 
 */
import java.awt.Color;

public interface ThrowTypes {
	String getThrowName();
	String getFontName();
	int getFontSize();
	Color getColor();
	
	int getXCoord();
	int getYCoord();
	int getXVelocity();
	int getYVelocity();
	
	void setXCoord(int xChange);
	void setYCoord(int yChange);
}
