package racingcar.controller;

import racingcar.model.RandomNumber;
import racingcar.service.RacingService;
import racingcar.validation.Validator;
import racingcar.view.OutputView;

public class AppController {

    public static RacingController run(){
        RandomNumber randomNumber = new RandomNumber();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        RacingService racingService = new RacingService(randomNumber, outputView);
        return new RacingController(validator, racingService);
    }

}
