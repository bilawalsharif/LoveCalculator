package bilawal.love.love.lovecalculator;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.MobileAds;

import java.util.Random;

import pl.droidsonroids.gif.GifTextView;

public class MainActivity extends AppCompatActivity {
    EditText edmale,edfemale;
    Button btn_cal;
    ImageView imageView;
    TextView txtresult;
    FrameLayout frameLayout;
    TextInputLayout usernameWrapper,passwordWrapper;
    private GifTextView imgPetals,imgPetals1;

    //InterstitialAd mInterstitialAd2;

   // ca-app-pub-3093263995894520~6692392206
    //unit id ca-app-pub-3093263995894520/3683085482
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widgets();


        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //showAd();
                if(!edfemale.getText().toString().equals("")&&!edmale.getText().toString().equals("")) {
                    hideKeyboard();
                    frameLayout.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    String male = edmale.getText().toString();
                    String female = edfemale.getText().toString();
                    if (male.equals(" ")) {
                        Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                        // edfemale.setError("");
                        // usernameWrapper.setError("Enter Name");
                        hideKeyboard();
                    }
                    if (female.equals(" ")) {
                        Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                        // edmale.setError("");
                        //passwordWrapper.setError("Enter Name");
                    }

                    edmale.setText("");
                    edfemale.setText("");
                    edfemale.setVisibility(View.GONE);
                    edmale.setVisibility(View.GONE);
                    btn_cal.setVisibility(View.GONE);

//                    Calendar c=Calendar.getInstance();
//                    String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
//                    String month=String.valueOf(c.get(Calendar.MONTH));
//                    String year=String.valueOf(c.get(Calendar.YEAR));
//
//                    String result_string=female+male+day+month+year;
//                    result_string=result_string.toLowerCase();
//                    result_string=result_string.trim();
//                    int seed=result_string.hashCode();
//                    Random random=new Random(seed);

                    // txtresult.setText((random.nextInt(100)+1+"%"));
                    // String no =(random.nextInt(100)+1+"%");

                    //   StringBuilder sb=new StringBuilder(no);

                    Random rand = new Random();

                    int n = rand.nextInt(100);

                    n += 1;

                    //   sb.deleteCharAt(2);

                    //  if (Integer.parseInt(sb.toString())>=50) {
                    if (n >= 50) {
                        txtresult.setText(String.valueOf(n + "%"));
                        imgPetals.setVisibility(View.VISIBLE);
                        imgPetals.setBackgroundResource(R.drawable.petals);
                    } else {

                        imgPetals1.setVisibility(View.VISIBLE);
                        imgPetals1.setBackgroundResource(R.drawable.cc);
                        txtresult.setText(String.valueOf(n + "%"));
                    }
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frameLayout.setVisibility(View.GONE);
                edfemale.setVisibility(View.VISIBLE);
                edmale.setVisibility(View.VISIBLE);
                btn_cal.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
                imgPetals.setVisibility(View.GONE);
                imgPetals1.setVisibility(View.GONE);
                txtresult.setText("");
            }
        });



    }
    public void widgets()
    {
        edmale= (EditText) findViewById(R.id.txtmale);
        edfemale= (EditText) findViewById(R.id.txtfemale);
        btn_cal = (Button) findViewById(R.id.btn_cal);
        txtresult = (TextView) findViewById(R.id.txtresult);
        imageView= (ImageView) findViewById(R.id.btnRestore);
        frameLayout= (FrameLayout) findViewById(R.id.linearLayout);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        usernameWrapper= (TextInputLayout) findViewById(R.id.usernameWrapper);
        imgPetals =(GifTextView) findViewById(R.id.imgPetals);
        imgPetals1 =(GifTextView) findViewById(R.id.imgPetals1);
    }

    @Override
    public void onBackPressed() {
        //showAd();
       finish();
    }
    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

//   public void showAd()
//    {
//        MobileAds.initialize(this, "ca-app-pub-3093263995894520~6692392206");
//
//        mInterstitialAd2 = new InterstitialAd(this);
//        mInterstitialAd2.setAdUnitId("ca-app-pub-3093263995894520/3683085482");
//        AdRequest request = new AdRequest.Builder().build();
//        mInterstitialAd2.loadAd(request);
//        mInterstitialAd2.setAdListener(new AdListener(){
//             public void onAdLoaded(){
//                if (mInterstitialAd2.isLoaded()) {
//                    mInterstitialAd2.show();
//                }
//            }
//        });
//    }
}
