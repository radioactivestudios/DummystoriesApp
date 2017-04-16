package com.radioactivestudios.hindihorrorstories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.*;

/**
 * Created by radioactive on 4/13/2017.
 */

public class GridViewActivity extends AppCompatActivity {
    GridView HorrorStoryMainGrid;
    String[] CataegoryType = {"डायन प्रेत","मुर्दे का प्यार",
                                "आत्मा का साया","शापित हवेली",
                                    "शमशान घाट","डरना जरूरी है",};
    int[] CataegoryTypeImage= {R.drawable.demon,R.drawable.ghost_love,
                                    R.drawable.sculls,R.drawable.souls,
                                    R.drawable.coffin,R.drawable.voodoo};

    @Override
    protected void onCreate(Bundle savedInsatnceState){
        super.onCreate(savedInsatnceState);
        setContentView(R.layout.activity_home_grid);


        GridViewAdapter HorrorStoryGridAdapter = new GridViewAdapter
                                            (GridViewActivity.this,CataegoryType,CataegoryTypeImage);
        Log.i("reached inside activity","Lets go");
        HorrorStoryMainGrid = (GridView)findViewById(R.id.Story_Cataegory_grids);
       // MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544/6300978111");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        HorrorStoryMainGrid.setAdapter(HorrorStoryGridAdapter);
        HorrorStoryMainGrid.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int i ,long Id)
            {
                Intent intent = new Intent(GridViewActivity.this, Home.class);
                intent.putExtra("selected-cataegory",CataegoryType[+i]);
                startActivity(intent);
                Log.i("now raise a toast honey",""+ CataegoryType[+i]);
                //Toast.makeText(GridViewActivity.this, "GridView Item: " +CataegoryType[+i], Toast.LENGTH_LONG).show();

            }
        });
        final Button EmailButton = (Button)findViewById(R.id.SendEmail);
        EmailButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent emailIntent = new Intent(GridViewActivity.this,Emailer.class);
                //Toast.makeText(GridViewActivity.this, "GridView Item: " +EmailButton.getText() , Toast.LENGTH_LONG).show();
                startActivity(emailIntent);
            }
        });
        };
}




