package controllers;
import helper.*;
import play.mvc.*;
import javax.inject.Inject;

import play.mvc.*;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import helper.*;

public class TopicsClassInfo {

    public CompletableFuture<Topic> topicProfilePage(GitCommonWrapper gcw) {
        // TODO Auto-generated method stub
        return gitHubRestAPIs.getTopicsList(gcw).thenApplyAsync(
                json -> mapper.convertValue(json, new TypeReference<Topic>() {})
        );
    }



}