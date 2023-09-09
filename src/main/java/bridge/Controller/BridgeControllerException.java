package bridge.Controller;

import bridge.Constants;

import java.lang.invoke.ConstantBootstraps;

public class BridgeControllerException {

    public static void numberCheck(String inputString){ //입력받은 string이 숫자형식인지 체크하는 함수
        try {
            Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 다리 길이는 숫자 형식이어야 합니다.");
        }
    }

    public static void rangeCheck(String inputString){
        int inputNumber=Integer.parseInt(inputString);
        if(inputNumber< Constants.BRIDGE_MIN_NUMBER||inputNumber>Constants.BRIDGE_MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
