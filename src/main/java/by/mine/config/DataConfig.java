package by.mine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataConfig {

    @Bean
    private DataSource dataSource() {
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = databaseBuilder
                .setType(EmbeddedDatabaseType.DERBY)
                .addScript("derby/create.sql")
                .addScript("derby/insert.sql")
                .build();
        return db;
    }


}
