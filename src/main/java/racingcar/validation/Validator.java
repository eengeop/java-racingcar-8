package racingcar.validation;

import racingcar.domain.UserInputDTO;

import java.util.Arrays;
import java.util.IllformedLocaleException;
import java.util.List;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_TRY_COUNT = 0;
    private static final String VALIDATE_TRY_COUNT_REGX = "^\\d$";


    public String validateName(UserInputDTO userInputDTO){
        List<String> carNames = Arrays.stream(userInputDTO.getCarNames().split(",")).toList();
        if(carNames.stream()
                .anyMatch(carName-> carName.length() > MAX_CAR_NAME_LENGTH)){
            throw new IllformedLocaleException("자동차 이름은 5글자를 넘길 수 없습니다.");
        }
        return userInputDTO.getCarNames();
    }

    public String validateCount(UserInputDTO userInputDTO){
        if(userInputDTO.getInputTryCount() == null || !userInputDTO.getInputTryCount().matches(VALIDATE_TRY_COUNT_REGX)){
                throw new IllegalArgumentException("10회 미만의 자연수만 시도할 수 있습니다.");
        }
        if(Integer.parseInt(userInputDTO.getInputTryCount()) == MIN_TRY_COUNT){
                throw new IllegalArgumentException("경기는 한 번 이상부터 진행 가능합니다.");
        }
        return userInputDTO.getInputTryCount();
    }
}
