public class Point3D {
    double x, y, z;


    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point2D getPoint2D() {

        return new Point2D(x / (1 + (z * 0.0001)), y / (1 + (z * 0.0001)));

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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public void eulerRotation(double theta, char axis) {
        if(axis == 'z') {
            y = (y * Math.cos(Math.toRadians(theta))) - (x * Math.sin(Math.toRadians(theta)));
            x = (x * Math.cos(Math.toRadians(theta))) + (y * Math.sin(Math.toRadians(theta)));
            return;
        }
        if(axis == 'x') {
            z = (z * Math.cos(Math.toRadians(theta))) - (y * Math.sin(Math.toRadians(theta)));
            y = (y * Math.cos(Math.toRadians(theta))) + (z * Math.sin(Math.toRadians(theta)));
            return;
        }
        if(axis == 'y') {
            x = (x * Math.cos(Math.toRadians(theta))) - (z * Math.sin(Math.toRadians(theta)));
            z = (z * Math.cos(Math.toRadians(theta))) + (x * Math.sin(Math.toRadians(theta)));
            return;
        }
    }
}
