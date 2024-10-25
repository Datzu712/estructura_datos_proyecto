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
        }
        Client client = new Client("Sr. Alfredo");
        Ticket ticket = new Ticket("retiro", TicketType.SINGLE_TRANSACTION);

        Client client2 = new Client("Client stacks..."); // the idea of this client is to test the saved data is loaded correctly
        Ticket ticket2 = new Ticket("retiro", TicketType.SINGLE_TRANSACTION);

        JOptionPane.showMessageDialog(null, "Hora de creación del ticket de Sr. Alfredo:" + ticket.createdAt);

        ticket.setCurrentClient(client);
        ticket2.setCurrentClient(client2);

        bank.boxes.preferentialBox.enqueue(ticket);
        bank.boxes.preferentialBox.enqueue(ticket2);
        bank.save(Constants.BANK_FILENAME);

        JOptionPane.showMessageDialog(null, "Ticket en cola: " + bank.boxes.preferentialBox, "Ticket en cola preferencial", JOptionPane.INFORMATION_MESSAGE);

        Ticket ticketAttended = bank.boxes.preferentialBox.attend();
        JOptionPane.showMessageDialog(null, "Ticket atendido: " + ticketAttended, "Ticket atendido", JOptionPane.INFORMATION_MESSAGE);

        bank.save(Constants.BANK_FILENAME);
    }
}
