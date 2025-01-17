package com.virtual.deployer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deployer")
public class DeployerRestController {

    @PostMapping
    public void deploy(@RequestParam String appType) {

        System.out.println("Deploying " + appType);


    }


}
