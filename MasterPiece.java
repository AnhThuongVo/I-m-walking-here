// utility stuff
import java.util.ArrayList;
import java.util.Random;

// graphics stuff
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MasterPiece extends JPanel {
    private int canvasWidth;
    private int canvasHeight;

    private ArrayList<GraphicsObject> objects;

    /* Constructor for a window/canvas of a specified size
     *
     * @param width  The width of the canvas.
     * @param height The height of the canvas.
     */
    public MasterPiece(int width, int height) {
    this.canvasWidth = width;
    this.canvasHeight = height;
    this.objects = new ArrayList<GraphicsObject>();
    setDoubleBuffered(true);
    }

    /* Creates the window and shows it
     */
    public void showCanvas() {
    JFrame frame = new JFrame("I'm walking here");
    frame.getContentPane().add(this, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension dim = new Dimension(this.canvasWidth, this.canvasHeight);
    frame.getContentPane().setPreferredSize(dim);
    frame.pack();
    frame.setVisible(true);
    }

    /* Convenience function to paint all objects.
     */
    public void paint() {
    this.paint(this.getGraphics());
    }

    /* Paint/Draw the canvas.
     *
     * This function overrides the paint function in JPanel. This function is
     * automatically called when the panel is made visible.
     *
     * @param g The Graphics for the JPanel
     */
    @Override
    public void paint(Graphics g) {
    // use a for-each loop to draw each object
    for (GraphicsObject obj : this.objects) {
        obj.draw(g);
    }

    }
    
    public void update(int frame) {
        for (GraphicsObject obj : this.objects) {
            obj.update(frame);
        }
    }

    /* Add an object to be draw.
     *
     * @param obj The object to draw.
     */
    public void addObject(GraphicsObject obj) {
    this.objects.add(obj);
    }
    public void removeObject(){
        this.objects.remove(2);
    }  
    public static void main(String[] args) throws InterruptedException {
    int sizeX= 1800;
    int sizeY= 1050;
    MasterPiece pic = new MasterPiece(sizeX, sizeY);
    
    Color black= new Color(0,0,0);
    Color white= new Color(255,255,255);
    Color yellow = new Color(255,255,0);
    
    pic.addObject(new Rectangle(0,0,sizeX,sizeY,white));
    int index=0;
    pic.showCanvas();

    pic.paint();


    
    int frame=0;
    while (true) {
            int stickSize=(int) (Math.random()*(400-100+1)+100);
            double generate= Math.random();
            if (pic.objects.size()<50 && generate <0.5 && frame%50==0){
            int randomY=(int)(Math.random()*(sizeY-stickSize));
            int randomR=(int) (Math.random()*(255-0+1));
            int randomG=(int) (Math.random()*(255-0+1));
            int randomB=(int) (Math.random()*(255-0+1));
            int randomSpeed=(int) (Math.random()*(5-1+1)+1);
            boolean special=false;
            if (Math.random()<0.01){
                special=true;
            }
            pic.addObject(new StickMan(0,randomY,stickSize,new Color(randomR,randomG,randomB),randomSpeed,special));
            
        } 
            if (pic.objects.size()>20){
                pic.removeObject();
            }
            pic.repaint();
            pic.update(frame);
            
            frame++;
            Thread.sleep(10);
        }

    }

}
