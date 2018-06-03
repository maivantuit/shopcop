package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelclasses.KhachHang;
import modelclasses.NhanVien;
import dao.KhachHangDao;
import dao.NhanVienDAO;

/**
 * Servlet implementation class XemNhanVienKhoServlet
 */
public class XemNhanVienKhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemNhanVienKhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NhanVienDAO nhanVienDAO = new NhanVienDAO();
		ArrayList<NhanVien> listNhanVienKho=nhanVienDAO.getListKhachHang();
		request.setAttribute("listNhanVienKho", listNhanVienKho);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/manager_nhanvienkho.jsp");
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
