package objektwerks

import mainargs.{main, arg, ParserForMethods}

import scribe.Level

object App:
  scribe.Logger.root
    .clearHandlers()
    .clearModifiers()
    .withHandler(minimumLevel = Some(Level.Info))
    //.withHandler(writer = FileWriter("logs" / ("app-" % year % "-" % month % "-" % day % ".log")))
    .replace()

  val store = Store()

  @main
  def list( @arg filter: String = Filter.all ): Unit =
    println(s"list by filter: $filter")
    val todos = store.listTodos()
    filter match
      case Filter.all => list(todos)
      case Filter.completed => list( todos.filter(todo => todo.completed.nonEmpty) )
      case Filter.incomplete => list( todos.filter(todo => todo.completed.isEmpty) )
      case _ => println("list --filter all | completed | incomplete")

  @main
  def add( @arg todo: String* ): Unit =
    val newTodo = Todo(id = store.nextId(), todo = todo.tail.mkString(" "))
    store.writeTodo(newTodo)
    println(s"add --todo: $newTodo")

  @main
  def complete( @arg id: Int ): Unit =
    val todo = store.readTodo(s"$id.json")
    val completedTodo = todo.copy(completed = Todo.datetime())
    store.writeTodo(completedTodo)
    println(s"completed --id: $completedTodo")

  @main
  def help(): Unit =
    menu()

  def main(args: Array[String]): Unit =
    if args.isEmpty then menu()
    else ParserForMethods(this).runOrExit(args)

  private def menu(): Unit =
    println("menu:")
    println("1. list --filter all | completed | incomplete")
    println("2. add --todo")
    println("3. complete --id")
    println("4. help")

  private def list(todos: List[Todo]): Unit =
    todos
      .zip( Stream.from(1) )
      .foreach { case (todo, index) => println(s"$index. $todo") }