package helper;
import play.libs.ws.*;
import play.mvc.Http;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.JsonNode;
import play.api.http.HeaderNames.*;
import controllers.HomeController;

import java.util.*;

public class helper {
    private final WSClient ws;

    @Inject
    public helper(WSClient ws) {
        this.ws = ws;
    }




    public CompletableFuture<JsonNode> topicInfoRequest(String topic)
    {
        String url_for_request = "https://api.github.com/search/repositories";
        JsonNode js = null;
        return ws.url(url_for_request)
                .addHeader(Http.HeaderNames.ACCEPT, "application/vnd.github.v3+json")
                .addHeader(Http.HeaderNames.AUTHORIZATION, "Bearer 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")
                .addQueryParameter("q", "topic:" + topic)
                .addQueryParameter("sort", "updated")
                .addQueryParameter("direction", "desc")
                .addQueryParameter("per_page", "10")
                .addQueryParameter("page", "1")
                .get()
                .thenApplyAsync(WSResponse::asJson)
                .toCompletableFuture();
    }
}



