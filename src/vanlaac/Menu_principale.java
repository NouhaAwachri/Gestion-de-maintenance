package vanlaac;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder; 
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JComboBox;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

import vanlaac.Acceuil;

public class Menu_principale {

	private JFrame frame;
	private JTextField textNomMec;
	private JTextField textDate;
	private JTextField textCodeMa;
	private JTextField textGroupeMa;
	private JTextField textTempsArret;
	private JTable txtTable;

	/**
	 * Launch the application.
	 */
	//lawej kife ta3mel icone fl bureau wla ay fichier.exe
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//dispatch : irseel(renvoi)
			public void run() {
				try {
					Acceuil WA =new Acceuil();
					WA.getFrame().setVisible(true);
					Menu_principale window = new Menu_principale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	//connection BD
	
	Connection connection; 
	PreparedStatement pst;
	ResultSet rs;//acces a enregistrer les informations
	private JTextField textModId;
	private JTextField textSuppId;
	
	public Menu_principale() {
		
		Acceuil A = new Acceuil();
		frame= A.getFrame1();  
        A.initialize();
		initialize();
		Connect();
		
	}
	
	
	public void Connect() {
	
		String url="jdbc:sqlserver://DESKTOP-G9JJ6ER\\SQLEXPRESS1;databaseName=maintenance";
		String username="sa";
		String password="Bizertine-123";
		try{  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection=DriverManager.getConnection(url,username,password); 
			
			System.out.println("connection etablie avec SQL server");
		
			}catch(Exception e){
				System.out.println("error!");
				e.printStackTrace();
				}  
			}  

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Desktop\\eclipse2\\Maintenance\\maintenance vanlaac\\images.jfif"));
		frame.setResizable(false);
		frame.setBounds(100, 100, 636, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textHighlight);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION DE MAINTENANCE");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 6, 580, 62);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 91, 600, 252);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom M\u00E9canicien :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(315, 20, 130, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(325, 61, 130, 30);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Code Machine :");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(24, 20, 130, 30);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Groupe Machine :");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_3_1.setBounds(24, 61, 112, 30);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Temps d' arr\u00EAt  :");
		lblNewLabel_1_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_3_1_1.setBounds(24, 102, 130, 30);
		panel_1.add(lblNewLabel_1_3_1_1);
		
		textNomMec = new JTextField();
		textNomMec.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNomMec.setColumns(10);
		textNomMec.setBounds(433, 24, 130, 20);
		panel_1.add(textNomMec);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDate.setColumns(10);
		textDate.setBounds(433, 65, 130, 20);
		panel_1.add(textDate);
		
		textCodeMa = new JTextField();
		textCodeMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCodeMa.setColumns(10);
		textCodeMa.setBounds(140, 24, 130, 20);
		panel_1.add(textCodeMa);
		
		textGroupeMa = new JTextField();
		textGroupeMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textGroupeMa.setColumns(10);
		textGroupeMa.setBounds(140, 65, 130, 20);
		panel_1.add(textGroupeMa);
		
