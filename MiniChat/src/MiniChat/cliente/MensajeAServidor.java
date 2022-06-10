package MiniChat.cliente;

import java.io.Serializable;

public class MensajeAServidor implements Serializable {
    private String nombreCliente;
    private String mensaje;

    public MensajeAServidor(String nombreCliente, String nuevoMensaje){
        this.nombreCliente = nombreCliente;
        this.mensaje = nuevoMensaje;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
        return mensaje;
    }
}
