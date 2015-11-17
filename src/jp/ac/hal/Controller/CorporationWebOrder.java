package jp.ac.hal.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.CorporationOrder;

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
			Dao.getInstance().executeUpdate
			(
				"update order_t set cart = false where order_id = ?",
				request.getSession().getAttribute("orderId")
			);
			CorporationOrder o = new CorporationOrder();
			o.setOrderId(Dao.getInstance().getOrderId(request));
			o.setCorporationAccountId((Integer)request.getSession().getAttribute("orderId"));
			o.setConfirmed(true);
			Dao.getInstance().insert(o);
			request.getSession().setAttribute("orderId", null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
