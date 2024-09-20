import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Images {
    String model = "llava:7b";

    public String teste(OllamaAPI ollamaAPI, String prompt) throws OllamaBaseException, IOException, InterruptedException {
        OllamaResult result = ollamaAPI.generateWithImageFiles(model,
                prompt,
                List.of(new File("/home/augusto/Downloads/portfolio.png")),
                new OptionsBuilder().build()
        );
        System.out.println(result.getResponse());
        return result.getResponse();
    }
}
