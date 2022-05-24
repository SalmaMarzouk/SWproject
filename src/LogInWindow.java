import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;*/
import java.sql.SQLException;

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
	private JTextField nameField;
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
		panel.setBounds(0, 0, 510, 131);
		frmClinicSystem.getContentPane().add(panel);
		
		Label label_1 = new Label("Clinic System");
		label_1.setAlignment(Label.CENTER);
		panel.add(label_1);
		
		JLabel lblID = new JLabel("Username");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblID.setBounds(29, 191, 110, 36);
		frmClinicSystem.getContentPane().add(lblID);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(29, 286, 110, 36);
		frmClinicSystem.getContentPane().add(lblPassword);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameField.setBounds(193, 191, 197, 36);
		frmClinicSystem.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(193, 286, 197, 36);
		frmClinicSystem.getContentPane().add(passwordField);
		
		final JLabel emptyid = new JLabel("Enter your username");
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
				String id = nameField.getText();
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
					Boolean found = null;
					found = user.login(id,password);

					if(found && user.isDoctor) {
						Doctor dr = new Doctor();
						DoctorWindow drWindow = new DoctorWindow(dr);
						frmClinicSystem.setVisible(false);
					}
					
					else if (found && !user.isDoctor)  {
						Receptionist recep = new Receptionist();
						ReceptionistWindow recepWindow = new ReceptionistWindow(recep);
						frmClinicSystem.setVisible(false);
					}
					
					else {
						JOptionPane.showMessageDialog(frmClinicSystem, found, "Error", JOptionPane.ERROR_MESSAGE);
						nameField.setText("");
						passwordField.setText("");
					}
				}
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnLogIn.setBackground(new Color(204, 204, 255));
		btnLogIn.setForeground(new Color(0, 0, 0));
		btnLogIn.setBounds(147, 381, 146, 43);
		frmClinicSystem.getContentPane().add(btnLogIn);
		
	}
}
