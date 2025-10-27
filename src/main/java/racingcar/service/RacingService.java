package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.model.RandomNumber;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    private final RandomNumber randomNumber;
    private final OutputView outputView;

    public RacingService(RandomNumber randomNumber, OutputView outputView){
        this.randomNumber = randomNumber;
        this.outputView = outputView;
    }

    public List<RacingCar> startRacing(List<String> carNames, int tryCount){
        List<RacingCar> racingCar = convertToRacingCar(carNames);
        outputView.printResultMessage();
        runRace(racingCar, tryCount);
        List<String> winners = findWinners(racingCar);
        outputView.printWinneers(winners);
        return racingCar;
    }

    private List<RacingCar> convertToRacingCar(List<String> carNames){
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private void runRace(List<RacingCar> racingCar, int tryCount){
        for(int i = 0 ; i < tryCount ; i++){
            oneTimeRacing(racingCar);
            outputView.printRacingResult(racingCar);
        }
    }

    private void oneTimeRacing(List<RacingCar> racingCar) {
        racingCar.stream()
                .forEach(car -> car.move(randomNumber.createRandomNum()));
    }

    private List<String> findWinners(List<RacingCar> racingCar){
        int maxDash = findMaxDash(racingCar);
        return findWinnersByMaxDash(racingCar, maxDash);
    }

    private int findMaxDash(List<RacingCar> racingCar){
        return racingCar.stream()
                .mapToInt(RacingCar::getDashCount)
                .max()
                .orElse(0);
    }

    private List<String> findWinnersByMaxDash(List<RacingCar> racingCar, int maxDash){
        return racingCar.stream()
                .filter(car -> car.getDashCount() == maxDash)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }
}