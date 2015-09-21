package jp.ac.hal.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Dao.CorporationDao;
import jp.ac.hal.Model.Corporation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);

		// 受け取る文字コードの設定
		request.setCharacterEncoding("UTF-8");

		String flag = request.getParameter("flag");
		//エラーフラグ
		boolean err = false;
		//メッセージ格納用ArrayList
		ArrayList<String> msg = new ArrayList<String>();

		//セッションを生成
		HttpSession session = request.getSession(true);
		//セッションの有効時間を30分に設定
		session.setMaxInactiveInterval(1800);


		//Corporationオブジェクト生成
		Corporation corporationData = new Corporation();

		//DAOオブジェクト作成
		CorporationDao dao = new CorporationDao();

		//corporationIdの設定
		corporationData.setCorporationId(Integer.parseInt(request.getParameter("corporationId")));

		//passwdの設定
		corporationData.setPasswd(request.getParameter("passwd"));

		//



		//転送処理
		String disPage = "";
		//メッセージ転送
		disPage = "request.jsp";

		RequestDispatcher disp = request.getRequestDispatcher(disPage);

		//文字コード
		response.setContentType("text/html; charset=UTF-8");

		//メッセージ転送
		request.setAttribute("msg", msg);
		disp.forward(request, response);


	}

}
