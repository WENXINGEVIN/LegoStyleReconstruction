package legoStyleReconstruction.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessBuilderHelper {

    private List<String> CMD_ARRAY;

    public ProcessBuilderHelper(String... args) {
        this.CMD_ARRAY = new ArrayList<>();
        CMD_ARRAY.add("sh");
        CMD_ARRAY.add("-c");
        Collections.addAll(CMD_ARRAY, args);
    }

    public List<String> getCMD_ARRAY() {
        return CMD_ARRAY;
    }
}
