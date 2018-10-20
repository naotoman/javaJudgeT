package judge;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Main {

    public static void main(String[] args) {

        try {
            Class solv = Class.forName(args[0]);
            Class prob = Class.forName(args[1]);
            long timeLimitMillis = Integer.parseInt(args[2]);
            List<Path> files = Files.list(Paths.get(args[3])).collect(Collectors.toList());
            files.sort(Comparator.comparing(Path::getFileName));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
