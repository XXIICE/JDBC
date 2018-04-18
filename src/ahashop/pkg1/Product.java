/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahashop.pkg1;

import dbconnection.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INT105
 */
public class Product {

    private int product_id;
    private String product_name;
    private double price;

    public Product(int product_id, String product_name, double price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
    }

    public Product() {
    }

    public int updateProduct() throws ClassNotFoundException, SQLException {
        int result =0;
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
//        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/aha_shop(1)", "app", "app");
        
        Connection conn = DbConnection.getConnection();
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery("SELECT * FROM product where product_id =" + this.product_id);
//        if (rs.next()) {
//            result=st.executeUpdate("update product set product_name ='"+this.product_name+"', price = "+this.price+"where product_id="+this.product_id);
//        }else{
//             result=st.executeUpdate("insert into product values ("+this.product_id+",'"+this.product_name+"',"+this.price+")");
//        }
        PreparedStatement st = conn.prepareStatement("SELECT * FROM product where product_id =?" );
        st.setInt(1, this.product_id);
        
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            st = conn.prepareStatement("update product set product_name =?,price=? where product_id=?" );
            st.setString(1, this.product_name);
            st.setDouble(2, this.price);
            st.setInt(3, this.product_id);
            result=st.executeUpdate();
        }else{
            st = conn.prepareStatement("insert into product values (?,?,?)");
            st.setString(1, this.product_name);
            st.setDouble(2, this.price);
            st.setInt(3, this.product_id);
            result=st.executeUpdate();
        }

        conn.close();
        return result;
    }
    
    
    public static void orm(ResultSet rs,Product prod) throws SQLException{
        prod.setProduct_id(rs.getInt("product_id"));
        prod.setPrice(rs.getDouble("price"));
        prod.setProduct_name(rs.getString("product_name"));
    }

    public static Product findById(int id) throws ClassNotFoundException, SQLException {
        Product prod = null;
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
//        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/aha_shop(1)", "app", "app");
        
        Connection conn = DbConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM product where product_id =" + id);
//        while(rs.next()){
//            prod = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("price"));
////            System.out.println(prod.toString());
//        }
//or
//        if (rs.next()) {
//            prod = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getDouble("price"));
//        }
        if (rs.next()) {
            prod = new Product();
            orm(rs,prod);
        }
        conn.close();
        return prod;

    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", product_name=" + product_name + ", price=" + price + '}';
    }

}
