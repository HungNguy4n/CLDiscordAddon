package com.HungNguyen;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class CLDiscord extends JavaPlugin {
    private final AccountLinkListener eventListeners = new AccountLinkListener();

    @Override
    public void onEnable() {
        try {
            if (DiscordSRV.isReady) {
                DiscordSRV.api.subscribe(eventListeners);
                getLogger().info("EventListeners đã được đăng ký thành công.");
            } else {
                getLogger().warning("DiscordSRV chưa sẵn sàng khi onEnable được gọi.");
            }
        } catch (Exception e) {
            getLogger().severe("Không thể đăng ký EventListeners: " + e.getMessage());
        }
    }

    @Override
    public void onDisable() {
        try {
            if (DiscordSRV.isReady) {
                DiscordSRV.api.unsubscribe(eventListeners);
                getLogger().info("EventListeners đã được hủy đăng ký thành công.");
            } else {
                getLogger().warning("DiscordSRV chưa sẵn sàng khi onDisable được gọi.");
            }
        } catch (Exception e) {
            getLogger().severe("Không thể hủy đăng ký EventListeners: " + e.getMessage());
        }
    }
}
