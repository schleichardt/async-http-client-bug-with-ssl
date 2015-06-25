import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import org.junit.Test;

public class ClientTest {

    private static final String URL = "https://dev.sphere.io";

    @Test
    public void withAcceptAnyCertificate() throws Exception {
        try(final AsyncHttpClient asyncHttpClient = new AsyncHttpClient(new AsyncHttpClientConfig.Builder()
                .setAcceptAnyCertificate(true)
                .build())) {
            asyncHttpClient.prepareGet(URL).execute().get();
        }
    }

    @Test
    public void defaultCase() throws Exception {
        try(final AsyncHttpClient asyncHttpClient = new AsyncHttpClient(new AsyncHttpClientConfig.Builder()
                .setAcceptAnyCertificate(false)
                .build())) {
            asyncHttpClient.prepareGet(URL).execute().get();
        }
    }
}
