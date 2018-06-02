package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelclasses.SanPham;

import dao.SanPhamDAO;

/**
 * Servlet implementation class SuaSanPhamServlet
 */
public class SuaSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSP = request.getParameter("MaSPurl");
		// Lay table San Pham:
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		SanPham sanPham=sanPhamDAO.getMotSanPham(Integer.parseInt(maSP));
		request.setAttribute("sanPham", sanPham);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/CapNhatSanPham.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// Cac thuoc tinh duoi jsp:
		String maSanPham = request.getParameter("maSanPham").trim();
		String tenSanPham = request.getParameter("tenSanPham");
		String thuongHieu = request.getParameter("thuongHieu");
		String gia = request.getParameter("gia");
		String thoiGianBaoHanh = request.getParameter("thoiGianBaoHanh");
		String ram = request.getParameter("ram");
		String kichThuoc = request.getParameter("kichThuoc");
		String mauSac = request.getParameter("mauSac");
		String heDieuHanh = request.getParameter("heDieuHanh");
		String chipSets = request.getParameter("chipSet");
		String camera = request.getParameter("camera");
		String boNhoTrong = request.getParameter("boNhoTrong");
		String pin = request.getParameter("pin");				
		// Ham Update San Pham:
		
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		SanPham sanPham=sanPhamDAO.getMotSanPham(Integer.parseInt(maSanPham));
		request.setAttribute("sanPham", sanPham);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/CapNhatSanPham.jsp");
		rd.forward(request, response);
	}

}
