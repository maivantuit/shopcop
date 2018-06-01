package modelclasses;

/**
 *
 * @author CỌP
 */
public class ChiTietHoaDon {
    private int maDH;
    private int maChiTietDH;
    private int maSP;
    
    private int soLuong;

    public ChiTietHoaDon() {
    }
     public ChiTietHoaDon(int maDH, int maSP, int soLuong) {
        this.maDH = maDH;        
        this.maSP = maSP;       
        this.soLuong = soLuong;
    }  

    public int getMaDH() {
        return maDH;
    }

    public int getMaChiTietDH() {
        return maChiTietDH;
    }

    public int getMaSP() {
        return maSP;
    }

   

    public int getSoLuong() {
        return soLuong;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public void setMaChiTietDH(int maChiTietDH) {
        this.maChiTietDH = maChiTietDH;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }



    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
