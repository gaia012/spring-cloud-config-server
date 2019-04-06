package kr.co.gaia012.sample;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
public class RoutingRestController {

    @RequestMapping(method = RequestMethod.GET, value = "/hi/{name}")
    public Map<String, String> hi(@PathVariable String name, @RequestHeader(value = "X-CNJ-Name", required = false) Optional<String> cn) {
        String resolvedName = cn.orElse(name);
        return Collections.singletonMap("greeting", "Hello, " + resolvedName + "!");
    }
}
