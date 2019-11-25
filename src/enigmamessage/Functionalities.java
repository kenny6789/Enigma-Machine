/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigmamessage;

import java.awt.TextArea;
import java.awt.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Spinner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author OEM
 */
public class Functionalities {

    String ROTOR1[][] = {{"A", "Z", "1"}, {"J", "H", "2"}, {"M", "Q", "3"}, {"O", "T", "4"}, {"L", "C", "5"}, {"P", "K", "6"}, {"U", "M", "7"}, {"E", "U", "8"}, {"Q", "D", "9"}, {"V", "W", "10"}, {"F", "I", "11"}, {"S", "R", "12"}, {"W", "B", "13"}, {"D", "X", "14"}, {"X", "G", "15"}, {"K", "J", "16"}, {"Y", "P", "17"}, {"G", "A", "18"}, {"N", "F", "19"}, {"I", "L", "20"}, {"C", "Y", "21"}, {"T", "O", "22"}, {"H", "S", "23"}, {"R", "V", "24"}, {"Z", "N", "25"}, {"B", "E", "26"}};
    String ROTOR2[][] = {{"D", "E", "1"}, {"M", "G", "2"}, {"O", "U", "3"}, {"B", "C", "4"}, {"I", "J", "5"}, {"L", "Q", "6"}, {"H", "B", "7"}, {"R", "V", "8"}, {"A", "F", "9"}, {"J", "X", "10"}, {"V", "S", "11"}, {"N", "Y", "12"}, {"F", "A", "13"}, {"U", "P", "14"}, {"Z", "D", "15"}, {"C", "Z", "16"}, {"E", "H", "17"}, {"Y", "I", "18"}, {"G", "W", "19"}, {"S", "N", "20"}, {"K", "L", "21"}, {"W", "R", "22"}, {"Q", "T", "23"}, {"X", "M", "24"}, {"T", "O", "25"}, {"P", "K", "26"}};
    String ROTOR3[][] = {{"B", "C", "1"}, {"I", "K", "2"}, {"C", "Z", "3"}, {"D", "I", "4"}, {"H", "D", "5"}, {"Z", "R", "6"}, {"J", "T", "7"}, {"A", "S", "8"}, {"P", "J", "9"}, {"N", "A", "10"}, {"U", "M", "11"}, {"F", "P", "12"}, {"T", "V", "13"}, {"M", "B", "14"}, {"W", "Y", "15"}, {"E", "L", "16"}, {"Q", "X", "17"}, {"Y", "E", "18"}, {"L", "U", "19"}, {"X", "F", "20"}, {"V", "W", "21"}, {"O", "G", "22"}, {"R", "O", "23"}, {"S", "N", "24"}, {"K", "Q", "25"}, {"G", "H", "26"}};
    String REFLECTOR[][] = {{"A", "1"}, {"J", "2"}, {"F", "3"}, {"B", "4"}, {"H", "5"}, {"D", "6"}, {"C", "7"}, {"E", "8"}, {"L", "9"}, {"G", "10"}, {"M", "11"}, {"K", "12"}, {"I", "13"}, {"F", "14"}, {"C", "15"}, {"L", "16"}, {"K", "17"}, {"D", "18"}, {"I", "19"}, {"M", "20"}, {"A", "21"}, {"G", "22"}, {"J", "23"}, {"B", "24"}, {"E", "25"}, {"H", "26"}};
    String ALPHABET[][] = {{"A", "1"}, {"B", "2"}, {"C", "3"}, {"D", "4"}, {"E", "5"}, {"F", "6"}, {"G", "7"}, {"H", "8"}, {"I", "9"}, {"J", "10"}, {"K", "11"}, {"L", "12"}, {"M", "13"}, {"N", "14"}, {"O", "15"}, {"P", "16"}, {"Q", "17"}, {"R", "18"}, {"S", "19"}, {"T", "20"}, {"U", "21"}, {"V", "22"}, {"W", "23"}, {"X", "24"}, {"Y", "25"}, {"Z", "26"}};
    int max = 26;
    int min = 0;
    int incrementToFindLeftValueInRotor1 = 0;
    int add1ToRotor2WhenReachMax = 0;
    int add1ToRotor3WhenReachMax = 0;
    int increase1ForEveryNewInputInR2 = 1;
    int increase1ForEveryNewInputInR3 = 0;
    int numberOfIncrementalForRotor2 = 0;
    int numberOfIncrementalForRotor3 = 0;
    int rotor1Setup = 0;
    int rotor2Setup = 0;
    int rotor3Setup = 0;
    int increase1R3 = 0;
    public String name;
    public String PLUGBOARD[][];
    
