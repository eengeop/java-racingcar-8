package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String WINNER_DELIMITER = ", ";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printResultMessage(){
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResult(List<RacingCar> racingCar) {
        for(RacingCar car : racingCar){
            System.out.println(car.getCarName() + COLON + DASH.repeat(car.getDashCount()));
        }
        System.out.println();
    }

    public void printWinneers(List<String> winners){
        String winnerOutput = FINAL_WINNER + String.join(WINNER_DELIMITER, winners);
        System.out.println(winnerOutput);
    }
}
