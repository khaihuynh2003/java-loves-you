import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class tut5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;
        window.setTitle("Java painful");

        Button button = new Button("Click meeee");

        button.setOnAction(e -> tut5AlertBox.display("Hooohoo", "You are awesome"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 900, 600);
        window.setScene(scene);
        window.show();
    }
} 