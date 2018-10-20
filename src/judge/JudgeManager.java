package judge;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.List;

final class JudgeManager {

    void run(Class solv, Class prob, List<Path> inputs, long timeLimitMillis) {
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
        PathToList pToL = new PathToList();
        for(int i=0; i<inputs.size(); ++i) {
            Solver solver = null;
            try {
                solver = (Solver) solv.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            List<List<String>> input = pToL.toList(inputs.get(i));
            List<List<String>> copied = pToL.copyList(input);
            long startTimeNanos = System.nanoTime();
            List<List<String>> answer = solver.solve(copied);
            long elapsedTimeMillis = (System.nanoTime() - startTimeNanos) / 1000_000;
            Status state = problem.judge(input, answer);
        }
    }
}
