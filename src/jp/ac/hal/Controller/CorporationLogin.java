package jp.ac.hal.Controller;

import java.io.IOException;
import java.sql.SQLException;

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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 受け取る文字コードの設定
		request.setCharacterEncoding("UTF-8");
		//転送先
		String sendURL = "view/index.jsp";
		//エラーフラグ
		boolean err = false;
		//エラーメッセージ格納用
		String msg = "";
		//パラメータ受取
		//テストデータ id:1 pass:zoysxqwgdn
		String corporationAccountId = request.getParameter("corporationAccountId");
		String passwd = request.getParameter("passwd");
		//パラメータチェック
		InputCheck i = new InputCheck();
		err |= i.checkCharaLength(corporationAccountId, 8);
		err |= i.checkCharaLength(passwd, 50);
		err |= i.checkNullChar(corporationAccountId, passwd);
		err |= i.checkNumbers(corporationAccountId);

		//パラメータエラーなし
		if (!err) {
			//ログイン処理
			try {
				Dao dao = Dao.getNewInstance();
				//アカウントIDとpassが一致する法人IDと法人アカウントIDと法人アカウント名を受け取る
				Object[] cData = dao.corporationLogin(Integer.parseInt(corporationAccountId),passwd);
				if(cData != null){
					//セッションを生成、セッションに受け取ったデータを入れる
					HttpSession session = request.getSession(true);
					session.setAttribute("corporationLogin",cData);
					//セッションの有効時間を30分に設定
					session.setMaxInactiveInterval(1800);

				}
				else{
					err = true;
					msg = "入力したIDとパスワードが一致しません。";
					sendURL = "view/login/index.jsp";
				}
			} catch (NamingException e) {
				e.printStackTrace();
				err = true;
				msg = "DB処理でエラーが発生しました。";
				sendURL = "view/login/index.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
				err = true;
				msg = "DB処理でエラーが発生しました。";
				sendURL = "view/login/index.jsp";
			}
		}
		//パラメータエラーあり
		else {
			err = true;
			msg = "入力項目に誤りがあります。";

		}
		if(err){
			//Login画面へ戻る
			sendURL = "view/login/index.jsp";
			//メッセージ転送
			request.setAttribute("msg", msg);
			//request.setAttribute("err", err);
		}
		RequestDispatcher disp = request.getRequestDispatcher(sendURL);
		//文字コード
		response.setContentType("text/html; charset=UTF-8");
		disp.forward(request, response);
	}
}
