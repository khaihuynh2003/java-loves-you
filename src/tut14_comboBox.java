import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tut14_comboBox extends Application {
    
    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Java painful");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
            "Cuphead", 
            "Five nights at Freddy",
            "Minecraft",
            "Genshin Impact"
        );

        comboBox.setOnAction(e -> System.out.println("User selected " + comboBox.getValue()));

        comboBox.setPromptText("Select game?");

        // eat setPromptText ...
        comboBox.setEditable(true);

        button = new Button("Click me");
        button.setOnAction(e-> printGame());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void printGame()
    {
        System.out.println(comboBox.getValue());
    }
}