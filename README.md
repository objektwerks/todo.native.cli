Todo Native CLI
---------------
Todo native command line app using MainArgs, Os-lib, uPickle and Scala 3.

Install
-------
>See: http://www.scala-native.org/en/latest/user/setup.html
1. brew install llvm

Build
-----
1. ```sbt clean compile```

Test
----
1. ```sbt clean test```

Assembly
--------
1. ```sbt clean test assembly```

Commands
--------
1. list --filter
2. add --todo
3. complete --id
>The command ```list --filter``` accepts ```all```, ```completed``` and ```incomplete```
* ```list --filter all | completed | incomplete```
>Since the ```list``` default is: ```--filter all```, this also works:
* ```list```

Run
---
1. ```sbt "run list --filter all"```
2. ```sbt "run add --todo drink beer"```
3. ```sbt "run complete --id 1"```
4. ```sbt "run help"```
>```sbt run``` displays the help menu.

Execute
-------
1. todo

Resources
---------
1. [Scala Native Docs](http://www.scala-native.org/en/latest/index.html)
2. [Scala Native Intro Video](https://www.youtube.com/watch?v=u2CnE-sRdBw)