package ipv4calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

    private Calculator view;

    public Controller(Calculator view) {
        this.view = view;
        this.view.setTitle("Calculadora IPv4");
        this.view.getBtnOK().addActionListener(this);
        this.view.getBtnClean().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnOK()) {
            try {
                String ip = view.getIpAddress().getText();
                String mask = view.getMask().getText();
                IPv4Address ipv4Address = new IPv4Address(ip, mask);

                String result = "Dirección IP:\n" + ipv4Address.getIPAddress() + "          "
                        + ipv4Address.getBinaryAddress() + "\n\n"
                        + "Máscara:\n" + ipv4Address.getDecimalMask() + " = " + mask + "          "
                        + ipv4Address.getBinaryMask() + "\n\n"
                        + "Dirección de Red:\n" + ipv4Address.getDecimalNetwork() + "         "
                        + ipv4Address.getBinaryNetwork() + "\n\n"
                        + "Broadcast:\n" + ipv4Address.getDecimalBroadcast() + "          "
                        + ipv4Address.getBinaryBroadcast() + "\n\n"
                        + "Primer Host:\n" + ipv4Address.getDecimalFirstHost() + "            "
                        + ipv4Address.getBinaryFirstHost() + "\n\n"
                        + "Último Host:\n" + ipv4Address.getDecimalLastHost() + "         "
                        + ipv4Address.getBinaryLastHost() + "\n\n"
                        + "Máx. Hosts: " + ipv4Address.getMaxHosts() + "\n\n"
                        + "Tipo: " + ipv4Address.getType();

                view.getjTextArea1().setText(result);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error al calcular los datos:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == view.getBtnClean()) {
            view.getIpAddress().setText("");
            view.getMask().setText("");
        }
    }
}
