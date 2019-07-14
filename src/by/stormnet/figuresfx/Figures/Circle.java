package by.stormnet.figuresfx.Figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Circle extends Figure {
    private double radius;

    public Circle(double cx, double cy, double lineWidth, Color color, double radius) {
        this(cx, cy, lineWidth, color);
        this.radius = radius < 20 ? 20:radius;
    }

    private Circle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURES_TYPE_CIRCLE, cx, cy, lineWidth, color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append("radius=").append(radius);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.beginPath();
        gc.strokeOval(cx- radius, cy - radius, radius * 2, radius * 2);

    }

}
