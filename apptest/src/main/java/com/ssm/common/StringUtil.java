package com.ssm.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;

public class StringUtil {
	 private static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	    public StringUtil() {
	    }

	    public static String filterNull(String str) {
	        return str == null?"":str.trim();
	    }

	    public static boolean stringEquals(String source, String target) {
	        return isEmpty(source) && isEmpty(target) || !isEmpty(source) && !isEmpty(target) && source.equals(target);
	    }

	    public static boolean isEmpty(String str) {
	        return filterNull(str).equals("");
	    }

	    public static boolean isNotEmpty(String str) {
	        return !isEmpty(str);
	    }

	    public static boolean containsAny(String str, String... flag) {
	        if(str != null) {
	            if(flag == null || flag.length == 0) {
	                flag = "[-{-}-]-,".split("-");
	            }

	            String[] var2 = flag;
	            int var3 = flag.length;

	            for(int var4 = 0; var4 < var3; ++var4) {
	                String s = var2[var4];
	                if(str.contains(s)) {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }

	    public static boolean isGoodJson(String json) {
	        if(isNotEmpty(json)) {
	            try {
	                JSON.parse(json);
	                return true;
	            } catch (Exception var2) {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }

	    public static boolean isGoodObjectJson(String json) {
	        if(isNotEmpty(json)) {
	            try {
	                JSON.parseObject(json);
	                return true;
	            } catch (Exception var2) {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }

	    public static boolean isGoodArrayJson(String json) {
	        if(isNotEmpty(json)) {
	            try {
	                JSON.parseArray(json);
	                return true;
	            } catch (Exception var2) {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }

	    public static String[] listToStringArray(List<String> list) {
	        return list != null && !list.isEmpty()?(String[])list.toArray(new String[list.size()]):new String[0];
	    }

	    public static String[] setToStringArray(Set<String> set) {
	        return set != null && !set.isEmpty()?(String[])set.toArray(new String[set.size()]):new String[0];
	    }

	    public static List<String> stringsToListArray(String[] strings) {
	        return (List)(strings != null && strings.length > 0?Arrays.asList(strings):new ArrayList());
	    }

	    public static List<String> stringToListArray(String... strings) {
	        return (List)(strings != null && strings.length > 0?Arrays.asList(strings):new ArrayList());
	    }

	    public static String getDateByString(Date date, String format) {
	        if(isEmpty(format)) {
	            format = DEFAULT_FORMAT;
	        }

	        if(date != null) {
	            SimpleDateFormat df = new SimpleDateFormat(format);
	            return df.format(date);
	        } else {
	            return null;
	        }
	    }

	    public static String completionSPDBTxamt(String h) {
	        String s = "";
	        int len = 12 - h.length();
	        if(len > 0) {
	            for(int i = 0; i < len; ++i) {
	                s = s + "0";
	            }

	            s = s + h;
	        }

	        return s;
	    }

	    public static String reductionSPDBTxamt(String h) {
	        int k = 0;

	        for(int i = 0; i < h.length(); ++i) {
	            if(h.charAt(i) != 48) {
	                k = i;
	                break;
	            }
	        }

	        h = h.substring(k, h.length());
	        return h;
	    }

	    public static final String md5Digest(String res) {
	        if(res != null && !"".equals(res)) {
	            char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	            byte[] strTemp;
	            try {
	                strTemp = res.getBytes("gbk");
	            } catch (UnsupportedEncodingException var10) {
	                return null;
	            }

	            try {
	                MessageDigest e = MessageDigest.getInstance("MD5");
	                e.update(strTemp);
	                byte[] md = e.digest();
	                int j = md.length;
	                char[] str = new char[j * 2];
	                int k = 0;

	                for(int dd = 0; dd < j; ++dd) {
	                    byte byte0 = md[dd];
	                    str[k++] = hexDigits[byte0 >>> 4 & 15];
	                    str[k++] = hexDigits[byte0 & 15];
	                }

	                String var12 = new String(str);
	                return var12;
	            } catch (Exception var11) {
	                return null;
	            }
	        } else {
	            return null;
	        }
	    }
}
