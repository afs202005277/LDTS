import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.print.attribute.standard.CopiesSupported;
import java.util.Random;

public class Monster extends Element{
    public Monster() {super();}

    public Monster(Position position) {
        super(position);
    }

    public Monster(int x, int y) {
        super(new Position(x, y));
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getX(), getY()),"M");
    }

    public Position move(Arena arena){
        Random random = new Random();
        while (true){
            Position pos = new Position(getX() + random.nextInt(3) - 1, getY() + random.nextInt(3) - 1);
            if (pos.getX() > 0 && pos.getX() < arena.getWidth()-1 && pos.getY() > 0 && pos.getY() < arena.getHeight()-1)
                return pos;
        }
    }


}
