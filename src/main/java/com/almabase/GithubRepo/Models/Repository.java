package com.almabase.GithubRepo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository implements Comparable<Repository>{
    int id;
    String name;
    String full_name;
    String description;
    int forks_count;
    List<Contributor> topContributors;

    @Override
    public int compareTo(Repository o) {
        return Integer.compare(this.forks_count, o.forks_count);
    }
}
