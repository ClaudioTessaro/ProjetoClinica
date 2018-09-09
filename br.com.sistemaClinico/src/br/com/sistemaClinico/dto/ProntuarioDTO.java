package br.com.sistemaClinico.dto;

import java.util.Date;

public class ProntuarioDTO {
	
	
	private Integer idProntuario;
	private Date dataDeEntrada;
	private String exameInicial;
	private Date dataDeSaida;
	private String medicamentos;
	private String tratamentos;
	
	
	public Integer getIdProntuario() {
		return idProntuario;
	}
	public void setIdProntuario(Integer idProntuario) {
		this.idProntuario = idProntuario;
	}
	
	public Date getDataDeEntrada() {
		return dataDeEntrada;
	}
	public void setDataDeEntrada(Date dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}
	public String getExameInicial() {
		return exameInicial;
	}
	public void setExameInicial(String exameInicial) {
		this.exameInicial = exameInicial;
	}
	public Date getDataDeSaida() {
		return dataDeSaida;
	}
	public void setDataDeSaida(Date dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}
	public String getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	public String getTratamentos() {
		return tratamentos;
	}
	public void setTratamentos(String tratamentos) {
		this.tratamentos = tratamentos;
	}
	
	

}
