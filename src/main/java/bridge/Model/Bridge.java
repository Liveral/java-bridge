package bridge.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private int bridgeLength;
    private List<String> madeBridge; //랜덤으로 만들어진 다리

    private int checkIndex=0; // 사용자가 이번 차례에 이동하는 칸의 인덱스
    private List<String> checkedUpBridge=new ArrayList<>(); //위 칸의 이동 결과를 보관하는 리스트
    private List<String> checkedDownBridge=new ArrayList<>(); //아래 칸의 이동 결과를 보관하는 리스트
    

    public Bridge(){
    }

    public int getCheckIndex() {
        return checkIndex;
    }


    public int getBridgeLength() {
        return bridgeLength;
    }

    public void setBridgeLength(int bridgeLength) {
        this.bridgeLength = bridgeLength;
    }

    public List<String> getMadeBridge(){
        return this.madeBridge;
    }

    public void setMadeBridge(List<String> madeBridge) {
        this.madeBridge = madeBridge;
    }

    public List<String> getCheckedUpBridge() {
        return checkedUpBridge;
    }
    public List<String> getCheckedDownBridge() {
        return checkedDownBridge;
    }

    public void setCheckedBridge(String result,String move) {
        if(move.equals("U")){
            checkedUpBridge.add(result);
            checkedDownBridge.add(" ");
            checkIndex++;
            return;
        }
        checkedUpBridge.add(" ");
        checkedDownBridge.add(result);
        checkIndex++;
    }
    public void clearCheckedBridge(){ //게임이 다시시작되면 기존의 checkedBridge를 비워주기 위한 함수
        checkedUpBridge.clear();
        checkedDownBridge.clear();
        checkIndex=0;
    }
}
