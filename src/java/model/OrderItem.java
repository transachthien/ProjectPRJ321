/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author trans
 */
public class OrderItem {

    private int OrderItemID;
    private int OrderID;
    private int ProductID;
    private int Quantity;

    public OrderItem() {
        connect();
    }

    public OrderItem(int OrderItemID, int OrderID, int ProductID, int Quantity) {
        this.OrderItemID = OrderItemID;
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        connect();
    }

    public int getOrderItemID() {
        return OrderItemID;
    }

    public void setOrderItemID(int OrderItemID) {
        this.OrderItemID = OrderItemID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
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
            String strInsert = "INSERT INTO tblOrderItem (OrderID, ProductID, Quantity) values("+OrderID + "," + ProductID + "," + Quantity +")";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strInsert);

        } catch (Exception e) {
            System.out.println("Loi insert tblOrderItem" + e.getMessage());
        }
    }
    
}
