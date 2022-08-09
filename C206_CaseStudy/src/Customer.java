
import java.time.LocalDate;

public class Customer {
  private int id;
  private String name;
  private int mobileNo;
  private LocalDate dob; //Dob

  
  public Customer(int id, String name, int mobileNo, LocalDate dob) {
    super();
    this.id = id;
    this.name = name;
    this.mobileNo = mobileNo;
    this.dob = dob;
  
  
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(int mobileNo) {
    this.mobileNo = mobileNo;
  }

  public int getId() {
    return id;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }
  
}
