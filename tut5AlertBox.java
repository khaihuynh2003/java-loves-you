import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class tut5AlertBox {
    public static void display(String title, String message)
    {
        Stage window = new Stage();

        // ugh ugh can't do thingies till finish
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);
        window.setMinHeight(250);

        Label label = new Label();
        label.setText(message);

        Button close = new Button("Close window");
        close.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, close);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
