package legoStyleReconstruction.controller;

import legoStyleReconstruction.util.StreamGobbler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

@RestController
public class RestfulController {

    @GetMapping(value = "api/trigger/imageResizeScript")
    public String triggerImageResize() {
        String scriptLog = "balabala";
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh", "-c", "python ext-resources/script/imageResize.py ext-resources/upload-dir");
//        builder.command("sh", "-c", "ls", System.getProperty("user.dir")+"/src/");
//        builder.command("sh", "-c", "ls ext-resources");
        builder.directory(new File(System.getProperty("user.dir")));
        Process process = null;
        try {
            process = builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StreamGobbler streamGobbler = new StreamGobbler(process != null ? process.getInputStream() : null,
                System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = 0;
        try {
            if (process != null) {
                exitCode = process.waitFor();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert exitCode == 0;
        return "success";
    }
}
