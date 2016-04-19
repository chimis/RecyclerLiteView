package io.simi.rv;

import android.util.SparseArray;
import android.view.View;

/**
 * @author chimis@foxmail.com (CHIMIS 葛相池)
 */

public class WidgetArray<V extends View> extends SparseArray<V> {

    public WidgetArray() {
        super();
    }

    public WidgetArray(int initialCapacity) {
        super(initialCapacity);
    }
}
