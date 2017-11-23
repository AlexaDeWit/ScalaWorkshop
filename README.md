# Getting Started With Scala and Functional Programming

## What is this thing?

This is a repository that contains both documentation on how to get started with scala,
as well as a near empty project that has a configured build tool, and dependencies that will support
serving http requests, as well as json serialization support.

This workshop will involve playing around with creating a JSON API in Scala as a means
to illustrate functional programming principles in practice, as well as show the benefits
one can garner from the sort of type-level programming that is common in this paradigm.

Where many may be used to a programming paradigm centred around actions being taken, 
and state mutating as a response to inputs, we will instead try to think and model
a program instead in terms of functions taking immutable data and returning immutable results.

Another important part of this will be the idea of Pure and Total functions.

## But why though?

- Letting the compiler do as much work as possible is pretty cool. After all, what can never be null never needs a null check!
- Data Sharing: In this programming paradigm, we use immutable values to contain state. Thanks to this, we can use a concurrency model that relies heavily on shared access to resources.... Without -ever- needing locks, or mutexes, and without ever having a race condition. *(Except things that are below our level of abstraction as must always forever be so, such as a database-connection-level lock on a specific row)*
- Correctness:
- Reasonability: Once one is familiar with functional syntax, something like
 `List(1,2,3,4).map(_ * 2)`
 becomes much easier to read than the old imperative approach of
 ```
 var nums = new List{ 1, 2, 3, 4 };
 public List<int> doubleNums(List<int> nums) {
    var accumulator = new List<int>();
    foreach(var i in nums) {
        accumulator.Add(i * 2);
    }
    return accumulator;
 }

 ``` 
 - And while I recognize that the above example is fairly contrived, and not what one would do
 in the context of C# with LINQ.... The important thing here is that... When you use the LINQ approach
 you are using a subset of the techniques and approaches we will discuss here. As I am sure you all know,
 LINQ -is- functional programming. At least, some of it ;)
 - A bunch of other reasons including maintainability, referential transparency, and all sorts of stuff, but you already probably know some of the benfits if this workshop interests you. 

## Step One: Get the tools.

### Windows

- [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html)
- The build automation tool: [sbt](http://www.scala-sbt.org/download.html). Make sure that you add it to your `$PATH`
- Set your JAVA_HOME environment variable: [confluence](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
- You will need an editor. I highly recommend Intellij's [IDEA](https://www.jetbrains.com/idea/download/?gclid=EAIaIQobChMIwru2stDU1wIV3cqyCh1ZSQCzEAAYASABEgIRbvD_BwE&gclsrc=aw.ds.ds&dclid=CLjSu97Q1NcCFVGTGAodGz0OnA#section=windows). *Seriously, trust me on this, if you want something intellisense-likey, there's almost no other option for an editor.*
- Install the Scala/SBT plugin in IDEA during the install process.
- I recommend using git bash when executing sbt commands, but who knows maybe powershell is fine too. I wouldn't know.

### OSX

- Java: `brew cask install java`
- Set your `JAVA_HOME` environment variable. [This might be helpful?](http://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux)
- SBT (build automation tool): `brew install sbt`
- You will need an editor. I highly recommend Intellij's [IDEA](https://www.jetbrains.com/idea/download/?gclid=EAIaIQobChMIn7_C49LU1wIVE5AYCh18cgFkEAAYASABEgLXw_D_BwE&gclsrc=aw.ds.ds&dclid=CNSNt-TS1NcCFReAmgodkS0Ojg#section=mac). *Seriously, trust me on this, if you want something intellisense-likey, there's almost no other option for an editor.*
- Install the Scala/SBT plugin in IDEA during the install process.

## Step Two: Build the thing and run the Test(s)

- Open the Edit Configurations Menu

![Config Menu](/readme_images/EditRunConfigurations.png?raw=true "Configuarion Menu")
- Create a new SBT Task

![New Task](/readme_images/CreateNewSbtTask.png?raw=true "New Sbt Task")
- Define the Test Task as such. This task will run continuously and reload when it detects code changes.

![Test Task](/readme_images/TestTask.png?raw=true "Test Task")
- Define the Run task as such. This task will run continuously and reload when it detects code changes.

![Run Task](/readme_images/RunTask.png?raw=true "Run Task")
- Both tasks can be stopped at any time by using the stop button on the top-right of IDEA.

![Task Menu](/readme_images/TaskMenu.png?raw=true "Task Menu") 

## Step Three: Some Basic Terminology

- Pure Function: A function where its value(return) is based entirely on its inputs, and which mutates nothing external to itself.
- Referential Transparency: Any function which can be replaced by its value without changing the overall program is called a referentially transparent function.
- Total Function: A function for which a definition exists for all inputs. For instance: `a => a + 2` is a total function but `(n, d) => n / d` is not a total function(undefined for `d = 0`)
- Side-Effect: Any action taken by a function which influences "The ourside world", such as printing to console, logging, touching a database, or any other non-referentially-transparent action.
-- This means that hashing a password is a side-effect! It consumes system entropy, and does not result in the same value for any given input.




