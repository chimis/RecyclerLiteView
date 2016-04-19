package io.simi.rv;

import android.util.SparseArray;
import android.view.View;

/**
 * @author gexc@longkeysoft.cn (ND0113 葛相池)
 * @date 2016/4/18.
 */

public class WidgetArray<V extends View> extends SparseArray<V> {

    public WidgetArray() {
        super();
    }

    public WidgetArray(int initialCapacity) {
        super(initialCapacity);
    }
}
