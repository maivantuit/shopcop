package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelclasses.SanPham;
import connection.DBConnect;

/**
 *
 * @author CỌP
 */
public class SanPhamDAO {
    
    // lấy danh sách sản phẩm:
    public static ArrayList<SanPham> getListSanPhamALL() {
        Connection connect = DBConnect.getConnection();
        String sql = "select * from SanPham";
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanpham = new SanPham();
                sanpham.setMaSP(rs.getInt("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaDMSP(rs.getString("MaDMSP"));
                sanpham.setThuongHieu(rs.getString("ThuongHieu"));
                sanpham.setSoLuong(rs.getString("SoLuong"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setGia(rs.getInt("Gia")); 
                sanpham.setThoiGianBaoHanh(rs.getString("ThoiGianBaoHanh"));
                sanpham.setRam(rs.getString("Ram"));
                sanpham.setKichThuoc(rs.getString("KichThuoc"));
                sanpham.setMauSac(rs.getString("MauSac"));
                sanpham.setHeDieuHanh(rs.getString("HeDieuHanh"));
                sanpham.setChipSet(rs.getString("ChipSet"));
                sanpham.setCammera(rs.getString("Camera"));
                sanpham.setBoNhoTrong(rs.getString("BoNhoTrong"));
                sanpham.setPin(rs.getString("Pin"));
                sanpham.setCo(rs.getString("Co"));
                list.add(sanpham);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQLException: " + ex.getMessage());
        }
        return list;
    }
    // tìm kiếm sản phẩm:
    public static ArrayList<SanPham> timKiemSanPham(String tenSP) {
        Connection connect = DBConnect.getConnection();
        String sql = "select * from SanPham where TenSP like '%" + tenSP + "%'";
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanpham = new SanPham();
                sanpham.setMaSP(rs.getInt("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaDMSP(rs.getString("MaDMSP"));
                sanpham.setThuongHieu(rs.getString("ThuongHieu"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setGia(rs.getInt("Gia"));                
                list.add(sanpham);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQLException: " + ex.getMessage());
        }
        return list;
    }
    // lấy danh sách sản phẩm:
    public static ArrayList<SanPham> getListSanPham(int madanhmuc) {
        Connection connect = DBConnect.getConnection();
        String sql = "select * from SanPham where MaDMSP='" + madanhmuc + "'";
        ArrayList<SanPham> list = new ArrayList<SanPham>();
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanpham = new SanPham();
                sanpham.setMaSP(rs.getInt("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaDMSP(rs.getString("MaDMSP"));
                sanpham.setThuongHieu(rs.getString("ThuongHieu"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setGia(rs.getInt("Gia"));                
                list.add(sanpham);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQLException: " + ex.getMessage());
        }
        return list;
    }

    // hiển thị thông tin sản phẩm: (thong tin co ban cua 1 san pham)
    public SanPham getSanPham(long masp) throws SQLException {
        Connection connect = DBConnect.getConnection();
        String sql = "select * from SanPham where MaSP='" + masp + "'";
        PreparedStatement ps = connect.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        SanPham sanpham = new SanPham();
        while (rs.next()) {
            sanpham.setMaSP(rs.getInt("MaSP"));
            sanpham.setTenSP(rs.getString("TenSP"));
            sanpham.setThuongHieu(rs.getString("ThuongHieu"));
            sanpham.setHinhAnh(rs.getString("HinhAnh"));
            sanpham.setGia(rs.getInt("Gia"));            
        }
        return sanpham;
    }

    // hiển thị chi tiết sản phẩm:(1 san pham co nhieu thong tin chi tiet) , co the mot so thong tin lien quan den gio hang nen tu tu. show, show = table
    public SanPham getChiTietSanPham(long masp) throws SQLException {
        Connection connect = DBConnect.getConnection();
        String sql = "select * from ChiTietSanPham where MaSP='" + masp + "'";
        PreparedStatement ps = connect.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        SanPham sanpham = new SanPham();
        while (rs.next()) {
            sanpham.setMaSP(rs.getInt("MaSP"));
            // tiep tuc cac cau hinh.
        }
        return sanpham;
    }
     // lay 1 khach hang table khach hang bang makh
    public SanPham getASanPham(int masp) {    
        try {
            Connection connect = DBConnect.getConnection();
            String sql = " select * from SanPham where MaSP=?";
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setLong(1, masp);
            ResultSet rs = ps.executeQuery();            
            SanPham sp = new SanPham();
            while (rs.next()) {                
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setThuongHieu(rs.getString("ThuongHieu"));
                sp.setGia(rs.getInt("Gia"));
                sp.setHinhAnh(rs.getString("HinhAnh"));                                    
            }
            return sp;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 // lay 1 khach hang table khach hang bang makh
    public SanPham getMotSanPham(int masp) {    
        try {
            Connection connect = DBConnect.getConnection();
            String sql = " select * from SanPham where MaSP=? and Co='C'";
            PreparedStatement ps = connect.prepareCall(sql);
            ps.setLong(1, masp);
            ResultSet rs = ps.executeQuery();            
            SanPham sanpham = new SanPham();
            while (rs.next()) {                
            	sanpham.setMaSP(rs.getInt("MaSP"));
                sanpham.setTenSP(rs.getString("TenSP"));
                sanpham.setMaDMSP(rs.getString("MaDMSP"));
                sanpham.setThuongHieu(rs.getString("ThuongHieu"));
                sanpham.setSoLuong(rs.getString("SoLuong"));
                sanpham.setHinhAnh(rs.getString("HinhAnh"));
                sanpham.setGia(rs.getInt("Gia")); 
                sanpham.setThoiGianBaoHanh(rs.getString("ThoiGianBaoHanh"));
                sanpham.setRam(rs.getString("Ram"));
                sanpham.setKichThuoc(rs.getString("KichThuoc"));
                sanpham.setMauSac(rs.getString("MauSac"));
                sanpham.setHeDieuHanh(rs.getString("HeDieuHanh"));
                sanpham.setChipSet(rs.getString("ChipSet"));
                sanpham.setCammera(rs.getString("Camera"));
                sanpham.setBoNhoTrong(rs.getString("BoNhoTrong"));
                sanpham.setPin(rs.getString("Pin"));
                sanpham.setCo(rs.getString("Co"));                                   
            }
            return sanpham;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 // cập nhật dữ liệu khách hàng:
 	public static boolean updateSoLuongSanPham(String maSP, String soLuong){
 		Connection con = DBConnect.getConnection();
 		String sql = String.format("update SanPham " +
 				"set SoLuong = '%s'" +
 				"where MaSP = '%s'",soLuong,maSP);
 		try {
 			Statement stmt = con.createStatement();
 			stmt.executeUpdate(sql);
 			return true;
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return false;
 	}
 // lấy số lượng hiện tại:
 	public static String getSoLuongHienTai(String maSanPham) {
 		try {
 			Connection connect = DBConnect.getConnection();
 			String sql = " select SoLuong from SanPham where MaSP=?";
 			PreparedStatement ps = connect.prepareCall(sql);
 			ps.setString(1, maSanPham);
 			ResultSet rs = ps.executeQuery();
 			SanPham kh = new SanPham();
 			if (rs.next()) {
 				kh.setSoLuong(rs.getString("SoLuong")); 				
 			}
 			return kh.getSoLuong();
 		} catch (SQLException ex) {
 			Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null,
 					ex);
 		}
 		return null;
 	}

    public static void main(String[] args) throws SQLException {
        SanPhamDAO sanphamdao = new SanPhamDAO();
        ArrayList<SanPham> list = sanphamdao.timKiemSanPham("iphone");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getMaSP() + " - " + list.get(i).getTenSP());
        }
        for (SanPham item : list) {
            System.out.println(item.getMaSP() + " - " + item.getTenSP() + "- " + item.getGia());
        }
        //
        System.out.println("hien thi thong tin san pham: " + sanphamdao.getSanPham(1).getMaSP());
    }
}
