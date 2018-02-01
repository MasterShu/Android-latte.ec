package club.mastershu.latte.ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/2/1.
 */

public class ReleaseOpenHelper extends DaoMaster.OpenHelper {
    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
}
