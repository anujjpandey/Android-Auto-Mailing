/*
package com.wildcoder.internal.emailing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.wildcoder.internal.emailing.AsyncMailer.IOnSentListener;

public class MainActivity extends Activity implements IOnSentListener,
		OnClickListener {
	TextView txt_quiz;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt_quiz = (TextView) findViewById(R.id.txt_quiz);
		txt_quiz.setOnClickListener(this);
	}

	public void onClick(View view) {
		Intent i = new Intent();
		i.setClassName("com.eddy.family.quiz",
				"com.eddy.family.quiz.ActivityQuizHome");
		i.putExtra("name", "Anuj");
		i.putExtra("id", "21");
		startActivityForResult(i, 103);
	}

	private void sendMail() {
		HtmlTable formator = new HtmlTable();
		formator.addPair("Name", "Anuj");
		formator.addPair("Email", "a@b.com");
		formator.addPair("Age", "8Yr");
		String body = "Hey There,<br><br>Please provide me the certificate I achived.<br><br>"
				+ formator.getHtmlTable();

		MailBuilder mailer = new MailBuilder();
		mailer.setSenderId("testforautomailing@gmail.com");
		mailer.setReceiverId("anuj.pandey@esecforte.com");
		mailer.setPassword("anuj7551").setBody(body);
		mailer.setSubject("Anuj Claimed Certificate");

		*/
/*
		 * MailBuilder mailer = new MailBuilder();
		 * mailer.setSenderId("testforautomailing@gmail.com");
		 * mailer.setReceiverId("testforautomailing@gmail.com");
		 * mailer.setPassword("anuj7551").setBody(body);
		 * mailer.setSubject("Test Automailing");
		 *//*

		AsyncMailer async = new AsyncMailer(mailer);
		if (async != null) {
			async.setOnSentListener(this);
			async.execute();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 103) {
			if (resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				String str = "";
				str += bundle.getString("name");
				str += " " + bundle.getString("id");
				str += " " + bundle.getString("category");
				str += " " + bundle.getString("certificate");
				txt_quiz.setText(str);
			}
		}
	}

	@Override
	public void onMailPrepare() {

	}

	@Override
	public void onMailSent() {
		Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show();
	}
}
*/
