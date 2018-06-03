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

import modelclasses.DanhMuc;

import dao.DanhMucDAO;

/**
 * Servlet implementation class CapNhatDanhMucServlet
 */
public class CapNhatDanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatDanhMucServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DanhMucDAO danhmucdao = new DanhMucDAO();
		String maDMSP = request.getParameter("MaDMSPurl");
		DanhMuc danhmuc = danhmucdao.getDanhMuc(maDMSP);
		request.setAttribute("danhmuc", danhmuc);
		HttpSession sesstion = request.getSession();
		sesstion.setAttribute("danhmuc", danhmuc);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/update_danhmuc.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DanhMucDAO danhmucdao = new DanhMucDAO();
		request.setCharacterEncoding("UTF-8");
		String tenDanhMuc = request.getParameter("tendanhmuc");
		HttpSession sesstion = request.getSession();
		DanhMuc danhmuc2 = (DanhMuc) sesstion.getAttribute("danhmuc");
		DanhMucDAO.updateSoLuongSanPham(tenDanhMuc, danhmuc2.getMaDMSP());
		DanhMuc danhmuc = danhmucdao.getDanhMuc(danhmuc2.getMaDMSP());
		request.setAttribute("danhmuc", danhmuc);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/update_danhmuc.jsp");
		rd.forward(request, response);

	}

}
