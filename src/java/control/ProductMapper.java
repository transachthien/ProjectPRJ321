/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import model.Product;

/**
 *
 * @author trans
 */
public class ProductMapper implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductID(rs.getInt("ProductID"));
        product.setProductName(rs.getString("ProductName"));
        product.setUnit(rs.getInt("Unit"));
        product.setPrice(rs.getFloat("Price"));
        product.setImage(rs.getBytes("Image"));
        product.setDetail(rs.getString("Detail"));
        product.setProductCreateBy(rs.getString("ProductCreateBy"));
        
        return product;
        
    }
    
}
