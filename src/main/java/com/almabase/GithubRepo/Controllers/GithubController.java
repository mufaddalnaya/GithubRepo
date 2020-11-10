package com.almabase.GithubRepo.Controllers;

import com.almabase.GithubRepo.Models.Repository;
import com.almabase.GithubRepo.Services.GithubService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*

Controller Class Containing 2 rest endpoints

 */

@RestController
public class GithubController {

    @Autowired
    GithubService githubService;

    @ApiOperation(value = "Returns The n best repositories of the organisation and each repository containing details about m best committers")
    @GetMapping("/repos/{org}/{n}/{m}")
    public List<Repository> getRepos(@PathVariable String org, @PathVariable int n, @PathVariable int m) {

        return githubService.getGithubRepo(org, n, m);
    }

    @ApiOperation(value = "Default Message")
    @GetMapping("/")
    public String defaultMsg() {
        return "App to get the most popular repository of any organisation and its best contributors. <br>Try Running <a href=\"https://almabase-project.herokuapp.com/repos/google/3/4\">https://almabase-project.herokuapp.com/repos/google/3/4</a> and wait for result.";
    }

}
