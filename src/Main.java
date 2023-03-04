import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final JFrame frame = new JFrame();
    public static Point justClicked = null;
    private static Image graphics;
    private static double theta;

    private static Point mouse = new Point(0,0);

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

        Cube3D[][][] cubes = new Cube3D[10][10][10];
        Sphere3D s = new Sphere3D(250);

        Cube3D cube = new Cube3D(new Point3D(0, 0, 0), 500);
        //Cube3D cube2 = new Cube3D(new Point3D(500, 0, 0), 500);

        int size = 50;

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    int random = ThreadLocalRandom.current().nextInt(9);
                    if(random < 1) {
                        cubes[i][j][k] = new Cube3D(new Point3D((i * size), (k * size), (j * size)), size);
                    }
                    else {
                        cubes[i][j][k] = new Cube3D(new Point3D((i * size), (k * size), (j * size)), 0);
                    }
                }
            }
        }

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    for(Cube3D[][] c : cubes) {
                        for(Cube3D[] cube2 : c) {
                            for(Cube3D cube: cube2) {
                                cube.eulerRotation(0, 1, 0);
                            }
                        }
                    }
                    s.eulerRotation(0, 1, 0);
                    cube.eulerRotation(0, 1, 0);

                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    for(Cube3D[][] c : cubes) {
                        for(Cube3D[] cube2 : c) {
                            for(Cube3D cube: cube2) {
                                cube.eulerRotation(0, -1, 0);
                            }
                        }
                    }
                    s.eulerRotation(0, -1, 0);
                    cube.eulerRotation(0, -1, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    for(Cube3D[][] c : cubes) {
                        for(Cube3D[] cube2 : c) {
                            for(Cube3D cube: cube2) {
                                cube.eulerRotation(0, 0, 1);
                            }
                        }
                    }
                    s.eulerRotation(0, 0, 1);
                    cube.eulerRotation(0, 0, 1);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    for(Cube3D[][] c : cubes) {
                        for(Cube3D[] cube2 : c) {
                            for(Cube3D cube: cube2) {
                                cube.eulerRotation(0, 0, -1);
                            }
                        }
                    }
                    s.eulerRotation(0, 0, -1);
                    cube.eulerRotation(0, 0, -1);
                }

                if (e.getKeyCode() == KeyEvent.VK_E) {
                    for(Cube3D[][] c : cubes) {
                        for(Cube3D[] cube2 : c) {
                            for(Cube3D cube: cube2) {
                                cube.eulerRotation(1, 0, 0);
                            }
                        }
                    }
                    s.eulerRotation(1, 0, 0);
                    cube.eulerRotation(1, 0, 0);
                }
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    for(Cube3D[][] c : cubes) {
                        for(Cube3D[] cube2 : c) {
                            for(Cube3D cube: cube2) {
                                cube.eulerRotation(-1, 0, 0);
                            }
                        }
                    }
                    s.eulerRotation(-1, 0, 0);
                    cube.eulerRotation(-1, 0, 0);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        while (true) {
            graphics.redraw();
//            for(Cube3D[][] c : cubes) {
//                for(Cube3D[] cube2 : c) {
//                    for(Cube3D cube: cube2) {
//                        graphics.drawColoredCube(cube);
//                    }
//                }
//            }
            graphics.drawSphere(s);
            //s.eulerRotation(-1, -1, -1);

            //graphics.getCamera().location.z -= 10;
            //cube.rotateY(1);
            //graphics.drawCubeArray();
            graphics.drawColoredCube(cube);
            //graphics.drawColoredCube(cube2);
            graphics.updateUI();
            Thread.sleep(3, 0);
        }

//        Vector3D vector = new Vector3D(45,45,45, 10);
//        Vector3D vector2 = new Vector3D(10,10,10);
//        System.out.println(vector.location);
//        System.out.println(vector2.location);
//        System.out.println(vector2.getYaw());

//        for(int i = 0; i < 360; i++) {
//            graphics.drawPoint2D(new Point2D(50, 50).rotate(i));
//        }
        //graphics.updateUI();


    }
}