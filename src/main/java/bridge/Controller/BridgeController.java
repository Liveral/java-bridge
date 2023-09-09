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
    public BridgeController() {

    }

    public void bridgeMake(){
        String bridgeSize=inputView.readBridgeSize();
        bridgeValidateCheck(bridgeSize); //다리 길이 입력값 예외처리
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeNumberGenerator);
        bridge.setBridgeLength(Integer.parseInt(bridgeSize));
        bridge.setMadeBridge(bridgeMaker.makeBridge(Integer.parseInt(bridgeSize)));
    }

    public void bridgeValidateCheck(String input){
        try {
            BridgeControllerException.numberCheck(input);
            BridgeControllerException.rangeCheck(input);
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}
