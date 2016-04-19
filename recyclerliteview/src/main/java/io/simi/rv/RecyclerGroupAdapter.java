package io.simi.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chimis@foxmail.com (CHIMIS 葛相池)
 * @date 2016/4/18.
 */

public abstract class RecyclerGroupAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<?> data = new ArrayList<>();
    private SparseArray<Integer> layoutResIds = new SparseArray<>();
    private ViewTypeArray viewTypeArray;
    private Context context;

    private RecyclerLiteView.OnItemClickListener onItemClickListener;
    private RecyclerLiteView.OnItemLongClickListener onItemLongClickListener;

    protected RecyclerGroupAdapter(Context context, List<?> data, ViewTypeArray viewTypeArray) {
        this.context = context;
        this.viewTypeArray = viewTypeArray;
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder holder = new RecyclerViewHolder(LayoutInflater.from(context).inflate(layoutResIds.get(viewType), null));
        holder.setOnItemClickListener(onItemClickListener);
        holder.setOnItemLongClickListener(onItemLongClickListener);
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        ViewType viewType = viewTypeArray.getViewType(position);
        int viewTypeCode = 0;
        switch (viewType.getType()) {
            case SINGLE:
                viewTypeCode = 10000 + viewType.getPosition();
                break;
            case LOOP:
                viewTypeCode = 20000 + viewType.getPosition();
                break;
        }
        layoutResIds.put(viewTypeCode, viewType.getLayoutResId());
        return viewTypeCode;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        onBindView(holder, position, viewTypeArray.getViewType(position).getLayoutResId());
    }

    public abstract void onBindView(RecyclerViewHolder holder, int position, int layoutResId);

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
