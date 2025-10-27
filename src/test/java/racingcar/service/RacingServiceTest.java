package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;

public class RacingServiceTest {

    @DisplayName("랜덤 값이 4이상일 경우에는 한 칸 이동한다.")
    @ParameterizedTest
    @ValueSource(ints={4,5,6,7,8,9})
    void move_car_one_dash(int randomNum){
        RacingCar racingCar = new RacingCar("pobi");

        int moveResult = racingCar.move(randomNum);

        assertThat(moveResult).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 3이하일 경우에는 움직이면 안된다.")
    @ParameterizedTest
    @ValueSource(ints={0,1,2,3})
    void not_move_car(int randomNum){
        RacingCar car = new RacingCar("woni");

        int moveResult = car.move(randomNum);

        assertThat(moveResult).isEqualTo(0);
    }

    @DisplayName("2대의 자동차가 같은 거리를 이동하면 공동 우승이 된다.")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    void communal_winner(int randomNum){
        RacingCar car1 = new RacingCar("pobi");
        RacingCar car2 = new RacingCar("woni");

        int movigResultOfCar1 = car1.move(randomNum);
        int movigResultOfCar2 = car2.move(randomNum);

        assertThat(movigResultOfCar1).isEqualTo(movigResultOfCar2);
    }
}
