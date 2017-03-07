package by.mine.beans;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * Created by harle on 02.03.2017.
 */

@Component
@ManagedResource(objectName = "by.mine.beans:name=User")
public class User {

    private String login;
    private String fullName;

    public User() { }

    @ManagedAttribute
    public String getLogin() {
        return login;
    }

    @ManagedAttribute
    public void setLogin(String login) {
        this.login = login;
    }

    @ManagedAttribute
    public String getFullName() {
        return fullName;
    }

    @ManagedAttribute
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ManagedOperation
    public void sayHello() {
        System.out.println(this + " be here!");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("login='").append(login).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
