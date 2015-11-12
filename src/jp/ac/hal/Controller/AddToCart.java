package jp.ac.hal.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.Order;
import jp.ac.hal.Model.OrderDetail;
import jp.ac.hal.Util.Ic;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession s = request.getSession();
			if(s.getAttribute("orderId") == null)
			{
				Order o = new Order();
				o.setCart(true);
				int id = Dao.getInstance().insert(o);
				s.setAttribute("orderId", id);
			}
			
			OrderDetail d = new OrderDetail();
			d.setOrderId((Integer)s.getAttribute("orderId"));
			d.setProductId(Ic.intNotNullable(request.getParameter("productId")));
			d.setNumberOf(Ic.intNotNullable(request.getParameter("numberOf")));
			d.setSubTotal(Ic.intNullable(request.getParameter("subTotal")));
			Dao.getInstance().insert(d);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
