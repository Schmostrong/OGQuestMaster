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
                                //Create new OGQuest and add to the currently loaded quests
                                OGQuestMasterUtils.getInstance().addOGQuest(new OGQuest(strings[0], Integer.parseInt(strings[1]), strings[2], Integer.parseInt(strings[3])));
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

    /**
     * Function is used to check, if a given String can be parsed as a material existing in minecraft
     *
     * @param material - String representing the material to be checked
     * @return - Boolean that is set to true or false, depending on the outcome of the check
     */
    public boolean isMinecraftMaterial(String material){
        try{
            Material minecraftMaterial = Material.getMaterial(material);
            if(minecraftMaterial == null){
                return false;
            }
            return true;
        }catch (Exception exception){
            return false;
        }finally {
            return false;
        }
    }

    /**
     * Function is used to check, wheter a given String can be parsed as a valid number representing the amount of given materials
     *
     * @param amount - String that should be tried to parse as a numeric value
     * @return - Boolean that is set to true or false, depending on the outcome of the check
     */
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
