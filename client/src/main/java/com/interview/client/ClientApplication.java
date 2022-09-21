package com.interview.client;

import com.interview.client.network.ClientC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ${USER}
 * @created ${DATE}
 * @project ${PROJECT_NAME}
 */
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);

        ClientC clientC = new ClientC();

        for(int i =0; i < 40; i++ ){
            clientC.makeRequest();
        }
        
    }
}