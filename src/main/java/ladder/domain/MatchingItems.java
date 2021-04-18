package ladder.domain;

import common.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MatchingItems {

    private static final String NAME_DELIMITER = ",";

    private final List<String> matchingItems;

    public MatchingItems(String gameResultNames, int participantsCount) {
        this(generateMatchingItems(gameResultNames, participantsCount));
    }

    public MatchingItems(List<String> matchingItems) {
        this.matchingItems = matchingItems;
    }

    private static List<String> generateMatchingItems(String gameResultNames, int participantsCount) {
        validateMatchingItemNames(gameResultNames);
        return generateMatchingItems(Arrays.asList(gameResultNames.split(NAME_DELIMITER)), participantsCount);
    }

    private static void validateMatchingItemNames(String gameResultNames) {
        if (StringUtils.isBlank(gameResultNames)) {
            throw new IllegalArgumentException("게임 결과를 입력해 주세요.");
        }
    }

    private static List<String> generateMatchingItems(List<String> gameResults, int participantsCount) {
        validateMatchingItemNames(gameResults, participantsCount);
        return gameResults;
    }

    private static void validateMatchingItemNames(List<String> gameResults, int participantsCount) {
        if (gameResults.size() != participantsCount) {
            throw new IllegalArgumentException("게임 결과 수는 참가자 수와 같아야 합니다.");
        }
        if (isBlankPresent(gameResults)) {
            throw new IllegalArgumentException("유효하지 않은 결과값이 존재합니다. 입력값을 확인해주세요.");
        }
    }

    private static boolean isBlankPresent(List<String> gameResults) {
        return gameResults.stream().anyMatch(StringUtils::isBlank);
    }

    public List<String> getMatchingItems() {
        return matchingItems;
    }

    public String getGameResult(int ladderExitNumber) {
        return matchingItems.get(ladderExitNumber);
    }
}
