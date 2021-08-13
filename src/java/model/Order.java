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
public class Order {

    private int OrderID;
    private String CustomerIDbuy;
    private String CustomerIDsell;
    private String OrderDate;

    public Order() {
        connect();
    }

    public Order(int OrderID, String CustomerIDbuy, String CustomerIDsell, String OrderDate) {
        this.OrderID = OrderID;
        this.CustomerIDbuy = CustomerIDbuy;
        this.CustomerIDsell = CustomerIDsell;
        this.OrderDate = OrderDate;
        connect();
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getCustomerIDbuy() {
        return CustomerIDbuy;
    }

    public void setCustomerIDbuy(String CustomerIDbuy) {
        this.CustomerIDbuy = CustomerIDbuy;
    }

    public String getCustomerIDsell() {
        return CustomerIDsell;
    }

    public void setCustomerIDsell(String CustomerIDsell) {
        this.CustomerIDsell = CustomerIDsell;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
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
            String strInsert = "INSERT INTO tblOrder ( CustomerIDbuy, CustomerIDsell, OrderDate) values("+ "'" + CustomerIDbuy + "','" + CustomerIDsell +  "','" + OrderDate+"')";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strInsert);

        } catch (Exception e) {
            System.out.println("Loi insert tblOrder" + e.getMessage());
        }
    }
    public int getNumberOfOrder() {
        int order =0;

        //xử lý getlist
        try {
            String strSelect = "select * from tblNumberOfCustomer where khoachinh ='khoachinh'" ;
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {
                int Unit = rs.getInt(2);
                order = Unit;
                return order;
            }
        } catch (Exception e) {
            System.out.println("Get Product error:" + e.getMessage());
        }

        return order;
    }
    public void UpdateNumberOfOrder(int number) {
        try {
            String strupdate = "update tblNumberOfCustomer set NumberOfOrder="+number+"where khoachinh='khoachinh'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strupdate);
            return;
        } catch (Exception e) {
            System.out.println("Lỗi Update: " + e.getMessage());

        }
    }
    
}
