package dao;

import connection.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelclasses.ChiTietHoaDon;
import modelclasses.HoaDon;
import modelclasses.KhachHang;
import modelclasses.SanPham;

/**
 *
 * @author CỌP
 */
public class HoaDonDAO {

    public void insertHoaDon(HoaDon hoadon) {
        try {
            Connection connect = DBConnect.getConnection();
            String sql = "insert into DonHang(MaKH,DiaChiGiaoHang,SoDienThoai,NguoiNhan,TongTien) values(?,?,?,?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, hoadon.getMaKH());           
            ps.setString(2, hoadon.getDiaChi());
            ps.setString(3, hoadon.getSoDienThoai());            
            ps.setString(4, hoadon.getNguoiNhan());
            ps.setDouble(5, hoadon.getTongTien());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error query sql: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error common: " + ex.getMessage());
        }
    }

    // get table HoaDonDatHang:(DonHang)
    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> listhd = new ArrayList<HoaDon>();
        try {
            Connection connect = DBConnect.getConnection();
            String sql = " select * from DonHang where NhanVienGiaoHang is null and NhanVienGiaoHang is null ";
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                HoaDon hoadon = new HoaDon();
                hoadon.setMaDH(rs.getInt("MaDH"));
                hoadon.setMaKH(rs.getInt("MaKH"));
                hoadon.setNgayDat(rs.getTimestamp("NgayDat"));
                hoadon.setNguoiNhan(rs.getString("NguoiNhan"));
                hoadon.setDiaChi(rs.getString("DiaChiGiaoHang"));
                hoadon.setTongTien(rs.getInt("TongTien"));
                listhd.add(hoadon);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhd;
    }
 // get table HoaDonDatHang:(DonHang)
    public ArrayList<HoaDon> getTatCaListHoaDon() {
        ArrayList<HoaDon> listhd = new ArrayList<HoaDon>();
        try {
            Connection connect = DBConnect.getConnection();
            String sql = " select * from DonHang";
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                HoaDon hoadon = new HoaDon();
                hoadon.setMaDH(rs.getInt("MaDH"));
                hoadon.setMaKH(rs.getInt("MaKH"));
                hoadon.setNgayDat(rs.getTimestamp("NgayDat"));
                hoadon.setNguoiGiao(rs.getString("NhanVienGiaoHang"));
                hoadon.setTinhTrang(rs.getString("TinhTrang"));
                hoadon.setNgayGiao(rs.getString("NgayGiao"));
                hoadon.setDiaChi(rs.getString("DiaChiGiaoHang"));
                hoadon.setTongTien(rs.getInt("TongTien"));
                listhd.add(hoadon);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhd;
    }
 // get table HoaDonDatHang:(DonHang)
    public ArrayList<HoaDon> getListHoaDonNhanVienKho() {
        ArrayList<HoaDon> listhd = new ArrayList<HoaDon>();
        try {
            Connection connect = DBConnect.getConnection();
            String sql = " select * from DonHang where TinhTrang=N'Đang đóng gói và gửi đi' and NgayGiao is null";
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                HoaDon hoadon = new HoaDon();
                hoadon.setMaDH(rs.getInt("MaDH"));
                hoadon.setMaKH(rs.getInt("MaKH"));
                hoadon.setNgayDat(rs.getTimestamp("NgayDat"));               
                hoadon.setDiaChi(rs.getString("DiaChiGiaoHang"));
                hoadon.setNguoiNhan(rs.getString("NguoiNhan"));
                hoadon.setTongTien(rs.getInt("TongTien"));
                listhd.add(hoadon);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhd;
    }
 // get table HoaDonDatHang:(DonHang)
    public ArrayList<HoaDon> getListHoaDonNhanVienGiaoHang(String maNV) {
        ArrayList<HoaDon> listhd = new ArrayList<HoaDon>();
        try {
            Connection connect = DBConnect.getConnection();
            String sql = " select * from DonHang where TinhTrang=N'Đang đóng gói và gửi đi' " +
            		"and NgayGiao is null and NhanVienGiaoHang is not null and NhanVienGiaoHang='"+maNV+ "'";
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                HoaDon hoadon = new HoaDon();
                hoadon.setMaDH(rs.getInt("MaDH"));
                hoadon.setMaKH(rs.getInt("MaKH"));
                hoadon.setNgayDat(rs.getTimestamp("NgayDat"));               
                hoadon.setDiaChi(rs.getString("DiaChiGiaoHang"));
                hoadon.setSoDienThoai(rs.getString("SoDienThoai"));
                hoadon.setNguoiGiao(rs.getString("NhanVienGiaoHang"));
                hoadon.setNguoiNhan(rs.getString("NguoiNhan"));
                hoadon.setTongTien(rs.getInt("TongTien"));
                listhd.add(hoadon);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listhd;
    }   
       // xem table Hóa đơn theo 1 mã khách hàng:
    public static ArrayList<HoaDon> getListHoaDonHaveCode(String makh) {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        try {
            Connection connect = DBConnect.getConnection();
            String sql = " select * from DonHang where MaKH='" + makh + "'";
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon cthd = new HoaDon();
                cthd.setMaDH(rs.getInt("MaDH"));
                cthd.setMaKH(rs.getInt("MaKH"));               
                cthd.setNgayDat(rs.getTimestamp("NgayDat"));              
                cthd.setDiaChi(rs.getString("DiaChiGiaoHang"));                
                cthd.setTongTien(rs.getInt("TongTien"));
                list.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    // xem table Hóa đơn theo 1 mã hóa đơn:
    public static ArrayList<HoaDon> getListHoaDonHaveCodeTheoMaHoaDon(String mahd) {
        ArrayList<HoaDon> list = new ArrayList<HoaDon>();
        try {
            Connection connect = DBConnect.getConnection();
            String sql = " select * from DonHang where MaDH='" + mahd + "'";
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon cthd = new HoaDon();
                cthd.setMaDH(rs.getInt("MaDH"));
                cthd.setMaKH(rs.getInt("MaKH"));
                
                cthd.setNgayDat(rs.getTimestamp("NgayDat"));         
                cthd.setDiaChi(rs.getString("DiaChiGiaoHang"));
               
                cthd.setTongTien(rs.getInt("TongTien"));
                list.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // get MaNV
    public int getMaDHShow() {
        int madh = 0;
        try {
            Connection con = DBConnect.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT TOP 1 * FROM DonHang ORDER BY MaDH DESC";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                madh = rs.getInt("MaDH");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return madh;
    }
 // cập nhật dữ liệu khách hàng:
  	public boolean duyetDonHang(String tinhTrangDonHang, String nhanVienGiaoHang, String maDH){
  		Connection con = DBConnect.getConnection();
  		String sql = String.format("update DonHang set TinhTrang=N'%s', NhanVienGiaoHang = '%s' where MaDH='%s'",tinhTrangDonHang,nhanVienGiaoHang,maDH);
  		try {
  			Statement stmt = con.createStatement();
  			stmt.executeUpdate(sql);
  			return true;
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return false;
  	}
 // cập nhật dữ liệu đơn hàng của nhân viên kho:
   	public boolean capNhatTrangThaiDonHang(String tinhTrangDonHang,String ngayGiao, String maDH){
   		Connection con = DBConnect.getConnection();
   		String sql = String.format("update DonHang set TinhTrang=N'%s', NgayGiao='%s' where MaDH='%s'",tinhTrangDonHang,ngayGiao,maDH);
   		try {
   			Statement stmt = con.createStatement();
   			stmt.executeUpdate(sql);
   			return true;
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		return false;
   	}

    public static void main(String[] args) throws SQLException {
        //(int maKH, int maND, double tongTien, String phuongthucthanhToan, String diaChi)
        //new HoaDonDAO().insertHoaDon(new HoaDon(1001, 11, 2000000, "Thanh toán khi nhận hàng", "TP Đà Nẵng2"));
//        HoaDonDAO h= new HoaDonDAO();
//        int a=h.getMaDHShow(1000);
//        System.out.println(a);
        HoaDonDAO h = new HoaDonDAO();
        ArrayList<HoaDon> list = h.getListHoaDonNhanVienGiaoHang("NVGH01");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getMaDH());
        }

    }
}
