package com.example.dbdog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    public interface OnClickItem{
        void onClickItem(ItemView itemView, int position);
    }

    private OnClickItem callBack;
    private List<ItemView> data;



    public void setOnItemClickListener(OnClickItem callBack) {
        this.callBack = callBack;
    }

    public ListAdapter(List<ItemView> data) {
        this.data = data;
    }

    public void setData(List<ItemView> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog_new, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.weightFirst.setText(String.valueOf(data.get(position).weight));
        holder.highFirst.setText(String.valueOf(data.get(position).high));
        holder.colour1.setText(String.valueOf(data.get(position).colour1));
        holder.colour2.setText(String.valueOf(data.get(position).colour2));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView weightFirst;
        private TextView highFirst;
        private TextView colour1;
        private TextView colour2;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            colour1 = itemView.findViewById(R.id.colour_mail);
            colour2 = itemView.findViewById(R.id.colour_femail);
            highFirst = itemView.findViewById(R.id.high_text_first);
            weightFirst= itemView.findViewById(R.id.weight_text_second);





            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callBack != null)
                        callBack.onClickItem(, getAdapterPosition());
                }
            });*/
        }
    }
}
