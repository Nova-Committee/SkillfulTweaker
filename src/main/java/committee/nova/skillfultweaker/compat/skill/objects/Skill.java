package committee.nova.skillfultweaker.compat.skill.objects;

import committee.nova.skillful.impl.skill.instance.SkillInstance;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("skillful.skill.Skill")
public class Skill {
    private final SkillInstance instance;

    public Skill(SkillInstance instance) {
        this.instance = instance;
    }

    @ZenGetter("skillType")
    public SkillType getSkillType() {
        return new SkillType(instance.getSkill());
    }

    @ZenGetter("xp")
    public int getXP() {
        return instance.getCurrentXp();
    }

    @ZenGetter("level")
    public int getLevel() {
        return instance.getCurrentLevel();
    }

    @ZenMethod
    public boolean isAcquired() {
        return instance.isAcquired();
    }

    @ZenMethod
    public boolean isClueless() {
        return instance.isClueless();
    }

    @ZenMethod
    public boolean isCompleted() {
        return instance.isCompleted();
    }

    @ZenMethod
    public void changeXp(IPlayer player, int change) {
        if (CraftTweakerMC.getPlayer(player) instanceof EntityPlayerMP)
            instance.addXp((EntityPlayerMP) CraftTweakerMC.getPlayer(player), change);
    }

    @ZenMethod
    public void clear(IPlayer player) {
        if (CraftTweakerMC.getPlayer(player) instanceof EntityPlayerMP)
            instance.clear((EntityPlayerMP) CraftTweakerMC.getPlayer(player));
    }

    @ZenMethod
    public void cheat(IPlayer player) {
        if (CraftTweakerMC.getPlayer(player) instanceof EntityPlayerMP)
            instance.cheat((EntityPlayerMP) CraftTweakerMC.getPlayer(player));
    }

    public SkillInstance getInstance() {
        return instance;
    }
}
