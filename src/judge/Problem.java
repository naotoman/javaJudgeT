package judge;

import java.util.List;

public interface Problem {

    Status judge(List<List<String>> input, List<List<String>> answer);
}