    Messages message = new Messages();
    
    public Functionalities(String n){
        name = n;
    }
    public Functionalities(){
    }
    public Functionalities(String PB[][])
    {
        PLUGBOARD = PB;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }
    public void clearSetting(){
        max = 26;
        min = 0;
        incrementToFindLeftValueInRotor1 = 0;
        add1ToRotor2WhenReachMax = 0;
        add1ToRotor3WhenReachMax = 0;
        increase1ForEveryNewInputInR2 = 1;
        increase1ForEveryNewInputInR3 = 0;
        numberOfIncrementalForRotor2 = 0;
        numberOfIncrementalForRotor3 = 0;
        rotor1Setup = 0;
        rotor2Setup = 0;
        rotor3Setup = 0;
        increase1R3 = 0;
    }
    public int returnRotorOrder(JSpinner rotor){
        int value = 0;
        value = Integer.valueOf(String.valueOf(rotor.getValue()));
        return value;
    }
    
    protected ArrayList generateRandomRotor() {
        ArrayList list = new ArrayList();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int counter = 0;
        Random rnd = new Random();
        while (counter < alphabet.length()) {
            String temp = String.valueOf(alphabet.charAt(rnd.nextInt(26)));
            if (!list.contains(temp)) {
                list.add(temp);
                counter++;
            }
            if (counter == 26) {
                break;
            }
        }
        return list;
    }
    public void load(ArrayList list,TextField txfP1, TextField txfP2, TextField txfP3, TextField txfP4, TextField txfP5, TextField txfP6, TextField txfP7, TextField txfP8, TextField txfP9, TextField txfP10, TextField txfP11, TextField txfP12, TextField txfP13, TextField txfP14, TextField txfP15, TextField txfP16, TextField txfP17, TextField txfP18, TextField txfP19, TextField txfP20, TextField txfP21, TextField txfP22, TextField txfP23, TextField txfP24, TextField txfP25, TextField txfP26){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter fileName = new FileNameExtensionFilter("Text File", "txt");
        chooser.setFileFilter(fileName);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                String myPlugBoardPath = chooser.getSelectedFile().toString();
                File file = new File(myPlugBoardPath);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    list.add(scanner.nextLine());
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ArrayList getPlugBoard = getGroupPlugBoard(txfP1, txfP2, txfP3, txfP4, txfP5, txfP6, txfP7, txfP8, txfP9, txfP10, txfP11, txfP12, txfP13, txfP14, txfP15, txfP16, txfP17, txfP18, txfP19, txfP20, txfP21, txfP22, txfP23, txfP24, txfP25, txfP26);
        for (int i = 0; i < list.size(); i++) {
            for (int z = 0; z < getPlugBoard.size(); z++) {
                if (i == z) {
                    TextField txf = (TextField) getPlugBoard.get(z);
                    txf.setText((String) list.get(i));
                    
                }
            }
        }
    }
    protected ArrayList groupAllTextFieldInPlugBoard(TextField txt1, TextField txt2, TextField txt3, TextField txt4, TextField txt5, TextField txt6, TextField txt7, TextField txt8, TextField txt9, TextField txt10, TextField txt11, TextField txt12, TextField txt13, TextField txt14, TextField txt15, TextField txt16, TextField txt17, TextField txt18, TextField txt19, TextField txt20, TextField txt21, TextField txt22, TextField txt23, TextField txt24, TextField txt25, TextField txt26) {
        ArrayList<TextField> list = new ArrayList<>();
        list.add(txt1);
        list.add(txt2);
        list.add(txt3);
        list.add(txt4);
        list.add(txt5);
        list.add(txt6);
        list.add(txt7);
        list.add(txt8);
        list.add(txt9);
        list.add(txt10);
        list.add(txt11);
        list.add(txt12);
        list.add(txt13);
        list.add(txt14);
        list.add(txt15);
        list.add(txt16);
        list.add(txt17);
        list.add(txt18);
        list.add(txt19);
        list.add(txt20);
        list.add(txt21);
        list.add(txt22);
        list.add(txt23);
        list.add(txt24);
        list.add(txt25);
        list.add(txt26);
        //System.out.println(list.toString());
        return list;
    }
    
