
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;


public class DoctorWindow extends JFrame {

	
	//private JFrame frmClinicSystem;
	private JPanel panel;
	private Button addAppointment; 
	private JSpinner timeSpinner;
	/*    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorWindow window = new DoctorWindow();
					window.frmClinicSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 *//*
	public DoctorWindow() {
		initialize();
	}
	*/
	
	public DoctorWindow/*void initialize*/(/*final DBConnection conn, */final Doctor dr/**/)/* throws SQLException*/ {
		
		//frmClinicSystem = new JFrame();
		/*frmClinicSystem.*/setTitle("Clinic System");
		/*frmClinicSystem.*/setVisible(false);
		/*frmClinicSystem.*/getContentPane().setBackground(Color.WHITE);
		/*frmClinicSystem.*/setBounds(100, 100, 550, 250);
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
	

		addAppointment = new Button("Add Appointmnet");
		addAppointment.setFont(new Font("Dialog", Font.PLAIN, 18));
		addAppointment.setBackground(new Color(204, 204, 255));
		addAppointment.setBounds(190, 100, 175, 39);
		/*frmClinicSystem.*/getContentPane().add(addAppointment);
				

		addAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*frmClinicSystem.*/setVisible(false);
				final JFrame frame = new JFrame();
				frame.getContentPane().setBackground(Color.WHITE);
				frame.setBounds(100, 100, 540, 340);
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
						LogInWindow log = new LogInWindow();
						log.main(null);
					}
				});
				back.setBackground(new Color(204, 153, 153));
				panel.add(back, "2, 2");
						
				JLabel dateLabel = new JLabel("Date");
				dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				dateLabel.setBounds(50, 73, 150, 30);
				frame.getContentPane().add(dateLabel);
				
				JLabel timeLabel = new JLabel("Time");
				timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				timeLabel.setBounds(50, 140, 150, 30);
				frame.getContentPane().add(timeLabel);

		    	final JDateChooser date = new JDateChooser();
				date.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 10));
				date.setBounds(200, 75, 250, 26);
				frame.getContentPane().add(date);
				date.setDateFormatString("dd-MM-yyyy");
		    	
				final Date d = new Date();
				SpinnerDateModel sm = new SpinnerDateModel(d, null, null, Calendar.HOUR_OF_DAY);
				timeSpinner = new JSpinner(sm);
				JSpinner.DateEditor t = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
				timeSpinner.setEditor(t);
				timeSpinner.setBounds(200, 145, 110, 30);
				timeSpinner.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 10));
				frame.getContentPane().add(timeSpinner);

				
				JButton save = new JButton("Save");
				save.setBackground(new Color(204, 204, 255));
				save.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 18));
				save.setBounds(180, 220, 141, 39);
				frame.getContentPane().add(save);
				frame.getContentPane().add(save);  
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.setVisible(true);
					
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								
						boolean expired = date.getDate().before(new Date());
						if(expired) {
								JOptionPane.showMessageDialog(null, "This date id not valid, Please choose another one.", "Error Message", JOptionPane.ERROR_MESSAGE);
						}

						
						if(!expired && timeSpinner.getValue().toString() != null && date.getDate().toString() != null) {
							LocalDate localdate = LocalDate.parse(date.toString());
							LocalTime localtime = LocalTime.parse(timeSpinner.toString());
							boolean reserved = false;
							try {
								reserved = dr.add_appointment(localdate, localtime);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(reserved) {
								JOptionPane.showConfirmDialog(null, "Appointment reserved successfully.");
							}	 
							else {
								JOptionPane.showMessageDialog(null, "Please enter correct data", 
										"Error Message", JOptionPane.ERROR_MESSAGE);
							}

						}
																		
						}
					});
						
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
