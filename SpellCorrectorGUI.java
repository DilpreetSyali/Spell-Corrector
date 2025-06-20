import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SpellCorrectorGUI extends Application {
    private SpellCorrector spellCorrector;

    @Override
    public void start(Stage primaryStage) {
        // Load the dictionary
        Trie dictionary = new Trie();
        DictionaryLoader.loadDictionary(dictionary, "C:\\Users\\Dell\\Downloads\\dictionary.txt");
        spellCorrector = new SpellCorrector(dictionary);

        // Create UI components
        Label title = new Label("Spell Corrector");
        title.setFont(new Font(24));

        Label inputLabel = new Label("Enter a word to correct:");
        inputLabel.setFont(new Font(16));

        TextField inputField = new TextField();
        inputField.setFont(new Font(16));

        Button correctButton = new Button("Correct");
        Label resultLabel = new Label("Corrected word:");

        correctButton.setOnAction(e -> {
            String inputWord = inputField.getText();
            String correctedWord = spellCorrector.correct(inputWord);
            resultLabel.setText("Corrected word: " + correctedWord);
        });

        VBox vbox = new VBox(10, title, inputLabel, inputField, correctButton, resultLabel);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Spell Corrector");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
