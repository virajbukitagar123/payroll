package org.example.payroll.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getAllEmployees() throws Exception{
        assertThat(this.testRestTemplate.getForObject("http://localhost:"+port+"/employees",String.class))
                .contains("Bilbo");
    }

    @Test
    void getEmployee() {
        assertThat(this.testRestTemplate.getForObject("http://localhost:"+port+"/employees/2",String.class))
                .contains("Frodo");
    }
}