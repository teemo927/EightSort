package com.teemo.sorttest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teemo.sorttest.R;

import java.util.List;

/**
 * Created by Asus on 2017/4/1.
 */

public class ListSortAdapter extends RecyclerView.Adapter {
    private List<String> sortData;
    private OnItemClickListener itemClickListener;

    public ListSortAdapter(List<String> sortData) {
        this.sortData = sortData;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_sort, parent, false);
        return new SortHolder(root);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SortHolder) {
            ((SortHolder) holder).name.setText(sortData.get(position));
        }
        if (itemClickListener == null) {
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(v,holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return sortData == null ? 0 : sortData.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    private class SortHolder extends RecyclerView.ViewHolder {

        TextView name;

        SortHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tv);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
