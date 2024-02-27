package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Results {
    private final List<Result> results;

    public Results(List<String> results, int playersCount) {
        if (results.size() != playersCount) {
            throw new IllegalArgumentException(
                    "실행 결과의 수가 사용자 수와 다릅니다: %d".formatted(results.size())
            );
        }
        this.results = new ArrayList<>();
        IntStream.range(0, playersCount)
                .forEach(index -> this.results.add(new Result(results.get(index), index)));
    }

    public Stream<Result> stream() {
        return results.stream();
    }

    public String getResultValue(int location) {
        return results.stream()
                .filter(result -> result.hasSameLocation(location))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 위치입니다."))
                .reward();
    }
}
