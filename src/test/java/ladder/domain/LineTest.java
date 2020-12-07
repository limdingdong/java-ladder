package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {


    @DisplayName("사다리 가로라인이 겹쳐지는 경우 Exception Test")
    @Test
    void linePointsDuplicationTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Point> points = new ArrayList<>();
            points.add(new Point(new Direction(false, true)));
            points.add(new Point(new Direction(true, true)));

            new Line(points);

        }).withMessageContaining(LadderGameErrorMessage.ILLEGAL_LINE_POINTS.getErrorMessage());
    }
}
