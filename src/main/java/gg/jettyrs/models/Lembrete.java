package gg.jettyrs.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lembrete {

	@JsonProperty("id")
	private long id;
	
	@JsonProperty("texto")
	private String texto;

	public Lembrete() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