    public void plugBoardDefaultSetting(ArrayList list, TextField txt1, TextField txt2, TextField txt3, TextField txt4, TextField txt5, TextField txt6, TextField txt7, TextField txt8, TextField txt9, TextField txt10, TextField txt11, TextField txt12, TextField txt13, TextField txt14, TextField txt15, TextField txt16, TextField txt17, TextField txt18, TextField txt19, TextField txt20, TextField txt21, TextField txt22, TextField txt23, TextField txt24, TextField txt25, TextField txt26) {
        list.add(txt1.getText());
        list.add(txt2.getText());
        list.add(txt3.getText());
        list.add(txt4.getText());
        list.add(txt5.getText());
        list.add(txt6.getText());
        list.add(txt7.getText());
        list.add(txt8.getText());
        list.add(txt9.getText());
        list.add(txt10.getText());
        list.add(txt11.getText());
        list.add(txt12.getText());
        list.add(txt13.getText());
        list.add(txt14.getText());
        list.add(txt15.getText());
        list.add(txt16.getText());
        list.add(txt17.getText());
        list.add(txt18.getText());
        list.add(txt19.getText());
        list.add(txt20.getText());
        list.add(txt21.getText());
        list.add(txt22.getText());
        list.add(txt23.getText());
        list.add(txt24.getText());
        list.add(txt25.getText());
        list.add(txt26.getText());
        //System.out.println(list.toString());
    }
    
    public void checkPlugBoardIsFilled(ArrayList list,JTextArea ta){
        if(list.size() < max){
            JOptionPane.showMessageDialog(null, "Please make sure the plugboard is filled", "PlugBoard is not filled properly", 0);
            ta.setText("");
        }
    }
    
    public ArrayList getGroupPlugBoard(TextField txfP1, TextField txfP2, TextField txfP3, TextField txfP4, TextField txfP5, TextField txfP6, TextField txfP7, TextField txfP8, TextField txfP9, TextField txfP10, TextField txfP11, TextField txfP12, TextField txfP13, TextField txfP14, TextField txfP15, TextField txfP16, TextField txfP17, TextField txfP18, TextField txfP19, TextField txfP20, TextField txfP21, TextField txfP22, TextField txfP23, TextField txfP24, TextField txfP25, TextField txfP26)
    {
        ArrayList list = new ArrayList();
        list = groupAllTextFieldInPlugBoard(txfP1, txfP2, txfP3, txfP4, txfP5, txfP6, txfP7, txfP8, txfP9, txfP10, txfP11, txfP12, txfP13, txfP14, txfP15, txfP16, txfP17, txfP18, txfP19, txfP20, txfP21, txfP22, txfP23, txfP24, txfP25, txfP26);
        return list;
    } 
    
