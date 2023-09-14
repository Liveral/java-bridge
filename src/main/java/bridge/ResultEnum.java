package bridge;

public enum ResultEnum {
    O("성공"),
    X("실패");

    public String result;

    ResultEnum(String result) {
        this.result = result;
    }

    public String getResult(){
        return this.result;
    }
}
