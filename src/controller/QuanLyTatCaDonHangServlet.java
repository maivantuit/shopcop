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
import dao.HoaDonDAO;
import dao.NguoiGiaoHangDAO;

/**
 * Servlet implementation class QuanLyTatCaDonHangServlet
 */
public class QuanLyTatCaDonHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyTatCaDonHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HoaDonDAO hoadondao = new HoaDonDAO();
		ArrayList<HoaDon> listhoadon = hoadondao.getTatCaListHoaDon();
		request.setAttribute("listhoadon", listhoadon);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/manager_hoadonbanhang2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
