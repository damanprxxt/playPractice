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

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }



    public CompletionStage<Result> topicsInfo(String topic){
        CompletableFuture<JsonNode> tInfo = helper.topicInfoRequest(topic);

        return ok(views.html.topicsInfo.Render(tInfo));

    }

}
