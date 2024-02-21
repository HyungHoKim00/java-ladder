package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @DisplayName("높이 생성")
    @Test
    void validHeightTest() {
        assertThatCode(() -> new Height(1))
                .doesNotThrowAnyException();
    }

    @DisplayName("자연수가 아닌 높이를 입력하면 예외가 발생한다.")
    @ValueSource(ints = {0, -1})
    @ParameterizedTest
    void invalidHeightTest(int value) {
        assertThatThrownBy(() -> new Height(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
