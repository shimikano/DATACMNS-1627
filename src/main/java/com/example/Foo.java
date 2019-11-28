package com.example;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@TypeAlias("foo")
public class Foo {

}
