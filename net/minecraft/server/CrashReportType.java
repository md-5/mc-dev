package net.minecraft.server;

import java.util.concurrent.Callable;

class CrashReportType implements Callable {

    final DedicatedServer a;

    CrashReportType(DedicatedServer dedicatedserver) {
        this.a = dedicatedserver;
    }

    public String a() {
        return "Dedicated Server";
    }

    public Object call() {
        return this.a();
    }
}
