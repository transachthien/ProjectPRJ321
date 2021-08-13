/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author trans
 */
public class Cart {
    private int CartID;
    private String username;
     private int ProductID; 

    public Cart() {
        connect();
    }

    public Cart(int CartID, String username, int ProductID) {
        this.CartID = CartID;
        this.username = username;
        this.ProductID = ProductID;
        connect();
    }
    Connection cnn;
    Statement stm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).getConnection();
            System.out.println("ket noi thanh cong");
        } catch (Exception e) {
            System.out.println("loi connect" + e.getMessage());
        }

    }
    public void create() {

        try {
            // cau nay khong dk lay dau cach can than sai vo mom o  doan "','"
            String strInsert = "INSERT INTO tblCart (username, ProductID) values('" + username + "','" + ProductID +"')";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strInsert);

        } catch (Exception e) {
            System.out.println("Loi insert Cart" + e.getMessage());
        }
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int CartID) {
        this.CartID = CartID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    public ArrayList<Product> getProducttoCart(String username){
        ArrayList<Product> list = new ArrayList<>();
        try {
            String strSelect = "select a.ProductID,a.ProductName,a.Unit,a.Price,a.Image,a.Detail,a.ProductCreateBy from tblProduct as a, tblCart as b,tblUser as c   where a.ProductID = b.ProductID and  b.username = c.username and c.username ='"+username+"'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {

                int ProductID = rs.getInt(1);
                String ProductName = rs.getString(2);
                int Unit = rs.getInt(3);
                float Price = rs.getFloat(4);
                byte[] Image = rs.getBytes(5);
                String Detail = rs.getString(6);
                String ProductCreateBy = rs.getString(7);

                Product u = new Product(ProductID, ProductName, Unit, Price, Image, Detail, ProductCreateBy);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("Get Product error:" + e.getMessage());
        }
        
        return list;
    }
    public boolean checkCart(String username,int ProductID){
        try {
            String strSelect = "select *from tblCart where username ='"+username+"'and ProductID="+ProductID+"";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("check your Cart Error:" + e.getMessage());
        }
        
        
        return true;
    }
    public void deleteCart(int ID,String username ) {
        try {
            String strupdate = "DELETE FROM tblCart WHERE ProductID=" + ID+" and username='"+username+"'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strupdate);
            return;
        } catch (Exception e) {
            System.out.println("Lỗi Delete: " + e.getMessage());

        }
    }
    
}
