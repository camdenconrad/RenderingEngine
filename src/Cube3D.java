import java.util.ArrayList;

public class Cube3D extends Object3D {

    ArrayList<Point3D> points = new ArrayList<>();
    // front
    Point3D fbl;
    Point3D fbr;
    Point3D ftl;
    Point3D ftr;

    // back
    Point3D bbl;
    Point3D bbr;
    Point3D btl;
    Point3D btr;
    Point3D center;

    int size = 0;

    public Cube3D(Point3D center, int size) {
        this.center = center;
        this.size = size;

        calculateVertices();
        points.add(fbl);
        points.add(fbr);
        points.add(ftl);
        points.add(ftr);

        points.add(bbl);
        points.add(bbr);
        points.add(btl);
        points.add(btr);
    }

    public Cube3D(double x, double y, double z, int size) {
        this.center = new Point3D(x, y, z);
        this.size = size;

        calculateVertices();
    }

    private void calculateVertices() {
        double cx = center.x;
        double cy = center.y;
        double cz = center.z;
        double x = size / 2.;
        double y = size / 2.;
        double z = size / 2.;

        // front, bottom, left
        fbl = new Point3D(cx - x, cy - y, cz - z);
        fbr = new Point3D(cx + x, cy - y, cz - z);

        ftl = new Point3D(cx - x, cy + y, cz - z);
        ftr = new Point3D(cx + x, cy + y, cz - z);

        // back
        bbl = new Point3D(cx - x, cy - y, cz + z);
        bbr = new Point3D(cx + x, cy - y, cz + z);

        btl = new Point3D(cx - x, cy + y, cz + z);
        btr = new Point3D(cx + x, cy + y, cz + z);
    }

    public void eulerRotation(double roll, double pitch, double yaw) {
        fbl.eulerRotation(roll, pitch, yaw);
        fbr.eulerRotation(roll, pitch, yaw);
        ftl.eulerRotation(roll, pitch, yaw);
        ftr.eulerRotation(roll, pitch, yaw);

        bbl.eulerRotation(roll, pitch, yaw);
        bbr.eulerRotation(roll, pitch, yaw);
        btl.eulerRotation(roll, pitch, yaw);
        btr.eulerRotation(roll, pitch, yaw);
    }

    public void quaternionRotation(double roll, double pitch, double yaw) {
        fbl.quaternionRotation(roll, pitch, yaw);
        fbr.quaternionRotation(roll, pitch, yaw);
        ftl.quaternionRotation(roll, pitch, yaw);
        ftr.quaternionRotation(roll, pitch, yaw);

        bbl.quaternionRotation(roll, pitch, yaw);
        bbr.quaternionRotation(roll, pitch, yaw);
        btl.quaternionRotation(roll, pitch, yaw);
        btr.quaternionRotation(roll, pitch, yaw);
    }
}
