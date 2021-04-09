package ladder.view;

import ladder.controller.dto.LadderGenerationRequest;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public LadderGenerationRequest inputLadderGeneration() {
        return new LadderGenerationRequest(inputParticipants(), inputLadderHeight());
    }

    private String inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    private int inputLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
