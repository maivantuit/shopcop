package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelclasses.ChiTietHoaDon;
import modelclasses.HoaDon;
import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class CapNhatTrangThaiDonHangServlet
 */
public class CapNhatTrangThaiDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatTrangThaiDonHangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HoaDonDAO hoadondao = new HoaDonDAO();
		ArrayList<HoaDon> listhoadon = hoadondao.getListHoaDonNhanVienKho();
		request.setAttribute("listhoadon", listhoadon);
		RequestDispatcher rd = request
				.getRequestDispatcher("/warehousestaff/HoaDonBanHang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String trangThai = request.getParameter("chonTrangThaiNhe").trim();
		String maDonHangNhe = request.getParameter("maDonHangNhe");
		String ngayGiao = request.getParameter("ngayGiao").trim();
		/* String maSP = request.getParameter("maSanPham"); */
		HoaDonDAO hoaDon = new HoaDonDAO();
		if (ngayGiao.equals("") || ngayGiao == null) {
			String mesStr2 = "Ngày giao không được trống!";
			request.setAttribute("mesStr2", mesStr2);
		} else if (trangThai.equals("") || trangThai == null) {
			String mesStr3 = "Trạng thái không được trống!";
			request.setAttribute("mesStr3", mesStr3);
		} else {
			boolean checkCapNhatDonHang = hoaDon.capNhatTrangThaiDonHang(
					trangThai, ngayGiao, maDonHangNhe);
			if (checkCapNhatDonHang) {
				if (trangThai.equals("Trả lại")) {
					ChiTietHoaDonDAO chiTietDonHang = new ChiTietHoaDonDAO();
					ArrayList<ChiTietHoaDon> listChiTietHoaDon = chiTietDonHang
							.getListChiTietHoaDon(maDonHangNhe);
					for (ChiTietHoaDon item : listChiTietHoaDon) {
						int maSP = item.getMaSP();
						int soLuongBan = item.getSoLuong();
						SanPhamDAO sanPham = new SanPhamDAO();
						int soLuongHienTai = Integer.parseInt(sanPham
								.getSoLuongHienTai(String.valueOf(maSP)));
						int soLuong = soLuongHienTai + soLuongBan;
						SanPhamDAO.updateSoLuongSanPham(String.valueOf(maSP),
								String.valueOf(soLuong));
					}
				}
				String mesStr = "Cập nhật đơn hàng thành công!";
				request.setAttribute("mesStr", mesStr);
			}
		}
		HoaDonDAO hoadondao = new HoaDonDAO();
		ArrayList<HoaDon> listhoadon = hoadondao.getListHoaDonNhanVienKho();
		request.setAttribute("listhoadon", listhoadon);
		RequestDispatcher rd = request
				.getRequestDispatcher("/warehousestaff/HoaDonBanHang.jsp");
		rd.forward(request, response);
	}
}
