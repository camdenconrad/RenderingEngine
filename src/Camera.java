public class Camera {
    public Camera(double x, double y, double z) {
        this.location = new Point3D(x, y, z);
    }

    public Point3D getLocation() {
        return location;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    Point3D location;

    public void moveUp() {
        this.location.y += 10;
    }
    public void moveDown() {
        this.location.y -= 10;
    }

    public void moveRight() {
        this.location.x += 10;
    }
    public void moveLeft() {
        this.location.x -= 10;
    }
}
