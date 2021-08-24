package task23.DAO;

import org.springframework.stereotype.Service;
import task23.DAO.interfaces.ProfileDAOInterface;
import task23.DAO.repositories.ProfileDAORepository;
import task23.entity.User;
import task23.menus.intefaces.MainMenuInterface;

import java.sql.SQLException;
@Service
public class ProfileDAO implements ProfileDAOInterface {
    private MainMenuInterface mainMenuInterface;
    ProfileDAORepository profileDAORepository;

    public ProfileDAO(MainMenuInterface mainMenuInterface) throws SQLException {
        this.mainMenuInterface = mainMenuInterface;
    }

    public ProfileDAO() throws SQLException {
    }

    public void changeInfo(User user) throws SQLException {
        profileDAORepository.save(user);
        mainMenuInterface.run();
    }

    public void delProfile(User user) throws SQLException {
        profileDAORepository.delete(profileDAORepository.getOne(user.getLogin()));
        mainMenuInterface.run();
    }
}
