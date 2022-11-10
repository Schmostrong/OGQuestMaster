package og.spigot.survival.questmaster.listener;

import og.spigot.survival.questmaster.utils.OGQuestMasterUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OGQuestMasterListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent joinEvent){
        OGQuestMasterUtils.getInstance().showAllQuestMastersToPlayer(joinEvent.getPlayer());
    }
}
