package io.simi.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chimis@foxmail.com (CHIMIS 葛相池)
 */

public abstract class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<?> data = new ArrayList<>();
    private int layoutResId;
    private Context context;

    private RecyclerLiteView.OnItemClickListener onItemClickListener;
    private RecyclerLiteView.OnItemLongClickListener onItemLongClickListener;

    protected RecyclerAdapter(Context context, List<?> data, int layoutResId) {
        this.context = context;
        this.data = data;
        this.layoutResId = layoutResId;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder holder = new RecyclerViewHolder(LayoutInflater.from(context).inflate(layoutResId, null));
        holder.setOnItemClickListener(onItemClickListener);
        holder.setOnItemLongClickListener(onItemLongClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        onBindView(holder, position);
    }

    public abstract void onBindView(RecyclerViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setOnItemClickListener(RecyclerLiteView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(RecyclerLiteView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
