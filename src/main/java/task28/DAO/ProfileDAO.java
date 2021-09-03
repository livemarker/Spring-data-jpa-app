package task28.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task28.DAO.interfaces.ProfileDAOInterface;
import task28.DAO.repositories.ProfileDAORepository;
import task28.entity.User;

import java.sql.SQLException;

@Service
public class ProfileDAO implements ProfileDAOInterface {
    private ProfileDAORepository profileDAORepository;


    public ProfileDAO() {
    }

    public void changeInfo(User user) throws SQLException {
        profileDAORepository.save(user);
        // signInServiceInterface.run();
    }

    public void delProfile(User user) throws SQLException {
        profileDAORepository.delete(profileDAORepository.getOne(user.getLogin()));
        // signInServiceInterface.run();
    }

    @Autowired
    public void setProfileDAORepository(ProfileDAORepository profileDAORepository) {
        this.profileDAORepository = profileDAORepository;
    }
}
