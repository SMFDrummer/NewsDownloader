package net.heishanrm;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Poster {
    private static String urlGenerator(String timeStamp) {
        return "https://heishan.bdy.lnyun.com.cn/cloud/apis/cms/app/channel/arts?ordertime="+timeStamp+"&channelid=110&isfirst=false&pageid=20";
    }

    public static String post(String timeStamp) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlGenerator(timeStamp)))
                .header("Cookie", "acw_tc=0b62602a17079857334328156e0715376b1d235b14318401013c624f9bd6ce")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
