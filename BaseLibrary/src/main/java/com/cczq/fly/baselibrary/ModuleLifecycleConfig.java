package com.cczq.fly.baselibrary;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class ModuleLifecycleConfig implements IModuleInit{

    private ModuleLifecycleConfig instance;

    private ModuleLifecycleConfig() {
    }

    public ModuleLifecycleConfig getInstance() {
        if(instance==null){
            synchronized (ModuleLifecycleConfig.class){
                if(instance==null){
                    instance = new ModuleLifecycleConfig();
                }
            }
        }
        return instance;
    }

    public boolean  initModuleAhead(Application application){
        //初始化阿里路由框架
        if (BuildConfig.DEBUG) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application); // 尽可能早，推荐在Application中初始化
        return false;
    }

    public boolean  initModuleLow(Application application){
        return false;
    }
}
