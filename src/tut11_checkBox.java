import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tut11_checkBox extends Application {

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

        CheckBox box1 = new CheckBox("Watermelon");
        CheckBox box2 = new CheckBox("Mango");
        box2.setSelected(true);

        button = new Button("Click me");
        button.setOnAction(e -> handleOptions(box1, box2));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(box1, box2, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2)
    {
        String message = "";
        if(box1.isSelected())
            message += "Watermelon ";
        if(box2.isSelected())
            message += "Mango ";

        System.out.println(message);
    }
}