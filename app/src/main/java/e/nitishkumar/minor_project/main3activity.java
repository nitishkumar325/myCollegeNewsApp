package e.nitishkumar.minor_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class main3activity extends AppCompatActivity {
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    TextView textView1,textview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3activity);
        linearLayout1=(LinearLayout)findViewById(R.id.llAll1);
        linearLayout2=(LinearLayout)findViewById(R.id.llAll2);
        textView1=(TextView)findViewById(R.id.textview1);
        textview2=(TextView)findViewById(R.id.textview2);
        getSupportFragmentManager().beginTransaction().add(R.id.mycontaineer,new firstfragment()).commit();
    }

    public void firstfragment(View view) {
        textView1.setTextColor(getResources().getColor(R.color.pure_white));
        textview2.setTextColor(getResources().getColor(R.color.colorAccent));
        // linearLayout2.setBackgroundColor(getResources().getColor(R.color.pure_white));
        linearLayout2.setBackgroundResource(R.drawable.round3);
        linearLayout1.setBackgroundResource(R.drawable.round_button);
        getSupportFragmentManager().beginTransaction().replace(R.id.mycontaineer,new firstfragment()).commit();
    }

    public void secondfragment(View view) {
        textView1.setTextColor(getResources().getColor(R.color.colorAccent));
        textview2.setTextColor(getResources().getColor(R.color.pure_white));
        //linearLayout2.setBackgroundColor(getResources().getColor(R.color.app_grey));
        linearLayout1.setBackgroundResource(R.drawable.round4);
        linearLayout2.setBackgroundResource(R.drawable.round_button1);
        getSupportFragmentManager().beginTransaction().replace(R.id.mycontaineer,new secondfragment()).commit();
    }

    public void thirdfragment(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.mycontaineer,new thirdfragment()).commit();
    }

  /*  public void thirdfragment(View view) {
        getSupportFragmentManager().beginTransaction().add(R.id.mycontaineer,new thirdfragment()).commit();
    }*/
}
