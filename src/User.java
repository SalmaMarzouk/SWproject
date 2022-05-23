public class User {
    private String ID;
    private String password;
    private boolean isDoctor;



    public void login(String ID,String password){
        this.ID = ID;
        this.password = password;
        //validate user (check if ID exists, if the password true)
        //check if isDoctor ---> isDoctor = true
    }

}
