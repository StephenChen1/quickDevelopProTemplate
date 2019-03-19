package cn.stephenchen.study.util;

import cn.stephenchen.study.base.JsonRequest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 对象格式转换工具类
 */
public class ConvertUtil {

    /**
     * 查询对象转换成map形式，将页码和页容量转换成限制条件加进map
     */
    public static Map<String,Object> objParamsToMap(Object obj) {
        try{
            Map<String, Object> map = new HashMap<>();
            Class<?> clazz = obj.getClass();
            System.out.println(clazz);
            //转换成map
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(obj);
                map.put(fieldName, value);
            }
            Integer pageNum = (Integer)map.get("pageNum") ;
            Integer pageCount = (Integer)map.get("pageCount");
            System.out.println("pageNum："+ pageNum);
            System.out.println("pageCount：" + pageCount);
            //若页码为空，则将页码给默认值 1
            if(null == pageNum  || 1 > pageNum ){
                pageNum = 1 ;
            }
            //若页容量为空，则将页容量给默认值 20
                if(null == pageCount  || 1 < pageCount){
                pageCount = 20 ;
            }
            int pageOffset = (pageNum - 1) * pageCount;
            String limitCondition = " limit " + pageOffset + "," + pageCount;
            map.put("limitCondition",limitCondition);

            //获取isDeleted参数，若无，则默认给N,即未删除的
            String isDeleted = (String)map.get("isDeleted");
            if(null == isDeleted || "".equals(isDeleted)){
                map.put("isDeleted","N");
            }
            System.out.println("map参数如下：");
            for(String key : map.keySet()){
                System.out.println(key + ":"+ map.get(key));
            }
            System.out.println("map参数结束");
            return map;
        }catch (Exception e){
            System.out.println("====对象转为map出错====");
            e.printStackTrace();
            System.out.println("====对象转为map出错报告结束====");
        }
        return null;
    }


    /**
     * 将包含主要查询参数data和辅助查询参数的查询请求对象转换为直接适合数据库查询的map型参数
     */
    public static <R> Map<String , Object> JsonRequestToMapParams(JsonRequest jsonRequest){
        Map<String , Object > params = new HashMap<>(5);
        //1、先将data里面的参数放进map
        //1.1得到data参数，将其转换为Map型对象（尚未知原理）
        LinkedHashMap<String,Object> map = (LinkedHashMap<String,Object>)jsonRequest.getData();
        for(String key : map.keySet()){
            System.out.println(key + " : " + map.get(key));
            //参数插入查询条件
            params.put(key, map.get(key));
        }
        //2、将页码和页容转换，写进map参数(该值在map中必有的)
        //2.1获取页码和页容量
        Integer pageNum = jsonRequest.getPageNum();
        Integer pageCount = jsonRequest.getPageCount();
        //2.2若页码为空，则将页码给默认值 1
        if(null == pageNum  || 1 > pageNum ){
            pageNum = 1 ;
        }
        //2.3若页容量为空，则将页容量给默认值 20
        if(null == pageCount  || 1 < pageCount){
            pageCount = 20 ;
        }
        //2.4转换为偏移量查询参数
        int pageOffset = (pageNum - 1) * pageCount;
        String limitCondition = " limit " + pageOffset + "," + pageCount;
        params.put("limitCondition",limitCondition);

        //3、将排序列参数和升降序参数写进map参数（该值若没有，则map中不加入此参数）
        //3.1获得列参数和升降序参数
        String orderColumn = jsonRequest.getOrderColumn();
        String orderFlag = jsonRequest.getOrderFlag();
        //3.2定义参数值字符串
        String orderBySql = "";
        //3.3列参数非空，则转换成排序参数
        if( null != orderColumn && !"".equals(orderColumn) ){
            orderBySql = orderColumn ;
            //3.4升降序标识为空，则默认降序(注意要有空格)
            if(null == orderFlag || "".equals(orderFlag) || "down".equals(orderFlag)){
                orderBySql += " DESC" ;
            }else{
                orderBySql += " ASC" ;
            }
        }
        //3.4判断该参数最后是否有值，有则加入map参数
        if(!"".equals(orderBySql)){
            params.put("orderBySql",orderBySql);
        }

        //打印map，看是否正确
        System.out.println("查询参数转换后的map如下：");
        for(String key : params.keySet()){
            System.out.println(key + " : " + params.get(key));
        }
        System.out.println("查询参数转换后的map显示结束");

        return params ;


    }

}
