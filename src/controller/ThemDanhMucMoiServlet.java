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

import dao.DanhMucDAO;

/**
 * Servlet implementation class ThemDanhMucMoiServlet
 */
public class ThemDanhMucMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDanhMucMoiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/ThemDanhMucMoi.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		String tenDanhMuc = request.getParameter("tenDanhMuc");
		DanhMucDAO danhMucDAO = new DanhMucDAO();
		boolean checkThem=danhMucDAO.themMoiDanhMucSanPham(tenDanhMuc);
		if(checkThem){
			String mes = "Thêm thành công!";
			request.setAttribute("mes", mes);
		}
         ArrayList<DanhMuc> listdanhmuc = danhMucDAO.getListDanhMuc();
         request.setAttribute("listdanhmuc", listdanhmuc);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/manager_danhmuc.jsp");
		rd.forward(request, response);
	}

}
