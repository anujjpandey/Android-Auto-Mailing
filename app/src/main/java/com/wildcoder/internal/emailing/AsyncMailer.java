package com.wildcoder.internal.emailing;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.os.AsyncTask;

import com.wildcoder.internal.emailing.utils.MailingConstants;

public class AsyncMailer extends AsyncTask<Void, Void, Void> implements
		MailingConstants {
	private MailBuilder mailBulderDataSet;

	public AsyncMailer(MailBuilder mailBuilder) {
		this.mailBulderDataSet = mailBuilder;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		if (onSentListener != null)
			onSentListener.onMailPrepare();
	}

	@Override
	protected Void doInBackground(Void... params) {
		Session session = createSessionObject();
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailBulderDataSet.getSenderId()));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					mailBulderDataSet.getReceiverId()));
			msg.setSubject(mailBulderDataSet.getSubject());
			msg.setContent(mailBulderDataSet.getBody(),
					"text/html; charset=ISO-8859-1");
			// msg.setText(mailBulderDataSet.getBody());
			Transport.send(msg);
		} catch (AddressException e) {
		} catch (MessagingException e) {
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
		if (onSentListener != null)
			onSentListener.onMailSent();
	}

	private Session createSessionObject() {
		Properties properties = new Properties();
		properties.put(AUTH, "true");
		properties.put(STARTLS, "true");
		properties.put(HOST, "smtp.gmail.com");
		properties.put(PORT, "587");
		return Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailBulderDataSet
						.getSenderId(), mailBulderDataSet.getPassword());
			}
		});
	}

	public IOnSentListener getOnSentListener() {
		return onSentListener;
	}

	public void setOnSentListener(IOnSentListener onSentListener) {
		this.onSentListener = onSentListener;
	}

	private IOnSentListener onSentListener;

	public interface IOnSentListener {
		public void onMailPrepare();

		public void onMailSent();
	}
}
