import java.io.*;

import java.util.UUID;
import io.github.cdimascio.dotenv.Dotenv;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class CodeSaver {
    public static void Local(String code) {
        String name = UUID.randomUUID() + ".html";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/java/pages/" + name))) {
            writer.write(code);
            System.out.println("HTML file created successfully!");
            System.out.println("https://chat-book-omega.vercel.app/" + name);
        } catch (IOException e) {
            System.out.println("Error creating HTML file: " + e.getMessage());
        }
        CodeSaver.Push();
    }

    public static void Push() {
        Dotenv dotenv = Dotenv.load();
        String accessToken = dotenv.get("ACCESS_TOKEN"); // Seu token de acesso

        try {
            Git git = Git.open(new File("."));

            // Adicionar arquivos e fazer commit
            git.add().addFilepattern("src/main/java/pages/").call();
            git.commit().setMessage("Automated commit from CodeSaver").call();

            // Configurar credenciais e fazer push
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
