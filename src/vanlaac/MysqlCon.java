package vanlaac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlCon {
	
	//jdbc:mysql://DESKTOP-G9JJ6ER\\SQLEXPRESS1/BD_maintenance","",""

	private String url=	"jdbc:mysql://DESKTOP-G9JJ6ER\\SQLEXPRESS1/BD_maintenance";
	private String username="";
	private String password="";
	private Connection cnx;
	private static MysqlCon instance;

	public MysqlCon() {
		// TODO Auto-generated constructor stub
		try {
			this.cnx=DriverManager.getConnection(url,username,password);
			System.out.println("Database Connceted");
				} catch(SQLException ex){
					Logger.getLogger(MysqlCon.class.getName()).log(Level.SEVERE,null,ex);
					
				}
	}
	
	public Connection getCnx() {
		return cnx;
	}
	public static MysqlCon getInstance(){
		if(instance==null) {
			instance=new
			MysqlCon();
			
		}
		return instance;
	}

}
