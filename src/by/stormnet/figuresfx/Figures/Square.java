package by.stormnet.figuresfx.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Square extends Figure {
    public double width;
    public double heigth;

    public Square( double cx, double cy, double lineWidth, Color color) {
        super(Figure.FIGURES_TYPE_SQUARE, cx, cy, lineWidth, color);
    }

    public Square( double cx, double cy, double lineWidth, Color color, double width, double heigth) {
        this( cx, cy, lineWidth, color);
        this.width = width<20?20:width;
        this.heigth = heigth<20?20:heigth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.width, width) == 0 &&
                Double.compare(square.heigth, heigth) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, heigth);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Square{");
        sb.append("width=").append(width);
        sb.append(", height=").append(heigth);
        sb.append(", cy=").append(cy);
        sb.append(", cx=").append(cx);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.beginPath();
        gc.strokeRect(cx-width,cy - heigth,width,heigth);
    }
}

