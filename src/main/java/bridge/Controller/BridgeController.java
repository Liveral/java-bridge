package bridge.Controller;

import bridge.BridgeGame;
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
    BridgeGame bridgeGame=new BridgeGame();
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
        String a=bridge.getMadeBridge().get(0);
    }



    public void compare(){

    }
}
