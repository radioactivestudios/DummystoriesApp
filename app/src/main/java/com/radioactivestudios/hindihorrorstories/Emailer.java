package com.radioactivestudios.hindihorrorstories;

/**
 * Created by radioactive on 4/16/2017.
 */import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Emailer extends Activity {

    Button EmailNow;
    String textTo;
    EditText textSubject;
    EditText textMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailerpage);

        EmailNow = (Button) findViewById(R.id.EmailNow);
        textTo= "horrorstorieshindi@gmail.com";
        textSubject =(EditText)findViewById(R.id.editStoryTitle);
        textMessage = (EditText)findViewById(R.id.editStoryFull);
       // MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544/6300978111");
        AdView mAdView = (AdView) findViewById(R.id.adView_emailPage);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        EmailNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = "horrorstorieshindi@gmail.com";
                String StoryTitle =textSubject.getText().toString();
                String StroryFull =textMessage.getText().toString();
                Intent email_Stroy_to_App = new Intent(Intent.ACTION_SEND);
                email_Stroy_to_App.putExtra(Intent.EXTRA_EMAIL,new String[]{"horrorstorieshindi@gmail.com"});
                email_Stroy_to_App.putExtra(Intent.EXTRA_SUBJECT,StoryTitle);
                email_Stroy_to_App.putExtra(Intent.EXTRA_TEXT,StroryFull);
                email_Stroy_to_App.setType("message/rfc822");
                startActivity(Intent.createChooser(email_Stroy_to_App, "Choose an Email client :"));
            }
        });
    }
}
