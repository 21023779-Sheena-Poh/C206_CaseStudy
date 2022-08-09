
public class BikePart extends Item{
private String component;

  public BikePart(String id, String name, double price, String component) {
    super(id, name, price);
    this.component = component;
  }
  public String getComponent() {
    return component;
  }
  public void setComponent(String component) {
    this.component = component;
  }

}
