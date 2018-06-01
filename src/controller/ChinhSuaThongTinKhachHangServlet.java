package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelclasses.KhachHang;

import dao.KhachHangDao;

/**
 * Servlet implementation class ChinhSuaThongTinKhachHangServlet
 */
public class ChinhSuaThongTinKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChinhSuaThongTinKhachHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KhachHangDao khachHangDAO = new KhachHangDao();
		int makh = Integer.parseInt(request.getParameter("makh2"));
		KhachHang khachHang=khachHangDAO.getAKhachHang(makh);
		request.setAttribute("khachHang", khachHang);
		RequestDispatcher rd = request.getRequestDispatcher("/CapNhatThongTinKhachHang.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String hovaten = request.getParameter("hovaten");
		String email = request.getParameter("email");
		String ngaysinh = request.getParameter("ngaysinh");
		String diachi = request.getParameter("diachi");
		String sodienthoai = request.getParameter("sodienthoai");
		KhachHangDao khachHangDAO = new KhachHangDao();
		HttpSession session = request.getSession();
		KhachHang khachhang = (KhachHang) session.getAttribute("user");
		boolean checkUpdateCustomer=khachHangDAO.updateCustomer(String.valueOf(khachhang.getMaKH()), hovaten, diachi, sodienthoai, email, ngaysinh);
		String checkStr=null;
		if(checkUpdateCustomer){
			 checkStr= "Chỉnh sửa thông tin thành công!";
			request.setAttribute("checkStr", checkStr);
		}else{
			 checkStr= "Chỉnh sửa thông tin thất bại!";
			request.setAttribute("checkStr", checkStr);
		}
		KhachHang khachHang=khachHangDAO.getAKhachHang(khachhang.getMaKH());
		request.setAttribute("khachHang", khachHang);
		RequestDispatcher rd = request.getRequestDispatcher("/CapNhatThongTinKhachHang.jsp");
		rd.forward(request, response);
	}

}

