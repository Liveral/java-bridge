package bridge.Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BridgeControllerExceptionTest {
    @DisplayName("입력받은 다리의 길이가 숫자 형식이 아니면 예외처리")
    @Test
    void 예외_테스트1() {
        Assertions.assertThrows(NumberFormatException.class,()->{
            BridgeControllerException.rangeCheck("3a");
        });

    }
    @DisplayName("입력받은 다리의 길이가 3이상 20이하의 범위를 벗어날 때")
    @Test
    void 예외_테스트2() {
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            BridgeControllerException.rangeCheck("2");
        });
    }

    @DisplayName("입력받은 이동할 칸이 U또는 D로 입력되지 않았다면 예외처리")
    @Test
    void 예외_테스트3() {
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            BridgeControllerException.alphabetCheck("u");
        });

    }
}