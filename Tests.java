import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class Tests {

	//log in
	@Test
	public void log_in() {
		User user = new User();
		boolean succ = false;
		String id = "";
		String password = "";
		
		try {
			id = "1"; //correct id
			password = "11"; //correct password
			succ = user.login(id, password);
			assertTrue("Failed to login",succ);
		}
		catch(Throwable e) {
			Assert.fail("Failed to login");
		}
		
		
		try {
			id = "thhjdg"; //wrong id
			succ = user.login(id, password);
			assertFalse("Login using wrong id",succ);
		}
		catch(Throwable e) {
			Assert.fail("Login using wrong id");
		}
		
		
		try {
			id = "1"; //correct id
			password = "78djd"; //wrong password
			succ = user.login(id, password);
			assertFalse("Login using wrong password",succ);
		}
		catch(Throwable e) {
			Assert.fail("Login using wrong password");
		}
		
		
		try {
			id = "1"; //correct doctor id
			password = "11"; //correct password
			succ = user.login(id, password);
			assertTrue("Doctor has logged in as a receptionist",user.isDoctor);
		}
		catch(Throwable e) {
			Assert.fail("Doctor has logged in as a receptionist");
		}
		
		
		try {
			id = "2"; //correct receptionist id
			password = "11"; //correct password
			succ = user.login(id, password);
			assertFalse("Receptionist has logged in as a doctor",user.isDoctor);
		}
		catch(Throwable e) {
			Assert.fail("Receptionist has logged in as a doctor");
		}
	}

	
	
	@Test
	public void Add_appointment() {
			Doctor doc = new Doctor();
			String id = "1"; //correct id
			String password = "11"; //correct password
			boolean succ; 
			try {
				succ= doc.login(id, password);
				assertTrue("Failed to login",succ);
			}
			catch(Throwable e) {
				Assert.fail("Failed to login");
			}
			
			Receptionist resp = new Receptionist();
			String id2 = "2"; //correct id
			String password2 = "11"; //correct password
			try {
				succ = resp.login(id2, password2);
				assertTrue("Failed to login",succ);
			}
			catch(Throwable e) {
				Assert.fail("Failed to login");
			}
			
			
			LocalDate date = LocalDate.of(2022, 11, 8);
			LocalTime time = LocalTime.of(10, 0,0);
			boolean found;
			ArrayList<Appointment> appointments;
			
			try {
				succ = doc.add_appointment(date,time); 
				assertTrue("Failed to add appointment",succ);
				appointments = resp.view_empty_appointment();
				Appointment temp = null;
				found = false;
				for(int i=0;i<appointments.size();i++) {
					if(appointments.get(i).doctor_id.equals(id)) {
						if((appointments.get(i).date.equals(date))&&(appointments.get(i).time.equals(time))) { //date
							found = true;
							temp = appointments.get(i);
							break;
						}
					}
				}
				assertTrue("Failed to add appointment",found);
				assertTrue("Add unavailable appointment",temp.isEmpty());
			}
			catch(Throwable e) {
				Assert.fail("Failed to add appointment");
			}
			
			
			try {
				found = false;
				int n =0;
				succ = doc.add_appointment(date,time); //same time
				assertFalse("Add dublicate appointment",succ);
				appointments = resp.view_empty_appointment();
				for(int i=0;i<appointments.size();i++) {
					if(appointments.get(i).doctor_id.equals(id)) {
						if((appointments.get(i).date.equals(date))&&(appointments.get(i).time.equals(time))) { //date
							found = true;
							n++;
						}
					}
				}
				assertEquals("Add dublicate appointment",1, n);
			}
			catch(Throwable e) {
				Assert.fail("Add dublicate appointment");
			}
			
			
			try {
				found = false;
				date = LocalDate.of(2020, 7, 2);
				succ = doc.add_appointment(date, time); //Wrong date
				assertFalse("Add appointment with wrong date",succ);
				appointments = resp.view_empty_appointment();
				for(int i=0;i<appointments.size();i++) {
					if(appointments.get(i).doctor_id == id) {
						if((appointments.get(i).date == date)&&(appointments.get(i).time==time)) {
							found = true;
						}
					}
				}
				assertFalse("Add appointment with wrong date",found);
			}
			catch(Throwable e) {
				Assert.fail("Add appointment with wrong date");
			}
			
	}
	

	
	
	@Test
	public void Add_patient() {
		
		Receptionist resp = new Receptionist();
		String id = "2"; //correct id
		String password = "11"; //correct password
		try {
			boolean succ = resp.login(id, password);
			assertTrue("Failed to login",succ);
		}
		catch(Throwable e) {
			Assert.fail("Failed to login");
		}
		
		String ID = "235";
		String Gender = "Male";
		String Name = "Samy";
		String Age = "30";
		String address = "";
		
		boolean succ2;
		
		try {
			succ2= resp.add_patient(ID, Gender, Name, Age, address);
			assertTrue("Failed to add patient",succ2);
		}
		catch(Throwable e) {
			Assert.fail("Failed to add patient");
		}
		
		
		try {
			succ2 = resp.add_patient(ID, Gender, Name, Age, address);
			assertFalse("Add the same patient twice",succ2);
		}
		catch(Throwable e) {
			Assert.fail("Add the same patient twice");
		}
		
		
		try {
			Name = "Bob";
			succ2 = resp.add_patient(ID, Gender, Name, Age, address);
			assertFalse("Add patient with dublicated ID",succ2);
		}
		catch(Throwable e) {
			Assert.fail("Add patient with dublicated ID");
		}

		
		try {
			ID = "245";
			Gender = "Female";
			Name = "Amira";
			succ2 = resp.add_patient(ID, Gender, Name, Age, address);
			assertTrue("Failed to add patient",succ2);
		}
		catch(Throwable e) {
			Assert.fail("Failed to add patient");
		}

		
		try {
			ID = "267";
			Gender = "wrong";
			Name = "Mona";
			succ2 = resp.add_patient(ID, Gender, Name, Age, address);
			assertFalse("Add patient with undefined gender",succ2);
		}
		catch(Throwable e) {
			Assert.fail("Add patient with undefined gender");
		}
		
		
		
		try {
			ID = "268";
			Gender = "Male";
			Name = "5675";
			succ2 = resp.add_patient(ID, Gender, Name, Age, address);
			assertFalse("Add patient with undefined name",succ2);
		}
		catch(Throwable e) {
			Assert.fail("Add patient with undefined name");
		}
		
		
		try {
			ID = "269";
			Name = "John";
			Age = "-87";
			succ2 = resp.add_patient(ID, Gender, Name, Age, address);
			assertFalse("Add patient with negative age",succ2);
		}
		catch(Throwable e) {
			Assert.fail("Add patient with negative age");
		}
	}
	
	
	
	@Test
	public void Reserve_appointment() {
		
		Receptionist resp = new Receptionist();
		String id = "2"; //correct id
		String password = "11"; //correct password
		try {
			boolean succR = resp.login(id, password);
			assertTrue("Failed to login",succR);
		}
		catch(Throwable e) {
			Assert.fail("Failed to login");
		}
		
		Doctor doc = new Doctor();
		String id2 = "1"; //correct id
		String password2 = "11"; //correct password
		try {
			boolean succD = doc.login(id2, password2);
			assertTrue("Failed to login",succD);
		}
		catch(Throwable e) {
			Assert.fail("Failed to login");
		}
		
		LocalDate date = LocalDate.of(2022, 7, 4);
		LocalTime time = LocalTime.of(12, 45);
		try {
			boolean succAP = doc.add_appointment(date,time); //date
			assertTrue("Failed to add appointment",succAP);
		}
		catch(Throwable e) {
			Assert.fail("Failed to add appointment");
		}
		
		String ID = "20";
		String Gender = "Male";
		String Name = "Samy";
		String Age = "30";
		String address = "";
		try {
			boolean succAP= resp.add_patient(ID, Gender, Name, Age, address);
			assertTrue("Failed to add patient",succAP);
		}
		catch(Throwable e) {
			Assert.fail("Failed to add patient");
		}
		
		boolean succ;
		ArrayList<Appointment> appointments;
		boolean found = false;
		
		
		try {
			succ = resp.reserve_appointment(id2,date,time, ID, Name);//date
			assertTrue("Failed to reserve appointment", succ);
			appointments = resp.view_empty_appointment();
			found = false;
			for(int i=0;i<appointments.size();i++) {
				if(appointments.get(i).doctor_id == id) {
					if((appointments.get(i).date == date)&&(appointments.get(i).time==time)) { //date
						found = true;
						break;
					}
				}
			}
			assertFalse("Failed to reserve appointment",found);
		}
		catch(Throwable e) {
			Assert.fail("Failed to reserve appointment");
		}
		
		
		try {
			succ = resp.reserve_appointment(id2,date,time, ID,Name);//date
			assertFalse("Reserve the same appointment twice", succ);
		}
		catch(Throwable e) {
			Assert.fail("Reserve the same appointment twice");
		}
		
		
		try {
			time = LocalTime.of(17,15);
			try {
				succ = doc.add_appointment(date,time); //date
				assertTrue("Failed to add appointment",succ);
			}
			catch(Throwable e) {
				Assert.fail("Failed to add appointment");
			}
			succ = resp.reserve_appointment(id2,date,time, "77779",Name);//date
			assertFalse("Reserve appointment for non exist patient", succ);
		}
		catch(Throwable e) {
			Assert.fail("Reserve appointment for non exist patient");
		}
		
		
		try {
			succ = resp.reserve_appointment("7779",date,time, ID,Name);//date
			assertFalse("Reserve appointment with wrong doctor id", succ);
		}
		catch(Throwable e) {
			Assert.fail("Reserve appointment with wrong doctor id");
		}
		
		
		try {
			succ = resp.reserve_appointment(id2,date,time.plusHours(3), ID,Name);//wrong date
			assertFalse("Reserve non exist appointment", succ);
		}
		catch(Throwable e) {
			Assert.fail("Reserve non exist appointment");
		}
		
		
		Doctor doc2 = new Doctor();
		String id3 = "3"; //correct id
		String password3 = "564"; //correct password
		try {
		boolean succD = doc2.login(id3, password3);
		assertTrue("Failed to login",succD);
		}
		catch(Throwable e) {
			Assert.fail("Failed to login");
		}
		
		
		try {
			time = LocalTime.of(12, 45);
			doc2.add_appointment(date,time); //same date
			succ = resp.reserve_appointment(id3,date,time, ID,Name);//same date
			assertFalse("Reserve two appointments at the same time for one patient", succ);
		}
		catch(Throwable e) {
			Assert.fail("Reserve two appointments at the same time for one patient");
		}
	}
}
