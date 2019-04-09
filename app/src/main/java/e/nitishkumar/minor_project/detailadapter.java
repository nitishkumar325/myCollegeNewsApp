package e.nitishkumar.minor_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class detailadapter extends RecyclerView.Adapter<detailadapter.viewholder> {
    List<detaildetail> list;
    Context context;

    public detailadapter(List<detaildetail> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.news_detail, null);
        // progressBar=(ProgressBar)view.findViewById(R.id.mypro);
        //progressBar.setVisibility(View.VISIBLE);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
        Picasso.with(context).load(list.get(i).detailfirstimage).into(viewholder.detailtitlefirstimage);
        Picasso.with(context).load(list.get(i).detailsecondimage).into(viewholder.detailtitlesecondimage);
        Picasso.with(context).load(list.get(i).detailthirdimage).into(viewholder.detailtitlethirdimage);
        viewholder.detailtitle.setText(list.get(i).getDetailtitle());
        viewholder.detailfirst.setText(list.get(i).getDetailfirst());
        viewholder.detailsecond.setText(list.get(i).getDetailsecond());
        viewholder.detailthird.setText(list.get(i).getDetailthird());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView detailtitle,detailfirst,detailsecond,detailthird;
        ImageView detailtitlefirstimage,detailtitlesecondimage,detailtitlethirdimage;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            detailtitlefirstimage=(ImageView)itemView.findViewById(R.id.detailfirstimage);
            detailtitlesecondimage=(ImageView)itemView.findViewById(R.id.detailsecondimage);
            detailtitlethirdimage=(ImageView)itemView.findViewById(R.id.detailthirdimage);
            detailtitle=(TextView)itemView.findViewById(R.id.detailtitle);
            detailfirst=(TextView)itemView.findViewById(R.id.detailfirst);
            detailsecond=(TextView)itemView.findViewById(R.id.detailsecond);
            detailthird=(TextView)itemView.findViewById(R.id.detailthird);
        }
    }
}


