/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazticket;

import java.awt.Color;
import modelo.AgenciaMigratoria;
import modelo.Ticket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

/**
 * FXML Controller class
 *
 * @author CLOJA
 */
public class FXMLTicketController implements Initializable {

    @FXML
    private Label labelTurno;
    @FXML
    private Label labelTipoPersona;
    @FXML
    private Label mostrarTurno;
    @FXML
    private ImageView discapacitados;
    @FXML
    private ImageView normal;
    @FXML
    private ImageView terceraEdad;
    @FXML
    private AnchorPane anchor;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        anchor.setStyle("-fx-background-color: #ffffff");
    }    

    private void asignarTurno(int tur){
        Ticket t= new Ticket(tur);
        AgenciaMigratoria.turnos.offer(t);
        mostrarTurno.setText("Su turno es: "+t.getId());
        new Thread (() -> {
            try {
                Thread.sleep(3000);
                Platform.runLater(() -> {
                    FXMLTicketController.this.mostrarTurno.setText("");
                });
                
            }catch (InterruptedException ex) {
                Logger.getLogger(FXMLTicketController.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    @FXML
    private void turnoD(MouseEvent event) {
        asignarTurno(2);
    }

    @FXML
    private void turnoU(MouseEvent event) {
        asignarTurno(1);
    }
    @FXML
    private void turnoT(MouseEvent event) {
        asignarTurno(3);
    }
}
