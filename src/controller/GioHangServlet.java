package controller;

import dao.SanPhamDAO;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelclasses.GioHang;
import modelclasses.Item;
import modelclasses.SanPham;

/**
 * 
 * @author CỌP
 */
public class GioHangServlet extends HttpServlet {

	private final SanPhamDAO sanphamdao = new SanPhamDAO();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		String maSP = request.getParameter("maSP"); // tai product
													// href="GioHangServlet?command=plus&maSP="<%=
													// p.getMaSP()%>
		GioHang giohang = (GioHang) session.getAttribute("giohang");
		try {
			Long spma = Long.parseLong(maSP);
			SanPham sanpham = sanphamdao.getSanPham(spma); // ep kieu cho de
															// nhin
			switch (command) {
			case "plus": // them san pham vao gio hang
				if (giohang.getGiohangItems().containsKey(spma)) { // xem ham
																	// tra ve la
																	// . cuoi
					int checkSoLuong = giohang.getGiohangItems().get(spma)
							.getSoLuong();
					SanPhamDAO sanPham = new SanPhamDAO();
					int soLuongHienTai = Integer.parseInt(sanPham
							.getSoLuongHienTai(String.valueOf(spma)));
					if (checkSoLuong >= soLuongHienTai) {
						String soLuongTang = "Sản phẩm hiện tại không đủ";
						request.setAttribute("soLuongTang", soLuongTang);
					} else {
						if (checkSoLuong >= soLuongHienTai) {
							giohang.ThemSanPham(spma, new Item(sanpham,
									giohang.getGiohangItems().get(spma)
											.getSoLuong() - 1)); // contructor
						} else {
							giohang.ThemSanPham(spma, new Item(sanpham, giohang
									.getGiohangItems().get(spma).getSoLuong())); // contructor
						}
					}
				} else {
					giohang.ThemSanPham(spma, new Item(sanpham, 1));
				}
				RequestDispatcher rd = request
						.getRequestDispatcher("checkout.jsp");
				rd.forward(request, response);
				break;
			case "bot": // bớt san pham vao gio hang
				if (giohang.getGiohangItems().containsKey(spma)) { // xem ham
																	// tra ve la
																	// . cuoi
					int checkSoLuong = giohang.getGiohangItems().get(spma)
							.getSoLuong();
					if (checkSoLuong <= 1) {
						String soLuongGiam = "Số lượng sản phẩm không được < 1.";
						request.setAttribute("soLuongGiam", soLuongGiam);
					} else {
						if (checkSoLuong == 1) {
							giohang.BotSanPham(spma, new Item(sanpham,
									giohang.getGiohangItems().get(spma)
											.getSoLuong() + 1)); // contructor
						} else {
							giohang.BotSanPham(spma, new Item(sanpham, giohang
									.getGiohangItems().get(spma).getSoLuong())); // contructor
						}
					}
				} else {
					giohang.ThemSanPham(spma, new Item(sanpham, 1));
				}
				/* response.sendRedirect("/doancntt/checkout.jsp"); */
				RequestDispatcher rd2 = request
						.getRequestDispatcher("checkout.jsp");
				rd2.forward(request, response);
				break;
			case "remove": // xoa san pham in gio hang
				giohang.XoaSanPhamTrongGioHang(spma);
				response.sendRedirect("/doancntt/checkout.jsp");
				break;
			}
		} catch (Exception e) {
			response.sendRedirect("TrangChuKhachHangServlet");
		}
		session.setAttribute("giohang", giohang); // "" tu cho.

	}

}
