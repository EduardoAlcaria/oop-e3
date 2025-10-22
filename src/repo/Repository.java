package repo;

import domain.Games;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repository {

    private static final Path path = Paths.get("special", "ser", "arquivoTriAfuder.ser");

    public static <T> void serialize(List<T> listTriAfuder) throws IOException {


        Files.createDirectories(path.getParent());


        if (Files.notExists(path)) {
            Files.createFile(path);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(listTriAfuder);
        }

    }


    public static <T> List<T> deserialize() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Object objDeser = ois.readObject();
            if (objDeser instanceof List) {
                return (List<T>) objDeser;
            }else {
                throw new IllegalArgumentException("you have tried to deserialize something" +
                        "that is not a List");
            }
        }


    }


}
