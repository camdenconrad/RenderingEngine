import java.util.ArrayList;

public class Sphere3D extends Object3D {

    Point3D center;

    int size;

    public int horizontalLines = 100;
    public int verticalLines = 100;

    public ArrayList<Point3D> getPoints() {
        return points;
    }

    ArrayList<Point3D> points = new ArrayList<Point3D>();
    ArrayList<Point3D> hozLines = new ArrayList<>();
    ArrayList<Point3D> vertLines = new ArrayList<>();


    public Sphere3D(int size) {
        this.center = new Point3D(0,0,0);
        this.size = size;

        generatePoints();
    }

    private void generatePoints() {

        for (int m = 0; m < horizontalLines; m++)
        {
            for (int n = 0; n < verticalLines; n++)
            {
                double x = Math.sin(Math.PI * m/horizontalLines) * Math.cos(2 * Math.PI * n/verticalLines);
                double y = Math.sin(Math.PI * m/horizontalLines) * Math.sin(2 * Math.PI * n/verticalLines);
                double z = Math.cos(Math.PI * m / horizontalLines);
                points.add(new Point3D(x * size, y * size, z * size));
            }
        }
    }

    public void eulerRotation(double roll, double pitch, double yaw) {
        for(Point3D p : points) {
            p.eulerRotation(roll, pitch, yaw);
        }
    }
}
