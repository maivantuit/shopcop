package controller;

import com.sun.javafx.util.TempState;
import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelclasses.ChiTietHoaDon;
import modelclasses.GioHang;
import modelclasses.HoaDon;
import modelclasses.Item;
import modelclasses.KhachHang;

/**
 * 
 * @author CỌP
 */
public class HoaDonDatHangServlet extends HttpServlet {

	// tao 2:
	private final HoaDonDAO hoadondao = new HoaDonDAO();
	private final ChiTietHoaDonDAO chitiethoadondao = new ChiTietHoaDonDAO();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int checkKhachHang = Integer.parseInt(request.getParameter("checkKhachHang"));
		HttpSession session = request.getSession();
		GioHang giohang=(GioHang) session.getAttribute("giohang");;
		KhachHang khachhang = (KhachHang) session.getAttribute("user");
		if (checkKhachHang == 0) {
			String diachi = request.getParameter("diachi");			
			String sdt  = request.getParameter("sodienthoai");
			String hoten = request.getParameter("hoten");
			giohang = (GioHang) session.getAttribute("giohang");
			HoaDon hoadon = new HoaDon();
			hoadon.setMaKH(khachhang.getMaKH());			
			hoadon.setDiaChi(diachi);
			hoadon.setSoDienThoai(sdt);
			hoadon.setNguoiNhan(hoten);
			hoadon.setTongTien(giohang.TinhTongTienTrongGioHang());
			hoadondao.insertHoaDon(hoadon);
		} else {
			String diachi = request.getParameter("diachiNguoiNhanKhac");			
			String sdt  = request.getParameter("sodienthoaiNguoiNhanKhac");
			String tenNguoiNhan = request.getParameter("hoTenNguoiNhanKhac");			
			giohang = (GioHang) session.getAttribute("giohang");
			HoaDon hoadon = new HoaDon();
			hoadon.setMaKH(khachhang.getMaKH());			
			hoadon.setDiaChi(diachi);
			hoadon.setSoDienThoai(sdt);
			hoadon.setNguoiNhan(tenNguoiNhan);
			hoadon.setTongTien(giohang.TinhTongTienTrongGioHang());
			hoadondao.insertHoaDon(hoadon);
		}
		try {
			// getMaDH tai hoa don len, phai get id cuoi(tu dong tang)(demo cho
			// co la de 1 id cuoi khong trung cai tren)
			// o day to lay ngay dat: no khong bao gio trung.
			HoaDon hoadon2 = new HoaDon();
			// luc nay get du lieu bang HoaDon da vua them.(gom co ... dac biet
			// co NgayDat)
			// Timestamp ngaydat = hoadon2.getNgayDat();
			int madh = hoadondao.getMaDHShow();
			int dem = 0;
			for (Map.Entry<Long, Item> list : giohang.getGiohangItems()
					.entrySet()) {
				chitiethoadondao.InsertChiTietHoaDon(new ChiTietHoaDon(madh,
						list.getValue().getSanPham().getMaSP(),list.getValue()
								.getSoLuong()));
				//update lai so luong:
				try{
					int soLuongMua = list.getValue()
							.getSoLuong();
					int soLuongHienTai = Integer.parseInt(SanPhamDAO.getSoLuongHienTai(String.valueOf(list.getValue().getSanPham().getMaSP())));
					int soLuongTotal = soLuongHienTai-soLuongMua;
					SanPhamDAO.updateSoLuongSanPham(String.valueOf(list.getValue().getSanPham().getMaSP()),String.valueOf(soLuongTotal));
				}catch(Exception e){
					
				}
				
				dem++;
			}
			giohang = new GioHang();
			session.setAttribute("giohang", giohang);
			if (dem != 0) {
				response.sendRedirect("/doancntt/checkoutsuccess.jsp");
			} else {
				response.sendRedirect("TrangChuKhachHangServlet");
			}
		} catch (Exception e) {
		}

	}

}
