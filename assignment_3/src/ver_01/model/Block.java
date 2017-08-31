package ver_01.model;

import java.io.Serializable;

public class Block implements Serializable {

    private double size;
    private int index;
    private boolean highlighted;

    public Block(double size, int index) {

        this.size = size;
        this.index = index;
        highlighted = false;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(double size) {
        this.index = index;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public String toString() {
        return "" + index;
    }
}
