import java.awt.Color;
import java.awt.Graphics;

public class StickMan extends GraphicsObject {

    int height;
    Color color;
    Color bcolor;
    int speed;
    int leg1Rot;
    int leg2Rot;
    int arm1Rot;
    int arm2Rot;
    int forearm1Rot;
    int forearm2Rot;
    boolean special;

    public StickMan(int x, int y, int height, Color color,int speed, boolean special) {
    super(x, y);
    this.height=height;
    this.color=color;
    this.leg1Rot=270;
    this.leg2Rot=270;
    this.arm1Rot=270;
    this.arm2Rot=270;
    this.forearm1Rot=270;
    this.forearm2Rot=270;
    this.speed=speed;
    this.special=special;
    }
    public StickMan(int x, int y, int height, int leg1Rot, int leg2Rot, Color color) {
    super(x, y);
    this.height=height;
    this.color=color;
    this.leg1Rot=leg1Rot;
    this.leg2Rot=leg2Rot;
    }

    /* Draw the rectangle
     *
     * @param g The Graphics for the JPanel
     */
    @Override
    public void draw(Graphics g) {
    int headRadius=this.height/8;    


    g.setColor(color);
    
    int stickThickness=height/25;
    g.fillOval(this.x,this.y,headRadius,headRadius);
    int bottomRot;
    int bodyLength=height/2-height/8;
    if (speed>100){
        bottomRot=220;
    } else{
        bottomRot=270;
    }
    Stick body= new Stick(this.x+height/16,this.y+height/8,bodyLength,stickThickness,bottomRot,color);
    
    body.draw(g);
    
    int botposx= this.x+height/16;
    int botposy= this.y+height/2;
    
    Stick thigh1=new Stick(botposx,botposy,height/4,stickThickness,this.leg1Rot,color);
    Stick thigh2=new Stick(botposx,botposy,height/4,stickThickness,this.leg2Rot,color);
    
    
    thigh1.draw(g);
    thigh2.draw(g);
    
    int knee1x=(int) (botposx+height/4*Math.cos(Math.toRadians(leg1Rot)));
    int knee2x=(int) (botposx+height/4*Math.cos(Math.toRadians(leg2Rot)));
    
    int knee1y= (int) (botposy-height/4*Math.sin(Math.toRadians(leg1Rot)));
    int knee2y= (int) (botposy-height/4*Math.sin(Math.toRadians(leg2Rot)));
    
    if (leg1Rot>270){
        Stick leg1=new Stick(knee1x,knee1y,height/4,stickThickness,270,color);
        leg1.draw(g);
    }
    else{
        Stick leg1=new Stick(knee1x,knee1y,height/4,stickThickness,leg1Rot,color);
        leg1.draw(g);
    }
    
    if (leg2Rot>270){
        Stick leg2=new Stick(knee2x,knee2y,height/4,stickThickness,270,color);
        leg2.draw(g);
    }
    else{
        Stick leg2=new Stick(knee2x,knee2y,height/4,stickThickness,leg2Rot,color);
        leg2.draw(g);
    }
    
    int shoulderx=this.x+height/16;
    int shouldery=this.y+height/10+height/16;
    
    Stick upperarm1= new Stick(shoulderx,shouldery, height/5,stickThickness,arm1Rot,color);
    Stick upperarm2= new Stick(shoulderx,shouldery,height/5,stickThickness,arm2Rot,color);
    
    upperarm1.draw(g);
    upperarm2.draw(g);
    
    
    int elbow1x=(int) (shoulderx+height/5*Math.cos(Math.toRadians(arm1Rot)));
    int elbow2x=(int) (shoulderx+height/5*Math.cos(Math.toRadians(arm2Rot)));
    
    int elbow1y= (int) (shouldery-height/5*Math.sin(Math.toRadians(arm1Rot)));
    int elbow2y= (int) (shouldery-height/5*Math.sin(Math.toRadians(arm2Rot)));
    
    Stick forearm1= new Stick(elbow1x,elbow1y, height/5,stickThickness,forearm1Rot,color);
    Stick forearm2= new Stick(elbow2x,elbow2y, height/5,stickThickness,forearm2Rot,color);

    forearm1.draw(g);
    forearm2.draw(g);
    
    }
    public void update(int frame) {
        
        this.leg1Rot=(int) (20*Math.sin(6.28*frame/150*speed)*(2-Math.exp(-speed))+270);
        this.leg2Rot=(int) (20*Math.sin(-6.28*frame/150*speed)*(2-Math.exp(-speed))+270);
        this.arm1Rot=(int) (20*Math.sin(6.28*frame/150*speed)*(2-Math.exp(-speed))+270);
        this.arm2Rot=(int) (20*Math.sin(-6.28*frame/150*speed)*(2-Math.exp(-speed))+270);
        this.forearm1Rot=(int) (arm1Rot+(20*Math.sin(6.28*frame/150*speed)+30));
        this.forearm2Rot=(int) (arm2Rot+(20*Math.sin(6.28*frame/150*speed)+30));
        this.x+=speed;
        if (this.special){
            int randomR=(int) (Math.random()*(255-0+1));
            int randomG=(int) (Math.random()*(255-0+1));
            int randomB=(int) (Math.random()*(255-0+1));
            this.color=new Color(randomR,randomG,randomB);
            
        }
    }
    
}
