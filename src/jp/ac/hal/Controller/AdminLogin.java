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
import jp.ac.hal.Util.InputCheck;

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
//		try
//		{
//			request.setCharacterEncoding("UTF-8");
//
//			//パラメータ受け取り
//			String administratorId = request.getParameter("administratorId");
//			String passwd = request.getParameter("passwd");
//			InputCheck i = new InputCheck();
//			boolean err = false;
//			err |= i.checkCharaLength(administratorId, 8);
//			err |= i.checkCharaLength(passwd, 50);
//			err |= i.checkNullChar(administratorId ,passwd);
//			err |= i.checkNumbers(administratorId);
//			Dao dao = Dao.getInstance();
//			Admin admin = new Admin(dao.executeGet("select * from administrator_t where administrator_id = ? and passwd = ?", administratorId, passwd));
//			err |= admin == null;
//			if (!err) {
//				//セッションを生成
//				HttpSession session = request.getSession(true);
//				//セッションの有効時間を30分に設定
//				session.setMaxInactiveInterval(1800);
//				session.setAttribute("admin", admin);
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}

		// 受け取る文字コードの設定
		request.setCharacterEncoding("UTF-8");
		//転送先
		String sendURL = "view/corporations/index.jsp";
		//エラーフラグ
		boolean err = false;
		//メッセージ格納用List
		ArrayList<String> msg = new ArrayList<String>();
		//パラメータ受取
		String administratorId = request.getParameter("administratorId");
		String passwd = request.getParameter("passwd");
		//パラメータチェック
		InputCheck i = new InputCheck();
		err |= i.checkCharaLength(administratorId, 8);
		err |= i.checkCharaLength(passwd, 50);
		err |= i.checkNullChar(administratorId ,passwd);
		err |= i.checkNumbers(administratorId);

		//エラーなし
		if (!err) {
			//ログイン処理
			try {
				Dao dao = Dao.getNewInstance();
				//アカウントIDとpassが一致する法人IDと法人アカウントIDと法人アカウント名を受け取る
				Object[] administratorLogin = dao.administratorLogin(Integer.parseInt(administratorId),passwd);

				//セッションを生成、セッションに受け取ったデータを入れる
				HttpSession session = request.getSession(true);
				session.setAttribute("administratorLogin",administratorLogin);
				//セッションの有効時間を30分に設定
				session.setMaxInactiveInterval(1800);
			} catch (NamingException e) {
				e.printStackTrace();
				err = true;
				msg.add( "DB処理でエラーが発生しました。");
				sendURL = "view/admin/index.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
				err = true;
				msg.add( "DB処理でエラーが発生しました。");
				sendURL = "view/admin/index.jsp";
			}
		}
		//エラーあり
		else {
			msg.add("入力項目に誤りがあります。");
			//Login画面へ戻る
			sendURL = "view/admin/index.jsp";
			//メッセージ転送
			request.setAttribute("msg", msg);
			request.setAttribute("err", err);
		}
		RequestDispatcher disp = request.getRequestDispatcher(sendURL);
		//文字コード
		response.setContentType("text/html; charset=UTF-8");
		disp.forward(request, response);
	}
}
