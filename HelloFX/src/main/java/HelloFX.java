import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class HelloFX extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage){

            //Window Title
            primaryStage.setTitle("Select your file");

            //Setting the PlainText Title
            Text title = new Text("ENS PR Automailer");
            title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

            //Setting the label text, font and size
            Label label = new Label("File:");
            label.setFont(Font.font("Ariel", FontWeight.NORMAL, FontPosture.REGULAR, 14));

            //Creating variables for TextField and FileChooser
            TextField textField = new TextField();
            FileChooser fileChooser = new FileChooser();

            //Warning Text for empty text box
            final Label warning = new Label();
            warning.setStyle("-fx-text-fill: red");

            //Button Action for select button
            Button select = new Button("Select File");
            select.setOnAction(e -> {
                File selectedFile = fileChooser.showOpenDialog(primaryStage);
                if(selectedFile != null){
                    String directory = selectedFile.getAbsolutePath();
                    textField.setText(directory);
                    if (!directory.contains(".xlsx")){
                        warning.setText("File Type Selected is not correct");
                    }
                    else {
                        primaryStage.close();
                    }
                }
                else {
                    warning.setText("Please select a file");
                }
            });

            //Section for the GridBox
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            //Appending the variables to the grid box
            grid.add(title, 0,0,2,1);
            grid.add(label, 0, 1);
            grid.add(textField, 1, 1);
            grid.add(warning, 1,5);

            //Select button
            HBox selectBtn = new HBox();
            selectBtn.setAlignment(Pos.BOTTOM_RIGHT);
            selectBtn.getChildren().add(select);
            grid.add(selectBtn, 1, 4);

            //OK button
            /*
            HBox okBtn = new HBox();
            okBtn.setAlignment(Pos.BOTTOM_RIGHT);
            okBtn.getChildren().add(ok);
            grid.add(okBtn, 0,4);
            */

            //Create the scene
            Scene scene = new Scene(grid, 350,275);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }