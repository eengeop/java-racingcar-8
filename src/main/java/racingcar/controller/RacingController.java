package racingcar.controller;

import racingcar.domain.UserInputDTO;
import racingcar.domain.RacingCar;
import racingcar.service.RacingService;
import racingcar.validation.Validator;

import java.util.List;

public class RacingController {

    private Validator validator = new Validator();
    private RacingService racingService = new RacingService();

    public List<RacingCar> validUserInput(UserInputDTO userInputDTO){
        List<String> carNames = validator.validateName(userInputDTO);
        String tryCount = validator.validateCount(userInputDTO);
        return racingService.startRacing(carNames);
    }

    public void racingResultDTO(List<RacingCar> racingCar, String tryCount){

    }


    public void run(){
        /*
        * aaa = InputView.inputNameAndCount()
        * bbb = controller.validUserInput(aaa)
        * ccc = racingResultDTO(bbb, Integer.parseInt(aaa.getTryCount()))
        * */
    }



/*    public static void validateName(RacingCar racingCar){
        String[] CarNameArr = racingCar.carName().split(",");
        for(String arr : CarNameArr){
            if(arr.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateCount(RacingCar racingCar){
        try{
            int tryCount = Integer.parseInt(racingCar.tryCount());
            if(tryCount>10){
                throw new IllegalArgumentException("시도는 최대 10회만 가능합니다.");
            }
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }*/
}
