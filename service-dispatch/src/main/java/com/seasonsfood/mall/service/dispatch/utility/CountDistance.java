package com.seasonsfood.mall.service.dispatch.utility;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.Iterator;
//import net.sf.json.JSONObject;

public class CountDistance {
        public static String getDistance(Double originLng,Double originLat ,Double destinationLng,Double destinationlat) {
          //距离
            String distance =null;
            try {
                JSONArray jsonObject = getDistanceInfo( originLng, originLat,destinationLng,destinationlat).getJSONArray("result");
                for (Iterator<Object> iterator = jsonObject.iterator(); iterator.hasNext();) {
                    JSONObject obj = (JSONObject) iterator.next();
                    JSONObject obj11=obj.getJSONObject("distance");
                   // distance=obj11.getString("text");//米
                    distance=obj11.getString("value");//公里
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return distance;
        }
        public static JSONObject getDistanceInfo(Double originLng,Double originLat ,Double destinationLng,Double destinationlat) {
            String serverUrl="https://api.map.baidu.com/routematrix/v2/driving?" + "ak" + "=42b8ececa9cd6fe72ae4cddd77c0da5d" +
                    "&output=json&origins=" +originLat+","+originLng
                    + "&destinations=" +destinationlat +"," +destinationLng;
            System.out.println(serverUrl);
            JSONObject obj = JSONObject.parseObject(HttpUtil.getRequest(serverUrl));
            return obj;
        }
}
