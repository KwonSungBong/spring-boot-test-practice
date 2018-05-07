package com.example.demo.repository

import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
@Testcontainers
class TestRepositoryTests extends Specification {

    static final REDIS_PORT = 6379
    static final MYSQL_PORT = 3306

    @Shared
    DockerComposeContainer composeContainer = new DockerComposeContainer(
            new File("src/test/resources/docker-compose-test.yml"))
            .withExposedService("test_redis", REDIS_PORT)
            .withExposedService("test_mysql", MYSQL_PORT)
            .withPull(false)
            .withLocalCompose(true)


    def setupSpec() {
        System.setProperty("spring.redis.host", composeContainer.getServiceHost("test_redis", REDIS_PORT) as String)
        def tempRedisPort = composeContainer.getServicePort("test_redis", REDIS_PORT) as String
        System.setProperty("spring.redis.port", tempRedisPort)
        System.setProperty("spring.datasource.url",
                "jdbc:mysql://" + composeContainer.getServiceHost("test_mysql", MYSQL_PORT) + ":"
                        + composeContainer.getServicePort("test_mysql", MYSQL_PORT) + "/testtest?useSSL=false&useUnicode=true&characterEncoding=utf8")
        System.setProperty("spring.datasource.hikari.connection-timeout", "500")
    }

    @Unroll
    def "testtesttesttesttest"() {
        given:
        def data = "data"

        when:
        def test = "test+data"

        then:
        test.equals "test+${data}"
    }

}
