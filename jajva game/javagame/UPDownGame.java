import java.util.Random;
import java.util.Scanner;

public class UPDownGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = random.nextInt(100) + 1; // 1부터 100 사이 숫자
        int guess;
        int attempts = 0;

        System.out.println("Up-Down Game 시작! (1~100 사이 숫자를 맞혀보세요)");

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            attempts++;

            if (guess < targetNumber) {
                System.out.println(" UP!");
            } else if (guess > targetNumber) {
                System.out.println(" DOWN!");
            } else {
                System.out.println(" 정답입니다! 시도 횟수: " + attempts + "번");
                break;
            }
        }

        scanner.close();
    }
}
