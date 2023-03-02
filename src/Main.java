import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Main {

    private static final JFrame frame = new JFrame();
    public static Point justClicked = null;
    private static Image graphics;
    private static double theta;

    public static void main(String[] args) throws AWTException, InterruptedException {

        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Rendering Engine");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setResizable(false);

        graphics = new Image(screenSize.width, screenSize.height);
        frame.add(graphics);

        Cube3D cube = new Cube3D(new Point3D(0, 0, 0), 500);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    graphics.redraw();
                    graphics.getCamera().moveUp();
                    //graphics.drawCube(cube);
                    graphics.drawCubeArray();
                    graphics.updateUI();
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    graphics.redraw();
                    graphics.getCamera().moveDown();
                    //graphics.drawCube(cube);
                    graphics.drawCubeArray();
                    graphics.updateUI();
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    graphics.redraw();
                    graphics.getCamera().moveRight();
                    //graphics.drawCube(cube);
                    graphics.drawCubeArray();
                    graphics.updateUI();
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    graphics.redraw();
                    graphics.getCamera().moveLeft();
                    //graphics.drawCube(cube);
                    graphics.drawCubeArray();
                    graphics.updateUI();
                }

                if(e.getKeyCode() == KeyEvent.VK_R) {
                    graphics.redraw();
                    //cube.rotate(45);
                    graphics.drawCube(cube);
                    graphics.updateUI();
                }

                if(e.getKeyCode() == KeyEvent.VK_X) {
                    graphics.redraw();
                    graphics.getCamera().location.z += 10;
                    //cube.rotate(45);
                    graphics.drawCubeArray();
                    graphics.updateUI();
                }

                if(e.getKeyCode() == KeyEvent.VK_Z) {
                    graphics.redraw();
                    graphics.getCamera().location.z -= 10;
                    //cube.rotate(45);
                    graphics.drawCubeArray();
                    graphics.updateUI();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        while(true) {
            graphics.redraw();

            //graphics.getCamera().location.z -= 10;
            //cube.rotateY(1);
            //graphics.drawCubeArray();
            graphics.drawColoredCube(cube);
            graphics.updateUI();
            Thread.sleep(3,0);

//            theta++;
//            if(theta == 360) {
//                theta = 0;
//            }
        }


//        for(int i = 0; i < 360; i++) {
//            graphics.drawPoint2D(new Point2D(50, 50).rotate(i));
//        }
        //graphics.updateUI();





    }
}