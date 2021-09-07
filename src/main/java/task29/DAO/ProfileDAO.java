package task29.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task29.DAO.interfaces.ProfileDAOInterface;
import task29.DAO.repositories.ProfileDAORepository;
import task29.entity.User;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProfileDAO implements ProfileDAOInterface {
    private ProfileDAORepository profileDAORepository;


    public ProfileDAO() {
    }


    public void delProfile(String login) throws SQLException {
        profileDAORepository.deleteById(login);
    }

    @Autowired
    public void setProfileDAORepository(ProfileDAORepository profileDAORepository) {
        this.profileDAORepository = profileDAORepository;
    }

    public List<User> getAllUsers() {
        return profileDAORepository.getAllByLoginNotNull();
    }
}
