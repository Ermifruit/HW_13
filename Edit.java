import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class Edit {
    public String editMessage(String post) throws URISyntaxException, IOException {
        String anotherText = "Home Work 13";
        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.edit?");
        builder.setParameter("access_token", "034b41b35617a3d010821c0388129bd5a25a7805ef799c266f17d2ee16c75e99724141370000ccd976370")
                .setParameter("owner_id", "21376451")
                .setParameter("post_id", post)
                .setParameter("message", anotherText)
                .setParameter("v", "5.103");
        HttpGet request = new HttpGet(builder.build());
        HttpResponse response = client.execute(request);
        String idPost = EntityUtils.toString(response.getEntity()).substring(23,27);
        System.out.println("send "+idPost);
        return idPost;
    }
}
