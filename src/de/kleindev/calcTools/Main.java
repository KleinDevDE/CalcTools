package de.kleindev.calcTools;

import de.kleindev.calcTools.scenes.Scenes;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * CalcTools
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 2017, created by KleinDev
 */
public class Main extends Application{
    public static Stage primary;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primary = primaryStage;
        primary.setScene(Scenes.home);
        primary.setTitle("CalcTools");
        primary.setResizable(false);
        primary.getIcons().add(new Image(Main.class.getResourceAsStream("tools/images/icon.png")));
        primary.show();
    }
}
