import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;

import java.io.IOException;

public class Ollama {
    String host = "http://localhost:11434/";

    public String getOllamaResponse(String prompt) throws OllamaBaseException, IOException, InterruptedException {
        OllamaAPI ollamaAPI = new OllamaAPI(host);

        ollamaAPI.setRequestTimeoutSeconds(1000);

        Images images = new Images();
        String response = "";
        try {
            response = images.teste(ollamaAPI, prompt);
        } catch (Exception error) {
            System.out.println(error);
        }

        return response;
    }
}