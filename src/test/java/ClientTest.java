import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import org.junit.Test;

public class ClientTest {

    private static final String SUFFIX = "://dev.sphere.io";
    private static final String HTTP_URL = "http" + SUFFIX;
    private static final String HTTPS_URL = "https" + SUFFIX;

    @Test
    public void withAcceptAnyCertificateEverythingWorksFine() throws Exception {
        try(final AsyncHttpClient asyncHttpClient = new AsyncHttpClient(new AsyncHttpClientConfig.Builder()
                .setAcceptAnyCertificate(true)
                .build())) {
            asyncHttpClient.prepareGet(HTTPS_URL).execute().get();
        }
    }

    @Test
    public void doesNotConnectToHttps() throws Exception {
        try(final AsyncHttpClient asyncHttpClient = new AsyncHttpClient()) {
            asyncHttpClient.prepareGet(HTTPS_URL).execute().get();
        }
    }

    @Test
    public void httpWorks() throws Exception {
        try(final AsyncHttpClient asyncHttpClient = new AsyncHttpClient()) {
            asyncHttpClient.prepareGet(HTTP_URL).execute().get();
        }
    }
}
