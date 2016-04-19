package io.simi.rv;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * @author chimis@foxmail.com (CHIMIS 葛相池)
 * @date 2016/4/18.
 */

public class RecyclerLiteView extends RecyclerView {

    private boolean isRecyclerAdapter = false;
    private boolean isLoading = false;
    private int minNumber = 3;

    private OnLackDataListener onLackDataListener;
    private OnScrollListener onScrollListener;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public RecyclerLiteView(Context context) {
        super(context);
        init();
    }

    public RecyclerLiteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RecyclerLiteView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext()));
        super.addOnScrollListener(new OnScrollDefaultListener());
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof RecyclerAdapter) {
            isRecyclerAdapter = true;
            RecyclerAdapter recyclerAdapter = (RecyclerAdapter) adapter;
            if (onItemClickListener != null) {
                recyclerAdapter.setOnItemClickListener(onItemClickListener);
            }
            if (onItemLongClickListener != null) {
                recyclerAdapter.setOnItemLongClickListener(onItemLongClickListener);
            }
        } else if (adapter instanceof RecyclerGroupAdapter) {
            isRecyclerAdapter = true;
            RecyclerGroupAdapter recyclerAdapter = (RecyclerGroupAdapter) adapter;
            if (onItemClickListener != null) {
                recyclerAdapter.setOnItemClickListener(onItemClickListener);
            }
            if (onItemLongClickListener != null) {
                recyclerAdapter.setOnItemLongClickListener(onItemLongClickListener);
            }
        } else {
            Log.e("Error!", "This RecyclerLiteView not use a RecyclerAdapter!");
        }
    }

    public void setOnLackDataListener(OnLackDataListener onLackDataListener) {
        this.onLackDataListener = onLackDataListener;
    }

    @Override
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    @Override
    public void addOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        if (isRecyclerAdapter) {
            ((RecyclerAdapter) getAdapter()).setOnItemClickListener(onItemClickListener);
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
        if (isRecyclerAdapter) {
            ((RecyclerAdapter) getAdapter()).setOnItemLongClickListener(onItemLongClickListener);
        }
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    class OnScrollDefaultListener extends OnScrollListener {

        @Override
        public void onScrollStateChanged(android.support.v7.widget.RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(recyclerView, newState);
            }
        }

        @Override
        public void onScrolled(android.support.v7.widget.RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (onLackDataListener != null) {
                LayoutManager manager = getLayoutManager();
                if (manager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) manager;
                    if (linearLayoutManager.findLastVisibleItemPosition() >= linearLayoutManager.getItemCount() - minNumber && dy > 0 && !isLoading) {
                        onLackDataListener.onLackData();
                    }
                }
            }
        }
    }

    public interface OnLackDataListener {
        void onLackData();
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerViewHolder holder, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(RecyclerViewHolder holder, int position);
    }
}
