import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Bounds;

import java.util.Random;

public class Controller {

    Random random = new Random();
    int score = 0;

    @FXML
    private GridPane myGridPane;

    @FXML
    private ImageView diceImage;

    @FXML
    private ImageView orange;

    @FXML
    private Button rollButton;

    @FXML
    private Label resultLabel, scoreLabel;

    @FXML
    private TextField answerTextField;

    @FXML
    private Button submitButton;

    @FXML
    private Rectangle imageOverlay;

    private int diceValue;

    public void toggleOverlay(MouseEvent event) {
        if (imageOverlay.isVisible()) {
            imageOverlay.setVisible(false);
        } else {
            imageOverlay.setVisible(true);
        }
    }

    public void roll(ActionEvent e) {
        rollButton.setDisable(true);

        Thread animationThread = new Thread(() -> {
            try {
                for (int i = 0; i < 24; i++) {
                    diceValue = random.nextInt(6) + 1;
                    Image image = new Image(getClass().getResourceAsStream("/dice/" + diceValue + ".png"));

                    Platform.runLater(() -> diceImage.setImage(image));

                    Thread.sleep(50);
                }
                enableAnswerAndSubmitButton();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        animationThread.start();
    }

    private void enableAnswerAndSubmitButton() {
        Platform.runLater(() -> {
            resultLabel.setText("Result: " + diceValue);
            answerTextField.setDisable(false);
            submitButton.setDisable(false);
        });
    }

    public void submit(ActionEvent event) {
        String answer = answerTextField.getText().trim().toLowerCase();

        if (clickOverlay(imageOverlay).equals(posImage(orange)) && answer.equals("orange")) {
            score++;
            scoreLabel.setText("Score: " + score);
        }

        rollButton.setDisable(false);
        answerTextField.setDisable(true);
        submitButton.setDisable(true);
        answerTextField.clear();
    }

    public String clickOverlay(Rectangle rectangle) {
        String pos = "";
        int a = myGridPane.getColumnIndex(rectangle);
        int b = myGridPane.getRowIndex(rectangle);

        return pos = String.valueOf(b) + String.valueOf(a);
    }

    public String posImage(ImageView imageView) {
        String pos = "";
        int a = myGridPane.getColumnIndex(imageView);
        int b = myGridPane.getRowIndex(imageView);

        return pos = String.valueOf(b) + String.valueOf(a);
    }
}
