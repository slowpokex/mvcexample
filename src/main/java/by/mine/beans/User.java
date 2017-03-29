package by.mine.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Package: by.mine.beans
 * Project name: mvc
 * Created by Mikita Isakau
 * Creation date: 15.02.2017
 */
@Entity
@Table(name = "users")
public class User {

    public enum Roles {
        GUEST, USER, ADMIN, MODERATOR
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "login", nullable = false)
    private String login;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role;

    public User(String login, String password, Roles role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
        this("","", Roles.GUEST);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                role == user.role &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", admin=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
