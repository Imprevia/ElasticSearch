package com.imprevia.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.action.*;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.threadpool.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class ElasticSearchConfig {

    @Autowired
    private ElasticsearchProperties elasticsearchProperties;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        HttpHost httpHost = HttpHost.create("http://172.21.240.232:9200");
        RestClientBuilder builder = RestClient.builder(httpHost);
        return new RestHighLevelClient(builder);
    }

}
