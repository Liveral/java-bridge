package bridge;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge=new ArrayList<>();
        for (int i=0;i<size;i++){
            bridge.add(BridgeEnum.values()[bridgeNumberGenerator.generate()].getAlphabet()); //generate()에서 랜덤으로 받은 0또는 1을 이용해 Enum클래스에서 D 또는 U를 가져온다.
        }

        return bridge;
    }
}
