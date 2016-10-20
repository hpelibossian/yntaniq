package com.yntaniq.elasticsearch.configuration;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;
import java.util.concurrent.TimeUnit;
import java.net.InetAddress;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import javax.annotation.Resource;

@Configuration
//@PropertySource(value = "classpath:elasticsearch.properties")
@EnableElasticsearchRepositories(basePackages = "com.yntaniq.elasticsearch.repository")
public class ElasticsearchConfiguration {

    @Resource
    private Environment environment;
  /*  @Bean
    public Client client() {
        TransportClient client = new TransportClient();
        TransportAddress address = new InetSocketTransportAddress(environment.getProperty("elasticsearch.host"), Integer.parseInt(environment.getProperty("elasticsearch.port")));
        client.addTransportAddress(address);
        return client;
    }*/

    private static NodeClient getNodeClient() {
        return (NodeClient) nodeBuilder().client(true).build().client();
        //.clusterName(UUID.randomUUID().toString()).local(true).node().client();
    }



    private Client getClient() {
        Client retclient = null;
        if ((retclient == null)) {
            try {
                Settings settings = Settings.settingsBuilder()
                        .put("cluster.name", "hratchia-application").build();
                TransportClient tClient = TransportClient.builder().settings(settings).build()
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
                retclient = tClient;



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retclient;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(getClient());
    }

}
