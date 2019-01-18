<img style="width:100%;" src="/github-banner.png">

# starter-kit-java

Java starter kit for the glo2003 laboratory at Ulaval.

Built with [spark](http://sparkjava.com/) framework for simplicity

Starting at java is not easy: [better-java](https://github.com/cxxr/better-java) gives you modern best practices.

Some nice libraries have been added to help you start and do things way faster and more easily. Have a look at them
in the [build.gradle](/build.gradle) file.

## Building with gradle

```bash
./gradlew build
```

## Running with gradle

```bash
./gradlew run
```

## Building with maven

```bash
mvn clean install
```

## Running with maven

```bash
mvn exec:java
```

## Dependencies and interesing doc:

- [Jackson](http://wiki.fasterxml.com/JacksonHome)
- [Jackson-annotations](https://github.com/FasterXML/jackson-annotations)
- [SparkJava](http://sparkjava.com)
- [Javaslang](http://javaslang.com/) - better java 8 (this is really useful)

For testing 

- [Junit](http://junit.org/)
- [Truth](https://google.github.io/truth/)
