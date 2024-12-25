package com.hust.ai;

import com.hust.ai.visual_search.VisualSearchClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ai")
public class AiController {
    @Resource
    VisualSearchClient visualSearchClient;

    @GetMapping(value = "/suggest")
    public List<String> suggestImg(@RequestParam String img) {
        return visualSearchClient.suggestImg(img);
    }
}
