package com.back.inditex.qa.resources;

import org.apache.commons.lang3.RandomStringUtils;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
public class Utils {
    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return sdf.format(timestamp);
    }
    public static String getTransactionId() {
        char data[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String str = new String(data);
        String nanoId = RandomStringUtils.random(5, data) + '-' + RandomStringUtils.randomNumeric(8);
        return nanoId;
    }
    public static String getOrderId() {
        String ecommerceId = RandomStringUtils.randomNumeric(12) + '-' + RandomStringUtils.randomNumeric(1);
        return ecommerceId;
    }
    public String detectOS() {
        return System.getProperty("os.name");
    }
    public String getUser() {
        return System.getProperty("user.name");
    }
    public static Map<String, String> getPersonalProfileMap(Integer codeHU){
        String cellPhone = "+" + "50760" +RandomStringUtils.randomNumeric(6);
        String email = "sample"+codeHU+RandomStringUtils.randomAlphabetic(4)+"@hotmail.com";
        String personalId = "8" +'-'+RandomStringUtils.randomNumeric(3)+'-'+RandomStringUtils.randomNumeric(4);
        String clientId = "fg7d22d3" + '-' + "cuen" + '-' + codeHU + '-' + RandomStringUtils.randomAlphanumeric(4).toLowerCase() +  '-'  + RandomStringUtils.randomAlphanumeric(12).toLowerCase();
        String mask = RandomStringUtils.randomNumeric(2) + "********" + RandomStringUtils.randomNumeric(2);
        Map<String, String>  personalProfile = new HashMap<String,String>();
        personalProfile.put("clientId", clientId);
        personalProfile.put("email", email);
        personalProfile.put("identification",personalId);
        personalProfile.put("phoneNumber", cellPhone);
        personalProfile.put("mask", mask);
        return personalProfile;
    }
}
