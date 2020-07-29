import java.sql.*;


public class Validate {
	public static String gpin;
	//static final String dbClass = "com.mysql.jdbc.Driver";
    public static boolean checkUser(String username,String pin) 
    {
    	
    	 boolean st =false;
         try {

             //loading drivers for mysql
             Class.forName("com.mysql.jdbc.Driver").newInstance();

             //creating connection with the database
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oejava","root","Sunny#2002@");
         	System.out.println("Username and pin are in validate:\t"+username+pin);
         	System.out.println("here");
             PreparedStatement ps = con.prepareStatement("select * from info where username = ?and pin =?");
             System.out.println("here");
             ps.setString(1, username);
             System.out.println("here");
             ps.setString(2, pin);
            
             System.out.println("here");
             gpin=pin;
             System.out.println("here");
             System.out.println("Gpin is :\t"+gpin);
             ResultSet rs =ps.executeQuery();
             st = rs.next();
             con.close();
         }
         catch(Exception e) {
             e.printStackTrace();
         }
         return st;                 
                      
    }   
    public static int updateBal(int b) 
    {
    	
    int st=0;
    try{
    		 Class.forName("com.mysql.jdbc.Driver").newInstance();
       	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oejava","root","Sunny#2002@");
             //Statement st=con.createStatement();
//             ResultSet rs=st.executeQuery("select * from bank where Acno="+acno);
//             int totbal=0;
//             while(rs.next())
//                        {
//                                                             int s1=rs.getInt(5);
//                                                            
//                                                             totbal=s1-iamount;
//                                                             if(totbal<=0)
//                                                             {
//                                                             out.println("Your amount is credited you have to pay Rs"+totbal);
//                                                             }
//                                                             else
//                                                             {
//                                                             out.println("Your amount is credited Your balance is"+totbal);
//                                                             }
//                                     }
//                                    
              PreparedStatement pstmt = con.prepareStatement("update info set balance=balance+? where pin="+gpin);
              pstmt.setInt(1,b);
              st = pstmt.executeUpdate();
       	  
       	   con.close();
    	 }
    	  catch(Exception e) {
              e.printStackTrace();
          }
    	
    	 return st;
    }
    public static int debitBal(int b) 
    {
    	
    int st=0;
    try{
    		 Class.forName("com.mysql.jdbc.Driver").newInstance();
       	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oejava","root","Sunny#2002@");
             //Statement st=con.createStatement();
//             ResultSet rs=st.executeQuery("select * from bank where Acno="+acno);
//             int totbal=0;
//             while(rs.next())
//                        {
//                                                             int s1=rs.getInt(5);
//                                                            
//                                                             totbal=s1-iamount;
//                                                             if(totbal<=0)
//                                                             {
//                                                             out.println("Your amount is credited you have to pay Rs"+totbal);
//                                                             }
//                                                             else
//                                                             {
//                                                             out.println("Your amount is credited Your balance is"+totbal);
//                                                             }
//                                     }
//                                    
              PreparedStatement pstmt = con.prepareStatement("update info set balance=balance-? where pin="+gpin);
              pstmt.setInt(1,b);
              st = pstmt.executeUpdate();
       	  
       	   con.close();
    	 }
    	  catch(Exception e) {
              e.printStackTrace();
          }
    	
    	 return st;
    }
    
    
    public static int transferAmt(int amt,String username) 
    {
    	
    int st=0;
    try{
    		 Class.forName("com.mysql.jdbc.Driver").newInstance();
       	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oejava","root","Sunny#2002@");
             //Statement st=con.createStatement();
//             ResultSet rs=st.executeQuery("select * from bank where Acno="+acno);
//             int totbal=0;
//             while(rs.next())
//                        {
//                                                             int s1=rs.getInt(5);
//                                                            
//                                                             totbal=s1-iamount;
//                                                             if(totbal<=0)
//                                                             {
//                                                             out.println("Your amount is credited you have to pay Rs"+totbal);
//                                                             }
//                                                             else
//                                                             {
//                                                             out.println("Your amount is credited Your balance is"+totbal);
//                                                             }
//                                     }
//                                    
              PreparedStatement pstmt = con.prepareStatement("update info set balance=balance+? where username=? ");
              
//              PreparedStatement pstmt1 = con.prepareStatement();
//              pstmt1.setInt(1,amt);
//              st=pstmt1.executeUpdate();
              
              pstmt.setInt(1,amt);
              pstmt.setString(2, username);
              debitBal(amt);
              st = pstmt.executeUpdate();
       	  
       	   con.close();
    	 }
    	  catch(Exception e) {
              e.printStackTrace();
          }
    	
    	 return st;
    }
    }