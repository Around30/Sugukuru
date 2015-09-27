package jp.ac.hal.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.Corporation;
import jp.ac.hal.Model.CorporationOrder;
import jp.ac.hal.Util.Ic;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			HttpSession s = request.getSession();
			Order o = new Order();
			o.setCorporationAccountId((Integer)s.getAttribute("corporationAccountId"));
			o.setConfirmed(true);
			int id = Dao.getInstance().insert(o);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
