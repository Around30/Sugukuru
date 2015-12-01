package jp.ac.hal.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Util.AdminMail;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String to = AdminMail.EMAIL_ADDRESS; //送り先メールアドレス
		String from = AdminMail.EMAIL_ADDRESS;
		String userName = AdminMail.USER_NAME;
		String passwd = AdminMail.PASSWORD;

		PrintWriter out = response.getWriter();
		try {
			Properties property = new Properties();

			property.put("mail.smtp.host","smtp.gmail.com");

            //GmailのSMTP設定
			//認証
            property.put("mail.smtp.auth", "true");
            //暗号化
            property.put("mail.smtp.starttls.enable", "true");
            //ホスト
            property.put("mail.smtp.host", "smtp.gmail.com");
            //ポート
            property.put("mail.smtp.port", "587");
            //デバッグモードON
            property.put("mail.smtp.debug", "true");

            Session session = Session.getInstance(property, new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(userName, passwd);
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
            InternetAddress toAddress = new InternetAddress(to);
            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
            InternetAddress fromAddress = new InternetAddress(from);
            mimeMessage.setFrom(fromAddress);
            mimeMessage.setSubject("Test", "ISO-2022-JP");
            mimeMessage.setText("TestMail", "ISO-2022-JP");
            Transport.send(mimeMessage);

            out.println("<htm><body>");
            out.println("メールを送信しました。");
            out.println("<body></html>");
        }
        catch(Exception e){
            out.println("<html><body>");
            out.println("メール送信に失敗しました");
            out.println("<br>エラーの内容" + e);
            out.println("</body></html>");
        }

        out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
