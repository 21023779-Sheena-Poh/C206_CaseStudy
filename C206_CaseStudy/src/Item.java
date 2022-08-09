
public class Item {
  private String id;
  private String name;
  private double price;
  private Boolean Available;
  
  public Item(String id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.Available = true;
  }
  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public double getPrice() {
    return price;
  }
  public Boolean getAvailable() {
    return Available;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public void setAvailable(Boolean Available) {
    this.Available = Available;
  }

}