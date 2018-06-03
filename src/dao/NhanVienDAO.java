package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelclasses.KhachHang;
import modelclasses.NhanVien;

import connection.DBConnect;

public class NhanVienDAO {
	// dang nhap admin:
	public NhanVien login(String id, String password) throws SQLException {
		Connection con = DBConnect.getConnection();
		String sql = "select * from NhanVien where CapDo='1' and MaNV='" + id
				+ "' and MatKhau='" + password + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				NhanVien kh = new NhanVien();
				kh.setMaNV(rs.getString("MaNV"));
				kh.setMatKhau(rs.getString("MatKhau"));// phải get lên mới set
														// Attribute được.
				kh.setTenNV(rs.getString("TenNV"));
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setEmail(rs.getString("Email"));
				kh.setSdt(rs.getString("SDT"));
				kh.setCmnd(rs.getString("CMND"));
				kh.setCapDo(rs.getString("CapDo"));
				return kh;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return null;
	}

	// dang nhap admin:
	public NhanVien loginNhanVienKho(String id, String password)
			throws SQLException {
		Connection con = DBConnect.getConnection();
		String sql = "select * from NhanVien where CapDo='2' and MaNV='" + id
				+ "' and MatKhau='" + password + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				NhanVien kh = new NhanVien();
				kh.setMaNV(rs.getString("MaNV"));
				kh.setMatKhau(rs.getString("MatKhau"));// phải get lên mới set
														// Attribute được.
				kh.setTenNV(rs.getString("TenNV"));
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setEmail(rs.getString("Email"));
				kh.setSdt(rs.getString("SDT"));
				kh.setCmnd(rs.getString("CMND"));
				kh.setCapDo(rs.getString("CapDo"));
				return kh;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return null;
	}
	public ArrayList<NhanVien> getListNhanVienGiaoHang() {
		ArrayList<NhanVien> listkh = new ArrayList<NhanVien>();
		try {
			Connection connect = DBConnect.getConnection();
			String sql = " select * from NhanVien where CapDo='3'";
			PreparedStatement ps = connect.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien kh = new NhanVien();
				kh.setMaNV(rs.getString("MaNV"));
				kh.setTenNV(rs.getString("TenNV"));				
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setSdt(rs.getString("SDT"));
				kh.setEmail(rs.getString("Email"));				
				listkh.add(kh);
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return listkh;
	}

	public ArrayList<NhanVien> getListKhachHang() {
		ArrayList<NhanVien> listkh = new ArrayList<NhanVien>();
		try {
			Connection connect = DBConnect.getConnection();
			String sql = " select * from NhanVien where CapDo='2'";
			PreparedStatement ps = connect.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhanVien kh = new NhanVien();
				kh.setMaNV(rs.getString("MaNV"));
				kh.setTenNV(rs.getString("TenNV"));				
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setSdt(rs.getString("SDT"));
				kh.setEmail(rs.getString("Email"));				
				listkh.add(kh);
			}
		} catch (SQLException ex) {
			Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return listkh;
	}

	// dang nhap admin:
	public NhanVien loginNhanVienGiaoHang(String id, String password)
			throws SQLException {
		Connection con = DBConnect.getConnection();
		String sql = "select * from NhanVien where CapDo='3' and MaNV='" + id
				+ "' and MatKhau='" + password + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				NhanVien kh = new NhanVien();
				kh.setMaNV(rs.getString("MaNV"));
				kh.setMatKhau(rs.getString("MatKhau"));// phải get lên mới set
														// Attribute được.
				kh.setTenNV(rs.getString("TenNV"));
				kh.setDiaChi(rs.getString("DiaChi"));
				kh.setEmail(rs.getString("Email"));
				kh.setSdt(rs.getString("SDT"));
				kh.setCmnd(rs.getString("CMND"));
				kh.setCapDo(rs.getString("CapDo"));
				return kh;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {
		NhanVienDAO nv = new NhanVienDAO();
		NhanVien nv2 = nv.login("Admin", "123");
		System.out.println(nv2.getMaNV());
	}
}
