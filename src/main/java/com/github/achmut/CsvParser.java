package com.github.achmut;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvParser implements Parser {

    @Override
    public ParseResult parse(InputStream input) {
        if (input == null) {
            throw new NullPointerException();
        }
        List<String> headers = new ArrayList<>();
        new Scanner(input).useDelimiter(";").forEachRemaining(headers::add);
        ParseResult parseResult = new ParseResult();
        parseResult.setHeaders(headers);
        return parseResult;
    }

}
