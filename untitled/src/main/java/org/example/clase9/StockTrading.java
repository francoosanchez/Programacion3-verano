package org.example.clase9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.google.gson.*;

public class StockTrading {
    private static final String API_KEY = "TU-API-KEY"; // Reemplaza con tu API Key
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=";

    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el símbolo de la acción (ejemplo: IBM, AAPL): ");
            String symbol = scanner.nextLine();


            // Obtener los datos de la API
            String jsonResponse = obtenerDatosAPI(symbol);

            // Paso 2: Convertir la respuesta JSON en un mapa ordenado de precios
            TreeMap<String, Double> precios = extraerPrecios(jsonResponse);

            // Paso 3: Convertir precios en un array para el algoritmo de programación dinámica
            double[] precioArray = precios.values().stream().mapToDouble(Double::doubleValue).toArray();

            // Número máximo de transacciones
            int K = 2;

            // Paso 4: Calcular la máxima ganancia
            double maxGanancia = maxProfit(K, precioArray);
            System.out.println("Máxima ganancia con " + K + " transacciones: " + maxGanancia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para obtener datos de la API
    private static String obtenerDatosAPI(String symbol) throws Exception {
        String urlString = BASE_URL + symbol + "&apikey=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();

        return content.toString();
    }

    // Método para extraer precios de cierre de la respuesta JSON
    private static TreeMap<String, Double> extraerPrecios(String json) {
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(json, JsonObject.class);
        JsonObject timeSeries = jsonResponse.getAsJsonObject("Time Series (Daily)");

        TreeMap<String, Double> sortedPrices = new TreeMap<>();
        for (Map.Entry<String, JsonElement> entry : timeSeries.entrySet()) {
            String fecha = entry.getKey();
            JsonObject dailyData = entry.getValue().getAsJsonObject();
            double cierre = dailyData.get("4. close").getAsDouble();
            sortedPrices.put(fecha, cierre);
        }
        return sortedPrices;
    }

    // Algoritmo de programación dinámica para calcular la máxima ganancia con K transacciones
    private static double maxProfit(int K, double[] precios) {
        int n = precios.length;
        if (n == 0 || K == 0) return 0;

        double[][] dp = new double[K + 1][n];

        for (int k = 1; k <= K; k++) {
            double maxDiff = -precios[0];
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], precios[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - precios[i]);
            }
        }

        return dp[K][n - 1];
    }
}

