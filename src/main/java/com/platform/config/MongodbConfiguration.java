package com.platform.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zjy on 17/7/5.
 */

@Configuration
@EnableConfigurationProperties(MongodbProperties.class)
public class MongodbConfiguration {

    private final MongodbProperties mongodbProperties;

    public MongodbConfiguration(MongodbProperties mongodbProperties) {
        this.mongodbProperties = mongodbProperties;
    }


    @Bean
    public MongoClient mongoClient (){
        ServerAddress address = new ServerAddress(mongodbProperties.getHost(),mongodbProperties.getPort());
        MongoCredential credential = MongoCredential.createCredential(mongodbProperties.getUsername(),mongodbProperties.getAuthDatabase(),mongodbProperties.getPassword().toCharArray());
        List credentialList = new ArrayList<>();
        credentialList.add(credential);
        return new MongoClient(address,credentialList);

    }

    @Bean
    public Datastore datastore(){
        Morphia morphia = new Morphia();
        morphia.mapPackage(mongodbProperties.getMapPackage());
        Datastore datastore = morphia.createDatastore(mongoClient(),mongodbProperties.getDatabase());
        datastore.ensureIndexes();
        return datastore;
    }

}
