package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.Bridge;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    InputView inputView=new InputView();
    OutputView outputView=new OutputView();
    Bridge bridge=new Bridge();
    BridgeNumberGenerator bridgeNumberGenerator=new BridgeRandomNumberGenerator();
    private int trialNum=0;
    public BridgeController() {

    }

    public void bridgeMake(){
        String bridgeSize=inputView.readBridgeSize();
        BridgeControllerException.bridgeValidateCheck(bridgeSize); //다리 길이 입력값 예외처리
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeNumberGenerator);
        bridge.setBridgeLength(Integer.parseInt(bridgeSize));
        bridge.setMadeBridge(bridgeMaker.makeBridge(Integer.parseInt(bridgeSize)));
    }


    public void userMove(){
        String moving=inputView.readMoving();
        BridgeControllerException.movingValidateCheck(moving); //이동할 칸 입력값 예외처리
        compareToBridge(moving);
    }
    public void compareToBridge(String move){
        int moveIndex=bridge.getCheckIndex(); //이번에 사용자가 이동할 칸의 인덱스 값
        if(move.equals(bridge.getMadeBridge().get(moveIndex))){
           bridge.setCheckedBridge("O",move); //이동할 칸과 비교해서 같으면 통과를 뜻하는 "O"를 Bridge클래스의 setCheckedBridge에 전달한다.
            return;
        }
        bridge.setCheckedBridge("X",move); ////다르면 실패를 뜻하는 "X"를 Bridge클래스의 setCheckedBridge에 전달한다.
    }

    public void printBridge(){
        outputView.printMap(bridge.getCheckedUpBridge(), bridge.getCheckedDownBridge());
    }

    public String getLastResult(){ //결과 리스트의 마지막 결과를 가져온다.
        int lastIndex=bridge.getCheckIndex()-1; //가장 마지막으로 체크한 칸의 인덱스
        return bridge.getMadeBridge().get(lastIndex);
    }


    public boolean getRetry(){
        String retry=inputView.readGameCommand();
        BridgeControllerException.retryAlphabetCheck(retry);
        if(retry.equals("R")){
            return true;
        }
        return false;
    }
}
