/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahashop.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author INT105
 */
public class AhashopG4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
//        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/aha_shop(1)","app","app");
//       
//        Statement st =conn.createStatement();
//        st.executeUpdate("INSERT INTO product VALUES(24,'Watch',200)");
//        st.executeUpdate("UPDATE product SET price = 2000 WHERE product_id =24");
//          ResultSet rs= st.executeQuery("SELECT * FROM order_item");
//          System.out.println("|\tOrder id\tProduct id\tQuantity\tPrice\t|");
//          while(rs.next()){
//              System.out.println("|\t"+rs.getInt(1)+"\t|\t"+rs.getInt(2)+"\t|\t"+rs.getInt(3)+"\t|\t"+rs.getDouble(4)+"\t|");
//          }
//          System.out.println("******************************************************************************************************************************");
//          System.out.println("|\tOrder id\tProduct Name\t\t\t\tQuantity\tProduct price\t\tTotal\t\tStatus\t|");
//          rs = st.executeQuery("SELECT ORDER_ITEM.ORDER_ID,PRODUCT.PRODUCT_NAME,ORDER_ITEM.QUANTITY,ORDER_ITEM.PRODUCT_PRICE,(ORDER_ITEM.QUANTITY*ORDER_ITEM.PRODUCT_PRICE) as total ,ORDERS.STATUS FROM order_item JOIN product ON order_item.PRODUCT_ID=product.PRODUCT_ID  JOIN ORDERS ON ORDER_ITEM.ORDER_ID=ORDERS.ORDER_ID  WHERE ORDER_ITEM.ORDER_ID=51");
//          double total=0;
//          while(rs.next()){
//              total += rs.getDouble("total");
//              System.out.println("|\t"+rs.getInt(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getInt(3)+"\t|\t"+rs.getInt(4)+"\t|\t"+rs.getFloat(5)+"\t|\t"+rs.getString(6));
//          }
//          System.out.println("Total Price = "+total);
//          conn.close();

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/aha_shop(1)","app","app");
            
            Statement st =conn.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM product");
            Product prod ;
            
//            while(rs.next()){
//                prod = new Product (rs.getInt("product_id"),rs.getString("product_name"),rs.getDouble("price"));
//                System.out.println(prod.toString());
//            }
            
            
//            Product p = Product.findById(20);
//            System.out.println(p);
//              Product temp = new Product(300,"Mouse",100);
//              temp.updateProduct();
              Product temp = Product.findById(300);
              temp.setPrice(200);
              temp.updateProduct();
            conn.close();
    }
    
}
