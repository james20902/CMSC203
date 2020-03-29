package Implementations.Assignment4;

/**
 * Class to represent a property along with information about location,
 * owner, and rent.
 *
 * @author James Pham
 */
public class Property {

  //instance variables
  private String city, owner, property;
  private double rentAmount;
  private Plot plot;

  /**
   * Default constructor with no arguments, empty strings, 0 rent, and default plot object
   */
  public Property(){
    city = "";
    owner = "";
    property = "";

    rentAmount = 0;

    plot = new Plot();
  }

  /**
   * Constructor with one argument to easily copy over properties of another property object
   * @param p the provided property object
   */
  public Property(Property p){
    city = p.getCity();
    owner = p.getOwner();
    property = p.getPropertyName();

    rentAmount = getRentAmount();

    plot = p.plot;
  }

  /**
   * Constructor with parameters besides Plot information
   * @param propertyName the name of the property
   * @param city the name of the city the property is located in
   * @param rentAmount the rent amount on a monthly basis
   * @param owner the name of the owner
   */
  public Property(String propertyName, String city, double rentAmount, String owner){
    this.city = city;
    this.owner = owner;
    this.property = propertyName;

    this.rentAmount = rentAmount;

    plot = new Plot();
  }

  /**
   * Completely parameterized constructor
   * @param propertyName the name of the property
   * @param city the name of the city the property is located in
   * @param rentAmount the rent amount on a monthly basis
   * @param owner the name of the owner
   * @param x the X coordinate of the plot
   * @param y the Y coordinate of the plot
   * @param width how much to expand the plot in the x direction
   * @param depth how much to expand the plot in the y direction
   */
  public Property(String propertyName,
      String city,
      double rentAmount,
      String owner,
      int x,
      int y,
      int width,
      int depth){
    this.city = city;
    this.owner = owner;
    this.property = propertyName;

    this.rentAmount = rentAmount;

    plot = new Plot(x, y, width, depth);
  }

  /**
   * The current location of the property
   * @return the name of the city
   */
  public String getCity(){
    return city;
  }

  /**
   * The current owner of the property
   * @return the name of the owner
   */
  public String getOwner(){
    return owner;
  }

  /**
   * The current name of the property
   * @return the name of the property
   */
  public String getPropertyName(){
    return property;
  }

  /**
   * The current rent amount of the property
   * @return the rent amount on a monthly basis
   */
  public double getRentAmount(){
    return rentAmount;
  }

  /**
   * Set property plot
   * @param x x coordinate of upper left corner of plot
   * @param y y coordinate of upper left corner of plot
   * @param width how much to expand in the x direction
   * @param depth how much to expand in the y direction
   * @return the plot created from the parameters
   */
  public Plot setPlot(int x, int y, int width, int depth){
    Plot newPlot = new Plot(x, y, width, depth);
    this.plot = newPlot;

    return newPlot;
  }

  /**
   * current property plot
   * @return plot
   */
  public Plot getPlot(){
    return plot;
  }

  /**
   * Set property location
   * @param city name of the new city
   */
  public void setCity(String city){
    this.city = city;
  }

  /**
   * Set property owner
   * @param owner name of the new owner
   */
  public void setOwner(String owner){
    this.owner = owner;
  }

  /**
   * Set property name
   * @param propertyName new name of the property
   */
  public void setPropertyName(String propertyName){
    this.property = propertyName;
  }

  /**
   * Set new monthly rent cost
   * @param rentAmount new monthly cost
   */
  public void setRentAmount(double rentAmount){
    this.rentAmount = rentAmount;
  }

  /**
   * Overridden default toString
   * @return Property Name: property, Located in city, Belonging to: owner, Rent amount: rent
   */
  @Override
  public String toString(){
    return "Property Name: " + property + "\n"
        + "Located in " + city + "\n"
        + "Belonging to: " + owner + "\n"
        + "Rent amount: " + rentAmount;
  }



}
