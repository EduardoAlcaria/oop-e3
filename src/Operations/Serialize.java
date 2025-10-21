package Operations;

import enums.DefaultPaths;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;


public class Serialize implements OperarArquivo {

    @Override
    public void executar() throws IOException {
        Path path = DefaultPaths.SERIALIZE.getPath();

        Files.createDirectories(path.getParent());

        if (Files.notExists(path)){
            Files.createFile(path);
        }

        try (ObjectOutputStream oss = new ObjectOutputStream(Files.newOutputStream(path))){
            oss.writeObject("i am the storm that is approaching");
        }

        if (Files.size(path) > 0){

            System.out.println("data has been serialized!!!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
