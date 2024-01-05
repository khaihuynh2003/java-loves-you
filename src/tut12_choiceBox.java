import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tut12_choiceBox extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Java painful");

        ChoiceBox<String> fruit = new ChoiceBox<>();

        fruit.getItems().add("Apple");
        fruit.getItems().add("Banana");
        fruit.getItems().addAll("Coconut", "Durian", "Elderberry");

        fruit.setValue("Apple");

        button = new Button("Click me");
        button.setOnAction(e -> getChoice(fruit));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(fruit, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void getChoice(ChoiceBox<String> cbox)
    {
        String current = cbox.getValue();
        System.out.println(current);
    }
}