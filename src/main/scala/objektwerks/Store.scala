package objektwerks

import upickle.default.{read => readJson, write => writeJson}

import Todo.given

final class Store:
  private val todosPath = os.home / ".todon"

  os.makeDir.all(todosPath)
  println("Initialized store.")

  def listTodos(): List[Todo] =
    println(s"List todos.")
    os.list(todosPath)
      .filter { path => path.baseName.nonEmpty }
      .map { path => readTodo(s"${path.baseName}.json") }
      .toList
      .sorted

  def readTodo(file: String): Todo =
    val todoAsJson = os.read(todosPath / file)
    println(s"Read todo: $file")
    readJson[Todo](todoAsJson)

  def writeTodo(todo: Todo): Unit =
    val todoAsJson = writeJson(todo)
    os.write.over(todosPath / todo.file, todoAsJson)
    println(s"Write todo: ${todo.id}")

  def nextId(): Int =
    val list = os.list(todosPath)
      .filter { path => path.baseName.nonEmpty }
      .map { path => path.baseName.toInt }
      .toList
    val id = if list.isEmpty then 1 else list.max + 1
    println(s"Next id: $id")
    id