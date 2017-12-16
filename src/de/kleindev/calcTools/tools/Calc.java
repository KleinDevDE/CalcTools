package de.kleindev.calcTools.tools;

import de.kleindev.calcTools.scenes.calculator.MathType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CalcTools
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 2017, created by KleinDev
 */


public class Calc {

    private String rawMath;
    private String error;
    private double result;
    private boolean isError;
    private HashMap<Integer, String> priority = new HashMap<>();
    private HashMap<Integer, String> chars = new HashMap<>();
    private ArrayList<MathType> mathTypes = new ArrayList<>();
    private ArrayList<Double> addition = new ArrayList<>();

    public Calc(String string, double lastResult){
        rawMath = string;
        scan();
    }

    public String getError() {
        return error;
    }

    public double getResult() {
        return result;
    }

    // (3+4)-6+(7-2)
    private void scan(){
        rawMath = rawMath.replaceAll(",", ".");
        for (char c : rawMath.toCharArray()){
            String s = Character.toString(c);
            chars.put(chars.size()+1, s);
            if (s.equals("+")) mathTypes.add(MathType.addition);
            if (s.equals("-")) mathTypes.add(MathType.substraction);
            if (s.equals("*")) mathTypes.add(MathType.multiplication);
            if (s.equals("÷")) mathTypes.add(MathType.division);
            if (s.equals("π")) mathTypes.add(MathType.pi);
            if (s.equals("√")) mathTypes.add(MathType.root);
            if (s.equals("^")) mathTypes.add(MathType.exponentation);
        }
        if (rawMath.contains("log")) mathTypes.add(MathType.logarithm);
        if (rawMath.contains("sin")) mathTypes.add(MathType.sine);
        if (rawMath.contains("cos")) mathTypes.add(MathType.cosine);
        if (rawMath.contains("tan")) mathTypes.add(MathType.tangent);
        if (rawMath.contains("(") && rawMath.contains(")")){
            Pattern p = Pattern.compile(".*\\((.*)\\).*");
            Matcher m = p.matcher(rawMath);
            if(m.find()){
                mathTypes.add(MathType.clips);
            }
        }
        calculate();
    }

    private void calculate(){
        rawMath = rawMath.replaceAll("π", String.valueOf(Math.PI));
        rawMath = rawMath.replaceAll("e", String.valueOf(Math.E));


        if (mathTypes.contains(MathType.clips)){
            Pattern p = Pattern.compile("\\((.*)\\)");
            Matcher m = p.matcher(rawMath);
            if (m.find()){
                Pattern addition = Pattern.compile("(?!\\*|÷|π)[0-9]\\.[0-9]\\+[0-9]\\.[0-9](?!\\*|÷|π)");
                Pattern substraction = Pattern.compile("(?!\\*|÷|π)[0-9]\\.[0-9]-[0-9]\\.[0-9](?!\\*|÷|π)");
                if (m.group().contains("*") || m.group().contains("÷") || m.group().contains("π")){

                }

                for (int count = 0; count <= m.groupCount(); count++){
                    if (addition.matcher(m.group(count)).find()){

                    }
                }
            }
        }

        if (mathTypes.contains(MathType.multiplication)){
            Pattern p = Pattern.compile("[0-9]\\.[0-9]\\*[0-9]\\.[0-9]");
            Matcher m = p.matcher(rawMath);
            if (m.find()){
                for (int count = 1; count <= m.groupCount(); count++){
                    double first = Double.parseDouble(m.group(count));
                    double last = Double.parseDouble(m.group(count));
                    addition.add(multiplication(first, last));
                }
            }
        }

        if (mathTypes.contains(MathType.root)){
            Pattern p = Pattern.compile(".*√\\((.*)\\).*");
            Matcher m = p.matcher(rawMath);
            if(m.find()){
                for (int count = 1; count <= m.groupCount(); count++){
                    addition.add(root(Double.parseDouble(m.group(count))));
                }
            }
        }


        if (mathTypes.contains(MathType.addition)){
            Pattern p = Pattern.compile("(?!\\*|÷|π)[0-9]\\.[0-9]\\+[0-9]\\.[0-9](?!\\*|÷|π)");
            Matcher m = p.matcher(rawMath);
            if(m.find()) {
                for (int count = 1; count <= m.groupCount(); count++){
                    double first = Double.parseDouble(m.group(count));
                    double last = Double.parseDouble(m.group(count));
                    addition.add(addition(first, last));
                }
            }
        }

        if (mathTypes.contains(MathType.substraction)){
            Pattern p = Pattern.compile("(?!\\*|÷|π)[0-9]\\.[0-9]-[0-9]\\.[0-9](?!\\*|÷|π)");
            Matcher m = p.matcher(rawMath);
            if(m.find()) {
                for (int count = 1; count <= m.groupCount(); count++){
                    double first = Double.parseDouble(m.group(count));
                    double last = Double.parseDouble(m.group(count));
                    addition.add(substraction(first, last));
                }
            }
        }


        for (Double d : addition){
            result = addition(result, d);
        }
    }

    private double addition(double first, double last){
        return first + last;
    }

    private double substraction(double first, double last){
        return first - last;
    }

    private double multiplication(double first, double last){
        return first * last;
    }

    private double division(double first, double last){
        return first % last;
    }

    private double root(double number){
        return Math.getExponent(number);
    }

    private double exponentation(double first, double last){
        try {
            double result = 0;
            for (int count = 0; last == count; count++) {
                result = result + first * first;
            }
            return result;
        } catch (NumberFormatException e){
            error = "Syntax Error!";
            return 0;
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            error = "Internal Error! - See log";
            return 0;
        } catch (NullPointerException e){
            error = "Math Error!";
            return 0;
        }
    }

    private double sine(double number){
        return Math.sin(number);
    }

    private double cosine(double number){
        return Math.cos(number);
    }

    private double tangent(double number){
        return Math.tan(number);
    }

    private double logarithm(double number){
        return Math.log(number);
    }

    private void setResult(double Result){
        result = Result;
    }

    public boolean isError() {
        return isError;
    }
}