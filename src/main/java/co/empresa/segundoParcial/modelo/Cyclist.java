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
	public Cyclist(String name,String email,Date birthDate,String id_country,String id_team) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.id_country = id_country;
		this.id_team = id_team;
	}
}
