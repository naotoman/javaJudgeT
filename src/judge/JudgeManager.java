package judge;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.List;

final class JudgeManager {

    void run(Class solv, Problem problem, long timeLimitMillis, List<Path> inputs) {
        InputMan pToL = new InputMan();
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
            List<List<String>> input = pToL.pathToList(inputs.get(i));
            List<List<String>> copied = pToL.copyList(input);
            long startTimeNanos = System.nanoTime();
            List<List<String>> answer = solver.solve(copied);
            long elapsedTimeMillis = (System.nanoTime() - startTimeNanos) / 1000_000;
            Status state = problem.judge(input, answer);
            if (elapsedTimeMillis > timeLimitMillis) {
                System.out.print("TLE");
            }
            else if (state == Status.WRONG_ANSWER) {
                System.out.print("WA");
            }
            else {
                System.out.print(state.getScore());
            }
            System.out.println("    (" + elapsedTimeMillis + "ms)");
        }
        //結果の出力

    }
}
