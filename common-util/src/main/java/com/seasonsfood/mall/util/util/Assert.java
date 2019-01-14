package com.seasonsfood.mall.util.util;//

import com.seasonsfood.mall.util.exception.AssertFailException;
import com.seasonsfood.mall.util.exception.BizException;

import java.util.Collection;
import java.util.Map;

/**
 * @Author zhaozhirong
 * @Date 2018/11/24 16:41
 */
public class Assert {
    private static String IS_TRUE_STR = "参数必须为真";
    private static String IS_NULL_STR = "参数必须为空";
    private static String NOT_NULL_STR = "参数必须非空";
    private static String HAS_LENGTH_STR = "参数必须有长度";
    private static String HAS_TEXT_STR = "参数必须为非空格字符";
    private static String DOES_NOT_CONTAIN = "父串不包含子串";
    private static String NOT_EMPTY = "集合不能为空";
    private static String NO_NULL_ELEMENTS = "集合不能包含空元素";


    /**
     * 断言参数为真，抛出指定异常 .
     *
     * @param expression
     * @param message
     * @return void
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            error(message);
        }
    }

    /**
     * 断言参数为真 .
     *
     * @param expression
     * @return
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, IS_TRUE_STR);
    }

    /**
     * 断言参数为空，抛出指定异常 .
     *
     * @param object
     * @param message
     * @return
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            error(message);
        }
    }

    /**
     * 断言参数为空 .
     *
     * @param object
     * @return
     */
    public static void isNull(Object object) {
        isNull(object, IS_NULL_STR);
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            error(message);
        }
    }

    /**
     * 断言参数不为空 .
     *
     * @param object
     * @return
     */
    public static void notNull(Object object) {
        notNull(object, NOT_NULL_STR);
    }

    /**
     * 断言参数有长度 .
     *
     * @param text
     * @param message
     * @return
     */
    public static void hasLength(String text, String message) {
        if (!Utils.hasLength(text)) {
            error(message);
        }
    }

    /**
     * 断言参数有长度 .
     *
     * @param text
     * @return
     */
    public static void hasLength(String text) {
        hasLength(text, HAS_LENGTH_STR);
    }

    /**
     * 断言参数有非空字符 .
     *
     * @param text
     * @param message
     * @return
     */
    public static void hasText(String text, String message) {
        if (!Utils.hasText(text)) {
            error(message);
        }
    }


    /**
     * 断言参数有非空格字符 .
     *
     * @param text
     * @return
     */
    public static void hasText(String text) {
        hasText(text, HAS_TEXT_STR);
    }


    /**
     * 断言父串不包含子串 .
     *
     * @param textToSearch 父串
     * @param substring    子串
     * @param message      异常提示信息
     * @return
     */
    public static void doesNotContain(String textToSearch, String substring, String message) {
        if (Utils.hasLength(textToSearch) && Utils.hasLength(substring) &&
                textToSearch.contains(substring)) {
            error(message);
        }
    }

    /**
     * 断言父串不包含子串 .
     *
     * @param textToSearch 父串
     * @param substring    子串
     * @return
     */
    public static void doesNotContain(String textToSearch, String substring) {
        doesNotContain(textToSearch, substring, DOES_NOT_CONTAIN + substring);
    }

    /**
     * 断言集合非空 .
     *
     * @param array
     * @param message
     * @return
     */
    public static void notEmpty(Object[] array, String message) {
        if (Utils.isEmpty(array)) {
            error(message);
        }
    }

    /**
     * 断言集合非空 .
     *
     * @param array
     * @return
     */
    public static void notEmpty(Object[] array) {
        notEmpty(array, NOT_EMPTY);
    }

    /**
     * 断言集合不包含空元素 .
     *
     * @param array
     * @param message
     * @return
     */
    public static void noNullElements(Object[] array, String message) {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    error(message);
                }
            }
        }
    }

    /**
     * 断言集合不包含空元素 .
     *
     * @param array
     * @return
     */
    public static void noNullElements(Object[] array) {
        noNullElements(array, NO_NULL_ELEMENTS);
    }

    /**
     * 断言集合非空 .
     *
     * @param collection
     * @param message
     * @return
     */
    public static void notEmpty(Collection<?> collection, String message) {
        if (Utils.isEmpty(collection)) {
            error(message);
        }
    }

    /**
     * 断言集合非空 .
     *
     * @param collection
     * @return
     */
    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, NOT_EMPTY);
    }

    /**
     * 断言集合非空 .
     *
     * @param map
     * @param message
     * @return
     */
    public static void notEmpty(Map<?, ?> map, String message) {
        if (Utils.isEmpty(map)) {
            error(message);
        }
    }

    /**
     * 断言集合非空 .
     *
     * @param map
     * @return
     */
    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, NOT_EMPTY);
    }


    public static void isInstanceOf(Class<?> clazz, Object obj) {
        isInstanceOf(clazz, obj, "");
    }

    public static void isInstanceOf(Class<?> type, Object obj, String message) {
        notNull(type, "Type to check against must not be null");
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(
                    (Utils.hasLength(message) ? message + " " : "") +
                            "Object of class [" + (obj != null ? obj.getClass().getName() : "null") +
                            "] must be an instance of " + type);
        }
    }


    public static void isAssignable(Class<?> superType, Class<?> subType) {
        isAssignable(superType, subType, "");
    }


    public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
        notNull(superType, "Type to check against must not be null");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            throw new IllegalArgumentException((Utils.hasLength(message) ? message + " " : "") +
                    subType + " is not assignable to " + superType);
        }
    }


//	public static void error() {
//		throw new AssertionError();
//	}

    public static void error(String message) {
        throw new AssertFailException(message);
    }

    private Assert() {
    }


}

class Utils {
    static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    static boolean hasText(String str) {
        return hasText((CharSequence) str);
    }

    static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    static boolean isEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

    static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }
}
