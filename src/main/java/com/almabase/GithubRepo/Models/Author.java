package com.almabase.GithubRepo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    String login;
    String id;
    String avatar_url;
    String url;
    String type;
}
