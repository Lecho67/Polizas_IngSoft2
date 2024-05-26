package com.Polizas.Polizas.Infraestructura.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import com.Polizas.Polizas.Dominio.Models.Transaccion;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    private static final String API_URL = "https://open.er-api.com/v6/latest/COP";

    public BigDecimal obtainTRM(Transaccion transaccion) throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        JSONObject jsonResponse = new JSONObject(response.toString());

        JSONObject rates = jsonResponse.getJSONObject("rates");
        BigDecimal trm = rates.getBigDecimal(transaccion.getMoneda());

        con.disconnect();

        return trm;
    }

}
