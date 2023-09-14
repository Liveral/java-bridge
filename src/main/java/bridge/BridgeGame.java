package bridge;

import bridge.Controller.BridgeController;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    BridgeController bridgeController=new BridgeController();
    public BridgeGame() {
        try {
            bridgeController.bridgeMake(); // 입력받은 다리의 길이만큼 다리를 만들어주는 bridgeMake()를 호출해 다리 생성
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void playGame(){
        bridgeController.addTrialNum();
        playerMove(); //사용자는 게임이 종료될때까지 움직인다.
        bridgeController.printGameResult();

    }
    public void playerMove(){
        while(true){
            move();
            print();
            if(bridgeController.isFail()){
                retry();
                break;
            }
            if(bridgeController.isSuccess()){
                break;
            }
        }
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {

        bridgeController.userMove();

    }
    public void print(){
        bridgeController.printBridge();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if(bridgeController.getRetry()){ //사용자가 R을 입력해 재시작을 원할 경우
            bridgeController.clearResult();
            bridgeController.addTrialNum();
            playerMove();
        }

    }
}
