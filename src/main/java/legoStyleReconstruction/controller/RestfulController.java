package legoStyleReconstruction.controller;

import legoStyleReconstruction.util.ProcessBuilderHelper;
import legoStyleReconstruction.util.StreamGobbler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;

@RestController
public class RestfulController {

    @GetMapping(value = "api/trigger/imageResizeScript")
    public String triggerImageResize() {
        ProcessBuilder builder = new ProcessBuilder();
        ProcessBuilderHelper helper = new ProcessBuilderHelper(
                "python ext-resources/script/imageResize.py ext-resources/upload-dir");
        builder.command(helper.getCMD_ARRAY());
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

    @GetMapping(value = "api/trigger/modelScript")
    public String triggerModel() {
        ProcessBuilder builder = new ProcessBuilder();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss-SSSZ").format(new java.util.Date());
        ProcessBuilderHelper helper = new ProcessBuilderHelper(
                "python demo.py ext-resources/obj-dir/"+timeStamp+".obj"+" ext-resources/resized-dir");
        builder.command(helper.getCMD_ARRAY());
        /* the way to get home dir
           System.getProperty("user.home")
           the way to get current application running dir
           System.getProperty("user.dir")
         */
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