    public void addCurrentPlugboardToList(ArrayList list, TextField txfP1, TextField txfP2, TextField txfP3, TextField txfP4, TextField txfP5, TextField txfP6, TextField txfP7, TextField txfP8, TextField txfP9, TextField txfP10, TextField txfP11, TextField txfP12, TextField txfP13, TextField txfP14, TextField txfP15, TextField txfP16, TextField txfP17, TextField txfP18, TextField txfP19, TextField txfP20, TextField txfP21, TextField txfP22, TextField txfP23, TextField txfP24, TextField txfP25, TextField txfP26)
    {
       ArrayList groupPlugBoard = getGroupPlugBoard(txfP1, txfP2, txfP3, txfP4, txfP5, txfP6, txfP7, txfP8, txfP9, txfP10, txfP11, txfP12, txfP13, txfP14, txfP15, txfP16, txfP17, txfP18, txfP19, txfP20, txfP21, txfP22, txfP23, txfP24, txfP25, txfP26);
       for(int i = 0; i < groupPlugBoard.size();i++){
           String temp = groupPlugBoard.get(i).toString();
           temp = temp.replaceAll("\\d","").substring(55, 56); // remove all the numerics and get only texts
           list.add(temp);
       }
    }
    
    public void enterManually(ArrayList list, TextField txfP1, TextField txfP2, TextField txfP3, TextField txfP4, TextField txfP5, TextField txfP6, TextField txfP7, TextField txfP8, TextField txfP9, TextField txfP10, TextField txfP11, TextField txfP12, TextField txfP13, TextField txfP14, TextField txfP15, TextField txfP16, TextField txfP17, TextField txfP18, TextField txfP19, TextField txfP20, TextField txfP21, TextField txfP22, TextField txfP23, TextField txfP24, TextField txfP25, TextField txfP26)
    {
        list.clear();
        ArrayList groupPlugBoard = getGroupPlugBoard(txfP1, txfP2, txfP3, txfP4, txfP5, txfP6, txfP7, txfP8, txfP9, txfP10, txfP11, txfP12, txfP13, txfP14, txfP15, txfP16, txfP17, txfP18, txfP19, txfP20, txfP21, txfP22, txfP23, txfP24, txfP25, txfP26);
        for(int i = 0; i < groupPlugBoard.size(); i++){
            TextField txtTemp = (TextField) groupPlugBoard.get(i);
            txtTemp.setText("");
            txtTemp.setEnabled(true);
        }
    }
    public void save(ArrayList list) throws Exception{
        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Specify a file to save");
        int userSelection = filechooser.showSaveDialog(filechooser);
        if(userSelection == JFileChooser.APPROVE_OPTION)
        {
            File fileToSave = filechooser.getSelectedFile();
            FileWriter writer = new FileWriter(fileToSave.getAbsolutePath());
            for(int i = 0; i < list.size();i++)
            {
                String temp = String.valueOf(list.get(i));
                writer.write(temp);
                writer.write('\n');
            }
            writer.close();
        }
    }
    public void generateRandomly(TextField txfP1, TextField txfP2, TextField txfP3, TextField txfP4, TextField txfP5, TextField txfP6, TextField txfP7, TextField txfP8, TextField txfP9, TextField txfP10, TextField txfP11, TextField txfP12, TextField txfP13, TextField txfP14, TextField txfP15, TextField txfP16, TextField txfP17, TextField txfP18, TextField txfP19, TextField txfP20, TextField txfP21, TextField txfP22, TextField txfP23, TextField txfP24, TextField txfP25, TextField txfP26){
        ArrayList groupPlugBoard = getGroupPlugBoard(txfP1, txfP2, txfP3, txfP4, txfP5, txfP6, txfP7, txfP8, txfP9, txfP10, txfP11, txfP12, txfP13, txfP14, txfP15, txfP16, txfP17, txfP18, txfP19, txfP20, txfP21, txfP22, txfP23, txfP24, txfP25, txfP26);
        ArrayList list = generateRandomRotor();
        for(int i = 0; i < groupPlugBoard.size(); i++)
        {
            TextField txtTemp = (TextField) groupPlugBoard.get(i);
            for (int z = 0; z < list.size(); z++) {
                if(i == z){
                    txtTemp.setText((String) list.get(z));
                    break;
                }
            }
            txtTemp.setEnabled(false);
        }
    }
    
