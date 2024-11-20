import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;

public class Functions {
    public String convertTextToCode (OllamaAPI ollamaAPI, String prompt) throws OllamaBaseException, IOException, InterruptedException {
        return convertDescriptionToCode(ollamaAPI, prompt);
    }

    public String convertDescriptionToCode(OllamaAPI ollamaAPI) throws OllamaBaseException, IOException, InterruptedException {
        String prompt = "Generate responsive HTML and CSS code for a web app interface with these features:" +
            "- A purple and white color scheme." +
            "- Top section: user profile with the name 'Jonathan' and a placeholder profile picture." +
            "- Middle section: three cards for 'posts', 'events', and 'products', each with a thumbnail, title, and description." +
            "- Bottom section: navigation menu on the left with items like 'Dashboard', 'Settings', 'Notifications', "+
            "and 'Logout'. Include a search bar in the top-right corner." +
            "Only return the HTML and CSS code. Exclude explanations, comments, and JavaScript. Limit the response " +
            "to a maximum of 3000 characters";

        OllamaResult result = ollamaAPI.generate("llama2:7b", prompt, false, new OptionsBuilder().build());

        return result.getResponse();
    }
}
