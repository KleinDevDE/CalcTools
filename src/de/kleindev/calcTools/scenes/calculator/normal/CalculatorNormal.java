package de.kleindev.calcTools.scenes.calculator.normal;

import de.kleindev.calcTools.tools.Calc;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * CalcTools
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 2017, created by KleinDev
 */
public class CalculatorNormal {

    public Label calcLabel;
    private double lastResult = 0;
    private String lastCalc;
    private String actualCalc;

    // Button 0-9
    public Button calcTasteNo0;
    public Button calcTasteNo1;
    public Button calcTasteNo2;
    public Button calcTasteNo3;
    public Button calcTasteNo4;
    public Button calcTasteNo5;
    public Button calcTasteNo6;
    public Button calcTasteNo7;
    public Button calcTasteNo8;
    public Button calcTasteNo9;

    // other Buttons
    public Button calcTasteKomma;
    public Button calcTastex10;
    public Button calcTasteAns;
    public Button calcTasteErgebnis;
    public Button calcTasteMinus;
    public Button calcTastePlus;
    public Button calcTasteMal;
    public Button calcTasteGeteilt;
    public Button calcTasteAC;
    public Button calcTasteDEL;
    public Button calcTasteLog;
    public Button calcTasteKlammerZu;
    public Button calcTasteKlammerAuf;
    public Button calcTasteNegativ;
    public Button calcTastePi;
    public Button calcTasteTan;
    public Button calcTasteCos;
    public Button calcTasteSin;
    public Button calcTasteWurzel;
    public Button calcTasteHoch;

    public void calcTasteNo0Action(){
        calcLabel.setText(calcLabel.getText()+"0");
    }

    public void calcTasteNo1Action(){
        calcLabel.setText(calcLabel.getText()+"1");
    }

    public void calcTasteNo2Action(){
        calcLabel.setText(calcLabel.getText()+"2");
    }

    public void calcTasteNo3Action(){
        calcLabel.setText(calcLabel.getText()+"3");
    }

    public void calcTasteNo4Action(){
        calcLabel.setText(calcLabel.getText()+"4");
    }

    public void calcTasteNo5Action(){
        calcLabel.setText(calcLabel.getText()+"5");
    }

    public void calcTasteNo6Action(){
        calcLabel.setText(calcLabel.getText()+"6");
    }

    public void calcTasteNo7Action(){
        calcLabel.setText(calcLabel.getText()+"7");
    }

    public void calcTasteNo8Action(){
        calcLabel.setText(calcLabel.getText()+"8");
    }

    public void calcTasteNo9Action(){
        calcLabel.setText(calcLabel.getText()+"9");
    }

    public void calcTasteKommaAction(){
        calcLabel.setText(calcLabel.getText()+",");
    }

    public void calcTastex10Action(){
        calcLabel.setText(calcLabel.getText()+"*10");
    }

    public void calcTasteAnsAction(){
        calcLabel.setText(calcLabel.getText()+"Ans");
    }

    public void calcTasteErgebnisAction(){
        Calc calc = new Calc(calcLabel.getText(), lastResult);
        if (calc.isError()){
            calcLabel.setText(calc.getError());
        } else {
            calcLabel.setText(String.valueOf(calc.getResult()));
            lastResult = calc.getResult();
        }
    }

    public void calcTasteMinusAction(){
        calcLabel.setText(calcLabel.getText()+"-");
    }

    public void calcTastePlusAction(){
        calcLabel.setText(calcLabel.getText()+"+");
    }

    public void calcTasteMalAction(){
        calcLabel.setText(calcLabel.getText()+"*");
    }

    public void calcTasteGeteiltAction(){
        calcLabel.setText(calcLabel.getText()+"÷");
    }

    public void calcTasteACAction(){
        calcLabel.setText("");
    }

    public void calcTasteDELAction(){
        String Text = calcLabel.getText();
        Text = Text.substring(0, Text.length() - 1);
        calcLabel.setText(Text);
    }

    public void calcTasteLogAction(){
        calcLabel.setText(calcLabel.getText()+"log(");
    }

    public void calcTasteKlammerZuAction(){
        calcLabel.setText(calcLabel.getText()+")");
    }

    public void calcTasteKlammerAufAction(){
        calcLabel.setText(calcLabel.getText()+"(");
    }

    public void calcTasteNegativAction(){
        calcLabel.setText(calcLabel.getText()+"-");
    }

    public void calcTastePiAction(){
        calcLabel.setText(calcLabel.getText()+"π");
    }

