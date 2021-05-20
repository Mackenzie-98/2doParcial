package co.empresa.segundoParcial.modelo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cyclist implements Serializable {
	private int id;
	private String name;
	private String email;
	private Date birthDate;
	private String id_country;
	private String id_team;
}
