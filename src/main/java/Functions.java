import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;

public class Functions {
    public String convertDescriptionToCode(OllamaAPI ollamaAPI, String prompt) throws OllamaBaseException, IOException, InterruptedException {
        OllamaResult result = ollamaAPI.generate("llama2:7b", prompt, false, new OptionsBuilder().build());

        String code = cleanCode(result.getResponse());

        String vercelLink = CodeSaver.createFile(code);

        return vercelLink;
    }

    private String cleanCode(String code) {
        return code;
    }
}