    public String[][] createPairOfLetter(ArrayList list, String PLUGBOARD[][]) {

        for (int i = 0; i < list.size(); i++) {
            switch (i) {
                case 0:
                    PLUGBOARD[0][0] = (String) list.get(i);
                case 1:
                    PLUGBOARD[0][1] = (String) list.get(i);
                case 2:
                    PLUGBOARD[1][0] = (String) list.get(i);
                case 3:
                    PLUGBOARD[1][1] = (String) list.get(i);
                case 4:
                    PLUGBOARD[2][0] = (String) list.get(i);
                case 5:
                    PLUGBOARD[2][1] = (String) list.get(i);
                case 6:
                    PLUGBOARD[3][0] = (String) list.get(i);
                case 7:
                    PLUGBOARD[3][1] = (String) list.get(i);
                case 8:
                    PLUGBOARD[4][0] = (String) list.get(i);
                case 9:
                    PLUGBOARD[4][1] = (String) list.get(i);
                case 10:
                    PLUGBOARD[5][0] = (String) list.get(i);
                case 11:
                    PLUGBOARD[5][1] = (String) list.get(i);
                case 12:
                    PLUGBOARD[6][0] = (String) list.get(i);
                case 13:
                    PLUGBOARD[6][1] = (String) list.get(i);
                case 14:
                    PLUGBOARD[7][0] = (String) list.get(i);
                case 15:
                    PLUGBOARD[7][1] = (String) list.get(i);
                case 16:
                    PLUGBOARD[8][0] = (String) list.get(i);
                case 17:
                    PLUGBOARD[8][1] = (String) list.get(i);
                case 18:
                    PLUGBOARD[9][0] = (String) list.get(i);
                case 19:
                    PLUGBOARD[9][1] = (String) list.get(i);
                case 20:
                    PLUGBOARD[10][0] = (String) list.get(i);
                case 21:
                    PLUGBOARD[10][1] = (String) list.get(i);
                case 22:
                    PLUGBOARD[11][0] = (String) list.get(i);
                case 23:
                    PLUGBOARD[11][1] = (String) list.get(i);
                case 24:
                    PLUGBOARD[12][0] = (String) list.get(i);
                case 25:
                    PLUGBOARD[12][1] = (String) list.get(i);
            }
        }
        return PLUGBOARD;
    }
    
