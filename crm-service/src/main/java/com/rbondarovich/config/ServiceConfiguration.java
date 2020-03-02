package com.rbondarovich.config;

import com.rbondarovich.dao.config.DaoConfiguration;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Import(DaoConfiguration.class)

@Configuration
@ComponentScan(basePackages = "com.rbondarovich.impl")
public class ServiceConfiguration {


    private static final String DOZER_MAPPING_FILES_TEMPLATE = "classpath*:/dozer/mappings/*_mapping.xml";

    @Bean
    public Mapper mapper(@Value(DOZER_MAPPING_FILES_TEMPLATE) Resource[] resourceArray) throws IOException {
        List<String> mappingFileUrlList = new ArrayList<>();
        for (Resource resource : resourceArray) {
            mappingFileUrlList.add(String.valueOf(resource.getURL()));
        }
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingFileUrlList);
        return dozerBeanMapper;
    }
}
