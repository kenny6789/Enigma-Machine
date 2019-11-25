/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigmamessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author OEM
 */
public class EnigmaMessage {

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
    String ROTOR1[][] = {{"A", "Z", "1"}, {"J", "H", "2"}, {"M", "Q", "3"}, {"O", "T", "4"}, {"L", "C", "5"}, {"P", "K", "6"}, {"U", "M", "7"}, {"E", "U", "8"}, {"Q", "D", "9"}, {"V", "W", "10"}, {"F", "I", "11"}, {"S", "R", "12"}, {"W", "B", "13"}, {"D", "X", "14"}, {"X", "G", "15"}, {"K", "J", "16"}, {"Y", "P", "17"}, {"G", "A", "18"}, {"N", "F", "19"}, {"I", "L", "20"}, {"C", "Y", "21"}, {"T", "O", "22"}, {"H", "S", "23"}, {"R", "V", "24"}, {"Z", "N", "25"}, {"B", "E", "26"}};
    String ROTOR2[][] = {{"D", "E", "1"}, {"M", "G", "2"}, {"O", "U", "3"}, {"B", "C", "4"}, {"I", "J", "5"}, {"L", "Q", "6"}, {"H", "B", "7"}, {"R", "V", "8"}, {"A", "F", "9"}, {"J", "X", "10"}, {"V", "S", "11"}, {"N", "Y", "12"}, {"F", "A", "13"}, {"U", "P", "14"}, {"Z", "D", "15"}, {"C", "Z", "16"}, {"E", "H", "17"}, {"Y", "I", "18"}, {"G", "W", "19"}, {"S", "N", "20"}, {"K", "L", "21"}, {"W", "R", "22"}, {"Q", "T", "23"}, {"X", "M", "24"}, {"T", "O", "25"}, {"P", "K", "26"}};
    String ROTOR3[][] = {{"B", "C", "1"}, {"I", "K", "2"}, {"C", "Z", "3"}, {"D", "I", "4"}, {"H", "D", "5"}, {"Z", "R", "6"}, {"J", "T", "7"}, {"A", "S", "8"}, {"P", "J", "9"}, {"N", "A", "10"}, {"U", "M", "11"}, {"F", "P", "12"}, {"T", "V", "13"}, {"M", "B", "14"}, {"W", "Y", "15"}, {"E", "L", "16"}, {"Q", "X", "17"}, {"Y", "E", "18"}, {"L", "U", "19"}, {"X", "F", "20"}, {"V", "W", "21"}, {"O", "G", "22"}, {"R", "O", "23"}, {"S", "N", "24"}, {"K", "Q", "25"}, {"G", "H", "26"}};
    String REFLECTOR[][] = {{"A", "1"}, {"J", "2"}, {"F", "3"}, {"B", "4"}, {"H", "5"}, {"D", "6"}, {"C", "7"}, {"E", "8"}, {"L", "9"}, {"G", "10"}, {"M", "11"}, {"K", "12"}, {"I", "13"}, {"F", "14"}, {"C", "15"}, {"L", "16"}, {"K", "17"}, {"D", "18"}, {"I", "19"}, {"M", "20"}, {"A", "21"}, {"G", "22"}, {"J", "23"}, {"B", "24"}, {"E", "25"}, {"H", "26"}};
    String ALPHABET[][] = {{"A", "1"}, {"B", "2"}, {"C", "3"}, {"D", "4"}, {"E", "5"}, {"F", "6"}, {"G", "7"}, {"H", "8"}, {"I", "9"}, {"J", "10"}, {"K", "11"}, {"L", "12"}, {"M", "13"}, {"N", "14"}, {"O", "15"}, {"P", "16"}, {"Q", "17"}, {"R", "18"}, {"S", "19"}, {"T", "20"}, {"U", "21"}, {"V", "22"}, {"W", "23"}, {"X", "24"}, {"Y", "25"}, {"Z", "26"}};
    String PLUGBOARD[][] = {{"Z", "W"}, {"J", "Y"}, {"C", "X"}, {"A", "F"}, {"V", "E"}, {"U", "D"}, {"T", "S"}, {"H", "M"}, {"R", "I"}, {"B", "Q"}, {"P", "K"}, {"O", "L"}, {"N", "G"}};
    
    
    //This is the main method of the program.
    
    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);

        //EnigmaMessage encrypted = new EnigmaMessage();
        //encrypted.generateEncryptedLetter("Hello Everyone, My name is Kenny. I love Computer and Science. I graduated Master of Computing in 2019", "D", "O", "G",1,3,2);
