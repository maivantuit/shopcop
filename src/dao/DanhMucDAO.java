package dao;

import connection.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import modelclasses.DanhMuc;

/**
 * @author CỌP
 */
public class DanhMucDAO {
    // lấy database danh mục sản phẩm:
    public ArrayList<DanhMuc> getListDanhMuc() {
        Connection connect = DBConnect.getConnection();
        String sql = "select * from DanhMucSanPham where Co='C'";
        ArrayList<DanhMuc> list = new ArrayList<DanhMuc>();
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc danhmuc = new DanhMuc();
                danhmuc.setMaDMSP(rs.getString("MaDMSP"));
                danhmuc.setTenDMSP(rs.getString("TenDMSP"));                
                list.add(danhmuc);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQLException: " + ex.getMessage());
        }
        return list;
       
    }
    public DanhMuc getDanhMuc(String maDMSP) {
        Connection connect = DBConnect.getConnection();
        String sql = "select * from DanhMucSanPham where MaDMSP='"+maDMSP+"'";
        
        DanhMuc danhmuc = new DanhMuc();
        try {
            PreparedStatement ps = connect.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {               
                danhmuc.setMaDMSP(rs.getString("MaDMSP"));
                danhmuc.setTenDMSP(rs.getString("TenDMSP"));                               
            }
        } catch (SQLException ex) {
            System.out.println("Error SQLException: " + ex.getMessage());
        }
        return danhmuc;
       
    }
    public boolean themMoiDanhMucSanPham(String tenDMSP) {
 		Connection con = DBConnect.getConnection();
 		String sql = null;
 		try {			
 			sql = String.format("insert into DanhMucSanPham(TenDMSP,Co) " +
 					"values (N'%s','C')",tenDMSP);
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


    // thêm mới một danh mục dữ liệu:
    public boolean InsertDanhMuc(DanhMuc danhmuc)  {
        try {
            Connection connect = DBConnect.getConnection();
            String sql = "insert into DanhMucSanPham(TenDMSP,MaNSX) values (?,?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, danhmuc.getTenDMSP());
            ps.setString(2, danhmuc.getMaNSX());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // cập nhật dữ liệu danh mục:
    public boolean UpdateDanhMuc(DanhMuc danhmuc){
        try {
            Connection connect = DBConnect.getConnection();
            String sql ="update DanhMucSanPham set TenDMSP=?, MaNSX=? where MaDMSP=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, danhmuc.getTenDMSP());            
            ps.setString(2, danhmuc.getMaNSX());                  
            ps.setString(3, danhmuc.getMaDMSP());
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 // cập nhật dữ liệu khách hàng:
  	public static boolean updateSoLuongSanPham(String tenDanhMuc, String maDMSP){
  		Connection con = DBConnect.getConnection();
  		String sql = String.format("update DanhMucSanPham " +
  				"set TenDMSP = '%s'" +
  				"where MaDMSP = '%s'",tenDanhMuc,maDMSP);
  		try {
  			Statement stmt = con.createStatement();
  			stmt.executeUpdate(sql);
  			return true;
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return false;
  	}
    // xóa dữ liệu danh mục:
    public boolean  DeleteDanhMuc(String madanhmuc){
        try {
            Connection connect = DBConnect.getConnection();
            String sql ="delete DanhMucSanPham where MaDMSP=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, madanhmuc);
            return ps.executeUpdate()==1;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean deleteDanhMucSanPham(String maMDSP){
 		Connection con = DBConnect.getConnection();
 		String sql = String.format("update DanhMucSanPham " +
 				"set Co = 'K'" +
 				"where MaDMSP = '%s'",maMDSP);
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

        //1.
        DanhMucDAO dmd = new DanhMucDAO();
        for (DanhMuc ds: dmd.getListDanhMuc()) {
            System.out.println(ds.getMaDMSP()+ " - "+ ds.getTenDMSP());
        }
        //DanhMucDAO dmd = new DanhMucDAO();
//        ArrayList<DanhMuc> list = dmd.getListDanhMuc();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getMaDMSP()+" - "+list.get(i).getTenDMSP());
//        }
        //2.Chèn 1 danh mục: hoặc có thể bỏ 1 vòng lặp for: chèn nhiều danh mục
        //InsertDanhMuc(DanhMuc danhmuc) // 
//        DanhMucDAO dmd = new DanhMucDAO();
//        for (int i = 0; i < 1; i++) {
//            dmd.InsertDanhMuc(new DanhMuc("DanhMucA", "NSX10"));
//        }
        /// 3. Update danh mục:
//        DanhMucDAO dmd = new DanhMucDAO();
//        dmd.UpdateDanhMuc(new DanhMuc("10013", "DanhMucAUpdate2", "NSX9"));
        ///4. Delete danhmuc:
//        DanhMucDAO dmd = new DanhMucDAO();
//        dmd.DeleteDanhMuc("10012");
    }
}
