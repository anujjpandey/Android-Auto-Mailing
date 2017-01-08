package com.emailing.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.wildcoder.internal.emailing.AsyncMailer;
import com.wildcoder.internal.emailing.AsyncMailer.IOnSentListener;
import com.wildcoder.internal.emailing.MailBuilder;
import com.wildcoder.internal.emailing.utils.CheckNetwork;
import com.wildcoder.bootreceiver.R;

public class MainActivity extends Activity implements IOnSentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void sendMail() {
        if (CheckNetwork.isInternetConnected(this)) {
            MailBuilder mailer = new MailBuilder()
                    .setSenderId("<Sender Email Id Here>")
                    .setPassword("<Sender Password Here>")
                    .setBody("<Mail Body Here>")
                    .setReceiverId("Receiver Email Id Here")
                    .setSubject("<Subject Here>");

            AsyncMailer async = new AsyncMailer(mailer);
            async.setOnSentListener(this);
            async.execute();
        } else {
            Toast.makeText(this, "Unable to process the request no active intenet connection found",Toast.LENGTH_SHORT).show();
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
