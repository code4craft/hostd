package us.codecraft.blackhole.suite.util;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * User: cairne
 * Date: 13-5-26
 * Time: 下午4:19
 */
public class UserZonesUtils {

    public static class DomainConfig {
        private String domain;
        private boolean active;
        private String ip;

        public DomainConfig() {
        }

        public DomainConfig(String domain, String ip, boolean active) {
            this.active = active;
            this.domain = domain;
            this.ip = ip;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }
    }

    public static String fromJson(String json) throws IOException {
        StringBuilder sb = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> list = (List<Map<String,Object>>) objectMapper.readValue(json, List.class);
        for (Map<String, Object> objectMap : list) {
            List<Map> config = (List<Map>)objectMap.get("config");
            for (Map domainConfig : config) {
                sb.append(((Boolean) domainConfig.get("active") ? "" : "#") + domainConfig.get("ip") + "\t" + domainConfig.get("domain") + "\n");
            }
        }


        return sb.toString();
    }

    public static String toJson(String text) throws IOException {
        if (StringUtils.isBlank(text)) {
            return "[]";
        }
        Map<String, List<DomainConfig>> map = new LinkedHashMap<String, List<DomainConfig>>();
        String[] lines = text.split("\n");
        for (String line : lines) {
            boolean isActive = true;
            line = StringUtils.trim(line);
            if (StringUtils.startsWith(line, "#")) {
                isActive = false;
                line = line.replaceAll("^#+", "");
            }
            String[] tokens = line.split("\\s+");
            if (tokens.length > 1) {
                String ip = tokens[0];
                for (int i = 1; i < tokens.length; i++) {
                    String domain = tokens[i];
                    List<DomainConfig> domainConfigs = map.get(domain);
                    if (domainConfigs == null) {
                        domainConfigs = new ArrayList<DomainConfig>();
                        map.put(domain, domainConfigs);
                    }
                    domainConfigs.add(new DomainConfig(domain, ip, isActive));
                }
            }
        }
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (Map.Entry<String, List<DomainConfig>> listEntry : map.entrySet()) {
            Map<String,Object> innerMap = new LinkedHashMap<String, Object>();
            innerMap.put("domain",listEntry.getKey());
            innerMap.put("config",listEntry.getValue());
            list.add(innerMap);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(list);
    }

    public static String merge(String textA,String textB){
        if (StringUtils.isBlank(textA)&&StringUtils.isBlank(textB)){
            return "";
        }
        if (StringUtils.isBlank(textA)){
            return textB;
        }
        if (StringUtils.isBlank(textB)){
            return textA;
        }
        String[] linesA = textA.split("\n");
        String[] linesB = textB.split("\n");
        Map<String,Boolean> linesMap = new LinkedHashMap<String, Boolean>();
        for (String line:linesA){
            boolean isActive = true;
            line = StringUtils.trim(line);
            if (StringUtils.startsWith(line, "#")) {
                isActive = false;
                line = line.replaceAll("^#+", "");
            }
            if (linesMap.get(line)==null||!linesMap.get(line)){
                linesMap.put(line,isActive);
            }
        }
        for (String line:linesB){
            boolean isActive = true;
            line = StringUtils.trim(line);
            if (StringUtils.startsWith(line, "#")) {
                isActive = false;
                line = line.replaceAll("^#+", "");
            }
            if (linesMap.get(line)==null||!linesMap.get(line)){
                linesMap.put(line,isActive);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Boolean> entry : linesMap.entrySet()) {
            sb.append(entry.getValue()?entry.getKey():"#"+entry.getKey()+"\n");
        }
        return sb.toString();
    }

}
