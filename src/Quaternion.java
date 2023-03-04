import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Quaternion {

    double w, x, y, z;

    public Quaternion(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Quaternion toQuaternion(double roll, double pitch, double yaw, double x, double y, double z) // roll (x), pitch (Y), yaw (z)
    {
        // Abbreviations for the various angular functions

        double cr = cos(roll * 0.5);
        double sr = sin(roll * 0.5);
        double cp = cos(pitch * 0.5);
        double sp = sin(pitch * 0.5);
        double cy = cos(yaw * 0.5);
        double sy = sin(yaw * 0.5);

        Quaternion q = new Quaternion(0, x, y, z);
        q.w = cr * cp * cy + sr * sp * sy;
        q.x = sr * cp * cy - cr * sp * sy;
        q.y = cr * sp * cy + sr * cp * sy;
        q.z = cr * cp * sy - sr * sp * cy;

        System.out.println("(" + x + " " + y + " " + z + ")");

        return q;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
