package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int MIN_RANDOM_DELIMITER = 0;
    private static final int MAX_RANDOM_DELIMITER = 9;

    public int createRandomNum(){
        return Randoms.pickNumberInRange(MIN_RANDOM_DELIMITER, MAX_RANDOM_DELIMITER);
    }
}
