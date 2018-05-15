package webMindJava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    static Pane roots = new Pane();
    static Grid currGrid = new Grid();
    static ExecutionContext context = new ExecutionContext();
    static AnchorPane anchorpane;



    /*
        Creating an empty GUI
    */
    @Override
    public void start(Stage primaryStage) throws Exception {
        currGrid = new Grid();
        context.makeSessionFromGrid(currGrid);
        anchorpane = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Game Of Life CS485");
        primaryStage.setScene(new Scene(anchorpane, 800, 500));
        anchorpane.getChildren().add(roots);

        createBoxes();
        primaryStage.show();
    }

    public void createBoxes() {
        roots.getChildren().clear();
        roots.setPrefSize(500,500);
        for (int i = 0; i < 35; i++) {
            for(int j = 0; j < 70; j++) {
                Tile tile = new Tile(j*10,i*10);
                tile.setTranslateX(j*10);
                tile.setTranslateY(i*10);
                if(currGrid.contains(new Point(j, i))) tile.border.setFill(Color.BLACK);
                roots.getChildren().add(tile);
            }
        }
        roots.setLayoutX(70);
        roots.setLayoutY(90);
    }

    public class Tile extends StackPane{
        private int x;
        private int y;
        private boolean on = true;
        Rectangle border = new Rectangle(10,10);

        public Tile(int x, int y){
            this.x = x;
            this.y = y;

            border.setFill(null);
            border.setStroke(Color.BLACK);


            //setAlignment(Pos.CENTER);
            getChildren().addAll(border);

            setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    if (border.getFill() == Color.BLACK){
                        border.setFill(Color.WHITE);
                        currGrid.remove(new Point(getPositionX() / 10, getPositionY() / 10));
                        setOnFalse();

                    } else{
                        setOnTrue();
                        border.setFill(Color.BLACK);
                        currGrid.add(new Point(getPositionX() / 10, getPositionY() / 10));
                    }
                    context.makeSessionFromGrid(currGrid);
                }
            });
        }

        public int getPositionX(){return x;}

        public int getPositionY(){return y;}

        public void setOnFalse(){on = false;}

        public void setOnTrue(){on = true;}

    }

    public static void main(String[] args) {
        launch(args);
    }
}
