package com.example.prototypeieca.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototypeieca.Models.ListElementMain;
import com.example.prototypeieca.R;

import java.util.List;

public class ListAdapterMain extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ListElementMain> myData;
    private LayoutInflater myInflater;
    private Context context;
    public ListAdapterMain(List<ListElementMain> itemList, Context context)
    {
        this.myInflater=LayoutInflater.from(context);
        this.context=context;
        this.myData=itemList;
    }
    @Override
    public int getItemCount()
    {
        return myData.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view=myInflater.inflate(R.layout.item_recycler_main_layout,null);
        return new ListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder  holder, final int position){
        holder.bindData(myData.get(position));
    }

    public void setItems(List<ListElementMain> items){
        myData=items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo,subTitulo;
        ViewHolder(View itemView){
            super(itemView);
            titulo=itemView.findViewById(R.id.TextTitleCard);
            subTitulo=itemView.findViewById(R.id.TextSubTitleCard);
        }

        void bindData(final ListElementMain item){
            titulo.setText(item.getTitulo());
            subTitulo.setText(item.getSubtitulo());
        }
    }
}
