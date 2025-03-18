package objektwerks

import scribe.Level
import scribe.file.{string2PathBuilder, string2FileName, FileWriter}

import upickle.default.{read => readJson, write => writeJson}

import Todo.given

object Store:
  scribe.Logger.root
    .clearHandlers()
    .clearModifiers()
    .withHandler(minimumLevel = Some(Level.Info))
    .withHandler(writer = FileWriter("~" / ".todon" / "log" / "app.log") )
    .replace()

final class Store:
  private val todosPath = os.home / ".todon" / "data"

  os.makeDir.all(todosPath)
  scribe.info("Initialized store.")

  def listTodos(): List[Todo] =
    scribe.info(s"List todos.")
    os.list(todosPath)
      .filter { path => path.baseName.nonEmpty }
      .map { path => readTodo(s"${path.baseName}.json") }
      .toList
      .sorted

  def readTodo(file: String): Todo =
    val todoAsJson = os.read(todosPath / file)
    scribe.info(s"Read todo: $file")
    readJson[Todo](todoAsJson)

  def writeTodo(todo: Todo): Unit =
    val todoAsJson = writeJson(todo)
    os.write.over(todosPath / todo.file, todoAsJson)
    scribe.info(s"Write todo: ${todo.id}")

  def nextId(): Int =
    val list = os.list(todosPath)
      .filter { path => path.baseName.nonEmpty }
      .map { path => path.baseName.toInt }
      .toList
    val id = if list.isEmpty then 1 else list.max + 1
    scribe.info(s"Next id: $id")
    id