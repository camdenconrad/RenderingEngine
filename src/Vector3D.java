public class Vector3D {

    // angles
    double roll = 0;
    double pitch = 0;
    double yaw = 0;
    double magnitude;



    Point3D location;

    public Vector3D(double roll, double pitch, double yaw, double magnitude) {
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.magnitude = magnitude;
        location = getLocation();
    }

    public Vector3D(double x, double y, double z) {
        this.magnitude = Math.sqrt(x * x + y * y + z * z);

        this.roll = 0;
        this.pitch = Math.acos(x / Math.sqrt(x * x + y * y) * (y < 0 ? -1 : 1));
        yaw = Math.acos(z / magnitude);

        location = getLocation();
    }

    private Point3D getLocation() {

        /*
        alpha is the horizontal angle from the X axis
        polar is the vertical angle from the Z axis
         */

        double x = Math.cos(pitch) * Math.sin(yaw);
        double y = Math.cos(yaw);
        double z = Math.sin(pitch) * Math.sin(yaw);

        return new Point3D(x, y, z);
    }

    public double getRoll() {
        return roll;
    }

    public void setRoll(double roll) {
        this.roll = roll;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public void eulerRotation(double roll, double pitch, double yaw) {
        double y = location.y;
        double x = location.x;
        double z = location.z;

        y = (y * Math.cos(Math.toRadians(roll))) - (x * Math.sin(Math.toRadians(roll)));
        x = (x * Math.cos(Math.toRadians(roll))) + (y * Math.sin(Math.toRadians(roll)));

        z = (z * Math.cos(Math.toRadians(pitch))) - (y * Math.sin(Math.toRadians(pitch)));
        y = (y * Math.cos(Math.toRadians(pitch))) + (z * Math.sin(Math.toRadians(pitch)));

        x = (x * Math.cos(Math.toRadians(yaw))) - (z * Math.sin(Math.toRadians(yaw)));
        z = (z * Math.cos(Math.toRadians(yaw))) + (x * Math.sin(Math.toRadians(yaw)));
    }

    public Point2D getPoint2D() {

        return new Point2D(location.x / (1 + (location.z * 0.0001)), location.y / (1 + (location.z * 0.0001)));

    }
}
