package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.DeepSearch;
import com.example.HackatonByGreatDevelopers.entity.Document;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalystService {

    private final ElasticsearchOperations elasticsearchOperations;

    public List<String> deepSearch(List<DeepSearch> deepSearches){
        List<String> list = new ArrayList<>();
        CriteriaQuery query = new CriteriaQuery(new Criteria(deepSearches.get(0).getField()).is(deepSearches.get(0).getSearchString()));
        for (int i = 1; i < deepSearches.size(); i++){
            query.addCriteria(new Criteria((deepSearches.get(i).getField())).is(deepSearches.get(i).getSearchString()));
        }
        SearchHits<Document> synonymEntities = elasticsearchOperations.search(query, Document.class);
        for(int i = 0;i < synonymEntities.get().count(); i++)
            list.add(synonymEntities.getSearchHit(i).getContent().getText());
        System.out.println(synonymEntities.get().count());
        return list;
    }
}
