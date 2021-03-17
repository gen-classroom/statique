# Statique

Statique is a brand new static site generator.

Build and unzip the project 

**MacOS/Linux:**

```
mvn clean install \
    && unzip -o target/statique.zip
```

**Windows:** Use git bash or any other unix based bash. Or do a mvn clean install -> remove manualy the old statique folder at the root of your project and unzip the new *target/statique.zip*.

Add the bin directory to your path:

```
export PATH=$PATH:`pwd`/statique/bin
```

Executing `statique` should now produce the following result:

```
statique
Usage: statique [COMMAND]
A brand new static site generator.
Commands:
  init   Initialize a static site directory
  clean  Clean a static site
  build  Build a static site
  serve  Serve a static site
```
