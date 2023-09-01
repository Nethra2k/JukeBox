package login.com;

public class UserDetails
{
    String name;
    String emailId;
    String password;
    String gender;
    int age;


    public UserDetails(String name, String emailId, String password, String gender, int age)
    {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }


    @Override
    public String toString()
    {
        return "UserDetails{" +
                "name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
