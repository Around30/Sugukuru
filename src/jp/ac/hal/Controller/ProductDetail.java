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

import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Util.InputCheck;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 受け取る文字コードの設定
				request.setCharacterEncoding("UTF-8");

				//転送先
				String sendURL = "view/items/item/index.jsp";
				// パラメータを受け取り変数にセット
//				String productId = request.getParameter("productId");
				String productId = "1";
				String msg;
				//パラメータチェック
				InputCheck i = new InputCheck();
				boolean err = false;
				err |= i.checkCharaLength(productId, 8);
				err |= i.checkNullChar(productId);
				err |= i.checkNumbers(productId);


				//エラーなし
				if (!err) {
					try {
						Dao dao = Dao.getNewInstance();
						Object[] pDetail = dao.productDetail(Integer.parseInt(productId));
//						Product product = new Product((int)(pDetail[0]),(String)pDetail[1],(String)pDetail[2],(int)pDetail[3],(int)pDetail[4],(int)pDetail[5],(int)pDetail[6],(int)pDetail[7],(int)pDetail[8],(int)pDetail[9],(int)pDetail[10],(String)pDetail[11],(int)pDetail[12]);
						request.setAttribute("pDetail",pDetail);
					} catch (NamingException e) {
						e.printStackTrace();
						err = true;
						msg = "DB処理でエラーが発生しました。";
						sendURL = "view/index.jsp";
					} catch (SQLException e) {
						e.printStackTrace();
						err = true;
						msg = "DB処理でエラーが発生しました。";
						sendURL = "view/index.jsp";
					}
				}
				//エラーあり
				else {
					msg = "不正な値です。";
					//トップ画面へ戻る
					sendURL = "view/index.jsp";
					//メッセージ転送
					request.setAttribute("msg", msg);
					request.setAttribute("err", err);
				}

				RequestDispatcher disp = request.getRequestDispatcher(sendURL);

				//文字コード
				response.setContentType("text/html; charset=UTF-8");

				disp.forward(request, response);
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
		String sendURL = "view/items/item/index.jsp";
		// パラメータを受け取り変数にセット
		String productId = request.getParameter("productId");
		String msg;
		//パラメータチェック
		InputCheck i = new InputCheck();
		boolean err = false;
		err |= i.checkCharaLength(productId, 8);
		err |= i.checkNullChar(productId);
		err |= i.checkNumbers(productId);


		//エラーなし
		if (!err) {
			try {
				Dao dao = Dao.getNewInstance();
				Object[] pDetail = dao.productDetail(Integer.parseInt(productId));
//				Product product = new Product((int)(pDetail[0]),(String)pDetail[1],(String)pDetail[2],(int)pDetail[3],(int)pDetail[4],(int)pDetail[5],(int)pDetail[6],(int)pDetail[7],(int)pDetail[8],(int)pDetail[9],(int)pDetail[10],(String)pDetail[11],(int)pDetail[12]);
				request.setAttribute("pDetail",pDetail);
			} catch (NamingException e) {
				e.printStackTrace();
				err = true;
				msg = "DB処理でエラーが発生しました。";
				sendURL = "view/index.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
				err = true;
				msg = "DB処理でエラーが発生しました。";
				sendURL = "view/index.jsp";
			}
		}
		//エラーあり
		else {
			msg = "不正な値です。";
			//トップ画面へ戻る
			sendURL = "view/index.jsp";
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
