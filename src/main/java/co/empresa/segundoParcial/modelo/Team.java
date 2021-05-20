package co.empresa.segundoParcial.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team implements Serializable {
	private String id;
	private String name;
	private String id_country;
}
