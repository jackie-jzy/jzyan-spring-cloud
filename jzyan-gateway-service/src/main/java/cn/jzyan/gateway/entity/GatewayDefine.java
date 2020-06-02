package cn.jzyan.gateway.entity;


import com.alibaba.fastjson.JSON;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : GatewayDefine
 * @Version : 1.0.0
 * @Package : cn.jzyan.gateway.entity
 * @Description : 路由配置
 * @Author : jzyan
 * @CreateDate : 2020/05/14 18:31
 */
@Entity
@Table(name = "gateway_define")
public class GatewayDefine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String routeId;

    private String uri;

    private String predicates;

    private String filters;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPredicates() {
        return predicates;
    }

    public void setPredicates(String predicates) {
        this.predicates = predicates;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }


    public List<PredicateDefinition> getPredicateDefinition() {
        if (this.predicates != null) {
            List<PredicateDefinition> predicateDefinitionList = JSON.parseArray(this.predicates, PredicateDefinition.class);
            return predicateDefinitionList;
        } else {
            return null;
        }
    }

    public List<FilterDefinition> getFilterDefinition() {
        if (this.filters != null) {
            List<FilterDefinition> filterDefinitionList = JSON.parseArray(this.filters, FilterDefinition.class);
            return filterDefinitionList;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "GatewayDefine{" +
                "id='" + id + '\'' +
                ", routeId='" + routeId + '\'' +
                ", uri='" + uri + '\'' +
                ", predicates='" + predicates + '\'' +
                ", filters='" + filters + '\'' +
                '}';
    }
}
