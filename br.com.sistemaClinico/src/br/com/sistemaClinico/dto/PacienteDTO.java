package br.com.sistemaClinico.dto;

import java.util.Date;

public class PacienteDTO {
	
	private Integer idPaciente;
	private String nomePaciente;
	private Character sexoPaciente;
	private Date dtNascimento;
	private Long CPF;
	private EnderecoDTO enderecoDTO;
	private ContatoDTO contatoDTO;
	private ProntuarioDTO prontuarioDTO;
	
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public Character getSexoPaciente() {
		return sexoPaciente;
	}
	public void setSexoPaciente(Character sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public Long getCPF() {
		return CPF;
	}
	public void setCPF(Long cPF) {
		CPF = cPF;
	}
	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}
	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}
	public ContatoDTO getContatoDTO() {
		return contatoDTO;
	}
	public void setContatoDTO(ContatoDTO contatoDTO) {
		this.contatoDTO = contatoDTO;
	}
	public ProntuarioDTO getProntuarioDTO() {
		return prontuarioDTO;
	}
	public void setProntuarioDTO(ProntuarioDTO prontuarioDTO) {
		this.prontuarioDTO = prontuarioDTO;
	}
	
	
	

}
