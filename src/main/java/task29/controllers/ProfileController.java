package task29.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import task29.DAO.interfaces.ProfileDAOInterface;
import task29.DAO.interfaces.UserDAOInterface;
import task29.entity.User;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProfileController {
    private UserDAOInterface userDAOInterface;
    private ProfileDAOInterface profileDAOInterface;

    @GetMapping(value = "/profile", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User getProfile(@RequestParam String login) {
        User user = userDAOInterface.load(login);
        return user;
    }

    @PostMapping("/profile/new")
    public void createNewUser(@RequestBody User user) {
        userDAOInterface.save(user);
    }

    @Transactional
    @Modifying
    @PutMapping("/profile/update")
    public void changeInfo(@RequestParam String login, @RequestBody User user) throws SQLException {
        User newInfo = new User(
                login,
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getPhoneNumber());
        userDAOInterface.save(newInfo);
    }


    @GetMapping(value = "/profile/all", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return profileDAOInterface.getAllUsers();
    }


    @Transactional
    @Modifying
    @DeleteMapping(value = "/profile/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delUser(@RequestParam("login") String login) throws SQLException {
        profileDAOInterface.delProfile(login);
    }

    @Autowired
    public void setProfileDAOInterface(ProfileDAOInterface profileDAOInterface) {
        this.profileDAOInterface = profileDAOInterface;
    }

    @Autowired
    public void setUserDAOInterface(UserDAOInterface userDAOInterface) {
        this.userDAOInterface = userDAOInterface;
    }
}
