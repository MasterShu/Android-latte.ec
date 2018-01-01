package club.mastershu.latte.app;

/**
 * Created by Administrator on 2018/1/1.
 */

/**
 * 整个应用程序里面 唯一的单例
 * 仅能被初始化一次
 * 在进行多线程时, 其可以做安全的惰性单例初始化
 * 线程安全的懒汉模式
 */
public enum ConfigType {
    API_HOST,   // 网络请求域名
    APPLICATION_CONTEXT,    // 应用的上下文
    CONFIG_READ,    // 控制初始化后完成度
    ICON    // 存储字体初始化配置
}
