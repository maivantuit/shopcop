package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelclasses.NhanVien;
import dao.NhanVienDAO;

/**
 * Servlet implementation class DangNhapNhanVienKhoServlet
 */

public class DangNhapNhanVienKhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapNhanVienKhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request
				.getRequestDispatcher("/warehousestaff/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 String maAdmin = request.getParameter("taiKhoan");
		 String matKhau = request.getParameter("matKhau");
		 NhanVienDAO nhanVien = new NhanVienDAO();
		 try {
			NhanVien nhanVienKhoInstace=nhanVien.loginNhanVienKho(maAdmin, matKhau);
			if(nhanVienKhoInstace!=null){
				// sesstion:
				HttpSession sesstion = request.getSession();
				sesstion.setAttribute("nhanVienKhoInstace", nhanVienKhoInstace);
			}else{
				String mes="Đăng nhập thất bại!";
				request.setAttribute("mes", mes);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		 RequestDispatcher rd = request
					.getRequestDispatcher("/warehousestaff/index.jsp");
			rd.forward(request, response);
	}

}
