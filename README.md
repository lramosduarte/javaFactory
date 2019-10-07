[![Build Status](https://travis-ci.org/lramosduarte/javaFactory.svg?branch=master)](https://travis-ci.org/lramosduarte/javaFactory) [![codecov](https://codecov.io/gh/lramosduarte/javaFactory/branch/master/graph/badge.svg)](https://codecov.io/gh/lramosduarte/javaFactory)

# javaFactory
A library that makes it easy to create models with test data. JavaFactory is inspired by [model-mommy](https://model-mommy.readthedocs.io/en/latest/index.html). 

With a single line, you can create an object with values (including nested objects, collections and maps).

# How to use

You can use this lib to generate fake values, seeding a database, factories in tests, etc.

## Requirements

- Java 1.8+

## Install
**TODO**

## Hands on

The only thing you need is the model's class and one single line:

```java
import static com.github.lramosduarte.fake.FakeDataGenerator.fake;

TempClass object = fake(TempClass.Class);
```

***TANDAM!*** you have a new instance of the class with those all-important random values!

# Report a problem

You are welcome to raise new [issues](https://github.com/lramosduarte/javaFactory/issues), just
don't be disrespectful.

# Contribution

This is a new project; contributors are welcome.
