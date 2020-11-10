package com.almabase.GithubRepo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contributor implements Comparable<Contributor>{
    int total;
    Author author;

    @Override
    public int compareTo(Contributor o) {
        return Integer.compare(this.total, o.total);
    }
}
