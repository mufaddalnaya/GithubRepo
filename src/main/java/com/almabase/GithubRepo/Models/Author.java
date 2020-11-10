package com.almabase.GithubRepo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 This Model class contains Information of a particular user present on github. The variable login represents users github id.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    String login;       //Author's github username
    String id;          //Author's github id
    String avatar_url;  //Author's github avatar
    String url;         //Author's github link to profile
    String type;        //Author's github type usually use
}
