package bridge.Controller;

import bridge.Constants;

import java.lang.invoke.ConstantBootstraps;

public class BridgeControllerException {

    public static void bridgeValidateCheck(String input){
        try {
            numberCheck(input);
            rangeCheck(input);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public static void numberCheck(String inputString){ //입력받은 string이 숫자형식인지 체크하는 함수
        try {
            Double.parseDouble(inputString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자 형식이어야 합니다.");
        }
    }

    public static void rangeCheck(String inputString){ //입력받은 숫자가 범위조건을 만족하는지 체크하는 함수
        int inputNumber=Integer.parseInt(inputString);
        if(inputNumber< Constants.BRIDGE_MIN_NUMBER||inputNumber>Constants.BRIDGE_MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void movingValidateCheck(String input){
        try {
            movingAlphabetCheck(input);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public static void movingAlphabetCheck(String inputString){
        if(!inputString.equals("D")&&!inputString.equals("U")){
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D로 입력해주세요");
        }
    }

    public static void retryValidateCheck(String input){
        try {
            retryAlphabetCheck(input);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public static void retryAlphabetCheck(String inputString){
        if(!inputString.equals("R")&&!inputString.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 게임 재시도 여부는 R또는 Q로 입력해주세요");
        }
    }
}