//encrypted.generateEncryptedLetter("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ", "Z", "B", "G",1,2,3);
        //EnigmaMessage decode = new EnigmaMessage();
        //decode.generateEncryptedLetter("Kzsck Wsazdtgn, Ev pmav fk Erwii. F hdnw Qwbgkspm eoz Ffladry. Z jwgscpevg Jfjyou bu Udwgvjxuf oi 2019", "D", "O", "G",1,3,2);
//decode.generateEncryptedLetter("BXIAAJIZLMEASHBDWBIQYCGODHRJRBXMYCDHLNXCNSKHJMNXCFIINFAOWUZPSYHTBMGOUZIKPPUBROHYVJNIWEZQPBFMAORXZFXZSZTDCRJHQUHIJZDZQYPQIPASRSZKEQKIOIQMHCJCUZFDAJREGDIFZDJKDCKQUPKLELJHNJTXTGQWPRJROEEKMSJGAPYVBMYFKYCWLFPZMUXDDCOIRRUJGCADPAXIAQQFIZXTNDQPZCDVITLXOMAHJDHOIIHITULFJWVJLIPAWQIJQBPWZMJAFICLGFMGDTBYIPLOUGQWPVYTKDEQQQKRBXGKZRDUPRGTSOBFAVHOYCKGFHGSRBRWULGHYQAZJNHUGIGMTOUNWZENKEHSJANBNHTDWFNRDAZNWMVODTBMZCSOMYIVFCNZHEZQQGRRBXULMTLYTBBBBXGGJQVUKCFBNHCRZCIYFEUXDREYWQWOFNOMSQLNJWPMWJWIZGAWOBRWIITWQYDTAYVOJHQQVQFZRZUPLMGKHBGXCGHIRJLFXVFIUINAXINEILJMPXOMQIWZBWJWYPDEYYRFHYKMNENBLFGGBXVJGIBZRQSNJEDRUHJQTCULIHPTPMPNANYGZQYZKNPNTNOYAZBYOVZCBBXSKXNRQIPEDOWLWAOPLMCRIAADVQFMMYTKZHVABECXIDZIKIGKXESNQRAYXONFTGTEDYMTOYBXTEWBBVRTPSDRCLSFZLRCENWHSMXYSBWUZFGVULLBMPALQXAVEIJWMSUDHWJVMFUBLWVCLKSBZRVGLHHPXQLZTSNUXPNMJEIQGFNOJKLHJHUBTBMZDISYBQFSWLYDNRCXEKZCZKBDRXDTUYLQCOHOATKGLBIUFUHSRUHUGTKVICYQHVZHRGNWLHZCLDMBBXTQNZTNZOGPMUNALUEKSGTQQAAKCJEPWMCPAYQQQVERDCZCXXIILXZAXJNXIOPNORHSLEMGMSZJSXQVFWOGRUENLXEXKDBIKIMSTEEICVAKIUFTIQLYDKATNJMGHPMTWUZSGNEGWUEHPXEQQVIR", "Z", "B", "G",1,2,3);
//decode.generateEncryptedLetter("BXIAAJIZLMEASHBDWBIQYCGODHRJRBXMYCDHLNXCNSKHJMNXCFIINFAOWUZPSYHTBMGOUZIKPPUBROHYVJNIWEZQPBFMAORXZFXZSZTDCRJHQUHIJZDZQYPQIPASRSZKEQKIOIQMHCJCUZFDAJREGDIFZDJKDCKQUPKLELJHNJTXTGQWPRJROEEKMSJGAPYVBMYFKYCWLFPZMUXDDCOIRRUJGCADPAXIAQQFIZXTNDQPZCDVITLXOMAHJDHOIIHITULFJWVJLIPAWQIJQBPWZMJAFICLGFMGDTBYIPLOUGQWPVYTKDEQQQKRBXGKZRDUPRGTSOBFAVHOYCKGFHGSRBRWULGHYQAZJNHUGIGMTOUNWZENKEHSJANBNHTDWFNRDAZNWMVODTBMZCSOMYIVFCNZHEZQQGRRBXULMTLYTBBBBXGGJQVUKCFBNHCRZCIYFEUXDREYWQWOFNOMSQLNJWPMWJWIZGAWOBRWIITWQYDTAYVOJHQQVQFZRZUPLMGKHBGXCGHIRJLFXVFIUINAXINEILJMPXOMQIWZBWJWYPDEYYRFHYKMNENBLFGGBXVJGIBZRQSNJEDRUHJQTCULIHPTPMPNANYGZQYZKNPNTNOYAZBYOVZCBBXSKXNRQIPEDOWLWAOPLMCRIAADVQFMMYTKZHVABECXIDZIKIGKXESNQRAYXONFTGTEDYMTOYBXTEWBBVRTPSDRCLSFZLRCENWHSMXYSBWUZFGVULLBMPALQXAVEIJWMSUDHWJVMFUBLWVCLKSBZRVGLHHPXQLZTSNUXPNMJEIQGFNOJKLHJHUBTBMZDISYBQFSWLYDNRCXEKZCZKBDRXDTUYLQCOHOATKGLBIUFUHSRUHUGTKVICYQHVZHRGNWLHZCLDMBBXTQNZTNZOGPMUNALUEKSGTQQAAKCJEPWMCPAYQQQVERDCZCXXIILXZAXJNXIOPNORHSLEMGMSZJSXQVFWOGRUENLXEXKDBIKIMSTEEICVAKIUFTIQLYDKATNJMGHPMTWUZSGNEGWUEHPXEQQVIR", "Z", "B", "G",1,2,3);    
//////decode.generateEncryptedLetter("BXIAAJIZLMEASHBDWBIQYCGODHRJRBXMYCDHLNXCNSKHJMNXCFIINFAOWUZPSYHTBMGOUZIKPPUBROHYVJNIWEZQPBFMAORXZFXZSZTDCRJHQUHIJZDZQYPQIPASRSZKEQKIOIQMHCJCUZFDAJREGDIFZDJKDCKQUPKLELJHNJTXTGQWPRJROEEKMSJGAPYVBMYFKYCWLFPZMUXDDCOIRRUJGCADPAXIAQQFIZXTNDQPZCDVITLXOMAHJDHOIIHITULFJWVJLIPAWQIJQBPWZMJAFICLGFMGDTBYIPLOUGQWPVYTKDEQQQKRBXGKZRDUPRGTSOBFAVHOYCKGFHGSRBRWULGHYQAZJNHUGIGMTOUNWZENKEHSJANBNHTDWFNRDAZNWMVODTBMZCSOMYIVFCNZHEZQQGRRBXULMTLYTBBBBXGGJQVUKCFBNHCRZCIYFEUXDREYWQWOFNOMSQLNJWPMWJWIZGAWOBRWIITWQYDTAYVOJHQQVQFZRZUPLMGKHBGXCGHIRJLFXVFIUINAXINEILJMPXOMQIWZBWJWYPDEYYRFHYKMNENBLFGGBXVJGIBZRQSNJEDRUHJQTCULIHPTPMPNANYGZQYZKNPNTNOYAZBYOVZCBBXSKXNRQIPEDOWLWAOPLMCRIAADVQFMMYTKZHVABECXIDZIKIGKXESNQRAYXONFTGTEDYMTOYBXTEWBBVRTPSDRCLSFZLRCENWHSMXYSBWUZFGVULLBMPALQXAVEIJWMSUDHWJVMFUBLWVCLKSBZRVGLHHPXQLZTSNUXPNMJEIQGFNOJKLHJHUBTBMZDISYBQFSWLYDNRCXEKZCZKBDRXDTUYLQCOHOATKGLBIUFUHSRUHUGTKVICYQHVZHRGNWLHZCLDMBBXTQNZTNZOGPMUNALUEKSGTQQAAKCJEPWMCPAYQQQVERDCZCXXIILXZAXJNXIOPNORHSLEMGMSZJSXQVFWOGRUENLXEXKDBIKIMSTEEICVAKIUFTIQLYDKATNJMGHPMTWUZSGNEGWUEHPXEQQVIR", "Z", "B", "G",1,2,3);
    }

    public ArrayList generateEncryptedLetter(String str, String r1Setup, String r2Setup, String r3Setup, int rotorNumber1, int rotorNumber2, int rotorNumber3) {
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
                
                encrypted.add(reflectedAlphabet);
                increase1ForEveryNewInputInR2++;
                result += reflectedAlphabet;
            }
        }
        System.out.println(result);
        return encrypted;
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

