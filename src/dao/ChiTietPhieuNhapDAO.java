package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelclasses.ChiTietPhieuNhap;
import modelclasses.PhieuNhap;
import connection.DBConnect;

public class ChiTietPhieuNhapDAO {
	// thêm chi tiết phiếu nhập:
	public boolean themChiTietPhieuNhap(String maPhieuNhap, String maSanPham,
			String soLuong, String donGia) {
		Connection con = DBConnect.getConnection();
		String sql = null;
		try {
			sql = String
					.format("insert into ChiTietPhieuNhap(MaPN,MaSP,SoLuongNhap,GiaNhap) values('%s','%s','%s','%s')",
							maPhieuNhap, maSanPham, soLuong, donGia);
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

	public ArrayList<ChiTietPhieuNhap> getChiTietPhieuNhap(String maPhieuNhap) {
		Connection connect = DBConnect.getConnection();
		String sql = String.format("SELECT * FROM ChiTietPhieuNhap WHERE MaPN = '%s'",
				maPhieuNhap);
		ResultSet rs = null;
		ArrayList<ChiTietPhieuNhap> listChiTietPhieuNhap = new ArrayList<ChiTietPhieuNhap>();		
		try {
			 PreparedStatement ps = connect.prepareCall(sql);
	             rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				ChiTietPhieuNhap pn = new ChiTietPhieuNhap();
				pn.setMaPhieuNhap(rs.getString("MaPN"));
				pn.setMaSanPham(rs.getString("MaSP"));
				pn.setSoLuong(rs.getString("SoLuongNhap"));
				pn.setDonGia(rs.getString("GiaNhap"));
				listChiTietPhieuNhap.add(pn);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listChiTietPhieuNhap;
	}

	public static void main(String[] args) {
		ChiTietPhieuNhapDAO d = new ChiTietPhieuNhapDAO();
		ArrayList<ChiTietPhieuNhap> list=d.getChiTietPhieuNhap("1");
		for(ChiTietPhieuNhap item:list){
			System.out.println(item.getMaSanPham());
		}
	}

}
