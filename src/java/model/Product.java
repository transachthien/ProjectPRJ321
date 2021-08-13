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
public class Product {

    private int ProductID;
    private String ProductName;
    private int Unit;
    private Float Price;
    private byte[] Image;
    private String Detail;
    private String ProductCreateBy;

    public Product() {
        connect();
    }

    public Product(int ProductID, String ProductName, int Unit, Float Price, byte[] Image, String Detail, String ProductCreateBy) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Unit = Unit;
        this.Price = Price;
        this.Image = Image;
        this.Detail = Detail;
        this.ProductCreateBy = ProductCreateBy;

        connect();
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getUnit() {
        return Unit;
    }

    public void setUnit(int Unit) {
        this.Unit = Unit;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float Price) {
        this.Price = Price;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public String getProductCreateBy() {
        return ProductCreateBy;
    }

    public void setProductCreateBy(String ProductCreateBy) {
        this.ProductCreateBy = ProductCreateBy;
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

    public ArrayList<Product> getList( String username) {
        ArrayList<Product> list = new ArrayList<Product>();

        //xử lý getlist
        try {
            String strSelect = "select * from tblProduct where Unit >0 and ProductCreateBy not in('"+username+"')";
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

    public ArrayList<Product> getListByName(String Name) {
        ArrayList<Product> list = new ArrayList<Product>();

        //xử lý getlist
        try {
            String strSelect = "select * from tblProduct where ProductName like'%" + Name + "%' and Unit >0 ";
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

    public ArrayList<Product> getListYourProduct(String Name) {
        ArrayList<Product> list = new ArrayList<Product>();

        //xử lý getlist
        try {
            String strSelect = "select * from tblProduct where ProductCreateBy ='" + Name + "'";
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
            System.out.println("Get yourProduct error:" + e.getMessage());
        }

        return list;
    }

    public ArrayList<Product> getListByName2(String Name, String yourProduct) {
        ArrayList<Product> list = new ArrayList<Product>();

        //xử lý getlist
        try {
            String strSelect = "select * from tblProduct where ProductName like'%" + Name + "%'and ProductCreateBy = '" + yourProduct + "'";
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

    public int getNumberAccount() {
        int count = 0;
        try {
            String strSelect = "select NumberOfAcount from tblNumberOfCustomer where khoachinh ='khoachinh'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);//Thực hiện câu lệnh select
            while (rs.next()) {

                count = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Get numberOfAccount error:" + e.getMessage());
        }
        return count;
    }

    public void create() {

        try {
            // cau nay khong dk lay dau cach can than sai vo mom o  doan "','"
            String strInsert = "INSERT INTO tblProduct (ProductName, Unit, Price, Image, Detail, ProductCreateBy) values('" + ProductName + "','" + Unit + " ','" + Price + "'," + "null" + ",'" + Detail + "','" + ProductCreateBy + "')";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strInsert);

        } catch (Exception e) {
            System.out.println("Loi insert product" + e.getMessage());
        }
    }

    public void UpdateProduct(int id, String name, int unit, float price) {
        try {
            String strupdate = "update tblProduct set ProductName='" + name + "',Unit=" + unit + ",Price=" + price +"where ProductID=" + id + "";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strupdate);
            return;
        } catch (Exception e) {
            System.out.println("Lỗi Update: " + e.getMessage());

        }
    }
    public void UpdateProductUnit( int unit,int id) {
        try {
            String strupdate = "update tblProduct set Unit="+unit+ "where ProductID=" + id + "";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strupdate);
            return;
        } catch (Exception e) {
            System.out.println("Lỗi Update: " + e.getMessage());

        }
    }


    public void deledteProduct(int ID) {
        try {
            String strupdate = "DELETE FROM tblProduct WHERE ProductID=" + ID;
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.execute(strupdate);
            return;
        } catch (Exception e) {
            System.out.println("Lỗi Delete: " + e.getMessage());

        }
    }
    public Product getProduct(int Name) {
        Product list = new Product();

        //xử lý getlist
        try {
            String strSelect = "select * from tblProduct where ProductID =" + Name+"";
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
                list = u;
            }
        } catch (Exception e) {
            System.out.println("Get Product error:" + e.getMessage());
        }

        return list;
    }
}
