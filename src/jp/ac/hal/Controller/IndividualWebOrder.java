package jp.ac.hal.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.IndividualOrder;
import jp.ac.hal.Util.Ic;

/**
 * Servlet implementation class IndividualWebOrder
 */
@WebServlet("/IndividualWebOrder")
public class IndividualWebOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualWebOrder() {
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
			IndividualOrder o = new IndividualOrder();
			o.setOrderId(Dao.getInstance().getOrderId(request));
			System.out.println(o.getOrderId());
			o.setName(Ic.stringNotNullable(request.getParameter("name")));
			o.setPhonetic(Ic.stringNotNullable(request.getParameter("phonetic")));
			o.setPostalCode(Ic.stringNotNullable(request.getParameter("postalCode")));
			o.setAddress(Ic.stringNotNullable(request.getParameter("address")));
			o.setPhoneNumber(Ic.stringNotNullable(request.getParameter("phoneNumber")));
			o.setMailAddress(Ic.stringNotNullable(request.getParameter("mailAddress")));
			Dao.getInstance().insert(o);
			response.sendRedirect(request.getContextPath() + "/view/cart/individual_order_confirm.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
