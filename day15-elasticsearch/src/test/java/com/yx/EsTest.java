package com.yx;

import com.alibaba.fastjson.JSON;
import com.yx.domain.Goods;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.io.IOException;
import java.util.*;

@SpringBootTest
public class EsTest {
    @Autowired
    RestHighLevelClient client;
    
    @Autowired
    ElasticsearchRestTemplate esTemplate;
    
    @Test
    public void testClient() {
        System.out.println(client);
    }
    
    /**
     * 添加索引
     *
     * @throws IOException
     */
    @Test
    public void addIndex() throws IOException {
        //1.使用client获取操作索引对象
        IndicesClient indices = client.indices();
        //2.具体操作获取返回值
        //2.1 设置索引名称
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test_index");
        // 设置mapping
        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("type", "keyword");
        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put("type", "text");
        map2.put("analyzer", "ik_smart");
        Map<String, Map<String, String>> properties = new LinkedHashMap<>();
        properties.put("name", map1);
        properties.put("address", map2);
        Map<String, Map<String, Map<String, String>>> map = new LinkedHashMap<>();
        map.put("properties", properties);
        String jsonString = JSON.toJSONString(map);
        
        createIndexRequest.mapping(jsonString, XContentType.JSON);
        
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        //3.根据返回值判断结果
        System.out.println(createIndexResponse.isAcknowledged());
        
    }
    
    /**
     * 查询索引
     */
    @Test
    public void queryIndex() throws IOException {
        IndicesClient indices = client.indices();
        
        GetIndexRequest getRequest = new GetIndexRequest("test_index");
        GetIndexResponse response = indices.get(getRequest, RequestOptions.DEFAULT);
        Map<String, MappingMetadata> mappings = response.getMappings();
        //iter 提示foreach
        for (String key : mappings.keySet()) {
            System.out.println(key + "===" + mappings.get(key).getSourceAsMap());
        }
    }
    
    @Test
    public void deleteIndex() throws IOException {
        IndicesClient indices = client.indices();
        
        GetIndexRequest getIndexRequest = new GetIndexRequest("test_index");
        boolean isExists = indices.exists(getIndexRequest, RequestOptions.DEFAULT);
        if (isExists) {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("test_index");
            AcknowledgedResponse acknowledgedResponse =
                indices.delete(deleteIndexRequest, RequestOptions.DEFAULT);
            System.out.println(acknowledgedResponse.isAcknowledged());
        }
        
    }
    
    /**
     * Bulk 批量操作
     */
    @Test
    public void test2() throws IOException {
        
        //创建bulkrequest对象，整合所有操作
        BulkRequest bulkRequest = new BulkRequest();

           /*
        # 1. 删除5号记录
        # 2. 添加6号记录
        # 3. 修改3号记录 名称为 “三号”
         */
        //添加对应操作
        //1. 删除5号记录
        // DeleteRequest deleteRequest = new DeleteRequest("test_index", "5");
        // bulkRequest.add(deleteRequest);
        
        //2. 添加6号记录
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "六号");
        map.put("address", "河南省郑州市");
        IndexRequest indexRequest = new IndexRequest("test_index").id("6").source(map);
        bulkRequest.add(indexRequest);
        //3. 修改3号记录 名称为 “三号”
        //Map<String, Object> mapUpdate = new HashMap<>();
        //mapUpdate.put("name", "三号");
        //UpdateRequest updateRequest = new UpdateRequest("test_index", "3").doc(mapUpdate);
        //bulkRequest.add(updateRequest);
        
        //执行批量操作
        
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response.status());
        
    }
    
    /**
     * 查询所有
     * 1. matchAll
     * 2. 将查询结果封装为Goods对象，装载到List中
     * 3. 分页。默认显示10条
     */
    @Test
    public void matchAll() throws IOException {
        //2. 构建查询请求对象，指定查询的索引名称
        SearchRequest searchRequest = new SearchRequest("goods");
        //4. 创建查询条件构建器SearchSourceBuilder
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //6. 查询条件
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        //5. 指定查询条件
        sourceBuilder.query(queryBuilder);
        //3. 添加查询条件构建器 SearchSourceBuilder
        searchRequest.source(sourceBuilder);
        // 8 . 添加分页信息  不设置 默认10条
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        //1. 查询,获取查询结果
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        //7. 获取命中对象 SearchHits
        SearchHits hits = searchResponse.getHits();
        //7.1 获取总记录数
        long total = hits.getTotalHits().value;
        System.out.println("总数：" + total);
        //7.2 获取Hits数据  数组
        SearchHit[] hits1 = hits.getHits();
        //获取json字符串格式的数据
        List<Goods> goodsList = new ArrayList<>();
        for (SearchHit searchHit : hits1) {
            String sourceAsString = searchHit.getSourceAsString();
            //转为java对象
            Goods goods = JSON.parseObject(sourceAsString, Goods.class);
            goodsList.add(goods);
        }
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }
    
    @Test
    public void testQuery() throws IOException {
        // 创建请求对象
        SearchRequest searchRequest = new SearchRequest("test_index");
        // 设置请求参数
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("address", "河南省");
        sourceBuilder.query(queryBuilder);
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        Arrays.stream(searchResponse.getHits().getHits()).forEach(System.out::println);
    }
}
