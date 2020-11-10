package com.almabase.GithubRepo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/*

 This Model class contains Information of a particular repository of a particular organisation.
 The variable fork_count represents total forks made to this repo.

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository implements Comparable<Repository>{
    int id;             //Repository ID
    String name;        //Repository name
    String full_name;   //Repository full-name {org_name}/{repo_name}
    String description; //Repository Description
    int forks_count;    //Repository Forks Count
    List<Contributor> topContributors;  //Repository Contributors List

    @Override
    public int compareTo(Repository o) {
        return Integer.compare(this.forks_count, o.forks_count);
    }
}
