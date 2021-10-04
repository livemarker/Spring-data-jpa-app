package task30;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.sql.SQLException;


@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
      //  ctx.getBean(MainMenu.class).run();
    }
}