    public void calcTasteTanAction(){
        calcLabel.setText(calcLabel.getText()+"tan(");
    }

    public void calcTasteCosAction(){
        calcLabel.setText(calcLabel.getText()+"cos(");
    }

    public void calcTasteSinAction(){
        calcLabel.setText(calcLabel.getText()+"sin(");
    }

    public void calcTasteWurzelAction(){
        calcLabel.setText(calcLabel.getText()+"√(");
    }

    public void calcTasteHochAction(){
        calcLabel.setText(calcLabel.getText()+"^");
    }

    @FXML
    void calcKeyPressed(KeyEvent event) {
        System.out.print("Key: " + event.getCode() + "\n");
        event.consume();
        switch (event.getCode()) {
            case DIGIT0:
            case NUMPAD0:
                calcLabel.setText(calcLabel.getText() + "0");
                break;
            case DIGIT1:
            case NUMPAD1:
                calcLabel.setText(calcLabel.getText() + "1");
                break;
            case DIGIT2:
            case NUMPAD2:
                calcLabel.setText(calcLabel.getText() + "2");
                break;
            case DIGIT3:
            case NUMPAD3:
                calcLabel.setText(calcLabel.getText() + "3");
                break;
            case DIGIT4:
            case NUMPAD4:
                calcLabel.setText(calcLabel.getText() + "4");
                break;
            case DIGIT5:
            case NUMPAD5:
                calcLabel.setText(calcLabel.getText() + "5");
                break;
            case DIGIT6:
            case NUMPAD6:
                calcLabel.setText(calcLabel.getText() + "6");
                break;
            case DIGIT7:
            case NUMPAD7:
                if (event.getCode() == KeyCode.DIGIT7 && event.isShiftDown())
                    calcLabel.setText(calcLabel.getText() + "÷");
                else calcLabel.setText(calcLabel.getText() + "7");
                break;
            case DIGIT8:
            case NUMPAD8:
                if (event.getCode() == KeyCode.DIGIT8 && event.isShiftDown())
                    calcLabel.setText(calcLabel.getText() + "(");
                else calcLabel.setText(calcLabel.getText() + "8");
                break;
            case DIGIT9:
            case NUMPAD9:
                if (event.getCode() == KeyCode.DIGIT9 && event.isShiftDown())
                    calcLabel.setText(calcLabel.getText() + ")");
                else calcLabel.setText(calcLabel.getText() + "9");
                break;
            case MINUS:
            case SUBTRACT:
                calcLabel.setText(calcLabel.getText() + "-");
                break;
            case PLUS:
            case ADD:
                if (event.getCode() == KeyCode.PLUS && event.isShiftDown())
                    calcLabel.setText(calcLabel.getText() + "*");
                else calcLabel.setText(calcLabel.getText() + "+");
                break;
            case DIVIDE:
                calcLabel.setText(calcLabel.getText() + "÷");
                break;
            case MULTIPLY:
                calcLabel.setText(calcLabel.getText() + "*");
                break;
            case BACK_SPACE:
                if (calcLabel.getText().length() > 0) {
                    String Text = calcLabel.getText();
                    Text = Text.substring(0, Text.length() - 1);
                    calcLabel.setText(Text);
                }
                break;
            case COMMA:
            case DECIMAL:
                calcLabel.setText(calcLabel.getText() + ",");
                break;
            case UP:
                if (!lastCalc.isEmpty()) {
                    actualCalc = calcLabel.getText();
                    calcLabel.setText(lastCalc);
                }
                break;
            case DOWN:
                if (!actualCalc.isEmpty()){
                    calcLabel.setText(actualCalc);
                }
                break;
            case V:
                if (event.isShortcutDown()){
                    try {
                        if (Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor) != null) {
                            String data = (String) Toolkit.getDefaultToolkit()
                                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
                            String Text = calcLabel.getText() + data;
                            calcLabel.setText(Text);
                        }
                    } catch (UnsupportedFlavorException | IOException e) {
                        String error = "";
                        if (e.getMessage().equalsIgnoreCase("Unicode String"))
                            error = "Clipboard isn't a String,\n" +
                                    "make sure you have copied a String";
                        e.printStackTrace();
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Error while calling the clipboard!\n" +
                                error, ButtonType.OK);
                        alert.showAndWait();
                    }
                }
                break;
            case ENTER:
                Calc calc = new Calc(calcLabel.getText(), lastResult);
                calcLabel.setText(String.valueOf(calc.getResult()));
                lastResult = calc.getResult();
                break;
            default:
                break;
        }
    }

}
