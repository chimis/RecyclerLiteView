package io.simi.rv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
/**
 * @author chimis@foxmail.com (CHIMIS 葛相池)
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private RecyclerViewHolder viewHolder;
    private ParamsArray paramsArray;
    private WidgetArray<View> widgets = new WidgetArray<>();
    private ViewGroup itemView;

    public RecyclerViewHolder(final View itemView) {
        super(itemView);
        this.viewHolder = this;
        this.itemView = (ViewGroup) itemView;
    }

    public void setOnItemClickListener(RecyclerLiteView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            return;
        }
        onItemClickListener.onItemClick(viewHolder, getAdapterPosition());
    }

    public void setOnItemLongClickListener(RecyclerLiteView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            return;
        }
        onItemLongClickListener.onItemLongClick(viewHolder, getAdapterPosition());
    }

    public ViewGroup getViewGroup() {
        return itemView;
    }

    public <T extends View> T getById(int id) {
        View view = widgets.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            assert view != null;
            widgets.put(id, view);
        }
        return (T) view;
    }

    public <P extends Object> P getParams(int key) {
        if (paramsArray.indexOfKey(key) > -1) {
            return (P) paramsArray.get(key);
        }
        return null;
    }

    public void putParamsNotify(int key, Object value) {
        putParams(key, value);
    }

    public void putParams(int key, Object value) {
        if (paramsArray == null) {
            paramsArray = new ParamsArray();
        }
        paramsArray.put(key, value);
    }
}