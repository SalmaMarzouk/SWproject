import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class Doctor extends User{
    //date yyyy-MM-dd, time HH-mm-ss-ns
    public void add_appointment(LocalDate date, LocalTime time) throws Exception {
        Statement stmt;
        Connection conn = DBConnection.getConnection();
        Appointment a = new Appointment(date,time);
        try {
            stmt = conn.createStatement();

            String sql = "INSERT INTO `clinic`.`Appointment` (`Patient_id`, `Patient_name`, `Doctor_id`, `Doctor_name`, `Date`, `Time`, `Available`) VALUES ('" +
                    a.patient_id + "', '" +
                    a.patient_name + "', '" +
                    a.doctor_id + "', '" +
                    a.doctor_name + "', '" +
                    a.date+ "', '" +
                    a.time + "', '" +
                    true + "');";

            stmt.execute(sql);
            stmt.close();
        }

        catch (SQLException err){
            err.printStackTrace();
        }


    }
}
