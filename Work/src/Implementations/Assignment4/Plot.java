package Implementations.Assignment4;

/**
 * Class to represent a property's position on a cartesian grid,
 * with the ability to check for encompassing or overlap.
 *
 * @author James Pham
 */
public class Plot {
  //instance variables
  private int x1, y1, x2, y2, width, depth;

  /**
   * Default constructor with no arguments, defaults all fields to (0,0) with a width and depth of 1
   */
  public Plot(){
    x1 = 0;
    y1 = 0;
    width = 1;
    depth = 1;
    x2 = x1 + width;
    y2 = y1 - depth;
  }

  /**
   * Constructor with one argument to easily copy over properties of another plot object
   * @param p the provided Plot object
   */
  public Plot(Plot p){
    x1 = p.getX();
    y1 = p.getY();
    width = p.getWidth();
    depth = p.getDepth();
    x2 = x1 + width;
    y2 = y1 - depth;
  }

  /**
   * The standard paramaterized constructor to define plot properties
   * @param x x coordinate of upper left corner of plot
   * @param y y coordinate of upper left corner of plot
   * @param width how much to expand in the x direction
   * @param depth how much to expand in the y direction
   */
  public Plot(int x, int y, int width, int depth){
    this.x1 = x;
    this.y1 = y;
    this.width = width;
    this.depth = depth;
    x2 = x1 + width;
    y2 = y1 - depth;
  }

  /**
   * Checks for overlap with plot specified in parameter
   * @param p Plot object
   * @return if current reference overlaps plot parameter
   */
  public boolean overlaps(Plot p){
    //if the upper corner is lower than the lower corner of plot p
    //or the lower corner is lower than the upper corner of plot p
    //assume overlap
    //todo BROKEN
    System.out.println("Upper Left" + this.getX() + " " + this.getY() + " " + "Lower right" + this.getXLower() + " " + this.getYLower());
    System.out.println("Upper Left" + p.getX() + " " + p.getY() + " " + "Lower right" + p.getXLower() + " " + p.getYLower());
    boolean xWithinBounds = this.getX() < p.getXLower() || this.getXLower() < p.getX();
    boolean yWithinBounds = this.getY() < p.getYLower() || this.getYLower() < p.getY();
    return xWithinBounds || yWithinBounds;
  }

  /**
   * Checks for containment of plot specified in parameter
   * @param p Plot object
   * @return if current reference is larger than plot parameter
   */
  public boolean encompasses(Plot p){
    //if the upper corner and lower corners of plot p are less than the upper and lower corners
    //of this plot, assume containment
    boolean upperCornerCheck = this.getX() <= p.getX() && this.getY() <= p.getY();
    boolean lowerCornerCheck = this.getXLower() >= p.getXLower() && this.getYLower() <= p.getYLower();
    return upperCornerCheck && lowerCornerCheck;
  }

  /**
   * set X coordinate of plot
   * @param x the new X coordinate
   */
  public void setX(int x){
    this.x1 = x;
    x2 = x1 + width;
  }

  /**
   * get current X coordinate of plot
   * @return the current X coordinate
   */
  public int getX(){
    return x1;
  }

  /**
   * Private method for internally calculating overlap
   * @return the lower right X coordinate
   */
  private int getXLower(){
    return x2;
  }

  /**
   * set Y coordinate of plot
   * @param y the new Y coordinate
   */
  public void setY(int y){
    this.y1 = y;
    y2 = y1 - depth;
  }

  /**
   * get current Y coordinate of plot
   * @return the current Y coordinate
   */
  public int getY(){
    return y1;
  }

  /**
   * Private method for internally calculating overlap
   * @return the lower right Y coordinate
   */
  private int getYLower(){
    return y2;
  }

  /**
   * set the width of the plot
   * @param width the new width
   */
  public void setWidth(int width){
    this.width = width;
    x2 = x1 + width;
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
    y2 = y1 - depth;
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
    return "Upper left: (" + x1 + "," + y1 + "); Width: " + width + " Depth: " + depth;
  }

}
