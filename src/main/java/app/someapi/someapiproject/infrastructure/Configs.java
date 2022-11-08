package app.someapi.someapiproject.infrastructure;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configs {

  @Bean
  public List<ClientHttpRequestInterceptor> interceptors() {
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
    //TODO: dodqc do klasy konfiguracyjnej
    interceptors.add(new HttpHeaderInterceptor("x-rapidapi-key", "c2105de165msh37de1398ce37d9dp1d47d0jsne294e6641518"));
    interceptors.add(new HttpHeaderInterceptor("x-rapidapi-host", "api-football-beta.p.rapidapi.com"));
    return interceptors;
  }

  @Bean
  public RestTemplate restTemplate(List<ClientHttpRequestInterceptor> interceptors) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setInterceptors(interceptors);
    return restTemplate;
  }
}
