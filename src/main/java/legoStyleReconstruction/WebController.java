package legoStyleReconstruction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "bootstraphelloworld";
    }

    @ResponseBody
    @RequestMapping(value="/greeting",method = RequestMethod.GET)
    public String Greeting(){
        return "greeting";
    }

    @RequestMapping(value = "/r2n2", method = RequestMethod.GET)
    public String r2n2() {
        return "webvr_vive_dragging";
    }
}
