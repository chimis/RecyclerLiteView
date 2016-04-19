package io.simi.rv;

/**
 * @author gexc@longkeysoft.cn (ND0113 葛相池)
 * @date 2016/4/18.
 */

public class ViewType {

    private Type type;
    private int position;
    private int layoutResId;

    public ViewType(Type type, int position, int layoutResId) {
        this.type = type;
        this.position = position;
        this.layoutResId = layoutResId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLayoutResId() {
        return layoutResId;
    }

    public void setLayoutResId(int layoutResId) {
        this.layoutResId = layoutResId;
    }

    public enum Type {
        DEFAULT, SINGLE, LOOP;
    }
}
