package ladder.controller;

import ladder.controller.dto.LadderGenerationRequest;
import ladder.controller.dto.LadderGenerationResponse;
import ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LadderGenerationControllerTest {

    @Test
    @DisplayName("참가자 수와 이름 검증")
    void participants() {
        // given
        String participantNames = "pobi,honux,crong,jk";
        int ladderHeight = 5;
        LadderGenerationRequest request = new LadderGenerationRequest(participantNames, "꽝,5000,꽝,3000", ladderHeight);
        LadderGenerationController controller = new LadderGenerationController();

        // when
        LadderGenerationResponse response = controller.generateLadder(request);

        // then
        assertThat(4).isEqualTo(response.getParticipantNames().size());
        for (String name : response.getParticipantNames()) {
            assertThat(Arrays.asList(participantNames.split(",")).contains(name)).isTrue();
        }
    }

    @Test
    @DisplayName("사다리 높이 검증")
    void ladderHeight() {
        // given
        String participantNames = "pobi,honux,crong,jk";
        int ladderHeight = 5;
        LadderGenerationRequest request = new LadderGenerationRequest(participantNames, "꽝,5000,꽝,3000", ladderHeight);
        LadderGenerationController controller = new LadderGenerationController();

        // when
        LadderGenerationResponse response = controller.generateLadder(request);

        // then
        assertThat(ladderHeight).isEqualTo(response.getLadderLines().size());
    }

    @Test
    @DisplayName("사다리 라인 폭 검증")
    void ladderHorizonLength() {
        // given
        String participantNames = "pobi,honux,crong,jk";
        int ladderHeight = 5;
        LadderGenerationRequest request = new LadderGenerationRequest(participantNames, "꽝,5000,꽝,3000", ladderHeight);
        LadderGenerationController controller = new LadderGenerationController();

        // when
        LadderGenerationResponse response = controller.generateLadder(request);

        // then
        assertThat(Ladder.LADDER_HORIZON_WIDTH).isEqualTo(response.getLadderWidth());
    }

    @Test
    @DisplayName("게임생성 결과 검증")
    void gameResults() {
        // given
        String participantNames = "pobi,honux,crong,jk";
        int ladderHeight = 5;
        String gameResults = "꽝,5000,꽝,3000";
        LadderGenerationRequest request = new LadderGenerationRequest(participantNames, gameResults, ladderHeight);
        LadderGenerationController controller = new LadderGenerationController();

        // when
        LadderGenerationResponse response = controller.generateLadder(request);

        // then
        for (String gameResult : response.getGameResults()) {
            assertThat(Arrays.asList(gameResults.split(",")).contains(gameResult)).isTrue();
        }
    }
}