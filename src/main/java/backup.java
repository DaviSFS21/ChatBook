//import io.github.ollama4j.OllamaAPI;
//import io.github.ollama4j.exceptions.OllamaBaseException;
//import io.github.ollama4j.exceptions.ToolInvocationException;
//import io.github.ollama4j.tools.OllamaToolsResult;
//import io.github.ollama4j.tools.Tools;
//import io.github.ollama4j.utils.OptionsBuilder;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.Arrays;
//import java.util.Map;
//
//
//    public static String ask(OllamaAPI ollamaAPI, String prompt) throws OllamaBaseException, IOException, InterruptedException, ToolInvocationException {
//        String model = "mistral";
//
//        OllamaToolsResult toolsResult = ollamaAPI.generateWithTools(model, prompt, new OptionsBuilder().build());
//
//        StringBuilder resultBuilder = new StringBuilder();
//        for (OllamaToolsResult.ToolResult r : toolsResult.getToolResults()) {
//            resultBuilder.append(String.format("[Result of executing tool '%s']: %s%n", r.getFunctionName(), r.getResult().toString()));
//        }
//        System.out.println("resultBuilder" + resultBuilder);
//
//        return resultBuilder.toString();
//    }
//}
//

//"The image appears to be a screenshot of an application interface, which seems to be for a " +
//                "mobile or web-based app. The layout is designed with a purple and white color scheme. The top part " +
//                "shows a user profile with the name 'Jonathan' and a placeholder image that looks like a photo of a " +
//                "person's face.Below this, there are sections titled 'My Profile', 'My Skills', and 'My Certifications'. " +
//                "Each section seems to have fields for inputting information such as text boxes, buttons with icons "+
//                "that suggest actions like uploading a photo or profile picture, and possibly a progress bar indicating " +
//                "some form of status. The middle part of the screenshot is more detailed and appears to be a mock-up or " +
//                "prototype of the app's functionality. There are cards representing different types of content such as " +
//                "posts, events, and products. Each card has a thumbnail image, a title, and some descriptive text. " +
//                "The design suggests that users can create, view, and interact with these different types of content " +
//                "within the app. The bottom part of the screenshot shows a page with a navigation menu on the left " +
//                "side. This menu includes items like 'Dashboard', 'Settings', 'Notifications' and 'Logout'. There is " +
//                "also a search bar at the top right corner. Overall, the image displays an example of how a user " +
//                "interface for a mobile or web application might be designed to showcase different features and " +
//                "functionalities.";