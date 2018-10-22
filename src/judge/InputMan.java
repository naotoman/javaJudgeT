package judge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class InputMan {

    List<List<String>> pathToList(Path path) {
        List<List<String>> input = new ArrayList<>();
        try {
            List<String> dec = Files.readAllLines(path);
            for(String line : dec) {
                input.add(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    List<List<String>> copyList(List<List<String>> input) {
        List<List<String>> out = new ArrayList<>();
        for(List<String> line : input) {
            List<String> newLine = new ArrayList<>();
            for(String one : line) {
                newLine.add(one);
            }
            out.add(newLine);
        }
        return out;
    }
}
