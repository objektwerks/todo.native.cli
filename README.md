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

Publish
-------
1. ```sbt clean compile nativeLink```
2. ```mv target/scala-3.7.0-RC1/todo-native-cli target/scala-3.7.0-RC1/todo```
3. ```sudo cp target/scala-3.7.0-RC1/todo /usr/local/bin```

Commands
--------
1. list --filter
2. add --todo
3. complete --id
>The command ```list --filter``` accepts ```all```, ```completed``` and ```incomplete```
* ```list --filter all | completed | incomplete```
>Since the ```list``` default is: ```--filter all```, this also works:
* ```list```

Execute
-------
1. todo
2. todo list
3. todo list --filter all | completed | incomplete
4. todo add --todo drink beer
5. todo complete --id 1
6. todo help

Resources
---------
1. [Scala Native Docs](http://www.scala-native.org/en/latest/index.html)
2. [Scala Native Intro Video](https://www.youtube.com/watch?v=u2CnE-sRdBw)