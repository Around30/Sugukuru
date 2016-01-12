package jp.ac.hal.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Util.Ic;

/**
 * Servlet implementation class LoginForConfirm
 */
@WebServlet("/LoginForConfirm")
public class LoginForConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			if
			(
				Dao.getInstance().executeConfirm
				(
					"select 1 from corporation_account_t",
					Ic.intNotNullable(request.getParameter("corporation_account_id")),
					Ic.stringNotNullable(request.getParameter("password"), 8, 16)
				)
			)
			{
				request.getSession().setAttribute("orderId", request.getParameter("orderId"));
				response.sendRedirect(request.getContextPath() + "/view/cart/corporation_order_confirm.jsp");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
