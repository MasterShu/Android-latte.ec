package club.mastershu.latte.app;

import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/12/31.
 */

public class Configurator {
    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        //.name() 是以字符串输出
        LATTE_CONFIGS.put(ConfigType.CONFIG_READ.name(), false);
    }

    // 线程安全的懒汉模式
    // 静态内部类
    public static Configurator getInstance() {
        return Hodler.INSTANCE;
    }
    final WeakHashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }
    private static class Hodler {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READ.name(), true);
    }

    // 配置 API_HOST
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    // 检查配置项
    private void checkConfigurator() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READ.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call Configure.");
        }
    }

    // 告诉编译器 没有检查过类型的, 但不抛出警告
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration (Enum<ConfigType> key) {
        checkConfigurator();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
