package qzy.trial.sharding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qzy.trial.sharding.entity.Log;
import qzy.trial.sharding.repository.LogRepository;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogRepository logRepository;

    @GetMapping("/add")
    public Object add(){

        for (int i = 0; i < 10; i++) {
            Log log = new Log();
            log.setId((long)i);
            log.setAppId((long)i);
            log.setTitle(""+log.hashCode());
            logRepository.save(log);
        }

        return "success";

    }

    @GetMapping("list")
    private Object list() {
        return logRepository.findAll();
    }
}
