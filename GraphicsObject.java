import java.awt.Color;
import java.awt.Graphics;

public class GraphicsObject {

    int x;
    int y;

    public GraphicsObject(int x, int y) {
    this.x = x;
    this.y = y;
    }

    /* Draw the object
     *
     * This function should never be called directly, but should be overridden
     * by subclasses.
     *
     * @param g The Graphics for the JPanel
     */
    public void draw(Graphics g) {
    }

    public void update(int frame) {

    }
}
