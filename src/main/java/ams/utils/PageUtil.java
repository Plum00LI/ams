package ams.utils;

import ams.dao.IBaseDao;

import ams.entity.PageData;
import java.lang.reflect.*;
import java.util.*;

public class PageUtil {

    public static Map<String, Object> getPageData(Map<String, Object> map, IBaseDao dao) {

        List<String> orderData = CastUtil.cast(map.get("orderData"));

        String orderStr = "";

        if (orderData != null) {
            for (int i = 0; i < orderData.size(); i++) {
                if (i == orderData.size() - 1) {
                    orderStr += orderData.get(i);
                    break;
                }
                orderStr += orderData.get(i) + ",";
            }
        }
        Integer currentPage = (Integer) map.get("currentPage");

		Integer start = (currentPage - 1) * 10;
		

        Integer totalPage = 1;

		// sql中的start
		map.put("start", start);
		// 每页显示10条
		map.put("pageSize", 10);
		

		//排序条件
		map.put("orderStr", orderStr);

        // 获取总个数
        Integer totalCount = dao.likeSelectCount(map).intValue();

        List<Map<String, Object>> resultList = dao.likeSelect(map);

        if (totalCount != 0) {

            if (totalCount % 10 == 0) {
                totalPage = totalCount / 10;
            } else {
                totalPage = totalCount / 10 + 1;
            }

        }

        map.clear();
        // 当前页
        map.put("currentPage", currentPage);

        map.put("count", totalCount);

        map.put("totalPage", totalPage);

        map.put("result", resultList);

        return map;
    }


	private static <E> void initEntity(E entity, Class<?> entityClass, String orderStr, Integer start) throws NoSuchFieldException, IllegalAccessException {
        	Field startFiled = entityClass.getSuperclass().getDeclaredField("start");
            startFiled.setAccessible(true);
            // sql中的start
            startFiled.set(entity,start);

            Field pageSizeFiled = entityClass.getSuperclass().getDeclaredField("pageSize");
            pageSizeFiled.setAccessible(true);
            // 每页显示10条
            pageSizeFiled.set(entity,10);
            Field orderStrFiled = entityClass.getSuperclass().getDeclaredField("orderStr");
            orderStrFiled.setAccessible(true);
            //排序条件
            orderStrFiled.set(entity, orderStr);
    }

}

