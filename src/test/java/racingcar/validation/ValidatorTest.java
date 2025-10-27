package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("빈 자동차 이름 입력시 예외 발생")
    void validateEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String userInput = "";
            validator.validateName(userInput);
        });
        assertThat(exception.getMessage()).isEqualTo("입력 값은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("5자 초과 자동차 이름 입력시 예외 발생")
    void validateNameLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String userInput = "abced2";
            validator.validateName(userInput);
        });
        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 5글자를 넘길 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수 음수 입력시 예외 발생")
    void validateNaturalNumber(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String userInput = "-2";
            validator.validateCount(userInput);
        });
        assertThat(exception.getMessage()).isEqualTo("시도횟수는 1회 이상의 자연수만 가능합니다.");
    }

    @Test
    @DisplayName("시도 횟수 정수가 아닐시 예외 발생")
    void validateFloat(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String userInput = "2.2";
            validator.validateCount(userInput);
        });
        assertThat(exception.getMessage()).isEqualTo("시도횟수는 1회 이상의 자연수만 가능합니다.");
    }

    @Test
    @DisplayName("시도 횟수 0 입력시 예외 발생")
    void validateZero(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String userInput = "0";
            validator.validateCount(userInput);
        });
        assertThat(exception.getMessage()).isEqualTo("시도횟수는 1회 이상의 자연수만 가능합니다.");
    }
}