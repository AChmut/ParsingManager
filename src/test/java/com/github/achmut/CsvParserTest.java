package com.github.achmut;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvParserTest {

    @Test(expected = NullPointerException.class)
    public void parseNull() throws Exception {
        new CsvParser().parse(null);
    }

    @Test
    public void parseNonEmpty() throws Exception {
        ParseResult result = new CsvParser().parse(new ByteArrayInputStream("123".getBytes()));
        assertThat(result).isNotNull();
    }

    @Test
    public void parseHeaders() throws Exception {
        ParseResult result = new CsvParser().parse(new ByteArrayInputStream("123;456;789".getBytes()));
        assertThat(result).isNotNull();
        assertThat(result.getHeaders()).containsExactly("123", "456", "789");
    }
}