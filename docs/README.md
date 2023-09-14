# 다리 건너기 게임

---

## 기능 구현

---

## Model 패키지

### Bridge 클래스

1. `setCheckedBridge()`

이동 후 결과를 저장할 `checkedUpBridge` 와 `checkedDownBridge` 리스트의 setter이다. 매개변수로 받은 결과가 U, 즉 위로 이동했다면 `checkedUpBridge` 에 result를 add하고 `checkedDownBridge` 에는 빈 칸을 add한다. 아래로 이동했다면 이것의 반대로 진행한다. 그리고 현재까지 체크된 인덱스를 확인하기 위한 변수 `checkIndex` 의 값을 1 올려준다.

1. `clearCheckedBridge()`

게임 재 시작시 저장된 결과를 비우는 메소드로 `checkedUpBridge` 와 `checkedUpBridge` 를 clear()로 비워주고 `checkIndex` 또한 0으로 바꿔준다.

1. `setMadeBridge()`

랜덤으로 만들어진 정답 다리를 저장하는  `List<String> madeBridge` 의 setter

---

## View 패키지

### InputView

1. `readBridgeSize()` 

다리의 길이를 입력받는 메소드

1. `readMoving()`

사용자가 이동할 칸을 입력받는다(U 또는 D)

1. `readGameCommand()`

사용자의 게임 재시작 여부를 입력받는다(R또는 Q)

### OutputView

1. `printMap()`

이동한 다리의 상태를 출력하는 메소드.  전체적인 형식만 제공하고 중간쪽 반복되는 구간은 `additionPrint()` 를 호출해 구현

1. `additionPrint()`

사이즈가 커져서 다리의 중간 부분에 반복되는 출력을 해야하는데, for문을 통해 벽과 다리 결과를 반복 출력해주는 메소드

1. `printResult()`

게임의 최종 결과를 출력하는 메소드. if else 문 대신 Enum클래스 `ResultEnum` 에서 결과에 대한 텍스트를 가져온다.

---

## Enum 클래스

### ResultEnum

“성공” 이라는 텍스트를 가지는 `O` ,“실패” 라는 텍스트를 가지는 `X` 객체로 구성되어있다.  여기에 구현된 `getResult()` 를 이용해 텍스트를 전달할 수 있다.

### BridgeEnum

아래를 뜻하는 “D” 텍스트를 포함하는 `BRIDGE_UP` , 위를 뜻하는 “U” 텍스트를 포함하는 `BRIDGE_DOWN` 객체로 구성되어 있다. 여기에 구현된 `getAlphabet()` 을 이용해 텍스트를 전달할 수있다.

---

## Controller 클래스

### BridgeController - 모델 Bridge을 관리하는 Controller

1. `bridgeMake()` 

다리를 만드는 메소드. `InputView` 클래스의 `readBridgeSize()` 로 다리 길이를 입력을 받고 예외처리 클래스 `BridgeControllerException()` 로 그 값을 보내서 입력 형식이 올바른지 체크한다.  확인됐다면 다리를 만드는 클래스`BridgeMaker` 에 다리 길이를 전달해 랜덤으로 만들어진 다리를 전달받고 그걸 모델 Bridge에 전달한다.

1. `userMove()`

사용자가 움직이는 행동을 뜻하는 메소드. `InputView` 클래스의 `readMoving()` 를 호출해 위, 아래중 어디로 이동할 지 입력받고 위와 같이 예외처리를 한 후 , 정답인지 아닌지 비교해주는 메소드 `compareToBridge()` 로 값을 전달한다.

1. `ompareToBridge()`

 정답인지 아닌지 비교해주는 메소드.  `Bridge` 클래스로 부터 `getCheckIndex()` 로 이동할 인덱스 값을 받아오고 이동할 칸과 비교해서 같으면 통과를 뜻하는 "O"를 `Bridge`클래스의 `setCheckedBridge()`에 전달한다. 다르면 실패를 뜻하는 "X"를 Bridge클래스의 setCheckedBridge에 전달한다.

1. `printBridge()` 

`OutputView` 클래스에서 다리 상태를 출력하는 `printMap()` 을 위해 `Bridge` 클래스로 부터 전달받은 위쪽 다리의 결과와 아래쪽 다리의 결과를 전달하는 메소드.

1. `getLastResult()` 

`Bridge` 클래스에 저장된 결과 리스트의 마지막 결과를 가져온다.  그리고 `isFail()` 과 `isSuccess()` 메소드로 전달되서 성공 및 실패를 체크하는데 쓰인다. 

1. `getRetry()` 

`InputView` 클래스로 부터 재시작 여부를 입력받고 R이면 재시작을 뜻하는 true를, Q이면 종료를 뜻하는 false를 리턴하는 boolean형 함수

1. `printGameResult()`

결과를 출력하는 메소드. `OutputView` 클래스에 결과를 출력하도록 명령한다.

### BridgeControllerException - 예외처리 함수 모음

BridgeController에 너무 많은 메소드가 구현되는걸 막기위해 예외처리는 여기서 해준다.