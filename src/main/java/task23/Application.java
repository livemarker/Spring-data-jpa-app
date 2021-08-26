package task23;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import task23.menus.AdminMenu;
import task23.menus.MainMenu;


import java.sql.SQLException;


@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        ctx.getBean(MainMenu.class).run();
    }
}
