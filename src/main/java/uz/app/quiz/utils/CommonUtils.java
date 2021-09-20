package uz.app.quiz.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.sql.Timestamp;

public class CommonUtils {
    /**
     *
     * @param page
     * @param size
     */
    public static void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new NullPointerException("Sahifa soni noldan kam bo'lishi mumkin emas.");
        }

        if (size > AppConstants.MAX_PAGE_SIZE) {
            throw new NullPointerException("Sahifa soni " + AppConstants.MAX_PAGE_SIZE + " dan ko'p bo'lishi mumkin emas.");
        }
    }

    /**
     *
     * @param page
     * @param size
     * @param byField
     * @return
     */
    public static Pageable getPageable(int page, int size, String byField) {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size, Sort.Direction.DESC, byField);
    }

    public static Pageable getPageable(int page, int size) {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
    }

    /**
     *
     * @param page
     * @param size
     * @return
     */
    public static Pageable getPageableWithoutSort(int page, int size) {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size);
    }

    /**
     *
     * @param page
     * @param size
     * @return
     */
    public static Pageable getPageableForNative(int page, int size) {
        validatePageNumberAndSize(page, size);
        return PageRequest.of(page, size, Sort.Direction.DESC, "created_at");
    }

    /**
     *
     * @param timestamp
     * @param isFrom
     * @return
     */
    public static Timestamp validTimestamp(Timestamp timestamp, Boolean isFrom) {
        if (isFrom)
            return timestamp == null ? new Timestamp(1) : timestamp;
        return timestamp == null ? new Timestamp(System.currentTimeMillis()) : timestamp;
    }

    /**
     *
     * @param map
     * @param cls
     * @return
     */
    public static Object parseHashMapToObject(Object map, Class cls) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String jsonString = gson.toJson(map);
        return gson.fromJson(jsonString, cls);
    }
    public static String parseObjectToJson(Object obj ) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String jsonString = gson.toJson(obj);
        return  jsonString = gson.toJson(obj);
    }

    /**
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static Object stringToObject(String jsonString, Class cls) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(jsonString, cls);
    }
}
