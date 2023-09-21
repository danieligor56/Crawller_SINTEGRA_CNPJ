function consultarCNPJ() {
  var cnpj = document.getElementById("cnpjInput").value;
  var url = 'http://25.6.206.68:8080/cnpj=' + cnpj;

  fetch(url, {
    method: "GET", // ou 'POST', 'PUT', 'DELETE', etc., dependendo do tipo de requisição
    headers: {
      // Adicione quaisquer cabeçalhos necessários aqui
    },
  })
    .then(function (response) {
      if (!response.ok) {
        throw new Error("Erro na requisição: " + response.status);
      }
      return response.json(); // ou response.text() se a resposta for texto
    })
    .then(function (data) {
      console.log("Dados recebidos:", data);

      document.getElementById("cnpj").textContent = data.cnpj;
      document.getElementById("ie").textContent = data.ie;
      document.getElementById("rsocial").textContent = data.rsocial;
      document.getElementById("logradouro").textContent = data.logradouro;
      document.getElementById("num").textContent = data.num;
      document.getElementById("bairro").textContent = data.bairro;
      document.getElementById("munic").textContent = data.munic;
      document.getElementById("cep").textContent = data.cep;
      document.getElementById("uf").textContent = data.uf;
      document.getElementById("tel").textContent = data.tel;
      document.getElementById("sitCadVig").textContent = data.sitCadVig;
      document.getElementById("datIniAtv").textContent = data.datIniAtv;
      document.getElementById("tipRegRec").textContent = data.tipRegRec;
      document.getElementById("opSimples").textContent = data.opSimples;
    })
    .catch(function (error) {
      console.error("Erro:", error);
    });
}
