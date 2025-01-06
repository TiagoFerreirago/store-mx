package com.mx.product_catalog.config;

import java.time.Duration;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = "com.mx.product_catalog.repository")
@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200") // HTTPS com porta
                .withSocketTimeout(Duration.ofSeconds(10))
                .withConnectTimeout(Duration.ofSeconds(5))
                .build();
    }

    @Override
    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
        return new ElasticsearchCustomConversions(customConversions());
    }

    private List<Object> customConversions() {
        return List.of();
    }
}
