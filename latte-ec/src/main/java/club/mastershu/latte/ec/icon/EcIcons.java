package club.mastershu.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by Administrator on 2018/1/3.
 */

public enum EcIcons implements Icon {
    icon_scan('\ue501'),
    icon_ali_pay('\ue616');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }
    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return 0;
    }
}
