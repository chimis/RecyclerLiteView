package io.simi.rv;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static io.simi.rv.ViewType.Type.DEFAULT;

/**
 * @author gexc@longkeysoft.cn (ND0113 葛相池)
 * @date 2016/4/18.
 */

public class ViewTypeArray {

    private ViewType defaultViewType;
    private SparseArray<ViewType> singleViewType = new SparseArray<>();
    private SparseArray<ViewType> loopViewType = new SparseArray<>();

    public void add(ViewType.Type type, int position, int layoutResId) {
        switch (type) {
            case DEFAULT:
                defaultViewType = new ViewType(type, position, layoutResId);
                break;
            case SINGLE:
                singleViewType.put(position, new ViewType(type, position, layoutResId));
                break;
            case LOOP:
                loopViewType.put(position, new ViewType(type, position, layoutResId));
                break;
        }
    }

    public ViewType getViewType(int position) {
        if (singleViewType.indexOfKey(position) > -1) {
            return singleViewType.get(position);
        }
        int size = loopViewType.size();
        if (size > 0) {
            int key = 0;
            for (int i = 0; i < size; i++) {
                key = loopViewType.keyAt(i);
                if (position % key == 0) {
                    return loopViewType.get(key);
                }
            }
        }
        return defaultViewType;
    }
}
