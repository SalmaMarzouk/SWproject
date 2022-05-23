public class User {
    protected String ID;
    protected String name;
    protected String password;
    protected boolean isDoctor;



    public void login(String ID,String password){
        this.ID = ID;
        this.password = password;
        //validate user (check if ID exists, if the password true)
        //this.name = name
        //check if isDoctor ---> isDoctor = true
    }

}