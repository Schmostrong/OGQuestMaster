package og.spigot.survival.questmaster.utils;

import og.spigot.survival.questmaster.data.OGQuest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OGQuestMasterUtils {
    public static OGQuestMasterUtils ogQuestMasterUtils;

    //List that holds every loaded Quest loaded
    private Set<OGQuest> ogQuests;

    public OGQuestMasterUtils(){
        this.ogQuests = new HashSet<>();
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
