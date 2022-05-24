import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

import java.util.Calendar;


public class ReceptionistWindow extends JFrame {

	//private JFrame frmClinicSystem;
	private JPanel panel;
	private Button viewAppointment; 
	private Button addPatient; 
	private Button reserveAppointment;
	private JSpinner timeSpinner;
	//private final SimpleDateFormat format = new SimpleDateFormat("hh:mm aa");
	//private final DecimalFormat numberFormat = new DecimalFormat("00");
/*	    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistWindow window = new ReceptionistWindow();
					window.frmClinicSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
/*	public ReceptionistWindow() {
		initialize();
	}
	
*/	
	public ReceptionistWindow/*initialize*/(/*final DBConnection conn, */final Receptionist recep/**/)/* throws SQLException*/ {
		
		//frmClinicSystem = new JFrame();
		/*frmClinicSystem.*/setTitle("Clinic System");
		/*frmClinicSystem.*/setVisible(false);
		/*frmClinicSystem.*/getContentPane().setBackground(Color.WHITE);
		/*frmClinicSystem.*/setBounds(100, 100, 550, 400);
		/*frmClinicSystem.*/setDefaultCloseOperation(JFrame.TEXT_CURSOR);
		/*frmClinicSystem.*/getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(204, 153, 153));
		panel.setBounds(0, 0, 561, 53);
		//frmClinicSystem.getContentPane().add(panel);
		
		
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("34px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("104px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("230px"),
				ColumnSpec.decode("1px"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("102px"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("31px"),
				FormFactory.NARROW_LINE_GAP_ROWSPEC,
				RowSpec.decode("1px"),}));
				
