package jp.ac.hal.Controller;

import jp.ac.hal.Util.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		//パラメータ受け取り
		String administratorId = request.getParameter("administratorId");
		String passwd = request.getParameter("passwd");
		InputCheck i = new InputCheck();
		boolean err = false;
		err |= i.checkCharaLength(administratorId, 8);
		err |= i.checkCharaLength(passwd, 50);
		err |= i.checkNullChar(passwd);
		err |= i.checkNumbers(administratorId);
		 
		if (!err) {
			
		}
	}

}
