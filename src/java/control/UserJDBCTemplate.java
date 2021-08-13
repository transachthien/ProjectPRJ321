/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.sql.DataSource;
import model.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public boolean create(User user) {
        String SQL = "select * from tblUser where username = ?";
        List<User> result = jdbcTemplateObject.query(SQL,new Object[]{user.getUsername()}, new UserMapper());
        if (result.size() > 0) {
            return false;
        }

        SQL = "insert into tblUser (username, password, fullName, idCardNumber, idCardType, address, description) values (?,?,?,?,?,?,?)";

        jdbcTemplateObject.update(SQL, user.getUsername(), user.getPassword(), user.getFullName(),
                user.getIdCardNumber(), user.getIdCardType(), user.getAddress(), user.getDescription());
        return true;
    }
    

    public User getUser(String username) {
        String SQL = "select * from tblUser where username = ?";
        User user = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{username}, new UserMapper());
        return user;
    }

    public List<User> listUsers(String username ) {
        String SQL = "select * from tblUser where username like ?";
        List<User> users = jdbcTemplateObject.query(SQL,
                new Object[]{"%" + username +"%"},
                new UserMapper());
        return users;
    }

    public boolean checkLogin(User user) {
        String SQL = "select * from tblUser where username = ? and password = ?";
        List<User> result = jdbcTemplateObject.query(SQL, new Object[]{user.getUsername(), user.getPassword()}, new UserMapper());
        if (result.size() > 0) {
            return true;
        }
        return false;
    }

    public List<User> listUsers() {
        String SQL = "select * from tblUser";
        List<User> users = jdbcTemplateObject.query(SQL,new UserMapper());
        return users;
    }

    public void delete(String id) {
        String SQL = "delete from tblUser where username = ?";
        jdbcTemplateObject.update(SQL, id);
        return;
    }

    public void updateFullName(User user) {
        String SQL = "update tblUser set fullName = ?,address = ?,idCardNumber = ?,idCardType = ?,description = ? where id = ?";
        jdbcTemplateObject.update(SQL, user.getFullName(),user.getAddress(),user.getIdCardNumber(),user.getIdCardType(),user.getDescription(), user.getId());
        return;
    }
// ham xu ly product description
    public List<Product> listProducts() {
        String SQL = "select * from tblProduct";
        List<Product> products = jdbcTemplateObject.query(SQL,new ProductMapper());
        return products;
    }
    
    
}
