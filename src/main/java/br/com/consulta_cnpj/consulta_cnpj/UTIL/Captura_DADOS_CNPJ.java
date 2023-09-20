package br.com.consulta_cnpj.consulta_cnpj.UTIL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.consulta_cnpj.consulta_cnpj.DTO.CNPJ_DTO;

@Service
public class Captura_DADOS_CNPJ {

	public static final Logger LOGGER = LoggerFactory.getLogger(Captura_DADOS_CNPJ.class);
	

	public CNPJ_DTO main(String link ) {
		System.setProperty("javax.net.ssl.trustStore", "/usr/lib/jvm/java-11-openjdk-amd64/lib/security/cacerts");
		
		
		Captura_DADOS_CNPJ capture = new Captura_DADOS_CNPJ();
		
		
		return capture.doc(link);

	}

	public CNPJ_DTO doc(String link) {
		
		CNPJ_DTO capt = new CNPJ_DTO();
		Document document = null;
		System.out.println();
		
		try {

			document = Jsoup.connect(link).get();
			//System.out.println("INDENTIFICAÇÃO: ");
			// CNPJ
			String cnpj = document.selectXpath("/html/body/section/div/div/div[2]/div/div/div/table[1]//tr/td[1]")
					.text();
			LOGGER.info("Cnpj: " + cnpj);
			capt.setCnpj(cnpj);
			
			// INSCRIÇÃO ESTADUAL
			String ie = document.selectXpath("//*[@id=\"dadossintegra\"]//tr/td[2]").text();
			LOGGER.info("Inscrição estadual: " + ie);
			capt.setIe(ie);
			// RAZÃO SOCIAL
			String rsocial = document.selectXpath("//*[@id=\"dadossintegra\"]//tr/td[3]").text();
			LOGGER.info("Razão social/Nome :" + rsocial);
			capt.setRsocial(rsocial);
			// ENDEREÇOS//
			//System.out.println("ENDEREÇO: ");
			// Logradouro
			String logradouro = document.selectXpath("//*[@id=\"enderecosintegara\"]/thead/tr[2]/td").first().text();
			LOGGER.info("Logradouro: " + logradouro);
			capt.setLogradouro(logradouro);
			// Numero
			String num = document.selectXpath("//*[@id=\"enderecosintegara\"]/thead/tr[3]/td[1]").first().text();
			LOGGER.info("Número: " + num);
			capt.setNum(num);
			// Bairro
			String bairro = document.selectXpath("//*[@id=\"enderecosintegara\"]/thead/tr[4]/td").first().text();
			LOGGER.info("Bairro: " + bairro);
			capt.setBairro(bairro);
			// Municipio
			String munic = document.selectXpath("//*[@id=\"enderecosintegara\"]/thead/tr[5]/td[1]").first().text();
			LOGGER.info("Municipio: " + munic);
			capt.setMunic(munic);
			// Cep
			String cep = document.selectXpath("//*[@id=\"enderecosintegara\"]/thead/tr[6]/td[1]").first().text();
			LOGGER.info("CEP: " + cep);
			capt.setCep(cep);
			// UF
			String uf = document.selectXpath("//*[@id=\"enderecosintegara\"]/thead/tr[5]/td[2]").first().text();
			LOGGER.info("UF: " + uf);
			capt.setUf(uf);
			// CONTATO
			//System.out.println("CONTATO: ");
			// TELEFONE
			String tel = document.selectXpath("//*[@id=\"enderecosintegara\"]/thead/tr[6]/td[2]").first().text();
			LOGGER.info("Telefone: " + tel);
			capt.setTel(tel);
			// INFORMAÇÕES COMPLEMENTARES
			//System.out.println("INFORMAÇÕES COMPLEMENTARES: ");
			// SITUAÇÃO CASTRAL VIGENTE
			String sitCadVig = document
					.selectXpath("/html/body/section/div/div/div[2]/div/div/div/table[3]/thead/tr[4]/td").text();
			LOGGER.info("Situação cadastral vigente: " + sitCadVig);
			capt.setSitCadVig(sitCadVig);
			// DATA DE INICIO DE ATIVIDADE
			String datIniAtv = document
					.selectXpath("/html/body/section/div/div/div[2]/div/div/div/table[3]/thead/tr[5]/td").first()
					.text();
			LOGGER.info("Data do inicio de atividade: " + datIniAtv);
			capt.setDatIniAtv(datIniAtv);
			// REGIME DE RECOLHIMENTO
			String tipRegRec = document
					.selectXpath("/html/body/section/div/div/div[2]/div/div/div/table[3]/thead/tr[7]/td").first()
					.text();
			LOGGER.info("Regime de recolhimento: " + tipRegRec);
			capt.setTipRegRec(tipRegRec);
			// OPÇÃO SIMPLES
			String opSimples = document
					.selectXpath("/html/body/section/div/div/div[2]/div/div/div/table[3]/thead/tr[11]/td").first()
					.text();
			LOGGER.info("Optante Simples: " + opSimples);
			capt.setOpSimples(opSimples);
		
		} catch (Exception e) {
			LOGGER.error("Erro ao conectar com o google JSOUP -> {}", e.getMessage());

		}
		return capt;
	}
	
	public String montaURL(String URL_BASE,String CNPJ) {
			try {
				return URL_BASE+CNPJ;
			} catch (Exception e) {
				LOGGER.error("Erro: CNPJ não encontrado {}", e.getMessage());
			}

		return null;
		}
}
