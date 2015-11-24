package jp.ac.hal.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.OrderDetail;
import jp.ac.hal.Util.Ic;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			OrderDetail d = new OrderDetail();
			d.setOrderId(Dao.getInstance().getOrderId(request));
			d.setProductId(Ic.intNotNullable(request.getParameter("productId")));
			d.setNumberOf(Ic.intNotNullable(request.getParameter("numberOf")));
			d.setSubTotal(Ic.intNullable(request.getParameter("subTotal")));
			Dao.getInstance().insert(d);
			response.sendRedirect(request.getContextPath() + "/view/cart/index.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
