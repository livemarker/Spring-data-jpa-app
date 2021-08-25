package task23.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task23.DAO.interfaces.SupportDAOInterface;
import task23.entity.Ticket;
import task23.entity.User;
import task23.menus.intefaces.SupportMenuInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
public class SupportMenu implements SupportMenuInterface {

    private User user;
    private Scanner sc = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private SupportDAOInterface supportDAOInterface;

    public void run(User user) throws SQLException {
        this.user = user;
        System.out.println("--------------");
        System.out.println("Меню тех. поддержки");
        System.out.println("1. Написать обращение");
        System.out.println("2. Посмотреть отправленные обращения");
        System.out.println("");
        System.out.println("Выйти в меню аккаунта: -1");
        int choice = sc.nextInt();
        if (choice == 1) {
            try {
                createTicket();
            } catch (IOException e) {
            }
        } else if (choice == 2) {
            getTickets();
        } else if (choice == -1) {

        } else {
            run(user);
        }
    }

    private void createTicket() throws SQLException, IOException {
        System.out.println("");
        System.out.println("Создание обращения, введите тему обращения:");
        String topic = br.readLine();
        System.out.println("Введите сообщение");
        String text = br.readLine();
        String status = "в процессе рассмотрения";
        supportDAOInterface.addTicket(new Ticket(null, user.getLogin(), topic, text, status));
        run(user);
    }

    private void getTickets() throws SQLException {
        System.out.println("--------------");
        System.out.println("Мои обращения:");
        List<Ticket> tickets = supportDAOInterface.getTicket(user);
        if (!tickets.isEmpty()) {
            System.out.println(tickets.toString());
        } else {
            System.out.println("Список обращений пуст");
        }
        run(user);
    }

    @Autowired
    public void setSupportDAOInterface(SupportDAOInterface supportDAOInterface) {
        this.supportDAOInterface = supportDAOInterface;
    }
}
