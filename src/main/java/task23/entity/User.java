package task23.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.SQLException;

@Component
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(unique = true)
    private String login;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String phoneNumber;

    public User(String login, String firstName, String lastName, String address, String phoneNumber) throws SQLException {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User(String login) {
        this.login = login;

    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
