package racingcar.validation;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_TRY_COUNT = 0;
    private static final String VALIDATE_TRY_COUNT_REGX = "^[1-9]\\d*$";
    private static final String ERROR_EMPTY_NAME = "입력 값은 비어있을 수 없습니다.";
    private static final String ERROR_NAME_LENGTH = "자동차 이름은 5글자를 넘길 수 없습니다.";
    private static final String ERROR_INVALID_COUNT = "시도횟수는 1회 이상의 자연수만 가능합니다.";

    public List<String> validateName(String inputCarName){
        validateisEmpty(inputCarName);
        List<String> carNames = splitInputCarName(inputCarName);
        validateCarNameLength(carNames);
        return carNames;
    }

    private List<String> splitInputCarName(String inputCarName){
        List<String> splitCarNames = Arrays.stream(inputCarName.split(","))
                .map(String::trim)
                .toList();
        return splitCarNames;
    }

    private void validateCarNameLength(List<String> inputCarName){
        if(inputCarName.stream()
                .anyMatch(name-> name.length() > MAX_CAR_NAME_LENGTH)){
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    private void validateisEmpty(String input){
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    public int validateCount(String inputTryCount){
        validateisEmpty(inputTryCount);
        validateNumberFormat(inputTryCount);
        int tryCount = Integer.parseInt(inputTryCount);
        validateMinimumCount(tryCount);
        return tryCount;
    }

    private void validateNumberFormat(String inputTryCount){
        if(!inputTryCount.matches(VALIDATE_TRY_COUNT_REGX)){
            throw new IllegalArgumentException(ERROR_INVALID_COUNT);
        }
    }

    private void validateMinimumCount(int inputTryCount){
        if(inputTryCount < MIN_TRY_COUNT){
            throw new IllegalArgumentException(ERROR_INVALID_COUNT);
        }
    }
}
