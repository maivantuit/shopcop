package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelclasses.PhieuNhap;
import modelclasses.SanPham;

import dao.PhieuNhapDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class TaoPhieuNhapServlet
 */
public class TaoPhieuNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaoPhieuNhapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// get maPhieuNhap from NhapHang.jsp:
		String maPhieuNhap = request.getParameter("maphieunhap");
		// insert a phieu nhap:
		PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
		if("submit".equals(request.getParameter("submit"))){
			boolean checkThemPhieuNhap=phieuNhapDAO.themPhieuNhap(maPhieuNhap);
			if(checkThemPhieuNhap){
				request.setAttribute("maPhieuNhap", maPhieuNhap);
				PhieuNhap phieuNhap=phieuNhapDAO.getPhieuNhap(maPhieuNhap);
				request.setAttribute("phieuNhap", phieuNhap);
				
				String themPhieuNhapMess1= "Thêm phiếu nhập  thành công!";
				request.setAttribute("themPhieuNhapMess1", themPhieuNhapMess1);
			}else{
				String themPhieuNhapMess= "Thêm phiếu nhập không thành công!";
				request.setAttribute("themPhieuNhapMess", themPhieuNhapMess);
			}
		}
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		ArrayList<SanPham> listMaSP=sanPhamDAO.getListSanPhamALL();
		request.setAttribute("listMaSP", listMaSP);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/NhapHang.jsp");
		rd.forward(request, response);

	}

}
