import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
/*import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;*/
import java.sql.SQLException;
import java.sql.Statement;

/*import javax.imageio.ImageIO;
import javax.swing.ImageIcon;*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogInWindow {

	private JFrame frmClinicSystem;
	private JTextField IDField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInWindow window = new LogInWindow();
					window.frmClinicSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogInWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClinicSystem = new JFrame();
		frmClinicSystem.setTitle("Clinic System");
		frmClinicSystem.getContentPane().setBackground(Color.WHITE);
		frmClinicSystem.setBounds(100, 100, 520, 509);
		frmClinicSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClinicSystem.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setForeground(Color.BLACK);
		panel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 35));
		panel.setBackground(new Color(204, 153, 153));
		panel.setBounds(0, 0, 510, 70);
		frmClinicSystem.getContentPane().add(panel);
		
		Label label_1 = new Label("Clinic System");
		label_1.setAlignment(Label.CENTER);
		panel.add(label_1);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblID.setBounds(50, 150, 110, 36);
		frmClinicSystem.getContentPane().add(lblID);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(50, 250, 110, 36);
		frmClinicSystem.getContentPane().add(lblPassword);
		
		IDField = new JTextField();
		IDField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		IDField.setBounds(210, 150, 197, 36);
		frmClinicSystem.getContentPane().add(IDField);
		IDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(210, 250, 197, 36);
		frmClinicSystem.getContentPane().add(passwordField);
		
		final JLabel emptyid = new JLabel("Enter your ID");
		emptyid.setForeground(Color.RED);
		emptyid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emptyid.setBounds(203, 243, 176, 20);
		emptyid.setVisible(false);
		frmClinicSystem.getContentPane().add(emptyid);
		
		final JLabel emptypassword = new JLabel("Enter your password");
		emptypassword.setForeground(Color.RED);
		emptypassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emptypassword.setBounds(203, 339, 176, 20);
		emptypassword.setVisible(false);
		frmClinicSystem.getContentPane().add(emptypassword);
		
		final JLabel emptyname1 = new JLabel("*");
		emptyname1.setFont(new Font("Tahoma", Font.BOLD, 17));
		emptyname1.setForeground(Color.RED);
		emptyname1.setBounds(412, 200, 23, 20);
		emptyname1.setVisible(false);
		frmClinicSystem.getContentPane().add(emptyname1);
		
		final JLabel emptypassword1 = new JLabel("*");
		emptypassword1.setForeground(Color.RED);
		emptypassword1.setFont(new Font("Tahoma", Font.BOLD, 17));
		emptypassword1.setBounds(412, 296, 23, 20);
		emptypassword1.setVisible(false);
		frmClinicSystem.getContentPane().add(emptypassword1);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = IDField.getText();
				String password = passwordField.getText();
				if(id.isEmpty()) {
					emptyid.setVisible(true);
					emptyname1.setVisible(true);
				}
				else {
					emptyid.setVisible(false);
					emptyname1.setVisible(false);
				}
				if(password.isEmpty()) {
					emptypassword.setVisible(true);
					emptypassword1.setVisible(true);
				}
				else {
					emptypassword.setVisible(false);
					emptypassword1.setVisible(false);
				}
				if(!id.isEmpty() && !password.isEmpty()) {
					
					User user = new User();
					boolean found = false;
					try {
						Connection conn = DBConnection.getConnection();
						Statement stmt = conn.createStatement();
						ResultSet rs = null;
						String sql;
						sql = "SELECT Name FROM clinic.User WHERE ID = \'"+ id +"\' and Password = \'"+password+"\' ;";
			            rs = stmt.executeQuery(sql);
			            
			            if(rs.next()) {
			            	
			            	System.out.print("inside rs ");
			            String name = rs.getString("Name");
						found = user.login(id, password);
		            	System.out.print(name);
						
						//rs.last();
			            
			            stmt.close();
			            conn.close();
			            
			            System.out.println("Name: "+name+", ID: "+id+", Pass: "+password );
			           
			            if(found && user.isDoctor) {
							Doctor dr = new Doctor(id, name.toString());
							DoctorWindow drWindow = new DoctorWindow(dr);
							frmClinicSystem.setVisible(false);
						}
						
						else if (found && !user.isDoctor)  {
							Receptionist recep = new Receptionist(id, name.toString());
							ReceptionistWindow recepWindow = new ReceptionistWindow(recep);
							frmClinicSystem.setVisible(false);
						}
						
						else {
							JOptionPane.showMessageDialog(frmClinicSystem, found, "This user not found",
									JOptionPane.ERROR_MESSAGE);
							IDField.setText("");
							passwordField.setText("");
						}
			            
			            }
			            else {
			            	JOptionPane.showMessageDialog(frmClinicSystem, "Please enter correct "
			            			+ "Name and Password", "Error",JOptionPane.ERROR_MESSAGE);
							IDField.setText("");
							passwordField.setText("");
			            }
			           
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnLogIn.setBackground(new Color(204, 204, 255));
		btnLogIn.setForeground(new Color(0, 0, 0));
		btnLogIn.setBounds(147, 350, 146, 43);
		frmClinicSystem.getContentPane().add(btnLogIn);
		
	}
}
