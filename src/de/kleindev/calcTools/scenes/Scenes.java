package de.kleindev.calcTools.scenes;

import de.kleindev.calcTools.scenes.calculator.normal.CalculatorNormal;
import de.kleindev.calcTools.scenes.calculator.scientific.CalculatorScientific;
import de.kleindev.calcTools.scenes.converter.Converter;
import de.kleindev.calcTools.scenes.home.Home;
import de.kleindev.calcTools.scenes.info.Info;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * CalcTools
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 2017, created by KleinDev
 */
public class Scenes {
    public final static Scene home = home();
    public final static Scene calculatorNormal = calculatorNormal();
    public final static Scene calculatorScientific = calculatorScientific();
    public final static Scene converter = converter();
    public final static Scene info = info();


    private static Scene home(){
        try {
            FXMLLoader fxmlLoader= new FXMLLoader(Home.class.getResource("Home.fxml"));
            AnchorPane anchorPane= (AnchorPane) fxmlLoader.load();
            return new Scene(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Scene calculatorNormal(){
        try {
            FXMLLoader fxmlLoader= new FXMLLoader(CalculatorNormal.class.getResource("CalculatorNormal.fxml"));
            AnchorPane anchorPane= (AnchorPane) fxmlLoader.load();
            return new Scene(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Scene calculatorScientific(){
        try {
            FXMLLoader fxmlLoader= new FXMLLoader(CalculatorScientific.class.getResource("CalculatorScientific.fxml"));
            AnchorPane anchorPane= (AnchorPane) fxmlLoader.load();
            return new Scene(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Scene converter(){
        try {
            FXMLLoader fxmlLoader= new FXMLLoader(Converter.class.getResource("Converter.fxml"));
            AnchorPane anchorPane= (AnchorPane) fxmlLoader.load();
            return new Scene(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Scene info(){
        try {
            FXMLLoader fxmlLoader= new FXMLLoader(Info.class.getResource("Info.fxml"));
            AnchorPane anchorPane= (AnchorPane) fxmlLoader.load();
            return new Scene(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
