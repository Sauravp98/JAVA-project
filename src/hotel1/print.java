package hotel1;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class print {
    public static void main(String[] args)
    {    Connection con = null;
        String url="jdbc:derby://localhost:1527/panda";
   String username="panda";
   String password="12345";
   String Query="select* from COSTUMERS";
   try{
         
       con=DriverManager.getConnection(url,username,password);
   }
   catch(SQLException e)
   {
       System.out.println(e);
   }
           
         try(Statement tmt=con.createStatement())
        {
             ResultSet r=tmt.executeQuery(Query);
             ResultSetMetaData rsdm=r.getMetaData();
             r.next();
             
             System.out.println("No of attributes equals "+rsdm.getColumnCount());
             System.out.println("attributes of table\n");
             for(int i=1;i<=rsdm.getColumnCount();i++)
             {
                 System.out.println(rsdm.getColumnName(i)+" : " + rsdm.getColumnTypeName(i));
             }
             
        }
catch (Exception ex) {
           System.out.println("Error"+ ex);
        
}
        }}