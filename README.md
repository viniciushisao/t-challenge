# Conference Track Management

## About this file

If you are reading outside Github, this file has formatting text called *GitHub Flavored Markdown*.
You can read it without any tool but for better visualization you can use some viewer for Markdown. 

I personally never used a Markdown viewer, but I found some interesting [here](http://mashable.com/2013/06/24/markdown-tools/#W7HNkkc1AZqV)


## About this project

This project is a test project I developed based on **Problem Two: Conference Track Management**

## Tools I used to make this project

1. [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
1. [IntelliJ IDEA](https://www.jetbrains.com/idea/)
1. [JUnit4](http://junit.org/junit4/)

## How to run

1. Before run just be sure you have Java 8 installed
    1. On terminal, execute ```java -version```
    1. I didn`t make tests but I am almost sure it will execute on Java 7 too.
1. I am running all commands in MacOs. If you are using another OS commands may differ a little. Also you
may need set some environment variables to run.

### Via Command line

1. Open command line tool
1. Go to ```/src``` folder
1. Execute ```javac -sourcepath . -d ./build/ *.java```
    1. This will compile all java classes and move then to ```./build``` folder
1. Go to ```./build``` folder 
1. Execute ```java Main ../../test/res/talks_test_1.txt```
    1. This will execute the main class with file ```talks_test_1.txt```
    1. The file above has the data provided for this test.
    1. Change ```../../test/res/talks_test_1.txt``` to your own file. Or edit to meet your test.
1. At the end of the output you will see a final report, where you can check if entrance worked or not.

### Via IntelliJ

1. Download and install IntelliJ
1. Open IntelliJ and open the base folder of the project.
1. Run ```src/Main.java``` (right button on the file)
    1. It will run ```/test/res/talks_test_1.txt``` and the output will be shown on Terminal inside IntelliJ

## Application tests

This project has a lot of tests, all of those are made using JUnit4. You can check then under ```/test``` folder. They are pretty much self explanatory.

### Running tests with IntelliJ

Tests are under ```/test``` folder. Select this folder, right button and select *Run all tests*

## Architecture

How application works, step by step.

1. Read the file containing all talks
1. Validate talks
1. Create Tracks, sessions and talks objects.
1. For every *morning* session, try to fill session time with KnapSack algorithm
1. For every *evening* session, try to fill session time with KnapSack algorithm
1. Print it.

### Folders organization

```src``` *The main source of this application*

```src\model``` *Models of the application*

```src\util``` *Util* 

```test``` *Main tests folder*

```test\res``` *Text files of possible inputs tests*

```test\util``` *Tests util*




## Things to think better

1. I am using a sort of KnapSack problem solving algorithm. Is Bin Packing better?
1. All the times I am generating the KnapSack matrix.
1. Maybe a tutorial on how running tests in command line?

## More References

1. [GitHub Flavored Markdown](https://help.github.com/categories/writing-on-github/)
1. [KnapSack Problem](https://en.wikipedia.org/wiki/Knapsack_problem)
1. [Bin packing problem](https://en.wikipedia.org/wiki/Bin_packing_problem)
