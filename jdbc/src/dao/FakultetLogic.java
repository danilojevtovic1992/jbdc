package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import metode.CommonMethods;
import model.Student;

public class FakultetLogic {
	
	private void zatvoriPreparedStatment(PreparedStatement ps) {
		
		if(ps != null) {
			try {
				ps.close();
				System.out.println("Zatvorio ps...");
			} catch (SQLException e) {
				System.out.println("Nije zatvorio ps!");
				e.printStackTrace();
			}
		}
	}
private void zatvoriKonkciju(Connection con) {
		
		if(con != null) {
			try {
				con.close();
				System.out.println("Zatvorio konekciju...");
			} catch (SQLException e) {
				System.out.println("Nije zatvorio konekciju!");
				e.printStackTrace();
			}
		}
	}

	public void unesiDrzavu (String imeDrzave) {
			
			Connection con = null;
			PreparedStatement ps = null;
		
		try {
			con = CommonMethods.konektujSe("fakultet");
			
			System.out.println("Connection OK!");
			
			String query = "INSERT INTO drzava VALUES (null, ?)"; //pismo
				ps = con.prepareStatement(query);
				ps.setString(1, imeDrzave);
			
			ps.execute();
			
			System.out.println("Upisan" + imeDrzave+ "u tabelu Drzava");
			
		} catch (SQLException e) {
			System.out.println("Konekcija neuspela!");
			e.printStackTrace();
		}finally {
			zatvoriPreparedStatment(ps);
			zatvoriKonkciju(con);
		}
		
	}
	public void unesiStudenta (Student student) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = CommonMethods.konektujSe("fakultet");
			
			System.out.println("Connection OK!");
			
			String query = "INSERT INTO student VALUES (null, ?,?,?,?,?,?)"; //pismo
				ps = con.prepareStatement(query);
				ps.setString(1,student.getIme());
				ps.setString(2, student.getPrezime());
				ps.setInt(3, student.getBrojIndexa());
				ps.setInt(4, student.getSmer());
				ps.setInt(5, student.getDrzava());
				ps.setInt(6, student.getIspiti());
			
			ps.execute();
			
			System.out.println("Student je upisan!");
			
			
		} catch (SQLException e) {
			System.out.println("Konekcija neuspela!");
			e.printStackTrace();
		}finally {
			zatvoriPreparedStatment(ps);
			zatvoriKonkciju(con);
		}
		
		

	}
	
	
}
