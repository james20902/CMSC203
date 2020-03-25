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



}
