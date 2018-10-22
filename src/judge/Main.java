package judge;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Main {

    public static void main(String[] args) {

        try {
            Class solv = Class.forName(args[0]);
            Class prob = Class.forName(args[1]);
            Problem problem = null;
            try {
                problem = (Problem) prob.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            long timeLimitMillis = Integer.parseInt(args[2]);
            List<Path> files = Files.list(Paths.get(args[3])).collect(Collectors.toList());
            files.sort(Comparator.comparing(Path::getFileName));
            JudgeManager man = new JudgeManager();
            man.run(solv, problem, timeLimitMillis, files);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
