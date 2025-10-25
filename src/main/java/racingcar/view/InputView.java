package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.UserInputDTO;
import racingcar.model.RacingCar;

public class InputView {

    private static final String SET_RACING_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SET_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public UserInputDTO inputNameAndCount(){
        System.out.println(SET_RACING_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();

        System.out.println(SET_TRY_COUNT);
        String inputTryCount = Console.readLine();

        UserInputDTO userInput = new UserInputDTO(carNames, inputTryCount);
        return  userInput;
    }
    /*
    1. readLine()으로 자동차 이름을 입력받음(배열로 할지, String으로 할지, List로 할지는 아직 모름).
    2. readLine()으로 시도할 횟수를 입력받음.
    3. 입력 받은 값을 Controller로 보냄
 ==================^^^^^^^^^^^^InputView 역할^^^^^^^^^^^^^^^===========================
    4. Controller는 자동차 이름이 5자 이하인지 검증함, 공백도 이름의 일부로 포함(5자 초과라면 new throw)
    5. Controller는 시도할 횟수가 초과 하였는지 검증함 (일단 10번 초과면 new throw)
    6. 검증이 완료된 값들을 Service로 보냄.
 ==================^^^^^^^^^^^^Controller 역할^^^^^^^^^^^^^^^===========================
    7. Service에서 Map<String, int>에 <자동차 이름, Randoms()> 값을 담음.
    8. if(Randoms() >= 4)면,
    * */


    /*
    * InputeView에서 UserInput 받고 userInputDTO로 Controller에게 넘겨줌.
    * Controller는 userInputDTO 받아서 Validator에서 넘겨주고 Validator에서 값을 다시 넘겨줌
    * Controller는 이상 없는 값을 Service에게 넘겨줌
    * Service에서 값을 처리하고 OutPutView로 넘겨줌 --> 여기서 값을 가공하는건 Model에서 담당하게끔.
    *
    * */
}
