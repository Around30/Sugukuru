package jp.ac.hal.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.CorporationOrder;
import jp.ac.hal.Model.Mail;

/**
 * Servlet implementation class CorporationWebOrder
 */
@WebServlet("/CorporationWebOrder")
public class CorporationWebOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			if(request.getSession().getAttribute("administratorLogin") != null)
			{
				Mail.send
				(
					request.getParameter("id"),
					request.getContextPath() + "/view/cart/login_for_confirm.jsp"
				);
			}
			else if
			(
				Dao.getInstance().executeConfirm
				(
					"select * from corporation_account_t where corporation_account_id = ? and password = ?",
					request.getParameter("id"),
					request.getParameter("password")
				)
			)
			{
				CorporationOrder o = new CorporationOrder();
				o.setOrderId(Dao.getInstance().getOrderId(request));
				o.setCorporationAccountId(request.getParameter("id"));
				Dao.getInstance().insert(o);
				response.sendRedirect(request.getContextPath() + "/view/cart/corporation_order_confirm.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
