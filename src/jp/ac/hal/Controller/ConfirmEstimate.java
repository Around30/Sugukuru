package jp.ac.hal.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Dao.Dao;

/**
 * Servlet implementation class ConfirmEstimate
 */
@WebServlet("/ConfirmEstimate")
public class ConfirmEstimate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmEstimate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Dao.getInstance().executeUpdate
			(
				"update corporation_order_t set estimate_request_date = sysdate where order_id = ?",
				request.getSession().getAttribute("orderId")
			);
			request.getSession().setAttribute("orderId", null);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}

}
