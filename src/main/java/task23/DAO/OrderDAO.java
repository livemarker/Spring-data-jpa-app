package task23.DAO;

import org.springframework.stereotype.Service;
import task23.DAO.interfaces.OrderDAOInterface;
import task23.DAO.repositories.ListOrdersDAORepository;
import task23.DAO.repositories.OrderDAORepository;
import task23.entity.ListOrders;
import task23.entity.Product;
import task23.entity.User;
import task23.entity.Order;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDAO implements OrderDAOInterface {
    private ListOrdersDAORepository listOrdersDAORepository;
    private OrderDAORepository orderDAORepository;

    public OrderDAO() throws SQLException {
    }

    public List<Order> getOrderList(User user) throws SQLException {
        List<Order> orders = new ArrayList<>();
//        String tableName = user.getFirstName() + "_" + user.getLastName();
//
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName + ";");
//
//        Order order;
//        while (rs.next()) {
//            order = new Order(rs.getInt(1),
//                    rs.getString(2),
//                    rs.getDouble(3),
//                    rs.getString(4),
//                    rs.getString(5));
//            orders.add(order);
//        }
        return orders;
    }

    public void addOrder(ListOrders listOrders,Order order) throws SQLException {
        listOrdersDAORepository.save(listOrders);
        orderDAORepository.save(order);
//
//
//        String tableName = user.getFirstName() + "_" + user.getLastName();
//
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM  users " +
//                "WHERE \"Имя\"=\'" + user.getFirstName() + "\' " +
//                "AND  \"Фамилия\"=\'" + user.getLastName() + "\'");
//
//        String create =
//                " create table if not exists " + tableName + "(order_number INT, name_Product VARCHAR, price DECIMAL, category VARCHAR, status VARCHAR);";
//        PreparedStatement pss = connection.prepareStatement(create);
//        pss.executeUpdate();
//
//        int id = generator(tableName);
//        String add = " INSERT INTO " + tableName + " values (?,?,?,?,?);";
//        while (resultSet.next()) {
//            for (Product p : products) {
//                PreparedStatement ps = connection.prepareStatement(add);
//                ps.setInt(1, id);
//                ps.setString(2, p.getName());
//                ps.setDouble(3, p.getPrice());
//                ps.setString(4, p.getCategory());
//                ps.setString(5, "Подготовка к отправке");
//                ps.executeUpdate();
          //  }
       // }
    }
}
