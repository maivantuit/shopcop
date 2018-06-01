package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelclasses.HoaDon;
import modelclasses.NguoiGiaoHang;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.KhachHangDao;
import dao.NguoiGiaoHangDAO;

/**
 * Servlet implementation class DuyetDonHangServlet
 */
public class DuyetDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DuyetDonHangServlet() {
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
		ArrayList<HoaDon> listhoadon = hoadondao.getListHoaDon();
		request.setAttribute("listhoadon", listhoadon);
		NguoiGiaoHangDAO nguoiGiaoHangDAO = new NguoiGiaoHangDAO();
		ArrayList<NguoiGiaoHang> listNguoiGiaoHang = nguoiGiaoHangDAO
				.getNhanVienGiaoHang();
		request.setAttribute("listNguoiGiaoHang", listNguoiGiaoHang);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/manager_hoadonbanhang.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		String nguoiGiaoHang = request.getParameter("chonNguoiGiaoHangA");
		String maDH = request.getParameter("maDonHangNhe");
		HoaDonDAO hoaDonDAO = new HoaDonDAO();
		boolean checkDuyet = hoaDonDAO.duyetDonHang("Đang đóng gói và gửi đi",
				nguoiGiaoHang, maDH);
		if (checkDuyet) {
			String mesStr = "Duyệt đơn hàng thành công";
			request.setAttribute("mesStr", mesStr);
		}
		HoaDonDAO hoadondao = new HoaDonDAO();
		ArrayList<HoaDon> listhoadon = hoadondao.getListHoaDon();
		request.setAttribute("listhoadon", listhoadon);
		NguoiGiaoHangDAO nguoiGiaoHangDAO = new NguoiGiaoHangDAO();
		ArrayList<NguoiGiaoHang> listNguoiGiaoHang = nguoiGiaoHangDAO
				.getNhanVienGiaoHang();
		request.setAttribute("listNguoiGiaoHang", listNguoiGiaoHang);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/manager_hoadonbanhang.jsp");
		rd.forward(request, response);
	}

}
