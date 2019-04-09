package e.nitishkumar.minor_project;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class recycleradapter extends RecyclerView.Adapter<recycleradapter.viewholder> {
List<newsinformation>list;
Context context;

    public recycleradapter(List<newsinformation>list,Context context) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.news_layout,null);
        // progressBar=(ProgressBar)view.findViewById(R.id.mypro);
        //progressBar.setVisibility(View.VISIBLE);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, final int i) {
        viewholder.title.setText(list.get(i).getTitle());
        viewholder.date.setText(list.get(i).getDate());
        viewholder.inshort.setText(list.get(i).getinshort());
        Picasso.with(context).load(list.get(i).getImage()).into(viewholder.imageView);
        viewholder.indetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("url",list.get(i).getNexturl());
                thirdfragment myfragment=new thirdfragment();
                myfragment.setArguments(bundle);
                ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.mycontaineer,myfragment).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,date,inshort,indetail;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            indetail=(TextView)itemView.findViewById(R.id.indetail);
            imageView =(ImageView)itemView.findViewById(R.id.newsimage);
            title =(TextView) itemView.findViewById(R.id.title);
            inshort =(TextView) itemView.findViewById(R.id.inshort);
            date =(TextView) itemView.findViewById(R.id.date);
        }
    }

}
