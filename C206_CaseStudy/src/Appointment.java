import java.time.LocalDate;

public class Appointment{ 
	 private String id; 
	 private String appointmentDate; 
	  
	 public Appointment(String id, String appointmentDate) { 
	  this.id=id; 
	  this.appointmentDate=appointmentDate; 
	 } 
	 public String getID() { 
	  return id; 
	 } 
	 
	 public String getApptDate() { 
	  return appointmentDate; 
	 } 
	 public void setApptDate(String appointmentDate) { 
	  this.appointmentDate = appointmentDate; 
	 } 
	 
	}