package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@RestController
public class TestController {


    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    DemoService demoService;


    String apiToken = "Dad-v7bHBTwFg6hx1C7kGjFhvt7lbPy9fuiubk1Y";

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello World";
    }

    @GetMapping("/cloudflare")
    public ResponseEntity<String> getZoneInfo(@RequestParam String zoneId)
    {
        String api_url = "https://api.cloudflare.com/client/v4/zones/" + zoneId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer " + apiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(api_url, HttpMethod.GET, entity, String.class);

    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam String name)
    {
        return "Hello " + name;
    }

    @GetMapping(path = "/allemp")
    public List<Employee> listEmp()
    {
        return demoService.listEmp();
    }


}
