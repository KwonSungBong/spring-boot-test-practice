package com.example.demo.config;

import io.arivera.oss.embedded.rabbitmq.EmbeddedRabbitMq;
import io.arivera.oss.embedded.rabbitmq.EmbeddedRabbitMqConfig;
import io.arivera.oss.embedded.rabbitmq.OfficialArtifactRepository;
import io.arivera.oss.embedded.rabbitmq.PredefinedVersion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class TestEmbeddedRabbitMqConfig {

    @Value("${spring.rabbitmq.port:6666}")
    private int rabbitmqPort;

    private EmbeddedRabbitMq rabbitMq;

    @PostConstruct
    public void startRabbitMq() throws MalformedURLException {
//        String url = "https://github.com/rabbitmq/rabbitmq-server/releases/download/rabbitmq_v3_6_6_milestone1/rabbitmq-server-mac-standalone-3.6.5.901.tar.xz";
        String url = "https://github.com/rabbitmq/rabbitmq-server/releases/download/rabbitmq_v3_6_9/rabbitmq-server-generic-unix-3.6.9.tar.xz";

        EmbeddedRabbitMqConfig config = new EmbeddedRabbitMqConfig.Builder()
                .version(PredefinedVersion.V3_6_9)
//                .port(rabbitmqPort)
//                .downloadFrom(new URL(url), "rabbitmq_server-3.6.5.901")
//                .downloadTarget(new File("data/tmp/rabbitmq.tar.xz"))
//                .extractionFolder(new File("data/rabbits/"))
//                .useCachedDownload(false)
//                .deleteDownloadedFileOnErrors(false)
                .downloadFrom(new URL(url), "rabbitmq_server-3.6.9")
                .downloadProxy("localhost", 6666)
//                .downloadTarget(new File("/home/whilemouse/git/spring-boot-test-practice/rabbitmq/servers"))
                .extractionFolder(new File("/home/whilemouse/git/spring-boot-test-practice/rabbitmq/servers"))
                .useCachedDownload(true)
                .deleteDownloadedFileOnErrors(false)
                .build();

        rabbitMq = new EmbeddedRabbitMq(config);
        rabbitMq.start();
    }

    @PreDestroy
    public void stopRabbitMq() {
        rabbitMq.stop();
    }

}
