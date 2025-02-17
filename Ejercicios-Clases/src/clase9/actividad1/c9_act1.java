package clase9.actividad1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c9_act1 {
    private static final String API_KEY = "73YX42U4VI50EUIB";
    private static final String SYMBOL = "MSFT";

    public static void main(String[] args) throws IOException {
        List<Double> prices = getStockPrices(SYMBOL);
        int K = 2; // Número de transacciones permitidas
        System.out.println("Máxima ganancia: " + maxProfit(K, prices));
    }

    public static List<Double> getStockPrices(String symbol) throws IOException {
        String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
                + symbol + "&apikey=" + API_KEY;
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

        return parseJson(content.toString());
    }

    private static List<Double> parseJson(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (Daily)");

        System.out.println(timeSeries); //Esta response es null, por lo que no se puede parsear


        TreeMap<String, Double> sortedPrices = new TreeMap<>(Collections.reverseOrder());
        for (String date : timeSeries.keySet()) {
            double closePrice = timeSeries.getAsJsonObject(date).get("4. close").getAsDouble();
            sortedPrices.put(date, closePrice);
        }
        return new ArrayList<>(sortedPrices.values());
    }

    public static int maxProfit(int K, List<Double> prices) {
        if (prices.isEmpty()) return 0;
        int n = prices.size();
        if (K >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices.get(i) > prices.get(i - 1))
                    maxProfit += (int) (prices.get(i) - prices.get(i - 1));
            }
            return maxProfit;
        }

        int[][] dp = new int[K + 1][n];
        for (int k = 1; k <= K; k++) {
            int maxDiff = (int) -prices.getFirst();
            for (int i = 1; i < n; i++) {
                dp[k][i] = (int) Math.max(dp[k][i - 1], prices.get(i) + maxDiff);
                maxDiff = (int) Math.max(maxDiff, dp[k - 1][i] - prices.get(i));
            }
        }
        return dp[K][n - 1];
    }
}

