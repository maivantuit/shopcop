package controller;

import dao.KhachHangDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelclasses.KhachHang;
import tools.MD5;

/**
 * 
 * @author CỌP
 */
public class KhachHangServlet extends HttpServlet {

	KhachHangDao khachhangdao = new KhachHangDao();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// bien comand de phan biejt giua cac xu ly:
		String command = request.getParameter("command");
		KhachHang kh = new KhachHang();
		HttpSession session = request.getSession();
		String url = "";
		switch (command) {// String tenKH, String matKhau, String diaChi, String
							// email, String sdt
		case "insert":// (TenKH,MatKhau,NgaySinh,DiaChi,Email,SDT)
			String emailCheck = request.getParameter("email");
			boolean checkEmailTonTai = khachhangdao.checkEmail(emailCheck
					.trim());

			String sdt = request.getParameter("sodienthoai");
			kh.setSdt(sdt);
			request.setAttribute("sdt", sdt);

			String ngaysinh = request.getParameter("ngaysinh").trim();
			kh.setNgaySinh(ngaysinh);
			request.setAttribute("ngaysinh", ngaysinh);

			String hovaten = request.getParameter("hovaten");
			kh.setTenKH(hovaten);
			request.setAttribute("hovaten", hovaten);

			String nhaplaimatkhau = request.getParameter("nhaplaimatkhau");
			kh.setMatKhau(nhaplaimatkhau);
			request.setAttribute("nhaplaimatkhau", nhaplaimatkhau);

			String matkhau = request.getParameter("matkhau");
			kh.setMatKhau(matkhau);
			request.setAttribute("matkhau", matkhau);

			String diachi = request.getParameter("diachi");
			kh.setDiaChi(diachi);
			request.setAttribute("diachi", diachi);
			if (emailCheck.equals("") || diachi.equals("")
					|| matkhau.equals("") || nhaplaimatkhau.equals("")
					|| hovaten.equals("") || sdt.equals("")
					|| ngaysinh.equals("")) {
				url = "/register.jsp";
			} else {
				if (checkEmailTonTai) {
					request.setAttribute("emailCheck", emailCheck);
					url = "/register.jsp";
				} else {
					if (!matkhau.equals(nhaplaimatkhau)) {
						request.setAttribute("nhapLaiMatKhau", nhaplaimatkhau);
						url = "/register.jsp";
					} else {
						kh.setEmail(emailCheck);
						khachhangdao.InsertKhachHang(kh);
						session.setAttribute("user", kh);// user tự đặt tại đây,
															// tiếp // tục tại
															// header
						url = "/TrangChuKhachHangServlet";
					}
				}

			}
			break;
		case "login":
			kh = khachhangdao.login(request.getParameter("email"),
					MD5.encrytion(request.getParameter("pass")));
			if (kh != null) {
				session.setAttribute("user", kh);// user tự đặt tại đây, tiếp
													// tục tại header
				url = "/TrangChuKhachHangServlet";
			} else {
				request.setAttribute("error", "Error email or password!");
				url = "/TrangChuKhachHangServlet";
			}
			break;
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
