package com.radioactivestudios.hindihorrorstories;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;


public class Home extends Activity {

    ListView StoryList;
    String[] Stories;
    String SelectedCataegory;
    String SelectedCatategory_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544/6300978111");
        AdView mAdView = (AdView) findViewById(R.id.adView_Home);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        final Button EmailButton = (Button)findViewById(R.id.SendEmailHomeList);
        EmailButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(Home.this,Emailer.class);
                //Toast.makeText(GridViewActivity.this, "GridView Item: " +EmailButton.getText() , Toast.LENGTH_LONG).show();
                startActivity(emailIntent);
            }
        });
        Intent intent = getIntent();
        SelectedCataegory = intent.getStringExtra("selected-cataegory");
         StoryList = (ListView) findViewById(R.id.HorrorstoryList);
        switch (SelectedCataegory){
            case "डायन प्रेत":
                Stories = (String[]) getResources().getStringArray(R.array.Story_title_demon);
                SelectedCatategory_id ="0";
                break;
            case "मुर्दे का प्यार":
                Stories = (String[]) getResources().getStringArray(R.array.Story_title_deadlover);
                SelectedCatategory_id="1";
                break;
            case "आत्मा का साया":
                Stories= (String[])getResources().getStringArray(R.array.Story_title_soulShadow);
                SelectedCatategory_id="2";
                break;
            case "शापित हवेली":
                Stories= (String[])getResources().getStringArray(R.array.Story_title_hauntedHouse);
                SelectedCatategory_id="3";
                                break;
            case "शमशान घाट":
                Stories =(String[])getResources().getStringArray(R.array.Story_title_graveyard);
                SelectedCatategory_id="4";
                break;
            default:
                 Stories = (String[]) getResources().getStringArray(R.array.Story_title_deadlyToy);
                SelectedCatategory_id= "5";

        }

        //String[] Stories = (String[]) getResources().getStringArray(R.array.Story_title);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_shortstories,
                R.id.horrorStoryHomeText, Stories);
        StoryList.setAdapter(adapter);

        StoryList.setOnItemClickListener(new ListClickHandler());
    }

    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            ArrayList<String> storyandandcategory = new ArrayList<>();
            storyandandcategory.add(SelectedCatategory_id);
            // TODO Auto-generated method stub
            TextView listText = (TextView) view.findViewById(R.id.horrorStoryHomeText);
            String text = listText.getText().toString();
            storyandandcategory.add(text);
            Intent intent = new Intent(Home.this, HorrorStoryActivity.class);
            intent.putStringArrayListExtra("selected-item", storyandandcategory);
            startActivity(intent);

        }
    }
}
