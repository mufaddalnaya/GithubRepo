package com.almabase.GithubRepo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*

This Model class contains Information about a particular organisation.

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organisation {
    int id;             //Organisation's Github id
    String repos_url;   //Organisation's Github repository api link
    String description; //Organisation's Github description
    String name;        //Organisation's Github name
    String email;       //Organisation's Github email
    int public_repos;   //Organisation's Github repositories count
}
