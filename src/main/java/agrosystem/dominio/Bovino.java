package agrosystem.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import agrosystem.dominio.enumeracao.Raca;
import agrosystem.dominio.enumeracao.Sexo;
import agrosystem.dominio.enumeracao.Situacao;
import agrosystem.utilitarios.Utilitario;

@Entity
@Table(name = "bovinos")
public class Bovino implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String brinco;
	private String nome;
	private Situacao situacao;
	private Sexo sexo;
	private String brincoMae;
	private String brincoPai;
	private Raca raca;
	private LocalDate dataNascimento;
	private LocalDate dataPrenhes;
	private LocalDate dataUltimoParto;
	
	public Bovino() {
	}//Construtor
	
	public Bovino(String brinco, String nome, Situacao situacao, Sexo sexo, String brincoMae, String brincoPai,
			Raca raca, LocalDate dataNascimento, LocalDate dataPrenhes, LocalDate dataUltimoParto) {
		super();
		this.brinco = brinco;
		this.nome = nome;
		this.situacao = situacao;
		this.sexo = sexo;
		this.brincoMae = brincoMae;
		this.brincoPai = brincoPai;
		this.raca = raca;
		this.dataNascimento = dataNascimento;
		this.dataPrenhes = dataPrenhes;
		this.dataUltimoParto = dataUltimoParto;
	}//Construtor
	
	public Bovino(String brinco, String nome, String situacao, String sexo, String brincoMae, String brincoPai,
			String raca, String dataNascimento, String dataPrenhes, String dataUltimoParto) {
		super();
		this.brinco = brinco;
		this.nome = nome;
		this.situacao = Situacao.converterStringParaSituacao(situacao);
		this.sexo = Sexo.converterStringParaSexo(sexo);
		this.brincoMae = brincoMae;
		this.brincoPai = brincoPai;
		this.raca = Raca.converterStringParaRaca(raca);
		this.dataNascimento = LocalDate.parse(dataNascimento, Utilitario.DIA_MES_ANO_FORMATTER);
		this.dataPrenhes = LocalDate.parse(dataPrenhes, Utilitario.DIA_MES_ANO_FORMATTER);;
		this.dataUltimoParto = LocalDate.parse(dataUltimoParto, Utilitario.DIA_MES_ANO_FORMATTER);;
	}//Construtor

	public Integer getId() {
		return id;
	}//getId()

	public void setId(Integer id) {
		this.id = id;
	}//setId()

	public String getBrinco() {
		return brinco;
	}//getBrinco()
	
	public void setBrinco(String brinco) {
		this.brinco = brinco;
	}//setBrinco()
	
	public String getNome() {
		return nome;
	}//getNome()
	
	public void setNome(String nome) {
		this.nome = nome;
	}//setNome()
	
	public Situacao getSituacao() {
		return situacao;
	}//getSituacao()
	
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}//setSituacao()
	
	public Sexo getSexo() {
		return sexo;
	}//getSexo()
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}//setSexo()
	
	public String getBrincoMae() {
		return brincoMae;
	}//getBrincoMae()
	
	public void setBrincoMae(String brincoMae) {
		this.brincoMae = brincoMae;
	}//setBrincoMae()
	
	public String getBrincoPai() {
		return brincoPai;
	}//getBrincoPai()
	
	public void setBrincoPai(String brincoPai) {
		this.brincoPai = brincoPai;
	}//setBrincoPai()
	
	public Raca getRaca() {
		return raca;
	}//getRaca()
	
	public void setRaca(Raca raca) {
		this.raca = raca;
	}//setRaca()
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}//getDataNascimento()
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}//setDataNascimento()
	
	public LocalDate getDataPrenhes() {
		return dataPrenhes;
	}//getDataPrenhes()
	
	public void setDataPrenhes(LocalDate dataPrenhes) {
		this.dataPrenhes = dataPrenhes;
	}//setDataPrenhes()
	
	public LocalDate getDataUltimoParto() {
		return dataUltimoParto;
	}//getDataUltimoParto()
	
	public void setDataUltimoParto(LocalDate dataUltimoParto) {
		this.dataUltimoParto = dataUltimoParto;
	}//setDataUltimoParto()

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bovino id: ").append(id).append(", brinco: ").append(brinco).append(", nome: ").append(nome).append("\n")
		.append(", situacao: ").append(situacao).append(", sexo: ").append(sexo).append(", brinco da Mãe: ").append(brincoMae)
		.append("\n").append(", brinco do Pai: ").append(brincoPai).append(", raça: ").append(raca).append(", data de nascimento: ")
		.append(dataNascimento.format(Utilitario.DIA_MES_ANO_FORMATTER)).append(", data de prenhes: ")
		.append(dataPrenhes.format(Utilitario.DIA_MES_ANO_FORMATTER)).append("\n").append(", data do ultimoParto: ")
		.append(dataUltimoParto.format(Utilitario.DIA_MES_ANO_FORMATTER));
		return builder.toString();
	}//toString()
}//Bovino
