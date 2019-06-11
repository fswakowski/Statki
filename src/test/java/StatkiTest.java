import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.sun.org.apache.xerces.internal.util.FeatureState.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StatkiTest {

    private Plansza game;

    @BeforeEach
    public void setUp() {
        game = new Plansza();

        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {}
        }));
        game.drukujPlansze();
    }

    @Test
    public void checkStatki()
    {

        Plansza plansza1 = new Plansza();
        plansza1.utworzPlansze();
        Plansza plansza2 = new Plansza();
        plansza2.utworzPlansze();

        assertFalse(plansza1 == plansza2);
    }

    @Test
    public void makeBoardTest() {
        game.utworzPlansze();

        Boolean flag = true;

        for(int i=0; i<11; i++) {
            for(int j=0; j<11; j++) {
                if(game.plansza[i][j] != '-')
                    flag = false;
            }
        }

        assertFalse(flag);

    }

    @Test
    public void makeShipTest() {
        game.utworzPlansze();

        Zaznaczenie.ustawStatek(game.plansza,1,1);

        Boolean flag = false;

        for(int i=0; i<11; i++) {
            for(int j=0; j<11; j++) {
                if(game.plansza[i][j] == 'S')
                    flag = true;
            }
        }

        assertTrue(flag);

    }

    @Test
    public void makeShotTest() {
        game.utworzPlansze();

        Zaznaczenie.ustawStatek(game.plansza,1,1);

        int i;
        int j;
        char x = ' ';

        for(i=0; i<11; i++) {
            for(j=0; j<11; j++) {
                if(game.plansza[i][j] == 'S') {
                    Zaznaczenie.strzalTrafiony(game.plansza, i, j);
                    x = game.plansza[i][j];
                }
            }
        }
        assertThat(x, equalTo('X'));

    }

    @Test
    public void checkWin()
    {

        Plansza plansza1 = new Plansza();
        plansza1.utworzPlansze();
        Plansza plansza2 = new Plansza();
        plansza2.utworzPlansze();

        Zaznaczenie.ustawStatek(plansza1.plansza,3,3);
        Zaznaczenie.ustawStatek(plansza1.plansza, 3,4);
        Zaznaczenie.ustawStatek(plansza1.plansza,3,5);
        Zaznaczenie.ustawStatek(plansza1.plansza, 3,6);

        Zaznaczenie.ustawStatek(plansza1.plansza,5,8);
        Zaznaczenie.ustawStatek(plansza1.plansza, 6,8);
        Zaznaczenie.ustawStatek(plansza1.plansza,7,8);
        Zaznaczenie.ustawStatek(plansza1.plansza, 8,8);

        boolean flag1 = false;
        boolean flag2 = false;

        do {
            int col = (int) (Math.random() * 9);
            int row = (int) (Math.random() * 10);

            if(flag1 == false) {
                if (plansza1.plansza[col][row] == 'S') {
                    Zaznaczenie.strzalTrafiony(plansza1.plansza, col, row);

                    for (int i = 0; i < 11; i++) {
                        for (int j = 0; j < 11; j++) {
                            if (plansza1.plansza[i][j] != 'S')
                                flag1 = true;
                        }
                    }
                } else {
                    Zaznaczenie.strzalPudlo(plansza1.plansza, col, row);
                }
            }

            if(flag2 == false) {
                if (plansza2.plansza[col][row] == 'S') {
                    Zaznaczenie.strzalTrafiony(plansza2.plansza, col, row);

                    for(int i=0; i<11; i++) {
                        for(int j=0; j<11; j++) {
                            if(plansza1.plansza[i][j] != 'S')
                                flag2 = true;
                        }
                    }

                } else {
                    Zaznaczenie.strzalPudlo(plansza2.plansza, col, row);
                }
            }

        }
        while (flag1 == false && flag2==false);



        assertTrue(flag1||flag2);
    }



}
