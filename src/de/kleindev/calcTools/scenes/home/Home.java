package de.kleindev.calcTools.scenes.home;

import de.kleindev.calcTools.Main;
import de.kleindev.calcTools.scenes.Scenes;
import de.kleindev.calcTools.scenes.calculator.normal.CalculatorNormal;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


/**
 * CalcTools
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 2017, created by KleinDev
 */

public class Home {

    public Button calculatorButton;
    public ImageView calculatorImage;
    public Button converterButton;
    public ImageView converterImage;
    public ImageView infoImage;

    /*
    Calculator icon downloaded from iconarchive.com
    http://www.iconarchive.com/show/beautiful-flat-one-color-icons-by-elegantthemes/calculator-icon.html

    Info icon downloaded from iconarchive.com
    http://www.iconarchive.com/show/minium-2-icons-by-rade8/General-Get-Info-icon.html3

    Converter icon downloaded from iconarchive.com
    http://www.iconarchive.com/show/button-ui-requests-7-icons-by-blackvariant/CarbonCopyCloner-icon.html
    */

    public void onCalculatorButtonClick(){
        calculator();
    }

    public void onCalculatorImageClick(){
        calculator();
    }


    public void onConverterButtonClick(){
        converter();
    }

    public void onConverterImageClick(){
        converter();
    }

    private void converter(){
        Main.primary.setScene(Scenes.converter);
        Main.primary.setTitle("Converter");
    }

    private void calculator(){
       Main.primary.setScene(Scenes.calculatorNormal);
        Main.primary.setTitle("Calculator");
    }

    public void onInfoImageClick(){
        final Stage[] stage = {new Stage()};
        stage[0].setScene(Scenes.info);
        stage[0].getIcons().add(new Image(Main.class.getResourceAsStream("tools/images/info.png")));
        stage[0].setResizable(false);
        stage[0].show();

        stage[0].setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                stage[0] = null;
                System.gc();
            }
        });
    }
}
