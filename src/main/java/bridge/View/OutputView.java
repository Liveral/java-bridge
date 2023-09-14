package bridge.View;

import bridge.Model.Bridge;
import bridge.ResultEnum;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String LEFT_WALL="[ ";
    private final String RIGHT_WALL=" ]";
    private final String DIVIDE_WALL=" | ";
    private final String MOVE_SUCCESS="O";
    private final String MOVE_FAIL="X";

    private final String SUCCESS_MESSAGE="게임 성공 여부 : 성공";
    private final String FAIL_MESSAGE="게임 성공 여부 : 실패";
    private final String TRIAL_NUMBER_MESSAGE="총 시도한 횟수: ";

    public OutputView() {
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBridge, List<String> downBridge) {
        System.out.print(LEFT_WALL);
        System.out.print(upBridge.get(0));
        additionPrint(upBridge);
        System.out.println(RIGHT_WALL);
        System.out.print(LEFT_WALL);
        System.out.print(downBridge.get(0));
        additionPrint(downBridge);
        System.out.println(RIGHT_WALL);
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result,int trialNumber) {
        System.out.print("게임 성공 여부: ");
        System.out.println(ResultEnum.valueOf(result).getResult());
        System.out.print("총 시도한 횟수: ");
        System.out.println(trialNumber);
    }
    public void printResultMessage(){
        System.out.println("최종 게임 결과");
    }

}
