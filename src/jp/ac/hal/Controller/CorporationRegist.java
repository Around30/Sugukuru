package jp.ac.hal.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.Corporation;
import jp.ac.hal.Util.InputCheck;

/**
 * Servlet implementation class CorporationRegist
 */
@WebServlet("/CorporationRegist")
public class CorporationRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorporationRegist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("edit") != null) {
			//パラメータ受け取り
			int corporationId = Integer.parseInt(request.getParameter("corporationId"));
			String corporationName = request.getParameter("corporationName");
			String postalCode = request.getParameter("postalCode");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String creditLimit = request.getParameter("creditLimit");

			String sendURL = "view/admin/corporations/corporation/corporation_detail.jsp?corporation_id=" + corporationId;
			String msg = "";
			InputCheck i = new InputCheck();
			boolean err = false;
			err |= i.checkNullChar(corporationName, postalCode, address, phoneNumber);
			err |= i.checkCharaLength(corporationName, 30);
			err |= i.checkCharaLength(address, 100);
			if(!err) {
				try {
					Dao dao = Dao.getNewInstance();
					Corporation c = new Corporation();
					c.setCorporationName(corporationName);
					c.setPostalCode(postalCode);
					c.setAddress(address);
					c.setCreditLimit(Integer.parseInt(creditLimit));
					c.setPhoneNumber(phoneNumber);
					dao.update(c, corporationId);
					msg = "登録が完了しました。";
				} catch (NamingException e) {
					e.printStackTrace();
					msg = "Naming";
				} catch (SQLException e) {
					e.printStackTrace();
					msg = "SQL";
				}
			} else {
				msg = "入力項目に誤りがあります。";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher disp = request.getRequestDispatcher(sendURL);
			//文字コード
			response.setContentType("text/html; charset=UTF-8");
			disp.forward(request, response);
		//////////////////////////////////////
		// 法人登録
		//////////////////////////////////////
		} else if (request.getParameter("regist") != null) {
			String corporationName = request.getParameter("corporationName");
			String postalCode = request.getParameter("postalCode");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String creditLimit = request.getParameter("creditLimit");

			int ret = 0;
			String msg = "";
			boolean err = false;
			InputCheck c = new InputCheck();
			err |= c.checkNullChar(corporationName, postalCode, address, phoneNumber);

			if (!err) {
				try {
					System.out.println("ss");
					ret =  Dao.getInstance().executeInsert
					(
							"insert into corporation_t values(corporation_seq.nextval, ?, ?, ?, ?, ?, sysdate)",
							corporationName,
							postalCode,
							address,
							phoneNumber,
							creditLimit
					);

					if (ret != 0) {
						// 処理が成功した場合登録した法人詳細へ飛ばす
						response.sendRedirect("view/admin/corporations/corporation/corporation_detail.jsp?corporation_id=" + ret);
					} else {
						msg = "DB処理でエラーが発生しました。";
					}
				} catch (SQLException | NamingException e) {
					e.printStackTrace();
				}
			} else {
				response.sendRedirect("view/admin/corporations/corporation/corporation_regist.jsp");
			}
		}
	}
}
