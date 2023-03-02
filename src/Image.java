import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Image extends JPanel {
    private final int width;
    private final int height;
    private double theta = 0;

    public Camera getCamera() {
        return camera;
    }

    private final Camera camera;

    public BufferedImage getImg() {
        return img;
    }

    private final BufferedImage img;
    private final ArrayList<Point> toDraw = new ArrayList<Point>();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //protected ArrayList<Node> nodes = new ArrayList<>();

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        camera = new Camera(0,0,0);


        img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                img.setRGB(x, y, Color.BLACK.getRGB());
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.drawImage(img, 0, 0, this);
        g2d.dispose();
    }

    public void drawPx(int x, int y) {
        try {
            img.setRGB(x + screenSize.width / 2, y + screenSize.height / 2, Color.ORANGE.getRGB());
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void drawPx(int x, int y, Color c) {
        try {
            img.setRGB(x + screenSize.width / 2, y + screenSize.height / 2, c.getRGB());
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

//    public void drawPx(Point p) {
//        img.setRGB(p.x, p.y, Color.ORANGE.getRGB());
//    }


    public void redraw() {

//        for (int x = 0; x < img.getWidth(); x++) {
//            for (int y = 0; y < img.getHeight(); y++) {
//                img.setRGB(x, y, Color.BLACK.getRGB());
//            }
//        }
        Graphics2D local = img.createGraphics();
        local.setColor(Color.BLACK);
        local.fillRect(0,0, screenSize.width, screenSize.height);
    }

    public void update() {
        redraw();
        this.updateUI();
    }

    public void drawLine(Point2D p1, Point2D p2) {

        Graphics2D local = img.createGraphics();
        int random = ThreadLocalRandom.current().nextInt(9);
       // if(random < 5) {
            local.setColor(new Color(125,252,254));
      //  } else {
            //local.setColor(new Color(223, 116, 12));
      //  }

//        p1.x += camera.location.x;
//        p2.x += camera.location.x;
//
//        p1.y += camera.location.y;
//        p2.y += camera.location.y;

        local.drawLine((int) p1.getX() + screenSize.width / 2, -1 * (int) p1.getY() + screenSize.height / 2, (int) p2.getX() + screenSize.width / 2, -1 * (int) p2.getY() + screenSize.height / 2);
    }

    public void reset() {

        toDraw.clear();
    }

    public void drawCube(Cube3D cube) {
        cube.eulerRotation(1, 'x');
        //cube.eulerRotation(1, 'z');
        cube.eulerRotation(1, 'y');

        // front bottom
        drawLine(cube.fbl.getPoint2D(), cube.fbr.getPoint2D());
        // front top
        drawLine(cube.ftl.getPoint2D(), cube.ftr.getPoint2D());
        // front left
        drawLine(cube.fbl.getPoint2D(), cube.ftl.getPoint2D());
        // front right
        drawLine(cube.fbr.getPoint2D(), cube.ftr.getPoint2D());

        // back bottom
        drawLine(cube.bbl.getPoint2D(), cube.bbr.getPoint2D());
        // back top
        drawLine(cube.btl.getPoint2D(), cube.btr.getPoint2D());
        // back left
        drawLine(cube.bbl.getPoint2D(), cube.btl.getPoint2D());
        // back right
        drawLine(cube.bbr.getPoint2D(), cube.btr.getPoint2D());

        // left bottom side
        drawLine(cube.fbl.getPoint2D(), cube.bbl.getPoint2D());
        // right bottom side
        drawLine(cube.fbr.getPoint2D(), cube.bbr.getPoint2D());
        // left top side
        drawLine(cube.ftl.getPoint2D(), cube.btl.getPoint2D());
        // right top side
        drawLine(cube.ftr.getPoint2D(), cube.btr.getPoint2D());

        //draw planes


        for(Point3D point : cube.points) {
            drawPoint2D(point.getPoint2D());
        }


    }

    public void drawPoint2D(Point2D p) {
        try {
            img.setRGB((int) (p.x + screenSize.width / 2), (int) (p.y + screenSize.height / 2), Color.RED.getRGB());
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void drawCubeArray() {
        Cube3D[][][] cubes = new Cube3D[30][30][3];
        for(int i = -15; i < 15; i++) {
            for(int j = -15; j < 15; j++) {
                for(int k = 0; k < 3; k++) {
                    cubes[i + 15][j + 15][k] = new Cube3D(new Point3D(i * 10 + camera.location.x, j * 10 + camera.location.y, 0 + (k * 100) + camera.location.z), 100);
                }
            }
        }

        for(int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                for(int k = 0; k < 3; k++) {
                    drawCube(cubes[i][j][k]);
                }
            }
        }
        theta++;
    }
}