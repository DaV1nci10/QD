package com.example.HackatonByGreatDevelopers.services;

import com.example.HackatonByGreatDevelopers.entity.Phrase;
import com.example.HackatonByGreatDevelopers.entity.Section;
import com.example.HackatonByGreatDevelopers.entity.SectionBody;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class TestService {

    private final ArticleService articleService;
    private final RestHighLevelClient esClient;
    public List<String> listOfSectionIll = new ArrayList<>();

    public List<Section> test(List<SectionBody> sectionBodyList) throws IOException {
        List<Section> resultItIs = new ArrayList<>();
        for (int i = 0; i < sectionBodyList.size(); i++) {
            resultItIs.add(new Section(sectionBodyList.get(i).getSectionCode(), getPhrasesFromOneSection(sectionBodyList.get(i))));
        }
        return resultItIs;
    }

    public List<Phrase> getPhrasesFromOneSection(SectionBody section) throws IOException {
        List<String> listOfSectionPhrases = articleService.searchPhrasesByArticleName(section.getSectionCode());

        String text = section.getText();
        List<Phrase> phrases = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\s*[,;.:]\\s*)+(?=[^,;.:0-9])");
        Matcher matcher = pattern.matcher(text + ".   ");
        int lastUsedIndex = 0;
        while (matcher.find()) {
            String phraseString = text.substring(lastUsedIndex, matcher.start());
            String delimiter = matcher.group();
            lastUsedIndex = matcher.end();
            if (!phraseString.equals("")) {
                if (listOfSectionPhrases.stream().anyMatch(l -> l.equals(phraseString)))
                    phrases.add(new Phrase(phraseString, true, null, false));
                else {
                    List<String> suggest = searchForSuggestList(section.getSectionCode(), phraseString, "article");
                    phrases.add(new Phrase(phraseString, false, suggest, false));
                }
            }
//              phrases.add(new Phrase(delimiter, false, null, true));
        }
        return (phrases);
    }

    public List<String> searchForSuggestList(String articleName, String searchName, String index) throws IOException {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.boolQuery()
                .must(QueryBuilders.multiMatchQuery(searchName, "text").fuzziness(1))
                .must(QueryBuilders.multiMatchQuery(articleName, "title")
                ));
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
        List<String> list = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            list.add((String) sourceAsMap.get("text"));
        }
        return list;
    }

}
