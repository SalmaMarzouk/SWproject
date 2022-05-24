
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException, Exception {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/?user=root";

        //  Database credentials
        final String USER = "root";
        final String PASS = "root";

        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        return conn;
    }
    public static void main(String[]args) throws SQLException, Exception {
    	User user = new User();
    	System.out.println(user.login("1","11"));
    	Doctor dr = (Doctor)user.get_user();
    	LocalDate date = LocalDate.parse("2022-06-23");
    	LocalTime time = LocalTime.parse("06:00:00");
    	//System.out.println(dr.add_appointment(date,time));
    	//receptionist
    	User user2 = new User();
    	System.out.println(user2.login("2","11"));
    	Receptionist res = (Receptionist) user2.get_user();
    	List<Appointment>l = new ArrayList<>();
    	l= res.view_empty_appointment();
    	System.out.println(l.size());
    	for(Appointment p : l) {
    		System.out.println(p.doctor_id+"  "+p.doctor_name);
    	}
    	//System.out.println(res.add_patient("3", "f", "Sayd", "56", "Egypt"));
    	System.out.println(res.add_patient("44", "F", "Sayda", "22", "Egypt"));
    	//System.out.println(res.reserve_appointment("1",date,time,"3","Sayd"));
    }
    
}