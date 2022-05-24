import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class Doctor extends User{
	public Doctor() {}
    //date yyyy-MM-dd, time HH-mm-ss-ns
	public Doctor(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}
    public boolean add_appointment(LocalDate date, LocalTime time) throws Exception {
    	if(date.isBefore(LocalDate.now())||(date.equals(LocalDate.now())&&time.isBefore(LocalTime.now()))) {
    		return false;
    	}
        Statement stmt ;
        Connection conn = DBConnection.getConnection();
        Appointment a = new Appointment(this.ID,this.name,date,time);
        try {
            stmt = conn.createStatement();
            System.out.println(this.ID);
            String sql = "INSERT INTO clinic.Appointment (`Patient_id`, `Patient_name`, `Doctor_id`, `Doctor_name`, `Date`, `Time`, `Available`) VALUES (\'" +
                    a.patient_id + "\' , \'" +
                    a.patient_name + "\', \'" +
                    a.doctor_id + "\', \'" +
                    a.doctor_name + "\', \'" +
                    a.date+ "\', \'" +
                    a.time + "\', \'" +
                    "1" + "\');";

            stmt.execute(sql);
            stmt.close();
            conn.close();
           
        }
        catch(SQLException sqe)
        {
        System.out.println("Invalid input");
        sqe.printStackTrace();
        return false;
        }
 	
        

        return true;
    }
}
