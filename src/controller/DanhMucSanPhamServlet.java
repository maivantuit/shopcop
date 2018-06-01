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
 * Servlet implementation class DanhMucSanPhamServlet
 */
public class DanhMucSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhMucSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 DanhMucDAO danhmucdao = new DanhMucDAO();
         ArrayList<DanhMuc> listdanhmuc = danhmucdao.getListDanhMuc();
         request.setAttribute("listdanhmuc", listdanhmuc);
         RequestDispatcher rd = 
        		 request.getRequestDispatcher("/admin/manager_danhmuc.jsp");
 		 rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
