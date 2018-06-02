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
 * Servlet implementation class DangNhapNhanVienGiaoHangServlet
 */

public class DangNhapNhanVienGiaoHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapNhanVienGiaoHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request
				.getRequestDispatcher("/deliveryman/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String maAdmin = request.getParameter("taiKhoan");
		 String matKhau = request.getParameter("matKhau");
		 NhanVienDAO nhanVien = new NhanVienDAO();
		 try {
			NhanVien nhanVienKhoGiaoHang=nhanVien.loginNhanVienGiaoHang(maAdmin, matKhau);
			if(nhanVienKhoGiaoHang!=null){
				// sesstion:
				HttpSession sesstion = request.getSession();
				sesstion.setAttribute("nhanVienKhoGiaoHang", nhanVienKhoGiaoHang);
			}else{
				String mes="Đăng nhập thất bại!";
				request.setAttribute("mes", mes);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		 RequestDispatcher rd = request
					.getRequestDispatcher("/deliveryman/index.jsp");
			rd.forward(request, response);
	}

}
