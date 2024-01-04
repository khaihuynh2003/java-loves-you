import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tut10 extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Hoho");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0, 0);

        PasswordField passInput = new PasswordField(); 
        GridPane.setConstraints(passInput, 1, 0);

        button = new Button("Sign up");
        button.setOnAction(e -> isCorrect(passInput));
        GridPane.setConstraints(button, 1, 2);

        grid.getChildren().addAll(passLabel, passInput, button);

        Scene scene = new Scene(grid, 300, 150);
        window.setScene(scene);
        window.show();
    }

    private boolean isCorrect(PasswordField input) {
        String password = input.getText();
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern specialSymbol = Pattern.compile("[^a-zA-Z0-9]");
        Pattern number = Pattern.compile("[0-9]");

        Matcher upperMatcher = uppercase.matcher(password);
        Matcher specialMatcher = specialSymbol.matcher(password);
        Matcher numberMatcher = number.matcher(password);

        boolean hasUppercase = upperMatcher.find();
        boolean hasSpecialSymbol = specialMatcher.find();
        boolean hasNumber = numberMatcher.find();

        if (hasUppercase && hasSpecialSymbol && hasNumber) {
            System.out.println("Login successful");
            return true;
        } else {
            System.out.println("Password does not meet requirements");
            return false;
        }
    }
}
