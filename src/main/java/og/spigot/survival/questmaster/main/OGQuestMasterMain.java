package og.spigot.survival.questmaster.main;

import og.spigot.survival.questmaster.command.OGQuestAddCommand;
import og.spigot.survival.questmaster.command.OGQuestSpawnMasterCommand;
import og.spigot.survival.questmaster.listener.OGQuestMasterListener;
import og.spigot.survival.questmaster.utils.OGQuestMasterUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class OGQuestMasterMain extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("ogquestadd").setExecutor(new OGQuestAddCommand());
        getCommand("ogquestspawnmaster").setExecutor(new OGQuestSpawnMasterCommand());

        this.getServer().getPluginManager().registerEvents(new OGQuestMasterListener(), this);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
