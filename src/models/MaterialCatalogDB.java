package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.text.AbstractDocument.BranchElement;

import org.apache.commons.codec.language.Metaphone;

import com.stanislav.exception.DataException;
import com.stanislav.exception.DataException.ErrorType;

public class MaterialCatalogDB implements MaterialCatalogInterface {

	public MaterialCatalogDB() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addMaterail(Material newMaterial) {

		Connection conn = null;

		PreparedStatement stm = null;
		try {

			try {
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");

				if (newMaterial instanceof Book) {
					Book newBook = (Book) newMaterial;
					String sql = " insert into materials (barcode,title,author,isbn,numberofpages,branch,type) values(?,?,?,?,?,?,'BOOK')";
					stm = conn.prepareStatement(sql);
					stm.setString(1, newBook.getID());
					stm.setString(2, newBook.getTitle());
					stm.setString(3, newBook.getAuthor());
					stm.setString(4, newBook.getIsbn());
					stm.setInt(5, newBook.getNoofPages());
					stm.setString(6, "AnyTown Branch");
				} else if (newMaterial instanceof DVD) {
					DVD newDVD = (DVD) newMaterial;
					String sql = " insert into materials (barcode,title,catalognumber,runningtime,licenced,branch,type) values(?,?,?,?,?,?,'DVD')";
					stm = conn.prepareStatement(sql);
					stm.setString(1, newDVD.getID());
					stm.setString(2, newDVD.getTitle());
					stm.setString(3, newDVD.getCatalogNumber());
					stm.setInt(4, newDVD.getRunningTime());
					stm.setBoolean(5, newDVD.getLicenced());
					stm.setString(6, "AnyTown Branch");
				}
				int results = stm.executeUpdate();
				System.out.println("Recors added: " + results);
				
				
				//opened a data base connection here
				// tried to fetch records here from the database
				
				int recordCount = 0;
				
				
				
			} finally {
				if (stm != null)
					stm.close();
				if (conn != null)
					conn.close();
			}
		}
		catch (NullPointerException ex) {
			//handle me here
		}
//		catch (XYZException ex) {
//			//handled it here
//		}
		catch (ClassNotFoundException e) {
			System.out.println("Something went wrong");
			System.out.println(e);
		} 
		catch (SQLException e) {
			System.out.println("Something went wrong");
			System.out.println(e);
		}
	}

	@Override
	public Map<String, Material> getMaterialMap() {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				stm = conn.createStatement();
				rs = stm.executeQuery("select * from materials");
				Map<String, Material> allMaterials = new HashMap<String, Material>();
				while (rs.next()) {
					String materialType = rs.getString("type");

					if (materialType.equalsIgnoreCase("BOOK")) {
						Book newbook = new Book(rs.getString("barcode"), rs.getString("title"), rs.getString("author"),
								rs.getString("isbn"), rs.getString("branch"), rs.getInt("numberofpages"));

						allMaterials.put(rs.getString("barcode"), newbook);

					} else if (materialType.equalsIgnoreCase("DVD")) {
						DVD newdvd = new DVD(rs.getString("barcode"), rs.getString("title"), rs.getString("branch"),
								rs.getString("director"), rs.getString("catalognumber"), rs.getInt("runningtime"));

						allMaterials.put(rs.getString("barcode"), newdvd);
					}
				}
				return allMaterials;

			} finally {
				if (rs != null)
					rs.close();
				if (stm != null)
					stm.close();
				if (conn != null) {
					conn.close();
					System.out.println("Connection was closed");
				}

				System.out.println("Finally was closed");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Material findMaterial(String title) throws MaterialNotFoundException {

		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				stm = conn.createStatement();
				rs = stm.executeQuery("select * from materials where title like '%" + title + "%'");
				if (rs.next()) {
					String materialType = rs.getString("type");

					if (materialType.equalsIgnoreCase("BOOK")) {
						Book book = new Book(rs.getString("barcode"), rs.getString("title"), rs.getString("author"),
								rs.getString("isbn"), rs.getString("branch"), rs.getInt("numberofpages"));
						return book;
					} else if (materialType.equalsIgnoreCase("DVD")) {
						DVD dvd = new DVD(rs.getString("barcode"), rs.getString("title"), rs.getString("branch"),
								rs.getString("director"), rs.getString("catalogNumber"), rs.getInt("runnigTime"));
						return dvd;

					} else {
						throw new MaterialNotFoundException();
					}
				}

				else {
					throw new MaterialNotFoundException();
				}

			} finally {
				if (rs != null)
					rs.close();
				if (stm != null)
					stm.close();
				if (conn != null) {
					conn.close();
					System.out.println("Connection was closed");
				}

				System.out.println("Finally was closed");
			}
		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int getNumberOfMaterials() {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			try {

				conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				stm = conn.createStatement();
				rs = stm.executeQuery("select count(id) from materials");
				rs.next();
				return rs.getInt(1);

			} finally {
				if (rs != null)
					rs.close();
				if (stm != null)
					stm.close();
				if (conn != null) {
					conn.close();
					System.out.println("Connection was closed");
				}

				System.out.println("Finally was closed");
			}
		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Material> findItemsSoundingLike(String title) {
		Map<String, Material> allItems = getMaterialMap();
		List<Material> result = new ArrayList<Material>();
		
		Metaphone mph = new Metaphone();
		String mphTitle = mph.encode(title);
		for(Material nextMaterial : allItems.values()) {
			if(mph.encode(nextMaterial.getTitle()).equals(mphTitle)) {
				result.add(nextMaterial);
			}
		}
		return result;
	}

	
	

}
