package com.cczq.fly.baselibrary;

import android.app.Application;

public interface IModuleInit {

    boolean  initModuleAhead(Application application);
    boolean  initModuleLow(Application application);
}
