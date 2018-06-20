General Considerations
======================
In answering the code questions, please write code as if you intended to ship it to production. 
Details matters. Tests are expected, simple idiomatic code as well.

### 1 - Simple Test Driven Programming
Enclosed you will find a simple _maven_ project
which you should be able to open and modify in your environment.
In this project you will find some test classes: 

* Challenge00BaseMethodsTest
* Challenge01CollectionMethodsTest
* Challenge02DesignPatternsTest
* Challenge03SimpleProgramTest
* Challenge04SQLTest
* Challenge05BaseDataMethodsTest
* Challenge06ExtraTest

You will notice that those three classes statically include
all methods you will need to expose in their corresponding source classes.

* Challenge00BaseMethods
* Challenge01CollectionMethods
* Challenge02DesignPatterns
* Challenge03SimpleProgram
* Challenge04SSQL
* Challenge05BaseDataMethods
* Challenge06Extra

We ask you to modify those classes in order to make the tests to run successfully.

Classes in the it.techgap.challenge.java.senior.beans

Please note we expect you not to modify:
* any of the test cases;
* any class in the `it.techgap.challenge.java.senior.beans` package.

Anyhow, feel free to add as many classes as you need to the source.

### 2 - Test Driven Programming
Write some code that will flatten an array of arbitrarily nested arrays of integers into a 
flat array of integers. e.g. 

    [[1,2,[3]],4] -> [1,2,3,4]
    
Your program should be fully tested too.
Please organize the project as a Maven project and make it available on a public GIT server.