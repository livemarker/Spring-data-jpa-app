package task23.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task23.entity.Order;
import task23.entity.Product;
import task23.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Component
//
public class OrderDAO  {
//    Connection connection = new DBWorker().getConnection();
//    OrderRepository orderRepository;
//
//    public OrderDAO(OrderRepository orderRepository) throws SQLException {
//        this.orderRepository=orderRepository;
//    }
//private Order getOrder(User user, List<Product> products){
//        return new Order(1,user.)
//}
////
////    public List<Order> getOrderList(User user) throws SQLException {
////        List<Order> orders = new ArrayList<>();
////        String tableName = user.getFirstName() + "_" + user.getLastName();
////
////        Statement statement = connection.createStatement();
////        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName + ";");
////
////        Order order;
////        while (rs.next()) {
////            order = new Order(rs.getInt(1),
////                    rs.getString(2),
////                    rs.getDouble(3),
////                    rs.getString(4),
////                    rs.getString(5));
////            orders.add(order);
////        }
////        return orders;
////    }
////
////    public void addOrder(User user, List<Product> products) throws SQLException {
////        String tableName = user.getFirstName() + "_" + user.getLastName();
////
////        Statement statement = connection.createStatement();
////        ResultSet resultSet = statement.executeQuery("SELECT * FROM  users " +
////                "WHERE \"Имя\"=\'" + user.getFirstName() + "\' " +
////                "AND  \"Фамилия\"=\'" + user.getLastName() + "\'");
////
////        String create =
////                " create table if not exists " + tableName + "(order_number INT, name_Product VARCHAR, price DECIMAL, category VARCHAR, status VARCHAR);";
////        PreparedStatement pss = connection.prepareStatement(create);
////        pss.executeUpdate();
////
////        int id = generator(tableName);
////        String add = " INSERT INTO " + tableName + " values (?,?,?,?,?);";
////        while (resultSet.next()) {
////            for (Product p : products) {
////                PreparedStatement ps = connection.prepareStatement(add);
////                ps.setInt(1, id);
////                ps.setString(2, p.getName());
////                ps.setDouble(3, p.getPrice());
////                ps.setString(4, p.getCategory());
////                ps.setString(5, "Подготовка к отправке");
////                ps.executeUpdate();
////            }
////        }
////    }
//
//    private int generator(String table) throws SQLException {
//        String order_number = "order_number";
//        String sql = "SELECT * FROM " + table +
//                " WHERE " + order_number + " = (SELECT max(" + order_number + ") FROM " + table + ");";
//
//        PreparedStatement ps = connection.prepareStatement(sql);
//        ResultSet resultSet = ps.executeQuery();
//        while (resultSet.next()) {
//            return resultSet.getInt(1) + 1;
//        }
//        return 1;
//    }
//
//    @Override
//    public List<Order> getOrderList(User user) {
//        return null;
//    }
//
//    @Override
//    public void addOrder(User user, List<Product> products) {
//orderRepository.s
//    }
}
