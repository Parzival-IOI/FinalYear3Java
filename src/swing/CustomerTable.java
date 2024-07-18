package swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CustomerTable {

//   create table customers (
//      customer_id int auto_increment primary key,
//      customer_last_name  varchar(50) not null,
//      customer_first_name varchar(50) not null,
//      customer_phone varchar(50) not null,
//   );

    public Connection connection;
    public CustomerTable() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Parzival","root", "1234");
        System.out.println("connection established");
    }
    public void select() throws SQLException {
        String query = "select * from customers";
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query);

        JFrame f = new JFrame("Customer Table Parzival");

        JLabel id = new JLabel("ID: ");
        JLabel firstName = new JLabel("Last Name: ");
        JLabel lastName = new JLabel("First Name: ");
        JLabel phone = new JLabel("Phone: ");

        JLabel idValue = new JLabel("");
        JLabel firstNameValue = new JLabel("");
        JLabel lastNameValue = new JLabel("");
        JLabel phoneValue = new JLabel("");

        JButton pre = new JButton("Previous");
        JButton next = new JButton("Next");


        id.setBounds(5, 5, 190, 55);
        idValue.setBounds(200, 5, 190, 55);

        lastName.setBounds(5, 60, 190, 55);
        lastNameValue.setBounds(200, 60, 190, 55);

        firstName.setBounds(5, 120, 190, 55);
        firstNameValue.setBounds(200, 120, 190, 55);

        phone.setBounds(5, 180, 190, 55);
        phoneValue.setBounds(200, 180, 190, 55);
        
        pre.setBounds(5, 240, 190, 55);
        next.setBounds(200, 240, 190, 55);

        f.add(id);
        f.add(idValue);

        f.add(lastName);
        f.add(lastNameValue);

        f.add(firstName);
        f.add(firstNameValue);

        f.add(phone);
        f.add(phoneValue);

        f.add(pre);
        f.add(next);

        resultSet.next();
        idValue.setText(resultSet.getString(1));
        lastNameValue.setText(resultSet.getString(2));
        firstNameValue.setText(resultSet.getString(3));
        phoneValue.setText(resultSet.getString(4));

        pre.addActionListener(e -> {
            try {
                resultSet.previous();
                idValue.setText(resultSet.getString(1));
                lastNameValue.setText(resultSet.getString(2));
                firstNameValue.setText(resultSet.getString(3));
                phoneValue.setText(resultSet.getString(4));

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        next.addActionListener(e -> {
            try {
                resultSet.next();
                idValue.setText(resultSet.getString(1));
                lastNameValue.setText(resultSet.getString(2));
                firstNameValue.setText(resultSet.getString(3));
                phoneValue.setText(resultSet.getString(4));

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);


//        while (resultSet.next()) {
//            System.out.println("Id : " + resultSet.getInt("customer_id"));
//            System.out.println("first Name" + resultSet.getString("customer_first_name"));
//            System.out.println("last Name" + resultSet.getString("customer_last_name"));
//            System.out.println("phone" + resultSet.getString("customer_phone"));
//        }
//
//        while (resultSet.previous()) {
//            System.out.println("Id : " + resultSet.getInt("customer_id"));
//            System.out.println("first Name" + resultSet.getString("customer_first_name"));
//            System.out.println("last Name" + resultSet.getString("customer_last_name"));
//            System.out.println("phone" + resultSet.getString("customer_phone"));
//        }
    }
}
