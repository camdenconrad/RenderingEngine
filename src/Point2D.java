public class Point2D {
    double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean equals(Point2D p) {
        return this.x == p.x && this.y == p.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Point2D rotate(double theta) {
        x = (x * Math.cos(Math.toRadians(theta))) - (y * Math.sin(Math.toRadians(theta)));
        y = (y * Math.cos(Math.toRadians(theta))) + (x * Math.sin(Math.toRadians(theta)));

        return this;
    }
}
