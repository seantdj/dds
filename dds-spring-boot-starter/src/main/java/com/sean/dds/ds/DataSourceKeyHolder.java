package com.sean.dds.ds;

/**
 * @author tengdj
 * @date 2020/2/26 15:39
 **/
public class DataSourceKeyHolder {

    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setRoutingKey(String key){
        holder.set(key);
    }

    public static void clearRoutingKey(){
        holder.remove();
    }

}
