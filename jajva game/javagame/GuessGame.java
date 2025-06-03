import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class GuessGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_TRIES = 3;

        System.out.println("숫자 맞추기 게임에 오신 것을 환영합니다!");

        boolean playAgain = true;

        while (playAgain) {
            Random random = new Random();
            int answer = random.nextInt(100) + 1;
            int guess = 0;
            int tries = 0;
            boolean guessedCorrectly = false;

            System.out.println("1부터 100 사이의 숫자를 맞혀보세요. 기회는 " + MAX_TRIES + "번입니다.");

            while (tries < MAX_TRIES) {
                System.out.print("숫자를 입력하세요 (" + (MAX_TRIES - tries) + "번 남음): ");
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                    tries++;

                    if (guess < 1 || guess > 100) {
                        System.out.println("1~100 사이 숫자를 입력해주세요.");
                        continue;
                    }

                    if (guess < answer) {
                        System.out.println("더 큰 수입니다.");
                    } else if (guess > answer) {
                        System.out.println("더 작은 수입니다.");
                    } else {
                        System.out.println("정답입니다! " + tries + "번 만에 맞추셨습니다.");
                        saveScore(tries);
                        guessedCorrectly = true;
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("기회를 모두 사용하셨습니다. 정답은 " + answer + "였습니다.");
            }

            System.out.print("다시 하시겠습니까? (Y/N): ");
            String response = scanner.nextLine().trim().toUpperCase();
            playAgain = response.equals("Y");
        }

        System.out.println("게임을 종료합니다.");
        scanner.close();
    }

    public static void saveScore(int tries) {
        try (FileWriter writer = new FileWriter("score.txt", true)) {
            writer.write("정답까지 시도한 횟수: " + tries + "번\n");
        } catch (IOException e) {
            System.out.println("점수 저장 중 오류 발생: " + e.getMessage());
        }
    }
}
