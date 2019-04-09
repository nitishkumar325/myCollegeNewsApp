package e.nitishkumar.minor_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class noticadapter extends RecyclerView.Adapter<noticadapter.viewholder> {
    List<notice> list;
    Context context;

    public noticadapter(List<notice> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.notice_layout, null);
        // progressBar=(ProgressBar)view.findViewById(R.id.mypro);
        //progressBar.setVisibility(View.VISIBLE);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
        viewholder.date.setText(list.get(i).getDate());
        viewholder.notice.setText(list.get(i).getNotice());
        viewholder.signature.setText(list.get(i).getSignature());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView signature, date, notice;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            notice = (TextView) itemView.findViewById(R.id.notice);
            signature = (TextView) itemView.findViewById(R.id.sign);
        }
    }
}

