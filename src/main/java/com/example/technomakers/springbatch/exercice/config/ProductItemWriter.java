package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Product;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.technomakers.springbatch.exercice.constant.FileConstants.*;

public class ProductItemWriter extends FlatFileItemWriter<Product> {

    public static final String ERROR_WRITING_HEADER = "Error writing header";
    public static final String NO_POSSIBILITY_TO_CHECK_FILE_EXISTENCE = "No possibility to check file existence";

    public ProductItemWriter() {
        setResource(new FileSystemResource(OUTPUT_FILE_NAME));
        setLineAggregator(createAggregator());
    }

    private DelimitedLineAggregator<Product> createAggregator() {
        DelimitedLineAggregator<Product> aggregator = new DelimitedLineAggregator<>();
        aggregator.setDelimiter(",");
        aggregator.setFieldExtractor(createFieldExtractor());
        return aggregator;
    }

    private FieldExtractor<Product> createFieldExtractor() {
        return product -> new Object[]{
                product.getProductId(),
                product.getProductName(),
                product.getQuantityInStock(),
                product.getUnitPrice(),
                product.getSupplier()
        };
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        super.open(executionContext);
        writeHeader();
    }

    private void writeHeader() {
        Path path = Paths.get(OUTPUT_FILE_NAME);
        if (!Files.exists(path) || isFileEmpty(path)) {
            try (Writer writer = Files.newBufferedWriter(path)) {
                writer.write(HEADER);
                writer.write(System.lineSeparator());
            } catch (IOException e) {
                throw new ItemStreamException(ERROR_WRITING_HEADER, e);
            }
        }
    }

    private boolean isFileEmpty(Path path) {
        try {
            return Files.size(path) == 0;
        } catch (IOException e) {
            throw new ItemStreamException(NO_POSSIBILITY_TO_CHECK_FILE_EXISTENCE, e);
        }
    }
}