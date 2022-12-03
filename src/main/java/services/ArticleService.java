package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Constants;
import model.Article;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ArticleService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final RestHighLevelClient restHighLevelClient;

    public ArticleService(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }


    public void updateArticle(String id, String title, String text) throws IOException {
        Article article = new Article();
        article.setTitle(title);
        article.setText(text);

        IndexRequest indexRequest = new IndexRequest(Constants.ARTICLE_INDEX);
        indexRequest.id(id);
        indexRequest.source(objectMapper.writeValueAsString(article), XContentType.JSON);

        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
    }
}