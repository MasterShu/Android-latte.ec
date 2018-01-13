package club.mastershu.latte.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * Created by Administrator on 2017/12/31.
 */

public class Configurator {
    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private Configurator() {
        //.name() 是以字符串输出
        LATTE_CONFIGS.put(ConfigType.CONFIG_READ.name(), false);
    }

    // 线程安全的懒汉模式
    // 静态内部类
    public static Configurator getInstance() {
        return Hodler.INSTANCE;
    }
    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }
    private static class Hodler {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READ.name(), true);
    }

    // 配置 API_HOST
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    // 配置 ICON
    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++ ) {
                initializer.with(ICONS.get(i));
            }
        }
    }
    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
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

    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigType.INTERCEPTOR, INTERCEPTORS);
        return this;
    }
    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigType.INTERCEPTOR, INTERCEPTORS);
        return this;
    }
}
