/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.util.Arrays;

/**
 *
 * @author juan
 */
public class Proyecto {
    public static void main(String[] args) {
        Bank bank = Bank.load("prod.txt");
        if (bank == null) {
            bank = new Bank("Banco nacional")
                .setPreferentialBox(new Box("discapacitados", false))
                .setQuickTransactionsBox(new Box("tramites_rapidos", true))
                .setGeneralBoxes(
                    Arrays.asList(
                        new Box("general_1", false),
                        new Box("general_2", false),
                        new Box("general_3", false)
                    )
                ).save("prod.txt");
        }

        System.out.println(bank);
    }
}
