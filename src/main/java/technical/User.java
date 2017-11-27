package technical;
import java.util.Random;

/**
 * Created by alex on 10.03.2017.
 */
public class User {
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public String FirstName = "Rob";
    public String Lastname = "Kawalski";
    public String DOB = "05/21/1970";
    public String EMail =   getSaltString()+"@gmail.com";
    public String Telephone = "+44567-56-65";
    public String Address = "Brookyn st, 45";
    public String City = "New york";
    public String PostCode = "03125";
    public String Password = "156423";

    //Credentials for paypage
    public String Country = "United States";
    public String State = "Alabama";
    public String IssuingBank = "CityBank";
    public String CardNumber = "4444333322221111";
    public String ExpirationMonth = "02";
    public String ExpirationYear = "2020";
    public String CVV2 = "987";
}
