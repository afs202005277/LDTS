import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element{
    public Hero(int x, int y){
        super(new Position(x, y));
    }

    public Position moveUp(){
        return new Position(getX(), getY() - 1);
    }
    public Position moveDown(){
        return new Position(getX(), getY() + 1);
    }
    public Position moveLeft(){
        return new Position(getX() - 1, getY());
    }
    public Position moveRight(){
        return new Position(getX() + 1, getY());
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY()),"X");
    }
}
