import java.util.Scanner;

public class Strzal {
    public static int wspolrzednaI(String strzal) {
        char wspolrzedne[] = strzal.toCharArray();
        int i;
        if (wspolrzedne.length == 2) {
            i = wspolrzedne[1] - 48;
        } else {
            i = 10;
        }
        return i;
    }

    public static int wspolrzednaJ(String strzal) {
        char wspolrzedne[] = strzal.toCharArray();
        int j = wspolrzedne[0] - 96;
        return j;
    }


    public static void rozstawianie(Plansza plansza1, Scanner scanner, int gracz) {
        System.out.println("Gracz " + gracz + " - Rozstaw statki:");
        plansza1.drukujPlansze();
        for (int i = 0; i < 4; i++) {
            String statek = scanner.next();
            //Zaznaczanie.ustawStatek(plansza1, Strzal.wspolrzednaI(statek), Strzal.wspolrzednaJ(statek));
        }
    }
}
