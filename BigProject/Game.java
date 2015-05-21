import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class Game extends Application {
    private boolean done;
    private Level level;

    @Override
    public void start(Stage primaryStage) {
        Level level = new FirstLevel();
        Scene scene = new Scene(
            level.getPane(), level.getWidth(), level.getHeight());
        setLevel(level);
        primaryStage.setTitle(level.getTitle());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Rectangle rect = new Rectangle();
        rect = getLevel().getCharacter().getRectangle();
        
        rect.setFocusTraversable(true);
        
        rect.setOnKeyPressed(
                (e) -> {
            switch(e.getCode()) {
                case D:
                    getLevel().getCharacter().moveRight();
                    break;
                case A:
                    getLevel().getCharacter().moveLeft();
                    break;
                case SPACE:
                    getLevel().getCharacter().jump();
                    break;
                case BACK_SPACE:
                    primaryStage.close();
                    Main main = new Main();
                    main.start(new Stage());
                    break;
            }
        });
        
        //getLevel().getExitButton().setOnMouseClicked((e) -> {
          //  if(e.getButton() == MouseButton.PRIMARY) {
            //    primaryStage.close();
              //  Main main = new Main();
                //main.start(new Stage());
           // }
        //});
    }
    
    public void setLevel(Level level) {
        this.level = level;
    }
    
    public Level getLevel() {
        return level;
    }
}
