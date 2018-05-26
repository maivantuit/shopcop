package modelclasses;

import connection.DBConnect;
import dao.HoaDonDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CỌP
 */
public class HoaDon {

    private int maDH;
    private int maKH;
    private int maNV;
    private String phuongthucthanhToan;
    private String trangthaigiaoHang;
    private String diaChi;
    private String soDienThoai;
    private String nguoiNhan;
    private Timestamp ngayDat; // getdate()
    private int tongTien;

    public HoaDon() {        
    }
    
    public HoaDon(int maDH, int maKH, int maNV, String phuongthucthanhToan,
			String trangthaigiaoHang, String diaChi, String soDienThoai,
			String nguoiNhan,  int tongTien) {
		super();
		this.maDH = maDH;
		this.maKH = maKH;
		this.maNV = maNV;
		this.phuongthucthanhToan = phuongthucthanhToan;
		this.trangthaigiaoHang = trangthaigiaoHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.nguoiNhan = nguoiNhan;		
		this.tongTien = tongTien;
	}

	public HoaDon(int maDH, int maKH, int maNV, String phuongthucthanhToan, String trangthaigiaoHang, String diaChi, Timestamp ngayDat, int tongTien) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.maNV = maNV;
        this.phuongthucthanhToan = phuongthucthanhToan;
        this.trangthaigiaoHang = trangthaigiaoHang;
        this.diaChi = diaChi;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
    }
    
    // contrutor not maDH, identity, not ngaydat
    public HoaDon(int maKH,int tongTien, String phuongthucthanhToan, String diaChi) {
        this.maKH = maKH;        
        this.tongTien = tongTien;
        this.phuongthucthanhToan = phuongthucthanhToan;
        this.diaChi = diaChi;        
    }
    // contrutor not maDH, identity, not ngaydat
    public HoaDon(int maKH, int maNV, int tongTien, String phuongthucthanhToan, String diaChi) {
        this.maKH = maKH;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.phuongthucthanhToan = phuongthucthanhToan;
        this.diaChi = diaChi;        
    }
// contrutor have maDH, identity
    public HoaDon(int maDH, int maKH, int maNV, int tongTien, String phuongthucthanhToan, String diaChi, Timestamp ngayDat) {
        this.maDH = maDH;
        this.maKH = maKH;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.phuongthucthanhToan = phuongthucthanhToan;
        this.diaChi = diaChi;
        this.ngayDat = ngayDat;
    }
     // get MaNV
    public int getMaDHShow(Timestamp ngaydat) {        
        try {
            Connection con = DBConnect.getConnection();
            Statement stmt = con.createStatement();
            String sql = "Select MaDH from DonHang where NgayDat='" + ngaydat+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                maDH = rs.getInt("MaDH");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return maDH;
    }
    
    public String getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getMaDH() {
        return maDH;
    }

    public String getTrangthaigiaoHang() {
        return trangthaigiaoHang;
    }

    public void setTrangthaigiaoHang(String trangthaigiaoHang) {
        this.trangthaigiaoHang = trangthaigiaoHang;
    }
    
    public int getMaKH() {
        return maKH;
    }

    public int getmaNV() {
        return maNV;
    }

    public int getTongTien() {
        return tongTien;
    }

    public String getPhuongthucthanhToan() {
        return phuongthucthanhToan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public Timestamp getNgayDat() {
        return ngayDat;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setmaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setPhuongthucthanhToan(String phuongthucthanhToan) {
        this.phuongthucthanhToan = phuongthucthanhToan;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgayDat(Timestamp ngayDat) {
        this.ngayDat = ngayDat;
    }

}
