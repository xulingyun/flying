package com.cczq.fly.flying.room;

import android.arch.paging.DataSource;

public abstract class Factory<Key, Value> {
    public abstract DataSource<Key, Value> create();
}
