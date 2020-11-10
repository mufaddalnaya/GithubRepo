package com.almabase.GithubRepo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organisation {
    int id;
    String repos_url;
    String description;
    String name;
    String email;
    int public_repos;
}
