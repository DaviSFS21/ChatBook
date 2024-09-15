import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
// import io.github.ollama4j.models.response.OllamaResult;
// import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;

public class Ollama {
    String host = "http://localhost:11434/";

    public String getOllamaResponse(String prompt) throws OllamaBaseException, IOException, InterruptedException {
        OllamaAPI ollamaAPI = new OllamaAPI(host);

        ollamaAPI.setRequestTimeoutSeconds(1000);

        Functions functions = new Functions();
        String response = "";
        try {
            response = functions.teste(ollamaAPI, prompt);
        } catch (Exception error) {
            System.out.println(error);
        }

        return response;
    }
}