package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.validation.Validator;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {

    private final Validator validator;
    private final RacingService racingService;

    public RacingController(Validator validator, RacingService racingService){
        this.validator = validator;
        this.racingService = racingService;
    }

    private List<String> validInputName(String carNames){
        return validator.validateName(carNames);
    }

    private int validInputTryCount(String tryCount){
        return validator.validateCount(tryCount);
    }

    public void start(){
        racingService.startRacing(validInputName(InputView.inputName()), validInputTryCount(InputView.inputTryCount()));
    }
}
