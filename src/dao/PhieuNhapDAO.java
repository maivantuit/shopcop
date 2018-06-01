package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelclasses.PhieuNhap;
import modelclasses.SanPham;

import connection.DBConnect;

public class PhieuNhapDAO {
	// thêm phiếu nhập:
	public boolean themPhieuNhap(String maPhieuNhap) {
		Connection con = DBConnect.getConnection();
		String sql = null;
		try {			
			sql = String.format("insert into PhieuNhap(MaPN) values('%s')",
					maPhieuNhap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	public PhieuNhap getPhieuNhap(String maPhieuNhap){
		Connection con = DBConnect.getConnection();
		String sql = String.format("SELECT * FROM PhieuNhap WHERE MaPN = '%s'", maPhieuNhap);
		ResultSet rs = null;
		PhieuNhap pn = new PhieuNhap();
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				pn.setMaPhieuNhap(rs.getString("MaPN"));
				pn.setNgayNhap(rs.getString("ThoiGianNhap"));
				return pn;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		PhieuNhapDAO p = new PhieuNhapDAO();
		PhieuNhap pN=p.getPhieuNhap("PN10");
		System.out.println(pN.getMaPhieuNhap());
	}
}
