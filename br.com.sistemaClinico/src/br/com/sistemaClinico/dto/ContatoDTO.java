package br.com.sistemaClinico.dto;

public class ContatoDTO {
	
	
	private Integer idContato;
	private Integer celular;
	private Integer telefoneFixo;
	private String email;
	
	
	public Integer getIdContato() {
		return idContato;
	}
	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}
	public Integer getCelular() {
		return celular;
	}
	public void setCelular(Integer celular) {
		this.celular = celular;
	}
	public Integer getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(Integer telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
