package cn.jzyan.global.context;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName : jzyan-spring-cloud
 * @FileName : SessionContext
 * @Version : 1.0
 * @Package : cn.jzyan.global.context
 * @Description : SessionContext
 * @Author : jzyan
 * @CreateDate : 2020/06/02 15:31
 */
public class SessionContext {

    private static final ThreadLocal<SessionContext> LOCAL = ThreadLocal.withInitial(() -> new SessionContext());

    private final Map<String, String> attachments = new HashMap<>();
    private final Map<String, Object> values = new HashMap<>();

    /**
     * get context.
     *
     * @return context
     */
    public static SessionContext getContext() {
        return LOCAL.get();
    }

    /**
     * remove context.
     *
     * @see
     */
    public static void removeContext() {
        LOCAL.remove();
    }

    /**
     * get attachment.
     *
     * @param key
     * @return attachment
     */
    public String getAttachment(String key) {
        return attachments.get(key);
    }

    /**
     * set attachment.
     *
     * @param key
     * @param value
     * @return context
     */
    public SessionContext setAttachment(String key, String value) {
        if (value == null) {
            attachments.remove(key);
        } else {
            attachments.put(key, value);
        }
        return this;
    }

    /**
     * remove attachment.
     *
     * @param key
     * @return context
     */
    public SessionContext removeAttachment(String key) {
        attachments.remove(key);
        return this;
    }

    /**
     * get attachments.
     *
     * @return attachments
     */
    public Map<String, String> getAttachments() {
        return attachments;
    }

    /**
     * set attachments
     *
     * @param attachment
     * @return context
     */
    public SessionContext setAttachments(Map<String, String> attachment) {
        this.attachments.clear();
        if (attachment != null && attachment.size() > 0) {
            this.attachments.putAll(attachment);
        }
        return this;
    }

    public void clearAttachments() {
        this.attachments.clear();
    }

    /**
     * get values.
     *
     * @return values
     */
    public Map<String, Object> get() {
        return values;
    }

    /**
     * set value.
     *
     * @param key
     * @param value
     * @return context
     */
    public SessionContext set(String key, Object value) {
        if (value == null) {
            values.remove(key);
        } else {
            values.put(key, value);
        }
        return this;
    }

    /**
     * remove value.
     *
     * @param key
     * @return value
     */
    public SessionContext remove(String key) {
        values.remove(key);
        return this;
    }

    /**
     * get value.
     *
     * @param key
     * @return value
     */
    public Object get(String key) {
        return values.get(key);
    }

}
