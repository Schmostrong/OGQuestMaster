package og.spigot.survival.questmaster.data;

import net.minecraft.server.v1_16_R3.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

public class OGQuestMaster {
    private EntityPlayer questMaster;
    private List<OGQuest> quests;

    public OGQuestMaster(){

    }

    public OGQuestMaster(EntityPlayer questMaster) {
        this.questMaster = questMaster;
        this.quests = new ArrayList<>();
    }

    /**
     * Function return the EntityPlayer object referencing the npc visible to the player
     *
     * @return - EntityPlayer object referencing the npc
     */
    public EntityPlayer getQuestMaster() {
        return questMaster;
    }

    /**
     * Function is used to set the npc figuring the QuestMaster
     *
     * @param questMaster - EntityPlayer object which is the visible npc
     */
    public void setQuestMaster(EntityPlayer questMaster) {
        this.questMaster = questMaster;
    }

    /**
     * Returns the list of quests this QuestMaster holds
     *
     * @return - List of OGQuest objects
     */
    public List<OGQuest> getQuests() {
        return quests;
    }

    /**
     * Function is used to add a new quest for this QuestMaster
     *
     * @param quest - OGQuest object to be added to the quests of this QuestMaster
     */
    public void addQuest(OGQuest quest){
        this.quests.add(quest);
    }

    /**
     * Function is used to remove a Quest for this QuestMaster
     *
     * @param quest - OGQuest to remove
     */
    public void removeQuest(OGQuest quest){
        this.quests.remove(quest);
    }
}
