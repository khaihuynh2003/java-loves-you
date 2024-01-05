import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class tut16_treeView extends Application {
    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Java painful");

        TreeItem<String> root, food, fruits;

        root = new TreeItem<>();
        // expanded by default
        root.setExpanded(true);

        food = makeBranch("Food", root);
        makeBranch("Chicken", food);
        makeBranch("Pizza", food);
        makeBranch("Rice", food);

        fruits = makeBranch("Fruits", root);
        makeBranch("Apple", fruits);
        makeBranch("Banana", fruits);

        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
        {
            if(newValue != null)   
                System.out.println(newValue.getValue());
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(tree);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);

        window.show();
    }

    private TreeItem<String>  makeBranch(String title, TreeItem<String> parent)
    {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        
        return item;
    }
}