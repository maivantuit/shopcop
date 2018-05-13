package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelclasses.DanhMuc;
import modelclasses.SanPham;

import dao.DanhMucDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class TrangChuKhachHangServlet
 */
public class TrangChuKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrangChuKhachHangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Get list DANHMUC:
		DanhMucDAO danhmucdao = new DanhMucDAO();
		ArrayList<DanhMuc> listDanhMuc = danhmucdao.getListDanhMuc();
		request.setAttribute("listDanhMuc", listDanhMuc);
		// Name product to get from input search:
		String tenSP = request.getParameter("tenSP");
		// Get list SANPHAM and check submit search:
		ArrayList<SanPham> listSanPham = null;
		if ("submit".equals(request.getParameter("submit"))) {
			listSanPham = SanPhamDAO.timKiemSanPham(tenSP);
			request.setAttribute("tenSP", tenSP);
		} else {
			listSanPham = SanPhamDAO.getListSanPhamALL();
		}
		request.setAttribute("listSanPham", listSanPham);
		// finally:
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);

	}

}
