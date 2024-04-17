import java.awt.Color;
import java.awt.Graphics;
//Rotation is clockwise
public class Stick extends GraphicsObject
{
    // instance variables - replace the example below with your own
    private int length;
    private int width;
    private int rotation;
    private Color color;
    /**
     * Constructor for objects of class TiltedOval
     */
    public Stick(int x, int y, int length,  int width, int rotation, Color color)
    {
        super(x,y);
        this.length=length;
        this.width=width;
        this.color=color;
        this.rotation=rotation;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillArc((int) this.x-this.width/2, this.y-this.width/2, this.width, this.width,90+this.rotation,180+this.rotation);
        int x1= (int) (this.x+this.width/2*Math.cos(Math.toRadians(270+this.rotation)));
        int x2= (int) (x1+this.length*Math.cos(Math.toRadians(this.rotation)));
        int x4= (int) (this.x+this.width/2*Math.cos(Math.toRadians(90+this.rotation)));
        int x3= (int) (x4+this.length*Math.cos(Math.toRadians(this.rotation)));
        int[] xCord= {x1,x2,x3,x4};
        
        int y1= (int) (this.y-this.width/2*Math.sin(Math.toRadians(270+this.rotation)));
        int y2= (int) (y1-this.length*Math.sin(Math.toRadians(this.rotation)));
        int y4= (int) (this.y-this.width/2*Math.sin(Math.toRadians(90+this.rotation)));
        int y3= (int) (y4-this.length*Math.sin(Math.toRadians(this.rotation)));
        int[] yCord= {y1,y2,y3,y4};
        
        g.fillPolygon(xCord,yCord,4);
        g.fillOval((int) (x3+x2)/2-this.width/2, (y3+y2)/2-this.width/2, this.width, this.width);
        
    }
}
