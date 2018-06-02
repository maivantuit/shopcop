package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelclasses.HoaDon;
import modelclasses.NhanVien;

import dao.HoaDonDAO;

/**
 * Servlet implementation class NhanVienGiaoHangXemHoaDonServlet
 */
public class NhanVienGiaoHangXemHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhanVienGiaoHangXemHoaDonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HoaDonDAO hoaDonDAO = new HoaDonDAO();
		HttpSession sesstion = request.getSession();
		NhanVien nhanVien=(NhanVien)sesstion.getAttribute("nhanVienKhoGiaoHang");		
		ArrayList<HoaDon> listhoadon=hoaDonDAO.getListHoaDonNhanVienGiaoHang(nhanVien.getMaNV());
		request.setAttribute("listhoadon", listhoadon);
		RequestDispatcher rd = request
				.getRequestDispatcher("/deliveryman/manager_hoadonbanhang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
