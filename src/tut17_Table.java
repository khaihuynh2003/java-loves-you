import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tut17_Table extends Application {
    Stage window;
    TableView<tut17_Products> table;
    TextField nameInput, priceInput, quantityInput;
    Button addButton, delButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Java painful");

        TableColumn<tut17_Products, String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<tut17_Products, Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(200);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<tut17_Products, Double> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setMinWidth(200);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        nameInput = new TextField();
        nameInput.setPromptText("Type name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Type price");
        priceInput.setMinWidth(100);

        quantityInput = new TextField();
        quantityInput.setPromptText("Type quantity");
        quantityInput.setMinWidth(100);

        addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClick());
        delButton = new Button("Delete");
        delButton.setOnAction(e -> delButtonClick());

        HBox layout2 = new HBox();
        layout2.setPadding(new Insets(10, 10, 10, 10));
        layout2.setSpacing(10);
        layout2.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, delButton);

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().add(nameCol);
        table.getColumns().add(priceCol);
        table.getColumns().add(quantityCol);

        VBox layout = new VBox();
        layout.getChildren().addAll(table, layout2);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        window.show();
    }

    public ObservableList<tut17_Products> getProducts() {
        ObservableList<tut17_Products> products = FXCollections.observableArrayList();
        products.add(new tut17_Products("Laptop", 999.00, 15));
        products.add(new tut17_Products("Smartphone", 599.00, 20));
        products.add(new tut17_Products("Headphones", 79.99, 50));
        products.add(new tut17_Products("Book", 19.99, 100));
        products.add(new tut17_Products("Desk Chair", 199.50, 10));
        return products;
    }

    public void addButtonClick() {
        tut17_Products product = new tut17_Products();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));

        table.getItems().add(product);

        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void delButtonClick() {
        ObservableList<tut17_Products> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts :: remove);
    }
}