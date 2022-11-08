package og.spigot.survival.questmaster.command;

import og.spigot.survival.questmaster.data.OGQuest;
import og.spigot.survival.questmaster.utils.OGQuestMasterUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OGQuestAddCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("ogquestadd")){
            if(strings.length == 4){
                if(isMinecraftMaterial(strings[0])){
                    if(isMinecraftMaterial(strings[2])){
                        if(isValidAmount(strings[1])){
                            if(isValidAmount(strings[3])){

                            }else{
                                commandSender.sendMessage("§7[§3OGQuestMaster§7] >> Please insert a valid amount of material you need to complete the quest");
                            }
                        }else{
                            commandSender.sendMessage("§7[§3OGQuestMaster§7] >> Please insert a valid amount of material you need to complete the quest");
                        }
                    }else{
                        commandSender.sendMessage("§7[§3OGQuestMaster§7] >> Please insert a valid minecraft material for the reward. e.g. diamond");
                    }
                }else{
                    commandSender.sendMessage("§7[§3OGQuestMaster§7] >> Please insert a valid minecraft material. e.g. diamond");
                }
            }else{
                commandSender.sendMessage("§7[§3OGQuestMaster§7] >> Wrong usage. /ogquestadd <name> <resource type> <amount> <reward type> <amount>");
            }
        }else{
            commandSender.sendMessage("§7[§3OGQuestMaster§7] >> Wrong usage. /ogquestadd <name> <resource type> <amount> <reward type> <amount>");
        }
        return true;
    }

    public boolean isMinecraftMaterial(String material){
        try{
            Material minecraftMaterial = Material.getMaterial(material);
            if(material == null){
                return false;
            }
            return true;
        }catch (Exception exception){
            return false;
        }finally {
            return false;
        }
    }

    public boolean isValidAmount(String amount){
        try{
            int valueAmount = Integer.parseInt(amount);
            return true;
        }catch (Exception exception){
            return false;
        }finally {
            return false;
        }
    }
}
