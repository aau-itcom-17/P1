import javafx.application.*;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;

public class HowToPlayScene extends QuickPlayScene{

    Label labelHeadline, labelHowToPlay;
    Button buttonDrinking, frontpageButton4;
    VBox layout;

    public HowToPlayScene(){
        Label labelHeadline = new Label(Constants.gameName);
        // Gets the css class "label-headline" instead of the normal layout
            labelHeadline.getStyleClass().add("label-headline");

        buttonDrinking = new Button ("Drinking Rules");

        // Gets the normal layout from the css stylesheet
        buttonDrinking.getStylesheets().add("Theme.css");

        labelHowToPlay = new Label("Fuck, people can see me.");

            labelHowToPlay.setVisible(false);

            buttonDrinking.setOnAction(e -> {
            if(labelHowToPlay.isVisible()) {
                labelHowToPlay.setVisible(false);
            } else {
                labelHowToPlay.setVisible(true);
            }

        });

        frontpageButton4 = new Button(Constants.goToMainText);

        layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(labelHeadline, buttonDrinking, labelHowToPlay, frontpageButton4);
        Scene gameRulesScene = new Scene(layout, 500, 500);
        gameRulesScene.getStylesheets().add("Theme.css");

        window.setScene(gameRulesScene);
    }
}