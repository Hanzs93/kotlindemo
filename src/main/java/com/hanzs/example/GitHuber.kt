package com.hanzs.example

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.File

interface GitHubApi {
    @GET("repos/{owner}/{repo}")
    fun getRepository(@Path("owner") owner: String, @Path("repo") repo: String): Call<Repository>
}

fun main() {
    println("test111")
    val account = "dswdsasdwsawdsawdsawasdwasss"
    val device_no = CodecUtil.desEncrypt(account);
    println("加密后 device_no = ${device_no}")

    val sourceStr = "8888117" + account + "3" + "7L4vPoAj6XLUFzSvMstMSwlRX8ZsEY1E"
    println("md5加密前 sourceStr = ${sourceStr}")
    val md5Str = CodecUtil.encryptForMD5(sourceStr)
    println("md5后 md5Str = ${md5Str}")


    val gitHubApi = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitHubApi::class.java)

    val response = gitHubApi.getRepository("Jetbrains", "kotlin").execute()
    val repository = response.body()
    if (repository == null) {
        println("Error!${response.code()} - ${response.message()}")
    } else {
        println(repository.name)
        println(repository.owner.login)
        println(repository.stargazers_count)
        println(repository.forks_count)
        println(repository.html_url)

        File("Kotlin.html").writeText(
            """
              <!DOCTYPE html>
              <html>
              <head>
                  <meta charset="UTF-8">
                  <title>${repository.owner.login} - ${repository.name}</title>
              </head>
              <body>
                  <h1><a href='${repository.html_url}'>${repository.owner.login} - ${repository.name}</a></h1>
                  <p>${repository.description}</p>
                  <p>Stars:${repository.stargazers_count}</p>
                  <p>Forks:${repository.forks_count}</p>
              </body>

              </html>
          """.trimIndent()
        )

        //        File("a.txt").writer().buffered().use {
        //            it.write("")
        //        }

        //        File("").readLines()
        //        File("").readBytes()
    }
}