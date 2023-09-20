package br.com.consulta_cnpj.consulta_cnpj.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CNPJ_DTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//INDENTIFICAÇÃO//
	private String cnpj;
	private String ie;
	private String rsocial;
	//ENDEREÇO//
	private String logradouro;
	private String num;
	private String bairro;
	private String munic;
	private String cep;
	private String uf;
	//COMUNICAÇÃO//
	private String tel;
	//INFORMAÇÕES COMPLEMENTARES//
	private String sitCadVig;
	private String datIniAtv;
	private String tipRegRec;
	private String opSimples;
	
	
	
	
	
	


}
