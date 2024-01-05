import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tut15_listView extends Application {

    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Java painful");

        listView = new ListView<>();
        listView.getItems().addAll("Aaa", "Bbb", "Ccc", "Ddd", "Eee", "Fff", "Ggg", "Hhh");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button = new Button("Click me");
        button.setOnAction(e -> buttonClick());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void buttonClick() {
        String message = "";
        ObservableList<String> wut;
        wut = listView.getSelectionModel().getSelectedItems();

        for (String w : wut)
            message += w + " ";

        System.out.println(message);
    }
}