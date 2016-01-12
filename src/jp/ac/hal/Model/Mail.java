package jp.ac.hal.Model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jp.ac.hal.Util.AdminMail;

public class Mail
{
	public static boolean send(String to, String subject, String message)
	{
		String from = AdminMail.EMAIL_ADDRESS;
		String userName = AdminMail.USER_NAME;
		String passwd = AdminMail.PASSWORD;

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
            mimeMessage.setSubject(subject, "ISO-2022-JP");
            mimeMessage.setText(message, "ISO-2022-JP");
            Transport.send(mimeMessage);

            return true;
        }
        catch(Exception e){
            return false;
        }
	}
}
