package com.example.netty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class hello {
    @Autowired
    WebClient webClient;

    @GetMapping("/")
    public Mono<String> index() throws URISyntaxException, IOException, InterruptedException {
        Mono<String> result = webClient.get().uri("https://api.coindesk.com/v1/bpi/currentprice.json")
                .retrieve()
                .bodyToMono(String.class);
        return result;
    }
}

class Resp{
    private final String result;

    public String getResult() {
        return result;
    }

    Resp(String result) {
        this.result = result;
    }
}



