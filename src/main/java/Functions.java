import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    public String convertDescriptionToCode(OllamaAPI ollamaAPI, String prompt) throws OllamaBaseException, IOException, InterruptedException {
        String newPrompt = prompt +
                "\nOnly return the HTML and CSS code. Put the css code inside <style> tag. Do not write \"html\" before "+
                "the html code. Exclude explanations, comments, and JavaScript. Limit the response to a maximum of 4000 characters.";
        OllamaResult result = ollamaAPI.generate("llama2:7b", newPrompt, false, new OptionsBuilder().build());

        String code = cleanCode(result.getResponse());

        return CodeSaver.createFile(code);
    }

    private String cleanCode(String code) {
        String cleanCode = code;
        String regex = "(?s)(<!DOCTYPE html>.*?</html>)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);

        if (matcher.find()) {
            cleanCode = matcher.group(1);
        } else {
            System.out.println("Nenhum código HTML encontrado.");
        }

        return cleanCode;
    }
}
