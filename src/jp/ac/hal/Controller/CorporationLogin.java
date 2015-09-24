package jp.ac.hal.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Model.Corporation;
import jp.ac.hal.Util.InputCheck;

/**
 * Servlet implementation class CorporationLogin
 */
@WebServlet("/CorporationLogin")
public class CorporationLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorporationLogin() {
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

		//転送先
		String sendURL = "index.jsp";
		//エラーフラグ
		boolean err = false;
		//メッセージ格納用ArrayList
		ArrayList<String> msg = new ArrayList<String>();

		//セッションを生成
		HttpSession session = request.getSession(true);
		//セッションの有効時間を30分に設定
		session.setMaxInactiveInterval(1800);

		//パラメータ受取
		String corporationId = request.getParameter("corporationId");
		String passwd = request.getParameter("passwd");

		//パラメータチェック
		InputCheck i = new InputCheck();
		err |= i.checkCharaLength(corporationId, 8);
		err |= i.checkNullChar(corporationId, passwd);
		err |= i.checkNumbers(corporationId);

		//エラーなし
		if (!err) {
			//ログイン処理

			try {
				Dao dao = Dao.getNewInstance();
				//Corporationオブジェクト生成
				Corporation c = new Corporation();
				c.setCorporationId(Integer.parseInt(corporationId));
				c.setPasswd(passwd);

				dao.select(c);
//				msg.add( "ログインしました。");
			} catch (NamingException e) {
				e.printStackTrace();
				err = true;
				msg.add( "DB処理でエラーが発生しました。");
			} catch (SQLException e) {
				e.printStackTrace();
				err = true;
				msg.add( "DB処理でエラーが発生しました。");
			}

		}
		//エラーあり
		else {

		//Login画面へ戻る
		sendURL = "CorpLogin.jsp";
		//メッセージ転送
		request.setAttribute("msg", msg);

		}

		RequestDispatcher disp = request.getRequestDispatcher(sendURL);

		//文字コード
		response.setContentType("text/html; charset=UTF-8");


		disp.forward(request, response);


	}

}
