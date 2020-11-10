package com.almabase.GithubRepo.Services;

import com.almabase.GithubRepo.Models.Contributor;
import com.almabase.GithubRepo.Models.Organisation;
import com.almabase.GithubRepo.Models.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class GithubService {

    // For calling github api
    @Autowired
    private RestTemplate restTemplate;

    // Contains Http Headers
    @Autowired
    private HttpEntity request;

    public List<Repository> getGithubRepo(String org, int n, int m) {

        String uri = "https://api.github.com/orgs/"+org;
        Organisation orgDetails;
        try {
            orgDetails = restTemplate.exchange(uri, HttpMethod.GET, request, Organisation.class).getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Organization Not Found"
            );
        }
        List<Repository> orgRepositories = getAllRepositories(orgDetails);
        List<Repository> bestNRepos = getBestNRepos(orgRepositories, n);
        bestMCommittees(bestNRepos, m);
        return bestNRepos;
    }

    private void bestMCommittees(List<Repository> repos, int m) {
        for(Repository repository: repos) {
            repository.setTopContributors(getTopMContributor(repository, m));
        }
    }

    private List<Contributor> getTopMContributor(Repository repository, int m) {

        String uri = "https://api.github.com/repos/"+repository.getFull_name()+"/stats/contributors";
        System.out.println(uri);
        Contributor[] contributors;
        try {
            contributors = restTemplate.exchange(uri, HttpMethod.GET, request, Contributor[].class).getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_GATEWAY, "Github Not Responding"
            );
        }
        PriorityQueue<Contributor> pq = new PriorityQueue<>();
        for(Contributor contributor: contributors) {
            pq.add(contributor);
            if(pq.size() == m+1) {
                pq.poll();
            }
        }
        List<Contributor> ascContributors = new ArrayList<>();
        while (!pq.isEmpty())
            ascContributors.add(pq.poll());
        List<Contributor> contributorsList = new ArrayList<>();
        for(int i=ascContributors.size()-1; i>=0; i--) {
            contributorsList.add(ascContributors.get(i));
        }
        return contributorsList;

    }

    private List<Repository> getBestNRepos(List<Repository> orgRepositories, int n) {
        PriorityQueue<Repository> pq = new PriorityQueue<>();
        for(Repository repository: orgRepositories) {
            pq.add(repository);
            if(pq.size() == n+1) {
                pq.poll();
            }
        }
        List<Repository> ascRepositories = new ArrayList<>();
        while (!pq.isEmpty())
            ascRepositories.add(pq.poll());
        List<Repository> repositories = new ArrayList<>();
        for(int i=ascRepositories.size()-1; i>=0; i--) {
            repositories.add(ascRepositories.get(i));
        }
        return repositories;
    }

    private List<Repository> getAllRepositories(Organisation org) {
        int repo_count = org.getPublic_repos();
        List<Repository> repositories = new ArrayList<>(repo_count);
        for(int i=1; i<=(repo_count-1)/100+1; i++) {
            String uri = org.getRepos_url()+"?per_page=100&page="+i;
            System.out.println(uri);
            Repository[] repositoryList;
            try {
                repositoryList = restTemplate.exchange(uri, HttpMethod.GET, request, Repository[].class).getBody();
            } catch (Exception e) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY, "Github Not Responding"
                );
            }
            repositories.addAll(Arrays.asList(repositoryList));
        }
        return repositories;
    }

}
