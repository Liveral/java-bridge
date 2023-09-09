package bridge;

public enum BridgeEnum {
    BRIDGE_UP("D"),
    BRIDGE_DOWN("U");

    public String bridgeAlphabet;

    BridgeEnum(String bridgeAlphabet) {
        this.bridgeAlphabet = bridgeAlphabet;
    }

    public String getAlphabet(){
        return this.bridgeAlphabet;
    }
}
