package Implementations.Assignment4;

/**
 * Class to represent a property's position on a cartesian grid,
 * with the ability to check for encompassing or overlap.
 *
 * @author James Pham
 */
public class Plot {
  //instance variables
  private int x, y, width, depth;

  /**
   * Default constructor with no arguments, defaults all fields to (0,0) with a width and depth of 1
   */
  public Plot(){
    x = 0;
    y = 0;
    width = 1;
    depth = 1;
  }

  /**
   * Constructor with one argument to easily copy over properties of another plot object
   * @param p the provided Plot object
   */
  public Plot(Plot p){
    x = p.getX();
    y = p.getY();
    width = p.getWidth();
    depth = p.getDepth();
  }

  /**
   * The standard paramaterized constructor to define plot properties
   * @param x x coordinate of upper left corner of plot
   * @param y y coordinate of upper left corner of plot
   * @param width how much to expand in the x direction
   * @param depth how much to expand in the y direction
   */
  public Plot(int x, int y, int width, int depth){
    this.x = x;
    this.y = y;
    this.width = width;
    this.depth = depth;
  }

  /**
   * Checks for overlap with plot specified in parameter
   * @param p Plot object
   * @return if current reference overlaps plot parameter
   */
  public boolean overlaps(Plot p){

    return false;
  }

  /**
   * Checks for containment of plot specified in parameter
   * @param p Plot object
   * @return if current reference is larger than plot parameter
   */
  public boolean encompasses(Plot p){
    //assumes two sides are within bounds
    boolean coordWithinBounds = (x >= p.getX()) && (y <= p.getY());
    return false;
  }

  /**
   * set X coordinate of plot
   * @param x the new X coordinate
   */
  public void setX(int x){
    this.x = x;
  }

  /**
   * get current X coordinate of plot
   * @return the current X coordinate
   */
  public int getX(){
    return x;
  }

  /**
   * set Y coordinate of plot
   * @param y the new Y coordinate
   */
  public void setY(int y){
    this.y = y;
  }

  /**
   * get current Y coordinate of plot
   * @return the current Y coordinate
   */
  public int getY(){
    return y;
  }

  /**
   * set the width of the plot
   * @param width the new width
   */
  public void setWidth(int width){
    this.width = width;
  }

  /**
   * get the current width of the plot
   * @return the current width
   */
  public int getWidth(){
    return width;
  }

  /**
   * set the depth of the plot
   * @param depth the new width
   */
  public void setDepth(int depth){
    this.depth = depth;
  }

  /**
   * get current depth coordinate of plot
   * @return the current depth
   */
  public int getDepth(){
    return depth;
  }

  /**
   * overridden toString
   * @return Upper left: (x,y); Width: w Depth: d
   */
  @Override
  public String toString(){
    return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
  }

}
