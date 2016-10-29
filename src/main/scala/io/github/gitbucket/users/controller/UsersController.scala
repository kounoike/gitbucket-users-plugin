package io.github.gitbucket.users.controller

import gitbucket.core.controller.ControllerBase
import gitbucket.core.model.Profile._
import gitbucket.core.service.{AccountService, RepositoryService}
import gitbucket.core.util.UsersAuthenticator
import gitbucket.core.util.Implicits._
import gitbucket.users.html

/**
  * Created by kounoike on 2016/10/29.
  */
class UsersController extends UsersControllerBase
  with AccountService with RepositoryService
  with UsersAuthenticator

trait UsersControllerBase extends ControllerBase {
  self: AccountService with RepositoryService
  with UsersAuthenticator =>

  // test
  get("/users"){
    val users = getAllUsers(false)
    val members = users.collect { case account if(account.isGroupAccount) =>
      account.userName -> getGroupMembers(account.userName).map(_.userName)
    }.toMap
    html.users(users, members)
  }
}
