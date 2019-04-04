package com.housekeeper178.housekeeper_178.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.housekeeper178.housekeeper_178.R;
import com.housekeeper178.housekeeper_178.activity.activity.FeileiGoodshowActivity;


import java.util.List;

public class fenleitype extends RecyclerView.Adapter<fenleitype.ViewHolder> {
    private Context context;
    private List<String> typename;
    private List<Integer> id;

    public fenleitype(Context context, List<String> typename, List<Integer> id) {
        this.typename = typename;
        this.context = context;
        this.id = id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_goodstype, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvname.setText(typename.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FeileiGoodshowActivity.class);
                int doid =id.get(position);
                String doname = typename.get(position);
                intent.putExtra("id",doid);
                intent.putExtra("typename",doname);
                context.startActivity(intent);

            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvname;

        public ViewHolder(View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tv_item_type);

        }
    }

    @Override
    public int getItemCount() {
        return typename.size();
    }
}
