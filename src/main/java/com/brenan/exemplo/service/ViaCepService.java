package com.brenan.exemplo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.brenan.exemplo.model.Endereco;

public class ViaCepService {

    private static final String URL_VIACEP = "https://viacep.com.br/ws/{cep}/json/";

    public Endereco consultarEnderecoPorCep(String cep) throws Exception {
        String urlString = URL_VIACEP.replace("{cep}", cep);
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonResponse = new JSONObject(response.toString());

        Endereco endereco = new Endereco();
        endereco.setCep(jsonResponse.optString("cep"));
        endereco.setLogradouro(jsonResponse.optString("logradouro"));
        endereco.setBairro(jsonResponse.optString("bairro"));
        endereco.setCidade(jsonResponse.optString("localidade"));
        endereco.setEstado(jsonResponse.optString("estado"));

        return endereco;
    }
}
