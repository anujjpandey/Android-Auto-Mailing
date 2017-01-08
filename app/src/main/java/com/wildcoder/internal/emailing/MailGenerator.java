package com.wildcoder.internal.emailing;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import android.os.AsyncTask;

import com.wildcoder.internal.emailing.utils.MailingConstants;

public class MailGenerator implements MailingConstants {
	private String USER_NAME = "abaservices@therapyassociates.com";
	private String PASSWORD = "";
	private String RECPTION = "";

	public void sendText(String file_path_excel, String file_path_pdf)
			throws UnsupportedEncodingException {
		Session session = createSessionObject();
		try {
			Message message = createMessage(session, file_path_excel,
					file_path_pdf);
			try {
				Transport.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendMail(String file_path_excel, String file_path_pdf)
			throws UnsupportedEncodingException {
		Session session = createSessionObject();
		try {
			Message message = createMessage(session, file_path_excel,
					file_path_pdf);
			new SendMailTask().execute(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	private Message createMessage(Session session, String file_path_excel,
			String file_path_Pdf) throws MessagingException {
		Message message = new MimeMessage(session);
		Multipart mp = new MimeMultipart();
		File[] attachments = new File[2];
		attachments[0] = new File(file_path_excel);
		attachments[1] = new File(file_path_Pdf);

		for (int i = 0; i < attachments.length; i++) {
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			FileDataSource fileDataSource = new FileDataSource(attachments[i]);
			messageBodyPart.setDataHandler(new DataHandler(fileDataSource));
			messageBodyPart.setFileName(attachments[i].getName());
			mp.addBodyPart(messageBodyPart);
		}
		message.setFrom(new InternetAddress(USER_NAME));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				RECPTION));
		message.setSubject("Subject");
		message.setContent(mp);
		return message;
	}

	private Session createSessionObject() {
		Properties properties = new Properties();
		properties.put(AUTH, "true");
		properties.put(STARTLS, "true");
		properties.put(HOST, "smtp.gmail.com");
		properties.put(PORT, "587");
		return Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER_NAME, PASSWORD);
			}
		});
	}

	private class SendMailTask extends AsyncTask<Message, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
		}

		@Override
		protected Void doInBackground(Message... messages) {
			try {
				Transport.send(messages[0]);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
