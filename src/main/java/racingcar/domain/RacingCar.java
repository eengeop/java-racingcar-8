package racingcar.domain;

public class RacingCar {

    private static final int VALUE_CONDITION_FOR_MOVE = 4;

    private String carName;
    private int dashCount;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public int move(int randomNumber){
        if(randomNumber >= VALUE_CONDITION_FOR_MOVE){
            dashCount++;
        }
        return dashCount;
    }

    public String getCarName() {
        return carName;
    }

    public int getDashCount(){
        return dashCount;
    }
}
