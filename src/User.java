import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    protected String ID;
    protected String name;
    protected String password;
    protected boolean isDoctor;
    User user;



    public boolean login(String ID,String password) throws SQLException, Exception{
        this.ID = ID;
        this.password = password;
        //validate user (check if ID exists, if the password true)
        Statement stmt = null;
        Connection conn = DBConnection.getConnection();

        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql;

            sql = "SELECT * FROM clinic.User WHERE ID = \'"+ ID +"\' and Password = \'"+password+"\' ;";

            ResultSet rs = stmt.executeQuery(sql);
          
            rs.last();
            if(rs.getRow()!=1) {
            	System.out.println("exit here!!"+rs.getRow());
            	return false;
            }
            this.name = rs.getString("Name");
            this.isDoctor = rs.getBoolean("isDoctor");
            if(this.isDoctor) {
            	user = new Doctor(this.ID,this.name);
            }else {
            	user = new Receptionist(this.ID,this.name);
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException err) {
        	err.printStackTrace();
        	
        }
        return true;
    }
    public User get_user() {
    	return user;
    }

}