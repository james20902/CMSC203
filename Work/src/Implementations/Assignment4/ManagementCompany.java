package Implementations.Assignment4;

/**
 * Class to represent company that manages several properties
 *
 * @author James Pham
 */
public class ManagementCompany {
  //constant variables
  public static final int MAX_PROPERTY = 5;
  public static final int MGMT_WIDTH = 10;
  public static final int MGMT_DEPTH = 10;

  //instance variables
  private double mgmFeePer;
  private String name, taxID;
  private Property[] properties;
  private Plot plot;
  private int header = -1;

  /**
   * Default constructor with no arguments
   */
  public ManagementCompany(){
    name = "";
    taxID = "";
    plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    properties = new Property[MAX_PROPERTY];
  }

  /**
   * Constructor with arguments for company details
   * @param name name of the company
   * @param taxID taxid of the company
   * @param mgmFee management fee charged for each property
   */
  public ManagementCompany(String name, String taxID, double mgmFee){
    this.name = name;
    this.taxID = taxID;
    mgmFeePer = mgmFee;
    plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
    properties = new Property[MAX_PROPERTY];
  }

  /**
   * Constructor with arguments for company details including plot
   * @param name name of the company
   * @param taxID taxid of the company
   * @param mgmFee management fee charged for each property
   * @param x the x coordinate of the company plot
   * @param y the y coordinate of the company plot
   * @param width how much the company expands in the x direction
   * @param depth how much the company expands in the y direction
   */
  public ManagementCompany(String name,
      String taxID,
      double mgmFee,
      int x,
      int y,
      int width,
      int depth){
    this.name = name;
    this.taxID = taxID;
    mgmFeePer = mgmFee;
    plot = new Plot(x, y, width, depth);
    properties = new Property[MAX_PROPERTY];
  }

  /**
   * Constructor with one argument to easily copy over properties of another management company
   * @param otherCompany provided company object
   */
  public ManagementCompany(ManagementCompany otherCompany){
    name = otherCompany.name;
    taxID = otherCompany.taxID;
    mgmFeePer = otherCompany.mgmFeePer;
    plot = otherCompany.plot;
    properties = otherCompany.properties;
  }

  /**
   * Add property to company
   * @param property property to add
   * @return -1 for full array, -2 for null object, -3 if company plot doesnt encompass property, -4 for overlap in array, otherwise index of property
   */
  public int addProperty(Property property){
    if(header >= 4){
      return -1;
    }
    if(property == null){
      return -2;
    }
    if(!plot.encompasses(property.getPlot())){
     return -3;
    }
    for(Property p : properties){
      if(p != null && p.getPlot().overlaps(property.getPlot())){
        return -4;
      }
    }
    header++;
    properties[header] = property;
    return header;
  }

  /**
   * Create new property and add to company
   * @param name name of the new property
   * @param city location of the new property
   * @param rent monthly rent of the new property
   * @param owner name of the owner of the property
   * @return -1 for full array, -2 for null object, -3 if company plot doesnt encompass property, -4 for overlap in array, otherwise index of property
   */
  public int addProperty(String name, String city, double rent, String owner){
    return addProperty(new Property(name, city, rent, owner));
  }

  /**
   * Create new property and add to company with plot information
   * @param name name of the new property
   * @param city location of the new property
   * @param rent monthly rent of the new property
   * @param owner name of the owner of the property
   * @param x the X coordinate of the plot
   * @param y the Y coordinate of the plot
   * @param width how much to expand the plot in the x direction
   * @param depth how much to expand the plot in the y direction
   * @return -1 for full array, -2 for null object, -3 if company plot doesnt encompass property, -4 for overlap in array, otherwise index of property
   */
  public int addProperty(String name,
      String city,
      double rent,
      String owner,
      int x,
      int y,
      int width,
      int depth){
    return addProperty(new Property(name,
        city,
        rent,
        owner,
        x,
        y,
        width,
        depth));
  }

  /**
   * Displays information of property at index i
   * @param i index in properties array
   * @return the toString of the property at the given index
   */
  public String displayPropertyAtIndex(int i){
    return properties[i].toString();
  }

  /**
   * The maximum property a company can hold
   * @return maximum property constant
   */
  public int getMAX_PROPERTY(){
    return MAX_PROPERTY;
  }

  /**
   * Find the highest rent value out of all the properties owned by the company
   * @return the rent amount of the property at the index with the highest rent
   */
  public double maxRentProp(){
    return properties[maxRentPropertyIndex()].getRentAmount();
  }

  /**
   * Iterate through all properties to find the index of the highest value property
   * @return the index of the highest
   */
  public int maxRentPropertyIndex(){
    int tempIndex = 0;
    double tempBiggest = 0;
    for(int i = 0; i < properties.length - 1; i++){
      if(properties[i] != null && tempBiggest < properties[i].getRentAmount()){
        tempBiggest = properties[i].getRentAmount();
        tempIndex = i;
      }
    }
    return tempIndex;
  }

  /**
   * Iterate through all properties and get total rent of company
   * @return total rent in dollars
   */
  public double totalRent(){
    double tempRent = 0;
    for(Property p : properties){
      if(p != null){
        tempRent += p.getRentAmount();
      }
    }
    return tempRent;
  }

  /**
   * Overridden default toString
   */
  @Override
  public String toString(){
    StringBuilder allProperties = new StringBuilder();
    for(Property p : properties){
      if(p != null){
        allProperties.append(p.toString());
      }
    }
    return allProperties.toString();
  }

  /**
   * The current plot this company occupies
   * @return plot object
   */
  public Plot getPlot() {
    return plot;
  }

  /**
   * The name of the company
   * @return company name
   */
  public String getName(){
    return name;
  }
}
