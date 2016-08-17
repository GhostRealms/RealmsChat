package net.ghostrealms.RealmsChat.spigot;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class RealmsChatBukkit extends JavaPlugin {

    private static Economy economy = null;
    private static Chat chat = null;

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        setupChat();
        setupEconomy();
    }

    @Override
    public void onDisable() {

    }


    //Vault Setup Classes from the Vault Documentation.

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }
}
