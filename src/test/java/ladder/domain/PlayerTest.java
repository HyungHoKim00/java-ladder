package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @DisplayName("이름을 입력하여 Player를 생성한다.")
    @Test
    void playerConstructTest() {
        assertThatCode(() -> new Player("명오"))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름이 1~5글자 범위를 벗어나면 예외를 발생한다.")
    @ValueSource(strings = {"", "우아한테크코스"})
    @ParameterizedTest
    void nameLengthTest(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5글자 사이로 입력해주세요: %s".formatted(name));
    }
}
