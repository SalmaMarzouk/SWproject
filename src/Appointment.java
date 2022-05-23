import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    public String patient_id;
    public String patient_name;
    public String doctor_id;
    public String doctor_name;
    public LocalDate date;
    public LocalTime time;
    private boolean available;

    public Appointment(/*String doctor_id,String doctor_name,*/LocalDate date,LocalTime time){
       this.patient_id = null;
       this.patient_name = null;
        //this.doctor_id = doctor_id;
        //this.doctor_name = doctor_name;
        this.date = date;
        this.time = time;
        this.available = true;
    }
    public boolean isEmpty(){
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }
    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

}
