import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Connection;

public class Receptionist extends User{
	
	public Receptionist() {}
	public Receptionist(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}

    public ArrayList<Appointment> view_empty_appointment() throws Exception {
        Statement stmt;
        Connection conn = DBConnection.getConnection();
        ArrayList <Appointment> appointments = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM clinic.Appointment WHERE Available = \'1\';";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Appointment a = new Appointment(rs.getString("Doctor_id"),rs.getString("Doctor_name"),rs.getDate("Date").toLocalDate(),rs.getTime("Time").toLocalTime());
                appointments.add(a);
            }
            conn.close();
        	stmt.close();
        }
        catch(SQLException err) {
        	err.printStackTrace();
        	
        }
        return appointments;
    }

    public boolean reserve_appointment(String doctor_id, LocalDate date, LocalTime time , String patient_id, String patient_name) throws Exception{
    	if(!patient_name.matches("[a-zA-Z]+")) {
    		System.out.println("Invalid Name!!");
    		return false;
    	}
    	Statement stmt ;
    	Connection conn = DBConnection.getConnection();
        try {
        	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql = "SELECT * FROM clinic.Appointment WHERE Patient_id = \'"+ patient_id +"\' and Date =\'"+date+"\' and Time =\'"+time+"\' and Available = \'0\';";

            ResultSet rs = stmt.executeQuery(sql);
            rs.last();
            if(rs.getRow()!=0) {
            	return false;
            }
            
            sql = "SELECT * FROM clinic.Appointment WHERE Date =\'"+date+"\' and Time =\'"+time+"\' and Doctor_id = \'"+doctor_id+"\' ;";

            rs = stmt.executeQuery(sql);
            rs.last();
            if(rs.getRow()==0) {
            	return false;
            }
			sql = "SELECT * FROM clinic.Patient WHERE Id = \'"+ patient_id +"\';";
			rs = stmt.executeQuery(sql);
			  rs.last();
	            if(rs.getRow()==0) {
	            	System.out.println("Patient is not recorded!!");
	            	return false;
	            }
            
	    	sql = "update clinic.Appointment set Patient_name = "+"\'"+patient_name+"\'"+", Patient_id = "+"\'"+patient_id+"\'"+" , Available = \'0\' "+" where Date =\'"+date+"\' and Time =\'"
	    			+time+"\' and Doctor_id =\'"+doctor_id+"\' and  Available = \'1\';";
	    	stmt.executeUpdate(sql);
	        conn.close();
	        stmt.close();
		} 
        catch(SQLException sqe)
        {
        System.out.println("Invalid input");
        sqe.printStackTrace();
        return false;
        }
 
           
            
        return true;
        
    }

    public boolean add_patient(String ID, String gender, String name, String age, String address) throws Exception {
    	if(!name.matches("[a-zA-Z]+")) {
    		System.out.println("Invalid Name!!");
    		return false;
    	}
        Statement stmt;
        Connection conn = DBConnection.getConnection();

        try {
            stmt = conn.createStatement();

            String sql = "INSERT INTO clinic.Patient (`ID`, `Gender`, `Name`, `Age`, `Address`) VALUES (\'" +
                    ID + "\', \'" +
                    gender + "\', \'" +
                    name +"\', \'" +
                    age + "\', \'" +
                    address + "\');";

            stmt.execute(sql);
            stmt.close();

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
