
public class Bike extends Item{
private String colour;

  public Bike(String id, String name, double price, String colour) {
    // TODO Auto-generated constructor stub
    super(id, name, price);
    this.colour = colour;
  }
  public String getColour() {
    return colour;
  }
  public void setColour(String colour) {
    this.colour = colour;
  }

}
