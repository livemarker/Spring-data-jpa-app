package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.DAO.interfaces.ProfileDAOInterface;
import task23.entity.User;
import task23.menus.intefaces.AccountMenuInterface;
import task23.menus.intefaces.MainMenuInterface;
import task23.menus.intefaces.ProfileMenuInterface;

import java.sql.SQLException;
import java.util.Scanner;

@Service
public class ProfileMenu implements ProfileMenuInterface {
    private Scanner sc = new Scanner(System.in);
    private AccountMenuInterface accountMenuInterface;
    private ProfileDAOInterface profileDAOInterface;
    private MainMenuInterface mainMenuInterface;
    private User user ;
    public void run() throws SQLException {
        System.out.println("-------------------");
        System.out.println("Информация о профиле:");
        System.out.println(user.toString());
        System.out.println("");
        System.out.println("1.  Изменить информацию");
        System.out.println("2.  Удалить профиль");
        System.out.println("3.  Вернуться в меню аккаунта");

        int choice = sc.nextInt();
        if (choice == 1) {
            changeInfo();
            run();
        } else if (choice == 2) {
            delProfile();
        } else if (choice == 3) {
            accountMenuInterface.run();
        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            run();
        }
    }

    private void changeInfo() throws SQLException {
        System.out.println("-------------------");
        System.out.println("Изменение данных");
        System.out.println("Текущее имя: " + user.getFirstName() + " изменить на ");
        String firstNameTemp = sc.next();

        System.out.println("Текущая фамилия: " + user.getLastName() + " изменить на ");
        String lastNameTemp = sc.next();

        System.out.println("Текущий адрес: " + user.getAddress() + " изменить на ");
        String addressTemp = sc.next();

        System.out.println("Текущее телефон: " + user.getPhoneNumber() + " изменить на ");
        String phoneNumberTemp = sc.next();

        user = new User(user.getLogin(), firstNameTemp, lastNameTemp, addressTemp, phoneNumberTemp);
        profileDAOInterface.changeInfo(user);

    }

    private void delProfile() throws SQLException {
        System.out.println("-------------------");
        System.out.println("Вы действительно хотите удалить профиль?");
        System.out.println("1.  Да");
        System.out.println("2.  Нет");
        int choice = sc.nextInt();

        if (choice == 1) {
            profileDAOInterface.delProfile(user);
        } else if (choice == 2) {
            accountMenuInterface.run();

        } else {
            System.out.println("Выберите правильный пункт меню");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }

    @Autowired
    public void setAccountMenuInterface(AccountMenuInterface accountMenuInterface) {
        this.accountMenuInterface = accountMenuInterface;
    }

    @Autowired
    public void setProfileDAOInterface(ProfileDAOInterface profileDAOInterface) {
        this.profileDAOInterface = profileDAOInterface;
    }

    @Autowired
    public void setMainMenuInterface(MainMenuInterface mainMenuInterface) {
        this.mainMenuInterface = mainMenuInterface;
    }
}