		textTempsArret = new JTextField();
		textTempsArret.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTempsArret.setColumns(10);
		textTempsArret.setBounds(140, 106, 73, 20);
		panel_1.add(textTempsArret);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
 // ****************************button valider function ***********************************
	 public void actionPerformed(ActionEvent e) {
		 String url="jdbc:sqlserver://DESKTOP-G9JJ6ER\\SQLEXPRESS1;databaseName=maintenance";
			String username="sa";
			String password="Bizertine-123";
				
		 // insertion des donnees dans sql server !!!
		 String codeMachine=textCodeMa.getText();
		 int codeMa=Integer.parseInt(codeMachine);
		 String groupeMa=textGroupeMa.getText();
		 String  tempsArret= textTempsArret.getText();
		 int tempsA=Integer.parseInt(tempsArret);
		 String nomMecanicien= textNomMec.getText();
		 String date= textDate.getText();
		 Date dateOp;
		
		try {
			dateOp = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			 System.out.println(dateOp);
			try{  
				//connection
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection=DriverManager.getConnection(url,username,password);
				System.out.println("connection etablie avec SQL server");
				String query="insert into operation_datails(codeMachine,groupeMachine,tempsArret,nomMecanicien,date)"
				+ "values('"+codeMa+"','"+groupeMa+"','"+tempsA+"','"+nomMecanicien+"','"+date+"')";			  
	         // Statement sta =connection.createStatement();//used to execute a simple sql statment no parametre!
				pst=connection.prepareStatement(query);//execute a simple sql statment with parametre
			    System.out.println("statement sta prepared statement");//sta valide
			    pst.executeUpdate();
				System.out.println("exceute query!");
			    connection.close();
			    System.out.println("con close ! ");
			    JOptionPane.showMessageDialog(null, textNomMec.getText()+"\t Ajout\u00E9");
				}catch(Exception e2){
					 JOptionPane.showMessageDialog(null,"Veuillez entrez des donnes valide svp");
					e2.printStackTrace();
					//*****************************************************************
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						 JOptionPane.showMessageDialog(null,"Veuillez entrez des donnes valide svp");
						e1.printStackTrace();
					}
					//
					try {
						connection = DriverManager.getConnection(url,username,password);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						 JOptionPane.showMessageDialog(null,"Veuillez entrez des donnes valide svp");
						e1.printStackTrace();
					}
					System.out.println("connection etablie avec SQL server");
					String query="insert into operation_datails(codeMachine,groupeMachine,tempsArret,nomMecanicien,date)"
					+ "values('"+codeMa+"','"+groupeMa+"','"+tempsA+"','"+nomMecanicien+"','"+date+"')";			  
		         // Statement sta =connection.createStatement();//used to execute a simple sql statment no parametre!
			
					try {
						pst=connection.prepareStatement(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						 JOptionPane.showMessageDialog(null,"Veuillez entrez des donnes valide svp");
						e1.printStackTrace();
					}//execute a simple sql statment with parametre
				    System.out.println("statement sta prepared statement");//sta valide
				    try {
						pst.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						 JOptionPane.showMessageDialog(null,"Veuillez entrez des donnes valide svp");
						e1.printStackTrace();
					}
	    //try w catch ijiw automatiquement !! 
					System.out.println("exceute query!");
				    try {
						connection.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						 JOptionPane.showMessageDialog(null,"Veuillez entrez des donnes valide svp");
						e1.printStackTrace();
					}
				    System.out.println("con close ! ");
				    JOptionPane.showMessageDialog(null, textNomMec.getText()+"\t Ajout\\u00E9");
					//---------
					}  
				} 
			
		 catch (ParseException e1) {
			// TODO Auto-generated catch block
			 
			e1.printStackTrace();
			 JOptionPane.showMessageDialog(null,"Veuillez entrez une date de la forme jj/mm/aaaaz svp");

		} 
		
		
		 System.out.println(codeMachine);
		 System.out.println(groupeMa);
		 System.out.println(nomMecanicien);
		 System.out.println(tempsArret);
		 System.out.println(date);
		
	 }
	 
		});
		
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(24, 160, 130, 27);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Minutes");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(SystemColor.activeCaptionText);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(221, 109, 49, 15);
		panel_1.add(lblNewLabel_1);
		
		JButton btnAfficher = new JButton("Afficher");
		//**************action performed click AFFICHER 1 TOUS *************
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{  
					 String url="jdbc:sqlserver://DESKTOP-G9JJ6ER\\SQLEXPRESS1;databaseName=maintenance";
					String username="sa";
					String password="Bizertine-123";
						
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection connection=DriverManager.getConnection(url,username,password);
					System.out.println("action performed select * ! ");
					System.out.println("connection etablie avec SQL server");
					String query="select * from  operation_datails";
					Statement stm = connection.createStatement();
				      ResultSet res = stm.executeQuery(query);
				      
				      String columns[] = { "Id Op", "Code Machine", "Groupe Machine","Temps d arret","Nom Mecanicien","Date" };
				      String data[][] = new String[20][6];
				      int i = 0;
				      while (res.next()) {
				        int id = res.getInt("id_op");
				        int codeMachine = res.getInt("codeMachine");
				        String codeMa=String.valueOf(codeMachine);
				        String groupeMa = res.getString("groupeMachine");
				        int tempsArret = res.getInt("tempsArret");
				        String tempsA=String.valueOf(tempsArret);
				        String nomMe = res.getString("nomMecanicien");
				        String date = res.getString("date");
				        data[i][0] = id + "";
				        data[i][1] = codeMa+"";
				        data[i][2] = groupeMa+"";
				        data[i][3] = tempsA+"";
				        data[i][4] = nomMe+"";
				        data[i][5] = date;
				        i++;
				      }
				      DefaultTableModel model = new DefaultTableModel(data, columns);
				      JTable table = new JTable(model);
				      table.setShowGrid(true);
				   	JButton btnModifier = new JButton("Modifier");
				      table.setShowVerticalLines(true);
				      JScrollPane pane = new JScrollPane(table);
				      JFrame f = new JFrame("Remplir JTable a partir d'une BDD");
				      JPanel panel = new JPanel();
				      panel.add(pane);
				      f.getContentPane().add(panel);
				      f.setSize(900, 450);
				      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				      f.setVisible(true);
				    
				    } catch(SQLException e2) {
				      e2.printStackTrace();
				    }
				    
	}
		 
			
		});
		btnAfficher.setForeground(new Color(34, 139, 34));
		btnAfficher.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAfficher.setBackground(Color.WHITE);
		btnAfficher.setBounds(24, 214, 130, 27);
		panel_1.add(btnAfficher);
		
		JButton btnModifier = new JButton("Modifier l'op\u00E9ration  n\u00B0 :");
		btnModifier.addActionListener(new ActionListener() {
			// ***********bouton modifier************
			public void actionPerformed(ActionEvent e) {
	
					 String url="jdbc:sqlserver://DESKTOP-G9JJ6ER\\SQLEXPRESS1;databaseName=maintenance";
					 String username="sa";
					 String password="Bizertine-123";
					 String codeMachine=textCodeMa.getText();
					 int codeMa=Integer.parseInt(codeMachine);
					 String groupeMa=textGroupeMa.getText();
					 String  tempsArret= textTempsArret.getText();
					 int tempsA=Integer.parseInt(tempsArret);
					 String nomMecanicien= textNomMec.getText();
					 String date= textDate.getText();
					 Date dateOp;
                     String IdMod=textModId.getText();
                     int ModId=Integer.parseInt(IdMod);
                     System.out.println(ModId);
				
					try {
						dateOp = new SimpleDateFormat("dd/MM/yyyy").parse(date);
					
						try{  
							//connection
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection connection=DriverManager.getConnection(url,username,password);
							System.out.println("connection etablie avec SQL server");
							String sql="select id_op from operation_datails";
							pst=connection.prepareStatement(sql);
							
						
			String query= "update operation_datails set codeMachine='"+codeMa+"',"
						+ "groupeMachine='"+groupeMa+"',tempsArret='"+tempsA+"',"
							+ "nomMecanicien='"+nomMecanicien+"',date='"+date+"'"
							+"where id_op = "+ ModId;						 
							
							pst=connection.prepareStatement(query);
						    System.out.println("statement sta prepared statement");
						    pst.executeUpdate();
							System.out.println("exceute query!");
						    connection.close();
						    System.out.println("con close ! ");
						    JOptionPane.showMessageDialog(null, "Operation n°"+textModId.getText()+"\t  bien modifier");
							}catch(Exception e2){
								 JOptionPane.showMessageDialog(null,"numéro d'operation n'existe pas ou donnees non valides ");
								e2.printStackTrace();}  
							} 
						
					 catch (ParseException e1) {
						// TODO Auto-generated catch block
						 
						e1.printStackTrace();
						 JOptionPane.showMessageDialog(null,"Veuillez entrez une date valide sous la forme jj/mm/aaaa svp" );

					} 
								
			}
		});
		btnModifier.setForeground(new Color(34, 139, 34));
		btnModifier.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnModifier.setBackground(Color.WHITE);
		btnModifier.setBounds(195, 160, 260, 27);
		panel_1.add(btnModifier);
		
		textModId = new JTextField();
		textModId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textModId.setColumns(10);
		textModId.setBounds(490, 162, 73, 25);
		panel_1.add(textModId);
		
		JButton btnSupprimerLoprationN = new JButton("Supprimer l'op\u00E9ration  n\u00B0 :");
		btnSupprimerLoprationN.addActionListener(new ActionListener() {
			//******************** boutton suppression****************
			public void actionPerformed(ActionEvent e) {
				 String url="jdbc:sqlserver://DESKTOP-G9JJ6ER\\SQLEXPRESS1;databaseName=maintenance";
				 String username="sa";
				 String password="Bizertine-123";
				
				 String IdSupp=textSuppId.getText();
				 System.out.println(IdSupp);
                 int SuppOp=Integer.parseInt(IdSupp);
                 System.out.println("idSupp="+SuppOp);
                 System.out.println(SuppOp);				 	
				
					try{  
						//connection
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						Connection connection=DriverManager.getConnection(url,username,password);
						System.out.println("connection etablie avec SQL server");
			String query= "	delete from operation_datails "+"where id_op ="+ SuppOp;
			//String query= "	delete from operation_datails "+"where [op_id] ='"+SuppId+"'";

						pst=connection.prepareStatement(query);
					    System.out.println("statement sta prepared statement");
					    pst.executeUpdate();
						System.out.println("exceute query!");
					    connection.close();
					    System.out.println("con close ! ");
					    JOptionPane.showMessageDialog(null, "Operation n°"+textSuppId.getText()+"\t  est bien spprimée");
						}catch(Exception e2){
							 JOptionPane.showMessageDialog(null,"numéro d'operation n'existe pas !  ");
							e2.printStackTrace();}  
						} 
					
	  			
			}
		);
		btnSupprimerLoprationN.setForeground(new Color(34, 139, 34));
		btnSupprimerLoprationN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSupprimerLoprationN.setBackground(Color.WHITE);
		btnSupprimerLoprationN.setBounds(195, 214, 260, 27);
		panel_1.add(btnSupprimerLoprationN);
		
		textSuppId = new JTextField();
		textSuppId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textSuppId.setColumns(10);
		textSuppId.setBounds(490, 216, 73, 25);
		panel_1.add(textSuppId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(576, 384, -546, -109);
		panel.add(scrollPane);
		
		txtTable = new JTable();
		txtTable.setForeground(SystemColor.textText);
		txtTable.setFillsViewportHeight(true);
		txtTable.setBackground(SystemColor.textHighlight);
		scrollPane.setViewportView(txtTable);
		txtTable.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Temps d'arret/Code machine");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			//***************affichage temps arret par code machine************
			//radio button temps d'arret par machine ----> affiche table jTable automated
			public void actionPerformed(ActionEvent e) {
		
				try{  
					 String url="jdbc:sqlserver://DESKTOP-G9JJ6ER\\SQLEXPRESS1;databaseName=maintenance";
					String username="sa";
					String password="Bizertine-123";
						
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection connection=DriverManager.getConnection(url,username,password);
					System.out.println("connection etablie avec SQL server");
					String query="select codeMachine,sum(tempsArret) as total from operation_datails group by codeMachine;";
					Statement stm = connection.createStatement();
				    ResultSet res = stm.executeQuery(query);
				      
				      String columns[] = { "Code Machine","Temps d arret"};
				      String data[][] = new String[20][2];
				      int i = 0;
				      while (res.next()) {
				        int codeMachine = res.getInt("codeMachine");
				        String codeMa=String.valueOf(codeMachine);
				         int total = res.getInt("total");
				        String totalT= String.valueOf(total);
				       
				        data[i][0] = codeMa+"";
				        data[i][1] = totalT;
				        i++;
				      }
				      DefaultTableModel model = new DefaultTableModel(data, columns);
				      JTable table = new JTable(model);
				      table.setShowGrid(true);
				      table.setShowVerticalLines(true);
				      JScrollPane pane = new JScrollPane(table);
				      JFrame f = new JFrame("Remplir JTable a partir d'une BDD");
				      JPanel panel = new JPanel();
				      panel.add(pane);
				      f.getContentPane().add(panel);
				      f.setSize(900, 300);
				      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				      f.setVisible(true);
				    
				    } catch(SQLException e2) {
				      e2.printStackTrace();
				    }
				    
				
			
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(297, 350, 237, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTempsDarretTotal = new JRadioButton("Temps total d'arret");
		rdbtnTempsDarretTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{  
					 String url="jdbc:sqlserver://DESKTOP-G9JJ6ER\\SQLEXPRESS1;databaseName=maintenance";
					String username="sa";
					String password="Bizertine-123";
						
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection connection=DriverManager.getConnection(url,username,password);
					System.out.println("connection etablie avec SQL server");
					String query="  select sum(tempsArret) as tempsTotal from operation_datails ;";
					Statement stm = connection.createStatement();
				    ResultSet res = stm.executeQuery(query);
				      		     
				     while (res.next()) {
				       
				         int totaltemps = res.getInt("tempsTotal");
				        String tempsTotal= String.valueOf(totaltemps);
				        JOptionPane.showMessageDialog(null, "Temps total d'arret \t:\t"+tempsTotal+"\t Minutes");
				        
				      }
				     } catch(SQLException e2) {
				      e2.printStackTrace();
				    }
				    
				
			}
		});
		rdbtnTempsDarretTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnTempsDarretTotal.setBounds(297, 399, 157, 23);
		panel.add(rdbtnTempsDarretTotal);
		
		JLabel lblNewLabel_2 = new JLabel("Affichage Specifique :");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2.setBounds(40, 375, 176, 23);
		panel.add(lblNewLabel_2);
		
		JRadioButton rdbtnTempsDarretPar = new JRadioButton("Temps d'arret/Groupe machine");
		rdbtnTempsDarretPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{  
					 String url="jdbc:sqlserver://DESKTOP-G9JJ6ER\\SQLEXPRESS1;databaseName=maintenance";
					String username="sa";
					String password="Bizertine-123";
						
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Connection connection=DriverManager.getConnection(url,username,password);
					System.out.println("connection etablie avec SQL server");
					String query="  select groupeMachine,sum(tempsArret)as tempsArretParMachine from operation_datails group by groupeMachine;";
					Statement stm = connection.createStatement();
				    ResultSet res = stm.executeQuery(query);
				      
				      String columns[] = { "Groupe Machine","Temps d arret"};
				      String data[][] = new String[20][2];
				      int i = 0;
				      while (res.next()) {
				        String groupeMachine = res.getString("groupeMachine");		       
				        int total = res.getInt("tempsArretParMachine");
				        String totalT= String.valueOf(total);
				       
				        data[i][0] = groupeMachine+"";
				        data[i][1] = totalT;
				        i++;
				      }
				      DefaultTableModel model = new DefaultTableModel(data, columns);
				      JTable table = new JTable(model);
				      table.setShowGrid(true);
				      table.setShowVerticalLines(true);
				      JScrollPane pane = new JScrollPane(table);
				      JFrame f = new JFrame("Remplir JTable a partir d'une BDD");
				      JPanel panel = new JPanel();
				      panel.add(pane);
				      f.getContentPane().add(panel);
				      f.setSize(900, 300);
				      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				      f.setVisible(true);
				    
				    } catch(SQLException e2) {
				      e2.printStackTrace();
				    }
				    
			}
		});
		rdbtnTempsDarretPar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdbtnTempsDarretPar.setBounds(297, 376, 251, 23);
		panel.add(rdbtnTempsDarretPar);
	}
}
