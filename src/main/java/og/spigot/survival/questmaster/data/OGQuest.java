package og.spigot.survival.questmaster.data;

import org.bukkit.Material;

import java.util.UUID;

/**
 * This class represents a single quest managed by the OGQuestMaster plugin
 */
public class OGQuest {
    //Unique ID given for each quest created
    private UUID questId;
    //Material to deliver to fulfill the quest
    private String questMaterial;
    //Amount of the above material to fulfill the quest
    private int questAmount;
    //Material of the reward received when completing the quest
    private String rewardMaterial;
    //Amount of the reward material
    private int rewardAmount;

    //Constructor, when all parameters are given
    public OGQuest(UUID questId, String questMaterial, int questAmount, String rewardMaterial, int rewardAmount) {
        this.questId = questId;
        this.questMaterial = questMaterial;
        this.questAmount = questAmount;
        this.rewardMaterial = rewardMaterial;
        this.rewardAmount = rewardAmount;
    }

    //Constructor that creates a random uuid if none is given
    public OGQuest(String questMaterial, int questAmount, String rewardMaterial, int rewardAmount) {
        this(UUID.randomUUID(), questMaterial, questAmount, rewardMaterial, rewardAmount);
    }

    /**
     * Function returns the unique ID of this quest
     *
     * @return - uuid of the quest
     */
    public UUID getQuestId() {
        return questId;
    }

    /**
     * Function returns the material name to gather for this quest
     *
     * @return - String that represents the material
     */
    public String getQuestMaterial() {
        return questMaterial;
    }

    /**
     * Function is used to set the name of the material that should be gathered in this quest
     *
     * @param questMaterial - String that represents the material, has to be an existing material
     */
    public void setQuestMaterial(String questMaterial) {
        this.questMaterial = questMaterial;
    }

    /**
     * Returns the amount of material to gather for this quest to fulfill
     *
     * @return - integer representing the amount
     */
    public int getQuestAmount() {
        return questAmount;
    }

    /**
     * Function is used to set the amount of material that needs to be gathered to complete the quest
     *
     * @param questAmount - Integer representing the amount
     */
    public void setQuestAmount(int questAmount) {
        this.questAmount = questAmount;
    }

    /**
     * Function is used to get the material of the reward
     *
     * @return - String representing the material of the reward
     */
    public String getRewardMaterial() {
        return rewardMaterial;
    }

    /**
     * Function is used to set the name of the material that is rewarded when completing this quest
     *
     * @param rewardMaterial - String representing the material of the reward
     */
    public void setRewardMaterial(String rewardMaterial) {
        this.rewardMaterial = rewardMaterial;
    }

    /**
     * Function is used to get the amount of reward material received when completing this quest
     *
     * @return - Integer representing the amount
     */
    public int getRewardAmount() {
        return rewardAmount;
    }

    /**
     * Function is used to set the amount of reward material received when completing this quest
     *
     * @param rewardAmount - Integer representing the amount
     */
    public void setRewardAmount(int rewardAmount) {
        this.rewardAmount = rewardAmount;
    }
}
