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
 * Servlet implementation class ThemSanPhamServlet
 */
public class ThemSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DanhMucDAO danhMucSanPhamDAO = new DanhMucDAO();
		ArrayList<DanhMuc> listDanhMuc=danhMucSanPhamDAO.getListDanhMuc();
		request.setAttribute("listDanhMuc", listDanhMuc);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/ThemSanPham.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maDanhMuc = request.getParameter("maDanhMuc");
		String tenSanPham = request.getParameter("tenSanPham");
		String thuongHieu = request.getParameter("thuongHieu");
		String gia = request.getParameter("gia");
		String thoiGianBaoHanh = request.getParameter("thoiGianBaoHanh");
		String ram = request.getParameter("ram");
		String kichThuoc = request.getParameter("kichThuoc");
		String mauSac = request.getParameter("mauSac");
		String heDieuHanh = request.getParameter("heDieuHanh");
		String chipSet = request.getParameter("chipSet");
		String camera = request.getParameter("camera");
		String boNhoTrong = request.getParameter("boNhoTrong");
		String pin = request.getParameter("pin");	
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		boolean checkThem =sanPhamDAO.themMoiSanPham(tenSanPham,maDanhMuc, thuongHieu, gia, thoiGianBaoHanh, ram, kichThuoc, mauSac, heDieuHanh, chipSet, camera, boNhoTrong, pin);
		if(checkThem){
			String mesTC= "Thêm thành công!";
			request.setAttribute("mesTC", mesTC);
		}else{
			String mesTB= "Thêm thất bại!";
			request.setAttribute("mesTB", mesTB);
		}
		SanPhamDAO sanphamdao = new SanPhamDAO();
		ArrayList<SanPham> listsanpham = sanphamdao.getListSanPhamALL();
		request.setAttribute("listsanpham", listsanpham);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/manager_sanpham.jsp");
		rd.forward(request, response);
	}

}
