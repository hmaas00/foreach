package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;



public class Empacotador {
	
	private ArrayList<Produto> prods = new ArrayList<>();
	
	private ArrayList<Compra> compras = new ArrayList<>();
	
	public Empacotador(){
		//setProds();
		queryProdutos();
	}
	

	public void addCompra(String [] produtos) {
		Compra c = new Compra();
		for(String s : produtos) {
			for(Produto p : prods) {
				if(s.equals(String.valueOf(p.getProdutoId()))) {
					c.addProduto(p);
				}
			}
		}
		c.setData(Calendar.getInstance().getTime().getYear() + 1900,
				Calendar.getInstance().getTime().getMonth(), 
				Calendar.getInstance().getTime().getDate());
		compras.add(c);
		CreateCompra(c);
	}


	public ArrayList<Compra> getCompras() {
		return compras;
	}


	public ArrayList<Produto> getProds() {
		return prods;
	}

	
	public void queryProdutos() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String strConnection = "jdbc:mysql://localhost:3306/foreach_schema";
		
		try {
		    //conn = DriverManager.getConnection(strConnection + "user=root&password=root");
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(strConnection , "root", "root");
		 // Do something with the Connection
			try {
			    stmt = conn.createStatement();
			    //rs = stmt.executeQuery("select * from sakila.produto");

			    // or alternatively, if you don't know ahead of time that
			    // the query will be a SELECT...

			    if (stmt.execute("select * from foreach_schema.produto")) {
			        rs = stmt.getResultSet();
			    }
			    while (rs.next()) {
			    	
			    	prods.add( new Produto(rs.getInt("produto_id"), rs.getString("nome_produto"), rs.getFloat("preco"), rs.getBoolean("promocao")));
			    	
		            /*String nomeProd = rs.getString("nome_produto");
		            float preco = rs.getFloat("preco");
		            boolean promo = rs.getBoolean("promocao");
		            int idProduto = rs.getInt("produto_id");
		            //float price = rs.getFloat("PRICE");
		            //int sales = rs.getInt("SALES");
		            //int total = rs.getInt("TOTAL");*/
		            //System.out.println(nomeProd + "\t" + preco + "\t" + promo + "\t" + idProduto);
		        }

			    // Now do something with the ResultSet ....
			}
			catch (SQLException ex){
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
			finally {
			    // it is a good idea to release
			    // resources in a finally{} block
			    // in reverse-order of their creation
			    // if they are no-longer needed

			    if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        rs = null;
			    }

			    if (stmt != null) {
			        try {
			            stmt.close();
			        } catch (SQLException sqlEx) { } // ignore

			        stmt = null;
			    }
			}

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Criar compra no Banco de dados
	public void CreateCompra( Compra c) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String strConnection = "jdbc:mysql://localhost:3306/foreach_schema";
		
		try {
		    //conn = DriverManager.getConnection(strConnection + "user=root&password=root");
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(strConnection , "root", "root");
		 // Do something with the Connection
			try {
			    stmt = conn.createStatement();
			    stmt.executeUpdate("INSERT INTO `foreach_schema`.`compra` (`compra_data`) VALUES ('"+ c.getData().getTime()+"');", stmt.RETURN_GENERATED_KEYS);
			    rs = stmt.getGeneratedKeys();
			    rs.next();
			    int chaveCompra = rs.getInt(1);
			    //System.out.println("chave --------------" + rs.getInt(1));
			    //rs = stmt.executeQuery("select * from sakila.produto");

			    // or alternatively, if you don't know ahead of time that
			    // the query will be a SELECT...
			    //TODO
			    for ( Produto p : c.getProdutos()) {
			    	//TODO
			    	stmt.executeUpdate("INSERT INTO `foreach_schema`.`compra_produto` (`compra_id`, `produto_id`) VALUES ('"+chaveCompra+"', '"+p.getProdutoId()+"');");
			    }
			    //stmt.execute("INSERT INTO `sakila`.`produto` (`"+ c.get+"`, `preco`, `promocao`) VALUES ('Passagem para Coréia do Norte', '1000', '0');");
			}
			catch (SQLException ex){
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
			finally {
			    // it is a good idea to release
			    // resources in a finally{} block
			    // in reverse-order of their creation
			    // if they are no-longer needed

			    if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        rs = null;
			    }

			    if (stmt != null) {
			        try {
			            stmt.close();
			        } catch (SQLException sqlEx) { } // ignore

			        stmt = null;
			    }
			}

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
