package freeplace.lla.model.springforms;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

    @Size(message = "Value must be between 2 and 15 characters", min = 2, max = 15)
    @NotEmpty(message = "Please enter your name.")
    private String name;
    @Size(message = "Value must be between 2 and 15 characters", min = 2, max = 15)
    @NotEmpty(message = "Please enter your last name.")
    private String lastName;
    @NotEmpty(message = "Please select your native language.")
    private String nativeLanguage;

    @Email(message = "Please enter valid email")
    @NotEmpty(message = "Please enter email")
    private String email;
    @Size(message = "Value must be between 2 and 15 characters", min = 2, max = 15)
    @NotEmpty(message = "Please enter login")
    private String login;
    @Size(message = "Value must be between 6 and 15 characters", min = 6, max = 15)    
    @NotEmpty(message = "Please enter password")
    private String password;
    @Size(message = "Value must be between 6 and 15 characters", min = 6, max = 15) 
    @NotEmpty(message = "Please repeat password")
    private String repeatedPassword;
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }
}
