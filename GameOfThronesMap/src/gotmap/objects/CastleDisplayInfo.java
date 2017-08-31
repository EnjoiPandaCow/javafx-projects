package gotmap.objects;

import javafx.geometry.Insets;

public class CastleDisplayInfo {
        public int columnIndex;
        public int rowIndex;
        public double insetTop;
        public double insetLeft;
        public double insetRight;
        public double insetBottom;

        public CastleDisplayInfo(int columnIndex, int rowIndex, double insetTop, double insetLeft, double insetRight, double insetBottom) {
            this.columnIndex = columnIndex;
            this.rowIndex = rowIndex;
            this.insetTop = insetTop;
            this.insetLeft = insetLeft;
            this.insetRight = insetRight;
            this.insetBottom = insetBottom;
        }

        public Insets toInsets() {
            return new Insets(insetTop, insetRight, insetBottom, insetLeft);
        }
}
