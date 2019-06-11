public class Plansza {
    char[][] plansza = new char[11][11];


    public void utworzPlansze() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    plansza[i][j] = (char) (48 + j);
                } else if (j == 0) {
                    plansza[i][j] = (char) (64 + i);
                } else {
                    plansza[i][j] = '0';
                }
                plansza[0][10] = '1';
                plansza[0][0] = ' ';
            }
        }
        //Drukowanie planszy - zeby widziec gdzie dac statki
        /*for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(plansza[i][j] + " ");
            }
            System.out.println();
        }*/

    }

    public void drukujPlansze() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                //Wyjatek zeby nie drukowac statkow
                if (plansza[i][j] == 'S') {
                    System.out.print('0' + " ");
                } else {
                    System.out.print(plansza[i][j] + " ");
                }
            } System.out.println();
        }
    }

    public void drukujPlanszeStatki() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(plansza[i][j] + " ");
            }
        } System.out.println();
    }
}
