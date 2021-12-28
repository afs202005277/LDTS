import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private Position position;

    public Element(){}
    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public int getX(){
        return position.getX();
    }

    public int getY(){
        return position.getY();
    }

    public void setX(int x){
        position.setX(x);
    }

    public void setY(int y){
        position.setY(y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    abstract public void draw(TextGraphics graphics);
}
