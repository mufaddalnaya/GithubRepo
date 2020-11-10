package com.almabase.GithubRepo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
This Model class contains Information of a particular contributor of a particular repo.
The variable total represents total commits and author contains the details of the author.

 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contributor implements Comparable<Contributor>{
    int total;      //Total Commits count
    Author author;  //Author Details

    @Override
    public int compareTo(Contributor o) {
        return Integer.compare(this.total, o.total);
    }
}
