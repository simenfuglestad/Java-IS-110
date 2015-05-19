import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

public class Level {
    private String title;
    protected Line line;
    protected Character character;
    protected Pane pane;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Level(String title, Pane pane, Line line, Character character) {
        this.title = title;
        this.pane = pane;
        this.line = line;
        this.character = character;
    }
    
    public Level() {
        this("Level", new Pane(), new Line(), new Character());
    }
    
    public Pane getPane() {
        return pane;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return WIDTH;
    }
    
    public int getHeight() {
        return HEIGHT;
    }
    
    public Line getLine() {
        return line;
    }
    
    public Character getCharacter() {
        return character;
    }
}
