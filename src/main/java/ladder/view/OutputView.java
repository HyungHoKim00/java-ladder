package ladder.view;

import static ladder.domain.Direction.RIGHT;

import java.util.List;
import java.util.StringJoiner;
import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.LadderLevel;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Results;

public class OutputView {

    private static final String DELIMITER = " ";
    private static final String NAME_FORMAT = "%5s";
    private static final String LINE = "|-----";
    private static final String EMPTY_LINE = "|     ";
    private static final String RESULT_FORMAT = "%-5s";

    public static void printLadderResult(Players players, Ladder ladder, Results results) {
        System.out.println("\n사다리 결과\n");
        printPlayers(players);
        printLadder(ladder);
        printResults(results);
    }

    private static void printPlayers(Players players) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        players.stream().forEach(player -> stringJoiner.add(NAME_FORMAT.formatted(player.name())));
        System.out.println(stringJoiner);
    }

    private static void printLadder(Ladder ladder) {
        ladder.stream().forEach(OutputView::printLadderLevel);
    }

    private static void printLadderLevel(LadderLevel ladderLevel) {
        System.out.print("\t");
        ladderLevel.stream().forEach(OutputView::printLine);
        System.out.println();
    }

    private static void printLine(Direction direction) {
        if (direction == RIGHT) {
            System.out.print(LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }

    private static void printResults(Results results) {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        results.stream().forEach(result -> stringJoiner.add(RESULT_FORMAT.formatted(result.value())));
        System.out.println(stringJoiner);
    }

    public static void printResultIndividual(String resultValue) {
        System.out.println("실행 결과");
        System.out.println(resultValue);
    }

    public static void printAllResults(List<Player> players, Results results) {
        System.out.println("실행 결과");
        players.forEach(player ->
                System.out.println(player.name() + " : " + results.getResultValue(player.location()))
        );
    }

    public static void printQuitMessage() {
        System.out.println("종료");
    }
}
