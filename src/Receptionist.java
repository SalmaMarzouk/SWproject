import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Connection;

public class Receptionist extends User{

    public ArrayList<Appointment> view_empty_appointment() throws Exception {
        Statement stmt = null;
        Connection conn = DBConnection.getConnection();
        ArrayList <Appointment> appointments = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM `clinic`.`Appointment` WHERE Available = 'true';";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Appointment a = new Appointment(rs.getString("Doctor_id"),rs.getString("Doctor_name"),rs.getDate("Date").toLocalDate(),rs.getTime("Time").toLocalTime());
                appointments.add(a);
            }
        }

        finally {
            conn.close();
            if(stmt != null) {
            	stmt.close();
            }
        }

        return appointments;
    }

    public void reserve_appointment(String doctor_id, LocalDate day, LocalTime time , String patient_id){
        //appointment.setAvailable = false;
        //appointment.setPatient_id = patient_id

    }

    public void add_patient(Patient p) throws Exception {

        Statement stmt;
        Connection conn = DBConnection.getConnection();

        try {
            stmt = conn.createStatement();

            String sql = "INSERT INTO `clinic`.`Patient` (`ID`, `gender`, `name`, `age`, `address`) VALUES ('" +
                    p.ID + "', '" +
                    p.gender + "', '" +
                    p.name +"', '" +
                    p.age + "', '" +
                    p.address + "');";

            stmt.execute(sql);
            stmt.close();

        }

        catch (SQLException err){
            err.printStackTrace();
        }
    }

}