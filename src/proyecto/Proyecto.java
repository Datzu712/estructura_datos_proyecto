/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import java.util.Arrays;

import javax.swing.JOptionPane;

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
        } else {
            JOptionPane.showMessageDialog(null, bank, "Bank loaded", JOptionPane.INFORMATION_MESSAGE);


            JOptionPane.showMessageDialog(null, bank.boxes.preferentialBox, "Preferential box", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Client client = new Client("Sr. Alfredo");
        Ticket ticket = new Ticket("retiro", TicketType.SINGLE_TRANSACTION);

        Client client2 = new Client("Client stacks..."); // the idea of this client is to test the saved data is loaded correctly
        Ticket ticket2 = new Ticket("retiro", TicketType.SINGLE_TRANSACTION);

        Client client3 = new Client("Client stacks..."); // the idea of this client is to test the saved data is loaded correctly
        Ticket ticket3 = new Ticket("retiro", TicketType.SINGLE_TRANSACTION);

        Client client4 = new Client("Client stacks..."); // the idea of this client is to test the saved data is loaded correctly
        Ticket ticket4 = new Ticket("retiro", TicketType.SINGLE_TRANSACTION);

        Client client5 = new Client("Client stacks..."); // the idea of this client is to test the saved data is loaded correctly
        Ticket ticket5 = new Ticket("retiro", TicketType.SINGLE_TRANSACTION);

        bank.boxes.preferentialBox.enqueue(ticket);
        JOptionPane.showMessageDialog(null, bank.boxes.preferentialBox + "\nLast ticket is" + bank.boxes.preferentialBox.getLastTicket(), "Ticket en cola preferencial", JOptionPane.INFORMATION_MESSAGE);
        bank.boxes.preferentialBox.enqueue(ticket2);
        JOptionPane.showMessageDialog(null, bank.boxes.preferentialBox + "\nLast ticket is" + bank.boxes.preferentialBox.getLastTicket(), "Ticket en cola preferencial", JOptionPane.INFORMATION_MESSAGE);
        bank.boxes.preferentialBox.enqueue(ticket3);
        JOptionPane.showMessageDialog(null, bank.boxes.preferentialBox + "\nLast ticket is" + bank.boxes.preferentialBox.getLastTicket(), "Ticket en cola preferencial", JOptionPane.INFORMATION_MESSAGE);
        bank.boxes.preferentialBox.enqueue(ticket4);
        JOptionPane.showMessageDialog(null, bank.boxes.preferentialBox + "\nLast ticket is" + bank.boxes.preferentialBox.getLastTicket(), "Ticket en cola preferencial", JOptionPane.INFORMATION_MESSAGE);
        bank.boxes.preferentialBox.enqueue(ticket5);
        JOptionPane.showMessageDialog(null, bank.boxes.preferentialBox + "\nLast ticket is" + bank.boxes.preferentialBox.getLastTicket(), "Ticket en cola preferencial", JOptionPane.INFORMATION_MESSAGE);
        Ticket ticketAttended = bank.boxes.preferentialBox.attend();
        JOptionPane.showMessageDialog(null, bank.boxes.preferentialBox + "\nLast ticket is" + bank.boxes.preferentialBox.getLastTicket(), "Ticket en cola preferencial", JOptionPane.INFORMATION_MESSAGE);

        bank.save(Constants.BANK_FILENAME);
    }
}
