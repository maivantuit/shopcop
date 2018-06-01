package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelclasses.NguoiGiaoHang;
import modelclasses.SanPham;
import connection.DBConnect;

public class NguoiGiaoHangDAO {
	// lấy danh sách người giao hàng:
    public  ArrayList<NguoiGiaoHang> getNhanVienGiaoHang() {
        Connection connect = DBConnect.getConnection();
        String sql = "select * from NhanVien where CapDo = '3'";
        ArrayList<NguoiGiaoHang> list = new ArrayList<NguoiGiaoHang>();
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	NguoiGiaoHang nguoiGiaoHang = new NguoiGiaoHang();
            	nguoiGiaoHang.setMaNV(rs.getString("MaNV"));
            	nguoiGiaoHang.setTenNV(rs.getString("TenNV"));
            	nguoiGiaoHang.setCapDo(rs.getString("CapDo"));
            	nguoiGiaoHang.setMatKhau(rs.getString("MatKhau"));                              
                list.add(nguoiGiaoHang);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQLException: " + ex.getMessage());
        }
        return list;
    }
    public static void main(String[] args) {
    	 
	}
}