				JButton back = new JButton(new ImageIcon(this.getClass().getResource("/back.png")));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						/*frmClinicSystem.*/setVisible(false);
						LogInWindow log = new LogInWindow();
						log.main(null);
					}
				});
				back.setBackground(new Color(204, 153, 153));
				panel.add(back, "2, 2");
				
				JLabel lblNewLabel_1_1 = new JLabel("Clinic System");
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				panel.add(lblNewLabel_1_1, "6, 2, left, center");
		
		viewAppointment = new Button("View Empty Appointment");
		viewAppointment.setFont(new Font("Dialog", Font.PLAIN, 18));
		viewAppointment.setBackground(new Color(204, 204, 255));
		viewAppointment.setBounds(150, 260, 235, 40);
		/*frmClinicSystem.*/getContentPane().add(viewAppointment);
		
		viewAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*frmClinicSystem.*/setVisible(false);
				final JFrame frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 583, 280);
				frame.setDefaultCloseOperation(JFrame.TEXT_CURSOR);
				frame.getContentPane().setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(204, 153, 153));
				panel.setBounds(0, 0, 570, 53);
				frame.getContentPane().add(panel);
				
				panel.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("34px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("104px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("230px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("1px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("102px"),},
					new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("31px"),
						FormFactory.NARROW_LINE_GAP_ROWSPEC,
						RowSpec.decode("1px"),}));
				
				JLabel lblNewLabel_1 = new JLabel("Clinic System");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				panel.add(lblNewLabel_1, "6, 2, left, center");
				
				JButton btnNewButton = new JButton("log out");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//cust.log_out();
						frame.setVisible(false);
						LogInWindow log = new LogInWindow();
						log.main(null);
					}
				});
				
				JLabel logOutPic = new JLabel(new ImageIcon(this.getClass().getResource("/logout.jpg")));
				panel.add(logOutPic, "13, 2, right, center");
				btnNewButton.setBackground(new Color(204, 204, 255));
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				panel.add(btnNewButton, "15, 2, left, top");
				
				JButton back = new JButton(new ImageIcon(this.getClass().getResource("/back.png")));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.setVisible(false);
						LogInWindow login = new LogInWindow();
					}
				});
				back.setBackground(new Color(204, 153, 153));
				panel.add(back, "2, 2");
	
				ArrayList<Appointment> empty_appointments;
				try {
					empty_appointments = recep.view_empty_appointment();
					String[] titles = {"Patient Id", "Patient Name", "Doctor Id", "Doctor Name", "Date", "Time", "Available"};
					String[][] arr = empty_appointments.stream().map(u -> empty_appointments.toArray(new String[0])).toArray(String[][]::new);
					JTable table = new JTable(arr, titles);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "No Appointments.", 
							"Error Message", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();

				}
			}
		});
		
		
		
		addPatient = new Button("Add Patient");
		addPatient.setFont(new Font("Dialog", Font.PLAIN, 18));
		addPatient.setBackground(new Color(204, 204, 255));
		addPatient.setBounds(190, 100, 141, 39);
		/*frmClinicSystem.*/getContentPane().add(addPatient);
		

		addPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*frmClinicSystem.*/setVisible(false);
				final JFrame frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 540, 440);
				frame.setDefaultCloseOperation(JFrame.TEXT_CURSOR);
				frame.getContentPane().setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(204, 153, 153));
				panel.setBounds(0, 0, 570, 50);
				frame.getContentPane().add(panel);
				
				panel.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("34px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("104px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("230px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("1px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("102px"),},
					new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("31px"),
						FormFactory.NARROW_LINE_GAP_ROWSPEC,
						RowSpec.decode("1px"),}));
				
				JLabel lblNewLabel_1 = new JLabel("Clinic System");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				panel.add(lblNewLabel_1, "6, 2, left, center");
				
				JButton btnNewButton = new JButton("log out");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.setVisible(false);
						LogInWindow log = new LogInWindow();
						log.main(null);
					}
				});
			
				JLabel logOutPic = new JLabel(new ImageIcon(this.getClass().getResource("/logout.jpg")));
				panel.add(logOutPic, "13, 2, right, center");
				btnNewButton.setBackground(new Color(204, 204, 255));
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				panel.add(btnNewButton, "15, 2, left, top");
				
				JButton back = new JButton(new ImageIcon(this.getClass().getResource("/back.png")));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.setVisible(false);
						ReceptionistWindow recepW = new ReceptionistWindow(recep);
					}
				});
				back.setBackground(new Color(204, 153, 153));
				panel.add(back, "2, 2");
				
				JLabel name = new JLabel("Patient Name");
				name.setFont(new Font("Tahoma", Font.PLAIN, 15));
				name.setBounds(50, 73, 150, 30);
				frame.getContentPane().add(name);
				
		    	JLabel age = new JLabel("Age");
		    	age.setFont(new Font("Tahoma", Font.PLAIN, 15));				
		    	age.setBounds(50, 130, 150, 30);
		    	frame.getContentPane().add(age);
		    	
		    	JLabel gender = new JLabel("Gender");
		    	gender.setFont(new Font("Tahoma", Font.PLAIN, 15));				
		    	gender.setBounds(50, 187, 150, 30);
		    	frame.getContentPane().add(gender);
		    	
		    	JLabel address = new JLabel("Address");
		    	address.setFont(new Font("Tahoma", Font.PLAIN, 15));				
		    	address.setBounds(50, 244, 150, 30);
		    	frame.getContentPane().add(address);
		    	
		    	final JComboBox genderBox = new JComboBox();
		    	genderBox.setForeground(new Color(0, 0, 0));
		    	genderBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		    	genderBox.setBackground(new Color(204, 204, 255));
		    	genderBox.setToolTipText("");
		    	genderBox.setBounds(200, 187, 250, 26);
				String[] g = {"Choose Gender","Male","Female"};
				genderBox.setModel(new DefaultComboBoxModel(g));
				frame.getContentPane().add(genderBox);

				final JTextField p_name = new JTextField();
				p_name.setBounds(200, 73, 250, 26);
				frame.getContentPane().add(p_name);
				p_name.setColumns(10);
				frame.getContentPane().add(p_name);
				
				final JTextField p_age = new JTextField();
				p_age.setBounds(200, 130, 250, 26);
				frame.getContentPane().add(p_age);
				p_age.setColumns(10);
				frame.getContentPane().add(p_age);
				
				final JTextField p_address = new JTextField();
				p_address.setBounds(200, 244, 250, 26);
				frame.getContentPane().add(p_address);
				p_address.setColumns(10);
				frame.getContentPane().add(p_address);
				
				JButton save = new JButton("Save");
				save.setBackground(new Color(204, 204, 255));
				save.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 18));
				save.setBounds(180, 300, 141, 39);
				frame.getContentPane().add(save);
				frame.getContentPane().add(save);  
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.setVisible(true);
			
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if(genderBox.getSelectedItem() != "Choose Gender" && !p_name.getText().isEmpty() && !p_age.getText().isEmpty() && !p_address.getText().isEmpty()) {
							int max=1000, min=0;
							int id = (int) (Math.random()*(max-min+1)+min);
							//Patient patient = new Patient(Integer.toString(id), p_name.getText().toString(), genderBox.getSelectedItem().toString(), p_age.getText().toString(), p_address.getText().toString());
							System.out.print(p_name.getText().toString());
							System.out.println(p_address.getText().toString());
							System.out.println(p_age.getText().toString());
							System.out.println(Double.toString(id));
							System.out.println(genderBox.getSelectedItem().toString());

							boolean added;
							try {
								added = recep.add_patient(Integer.toString(id), genderBox.getItemAt(genderBox.getSelectedIndex()).toString(), p_name.toString(), p_age.toString(), p_address.toString());
								System.out.print(added);
								if(added) {
									JOptionPane.showConfirmDialog(null, "Patient added successfully.");
								}
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Please enter correct data", 
										"Error Message", JOptionPane.ERROR_MESSAGE);
							}
							
							 
						}
						else {
							JOptionPane.showMessageDialog(null, "Please enter full data", 
									"Error Message", JOptionPane.ERROR_MESSAGE);
						}
						
						
					}
				});
				
			}
		});

		
		reserveAppointment = new Button("Reserve Appointmnent");
		reserveAppointment.setFont(new Font("Dialog", Font.PLAIN, 18));
		reserveAppointment.setBackground(new Color(204, 204, 255));
		reserveAppointment.setBounds(160, 180, 220, 39);
		/*frmClinicSystem.*/getContentPane().add(reserveAppointment);
		

		reserveAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*frmClinicSystem.*/setVisible(false);
				final JFrame frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(150, 150, 540, 500);
				frame.setDefaultCloseOperation(JFrame.TEXT_CURSOR);
				frame.getContentPane().setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(204, 153, 153));
				panel.setBounds(0, 0, 570, 50);
				frame.getContentPane().add(panel);
				
				panel.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("34px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
						ColumnSpec.decode("104px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("230px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						ColumnSpec.decode("1px"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("102px"),},
					new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("31px"),
						FormFactory.NARROW_LINE_GAP_ROWSPEC,
						RowSpec.decode("1px"),}));
				
				JLabel lblNewLabel_1 = new JLabel("Clinic System");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				panel.add(lblNewLabel_1, "6, 2, left, center");
				
				JButton btnNewButton = new JButton("log out");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.setVisible(false);
						LogInWindow log = new LogInWindow();
						log.main(null);
					}
				});
			
				JLabel logOutPic = new JLabel(new ImageIcon(this.getClass().getResource("/logout.jpg")));
				panel.add(logOutPic, "13, 2, right, center");
				btnNewButton.setBackground(new Color(204, 204, 255));
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
				panel.add(btnNewButton, "15, 2, left, top");
				
				JButton back = new JButton(new ImageIcon(this.getClass().getResource("/back.png")));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.setVisible(false);
						ReceptionistWindow recepW = new ReceptionistWindow(recep);
					}
				});
				back.setBackground(new Color(204, 153, 153));
				panel.add(back, "2, 2");
				
				final JLabel dr_id = new JLabel("Doctor ID");
				dr_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
				dr_id.setBounds(50, 73, 150, 30);
				frame.getContentPane().add(dr_id);
				
		    	final JLabel patient_id = new JLabel("Patient ID");
		    	patient_id.setFont(new Font("Tahoma", Font.PLAIN, 15));				
		    	patient_id.setBounds(50, 130, 150, 30);
		    	frame.getContentPane().add(patient_id);
		    	
		    	final JLabel patient_name = new JLabel("Patient Name");
		    	patient_name.setFont(new Font("Tahoma", Font.PLAIN, 15));				
		    	patient_name.setBounds(50, 187, 150, 30);
		    	frame.getContentPane().add(patient_name);
		    	
		    	final JLabel dateLabel = new JLabel("Date");
		    	dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));				
		    	dateLabel.setBounds(50, 244, 150, 30);
		    	frame.getContentPane().add(dateLabel);
		    	
		    	final JLabel timeLabel = new JLabel("Time");
		    	timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));				
		    	timeLabel.setBounds(50, 301, 150, 30);
		    	frame.getContentPane().add(timeLabel);
		    	
		    	final JDateChooser date = new JDateChooser();
				date.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 10));
				date.setBounds(200, 244, 250, 26);
				frame.getContentPane().add(date);
				date.setDateFormatString("dd-MM-yyyy");
		    	
				final Date d = new Date();
				SpinnerDateModel sm = new SpinnerDateModel(d, null, null, Calendar.HOUR_OF_DAY);
				timeSpinner = new JSpinner(sm);
				JSpinner.DateEditor t = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
				timeSpinner.setEditor(t);
				timeSpinner.setBounds(200, 300, 110, 30);
				timeSpinner.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 10));
				frame.getContentPane().add(timeSpinner);

				final JTextField drid = new JTextField();
				drid.setBounds(200, 75, 250, 26);
				frame.getContentPane().add(drid);
				drid.setColumns(10);
				frame.getContentPane().add(drid);
				
				final JTextField pid = new JTextField();
				pid.setBounds(200, 130, 250, 26);
				frame.getContentPane().add(pid);
				pid.setColumns(10);
				frame.getContentPane().add(pid);
				
				final JTextField pname = new JTextField();
				pname.setBounds(200, 185, 250, 26);
				frame.getContentPane().add(pname);
				pname.setColumns(10);
				frame.getContentPane().add(pname);
				

				JButton save = new JButton("Save");
				save.setBackground(new Color(204, 204, 255));
				save.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 18));
				save.setBounds(180, 370, 141, 39);
				frame.getContentPane().add(save);
				frame.getContentPane().add(save);  
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.setVisible(true);
			
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(date.getDate() == null || timeSpinner.getValue() == null) {
							JOptionPane.showMessageDialog(null, "Please enter full data", 
									"Error Message", JOptionPane.ERROR_MESSAGE);
						}
						else {
						boolean expired = date.getDate().before(new Date());
						if(expired) {
								JOptionPane.showMessageDialog(null, "This date id not valid, Please choose another one.", "Error Message", JOptionPane.ERROR_MESSAGE);
						}
						else {
							String year = Integer.toString(date.getDate().getYear()+1900);
							String month = Integer.toString(date.getDate().getMonth()+1);
							String day = Integer.toString(date.getDate().getDay());
							if(date.getDate().getMonth() == 1 || date.getDate().getMonth() == 2 || date.getDate().getMonth() == 3 || date.getDate().getMonth() == 4 ||
									date.getDate().getMonth() == 5 || date.getDate().getMonth() == 6 || date.getDate().getMonth() == 7 || date.getDate().getMonth() == 8 || date.getDate().getMonth() == 9) {
								month = "0" + month;
							}
							Calendar c = Calendar.getInstance();
							c.setTime(d);
							day = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
									
							LocalDate localdate = LocalDate.parse(year +"-"+ month +"-"+ day);
							System.out.println(localdate);
							
							Object obj = timeSpinner.getValue();
							LocalTime thetime = LocalTime.now();
							if (obj instanceof java.util.Date) {
							    Date theDate = (java.util.Date) obj;
							    Instant inst = theDate.toInstant();
							    ZoneId theZone = java.time.ZoneId.systemDefault();
							    thetime = java.time.LocalTime.ofInstant(inst, theZone); // Since JDK 9
							    /*
							    LocalTime.from(ZonedDateTime.ofInstant(inst, theZone)); // Since JDK 8
							     */
							    System.out.println("Time "+ thetime);
							}
							
							boolean reserved = false;
							try {
								reserved = recep.reserve_appointment(drid.getText().toString(), localdate, thetime, pid.getText().toString(), pname.getText().toString());
								if(reserved) {
									JOptionPane.showConfirmDialog(null, "Appointment reserved successfully.");
								}	 
								else {
									JOptionPane.showMessageDialog(null, "Please enter correct data", 
											"Error Message", JOptionPane.ERROR_MESSAGE);
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						
						}
					}
				});
				
		    	frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.setVisible(true);
			}
		});

		/*frmClinicSystem.*/getContentPane().add(panel, BorderLayout.CENTER);
						
						JLabel logOutPic_1 = new JLabel(new ImageIcon(this.getClass().getResource("/logout.jpg")));
						panel.add(logOutPic_1, "14, 2, right, center");
						
								JButton btnNewButton_1 = new JButton("log out");
								btnNewButton_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										//cust.log_out();
										/*frmClinicSystem.*/setVisible(false);
										LogInWindow log = new LogInWindow();
										log.main(null);
									}
								});
								btnNewButton_1.setBackground(new Color(204, 204, 255));
								btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
								panel.add(btnNewButton_1, "15, 2, left, top");
		/*frmClinicSystem.*/setVisible(true);    
	}
}
