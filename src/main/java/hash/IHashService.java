package hash;

/**
 * @author djl
 * @create 2021/2/26 21:36
 */
public interface IHashService {
    /**
     * 求出hash值
     *
     * @param key
     * @return
     */
    Long hash(String key);
}
