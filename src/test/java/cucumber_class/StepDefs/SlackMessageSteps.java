package cucumber_class.StepDefs;

import api_homework.GetSlackMessageURI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URISyntaxException;

public class SlackMessageSteps {

    @Given("user verifies the message is not in the channel")
    public void userVerifiesTheMessageIsNotInTheChannel() throws IOException, URISyntaxException {

        GetSlackMessageURI.uri_Def();

    }




    @When("user posts a message in a slack")
    public void userPostsAMessageInASlack() {

    }
    @Then("user verifies if the message was sent")
    public void userVerifiesIfTheMessageWasSent() {

    }


}
