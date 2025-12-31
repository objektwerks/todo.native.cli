Todo Native CLI
---------------
>Scala Native Todo command line app using MainArgs, Fansi, Os-Lib, uPickle, sJavaTime, Scribe and Scala 3.

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
2. ```mv target/scala-3.7.0-RC4/todo-native-cli target/scala-3.7.0-RC4/todo```
3. ```sudo cp target/scala-3.7.0-RC4/todo /usr/local/bin```

Commands
--------
1. ```help```
2. ```list --filter```
3. ```add --todo```
4. ```complete --id```
>The command ```list --filter``` accepts ```all```, ```completed``` and ```incomplete```
* ```list --filter all | completed | incomplete```
>Since the ```list``` default is: ```--filter all```, this also works:
* ```list```

Execute
-------
1. todo
2. todo list
3. todo list --filter all | completed | incomplete
4. todo add --todo drink ipa
5. todo complete --id 1
6. todo help

Persistence
-----------
>**Todos** are stored as json files here:
```
~/.todon/data
```

Logging
-------
>**Log** files are stored here:
```
~/.todon/log
```

Resources
---------
* [Scala Native Docs](http://www.scala-native.org/en/latest/index.html)
* [Scala Native Intro Video](https://www.youtube.com/watch?v=u2CnE-sRdBw)
* [MainArgs Github](https://github.com/com-lihaoyi/mainargs?tab=readme-ov-file#varargs-parameters)
* [Os-Lib Github](https://github.com/com-lihaoyi/os-lib)
* [uPickle Github](https://github.com/com-lihaoyi/upickle)
* [Scribe Github](https://github.com/outr/scribe)
* [Fansi Github](https://github.com/com-lihaoyi/fansi)
