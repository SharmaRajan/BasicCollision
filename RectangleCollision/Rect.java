import java.awt.Rectangle;

public class Rect {

    int x,y;
    boolean right = false;

    public Rect(int startX, int startY){
        this.x = startX;
        this.y = startY;
    }

    public void move(){
        if(x == 700) right = true;
        if(x ==0) right = false;

        if(right) x--;
        else x++;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,100,50);
    }

}
