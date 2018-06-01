package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelclasses.ChiTietPhieuNhap;
import modelclasses.PhieuNhap;
import modelclasses.SanPham;

import dao.ChiTietPhieuNhapDAO;
import dao.PhieuNhapDAO;
import dao.SanPhamDAO;

/**
 * Servlet implementation class TaoChiTietPhieuNhapSevlet
 */
public class TaoChiTietPhieuNhapSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaoChiTietPhieuNhapSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
		String maphieunhap = request.getParameter("maphieunhap2");
		String masanpham = request.getParameter("masanpham");
		String soluong = request.getParameter("soluong");
		String gianhap = request.getParameter("gianhap");
		ChiTietPhieuNhapDAO chiTietPhieuNhap = new ChiTietPhieuNhapDAO();		
		if ("submit".equals(request.getParameter("submit"))) {
			boolean checkThemChiTietPN = chiTietPhieuNhap.themChiTietPhieuNhap(
					maphieunhap, masanpham, soluong, gianhap);
			if (checkThemChiTietPN) {
				ArrayList<ChiTietPhieuNhap> listChiTietPhieuNhap=chiTietPhieuNhap.getChiTietPhieuNhap(maphieunhap);
				request.setAttribute("listChiTietPhieuNhap", listChiTietPhieuNhap);
				// update SoLuong in table SanPham.
				int soLuongNhap=Integer.parseInt(soluong);
				int soLuongHienTai = Integer.parseInt(SanPhamDAO.getSoLuongHienTai(masanpham));
				int soLuongTotal = soLuongHienTai+soLuongNhap;
				boolean checkCapNhapSoLuong=SanPhamDAO.updateSoLuongSanPham(masanpham, String.valueOf(soLuongTotal));				
				// lay SoLuong o san pham len.
				// Cong lai.
				// update lai SoLuong o san pham bang so luong da tinh. theo masanpham tren.
			}
		}	
		request.setAttribute("maPhieuNhap", maphieunhap);
		PhieuNhap phieuNhap=phieuNhapDAO.getPhieuNhap(maphieunhap);
		request.setAttribute("phieuNhap", phieuNhap);
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		ArrayList<SanPham> listMaSP = sanPhamDAO.getListSanPhamALL();
		request.setAttribute("listMaSP", listMaSP);
		RequestDispatcher rd = request
				.getRequestDispatcher("/admin/NhapHang.jsp");
		rd.forward(request, response);
	}

}
