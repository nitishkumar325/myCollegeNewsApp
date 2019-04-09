package e.nitishkumar.minor_project;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class firstfragment extends Fragment {
RecyclerView recyclerView;
    ArrayList<newsinformation> listItems;
    recycleradapter adapter;
    String url="https://api.myjson.com/bins/lp66o";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firstfragment, container, false);
    }

    @Override
    public void onStart() {
       // Toast.makeText(getActivity(),"first fragment onstart",Toast.LENGTH_SHORT).show();
        recyclerView=(RecyclerView)getActivity().findViewById(R.id.myrecyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listItems=new ArrayList<>();
        loadRecyclerViewData();
        super.onStart();
    }
    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading data...");
        progressDialog.show();
        StringRequest stringRequest =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("myarray");
                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject o=array.getJSONObject(i);
                        newsinformation item=new newsinformation(o.getString("title"),o.getString("inshort"),o.getString("image"),o.getString("date"),o.getString("nexturl"));
                        //Toast.makeText(newsfeed.this,""+o.getString("name"),Toast.LENGTH_SHORT).show();
                        listItems.add(item);
                    }
                    adapter=new recycleradapter(listItems,getContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),"please try after some time"+e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                //Toast.makeText(getApplicationContext(),"please check your internet connection",Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        //Toast.makeText(this,"again"+url,Toast.LENGTH_SHORT).show();
        requestQueue.add(stringRequest);
    }
}
