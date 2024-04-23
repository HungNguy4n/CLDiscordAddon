package com.HungNguyen;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.AccountLinkedEvent;
import github.scarsz.discordsrv.api.events.AccountUnlinkedEvent;
import net.dv8tion.jda.api.entities.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AccountLinkListener {

    @Subscribe
    public void onAccountLinked(AccountLinkedEvent event) {
        Player player = Bukkit.getPlayer(event.getPlayer().getUniqueId());
        String discordId = event.getUser().getId();
        User discordUser = (User) DiscordSRV.getPlugin().getJda().getUserById(discordId);
        String discordUsername = (discordUser != null) ? discordUser.getName() : "unknown";

        // Thông điệp hiển thị cho người chơi
        String kickMessage = "&bBạn vừa liên kết tài khoản Discord với tên: " + discordUsername + "\n&bVui lòng đăng nhập lại!";

        if (player != null) {
            player.kickPlayer(kickMessage);
        }
    }

    @Subscribe
    public void onAccountUnlinked(AccountUnlinkedEvent event) {
        Player player = Bukkit.getPlayer(event.getPlayer().getUniqueId());
        String discordId = event.getDiscordId();
        User discordUser = (User) DiscordSRV.getPlugin().getJda().getUserById(discordId);

        String discordUsername = (discordUser != null) ? discordUser.getName() : "unknown";
        String kickMessage = "&bBạn vừa bị hủy liên kết với tài khoản Discord: " + discordUsername + "\n&bBạn có thể đăng nhập và liên kết lại!";

        if (player != null) {
            player.kickPlayer(kickMessage);
        }
    }
}
