package task30.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task30.DAO.interfaces.ProfileDAOInterface;
import task30.DAO.repositories.ProfileDAORepository;
import task30.entity.User;

import java.sql.SQLException;

@Service
public class ProfileDAO implements ProfileDAOInterface {
    private ProfileDAORepository profileDAORepository;


    public ProfileDAO() {
    }

    public void changeInfo(User user) {
        profileDAORepository.save(user);

    }

    public void delProfile(User user) {
        profileDAORepository.delete(profileDAORepository.getOne(user.getLogin()));

    }

    @Autowired
    public void setProfileDAORepository(ProfileDAORepository profileDAORepository) {
        this.profileDAORepository = profileDAORepository;
    }
}
