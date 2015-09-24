package jp.ac.hal.Controller;

import jp.ac.hal.Dao.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//パラメータ受け取り
		String corporationName = request.getParameter("corporationName");
		String postalCode = request.getParameter("postalCode");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("address");
		String passwd = request.getParameter("passwd");
		String creditLimit = request.getParameter("creditLimit");
		
		//入力項目チェック
		InputCheck i = new InputCheck();
		boolean err = false;
		err |= i.checkNullChar(corporationName, postalCode, address, phoneNumber, passwd, creditLimit);
		err |= i.checkCharaLength(corporationName, 30);
		err |= i.checkCharaLength(postalCode, 7);
		err |= i.checkCharaLength(address, 100);
		err |= i.checkCharaLength(phoneNumber, 11);
		err |= i.checkCharaLength(passwd, 50);
		err |= i.checkCharaLength(creditLimit, 8);
		err |= i.checkNumbers(postalCode, phoneNumber, creditLimit);
		
		/*
		if(!err) {
			try {
				Dao dao = Dao.getNewInstance();
				
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
		}
		*/
	}
}
