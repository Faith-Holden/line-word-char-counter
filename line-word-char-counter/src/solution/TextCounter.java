package solution;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.geometry.Insets;

public class TextCounter extends Application{

    private int lines;
    private int words;
    private int characters;

    public void start (Stage primaryStage) throws Exception{
        VBox vBox = new VBox();
        Pane root = new Pane(vBox);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        vBox.setStyle("-fx-border-color: black; -fx-border-width: 3px; " +
                "-fx-background-color: black");
        vBox.setPrefWidth(400);
        vBox.setMinHeight(20);

        TextArea textBox = new TextArea("Please enter your text in this box.");
        textBox.setFont(Font.font("", 15));
        textBox.requestFocus();
        textBox.selectAll();
        textBox.setPrefColumnCount(40);
        textBox.setPrefRowCount(15);
        textBox.setWrapText(true);

        Label charLabel = new Label("Character count:");
        charLabel.setPrefWidth(vBox.getPrefWidth());
        charLabel.setFont(Font.font("", FontWeight.BOLD,15));
        charLabel.setStyle("-fx-background-color: white");

        Label wordsLabel = new Label("Word count:");
        wordsLabel.setPrefWidth(vBox.getPrefWidth());
        wordsLabel.setFont(Font.font("", FontWeight.BOLD,15));
        wordsLabel.setStyle("-fx-background-color: white");

        Label linesLabel = new Label("Line count:");
        linesLabel.setPrefWidth(vBox.getPrefWidth());
        linesLabel.setFont(Font.font("", FontWeight.BOLD,15));
        linesLabel.setStyle("-fx-background-color: white");

        Button analyzeButton = new Button("Analyze");
        analyzeButton.setDefaultButton(true);
        analyzeButton.setOnAction(evt->{
            String inputText = textBox.getText();
            analyzeText(inputText);
            linesLabel.setText("Line count:                      "+ lines);
            charLabel.setText("Character count:            "+ characters);
            wordsLabel.setText("Word count:                    "+ words);

        });

        HBox hBox = new HBox(analyzeButton);
        hBox.setAlignment(Pos.BASELINE_CENTER);

        vBox.getChildren().add(textBox);
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(wordsLabel);
        vBox.getChildren().add(charLabel);
        vBox.getChildren().add(linesLabel);
        vBox.setMargin(wordsLabel, new Insets(5));
        vBox.setMargin(textBox, new Insets(5));
        vBox.setMargin(charLabel, new Insets(5));
        vBox.setMargin(linesLabel, new Insets(5));
        vBox.setMargin(hBox, new Insets(5));

        primaryStage.show();
    }

    void analyzeText (String input){
        int charCounter;
        int lineCounter = 1;
        int wordCounter = 0;
        char previousCharacter = ' ';

        charCounter = input.length();
        for(int i = 0; i<input.length();i++){
            char character = input.charAt(i);
            if(character=='\n'){
                lineCounter++;
            }
            if(previousCharacter==' '){
                if(character!=' '){
                    wordCounter++;
                }
            }
            previousCharacter = character;
        }
        lines = lineCounter;
        words = wordCounter;
        characters = charCounter;

    }

    public static void main(String[]Args){
        launch(Args);
    }

}
