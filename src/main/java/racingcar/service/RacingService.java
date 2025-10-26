package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.model.RandomNumber;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    RandomNumber randomNumber = new RandomNumber();

    public List<RacingCar> startRacing(List<String> carNames){
        List<RacingCar> racingCar = convertToRacingCar(carNames);
        oneTimeRacing(racingCar);
        return racingCar;
    }

    public List<RacingCar> convertToRacingCar(List<String> carNames){
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void oneTimeRacing(List<RacingCar> racingCar) {
        racingCar.stream()
                .forEach(car -> car.move(randomNumber.createRandomNum()));
    }
}
