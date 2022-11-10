package og.spigot.survival.questmaster.utils;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R3.*;
import og.spigot.survival.questmaster.data.OGQuest;
import og.spigot.survival.questmaster.data.OGQuestMaster;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.*;

public class OGQuestMasterUtils {
    public static OGQuestMasterUtils ogQuestMasterUtils;

    //List that holds every loaded Quest loaded
    private Set<OGQuest> ogQuests;
    //List that holds all QuestMasters that are spawned
    private List<OGQuestMaster> questMasters;

    public OGQuestMasterUtils(){
        this.ogQuests = new HashSet<>();
        this.questMasters = new ArrayList<>();
    }

    /**
     * Function is used to add a new quest to the loaded quests
     *
     * @param quest - OGQuest object that should be added
     */
    public void addOGQuest(OGQuest quest){
        this.ogQuests.add(quest);
    }

    /**
     * Function is used to spawn a new QuestMaster and show it to all currently loaded players
     * @param player
     */
    public void spawnQuestMaster(Player player){
        MinecraftServer serverInstance = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer worldServer = ((CraftWorld)Bukkit.getWorld(player.getWorld().getName())).getHandle();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "§7[§3QuestMaster§7]");
        EntityPlayer npc = new EntityPlayer(serverInstance, worldServer, profile, new PlayerInteractManager(worldServer));
        npc.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());

        //Visualize this newly spawned npc to every player, by sending the necessary pakets
        for(Player p : Bukkit.getOnlinePlayers()){
            showSpecificQuestMasterToPlayer(p, npc);
        }

        this.questMasters.add(new OGQuestMaster(npc));
    }

    /**
     * Function is used to make a specific QuestMaster visible to a single player. The function is triggered when a new QuestMaster is spawned
     *
     * @param player - player object to show the new npc to
     * @param npc - the npc to show to the player
     */
    public void showSpecificQuestMasterToPlayer(Player player, EntityPlayer npc){
        PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256 / 360)));
    }

    /**
     * This function is used to make all npcs visible to a single player.
     * It it triggered when a new player joins the server
     *
     * @param player - player to show the npcs to
     */
    public void showAllQuestMastersToPlayer(Player player){
        for (OGQuestMaster questMaster : this.questMasters){
            showSpecificQuestMasterToPlayer(player, questMaster.getQuestMaster());
        }
    }

    /**
     * Function is used to get the singleton instance of the OGQuestMasterUtils class
     *
     * @return - OGQuestMasterUtils object
     */
    public static OGQuestMasterUtils getInstance(){
        if(ogQuestMasterUtils == null){
            ogQuestMasterUtils = new OGQuestMasterUtils();
        }
        return ogQuestMasterUtils;
    }

}
