package racingcar;

import racingcar.controller.AppController;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingCarController = AppController.run();
        racingCarController.start();
    }
}