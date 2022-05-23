public class Patient {
    public String ID;
    public String gender;
    public String name;
    public String age;
    public String address;

    public Patient(String ID,String name, String gender, String age, String address ){
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }
}