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
 * Servlet implementation class XoaDanhMucServlet
 */
public class XoaDanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaDanhMucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maMDSP = request.getParameter("MaDMSPurl");
		boolean checkXoa=DanhMucDAO.deleteDanhMucSanPham(maMDSP);
		if(checkXoa){
			String mesXoa="Xóa thành công!";
			request.setAttribute("mesXoa", mesXoa);
		}
		 DanhMucDAO danhmucdao = new DanhMucDAO();
         ArrayList<DanhMuc> listdanhmuc = danhmucdao.getListDanhMuc();
         request.setAttribute("listdanhmuc", listdanhmuc);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/manager_danhmuc.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
