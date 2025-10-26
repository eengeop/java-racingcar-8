package racingcar.domain;

public class UserInputDTO {
    private String carNames;
    private String inputTryCount;

    public UserInputDTO(String carNames, String inputTryCount) {
        this.carNames = carNames;
        this.inputTryCount = inputTryCount;
    }

    public String getCarNames() {
        return carNames;
    }

    public void setCarNames(String carNames) {
        this.carNames = carNames;
    }

    public String getInputTryCount() {
        return inputTryCount;
    }

    public void setInputTryCount(String inputTryCount) {
        this.inputTryCount = inputTryCount;
    }
}