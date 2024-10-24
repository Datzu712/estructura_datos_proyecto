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
        Bank bank = Bank.load(Constants.BANK_FILENAME);
        if (bank == null) {
            bank = Bank.build("Banco nacional");
            
            bank.boxes
                .setPreferentialBox(new Box("discapacitados", false))
                .setQuickTransactionsBox(new Box("tramites_rapidos", true))
                .setGeneralBoxes(
                    Arrays.asList(
                        new Box("general_1", false),
                        new Box("general_2", false),
                        new Box("general_3", false)
                    )
                );
            bank.save("prod.txt");
        }
        System.out.println(Constants.BANK_FILENAME);
    }
}
