package bridge.Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeControllerExceptionTest {
    @DisplayName("입력받은 다리의 길이가 숫자 형식이 아니면 예외처리")
    @Test
    void 예외_테스트1() {
        try {
            BridgeControllerException.numberCheck("5a");
        } catch (RuntimeException e) {
            Assertions.assertEquals("[ERROR] 다리 길이는 숫자 형식이어야 합니다.", e.getMessage());
        }

    }
    @DisplayName("입력받은 다리의 길이가 3이상 20이하의 범위를 벗어날 때")
    @Test
    void 예외_테스트2() {
        try {
            BridgeControllerException.rangeCheck("25");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.", e.getMessage());
        }

    }
}