package com.github.achmut;

import java.io.InputStream;

public interface Parser {

    ParseResult parse(InputStream input);
}
