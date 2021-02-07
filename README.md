[![Build Status](https://travis-ci.org/lramosduarte/javaFactory.svg?branch=master)](https://travis-ci.org/lramosduarte/javaFactory) [![codecov](https://codecov.io/gh/lramosduarte/javaFactory/branch/master/graph/badge.svg)](https://codecov.io/gh/lramosduarte/javaFactory)

# javaFactory
A library that makes it easy to create models with test data. JavaFactory is inspired by [model-mommy](https://model-mommy.readthedocs.io/en/latest/index.html).

With a single line, you can create an object with values (including nested objects, collections and maps).

# How to use

You can use this lib to generate fake values, seeding a database, factories in tests, etc.

## Requirements

- Java 1.8+

## Install
### jitpack

1. Maven
    1. Add the JitPack repository to your build file
    ```xml
    <repositories>
      <repository>
          <id>jitpack.io</id>
          <url>https://jitpack.io</url>
      </repository>
    </repositories>
    ```
    2. Add depedency
    ```xml
    <dependency>
        <groupId>com.github.lramosduarte</groupId>
        <artifactId>javaFactory</artifactId>
        <version>{{VERSION|TAG}}</version>
    </dependency>
    ```
2. Gradle
    1. Add the JitPack repository to your build file
    ```
      allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }
    ```
    2. Add depedency
    ```
      dependencies {
        implementation 'com.github.lramosduarte:javaFactory:{{VERSION|TAG}}'
      }
    ```

## Hands on

The only thing you need is the model's class and one single line:

```java
import static com.github.lramosduarte.fake.FakeDataGenerator.fake;

TempClass object = fake(TempClass.Class);
```
***TANDAM!*** you have a new instance of the class with those all-important random values!

## Ignore some attributes

If you wanna to ignore any attribute of the class on fake generate process, you can call the method `makeAndIgnore`.

```java
import static com.github.lramosduarte.fake.FakeDataGenerator;

Set attributesToIgnore = new HashSet<String>() {{ add("atrChar"); }};
TempClass object = FakeDataGenerator.getInstance().makeAndIgnore(TempClass.class, attributesToIgnore);
```

***Until now, we don't have any implementation for shortcut call the method `makeAndIgnore` like `fake`.***

# Report a problem

You are welcome to raise new [issues](https://github.com/lramosduarte/javaFactory/issues), just
don't be disrespectful.

# Contribution

This is a new project; contributors are welcome.


# Todo
- [ ] Suport to enum Type
- [ ] Default values
- [ ] Ignore some attributes
