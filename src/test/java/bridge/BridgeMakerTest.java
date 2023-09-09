package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    private BridgeNumberGenerator bridgeNumberGenerator;

    @DisplayName("랜덤으로 받은 숫자들로 원하는 다리가 완성되는지 테스트")
    @Test
    void 다리완성_테스트(){
        bridgeNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge=bridgeMaker.makeBridge(3);
        for(String s : bridge){
            System.out.println(s);
        }
    }
}