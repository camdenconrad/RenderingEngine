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

    public void eulerRotation(double roll, double pitch, double yaw) {

        y = (y * Math.cos(Math.toRadians(roll))) - (x * Math.sin(Math.toRadians(roll)));
        x = (x * Math.cos(Math.toRadians(roll))) + (y * Math.sin(Math.toRadians(roll)));

        z = (z * Math.cos(Math.toRadians(pitch))) - (y * Math.sin(Math.toRadians(pitch)));
        y = (y * Math.cos(Math.toRadians(pitch))) + (z * Math.sin(Math.toRadians(pitch)));

        x = (x * Math.cos(Math.toRadians(yaw))) - (z * Math.sin(Math.toRadians(yaw)));
        z = (z * Math.cos(Math.toRadians(yaw))) + (x * Math.sin(Math.toRadians(yaw)));
    }

    public void quaternionRotation(double roll, double pitch, double yaw) {

        Quaternion quaternion = new Quaternion(0, x, y, z);
        quaternion.toQuaternion(roll, pitch, yaw, x, y, z);

        x = quaternion.getY();
        y = quaternion.getY();
        z = quaternion.getZ();

       // y = (y * Math.cos(Math.toRadians(roll))) - (x * Math.sin(Math.toRadians(roll)));
     //   x = (x * Math.cos(Math.toRadians(roll))) + (y * Math.sin(Math.toRadians(roll)));

    }
}
