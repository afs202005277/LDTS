import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Arena {
    private Hero hero;
    private int width;
    private int height;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = new ArrayList<Coin>();
        coins = createCoins();
        this.monsters = new ArrayList<Monster>();
        monsters = createMonsters();
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private boolean checkCoinLocation(Coin next_coin){
        if (next_coin.getPosition().equals(hero.getPosition()))
            return false;
        if (coins.isEmpty())
            return true;
        for ( Coin coin : coins)
            if (coin.getPosition().equals(next_coin.getPosition()))
                return false;
        return true;
    }

    private boolean checkMonsterLocation(Monster next_monster){
        if (next_monster.getPosition().equals(hero.getPosition()))
            return false;
        if (monsters.isEmpty())
            return true;
        for ( Monster m : monsters)
            if (m.getPosition().equals(next_monster.getPosition()))
                return false;
        for ( Coin coin : coins)
            if (coin.getPosition().equals(next_monster.getPosition()))
                return false;
        return true;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        Coin next_coin = new Coin();
        for (int i = 0; i < 5; i++) {
            do {
                next_coin = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            } while (!checkCoinLocation(next_coin));
            coins.add(next_coin);
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        Monster next_monster = new Monster();
        for (int i = 0; i < 5; i++) {
            do {
                next_monster = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            } while (!checkMonsterLocation(next_monster));
            monsters.add(next_monster);
        }
        return monsters;
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin:coins)
            coin.draw(graphics);
        for (Monster m:monsters)
            m.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()) {
            case ArrowUp: moveHero(hero.moveUp()); break;
            case ArrowDown:moveHero(hero.moveDown());break;
            case ArrowLeft:moveHero(hero.moveLeft());break;
            case ArrowRight:moveHero(hero.moveRight());break;
        }
        moveMonsters();
    }

    private void moveMonsters() {
        for (Monster m:monsters) {
            m.setPosition(m.move(this));
            if (m.getPosition() == hero.getPosition())
            {
                System.out.println("You lost");
                System.exit(0);
            }
            for (Coin c:coins)
                if (c.getPosition() == m.getPosition())
                    coins.remove(c);
        }
    }

    private boolean canHeroMove(Position position) {
        boolean not_collided = true;
        for (Wall wall : walls)
        {
            if (wall.getPosition().equals(position))
                not_collided = false;
        }
        return (position.getX() >= 0 && position.getX()<= width-1 && position.getY()>=0&&position.getY()<= height-1) && not_collided;
    }

    private void retrieveCoins(){
        for (Coin coin: coins)
        {
            if (hero.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }
    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
            for (Monster m : monsters) {
                if (m.getPosition() == hero.getPosition()) {
                    System.out.println("You lost");
                    System.exit(0);
                }
                retrieveCoins();
            }
        }
    }
}
