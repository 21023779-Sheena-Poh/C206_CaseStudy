
public class Feedback {
  public String id;
  public String feedback;
  public String status;

  public Feedback(String id, String feedback) {
    this.id = id;
    this.feedback = feedback;
    this.status = "Pending";

  }
  
  public String getId() {
    return id;
  }
  
  public String getFeedback() {
    return feedback;
  }
  
  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
}
