package com.cwk.springbootdata01.springbootdata.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1.配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statviewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

      /*  public static final String SESSION_USER_KEY    = "druid-user";
        public static final String PARAM_NAME_USERNAME = "loginUsername";
        public static final String PARAM_NAME_PASSWORD = "loginPassword";
        public static final String PARAM_NAME_ALLOW    = "allow";
        public static final String PARAM_NAME_DENY     = "deny";
        public static final String PARAM_REMOTE_ADDR   = "remoteAddress";*/

        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername", "cwk");
        map.put("loginPassword", "cwk199651");
        map.put("allow", "");
        map.put("deny", "192.168.0.106");
        bean.setInitParameters(map);
        return bean;
    }

    //2.配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new WebStatFilter());
        HashMap<String, String> map = new HashMap<>();
        map.put("exclusions", "*.css,*.js,/druid/*");
        registrationBean.setInitParameters(map);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }

}
