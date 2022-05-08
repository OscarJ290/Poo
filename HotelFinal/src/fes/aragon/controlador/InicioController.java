package fes.aragon.controlador;

import static javafx.scene.control.ButtonType.OK;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import fes.aragon.modelo.Gerente;
import fes.aragon.modelo.Hotel;
import fes.aragon.modelo.Hoteles;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InicioController extends BaseController implements Initializable {

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnSalir;

    @FXML
    private TableColumn<Hotel, String> clmCorreo;

    @FXML
    private TableColumn<Hotel, String> clmDireccion;

    @FXML
    private TableColumn<Hotel, Gerente> clmGerente;

    @FXML
    private TableColumn<Hotel, String > clmNombre;

    @FXML
    private TableColumn<Hotel, String> clmTelefono;

    @FXML
    private TableView<Hotel> tblTabla;

    @FXML
    void eliminarHotel(ActionEvent event) {
    	int indice=this.tblTabla.getSelectionModel().getSelectedIndex();
    	if (indice>=0) {
    		this.tblTabla.getItems().remove(indice);
    	}
    	else {
    		Alert alerta;
    		alerta=new Alert(AlertType.INFORMATION);
    		alerta.setTitle("Dialogo de aviso");
    		alerta.setHeaderText("Se necesita una fila");
    		alerta.setContentText("Por favor selecciona una fila, para eliminar");
    		Optional<ButtonType> resultado=alerta.showAndWait();
    		if(resultado.get ().equals (OK)) {
    		}
    	}
    }

    @FXML
    void modificarHotel(ActionEvent event) {
    	int indice=this.tblTabla.getSelectionModel().getSelectedIndex();
    	if(indice>=0 ) {
    		Hoteles.getInstancia().setModificarHotel(true);
    		Hoteles.getInstancia().setIndice(indice);
    		this.nuevaVentana("Hotel");
    	}
    	else {
    		Alert alerta;
    		alerta=new Alert(AlertType.INFORMATION);
    		alerta.setTitle("Dialogo de aviso");
    		alerta.setHeaderText("Se necesita una fila");
    		alerta.setContentText("Por favor selecciona una fila, para la modificar");
    		Optional<ButtonType> resultado=alerta.showAndWait();
    		if(resultado.get ().equals (OK)) {
    			
    		}
    	}
    }

    @FXML
    void nuevoHotel(ActionEvent event) {
    	Hoteles.getInstancia().setIndice(-1);
    	Hoteles.getInstancia().setModificarHotel(false);
    	Hoteles.getInstancia().setIndiceHabitacion(-1);
    	Hoteles.getInstancia().getGrupoHoteles().add(new Hotel());
    	this.nuevaVentana("hotel");
    }

    @FXML
    void salir(ActionEvent event) {
    	Platform.exit();

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.clmNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.clmDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		this.clmCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
		this.clmTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		this.clmGerente.setCellValueFactory(new PropertyValueFactory<>("gerente"));
		this.tblTabla.setItems(Hoteles.getInstancia().getGrupoHoteles());
	}
	
}
