package og.spigot.survival.questmaster.command;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R3.*;
import og.spigot.survival.questmaster.utils.OGQuestMasterUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class OGQuestSpawnMasterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;

            if(command.getName().equalsIgnoreCase("ogquestspawnmaster")){
                OGQuestMasterUtils.getInstance().spawnQuestMaster(player);
                commandSender.sendMessage("§7[§3OGQuestMaster§7] >> The QuestMaster was successfully spawned");
                return true;
            }else{
                commandSender.sendMessage("§7[§3OGQuestMaster§7] >> Wrong usage. Use /ogquestspawnmaster instead");
            }
            return true;
        }else{
            commandSender.sendMessage("§7[§3OGQuestMaster§7] >> You can't use this command on the console");
            return true;
        }
    }
}
