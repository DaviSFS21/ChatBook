import java.io.*;

import java.util.UUID;
import io.github.cdimascio.dotenv.Dotenv;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class CodeSaver {
    public static String createFile(String code) {
        String name = UUID.randomUUID() + ".html";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/java/pages/" + name))) {
            writer.write(code);
        } catch (IOException e) {
            System.out.println("Error creating HTML file: " + e.getMessage());
        }
        pushMods();
        return "https://frontend-chat-preview.vercel.app/" + name;
    }

    private static void pushMods() {
        Dotenv dotenv = Dotenv.load();
        String accessToken = dotenv.get("ACCESS_TOKEN");

        try {
            Git git = Git.open(new File("."));

            git.add().addFilepattern("src/main/java/pages/").call();
            git.commit().setMessage("Automated commit from CodeSaver").call();

            git.push()
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider("DaviSFS21", accessToken))
                    .setRemote("origin")
                    .setRefSpecs(new RefSpec("refs/heads/main"))
                    .call();

            System.out.println("Push realizado com sucesso!");

        } catch (GitAPIException | IOException e) {
            e.printStackTrace();
        }
    }
}
