import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import io.github.cdimascio.dotenv.Dotenv;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class CodeSaver {
    public String Local(String code) {
        String name = UUID.randomUUID() + ".html";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./pages"))) {
            writer.write(code);
            System.out.println("HTML file created successfully!");
            System.out.println("https://frontend-chat-preview.vercel.app/" + name);
        } catch (IOException e) {
            System.out.println("Error creating HTML file: " + e.getMessage());
        }
    }

    public void Push() {
        Dotenv dotenv = Dotenv.load();
        String accessToken = dotenv.get(ACCESS_TOKEN); // Seu token de acesso

        try {
            FileRepositoryBuilder builder = new FileRepositoryBuilder();
            Repository repository = builder.setGitDir(new File(repoPath))
                    .readEnvironment()
                    .findGitDir()
                    .build();
            Git git = new Git(repository);

            // Adicionar arquivos e fazer commit
            git.add().addFilepattern(".").call();
            git.commit().setMessage("Automated commit from chatbot").call();

            // Configurar credenciais e fazer push
            git.push()
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider("DaviSFS21", accessToken))
                    .setRemote("origin")
                    .setRefSpecs(new RefSpec("refs/heads/main"))
                    .call();

            System.out.println("Push realizado com sucesso!");

        } catch (GitAPIException e) {
            e.printStackTrace();
        } catch (GitAPIException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