        public String generateEncryptedLetter(String str, String r1Setup, String r2Setup, String r3Setup, int rotorNumber1, int rotorNumber2, int rotorNumber3) {
        ArrayList encrypted = new ArrayList();
        String result = "";
        rotor1Setup = getRotorSetupLocation(r1Setup, rotorNumber1);
        rotor2Setup = getRotorSetupLocation(r2Setup, rotorNumber2);
        rotor3Setup = getRotorSetupLocation(r3Setup, rotorNumber3);
        int indexOfInput = 0;
        int leftIndexRotor1 = 0;
        for (int i = 0; i < str.length(); i++) {
            String input = String.valueOf(str.charAt(i));
            Boolean isUpperCase = Character.isUpperCase(str.charAt(i));
            if (!input.matches("^[a-zA-Z]*$")) {
                encrypted.add(input);
                result += input;
            } else {
                input = swapLetter(input); // swap the input to a different letter based on the plugboard setting.
                indexOfInput = findSwappedInputIndex(input);
                leftIndexRotor1 = makeSureNotInvalidNumber((indexOfInput + rotor1Setup) + incrementToFindLeftValueInRotor1);
                numberOfIncrementalForRotor2 = increase1ForRotor2WhenRotor1ReachMax();
                numberOfIncrementalForRotor3 = increase1ForRotor3WhenRotor2ReachMax();

                String leftValueRotor1 = findValueOfRotor1(leftIndexRotor1, 0);
                String rightValueRotor1 = find2ndValueOrIndex(leftValueRotor1, ROTOR1, 1,"letter");
                int indexOfRightValueRotor1 = Integer.valueOf(find2ndValueOrIndex(rightValueRotor1, ROTOR1, 1,"index"));
                incrementToFindLeftValueInRotor1++;
                updateRotor1Setup();

                //********************************Rotor2 starts here****************************
                int indexOfLeftValueR2 = makeSureNotInvalidNumber((indexOfRightValueRotor1 + (rotor2Setup + numberOfIncrementalForRotor2)) - (rotor1Setup + increase1ForEveryNewInputInR2));// formula to find left R2
                String leftValueRotor2 = findLeftValueOfR2andR3(indexOfLeftValueR2, ROTOR2);
                String rightValueRotor2 = find2ndValueOrIndex(leftValueRotor2, ROTOR2, 1,"letter");
                int indexOfRightValueRotor2 = Integer.valueOf(find2ndValueOrIndex(rightValueRotor2, ROTOR2, 1,"index"));
                updateRotor2Setup();

                //******************************Rotor3 starts here ******************************************
                updateRotor3Setup();
                
                int indexOfLeftValueR3 = makeSureNotInvalidNumber(((indexOfRightValueRotor2 + updateRotor3Setup()) - (rotor2Setup + increase1ForEveryNewInputInR3)) - numberOfIncrementalForRotor2);

                String leftValueRotor3 = findLeftValueOfR2andR3(indexOfLeftValueR3, ROTOR3);
                String rightValueRotor3 = find2ndValueOrIndex(leftValueRotor3, ROTOR3, 1,"letter");
                int indexOfRightValueRotor3 = Integer.valueOf(find2ndValueOrIndex(rightValueRotor3, ROTOR3, 1,"index"));

                //*****************************Reflector starts here ****************************************
                int reflectedKey = makeSureNotInvalidNumber((indexOfRightValueRotor3 - (rotor3Setup + numberOfIncrementalForRotor3)));
                String reflected1stLetter = findReflectedValue(reflectedKey, REFLECTOR);
                int reflected2ndLetterInIndex = find2ndReflectedValueAndReturnIndex(reflectedKey, reflected1stLetter, REFLECTOR);

                //*****************Reflected Rotor3************************
                int reflectedRightIndexR3 = makeSureNotInvalidNumber(reflected2ndLetterInIndex - (max - updateRotor3Setup()));
                String reflectedRightValueR3 = findReflectedRightValueOfR2AndR3(reflectedRightIndexR3, ROTOR3);
                String reflectedLeftValueR3 = find2ndValueOrIndex(reflectedRightValueR3, ROTOR3, 0,"letter");
                int reflectedLeftIndexR3 = Integer.valueOf(find2ndValueOrIndex(reflectedLeftValueR3, ROTOR3, 0,"index"));

                //***************************Reflected Rotor2**************************
                int reflectedIndexOfRightValueR2 = makeSureNotInvalidNumber((updateRotor2Setup() - updateRotor3Setup()) + reflectedLeftIndexR3);

                String reflectedRightValueR2 = findReflectedRightValueOfR2AndR3(reflectedIndexOfRightValueR2, ROTOR2);
                String reflectedLeftValueR2 = find2ndValueOrIndex(reflectedRightValueR2, ROTOR2, 0,"letter");
                int reflectedLeftIndexR2 = Integer.valueOf(find2ndValueOrIndex(reflectedLeftValueR2, ROTOR2, 0,"index"));

                //************************Reflected Rotor1*******************************
                int reflectedIndexOfRightValueR1 = makeSureNotInvalidNumber((updateRotor1Setup() - updateRotor2Setup()) + reflectedLeftIndexR2);
                String reflectedRightValueR1 = findReflectedRightValueOfR2AndR3(reflectedIndexOfRightValueR1, ROTOR1);
                String reflectedLeftValueR1 = find2ndValueOrIndex(reflectedRightValueR1, ROTOR1, 0,"letter");
                int reflectedLeftIndexR1 = Integer.valueOf(find2ndValueOrIndex(reflectedLeftValueR1, ROTOR1, 0,"index"));

                //*************************Reflected To Normal Alphabet
                int reflectedKeyAlphabet = makeSureNotInvalidNumber(reflectedLeftIndexR1 - (updateRotor1Setup() - 1));
                String reflectedAlphabet = findTheReflectedAlphabet(reflectedKeyAlphabet, ALPHABET);
                //System.out.println(reflectedAlphabet + isUpperCase);
                reflectedAlphabet = convertToLowerCase(reflectedAlphabet, isUpperCase);
                
                //encrypted.add(reflectedAlphabet);
                increase1ForEveryNewInputInR2++;
                result += reflectedAlphabet;
            }
        }
        //System.out.println(result);
        return result;
    }
    public String findTheReflectedAlphabet(int index, String[][] rotor) {
        String value = "";
        for (int i = 0; i < rotor.length; i++) {
            String[] elements = rotor[i];
            if (elements[1].equalsIgnoreCase(String.valueOf(index))) {
                value = swapLetter(elements[0]);
                break;
            }
        }
        return value;
    }

