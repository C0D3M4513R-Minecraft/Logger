# Logger
## Another logging library? Really?
Yes. This is technically another logging library.
I designed the main interface to be compatible to the org.slf4j.Logger (v1.7.15) interface.
I created this library, because I had wanted to create a minecraft plugin, that uses multiple plugin systems (sponge v7 and bukkit).
The issue is there, that sponge v7 uses slf4j, while bukkit uses java.util.logging.
And now I want to build a Library to support both systems (and many more, if you so desire).

## How to use

- if you use slf4j, and you do not relocate the slf4j library, you can just use [com.c0d3m4513r.logger.Slf4jLogger](src/main/lombok/com/c0d3m4513r/logger/Slf4jLogger.java) and use the constructor that accepts anything that implements org.slf4j.Logger as a replacement for your logger.
- if you use slf4j, and relocate your slf4j dependency, it gets slightly more tricky. You can use [com.c0d3m4513r.logger.Slf4jLoggerRelocatable](src/main/lombok/com/c0d3m4513r/logger/Slf4jLoggerRelocatable.java) and use the constructor that accepts a Object and a Class as a replacement for your logger. More information in the Javadoc of that class.
- if you use a java.util.logging logger, you can use [com.c0d3m4513r.logger.JavaUtilLogger](src/main/lombok/com/c0d3m4513r/logger/JavaUtilLogger.java) and use the constructor that accepts anything that implements java.util.logging.Logger as a replacement for your logger. You will of course need to change all method calls.
- if you use anything else, just implement the [com.c0d3m4513r.logger.Logger](src/main/lombok/com/c0d3m4513r/logger/Logger.java) interface and use the new class you created to create a [com.c0d3m4513r.logger.Logger](src/main/lombok/com/c0d3m4513r/logger/Logger.java).


## About Semver:

I generally strive to use [semantic versioning](https://semver.org/) for all my projects.
But there are a few exceptions I have to communicate here (mainly because I have seen enough stuff in minecraft projects):
- The implementation of methods and Classes can change, even in Patch releases.
- Private methods and variables are considered implementation details.
- non-public methods and variables on final classes are considered implementation details.
- Annotations may be added or removed in Patch releases, if the method call is still [binary compatible](https://docs.oracle.com/javase/specs/jls/se17/html/jls-13.html#jls-13.2).

- This means, that any java bytecode manipulation or java reflection may break in Patch releases.

Extra guarantees:
- The slf4j-api:1.7.15 will stay a fixed dependency, with at most a Patch update.

These rules are only in place, because I publish as java-version 8. If I had java modules, I would probably not have to add these notes.

# About the license:

I do not want this project to be copy-pasted into other projects.
I have thus not yet decided on a license.
General rules are:
- If you want to use this project, please contact me as I have not yet decided on a License yet. And yes, this includes ANY USE.
    - The [Pixel-gaming](https://pixelgaming.co) group, under which this project's source is published under shall be free to use any and all projects contained in this repository.
- Redistributing the source of this project is not permitted.
- Forks shall be only allowed with the intent of contributing to this project.
  All changes in Forks must not be on the default branch.
  If you fork this repository, and end up changing your mind about contributing to this project I would kindly ask you to delete the repository.
  If you end up forking this repository, and accidentally push to the default branch, just reset the branch to before that commit, and push again.
- If you want to use this project in closed-source projects, or open-source for-profit projects you

# Contributing guidelines and Code ownership:

Whilst no rigid license is in place (no License file in the modules and no license information available in the maven projects) code ownership of anything in this repository shall automatically change to C0D3 M4513R.
This includes any contributions to this Project, including PR's.
This will allow for specifying a license later on.
Also in general code ownership shall be settled on a per-module basis.
