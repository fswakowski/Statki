public class Zaznaczenie {
    public static char[][] strzalPudlo(char[][]plansza, int i, int j) {
        plansza[i][j] = '*';
        return plansza;
    }

    public static char[][] strzalTrafiony(char[][]plansza,int i, int j) {
        plansza[i][j] = 'X';
        return plansza;
    }

    public static char[][] ustawStatek(char[][]plansza,int i, int j) {
        plansza[i][j] = 'S';
        return plansza;
    }
}
