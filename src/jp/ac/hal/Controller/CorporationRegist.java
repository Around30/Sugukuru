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
		System.out.println(request.getParameter("edit"));
		
		if (request.getParameter("edit") != null) {
			//パラメータ受け取り
			int corporationId = Integer.parseInt(request.getParameter("corporationId"));
			String corporationName = request.getParameter("corporationName");
			String postalCode = request.getParameter("postalCode");
			String address = request.getParameter("address");
			String phoneNumber = request.getParameter("phoneNumber");
			String creditLimit = request.getParameter("creditLimit");
			
			String sendURL = "view/admin/corporations/corporation/corporation_detail.jsp?corporation_id=" + corporationId;
			
			System.out.println(corporationName);
			System.out.println(postalCode);
			System.out.println(address);
			System.out.println(phoneNumber);
			System.out.println(creditLimit);
	
			String msg = "";
			InputCheck i = new InputCheck();
			boolean err = false;
			err |= i.checkNullChar(corporationName, postalCode, address, phoneNumber, creditLimit);
			err |= i.checkCharaLength(corporationName, 30);
			err |= i.checkCharaLength(postalCode, 7);
			err |= i.checkNumbers(postalCode);
			err |= i.checkCharaLength(address, 100);
			err |= i.checkCharaLength(phoneNumber, 11);
			err |= i.checkNumbers(phoneNumber);
			err |= i.checkCharaLength(creditLimit, 8);
			err |= i.checkNumbers(creditLimit);
			
			System.out.println(err);
			
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
		}
	}
}
