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
        return Arrays.asList("https://rukminim1.flixcart.com/image/612/612/xif0q/net/s/f/l/cricket-net-100x10-cricket-net-nylon-hdpe-i2services19-10-original-imagj78bgyphbt7v.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/xif0q/net/c/u/m/cricket-net-ground-boundary-net-10x10-feet-i2services10-3-048-original-imagj5d4ypybak3h.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/xif0q/ball/m/b/8/110-medium-weight-pack-of-1-rubber-cricket-tennis-ball-standard-original-imagk6zzxzz6uvez.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/klb78nk0/wicket/7/n/o/heavy-cricket-kit-15-age-group-victory-original-imagygyqncgf8t6a.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/jmp79u80/bat/p/d/f/1-2-long-handle-hitman-full-size-double-blade-poplar-cricket-bat-original-imaf9jagezy8zf7r.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/xif0q/ball/k/g/g/110-cricket-wind-ball-pack-of-1-made-in-india-smooth-cricket-original-imagk6zysvatjvck.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/kcdp5zk0/bat/a/s/3/900-1000-short-handle-bat-with-cover-na-ceat-six-hitman-original-imaftgtuhgzggqu4.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/xif0q/grip/a/q/6/cricket-bat-grip-handle-chevron-extra-tacky-cricket-grip-6-bat-original-imagkrnnwqwtqays.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/xif0q/bat/t/r/z/800-full-size-long-handle-long-handle-yellowbeast1133-grade-1-original-imaghdug58yjthm7.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/kuwzssw0/bat/j/r/b/400-junior-cricket-bat-size-3-for-age-group-8-years-3-junior-3-original-imag7xfpjbdshg57.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/kvzkosw0/bat/j/c/r/1-thrill-fox-heavy-duty-first-grade-hd-plastic-cricket-bat-long-original-imag8rmb3madedrw.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/ky0g58w0/sport-glove/m/x/h/left-right-regular-wicket-keeping-gloves-combo-with-inner-gloves-original-imagac4ax4yuzn4d.jpeg?q=70",
                "https://rukminim1.flixcart.com/image/612/612/kskotjk0/bat/r/k/o/800-very-strong-pvc-black-beauty-full-size-long-handle-black-pvc-original-imag643rc3n9zge4.jpeg?q=70"
);
        //return visualSearchClient.suggestImg(img);
    }
}