    public String findValueOfRotor1(int index, int column) {
        String value = "";
        for (int i = 0; i < ROTOR1.length; i++) {
            String[] elements = ROTOR1[i];
            if (elements[2].equalsIgnoreCase(String.valueOf(index))) {
                value = elements[column];
                break;
            }
        }
        return value;
    }
    public String findReflectedRightValueOfR2AndR3(int inputIndex, String[][] rotor) {
        String returnValue = "";
        for (int i = 0; i < rotor.length; i++) {
            String[] elements = rotor[i];
            if (elements[2].equalsIgnoreCase(String.valueOf(inputIndex))) {
                returnValue = elements[1];
            }
        }
        return returnValue;
    }

    public String findReflectedValue(int inputIndex, String[][] rotor) {
        String returnValue = "";
        for (int i = 0; i < rotor.length; i++) {
            String[] elements = rotor[i];
            if (elements[1].equalsIgnoreCase(String.valueOf(inputIndex))) {
                returnValue = elements[0];
                break;
            }
        }
        return returnValue;
    }
    public int find2ndReflectedValueAndReturnIndex(int inputIndex, String value, String[][] rotor) {
        int returnValue = 0;
        for (int i = 0; i < rotor.length; i++) {
            String[] elements = rotor[i];
            if (elements[0].equalsIgnoreCase(value)) {
                if (!elements[1].equalsIgnoreCase(String.valueOf(inputIndex))) {
                    returnValue = Integer.parseInt(elements[1]);
                    break;
                }
            }
        }
        return returnValue;
    }
    public String findLeftValueOfR2andR3(int inputIndex, String[][] rotor) {
        String returnValue = "";
        for (int i = 0; i < rotor.length; i++) {
            String[] elements = rotor[i];
            if (elements[2].equalsIgnoreCase(String.valueOf(inputIndex))) {
                returnValue = elements[0];
                break;
            }
        }
        return returnValue;
    }
    public String find2ndValueOrIndex(String str, String[][] rotor, int sideOfValue, String column) {
        String returnedValue = "";
        for (int i = 0; i < rotor.length; i++) {
            String[] elements = rotor[i];
            if (elements[sideOfValue].equalsIgnoreCase(str)) {
                if(column.equalsIgnoreCase("letter")){
                    returnedValue = elements[sideOfValue];
                }
                else{
                    returnedValue = elements[2];
                }
                break;
            }
        }
        return returnedValue;
    } 
    public int updateRotor1Setup(){

        int updateRotor1Setup = rotor1Setup + incrementToFindLeftValueInRotor1;
        while (updateRotor1Setup >= max) {
            updateRotor1Setup = updateRotor1Setup - max;
        }
        return updateRotor1Setup;
    }   
    public int updateRotor2Setup(){
        int updateRotor2Setup = rotor2Setup;
        updateRotor2Setup = rotor2Setup + numberOfIncrementalForRotor2;
        while (updateRotor2Setup > max) {
            updateRotor2Setup = updateRotor2Setup - max;
        }
        return updateRotor2Setup;
    }
    public int updateRotor3Setup(){
        int updateRotor3Setup = rotor3Setup + numberOfIncrementalForRotor3;
        while (updateRotor3Setup > max) {
            updateRotor3Setup = updateRotor3Setup - max;
        }
        return updateRotor3Setup;
    }
    public int increase1ForRotor2WhenRotor1ReachMax() {
        if (incrementToFindLeftValueInRotor1 == max) {
            numberOfIncrementalForRotor2++;
            incrementToFindLeftValueInRotor1 = 0;
        }
        return numberOfIncrementalForRotor2;
    }
    public int increase1ForRotor3WhenRotor2ReachMax() {
        if (numberOfIncrementalForRotor2 == max) {
            numberOfIncrementalForRotor3++;
            if (numberOfIncrementalForRotor3 == max) {
                numberOfIncrementalForRotor3 = 1;
            }
            numberOfIncrementalForRotor2 = 1;
        }
        return numberOfIncrementalForRotor3;
    }
    public int makeSureNotInvalidNumber(int index) {
        if (index == min) {
            index = max;
        }
        while (index < min) {
            index = index + max;
            if (index == min) {
                index = max;
            }
        }
        while (index > max) {
            index = index - max;
        }
        return index;
    }
    public int findSwappedInputIndex(String str) {
        int returnIndex = 0;
        for (int z = 0; z < ALPHABET.length; z++) {
            String[] inputIndex = ALPHABET[z];
            if (inputIndex[0].equalsIgnoreCase(str)) {
                returnIndex = Integer.valueOf(inputIndex[1]);
                break;
            }
        }
        return returnIndex;
    }
    public String swapLetter(String input) {
        String swappedLetter = "";
        for (int i = 0; i < PLUGBOARD.length; i++) {
            String[] elements = PLUGBOARD[i];
            Boolean elementIndex0 = elements[0].equalsIgnoreCase(input);
            Boolean elementIndex1 = elements[1].equalsIgnoreCase(input);;
            if (elementIndex0 || elementIndex1) {
                if (!elementIndex0) {
                    swappedLetter = elements[0];
                } else if (!elementIndex1) {
                    swappedLetter = elements[1];
                }
            }
        }
        return swappedLetter;
    }
    public int resetRotorWhenReachedMax(int currentPosition) {
        int reset = 0;
        if (currentPosition > max) {
            reset = 1;
        }
        return reset;
    }
    public int getRotorSetupLocation(String input, int rotorNumber) {
        int rotorSetupPosition = 0;
        String rotor[][] = {};
        switch (rotorNumber) {
            case 1:
                rotor = ROTOR1;
                break;
            case 2:
                rotor = ROTOR2;
                break;
            case 3:
                rotor = ROTOR3;
                break;
        }
        for (int i = 0; i < rotor.length; i++) {
            String[] elements = rotor[i];
            if (elements[0].equalsIgnoreCase(input)) {
                rotorSetupPosition = Integer.valueOf(elements[2]);
            }
        }
        return rotorSetupPosition;
    }
    public String convertToLowerCase(String text, Boolean upperCase){
        String toLowerCase = "";
        if(!upperCase){
            toLowerCase = text.toLowerCase();
        }
        else{
            toLowerCase = text;
        }
        return toLowerCase;
    }
}
