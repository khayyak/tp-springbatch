package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Product;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import static com.example.technomakers.springbatch.exercice.constant.FileConstants.*;

public class ProductItemReader extends FlatFileItemReader<Product> {

    public ProductItemReader() {
        setResource(new ClassPathResource(INPUT_FILE_NAME));
        setLinesToSkip(1);
        setLineMapper(createLineMapper());
    }

    private DefaultLineMapper<Product> createLineMapper() {
        DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(createLineTokenizer());
        lineMapper.setFieldSetMapper(createFieldSetMapper());
        return lineMapper;
    }

    private DelimitedLineTokenizer createLineTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames(HEADERS);
        return tokenizer;
    }

    private BeanWrapperFieldSetMapper<Product> createFieldSetMapper() {
        BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Product.class);
        return fieldSetMapper;
    }

}
