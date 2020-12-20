import io.github.gitbucket.users.controller.UsersController
import io.github.gitbucket.solidbase.model.Version
import gitbucket.core.controller.Context
import gitbucket.core.plugin._

class Plugin extends gitbucket.core.plugin.Plugin {
  override val pluginId: String = "users"
  override val pluginName: String = "Users Plugin"
  override val description: String = "List users and groups of GitBucket plug-in"
  override val versions: List[Version] = List(
    new Version("1.0.0"),
    new Version("1.0.1"),
    new Version("1.0.2"),
    new Version("2.0.0")
  )

  override val globalMenus = Seq(
    (context: Context) => Some(Link("users", "Users", "users"))
  )

   override val controllers = Seq(
    "/users" -> new UsersController()
  )
}
