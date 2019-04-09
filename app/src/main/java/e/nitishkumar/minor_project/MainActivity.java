package e.nitishkumar.minor_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
List<post_pojo> mylist=new ArrayList<>();
String url="https://api.myjson.com/bins/1e24tc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.mytext);
        getDataFromServer();
        Log.d("get data not invoked","invoked");
    }
    public void getDataFromServer()
    {
        StringRequest myrequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    JSONArray array=object.getJSONArray("myarray");
                    for(int i=0;i<array.length();i++)
                    {
                        Log.d("hiiiii","hiiiiii2");
                        JSONObject object1=array.getJSONObject(i);
                        post_pojo mypojo=new post_pojo();
                        mypojo.setTitle(object1.getString("title"));
                        mypojo.setSubtitle(object1.getString("subtitle"));
                        mypojo.setDate(object1.getString("date"));
                        mypojo.setImage(object1.getString("image"));
                        mypojo.setInDetail(object1.getString("indetail"));
                        textView.setText(object1.getString("indetail"));
                        //Log.d("title",object1.getString("title"));
                       mylist.add(mypojo);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("hiiiii",e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.getMessage());
                Toast.makeText(MainActivity.this,"error"+error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue=Volley.newRequestQueue(this);
        queue.add(myrequest);
    }
}
