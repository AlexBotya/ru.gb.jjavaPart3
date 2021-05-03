package ru.geekbrains.java3;

import org.junit.platform.engine.discovery.DirectorySelector;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestRunner {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        LauncherDiscoveryRequest launcherReauest = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(ReturnArrayConsistsAllAfterLastFour.class)).build();
        Launcher launcher = LauncherFactory.create();
        launcher.discover(launcherReauest);

        launcher.registerTestExecutionListeners(new SummaryGeneratingListener());
        launcher.execute(launcherReauest);

    }
}
